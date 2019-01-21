package com.convert;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Convert {
	
	public static LocalDate toLocalDateFromDate(Date d) {
		return LocalDate.of(d.getYear(), d.getMonth(), d.getDate());
	}
	
	public static Date toDateFromLocalDate(LocalDate ld)
	{
		return new Date(ld.getYear(), (ld.getMonthValue()-1), ld.getDayOfMonth());
	}
	
	public static LocalDateTime toLocalDateTimeFromDate(Date d)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return LocalDateTime.of(d.getYear(), d.getMonth()+1, d.getDate(), Convert.getHour(d), d.getMinutes(), d.getSeconds());
	} 
	
	public static Date toDateFromLocalDateTime(LocalDateTime ldt)
	{
		return new Date(ldt.getYear()-1900, ldt.getMonthValue()-1, ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond());
	}
	
	public static LocalTime toLocalTimeFromDate(Date d)
	{
		return LocalTime.of(d.getHours(), d.getMinutes(), d.getSeconds());
	}
	
	public static MonthDay toMonthDayFromDate(Date d)
	{
		return MonthDay.of(d.getMonth()+1, d.getDate());
	}
	
	public static YearMonth toYearMonthFromDate(Date d)
	{
		return YearMonth.of(d.getYear(), d.getMonth()+1);
	}
	
	public static LocalDate toLocalDateFromCalendar(Calendar calendar) {
		return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE));
		
	}
	
	public static Calendar toCalendarFromLocalDate(LocalDate localDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
	    calendar.set(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
	    return calendar;
	}
	
	public static LocalTime toLocalTimeFromCalendar(Calendar calendar) {
		return LocalTime.of(Convert.getHour(calendar), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), (calendar.get(Calendar.MILLISECOND)/1000) );
	}
	
	/*
	public static Calendar toCalendarFromLocalTime(LocalTime localTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
	    return calendar;
	}
	*/
	
	public static LocalDateTime toLocalDateTimeFromCalender(Calendar calendar) {
		return LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE), Convert.getHour(calendar), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), (calendar.get(Calendar.MILLISECOND)/1000) );
	}
	
	public static Calendar toCalendarFromLocalDateTime(LocalDateTime localDateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond());
	    return calendar;
	}
	
	private static int getYear(int year) {
		if(year>=1900) return (year-1900);
		else return year;
	}
	
	private static int getHour(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.AM_PM)==Calendar.AM? calendar.get(Calendar.HOUR) : calendar.get(Calendar.HOUR)+12;
	}
	
	private static int getHour(Calendar calendar) {
		return calendar.get(Calendar.AM_PM)==Calendar.AM? calendar.get(Calendar.HOUR) : calendar.get(Calendar.HOUR)+12;
	}
	
	
	

}
