import static org.junit.Assert.*;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.convert.Convert;

@SuppressWarnings("deprecation")
public class TestConvert {
	
	private static Date actualDate= new Date(2010, 6, 13, 5, 25, 50);
	//private static LocalDate actuallocalDate = LocalDate.of(2010, 6, 13, 5, 25, 50);
	
	@Test
	public void testToLocalDateFromDate(){
		assertEquals(LocalDate.of(2010, Month.AUGUST, 13), Convert.toLocalDateFromDate(new Date(2010, Month.AUGUST.getValue(), 13)));
	}
	
	@Test
	public void testToDateFromLocalDate(){
		assertEquals(new Date(2014, 7, 22), Convert.toDateFromLocalDate(LocalDate.of(2014, 8,22)));
	}
	
	@Test
	public void testToLocalDateTimeFromDate(){
		assertEquals(LocalDateTime.of(2010, 7, 13, 5, 25, 50), Convert.toLocalDateTimeFromDate(actualDate));
		
		/*
		LocalDateTime expected = LocalDateTime.now();
		LocalDateTime actual = Convert.toLocalDateTimeFromDate(new Date());
		assertEquals(expected.getYear(), actual.getYear());
		assertEquals(expected.getMonthValue(), actual.getMonthValue());
		assertEquals(expected.getDayOfMonth(), actual.getDayOfMonth());
		assertEquals(expected.getHour(), actual.getHour());
		assertEquals(expected.getMinute(), actual.getMinute());
		assertEquals(expected.getSecond(), actual.getSecond());
		*/
		
		
	}
	

	@Test
	public void testDateFromLocalDateTime(){
		assertEquals(new Date(114, 7, 22, 6, 35, 58), Convert.toDateFromLocalDateTime(LocalDateTime.of(2014, 8, 22, 6, 35, 58, 444)));
	}
	
	@Test
	public void testToLocalTimeFromDate(){
		assertEquals(LocalTime.of(5, 25, 50), Convert.toLocalTimeFromDate(actualDate));
	}
	
	@Test
	public void testToMonthDayFromDate(){
		assertEquals(MonthDay.of(Month.JULY.getValue(),13), Convert.toMonthDayFromDate(actualDate));
	}
	
	@Test
	public void testToYearMonthFromDate(){
		assertEquals(YearMonth.of(2010,7), Convert.toYearMonthFromDate(actualDate));
	}
	
	@Test
	public void testToLocalDateFromCalendar() {
		Calendar c = Calendar.getInstance();
		assertEquals(LocalDate.of(2019, 1, 21), Convert.toLocalDateFromCalendar(c));

	}
	
	
	@Test
	public void testToCalendarFromLocalDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2018, 4, 17);

		assertEquals(cal, Convert.toCalendarFromLocalDate(LocalDate.of(2018,4,17)));
	} 
	
	@Test
	public void testToLocalTimeFromCalendar() {
		Calendar c = Calendar.getInstance();
		
		LocalTime expected = LocalTime.now();
		LocalTime actual =  Convert.toLocalTimeFromCalendar(c);
		assertEquals(expected.getHour(), actual.getHour());
		assertEquals(expected.getMinute(), actual.getMinute());
		assertEquals(expected.getSecond(), actual.getSecond());	

	}
	
	/*
	@Test
	public void testCalenderFromLocalDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2016, 8, 5, 7, 20, 45);

		assertEquals(cal, Convert.toCalendarFromLocalDateTime(LocalDateTime.of(2018, 4, 17, 7, 20, 45)));
	}*/
	
	
	@Test
	public void testToLocalDateTimeFromCalender() {
		Calendar c = Calendar.getInstance();
		assertEquals(LocalDate.now(), Convert.toLocalDateFromCalendar(c));

	}
	

}
