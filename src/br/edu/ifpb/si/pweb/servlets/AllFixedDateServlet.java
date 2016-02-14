package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FixedDateAllServlet
 */
@WebServlet("/allFixedDate.do")
public class AllFixedDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date").toString();
		date = date.substring(1, 5);			
		
		// dar update em todas as datas fixas para gerar em todos os anos
		
	}
	
	private String date(String date){
		String day = date.substring(8, 10);
		String month = date.substring(5, 7);
		String year = date.substring(0, 4);
		String newFormat = year+"-"+month+"-"+day;
		return newFormat;
	}

}
