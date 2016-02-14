package br.edu.ifpb.si.pweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Admin extends Pessoa {
	@OneToMany(mappedBy="admin", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	private List<CalendarHoliday> listHoliday;
	
	public Admin(){
		super();
		this.listHoliday = new ArrayList<CalendarHoliday>();
	}
	
	public void addHoliday(CalendarHoliday holiday){
		holiday.setAdmin(this);
		this.listHoliday.add(holiday);
	}
	
	public void delHoliday(CalendarHoliday holiday){
		holiday.setAdmin(null);
		this.listHoliday.remove(holiday);
	}
	
	public List<CalendarHoliday> getAllListHoliday(){
		return this.listHoliday;
	}
	
	public CalendarHoliday getHoliday(int id, int type){
		for(CalendarHoliday holiday : listHoliday){
			if(holiday.getId() == id && holiday.getType() == type ){
				return holiday;
			}
		}
		return null;
	}
	
	public CalendarHoliday getHoliday(int id){
		for(CalendarHoliday holiday : listHoliday){
			if(holiday.getId() == id){
				return holiday;
			}
		}
		return null;
	}
	
	public void setHoliday(CalendarHoliday ch){
		int index = 0;
		for(CalendarHoliday holiday : listHoliday){
			if(holiday.getId() == ch.getId()){
				this.listHoliday.set(index, ch);
			}
			index++;
		}
	}
	
}
