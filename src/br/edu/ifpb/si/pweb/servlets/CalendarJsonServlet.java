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

import br.edu.ifpb.si.pweb.dao.CalendarCommentDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.CalendarComment;
import br.edu.ifpb.si.pweb.util.Color;

@WebServlet("/json.do")
public class CalendarJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// essa class vai pegar todos os dados do banco e jogar no calendario
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List l = new ArrayList();
		
		DAO.open();
			CalendarCommentDAO cmDAO = new CalendarCommentDAO();
			l = cmDAO.readAll();
		DAO.close();
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(l));
		
	}

}
