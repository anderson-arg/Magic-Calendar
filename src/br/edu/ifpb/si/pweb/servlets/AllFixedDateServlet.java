package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.AdminDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.Admin;
import br.edu.ifpb.si.pweb.model.CalendarHoliday;
import br.edu.ifpb.si.pweb.model.Pessoa;

/**
 * Servlet implementation class FixedDateAllServlet
 */
@WebServlet("/allFixedDate.do")
public class AllFixedDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String calendarYear = request.getParameter("date").toString();
		calendarYear = calendarYear.substring(1, 5);			
		
		// pegar do banco datas fixas pq so funciona para o admin
		DAO.open();
			AdminDAO aDAO = new AdminDAO();
			Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
			List<CalendarHoliday> listFixedHoliday = ((Admin)p).getListFixedHoliday();
			List<CalendarHoliday> auxList = new ArrayList<CalendarHoliday>();
			String fixedYear = listFixedHoliday.get(0).getStart();
			if(listFixedHoliday.size() > 0){
				if(!fixedYear.equals(calendarYear)){
					for(CalendarHoliday ch : listFixedHoliday){
						String date = date(ch.getStart(), calendarYear);
						ch.setStart(date);
						auxList.add(ch);
					}
					DAO.open();
					DAO.begin();	
						((Admin)p).setListFixedHoliday(auxList);
						aDAO.update((Admin)p);
					DAO.commit();
					DAO.close();
					request.getSession(false).setAttribute("logado", p);
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
