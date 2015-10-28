package com.shc.learning;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 6);
		System.out.println("calendar " + calendar.getTime());
		
		Date expirationDate = calendar.getTime();
		System.out.println("expiration "+expirationDate);

		String parsedDate = "08/19/2013";
		System.out.println("parsedDate :"+parsedDate);
		Calendar now = new GregorianCalendar(TimeZone.getTimeZone("America/Chicago"), Locale.US);						
		now.setTime(new Date(parsedDate));
		now.add(Calendar.DATE,90);

		Date leastPurhaseExpirationDate = now.getTime();
		System.out.println("least "+leastPurhaseExpirationDate);
		
		long difference = getDateDifferenceInDays(expirationDate, leastPurhaseExpirationDate);
		System.out.println(difference);

	}
	
	public static long getDateDifferenceInDays(java.util.Date date1, java.util.Date date2){
		//return( date1.compareTo(date2));
		long diffInDays = 0;
		Calendar firstDate =null;
	    Calendar secondDate =null;
	      
	    // Create two calendars instances
	    firstDate = new GregorianCalendar(TimeZone.getTimeZone("America/Chicago"), Locale.US);
	    secondDate = new GregorianCalendar(TimeZone.getTimeZone("America/Chicago"), Locale.US);
	     
	    //Set the dates
	    firstDate.setTime(date1);
	    secondDate.setTime(date2);                  
	
	     // Get difference between two dates in days
	    diffInDays = (firstDate.getTimeInMillis() - secondDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);

	    Calendar date = (Calendar) secondDate.clone();  
	    long daysBetween = 0;  
	    while (date.before(firstDate)) {  
	      date.add(Calendar.DAY_OF_MONTH, 1);  
	      daysBetween++;  
	    }  
	    return daysBetween;	
	}

}
