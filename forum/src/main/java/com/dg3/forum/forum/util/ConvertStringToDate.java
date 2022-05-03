package com.dg3.forum.forum.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertStringToDate {
	
	/**
	 * Convert String to Date
	 * @param startDate
	 * @return date
	 */
	static Date convertStringtoDate(String startDate )  {
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dateconvert = null;
		try {
			dateconvert = df.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateconvert;
	}
}
