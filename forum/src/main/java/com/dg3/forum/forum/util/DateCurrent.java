package com.dg3.forum.forum.util;

import java.util.Date;

public class DateCurrent {
	/**
	 * Get date current
	 * @return date current
	 */
public static Date getDateCurrent()  {
	//get date current
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis); 
	return date;
	
}





}



