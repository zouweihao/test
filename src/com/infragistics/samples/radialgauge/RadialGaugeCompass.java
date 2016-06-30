package com.infragistics.samples.radialgauge;

import java.util.Timer;
import java.util.TimerTask;

import com.infragistics.controls.*;
import com.infragistics.extensions.Brushes;
import com.infragistics.extensions.Colors;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.widget.FrameLayout;

public class RadialGaugeCompass extends SampleLayout
{
	private RadialGaugeView compassSouthGauge;
	private RadialGaugeView compassNorthGauge;
	
	private double compassValue = 0.0;  	// compass north value
	private double compassInverse = 180.0;  // compass south value
	
	private boolean isSimulatingCompass = true;
	private boolean isActiveCompass = false;
	
	private Timer compassTimer = new Timer();
	
	private void CreateGaugeWithSouthNeedle(Context context){
		
		compassSouthGauge = new RadialGaugeView(context);
		
		compassSouthGauge.setMinimumValue(0);
		compassSouthGauge.setMaximumValue(360);
		compassSouthGauge.setValue(compassInverse);
		compassSouthGauge.setInterval(45);
		compassSouthGauge.setTransitionDuration(1100);
		
		compassSouthGauge.setNeedlePivotShape(RadialGaugePivotShape.NONE);
		compassSouthGauge.setNeedleShape(RadialGaugeNeedleShape.TRIANGLE);
		compassSouthGauge.setNeedleEndExtent(0.6);
		compassSouthGauge.setNeedleStartWidthRatio(0.07);
		compassSouthGauge.setNeedleEndWidthRatio(0.05);
	
		compassSouthGauge.setScaleStartAngle(270);
		compassSouthGauge.setScaleEndAngle(270 + 360);
		compassSouthGauge.setScaleStartExtent(0.44);
		compassSouthGauge.setScaleEndExtent(0.52);
		
		// use compass directions
		compassSouthGauge.setOnFormatLabelListener(new OnRadialCompassDirectionListener());
		compassSouthGauge.setLabelExtent(0.7); 
		
		// hidden
		compassSouthGauge.setTickStartExtent(0.6);
		compassSouthGauge.setTickEndExtent(0.6);
		compassSouthGauge.setMinorTickStartExtent(0.6);
		compassSouthGauge.setMinorTickEndExtent(0.6);
		compassSouthGauge.setScaleBrush(Brushes.Transparent);
		
	}
	private void CreateGaugeWithNorthNeedle(Context context){

		compassNorthGauge = new RadialGaugeView (context);
		compassNorthGauge.setMinimumValue(0);
		compassNorthGauge.setMaximumValue(360);
		compassNorthGauge.setValue(compassValue);
		compassNorthGauge.setInterval(15);
		compassNorthGauge.setTransitionDuration(1100);
		
		compassNorthGauge.setNeedlePivotShape(RadialGaugePivotShape.NONE);
		compassNorthGauge.setNeedleShape(RadialGaugeNeedleShape.TRIANGLE);
		compassNorthGauge.setNeedleEndExtent(0.6);
		compassNorthGauge.setNeedleStartWidthRatio(0.07);
		compassNorthGauge.setNeedleEndWidthRatio(0.05);
		compassNorthGauge.setNeedleBrush(Brushes.RedLight);
		compassNorthGauge.setNeedleOutline(Brushes.RedLight);
		
		compassNorthGauge.setScaleStartAngle(270);
		compassNorthGauge.setScaleEndAngle(270 + 360);
		compassNorthGauge.setScaleStartExtent(0.44);
		compassNorthGauge.setScaleEndExtent(0.52);
		
		// use compass angles
		compassNorthGauge.setOnFormatLabelListener(new OnRadialCompassNumberListener());
		compassNorthGauge.setLabelExtent(0.5);
		compassNorthGauge.setLabelTextSize(TypedValue.COMPLEX_UNIT_SP, 9);
				
		compassNorthGauge.setTickStartExtent(0.58);
		compassNorthGauge.setTickEndExtent(0.63);
		compassNorthGauge.setTickStrokeThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
		
		compassNorthGauge.setMinorTickStartExtent(0.6);
		compassNorthGauge.setMinorTickEndExtent(0.63);
		compassNorthGauge.setMinorTickCount(4);
					
		// hidden
		compassNorthGauge.setBackgroundColor(Colors.Transparent);
		compassNorthGauge.setBackingBrush(Brushes.Transparent);
		compassNorthGauge.setBackingOutline(Brushes.Transparent);
		compassNorthGauge.setScaleBrush(Brushes.Transparent);
	}
	
	public void cleanup() {
		
		super.cleanup();
		
		this.compassTimer.cancel();
		this.compassTimer.purge();
		 
	}
	public RadialGaugeCompass(Activity context) {
		super(context);
		 
		CreateGaugeWithSouthNeedle(context);
		CreateGaugeWithNorthNeedle(context);
		 
		this.compassSouthGauge.setLayoutParams(sampleLayoutParams);
		this.compassNorthGauge.setLayoutParams(sampleLayoutParams);
		
		// set duration for initial animation of gauges
		this.compassSouthGauge.setTransitionDuration(1000);
		this.compassNorthGauge.setTransitionDuration(1000);
	 
		this.addView(compassSouthGauge);
		this.addView(compassNorthGauge);
	
		isSimulatingCompass = true;
		
		this.compassTimer = new Timer();
		this.compassTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (isSimulatingCompass && isActiveCompass){
				
					double value = Math.random();
					if (value < 0.6)
						compassValue -= (float)(value * 30);
					else
						compassValue += (float)(value * 30);
					
					compassInverse = 180 + compassValue;
		    		
					UpdateCompassGauge();
				}
				}
			}, 1500, 1300 );
		
		isActiveCompass = true;
	}
	
	protected void UpdateCompassGauge() 
	{
		context.runOnUiThread(new Runnable() 
	     {
	    	
			public void run() 
	    	 {
	 			System.out.println("Updating Compass: " + Id);

				 if (isActiveCompass){

		    		 compassSouthGauge.setValue(compassInverse);
		    		 compassNorthGauge.setValue(compassValue); 
				 }
			 }
	     });
	}

	@Override
	protected String getDescription() {
		return "This sample shows how to use the Radial Gauge as a compass.";
	}
	  
	public class OnRadialCompassDirectionListener implements OnRadialGaugeFormatLabelListener {
		
		@Override
		public void onFormatLabel(RadialGaugeView radialGauge, RadialGaugeFormatLabelEvent event) {

			double value =  event.getValue();
			String label = String.format("%1$,.0f", value);
			
			if (value == 0.0 || value == 360.0 )
			{
				label = "N";
			}
			else if (value == 90.0)
				label = "E ";
			else if (value == 180.0)
				label = "S";
			else if (value == 270.0)
				label = " W";
			else if (value == 45.0)
				label = "NE";
			else if (value == 135.0)
				label = "SE";
			else if (value == 225.0)
				label = "SW";
			else if (value == 315.0)
				label = "NW";
			else
				label = "";
			
			event.setLabel(label);
		}
	}

	
	public class OnRadialCompassNumberListener implements OnRadialGaugeFormatLabelListener {
		
		@Override
		public void onFormatLabel(RadialGaugeView radialGauge, RadialGaugeFormatLabelEvent event) {
			double value =  event.getValue();
			String label = String.format("%1$,.0f", value);
			
			if (value == 0.0 || value == 360.0 )
			{
				label = "360";
			}
			
			event.setLabel(label);
		}
	}

}
