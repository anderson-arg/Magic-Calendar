package br.edu.ifpb.si.pweb.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.si.pweb.model.Usuario;

public class UsuarioDAO extends DAO<Usuario>{

	@Override
	public Usuario read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select u from Usuario u where u.id = '"+chave+"' ");
			Usuario u = (Usuario) q.getSingleResult();
			return u;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public Usuario readUser(String name, String pass){
		try{
			Query q = manager.createQuery("select u from Usuario u where u.name = '"+name+"' AND u.password = '"+pass+"' ");
			Usuario u = (Usuario) q.getSingleResult();
			return u;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Usuario> readAllUserInactive(){
		try{
			Query q = manager.createQuery("select u from Usuario u where u.status = 'false' ");
			List<Usuario> list = (List<Usuario>) q.getResultList();
			return list;
		}catch(NoResultException e){
			return null;
		}
	}

}
