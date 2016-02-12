package br.edu.ifpb.si.pweb.model;

import java.util.ArrayList;

public class Admin extends Pessoa {

	private ArrayList<CalendarHolidayAdapter> listHoliday;
	
	public Admin(){
		super();
		this.listHoliday = new ArrayList<CalendarHolidayAdapter>();
	}
	
	public ArrayList<CalendarHolidayAdapter> getAllListHoliday(){
		return this.listHoliday;
	}
	
	public CalendarHolidayAdapter getHoliday(int id, String type){
		for(CalendarHolidayAdapter holiday : listHoliday){
			
			
			if(holiday.getId() == id && type.equals("")){
				
			}
		}
		return null;
	}
	
}
