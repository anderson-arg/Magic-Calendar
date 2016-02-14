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
		String[] date = request.getParameterValues("date[]");
		for(String s : date){			
			System.out.println(s);
		}
	}

}
