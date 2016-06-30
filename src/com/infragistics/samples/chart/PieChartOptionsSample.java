package com.infragistics.samples.chart;

import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataPieSample;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
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

public class PieChartOptionsSample extends SampleLayout {

	public PieChartOptionsSample(Activity activity) {
		super(activity);
 
		CategoryDataPieSample data = new CategoryDataPieSample();				
		
		final PieChartView chart = new PieChartView (context);
		chart.setBackgroundColor(Color.WHITE);

		chart.setDataSource(data);
		chart.setLabelMemberPath("label");
		chart.setValueMemberPath("highValue");	 
		chart.setAllowSliceExplosion(true);
		chart.setRadiusFactor(0.7);

		 float width1 = TypedValue.applyDimension(
		            TypedValue.COMPLEX_UNIT_SP, 170, getResources()
	                .getDisplayMetrics());
	      float height1 = TypedValue.applyDimension(
				            TypedValue.COMPLEX_UNIT_SP, 35, getResources()
			                .getDisplayMetrics());		
		
		 FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int)width1,(int)height1);

		TextView textview1 = new TextView(context);
		textview1.setLayoutParams(params);
		textview1.setText("LabelPosition:");
		textview1.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			
		Spinner spinner1 = new Spinner(context);
		ArrayAdapter adapter = new ArrayAdapter<LabelsPosition>(context, android.R.layout.simple_spinner_item, LabelsPosition.values());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);	
		spinner1.setSelection(3);
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				LabelsPosition position = LabelsPosition.values()[pos];
				chart.setLabelsPosition(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				chart.setLabelsPosition(LabelsPosition.CENTER);
			}
			
		});	
		LinearLayout.LayoutParams spinnerParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		spinnerParams.weight = 1;
		spinner1.setLayoutParams(spinnerParams);
		
		LinearLayout lin1 = new LinearLayout(context);
		lin1.setOrientation(LinearLayout.HORIZONTAL);
		lin1.addView(textview1 );
		lin1.addView(spinner1 );		
		
		NumericValueEditor editor1 = new NumericValueEditor("Label Extent:", context);
	     editor1.SeekBar.setMax(80);
		 editor1.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			 @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, 
			     boolean fromUser) { 
			     chart.setLabelExtent(progress);
			   } 
			 });		
 
			NumericValueEditor editor2 = new NumericValueEditor("Start Angle:", context);
		     editor2.SeekBar.setMax(360);
			 editor2.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
				 @Override 
				   public void onProgressChanged(SeekBar seekBar, int progress, 
				     boolean fromUser) { 
				     chart.setStartAngle(progress);
				   } 
				 });		
  
			NumericValueEditor editor3 = new NumericValueEditor("Radius Factor:", context);
			editor3.SeekBar.setMax(1000);
			editor3.SeekBar.setProgress(700);
			editor3.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
					 @Override 
					   public void onProgressChanged(SeekBar seekBar, int progress, 
					     boolean fromUser) { 
						 chart.setRadiusFactor(progress/1000.0);
					   } 
					 });		
		  
		  TextView textview5 = new TextView(context);
		  textview5.setLayoutParams(params);
		  textview5.setText("LeaderlineType:");
	   	  textview5.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);	
	   	
	   	  ArrayAdapter adapter1 = new ArrayAdapter<LeaderLineType>(context, android.R.layout.simple_spinner_item, LeaderLineType.values());
		  Spinner spinner2 = new Spinner(context);
			adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner2.setAdapter(adapter1);		
			spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int pos, long arg3) {
					LeaderLineType ltype = LeaderLineType.values()[pos];
 					chart.setLeaderLineType(ltype);
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					chart.setLeaderLineType(LeaderLineType.STRAIGHT);
				}
				
			});
			 spinner2.setAdapter(adapter1);	
			 spinner2.setLayoutParams(spinnerParams);
			 LinearLayout lin5 = new LinearLayout(context);
			 lin5.setOrientation(LinearLayout.HORIZONTAL);
			 lin5.addView(textview5 );
			 lin5.addView(spinner2 );
			 
			// setActiveViews(lin1,editor1.Layout,editor2.Layout,editor3.Layout,lin5,chart);
			 
			 	this.sampleOptions.addView(lin1);
				this.sampleOptions.addView(editor1.Layout);
				this.sampleOptions.addView(editor2.Layout);
				this.sampleOptions.addView(editor3.Layout);
			 	this.sampleOptions.addView(lin5);
			
				this.sampleContainer.addView(chart);
		
	}

	@Override
	protected String getDescription() {
		return "The main features of the PieChart include label configurations, like position and extent, controlling pie radius, start angle, sweep direction, exploded slices and distance from center for exploded slices.";
	}

}
