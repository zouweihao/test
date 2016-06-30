package com.infragistics.samples.lineargauge;

import com.infragistics.controls.*;
import com.infragistics.samples.chart.OnNumericBarChangeListener;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class LinearGaugeLabelsSample extends SampleLayout {

	public LinearGaugeLabelsSample(Activity activity) {
		super(activity);

		 final LinearGaugeView gauge = new LinearGaugeView (context);
		 	gauge.setMaximumValue(1);
			gauge.setValue(0.1);
		    gauge.setTransitionDuration(800);
			gauge.setLabelExtent(0.7) ;
			gauge.setLabelInterval(0.1);	
			
			int height =
					(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
							150, getResources().getDisplayMetrics());
			FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
					FrameLayout.LayoutParams.MATCH_PARENT, 
					height);
			params.gravity = Gravity.CENTER;
			gauge.setLayoutParams(params);
			
			NumericValueEditor editor1 = new NumericValueEditor("Label Extent:", context);
		     editor1.SeekBar.setMax(100);
		     editor1.SeekBar.setProgress(70);
			 editor1.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setLabelExtent(progress / 100.0);
				   } 
				 });
		  
			 NumericValueEditor editor2 = new NumericValueEditor("Interval:", context);
			 editor2.SeekBar.setMax(100);
			 editor2.SeekBar.setProgress(10);
			 editor2.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setInterval(progress / 100.0);
				   } 
				 });
			  
			 NumericValueEditor editor3 = new NumericValueEditor("Label Pre-Terminal:", context);
			 editor3.SeekBar.setMax(50);
			 editor3.SeekBar.setProgress(10);
			 editor3.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setLabelsPreTerminal(progress / 100.0);
				   } 
				 });
			  
			 NumericValueEditor editor4 = new NumericValueEditor("Label Post-Initial:", context);
			 editor4.SeekBar.setMax(50);
			 editor4.SeekBar.setProgress(10);
			 editor4.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setLabelsPostInitial(progress / 100.0);
				   } 
				 });
			 
			 LinearLayout layout = new LinearLayout(context);
			 layout.setOrientation(LinearLayout.VERTICAL);
			 layout.addView(editor1.Layout);
			 layout.addView(editor2.Layout);
			 layout.addView(editor3.Layout);
			 layout.addView(editor4.Layout);
			 layout.addView(gauge);
			 
			 this.addView(layout);
	}

	@Override
	protected String getDescription() {
		return "Linear Gauge has different label configurations, like color, extent, interval, position of the first and last labels.";
	}

}
