package com.infragistics.samples.chart;

import com.infragistics.controls.*;
import com.infragistics.samplesbrowser.SampleInfo;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SampleChart extends SampleLayout {

	private int paddingMedium = 5;
	private int paddingSmall = 5;
	
	protected int _defaultTransitionInDuration = 1000;
	
	public SampleChart(Activity activity, SampleInfo info, boolean useLegend) {
		super(activity);

		CreateChartView(useLegend);
	}
	protected LegendViewBase legend;
	protected DataChartView chart;
	
 
	private ViewGroup CreateChartView(boolean useLegend) {

		chart = new DataChartView(context);
		
		chart.setHorizontalZoomable(true);
		chart.setVerticalZoomable(true);
		chart.setBackgroundColor(Color.WHITE);
		chart.setLayoutParams(sampleLayoutParams);

		sampleContainer.setBackgroundColor(Color.WHITE);
				 		 
		sampleContainer.addView(chart);
		
		if (useLegend)
		{
			FrameLayout.LayoutParams legendParams = 
					new FrameLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
			int paddingAmount = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 
						5, getResources().getDisplayMetrics());
			
			legendParams.gravity = Gravity.RIGHT | Gravity.TOP;
					
			legend = createLegend();
			legend.setPadding(paddingMedium, paddingMedium, paddingSmall, paddingMedium);
			legend.setLayoutParams(legendParams);
			
			sampleContainer.addView(legend);
            chart.setLegend(legend);
		}
		
		return sampleContainer;
	}

    protected LegendViewBase createLegend() {
        LegendView leg = new LegendView(context);
        return leg;
    }
 
}