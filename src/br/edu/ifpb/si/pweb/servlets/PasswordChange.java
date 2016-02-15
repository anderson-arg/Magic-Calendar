package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.AdminDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.Admin;
import br.edu.ifpb.si.pweb.model.Pessoa;

/**
 * Servlet implementation class PasswordChange
 */
@WebServlet("/passChange.do")
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("pass").toString();
		String newPass = request.getParameter("newPass").toString();
		String reNewPass = request.getParameter("reNewPass").toString();
		String msg;
		
		Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
		
		if(pass.isEmpty() || newPass.isEmpty() || reNewPass.isEmpty()){
			msg = "Preencha todos os campos!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(!((Admin)p).getPassword().equals(pass)){
			msg = "Senha atual incorreta!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(!newPass.equals(reNewPass)){
			msg = "Senha nova incorreta. Tente novamente!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			DAO.open();
				AdminDAO aDAO = new AdminDAO();
				p.setSenha(newPass);
				DAO.begin();
					aDAO.update((Admin)p);
				DAO.commit();
			DAO.close();
			request.getSession(false).setAttribute("logado", p);
			msg = "Senha alterada com sucesso!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
