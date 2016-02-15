package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.dao.PessoaDAO;
import br.edu.ifpb.si.pweb.model.Pessoa;
import br.edu.ifpb.si.pweb.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		String name = null;
		String pass = null;
		if(!request.getParameter("name").isEmpty() && !request.getParameter("password").isEmpty()){
			name = request.getParameter("name").toString();
			pass = request.getParameter("password").toString();
		}else{
			msg = "Preencha todos os campos!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		DAO.open();
			PessoaDAO pDAO = new PessoaDAO();
			Pessoa p = pDAO.readUser(name, pass);
			
			if(p == null){
				msg = "Usuário inexistente!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			if(p instanceof Usuario && !((Usuario)p).isStatus()){
				msg = "Aguarde a aprovação do ADM!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("logado", p);
		DAO.close();
		
		if(p != null)
			response.sendRedirect("index.jsp");
		
	}

}
