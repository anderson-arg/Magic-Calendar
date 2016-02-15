package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.CalendarHolidayDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.Admin;
import br.edu.ifpb.si.pweb.model.CalendarHoliday;
import br.edu.ifpb.si.pweb.model.Pessoa;
import br.edu.ifpb.si.pweb.util.CalendarType;
import br.edu.ifpb.si.pweb.util.Color;

/**
 * Servlet implementation class FixedDateAllServlet
 */
@WebServlet("/allFixedDate.do")
public class AllFixedDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String calendarYear = request.getParameter("date").toString();
		calendarYear = calendarYear.substring(1, 5);			
		
		DAO.open();
			CalendarHolidayDAO chDAO = new CalendarHolidayDAO();
			List<CalendarHoliday> listFixedHoliday = chDAO.readAll();
			List<CalendarHoliday> auxList = new ArrayList<CalendarHoliday>();
			String fixedYear = listFixedHoliday.get(0).getStart();
			if(listFixedHoliday.size() > 0){
				if(!fixedYear.contains(calendarYear)){
					for(CalendarHoliday ch : listFixedHoliday){
						if(ch.getType() == CalendarType.CALENDAR_FIXED){
							if(ch.getSubstituteDate() != null && ch.getSubstituteDate().contains(calendarYear)){
								ch.setType(CalendarType.CALENDAR_SUBSTITUTE);
								ch.setColor(Color.BLUE);
								auxList.add(ch);
							}else{
								String date = date(ch.getStart(), calendarYear);
								ch.setStart(date);
								ch.setColor(Color.RED);
								auxList.add(ch);
							}
						}
						
						if(ch.getType() == CalendarType.CALENDAR_SUBSTITUTE){
							if(ch.getSubstituteDate().contains(calendarYear)){
								ch.setType(CalendarType.CALENDAR_SUBSTITUTE);
								ch.setColor(Color.BLUE);
								auxList.add(ch);
							}else{
								String date = date(ch.getStart(), calendarYear);
								ch.setStart(date);
								ch.setType(CalendarType.CALENDAR_FIXED);
								ch.setColor(Color.RED);
								auxList.add(ch);
							}
							
						}
					}
					DAO.open();
					DAO.begin();	
						for(CalendarHoliday ch : auxList){
							chDAO.update(ch);
						}
					DAO.commit();
					DAO.close();
					
				}
			}
		DAO.close();
		
	}
	
	private String date(String date, String calendarYear){
		String day = date.substring(8, 10);
		String month = date.substring(5, 7);
		String year = date.substring(0, 4);
		String newFormat = calendarYear+"-"+month+"-"+day;
		return newFormat;
	}

}
