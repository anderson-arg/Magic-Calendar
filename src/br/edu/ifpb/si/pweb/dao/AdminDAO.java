package br.edu.ifpb.si.pweb.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.si.pweb.model.Admin;

public class AdminDAO extends DAO<Admin>{

	@Override
	public Admin read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select a from Admin a where a.id = '"+chave+"' ");
			Admin a = (Admin) q.getSingleResult();
			return a;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public Admin readUser(String name, String pass){
		try{
			Query q = manager.createQuery("select a from Admin a where a.name = '"+name+"' AND a.password = '"+pass+"' ");
			Admin a = (Admin) q.getSingleResult();
			return a;
		}catch(NoResultException e){
			return null;
		}
	}

}
