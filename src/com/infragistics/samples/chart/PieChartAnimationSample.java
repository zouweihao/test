package com.infragistics.samples.chart;

import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataSmallSample;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PieChartAnimationSample extends SampleLayout {

	public PieChartAnimationSample(Activity activity) {
		super(activity);
		
		PieChartView view = new PieChartView(context);
		view.setBackgroundColor(Color.WHITE);
		
		CategoryDataSmallSample smt = new CategoryDataSmallSample();
		view.explodeSlice(1);
				
		view.setDataSource(smt);
		view.setLabelMemberPath("label");
		view.setValueMemberPath("Value");
		view.setLabelsPosition(LabelsPosition.OUTSIDE_END);
		view.setAllowSliceExplosion(true);
		view.setExplodedRadius(0.2);
		view.setRadiusFactor(0.7);
        
        view.setOnSliceClickListener(new OnSliceClickListener() {
        	public void onSliceClick(PieChartView view, SliceClickEvent event) {
				event.setIsExploded(!event.getIsExploded());
				event.setIsSelected(!event.getIsSelected());
        	}
        });
        
    	FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(700,70);
    	TextView textview = new TextView(context);	
		textview.setLayoutParams(params);
		textview.setText("Tap a slice to explode pie chart!");
		textview.setGravity(Gravity.CENTER_VERTICAL);
				
		this.sampleOptions.addView(textview);
		this.sampleContainer.addView(view);
		
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates how to use the Pie Chart control. Click on a pie slice to toggle its explosion.";
	}

}
