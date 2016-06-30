package com.infragistics.samplesbrowser;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class NumericValueEditor {
	
	public TextView TextView;
	public SeekBar SeekBar;
	public LinearLayout Layout;
	
	public NumericValueEditor(String title, Activity context){
		 float width = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 170, context.getResources()
            .getDisplayMetrics());
		 float height = TypedValue.applyDimension(
		            TypedValue.COMPLEX_UNIT_SP, 35, context.getResources()
	                .getDisplayMetrics());

		
		 FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int)width,(int)height);
		 
		 this.TextView = new TextView(context);
		 this.TextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		 this.TextView.setLayoutParams(params);
		 this.TextView.setText(title);
		 
		 this.SeekBar = new SeekBar(context);
		 this.SeekBar.setMax(100);
		 this.SeekBar.setProgress(10);
		 
		 
		 float width1 = TypedValue.applyDimension(
		            TypedValue.COMPLEX_UNIT_SP, 130, context.getResources()
	                .getDisplayMetrics());
				 float height1 = TypedValue.applyDimension(
				            TypedValue.COMPLEX_UNIT_SP, 40, context.getResources()
			                .getDisplayMetrics());
		 
		// this.SeekBar.setLayoutParams(new LayoutParams(750, 95));
		 LinearLayout.LayoutParams lin = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		 lin.weight = 1;
		 this.SeekBar.setLayoutParams(lin);
				 
		 this.Layout = new LinearLayout(context);
		 this.Layout.setOrientation(LinearLayout.HORIZONTAL);
		 this.Layout.addView(this.TextView);
		 this.Layout.addView(this.SeekBar);
			
	}
	
	
}
