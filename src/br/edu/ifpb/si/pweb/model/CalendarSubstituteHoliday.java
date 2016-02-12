package br.edu.ifpb.si.pweb.model;

import javax.persistence.Entity;


public class CalendarSubstituteHoliday extends CalendarHolidayAdapter{
	private String start;
	
	public CalendarSubstituteHoliday(){
		super();
	}
	
	@Override
	public void setSubstituteHoliday(String substitute) {
		this.start = substitute;
	}
	
	@Override
	public String getSubstituteHoliday() {
		return this.start;
	}
}
