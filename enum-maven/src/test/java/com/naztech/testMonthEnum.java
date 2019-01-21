package com.naztech;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMonthEnum {

	@Test
	public void getShortName1() {
		//Testing getShortName() over words whose lengths are not less than 3
		String[] expected = new String[] {"Jan", "feb", "Mar", "Apr", "May", "JuN", "JUL", "AUG", "Jan", "feb", "Mar", "APR", "MaY",};
		String[] actual = new String[] {"January", "february", "MarCH", "AprIl", "May", "JuNe", "JULy", "AUGust", "Jan", "feb", "Mar", "APR", "MaY"};
		
		for(int i=0; i<actual.length; i++) {
			assertEquals(expected[i], Month.getShortName(actual[i]));
		}
	}
	
	//Testing getShortName() over words whose lengths are less than 3
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void getShortName2() {
		String[] actual=new String[] {"Ja", "Feb", "M", ""};
			
		for(int i = 0; i<actual.length; i++) {
			Month.getShortName(actual[i]);
		}		
	}
	
	
	@Test
	public void parse1() {
		
		String[] expected=new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		String[] actual=new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "JaNuary", "FeBruary", "MarCh", "APRil", "MAY", "JUNE", "july", "august", "SEPtember", "octOBER", "NoVeMbEr", "dEcEmBer", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",  "JAN", "FEb", "MaR", "Apr", "mAY", "jUn", "juL", "aug"};
		
		for(int i = 0; i<actual.length;i++) {
			assertEquals(Month.valueOf(expected[i%12]),Month.parse(actual[i]));
		}
		
	}
	
	@Test
	public void parse2() {
		String[] actual=new String[] {"Jabuary", "Februar", "Marc", "Aril", "Fay", "Juneaer", "Julydf", "Augu", "Septem", "Octob", "Novemb", "Decemb", "JaNua", "FeBrua", "MarC", "APRi", "FAY", "JUNEAD", "julyus", "augu", "SEPtem", "octO", "NoVeMbE", "EcEmBer"};
		for(int i = 0; i<actual.length;i++) {
			assertNull(Month.parse(actual[i]));
		}
	}
	
	
	@Test
	public void getDaysInMonth1() {
		
		int[] expected= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] actual=new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "JaNuary", "FeBruary", "MarCh", "APRil", "MAY", "JUNE", "july", "august", "SEPtember", "octOBER", "NoVeMbEr", "dEcEmBer", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",  "JAN", "FEb", "MaR", "Apr", "mAY", "jUn", "juL", "aug"};
		
		for(int i = 0; i<actual.length;i++) {
			assertEquals(expected[i%12],Month.parse(actual[i]).getDaysInMonth());
		}
		
	}
	
	@Test(expected=NullPointerException.class)
	public void getDaysInMonth2() {
		String[] actual=new String[] {"Jabuary", "Februar", "Marc", "Aril", "Fay", "Juneaer", "Julydf", "Augu", "Septem", "Octob", "Novemb", "Decemb", "JaNua", "FeBrua", "MarC", "APRi", "FAY", "JUNEAD", "julyus", "augu", "SEPtem", "octO", "NoVeMbE", "EcEmBer"};
		for(int i = 0; i<actual.length;i++) {
			assertNull(Month.parse(actual[i]).getDaysInMonth());
		}
	}
	
	@Test
	public void testTitle() {
		
		String[] expected=new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] actual=new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		
		for(int i = 0; i<actual.length;i++) {
			assertEquals(expected[i],Month.valueOf(actual[i]).title());
		}
		
	}
	

}
