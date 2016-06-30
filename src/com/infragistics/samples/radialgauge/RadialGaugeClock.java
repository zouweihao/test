package com.infragistics.samples.radialgauge;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import com.infragistics.controls.*;
import com.infragistics.extensions.Brushes;
import com.infragistics.extensions.Colors;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.FrameLayout;

public class RadialGaugeClock extends SampleLayout {

	private RadialGaugeView clockHourGauge = null;
	private RadialGaugeView clockMinutesGauge = null;
	private RadialGaugeView clockSecondsGauge = null;

	private double clockHour = 0;
	private double clockMinutes = 0;
	private double clockSeconds = 0;
	private boolean clockTransitionEnabled = true;
	private Timer clockTimer = new Timer();
	
	
	public RadialGaugeClock(Activity activity) {
		super(activity);
		 
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();  
		calendar.setTime(date);    
		clockHour = calendar.get(Calendar.HOUR);  // 12h format
		clockMinutes = calendar.get(Calendar.MINUTE);  
		clockSeconds = calendar.get(Calendar.SECOND);
	
		int secColor = Color.parseColor("#cc0000");
		SolidColorBrush secBrush = new SolidColorBrush();
		secBrush.setColor(secColor);
	
		int minutesColor = Color.parseColor("#666666");
		SolidColorBrush minutesBrush = new SolidColorBrush();
		minutesBrush.setColor(minutesColor);
	
		clockHourGauge = new RadialGaugeView (context);
		clockHourGauge.setMinimumValue(0);
		clockHourGauge.setMaximumValue(12);
		clockHourGauge.setValue(clockHour);
		clockHourGauge.setInterval(1);
		clockHourGauge.setTransitionDuration(0);

		clockHourGauge.setNeedlePivotShape(RadialGaugePivotShape.NONE);
		clockHourGauge.setNeedleShape(RadialGaugeNeedleShape.TRIANGLE);
		clockHourGauge.setNeedleStartExtent(-0.15);

		SolidColorBrush brushH = new SolidColorBrush();
		brushH.setColor(Color.parseColor("#1e90ff"));
		clockHourGauge.setNeedleBrush(brushH);
		clockHourGauge.setNeedleOutline(brushH);
		clockHourGauge.setNeedleStartWidthRatio(0.07);
		clockHourGauge.setNeedleEndWidthRatio(0.04);
		
		clockHourGauge.setLabelExtent(0.55);
		clockHourGauge.setLabelTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
		clockHourGauge.setFontBrush(brushH);
		
		clockHourGauge.setScaleStartAngle(270);
		clockHourGauge.setScaleEndAngle(270 + 360);
		
		clockHourGauge.setScaleStartExtent(0.52);
		clockHourGauge.setScaleEndExtent(0.52);
				
		clockHourGauge.setTickStartExtent(0.52);
		clockHourGauge.setTickEndExtent(0.52);
		
		clockHourGauge.setMinorTickStartExtent(0.52);
		clockHourGauge.setMinorTickEndExtent(0.52);
		
		clockHourGauge.setOnFormatLabelListener(new OnRadialClockHoursLabelListener());
						
		clockMinutesGauge = new RadialGaugeView (context);
		clockMinutesGauge.setMinimumValue(0);
		clockMinutesGauge.setMaximumValue(60);
		clockMinutesGauge.setValue(clockMinutes);
		clockMinutesGauge.setInterval(5);
		clockMinutesGauge.setTransitionDuration(0);

		clockMinutesGauge.setNeedlePivotShape(RadialGaugePivotShape.NONE);
		clockMinutesGauge.setNeedleShape(RadialGaugeNeedleShape.TRIANGLE);
		clockMinutesGauge.setNeedleStartExtent(-0.15);
		clockMinutesGauge.setNeedleEndExtent(0.64);
		clockMinutesGauge.setNeedleBrush(minutesBrush);
		clockMinutesGauge.setNeedleOutline(minutesBrush);
		clockMinutesGauge.setNeedleStartWidthRatio(0.04);
		clockMinutesGauge.setNeedleEndWidthRatio(0.04);
		
		clockMinutesGauge.setScaleStartAngle(270);
		clockMinutesGauge.setScaleEndAngle(270 + 360);
		clockMinutesGauge.setScaleStartExtent(0.44);
		clockMinutesGauge.setScaleEndExtent(0.52);
		
		clockMinutesGauge.setLabelExtent(0.72);
		clockMinutesGauge.setLabelTextSize(TypedValue.COMPLEX_UNIT_SP, 9);
		clockMinutesGauge.setOnFormatLabelListener(new OnRadialClockMinutesLabelListener());
		
		// hidden
		clockMinutesGauge.setTickStartExtent(0.61);
		clockMinutesGauge.setTickEndExtent(0.61);
		clockMinutesGauge.setMinorTickStartExtent(0.64);
		clockMinutesGauge.setMinorTickEndExtent(0.64);
				
		clockMinutesGauge.setBackgroundColor(Colors.Transparent);
		clockMinutesGauge.setBackingBrush(Brushes.Transparent);
		clockMinutesGauge.setBackingOutline(Brushes.Transparent);
		clockMinutesGauge.setScaleBrush(Brushes.Transparent);
		 
		clockSecondsGauge = new RadialGaugeView (context);
		clockSecondsGauge.setMinimumValue(0);
		clockSecondsGauge.setMaximumValue(60);
		clockSecondsGauge.setValue(clockSeconds);
		clockSecondsGauge.setInterval(5);
		clockSecondsGauge.setTransitionDuration(0);

		clockSecondsGauge.setNeedlePivotShape(RadialGaugePivotShape.NONE);
		clockSecondsGauge.setNeedleShape(RadialGaugeNeedleShape.TRIANGLE);
		clockSecondsGauge.setNeedleStartExtent(-0.15);
		clockSecondsGauge.setNeedleEndExtent(0.68);
		clockSecondsGauge.setNeedleBrush(secBrush);
		clockSecondsGauge.setNeedleOutline(secBrush);
		clockSecondsGauge.setNeedleStartWidthRatio(0.02);
		clockSecondsGauge.setNeedleEndWidthRatio(0.02);
		
		clockSecondsGauge.setScaleStartAngle(270);
		clockSecondsGauge.setScaleEndAngle(270 + 360);
		clockSecondsGauge.setScaleStartExtent(0.44);
		clockSecondsGauge.setScaleEndExtent(0.52);
		
		clockSecondsGauge.setLabelExtent(0.72);
		clockSecondsGauge.setLabelTextSize(TypedValue.COMPLEX_UNIT_SP, 9);
		
		clockSecondsGauge.setTickStartExtent(0.62);
		clockSecondsGauge.setTickEndExtent(0.66);
		
		clockSecondsGauge.setMinorTickStartExtent(0.64);
		clockSecondsGauge.setMinorTickEndExtent(0.66);
		clockSecondsGauge.setMinorTickCount(4);
		
		clockSecondsGauge.setOnFormatLabelListener(new OnRadialClockSecondsLabelListener());
				 
		clockSecondsGauge.setBackgroundColor(Colors.Transparent);
		clockSecondsGauge.setBackingBrush(Brushes.Transparent);
		clockSecondsGauge.setBackingOutline(Brushes.Transparent);
		clockSecondsGauge.setScaleBrush(Brushes.Transparent);
	 		
		FrameLayout frame = new FrameLayout(context);
		frame.setBackgroundColor(Color.WHITE);
	
		clockHourGauge.setLayoutParams(sampleLayoutParams);
		clockMinutesGauge.setLayoutParams(sampleLayoutParams);
		clockSecondsGauge.setLayoutParams(sampleLayoutParams);
		 
		this.addView(clockHourGauge);
		this.addView(clockMinutesGauge);
		this.addView(clockSecondsGauge);
		 
		clockTimer = new Timer();
		clockTimer.scheduleAtFixedRate( new TimerTask() {

			@Override
			public void run() {
				double value = Math.random();
				
				if (clockSeconds >= 60)
				{
					clockSeconds = 0;
					clockMinutes++;
				}
				
				if (clockMinutes >= 60)
				{
					clockMinutes = 0;
					clockHour++;
				}
				
				if (clockHour > 12)
				{
					clockHour = 1;
				}
				
				UpdateclockHourGaugeValue();  
				clockTransitionEnabled = true;			
				clockSeconds +=1;
				
			}
		}, 100, 1000 );
	
	}

	protected void UpdateclockHourGaugeValue() 
	{
		context.runOnUiThread(new Runnable() 
	    {
	    	 public void run() 
	    	 {
	    		 clockHourGauge.setValue(clockHour);
	    	     clockMinutesGauge.setValue(clockMinutes);
	     		 clockSecondsGauge.setValue(clockSeconds);
	     	 }
	     });
	}
	
	public void cleanup(){

		super.cleanup();
		
		if (clockTimer != null) 
		{
			clockTimer.cancel();
			clockTimer.purge();
		}
		
		
	}

	@Override
	protected String getDescription() {
		return "This sample shows how to use the Radial Gauge as a clock.";
	}
}
