package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.dao.UsuarioDAO;
import br.edu.ifpb.si.pweb.model.Pessoa;
import br.edu.ifpb.si.pweb.model.Usuario;

@WebServlet("/delAccount.do")
public class AccountDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
			UsuarioDAO uDAO = new UsuarioDAO();
			Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
			DAO.begin();
				uDAO.delete((Usuario)p);
			DAO.commit();
			request.getRequestDispatcher("logout.do").forward(request, response);
		DAO.close();
	}

}
