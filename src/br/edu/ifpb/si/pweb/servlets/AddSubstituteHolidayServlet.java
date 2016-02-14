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


@WebServlet("/addSubstituteHoliday.do")
public class AddSubstituteHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();

		String initDate = request.getParameter("date").toString();
		String subDate = request.getParameter("subDate").toString();
		String descMov = request.getParameter("desc").toString();
		CalendarHoliday cs = new CalendarHoliday();
		cs.setTitle(descMov);
		cs.setStart(initDate);
		cs.setSubstituteDate(subDate);
		cs.setColor(Color.GREEN);
		cs.setType(CalendarType.CALENDAR_SUBSTITUTE);

		CalendarHolidayDAO chDAO = new CalendarHolidayDAO();
		DAO.begin();
		chDAO.create(cs);
		DAO.commit();
		
		DAO.close();
		response.sendRedirect("/calendar/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
