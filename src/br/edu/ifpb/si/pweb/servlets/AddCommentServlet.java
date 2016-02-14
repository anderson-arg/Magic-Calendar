package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.CalendarCommentDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.CalendarComment;
import br.edu.ifpb.si.pweb.util.CalendarType;

/**
 * Servlet implementation class ComentarioServlet
 */
@WebServlet("/addComment.do")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// essa class vai adicionar o comentario do usuario do banco e rederecionar-lo para o index.jsp(la o json.do ira popular o calendario)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalendarComment c = new CalendarComment();
		c.setStart(request.getParameter("data").toString());
		c.setTitle(request.getParameter("texto").toString());
		c.setType(CalendarType.CALENDAR_COMMENT);
		
		DAO.open();
		
		DAO.begin();
		CalendarCommentDAO cm = new CalendarCommentDAO();
		cm.create(c);
		DAO.commit();
		
		DAO.close();
		
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
