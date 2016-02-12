package br.edu.ifpb.si.pweb.model;

import javax.persistence.Entity;


public class CalendarMovementHoliday extends CalendarHolidayAdapter {

	private String start;
	
	public CalendarMovementHoliday() {
		super();
	}
	
	@Override
	public void setMovementHoliday(String movement) {
		this.start = movement;
	}
	
	@Override
	public String getMovementHoliday() {
		return this.start;
	}
	
}
