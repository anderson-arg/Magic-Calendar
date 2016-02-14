package br.edu.ifpb.si.pweb.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.si.pweb.model.CalendarHoliday;

public class CalendarHolidayDAO extends DAO<CalendarHoliday>{
	@Override
	public CalendarHoliday read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select c from CalendarHoliday c where c.id= '" + chave +"'");
			CalendarHoliday c = (CalendarHoliday) q.getSingleResult();
			return c;
		}catch(NoResultException e){
			return null;
		}
	}
}
