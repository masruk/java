package com.convert;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate ld = LocalDate.of(1995, Month.AUGUST, 24);
		
		
		Date d2= new Date(1994, 10, 25);
		
		LocalDate ld1 = Convert.toLocalDateFromDate(d2);
		
		System.out.println(ld1);
		
		Calendar c = Calendar.getInstance();
		
		System.out.println(c);


	}

}
