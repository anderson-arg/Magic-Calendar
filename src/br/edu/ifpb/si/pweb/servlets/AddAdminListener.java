package br.edu.ifpb.si.pweb.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.ifpb.si.pweb.dao.AdminDAO;
import br.edu.ifpb.si.pweb.dao.DAO;
import br.edu.ifpb.si.pweb.model.Admin;

@WebListener
public class AddAdminListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext sc = event.getServletContext();
    	String name = sc.getInitParameter("name");
    	String pass = sc.getInitParameter("password");
    	DAO.open();
    		AdminDAO aDAO = new AdminDAO();
    		if(aDAO.readAll().size() == 0){
    			Admin a = new Admin();
    			a.setName(name);
    			a.setSenha(pass);
    			DAO.begin();
    				aDAO.create(a);
    			DAO.commit();
    		}
    	DAO.close();
    }
	
}
