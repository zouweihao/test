package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;
import com.infragistics.data.ColorsData;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samples.chart.OnNumericBarChangeListener;
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

public class RadialGaugeRangeSample extends SampleLayout  {

	public RadialGaugeRangeSample(Activity activity) {
		super(activity);

		final RadialGaugeView gauge = new RadialGaugeView (context);
		gauge.setTransitionDuration(1000);
		final RadialGaugeRange range1 = new RadialGaugeRange();
		range1.setStartValue(70);
		range1.setEndValue(100) ;
		SolidColorBrush brush = new SolidColorBrush() ;
		brush.setColor(Color.parseColor("#C62D36"));
		
		range1.setBrush(brush) ;
		range1.setOuterStartExtent(0.45);
		range1.setOuterEndExtent(0.40);
		gauge.addRange(range1);
		
		NumericValueEditor editor1 = new NumericValueEditor("Range StartValue:", context);
		editor1.SeekBar.setMax(100);
		editor1.SeekBar.setProgress(70);
		editor1.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
		   @Override 
		   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
			 range1.setStartValue(progress) ;

		   } 
		 });
			 
		NumericValueEditor editor2 = new NumericValueEditor("Range EndValue:", context);
		editor2.SeekBar.setMax(100);
		editor2.SeekBar.setProgress(100);
		editor2.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
		   @Override 
		   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
			 range1.setEndValue(progress) ;

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
		 textview2.setText("Range Brush:");
		 textview2.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		 
		 ColorsData data = new ColorsData();
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, data);
		 
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner1 = new Spinner(context);
		spinner1.setAdapter(adapter);
		
		spinner1.setSelection(6);
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
				
				String s = (String) arg0.getItemAtPosition(pos) ;
				SolidColorBrush b = new SolidColorBrush() ;

			   if (s == "WHITE")
				  b.setColor(Color.WHITE) ; 
			   else if (s == "BLACK")
				   b.setColor(Color.BLACK);
			   if (s == "GREEN")
				  b.setColor(Color.GREEN) ; 
				else if (s == "BLUE")
				   b.setColor(Color.BLUE); 
				else if (s == "MAGENTA")
					   b.setColor(Color.MAGENTA); 
				else if (s == "RED")
					   b.setColor(Color.RED); 
				else if (s == "TRANSPARENT")
					   b.setColor(Color.TRANSPARENT); 
				else if (s == "CYAN")
					   b.setColor(Color.CYAN); 
				else if (s == "YELLOW")
					   b.setColor(Color.YELLOW); 
				else if (s == "GRAY")
					   b.setColor(Color.GRAY); 	                                           
																				   
				range1.setBrush(b);
									
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				SolidColorBrush brush = new SolidColorBrush() ;
				brush.setColor(Color.parseColor("#C62D36"));
				range1.setBrush(brush) ;
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
		 layout.addView(lin1);
		 layout.addView(gauge);
		 
		 this.addView(layout);
	}

	@Override
	protected String getDescription() {
		return "Radial Gauge has different range configurations, like color, start and end value.";
	}
}
