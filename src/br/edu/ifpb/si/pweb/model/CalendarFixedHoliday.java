package br.edu.ifpb.si.pweb.model;

import javax.persistence.Entity;


public class CalendarFixedHoliday extends CalendarHolidayAdapter {
	private String start;
	
	public CalendarFixedHoliday(){
		super();
	}
	
	@Override
	public void setFixedHoliday(String fixed) {
		this.start = fixed;
	}
	
	@Override
	public String getFixedHoliday() {
		return this.start;
	}
}
