package br.edu.ifpb.si.pweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.ifpb.si.pweb.interfaces.CalendarInterface;

@Entity
public class CalendarHoliday implements CalendarInterface {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String startDate;
	private String endDate;
	private String color;
	private int type;
	@ManyToOne
	private Admin admin;
	
	public CalendarHoliday(){}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getTitle() {
		return text;
	}
	@Override
	public void setTitle(String title) {
		this.text = title;
	}
	@Override
	public String getStart() {
		return startDate;
	}
	@Override
	public void setStart(String start) {
		this.startDate = start;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public void setType(int type) {
		this.type = type;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEnd() {
		return endDate;
	}

	public void setEnd(String end) {
		this.endDate = end;
	}

}
