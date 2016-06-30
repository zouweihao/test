package com.infragistics.samples.bulletgraph;

import com.infragistics.controls.*;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samples.chart.OnNumericBarChangeListener;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class BulletGraphOptionsSample extends SampleLayout {

	public BulletGraphOptionsSample(Activity activity) {
		super(activity);

		final BulletGraphView gauge = new BulletGraphView (context);
        SolidColorBrush fontBrush = new SolidColorBrush(android.graphics.Color.WHITE);
        gauge.setFontBrush(fontBrush);
        gauge.setTransitionDuration(1000);
		gauge.setMinimumValue(0);
		gauge.setMaximumValue(200);
		gauge.setTargetValue(160);
		gauge.setValue(180);
	    gauge.setInterval(40) ;
	    SolidColorBrush b = new SolidColorBrush() ;
		b.setColor(Color.WHITE) ;
		gauge.setValueBrush(b);
		gauge.setTargetValueBrush(b);

		int height =
				(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						100, getResources().getDisplayMetrics());
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT, 
				height);
		params.gravity = Gravity.CENTER;
		gauge.setLayoutParams(params);
		
		LinearGraphRange lgrange1 = new LinearGraphRange();
		lgrange1.setStartValue(0);
		lgrange1.setEndValue(50) ;
		SolidColorBrush brush = new SolidColorBrush() ;
		brush.setColor(Color.parseColor("#C62D36"));
		lgrange1.setBrush(brush) ;
		
		LinearGraphRange lgrange2 = new LinearGraphRange();
		lgrange2.setStartValue(50);
		lgrange2.setEndValue(150) ;
		SolidColorBrush brush1 = new SolidColorBrush() ;
		brush1.setColor(Color.parseColor("#FDBD48"));
		lgrange2.setBrush(brush1) ;
		
		LinearGraphRange lgrange3 = new LinearGraphRange();
		lgrange3.setStartValue(150);
		lgrange3.setEndValue(200) ;
		SolidColorBrush brush2 = new SolidColorBrush() ;
		brush2.setColor(Color.parseColor("#48892D"));
		lgrange3.setBrush(brush2) ;
		
		gauge.addRange(lgrange1);
		gauge.addRange(lgrange2);
		gauge.addRange(lgrange3);
		
		NumericValueEditor editor = new NumericValueEditor("MinorTick Count:", context);
	     editor.SeekBar.setMax(20);
	     editor.SeekBar.setProgress(10);
		 editor.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
			     gauge.setMinorTickCount(progress);
			   } 
	    });
		 
		
		NumericValueEditor editor1 = new NumericValueEditor("Interval:", context);
	     editor1.SeekBar.setMax(100);
	     editor1.SeekBar.setProgress(40);
		 editor1.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
			     gauge.setInterval(progress);
			   } 
	    });
		 
		
	    			
		 NumericValueEditor editor2 = new NumericValueEditor("Label Post-Initial:", context);
	     editor2.SeekBar.setMax(100);
	     editor2.SeekBar.setProgress(10);
		 editor2.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
			     gauge.setLabelsPostInitial(progress);
			   } 
	    });
		 
		 NumericValueEditor editor3 = new NumericValueEditor("Label Pre-Terminal:", context);
	     editor3.SeekBar.setMax(100);
	     editor3.SeekBar.setProgress(10);
		 editor3.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
			     gauge.setLabelsPreTerminal(progress);
			   } 
	    });

		LinearLayout layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(editor1.Layout);
		layout.addView(editor2.Layout);
	 	layout.addView(editor3.Layout);
		layout.addView(gauge);

		this.addView(layout);
	}

	@Override
	protected String getDescription() {
		return "Bullet Graph supports a variety of configurations, e.g. orientation, scale, tick marks, ranges and colors.";
	}

}
