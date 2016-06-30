package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;
import com.infragistics.samples.chart.OnNumericBarChangeListener;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class RadialGaugeLabelsSample extends SampleLayout  {

	public RadialGaugeLabelsSample(Activity activity) {
		super(activity);
		
		 final RadialGaugeView gauge = new RadialGaugeView(context);
		gauge.setValue(0.1);
		gauge.setMaximumValue(1);
		gauge.setTransitionDuration(800);
		gauge.setLabelExtent(0.7) ;
		gauge.setInterval(0.1);
		
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

		 LinearLayout layout = new LinearLayout(context);
		 layout.setOrientation(LinearLayout.VERTICAL);
		 layout.addView(editor1.Layout);
		 layout.addView(editor2.Layout);
		 layout.addView(gauge);

		 this.addView(layout);
			
	}

	@Override
	protected String getDescription() {
		return "Radial Gauge has different label configurations, like color, extent, interval.";
	}

}
