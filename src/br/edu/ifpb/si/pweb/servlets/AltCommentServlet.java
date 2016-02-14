package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.dao.UsuarioDAO;
import br.edu.ifpb.si.pweb.model.CalendarComment;
import br.edu.ifpb.si.pweb.model.Pessoa;
import br.edu.ifpb.si.pweb.model.Usuario;
import br.edu.ifpb.si.pweb.util.CalendarType;

@WebServlet("/altComment.do")
public class AltCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag = request.getParameter("submit").toLowerCase();
		
		DAO.open();
		UsuarioDAO uDAO = new UsuarioDAO();
		Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
		
		CalendarComment cm = null;
		cm = ((Usuario)p).getComment(Integer.parseInt(request.getParameter("id").toString()));
		
		DAO.begin();
		
		if(tag.equals("update")){
			cm.setTitle(request.getParameter("texto").toString());
			((Usuario)p).setComment(cm);
			uDAO.update((Usuario)p);
		}else{
			cm.setUsuario(null);
			((Usuario)p).delComment(cm);
			uDAO.update((Usuario)p);
		}
			
		DAO.commit();
		
		DAO.close();
		request.getSession(false).setAttribute("logado", p);
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
