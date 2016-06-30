package com.infragistics.samples.lineargauge;

import com.infragistics.controls.*;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LinearGaugeAnimationSample extends SampleLayout {

	public LinearGaugeAnimationSample(Activity activity) {
		super(activity);

		LinearGaugeView gauge = new LinearGaugeView (context);
		gauge.setTransitionDuration(1000);
		gauge.setInterval(0.1);
		gauge.setMinimumValue(0.40);
    	gauge.setMaximumValue(0.80);
    	gauge.setValue(0.7);
    	gauge.setMinorTickCount(5);
    	gauge.setLabelExtent(0.05);
		
		int height =
				(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						200, getResources().getDisplayMetrics());
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT, 
				height);
		params.gravity = Gravity.CENTER;
		gauge.setLayoutParams(params);
		
		_count = 0;
		
		gauge.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				HandleLinearGaugeTouch(v);
			}
			
		});
		gauge.setClickable(true);
		 TextView textview = new TextView(context);	
		 FrameLayout.LayoutParams param = new FrameLayout.LayoutParams(
					700,70);
		 textview.setLayoutParams(param);
		 textview.setText("Tap the Gauge to start animation!");
		 
		 LinearLayout layout = new LinearLayout(context);
		 layout.setOrientation(LinearLayout.VERTICAL);
		 layout.addView(textview);
		 layout.addView(gauge);
		 
		 this.addView(layout);
		
	}
	private static int _count = 0;
	
	private static void HandleLinearGaugeTouch(View v) {
		LinearGaugeView gauge = (LinearGaugeView)v;
		switch (_count)
        {
            case 0:
        		gauge.setIsScaleInverted(true);
            	gauge.setInterval(0.1);
        		gauge.setMinimumValue(0.20);
            	gauge.setMaximumValue(0.60);
            	gauge.setValue(0.3);
            	gauge.setMinorTickCount(5);
            	gauge.setNeedleShape(LinearGraphNeedleShape.TRAPEZOID);
            	gauge.setNeedleBreadth(TypedValue.COMPLEX_UNIT_DIP, 10);
                break;
            case 1:
            	gauge.setIsScaleInverted(false);
            	gauge.setInterval(0.2);
        		gauge.setMinimumValue(0.10);
            	gauge.setMaximumValue(1);
            	gauge.setValue(0.5);
            	gauge.setMinorTickCount(5);
            	gauge.setNeedleShape(LinearGraphNeedleShape.RECTANGLE);
            	gauge.setNeedleBreadth(TypedValue.COMPLEX_UNIT_DIP, 5);
                break;
            case 2:
            	gauge.setIsScaleInverted(false);
            	gauge.setInterval(0.1);
        		gauge.setMinimumValue(0.30);
            	gauge.setMaximumValue(0.40);
            	gauge.setValue(0.3);
            	gauge.setMinorTickCount(5);
            	gauge.setNeedleShape(LinearGraphNeedleShape.TRIANGLE);
            	gauge.setNeedleBreadth(TypedValue.COMPLEX_UNIT_DIP, 8);
                break;
            case 3:
            	gauge.setIsScaleInverted(false);
            	gauge.setInterval(0.1);
        		gauge.setMinimumValue(0.40);
            	gauge.setMaximumValue(0.80);
            	gauge.setValue(0.7);
            	gauge.setMinorTickCount(5);
            	gauge.setNeedleShape(LinearGraphNeedleShape.TRAPEZOID);
            	gauge.setNeedleBreadth(TypedValue.COMPLEX_UNIT_DIP, 2);
                break;
        }
        _count++;

        if (_count > 3)
        {
            _count = 0;
        }
	}

	@Override
	protected String getDescription() {
		return "Linear Gauge is useful for showing a single measure on a linear range. This sample demonstrates animated transitions between different sets of settings.";
	}
}
