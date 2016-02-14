package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.CalendarHolidayDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.CalendarHoliday;
import br.edu.ifpb.si.pweb.util.CalendarType;
import br.edu.ifpb.si.pweb.util.Color;


@WebServlet("/addFixedHoliday.do")
public class AddFixedHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();

		String fixedDate = request.getParameter("date").toString();
		String desc = request.getParameter("desc").toString();
		CalendarHoliday cf = new CalendarHoliday();
		cf.setTitle(desc);
		cf.setStart(fixedDate);
		cf.setColor(Color.RED);
		cf.setType(CalendarType.CALENDAR_FIXED);

		CalendarHolidayDAO chDAO = new CalendarHolidayDAO();
		DAO.begin();
		chDAO.create(cf);
		DAO.commit();
		
		DAO.close();
		response.sendRedirect("/calendar/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private String date(String date){
		String day = date.substring(8, 10);
		String month = date.substring(5, 7);
		String year = date.substring(0, 4);
		String newFormat = year+"-"+month+"-"+day;
		return newFormat;
	}

}
