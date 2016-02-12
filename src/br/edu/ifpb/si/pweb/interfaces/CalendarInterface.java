package br.edu.ifpb.si.pweb.interfaces;

public interface CalendarInterface {
	int getId();
	void setTitle(String title);
	void setStart(String start);
	void setType(int type);
	String getTitle();
	String getStart();
	int getType();
}
