package Utulities;

import java.util.Date;

public class Util {
	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "elhadjenhafi" + timeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 100;
	public static final int PAGELOAD_TIME = 100;
	public static final int SCRIPT_TIME = 1000;

}
