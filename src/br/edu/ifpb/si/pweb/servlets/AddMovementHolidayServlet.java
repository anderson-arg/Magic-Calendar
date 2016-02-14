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


@WebServlet("/addMovementHoliday.do")
public class AddMovementHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
		
		String startDate = request.getParameter("startDate").toString();
		String endDate = request.getParameter("endDate").toString();
		String descMov = request.getParameter("desc").toString();
		CalendarHoliday cm = new CalendarHoliday();
		cm.setTitle(descMov);
		cm.setStart(startDate);
		cm.setEnd(endDate);
		cm.setColor(Color.BLUE);
		cm.setType(CalendarType.CALENDAR_MOVEMENT);

		CalendarHolidayDAO chDAO = new CalendarHolidayDAO();
		DAO.begin();
		chDAO.create(cm);
		DAO.commit();
		
		DAO.close();
		response.sendRedirect("/calendar/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
