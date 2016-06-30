package com.infragistics.samples.chart;

import java.util.List;

import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataSample;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;

public class ChartCategoryRangeSeriesSample extends SampleChart {

	private int _defaultTransitionInDuration = 1000;
	
	public ChartCategoryRangeSeriesSample(Activity activity, SampleInfo info, boolean useLegend, boolean smallData) {
		super(activity, info, useLegend);

		List<?> testData = CategoryDataSample.GetTemperatureData();
		
		chart.setTitle("Temperatures Over Time");
		chart.setSubtitle("Miami vs New York ");
			
		CategoryXAxis xAxis = new CategoryXAxis();
		NumericYAxis yAxis1 = new NumericYAxis();
		NumericYAxis yAxis2 = new NumericYAxis();

		xAxis.setTitle("Months");
		yAxis1.setTitle("Temperature (C)");
		yAxis2.setTitle("Temperature (F)");
		
		xAxis.setDataSource(testData);
		xAxis.setLabel("label");
		xAxis.setLabelAngle(90);
		xAxis.setInterval(1);
		
		yAxis1.setMinimumValue(-10);
		yAxis1.setMaximumValue(30);
		yAxis2.setMinimumValue(14);
		yAxis2.setMaximumValue(86);
		yAxis2.setInterval(9);
		
		yAxis1.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		yAxis2.setOnFormatLabelListener(new OnAxisNumericLabelListener());
				
		SolidColorBrush transparentBrush = new SolidColorBrush();
		transparentBrush.setColor(Color.parseColor("#00494949"));
		
		yAxis1.setTitleAngle(-90);
		yAxis2.setTitleAngle(90);
		
		yAxis2.setMajorStroke(transparentBrush);
		yAxis2.setTitlePosition(AxisTitlePosition.RIGHT);
		yAxis2.setLabelLocation(AxisLabelsLocation.OUTSIDE_RIGHT);
		
		chart.addAxis(xAxis);
		chart.addAxis(yAxis1);
		chart.addAxis(yAxis2);
		
		HorizontalRangeCategorySeries series;
		try {
			series = (HorizontalRangeCategorySeries)info.seriesClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return;
		}
		
		series.setXAxis(xAxis);
		series.setYAxis(yAxis1);
		series.setLowMemberPath("lowValue");
		series.setHighMemberPath("highValue");
		series.setDataSource(testData);
		series.setTitle("NA");
		series.setIsTransitionInEnabled(true);
		series.setTransitionInDuration(_defaultTransitionInDuration);
		series.setThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
		series.setAreaFillOpacity(.7);

		chart.addSeries(series);
	}

	@Override
	protected String getDescription() {
		return "This sample shows the Horizontal Range Category Series.";
	}
}
