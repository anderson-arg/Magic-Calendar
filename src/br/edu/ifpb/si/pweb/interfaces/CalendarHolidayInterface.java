package br.edu.ifpb.si.pweb.interfaces;

public interface CalendarHolidayInterface {
	void setFixedHoliday(String fixed);
	void setMovementHoliday(String movement);
	void setSubstituteHoliday(String substitute);
	String getFixedHoliday();
	String getMovementHoliday();
	String getSubstituteHoliday();
}
