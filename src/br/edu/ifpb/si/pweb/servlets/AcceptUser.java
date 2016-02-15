package br.edu.ifpb.si.pweb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.dao.UsuarioDAO;
import br.edu.ifpb.si.pweb.model.Usuario;

@WebServlet("/acceptUser.do")
public class AcceptUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("id[]");
		String msg;
		DAO.open();
			UsuarioDAO uDAO = new UsuarioDAO();
			List<Usuario> listUser = new ArrayList<Usuario>();
			for(String id : ids){
				try {
					Usuario u = uDAO.read(Integer.parseInt(id));
					if(u != null)listUser.add(u);
				} catch (NumberFormatException e) {	
				} catch (Exception e) {	
				}
			}
			
			DAO.begin();
			for (Usuario usuario : listUser) {
				usuario.setStatus(true);
				uDAO.update(usuario);
			}
			DAO.commit();
		DAO.close();
		msg = "Cadastro(s) Aceito(s)!";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
