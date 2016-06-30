package com.infragistics.data;

import java.text.DecimalFormat;

public class DateTime { // extends Date {
	
//	public int day;
//	public int month;
//	public int year;		
	private int hour;
	private int minutes;
	private int seconds;
	
	public DateTime(DateTime dt){
		
//		this.setYear(dt.getYear());
//		this.setMonth(dt.getMonth());
//		this.setDate(dt.getDate());
		
		this.setHour(dt.getHour());
		this.setMinutes(dt.getMinutes());
		this.setSeconds(dt.getSeconds());
				
	}
	public DateTime(){
		//super();
		hour = 0;
		minutes = 0;
		seconds = 0;
	}
	public DateTime(int hour, int minutes, int seconds){
		 
		setHour(hour);
		setMinutes(minutes);
		setSeconds(seconds);
}
	public int getHour(){ return hour; }
	public int getMinutes(){ return minutes; }
	public int getSeconds(){ return seconds; }
	
	public void setHour(int time){
		if (time >= 24)
			hour = (int)(time * (time % 24)); 
		else
			hour = time;
	}
	public void setMinutes(int time){
		if (time >= 60)
		{
			this.setHour((int)(hour + Math.floor(time / 60)));
	 		minutes = (int)(time * (time % 60));
		}
		else
			minutes = time;
	}
	public void setSeconds(int time){
		if (time >= 60)
		{
 			this.setMinutes((int)(minutes + Math.floor(time / 60)));
 			seconds = (int)(time * (time % 60)); 
 		}
		else
			seconds = time;
	}
	
	
	public void AddMinutes(int minutes){
		
		setMinutes(getMinutes() + minutes);
		//super.//.set(Calendar.MINUTE, 1);
	}
	
	public void AddSeconds(int seconds){
		
		setSeconds(getSeconds() + seconds);
		//super.//.set(Calendar.MINUTE, 1);
	}
	
//	public String toDateString(){
//		String time = this.getYear() + "/" + this.getMonth() + "/" + this.getDay();
//		return time;		
//	}

	public String toTimeString(){
		
		DecimalFormat formater = new DecimalFormat("00");
		
		String time = "";//this.getHour() + ":" + this.getMinutes() + ":" + this.getSeconds();
		time += formater.format(this.getHour()) + ":";
		time += formater.format(this.getMinutes()) + ":";
		time += formater.format(this.getSeconds());
		
		return time;		
	}
}
