package br.edu.ifpb.si.pweb.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.si.pweb.model.CalendarHoliday;
import br.edu.ifpb.si.pweb.util.CalendarType;

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
	
	public CalendarHoliday readDate(String date){
		try{
			Query q = manager.createQuery("select c from CalendarHoliday c where c.startDate= '" + date +"'");
			CalendarHoliday c = (CalendarHoliday) q.getSingleResult();
			return c;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<CalendarHoliday> readAllFixedDate(){
		try{
			Query q = manager.createQuery("select c from CalendarHoliday c where c.type= '" + CalendarType.CALENDAR_FIXED +"'");
			List<CalendarHoliday> list = (List<CalendarHoliday>) q.getResultList();
			return list;
		}catch(NoResultException e){
			return null;
		}
	}
}
