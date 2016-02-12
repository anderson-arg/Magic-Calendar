package br.edu.ifpb.si.pweb.model;

import br.edu.ifpb.si.pweb.interfaces.CalendarInterface;

public class CalendarConvert implements CalendarInterface{
	private int id;
	private String title;
	private String start;
	private String end;
	private String color;
	private int type;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
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
	
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public void setType(int type) {
		this.type = type;
	}
}
