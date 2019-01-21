package com.naztech;

public enum Month {

	JANUARY("January", 31),
	FEBRUARY("February", 28),
	MARCH("March", 31),
	APRIL("April", 30),
	MAY("May", 31),
	JUNE("June", 30),
	JULY("July", 31),
	AUGUST("August", 31),
	SEPTEMBER("September", 30),
	OCTOBER("October", 31),
	NOVEMBER("November", 30),
	DECEMBER("December", 31);
	
	private String title;
	private int daysInMonth;
	
	private Month(String title, int daysInMonth){
		this.title = title;
		this.daysInMonth = daysInMonth;
	}
	
	public String title() {
		return this.title;
	}
	
	public int getDaysInMonth() {
		return daysInMonth;
	}
	
	public static String getShortName(String s) {
		return s.substring(0,3);
	}
	public static Month parse(String s) {
		if(s==null || s.isEmpty()) {
			return null;
		}
		
		s = s.toUpperCase();
		
		try{
			
			return Month.valueOf(s);
			
		} catch(IllegalArgumentException e) {
			
			for(Month month: Month.values()) {
				if(getShortName(month.title()).toUpperCase().equals(s)) {
					return month;
				}
			}	
		}
		
		return null;
	}	

}
