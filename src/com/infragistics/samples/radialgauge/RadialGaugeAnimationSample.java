package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.view.Gravity;
import android.view.View; 
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RadialGaugeAnimationSample extends SampleLayout  {
	
	static int _gaugeTouchCount;
	
	public RadialGaugeAnimationSample(Activity activity) {
		super(activity);

		RadialGaugeView gauge = new RadialGaugeView(context);
		gauge.setTransitionDuration(1000);
		gauge.setTransitionEasingFunction(new EasingFunction() {
			@Override
			public double ease(double t) {
				return EasingFunctions.cubicEase(t);
			}
		});
		
		_gaugeTouchCount = 0;
		
		gauge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HandleGaugeTouch(v);
			}
			
		});
		gauge.setClickable(true);
		
		 FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(700,70);
		 TextView textview = new TextView(context);	
		 textview.setLayoutParams(params);
		 textview.setText("Tap the Gauge to start animation!");
	 	 textview.setGravity(Gravity.CENTER_VERTICAL);

		 
			this.sampleOptions.addView(textview);
			this.sampleContainer.addView(gauge);	 
	}
	
	private static void HandleGaugeTouch(View v) {
		RadialGaugeView gauge = (RadialGaugeView)v;
		switch (_gaugeTouchCount)
        {
            case 0:
            	gauge.setScaleSweepDirection(SweepDirection.COUNTERCLOCKWISE);
            	gauge.setScaleStartAngle(0);
            	gauge.setScaleStartAngle(180);
            	gauge.setNeedleShape(RadialGaugeNeedleShape.NEEDLE_WITH_BULB);
            	gauge.setNeedlePivotShape(RadialGaugePivotShape.CIRCLE);
                break;
            case 1:
            	gauge.setScaleSweepDirection(SweepDirection.CLOCKWISE);
            	gauge.setScaleStartAngle(90);
            	gauge.setScaleEndAngle(270);
            	gauge.setNeedleShape(RadialGaugeNeedleShape.RECTANGLE);
            	gauge.setNeedlePivotShape(RadialGaugePivotShape.CIRCLE_WITH_HOLE);
                break;
            case 2:
            	gauge.setScaleSweepDirection(SweepDirection.COUNTERCLOCKWISE);
            	gauge.setScaleStartAngle(320);
            	gauge.setScaleEndAngle(20);
            	gauge.setNeedleShape(RadialGaugeNeedleShape.TRIANGLE_WITH_BULB);
            	gauge.setNeedlePivotShape(RadialGaugePivotShape.CIRCLE_UNDERLAY);
                break;
            case 3:
            	gauge.setScaleSweepDirection(SweepDirection.CLOCKWISE);
            	gauge.setScaleStartAngle(135);
            	gauge.setScaleEndAngle(45);
            	gauge.setNeedleShape(RadialGaugeNeedleShape.NEEDLE);
            	gauge.setNeedlePivotShape(RadialGaugePivotShape.CIRCLE_OVERLAY);
                break;
        }
		_gaugeTouchCount++;

        if (_gaugeTouchCount > 3)
        {
        	_gaugeTouchCount = 0;
        }
	}

	@Override
	protected String getDescription() {
		return "Radial Gauge contains a number of visual elements, such as a scale with tick marks and labels, a needle, and a number of ranges. This sample demonstrates animated transitions between different sets of settings.";
	}
}
