package br.edu.ifpb.si.pweb.interfaces;

public interface CalendarCommentInterface {
	int getId();
	void setTitle(String title);
	void setStart(String start);
	String getTitle();
	String getStart();
}
