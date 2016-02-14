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
import br.edu.ifpb.si.pweb.util.Color;


@WebServlet("/addSubstituteHoliday.do")
public class AddSubstituteHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();

		String initDate = request.getParameter("date").toString();
		String subDate = request.getParameter("subDate").toString();
		String descMov = request.getParameter("desc").toString();
		CalendarHoliday ch = new CalendarHoliday();
		ch.setTitle(descMov);
		ch.setStart(initDate);
		ch.setSubstituteDate(subDate);
		ch.setColor(Color.GREEN);
		ch.setType(CalendarType.CALENDAR_SUBSTITUTE);

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

}
