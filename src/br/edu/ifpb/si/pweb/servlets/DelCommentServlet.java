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

@WebServlet("/delComment")
public class DelCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag = request.getParameter("submit").toLowerCase();
		
		DAO.open();
		CalendarCommentDAO cmDAO = new CalendarCommentDAO();
		
		DAO.begin();
		
		CalendarComment cm = null;
		try {
			cm = cmDAO.read(request.getParameter("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(tag.equals("update")){
			cm.setTitle(request.getParameter("texto").toString());
			cmDAO.update(cm);
		}else	
			cmDAO.delete(cm);
			
		DAO.commit();
		
		DAO.close();
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
