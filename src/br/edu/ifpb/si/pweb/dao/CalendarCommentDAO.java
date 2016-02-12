package br.edu.ifpb.si.pweb.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.si.pweb.model.CalendarComment;

public class CalendarCommentDAO extends DAO<CalendarComment> {

	@Override
	public CalendarComment read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select c from CalendarComment c where c.id= '" + chave +"'");
			CalendarComment c = (CalendarComment) q.getSingleResult();
			return c;
		}catch(NoResultException e){
			return null;
		}
	}
	
}
