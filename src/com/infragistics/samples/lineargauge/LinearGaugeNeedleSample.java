package com.infragistics.samples.lineargauge;

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

public class LinearGaugeNeedleSample extends SampleLayout {

	public LinearGaugeNeedleSample(Activity activity) {
		super(activity);
		 final LinearGaugeView gauge = new LinearGaugeView (context);
			gauge.setValue(0.1);
	     	gauge.setMaximumValue(1);
		 	gauge.setTransitionDuration(1000);
			gauge.setLabelExtent(0.05);
			gauge.setNeedleShape(LinearGraphNeedleShape.NEEDLE);
			int height =
					(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
							150, getResources().getDisplayMetrics());
			FrameLayout.LayoutParams paramsg = new FrameLayout.LayoutParams(
					FrameLayout.LayoutParams.MATCH_PARENT, 
					height);
			paramsg.gravity = Gravity.CENTER;
			gauge.setLayoutParams(paramsg);
			
					
			NumericValueEditor editor1 = new NumericValueEditor("Needle Value:", context);
		     editor1.SeekBar.setMax(100);
		     editor1.SeekBar.setProgress(10);
			 editor1.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setValue(progress / 100.0);
				   } 
				 });
			 
			 NumericValueEditor editor2 = new NumericValueEditor("NeedleInnerBase Width:", context);
		     editor2.SeekBar.setMax(40);
		     editor2.SeekBar.setProgress(5);
			 editor2.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setNeedleInnerBaseWidth(progress / 100.0);
				   } 
				 });
			 
			 NumericValueEditor editor3 = new NumericValueEditor("NeedleOuterBase Width:", context);
		     editor3.SeekBar.setMax(40);
			 editor3.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				   @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				     gauge.setNeedleOuterBaseWidth(progress / 100.0);
				   } 
				 });
			 
			 float width1 = TypedValue.applyDimension(
			            TypedValue.COMPLEX_UNIT_SP, 170, getResources()
		                .getDisplayMetrics());
		      float height1 = TypedValue.applyDimension(
					            TypedValue.COMPLEX_UNIT_SP, 35, getResources()
				                .getDisplayMetrics());		
			
			 FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int)width1,(int)height1);		

			 TextView textview2 = new TextView(context);
			 textview2.setLayoutParams(params);
			 textview2.setText("Needle Shape:");
			 textview2.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			 
			 Spinner spinner1 = new Spinner(context);
				ArrayAdapter adapter = new ArrayAdapter<LinearGraphNeedleShape>(context, android.R.layout.simple_spinner_item, LinearGraphNeedleShape.values());
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner1.setAdapter(adapter);
				LinearLayout.LayoutParams spinnerParams = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT);
				spinnerParams.weight = 1;
				spinner1.setLayoutParams(spinnerParams);
				spinner1.setSelection(4);
				spinner1.setOnItemSelectedListener(new OnItemSelectedListener() 
				{
				    @Override
						public void onItemSelected(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {
				    	LinearGraphNeedleShape nshape = LinearGraphNeedleShape.values()[pos];
						gauge.setNeedleShape(nshape) ;					    
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						gauge.setNeedleShape(LinearGraphNeedleShape.NEEDLE) ;	
					}
				});
				
			    LinearLayout lin1 = new LinearLayout(context);
							lin1.setOrientation(LinearLayout.HORIZONTAL);
							lin1.addView(textview2 );
							lin1.addView(spinner1 );
				
							LinearLayout layout = new LinearLayout(context);
							 layout.setOrientation(LinearLayout.VERTICAL);
							 layout.addView(editor1.Layout);
							 layout.addView(editor2.Layout);
							 layout.addView(editor3.Layout); 
							 layout.addView(lin1); 
								 layout.addView(gauge);
							 
							 this.addView(layout);
			
	}

	@Override
	protected String getDescription() {
		return "The needle of the Linear Gauge can be configured by setting its color, outline, shape, size.";
	}

}
