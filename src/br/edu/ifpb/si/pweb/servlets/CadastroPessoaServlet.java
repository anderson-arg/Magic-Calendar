package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.dao.UsuarioDAO;
import br.edu.ifpb.si.pweb.model.Usuario;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadPessoa.do")
public class CadastroPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").toString();
		String password = request.getParameter("password").toString();
		
		DAO.open();
			UsuarioDAO uDAO = new UsuarioDAO();
			Usuario u = new Usuario(name, password);
			DAO.begin();
				uDAO.create(u);
			DAO.commit();
		DAO.close();
		response.sendRedirect("index.jsp");
	}

}
