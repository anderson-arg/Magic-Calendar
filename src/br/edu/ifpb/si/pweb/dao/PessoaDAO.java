package br.edu.ifpb.si.pweb.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.si.pweb.model.Pessoa;

public class PessoaDAO extends DAO<Pessoa>{

	@Override
	public Pessoa read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select p from Pessoa p where u.id = '"+chave+"' ");
			Pessoa p = (Pessoa) q.getSingleResult();
			return p;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public Pessoa readUser(String name, String pass){
		try{
			Query q = manager.createQuery("select p from Pessoa p where p.name = '"+name+"' AND p.password = '"+pass+"' ");
			Pessoa p = (Pessoa) q.getSingleResult();
			return p;
		}catch(NoResultException e){
			return null;
		}
	}

}
