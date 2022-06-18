package com.utility;

public class ReusableUtility {
	private static ReusableUtility obj;
	private ReusableUtility() {
		
	}
	public static ReusableUtility getInstance() {
		if(obj==null) {
			obj=new ReusableUtility();			
		}
		return obj;
	}
	public void staticWaitForMillis(int millis) {
		try {
			Thread.sleep(millis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
