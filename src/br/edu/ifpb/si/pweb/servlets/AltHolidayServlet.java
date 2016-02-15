package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.AdminDAO;
import br.edu.ifpb.si.pweb.dao.CalendarHolidayDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.Admin;
import br.edu.ifpb.si.pweb.model.CalendarHoliday;
import br.edu.ifpb.si.pweb.model.Pessoa;
import br.edu.ifpb.si.pweb.util.CalendarType;

/**
 * Servlet implementation class AltFixedHoliday
 */
@WebServlet("/altHoliday.do")
public class AltHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag = request.getParameter("submit").toLowerCase();
		
		DAO.open();
		AdminDAO aDAO = new AdminDAO();
		CalendarHolidayDAO chDAO = new CalendarHolidayDAO();
		Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
		CalendarHoliday ch = ((Admin)p).getHoliday(Integer.parseInt(request.getParameter("id").toString()));
		
		DAO.begin();
		
		if(tag.equals("update")){
			ch.setTitle(request.getParameter("texto").toString());
			((Admin)p).setHoliday(ch);
			aDAO.update((Admin)p);
		}else{
			((Admin)p).delHoliday(ch);
			chDAO.delete(ch);
			aDAO.update((Admin)p);
		}
			
		DAO.commit();
		
		DAO.close();
		request.getSession(false).setAttribute("logado", p);
		response.sendRedirect("index.jsp");
	}
}
