package com.infragistics.samples.chart;

import java.util.List;

import android.graphics.*;
import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataItem;
import com.infragistics.data.CategoryDataSample;
import com.infragistics.data.CategoryDataSmallSample;
import com.infragistics.graphics.*;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class ChartCategoryBarSeriesSample extends SampleChart {

	private int _defaultTransitionInDuration = 1000;
	
	public ChartCategoryBarSeriesSample(Activity activity, SampleInfo info, boolean useLegend, boolean smallData) {
		super(activity, info, useLegend);

		List<?> testData;
		List<?> testData2;

		CategoryYAxis yAxis = new CategoryYAxis();
		NumericXAxis xAxis = new NumericXAxis();
		
		if (smallData) {
			testData = new CategoryDataSmallSample();
			testData2 = new CategoryDataSmallSample();
			xAxis.setTitle("Millions of People");
			xAxis.setMinimumValue(5);
			xAxis.setMaximumValue(20);
			xAxis.setInterval(5);
			chart.setTitle("Commuters Per Day");
			chart.setSubtitle("Bus vs Train");
			
		} else {
			testData = new CategoryDataSample();
			testData2 = new CategoryDataSample();
			xAxis.setTitle("Months");
			xAxis.setTitle("Millions of Dollars");
			chart.setTitle("Monthly Sales Per Region");
			chart.setSubtitle("Europe vs North America");
		}
		 
		yAxis.setDataSource(testData);
		yAxis.setLabel("label");
        xAxis.setMinimumValue(0);
		xAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		chart.addAxis(xAxis);
		chart.addAxis(yAxis);
	 
		BarSeries series1 = new BarSeries();	
		series1.setIsTransitionInEnabled(true);
		series1.setTransitionInDuration(_defaultTransitionInDuration);
		series1.setXAxis(xAxis);
		series1.setYAxis(yAxis);
		series1.setValueMemberPath("Value");
		series1.setDataSource(testData);
		series1.setTitle("NA");

   		BarSeries series2 = new BarSeries();
		series2.setIsTransitionInEnabled(true);
		series2.setTransitionInDuration(_defaultTransitionInDuration);
	    series2.setXAxis(xAxis);
		series2.setYAxis(yAxis);
		series2.setValueMemberPath("Value");
		series2.setTitle("Europe");
		series2.setDataSource(testData2);
			
		ChartToolTipAdapter tip = new ChartToolTipAdapter(context) {
			@Override
			public View getView(ChartDataContext chartContext, View existingView, CustomContentUpdateInfo updateInfo) {
				TextView tv;
				if (existingView == null) {
					tv = new TextView(context);
                    tv.setTextColor(Color.GRAY);
					existingView = tv;
				}
				tv = (TextView)existingView;

				CategoryDataItem it = (CategoryDataItem)chartContext.getItem();
				if (it != null) {
					String val = Double.toString(it.getValue());
					if (val == null) {
						val = "NaN";
					}
					tv.setText(val);
				}
				
				return existingView;
			}
		};
		
		chart.addSeries(series1);
		chart.addSeries(series2);
	}

	@Override
	protected String getDescription() {
		return "This sample shows Bar Series of the Data Chart used for comparison among categories.";
	}
}
