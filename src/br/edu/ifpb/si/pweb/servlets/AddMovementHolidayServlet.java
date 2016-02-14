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


@WebServlet("/addMovementHoliday.do")
public class AddMovementHolidayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
		
		String startDate = request.getParameter("startDate").toString();
		String endDate = request.getParameter("endDate").toString();
		String descMov = request.getParameter("desc").toString();
		CalendarHoliday ch = new CalendarHoliday();
		ch.setTitle(descMov);
		ch.setStart(startDate);
		ch.setEnd(endDate);
		ch.setColor(Color.BLUE);
		ch.setType(CalendarType.CALENDAR_MOVEMENT);

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
