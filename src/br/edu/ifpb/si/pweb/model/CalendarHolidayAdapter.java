package br.edu.ifpb.si.pweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifpb.si.pweb.interfaces.CalendarCommentInterface;
import br.edu.ifpb.si.pweb.interfaces.CalendarHolidayInterface;


public class CalendarHolidayAdapter implements CalendarCommentInterface, CalendarHolidayInterface {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String start;
	private String color;
	
	@Override
	public void setFixedHoliday(String fixed) {
		
	}

	@Override
	public void setMovementHoliday(String movement) {
		
	}

	@Override
	public void setSubstituteHoliday(String substitute) {
		
	}

	@Override
	public String getFixedHoliday() {
		return null;
	}

	@Override
	public String getMovementHoliday() {
		return null;
	}

	@Override
	public String getSubstituteHoliday() {
		return null;
	}

	@Override
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String getStart() {
		return start;
	}
	@Override
	public void setStart(String start) {
		this.start = start;
	}

}
