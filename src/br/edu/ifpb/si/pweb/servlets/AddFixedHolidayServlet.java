package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;
import java.util.Date;

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
import br.edu.ifpb.si.pweb.util.Color;


@WebServlet("/addFixedHoliday.do")
public class AddFixedHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		String currentYear = date.toString();
		int pos = currentYear.length();
		currentYear = currentYear.substring(pos-4, pos);
		
		DAO.open();

		String fixedDate = date(request.getParameter("date").toString(), currentYear);		
		String desc = request.getParameter("desc").toString();
		CalendarHoliday ch = new CalendarHoliday();
		ch.setTitle(desc);
		ch.setStart(fixedDate);
		ch.setColor(Color.RED);
		ch.setType(CalendarType.CALENDAR_FIXED);

		AdminDAO aDAO = new AdminDAO();
		Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
		DAO.begin();
			((Admin)p).addHoliday(ch);
			aDAO.update((Admin)p);
		DAO.commit();
		
		DAO.close();
		request.getSession(false).setAttribute("logado", p);
		response.sendRedirect("/calendar/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private String date(String date, String currentYear){
		String day = date.substring(8, 10);
		String month = date.substring(5, 7);
		String year = date.substring(0, 4);
		String newFormat = currentYear+"-"+month+"-"+day;
		return newFormat;
	}

}
