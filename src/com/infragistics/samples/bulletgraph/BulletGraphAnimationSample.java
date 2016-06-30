package com.infragistics.samples.bulletgraph;

import com.infragistics.controls.*;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View; 
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BulletGraphAnimationSample extends SampleLayout {

	private static int _count = 0;

	public BulletGraphAnimationSample(Activity activity) {
		super(activity);
		
		
		BulletGraphView gauge = new BulletGraphView (context);
        SolidColorBrush fontBrush = new SolidColorBrush(android.graphics.Color.WHITE);
        gauge.setFontBrush(fontBrush);
		gauge.setTransitionDuration(1000);
		gauge.setMinimumValue(0);
		gauge.setMaximumValue(100);
		gauge.setTargetValue(60);
		gauge.setValue(40);
		
	    SolidColorBrush b = new SolidColorBrush() ;
			b.setColor(Color.WHITE) ;
			gauge.setValueBrush(b);
			gauge.setTargetValueBrush(b);
			
			
			LinearGraphRange lgrange1 = new LinearGraphRange();
			lgrange1.setStartValue(0);
			lgrange1.setEndValue(20) ;
			SolidColorBrush brush = new SolidColorBrush() ;
			brush.setColor(Color.LTGRAY);
			lgrange1.setBrush(brush) ;
			
			LinearGraphRange lgrange2 = new LinearGraphRange();
			lgrange2.setStartValue(20);
			lgrange2.setEndValue(60) ;
			SolidColorBrush brush1 = new SolidColorBrush() ;
			brush1.setColor(Color.GRAY);
			lgrange2.setBrush(brush1) ;
			
			LinearGraphRange lgrange3 = new LinearGraphRange();
			lgrange3.setStartValue(60);
			lgrange3.setEndValue(100) ;
			SolidColorBrush brush2 = new SolidColorBrush() ;
			brush2.setColor(Color.DKGRAY);
			lgrange3.setBrush(brush2) ;
			
			gauge.addRange(lgrange1);
			gauge.addRange(lgrange2);
			gauge.addRange(lgrange3);	
			
			
		
		int height =
				(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						150, getResources().getDisplayMetrics());
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT, 
				height);
		params.gravity = Gravity.CENTER;
		gauge.setLayoutParams(params);
		
		_count = 0;
		
		gauge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HandleBulletGraphTouch(v);
			}
			
		});
		gauge.setClickable(true);
		 TextView textview = new TextView(context);	
		 FrameLayout.LayoutParams param = new FrameLayout.LayoutParams(
					700,70);
		 textview.setLayoutParams(param);
		 textview.setText("Tap the Bullet Graph to start animation!");
		 
		LinearLayout layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);
	 	layout.addView(textview);
		layout.addView(gauge);

		this.addView(layout);		
	}
	private static void HandleBulletGraphTouch(View v) {
		BulletGraphView gauge = (BulletGraphView)v;
		switch (_count)
        {
            case 0:
            	gauge.setIsScaleInverted(true);
            	gauge.setMinimumValue(20);
            	gauge.setMaximumValue(40);
            	gauge.setValue(25);
            	gauge.setTargetValue(35);
        		gauge.setMinorTickCount(2);
            	
                break;
            case 1:
            	gauge.setIsScaleInverted(false);
            	gauge.setMinimumValue(10);
            	gauge.setMaximumValue(90);
            	gauge.setValue(50);
            	gauge.setTargetValue(40);
            	gauge.setMinorTickCount(5);
            	
                break;
            case 2:
            	gauge.setIsScaleInverted(false);
            	gauge.setMinimumValue(30);
            	gauge.setMaximumValue(40);
            	gauge.setValue(35);
            	gauge.setTargetValue(30);
            	gauge.setMinorTickCount(1);
		
                break;
            case 3:
            	gauge.setIsScaleInverted(false);
            	gauge.setMinimumValue(40);
            	gauge.setMaximumValue(90);
            	gauge.setValue(42);
            	gauge.setTargetValue(80);
            	gauge.setMinorTickCount(4);
            	
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
		return "Bullet Graph displays a single primary measure and compares it to one or more other measures to create a concise data visualization. This sample demonstrates animated transitions between different sets of settings.";
	}
}
