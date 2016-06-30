package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;
import com.infragistics.samples.chart.OnNumericBarChangeListener;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class RadialGaugeNeedleSample extends SampleLayout {

	public RadialGaugeNeedleSample(Activity activity) {
		super(activity);

		 final RadialGaugeView gauge = new RadialGaugeView (context);
		gauge.setValue(0.1);
		gauge.setMaximumValue(1);
		gauge.setTransitionDuration(1000);
		gauge.setNeedlePivotShape(RadialGaugePivotShape.CIRCLE);
		gauge.setNeedleShape(RadialGaugeNeedleShape.NEEDLE);
		
		NumericValueEditor editor1 = new NumericValueEditor("Needle Value:", context);
		 editor1.SeekBar.setMax(100);
		 editor1.SeekBar.setProgress(10);
		 editor1.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				 gauge.setValue(progress / 100.0);
			   } 
			 });
			 
		 float width = TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_SP, 170, context.getResources()
					.getDisplayMetrics());
		  float height = TypedValue.applyDimension(
							TypedValue.COMPLEX_UNIT_SP, 35, context.getResources()
							.getDisplayMetrics());		
		
		 FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int)width,(int)height);				 				
		 
		 TextView textview2 = new TextView(context);
		 textview2.setLayoutParams(params);
		 textview2.setText("Needle Shape:");
		 textview2.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		 
		ArrayAdapter adapter = new ArrayAdapter<RadialGaugeNeedleShape>(context, android.R.layout.simple_spinner_item, RadialGaugeNeedleShape.values());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner1 = new Spinner(context);
		spinner1.setAdapter(adapter);
		spinner1.setSelection(3);
		LinearLayout.LayoutParams spinnerParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		spinnerParams.weight = 1;
		spinner1.setLayoutParams(spinnerParams);
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				RadialGaugeNeedleShape nshape = RadialGaugeNeedleShape.values()[pos];
				gauge.setNeedleShape(nshape) ;					    
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				gauge.setNeedleShape(RadialGaugeNeedleShape.NEEDLE) ;	
			}
			
		});
				
		LinearLayout lin1 = new LinearLayout(context);
		lin1.setOrientation(LinearLayout.HORIZONTAL);
		lin1.addView(textview2 );
		lin1.addView(spinner1 );
		
		 TextView textview3 = new TextView(context);
		 textview3.setLayoutParams(params);
		 textview3.setText("Pivot Shape:");
		 textview3.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		 
		ArrayAdapter adapter1 = new ArrayAdapter<RadialGaugePivotShape>(context, android.R.layout.simple_spinner_item, RadialGaugePivotShape.values());
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner2 = new Spinner(context);
		spinner2.setAdapter(adapter1);
		spinner2.setLayoutParams(spinnerParams);
		spinner2.setSelection(1);
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() 
			{
				@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
						int pos, long arg3) {
					RadialGaugePivotShape pshape = RadialGaugePivotShape.values()[pos];
					gauge.setNeedlePivotShape(pshape) ;					    
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					gauge.setNeedlePivotShape(RadialGaugePivotShape.CIRCLE) ;	
				}
			});
		LinearLayout lin2 = new LinearLayout(context);
		lin2.setOrientation(LinearLayout.HORIZONTAL);
		lin2.addView(textview3 );
		lin2.addView(spinner2 );
		 
		 LinearLayout layout = new LinearLayout(context);
		 layout.setOrientation(LinearLayout.VERTICAL);
		 layout.addView(editor1.Layout);
		 layout.addView(lin1);
		 layout.addView(lin2);
		 layout.addView(gauge);
		 
		 this.addView(layout);
	}

	@Override
	protected String getDescription() {
		return "The needle of the Radial Gauge can be configured by setting its color, needle and pivot shapes and outlines.";
	}

}
