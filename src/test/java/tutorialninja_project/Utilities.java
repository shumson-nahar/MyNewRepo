package tutorialninja_project;

import java.util.Date;

public class Utilities {
	public static String generateEmailWithTimeStamp() {
		Date date = new  Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "naharshumson"+ timestamp +"@gmail.com";
				
		
	}
	public static final int implitWaitTime =10;
	public static final int pageLoadTime = 10;
	public static final int scriptTime = 100;

}
