package br.edu.ifpb.si.pweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.ifpb.si.pweb.interfaces.CalendarInterface;

@Entity
public class CalendarComment implements CalendarInterface{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String date;
	private String color;
	private int type;
	@ManyToOne
	private Usuario usuario;
	
	public CalendarComment(){}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario u) {
		this.usuario = u;
	}
	
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
		return text;
	}
	@Override
	public void setTitle(String title) {
		this.text = title;
	}
	@Override
	public String getStart() {
		return date;
	}
	@Override
	public void setStart(String start) {
		this.date = start;
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
