package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifpb.si.pweb.dao.CalendarHolidayDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.Admin;
import br.edu.ifpb.si.pweb.model.CalendarComment;
import br.edu.ifpb.si.pweb.model.CalendarConvert;
import br.edu.ifpb.si.pweb.model.CalendarHoliday;
import br.edu.ifpb.si.pweb.model.Pessoa;
import br.edu.ifpb.si.pweb.model.Usuario;
import br.edu.ifpb.si.pweb.util.CalendarType;

@WebServlet("/json.do")
public class CalendarJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// essa class vai pegar todos os dados do banco e jogar no calendario
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Date date = new Date();
		String auxDate = date.toString();
		int pos = auxDate.length();
		auxDate = auxDate.substring(pos-4, pos);*/
		
		List list = new ArrayList();
		
		DAO.open();
			CalendarHolidayDAO chDAO = new CalendarHolidayDAO();
			List<CalendarHoliday> holidays = chDAO.readAll();
			if(holidays.size() > 0){
				for(CalendarHoliday cm : holidays){
					if(cm.getType() == CalendarType.CALENDAR_SUBSTITUTE){
						CalendarConvert cv = new CalendarConvert();
						cv.setId(cm.getId());
						cv.setStart(cm.getSubstituteDate());
						cv.setTitle(cm.getTitle());
						cv.setColor(cm.getColor());
						cv.setType(cm.getType());
						list.add(cv);
					}else{
						CalendarConvert cv = new CalendarConvert();
						cv.setId(cm.getId());
						cv.setStart(cm.getStart());
						cv.setEnd(cm.getEnd());
						cv.setTitle(cm.getTitle());
						cv.setColor(cm.getColor());
						cv.setType(cm.getType());
						list.add(cv);
					}
				}
			}
		
			Pessoa p = (Pessoa) request.getSession(false).getAttribute("logado");
			if(p != null && p instanceof Usuario){
				List<CalendarComment> comments = ((Usuario)p).getAllListComment();
				if(comments.size() > 0){
					for(CalendarComment cm : comments){
						CalendarConvert cv = new CalendarConvert();
						cv.setId(cm.getId());
						cv.setStart(cm.getStart());
						cv.setTitle(cm.getTitle());
						cv.setColor(cm.getColor());
						cv.setType(cm.getType());
						list.add(cv);
					}
				}
			}
		
		DAO.close();
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(list));
		
	}

}
