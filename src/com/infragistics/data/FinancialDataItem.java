package com.infragistics.data;

//import java.util.Calendar;

public class FinancialDataItem {
	public double lowValue;
	public double highValue;
	public double openValue;
	public double closeValue;
	public double volumeValue;
	public String label;
	public DateTime date;
	public int index;
	
//	public String labelDate(){
//		return date.toDateString();
//	}
//	public String labelTime(){
//		return date.toTimeString();
//	}
	
	public FinancialDataItem(){
		date = new DateTime();
		
//		date.setMinutes(0);
//		date.setSeconds(0);
		
//		now.setMinutes(0);;
//		date = new Date(now.getYear(), )
	}
	public double spendingValue;
	public double budgetValue;
	
	
}
