package com.infragistics.samples.chart;

import java.util.List;

import com.infragistics.controls.*;
import com.infragistics.data.ScatterDataItem;
import com.infragistics.data.ScatterDataSample;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class ChartScatterContinuesSeriesSample extends SampleChart {

	public ChartScatterContinuesSeriesSample(Activity activity,SampleInfo info, boolean useLegend) {
		super(activity, info, useLegend);

		List<?> testData1;
		List<?> testData2;
		 
		testData1 = ScatterDataSample.GetBMI(1.6, 1.9, 20, 35);
		testData2 = ScatterDataSample.GetBMI(1.5, 1.7, 15, 20);
		
		NumericXAxis numericX1 = new NumericXAxis();
		NumericYAxis numericY1 = new NumericYAxis();

		NumericXAxis numericX2 = new NumericXAxis();
		NumericYAxis numericY2 = new NumericYAxis();

		numericX1.setMinimumValue(0);
		numericX1.setMaximumValue(160);
		numericX2.setMinimumValue(0);
		numericX2.setMaximumValue(350);
				
		numericY1.setMinimumValue(1.4);
		numericY1.setMaximumValue(2.0);
		numericY2.setMinimumValue(4.9);
		numericY2.setMaximumValue(6.6);
		numericY2.setInterval(0.3);
		
		numericX1.setLabelTopMargin(TypedValue.COMPLEX_UNIT_DIP, 15);
		numericX1.setTitle("Weight (kilograms)");
		numericY1.setTitle("Height (meters)");
		
		numericX2.setTitle("Weight (pounds)");
		numericY2.setTitle("Height (feet)");
	
		numericX1.setLabelLocation(AxisLabelsLocation.OUTSIDE_BOTTOM);
		numericX2.setLabelLocation(AxisLabelsLocation.OUTSIDE_TOP);
		numericY1.setLabelLocation(AxisLabelsLocation.OUTSIDE_LEFT);
		numericY2.setLabelLocation(AxisLabelsLocation.OUTSIDE_RIGHT);
		
		numericX1.setLabelAngle(90);
		numericX2.setLabelAngle(90);
				
		numericY1.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 45);
		numericY2.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 45);
		
		numericY1.setLabelHorizontalAlignment(HorizontalAlignment.CENTER);
		numericY2.setLabelHorizontalAlignment(HorizontalAlignment.CENTER);
		
		numericX1.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		numericX2.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		numericX1.setLabelVerticalAlignment(VerticalAlignment.CENTER);
		numericX1.setLabelVerticalAlignment(VerticalAlignment.CENTER);
		
		numericX2.setMajorStrokeThickness(TypedValue.COMPLEX_UNIT_DIP, 0);
		numericY2.setMajorStrokeThickness(TypedValue.COMPLEX_UNIT_DIP, 0);
		
		numericX2.setTitlePosition(AxisTitlePosition.TOP);
		numericY2.setTitlePosition(AxisTitlePosition.RIGHT);
		numericY2.setTitleAngle(90);
		
		SolidColorBrush transparentBrush = new SolidColorBrush();
		transparentBrush.setColor(Color.parseColor("#00494949"));
		
		numericX2.setMajorStroke(transparentBrush);
		numericY2.setMajorStroke(transparentBrush);
		
		chart.addAxis(numericX1);
		chart.addAxis(numericX2);
		chart.addAxis(numericY1);
		chart.addAxis(numericY2);
		
		ScatterBase series1 = GetScatterContinuesSeries(info.seriesClass, numericX1, numericY1, testData1);
		ScatterBase series2 = GetScatterContinuesSeries(info.seriesClass, numericX1, numericY1, testData2);
		series1.setTitle("US") ;
		series2.setTitle("Japan") ;
		
		series1.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 1);
		series2.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 1);
		
		SolidColorBrush seriesBrush1 = new SolidColorBrush();
		seriesBrush1.setColor(Color.parseColor("#494949"));
				
		SolidColorBrush trendBrush1 = new SolidColorBrush();
		trendBrush1.setColor(Color.parseColor("#494949"));
	
		SolidColorBrush seriesBrush2 = new SolidColorBrush();
		seriesBrush2.setColor(Color.parseColor("#1b81e5"));
		
		SolidColorBrush trendBrush2 = new SolidColorBrush();
		trendBrush2.setColor(Color.parseColor("#125699"));
		
		chart.addSeries(series1);
		chart.addSeries(series2);
		
		chart.setTitle("Body Mass Index");
		chart.setSubtitle("U.S. vs Japan population");
	}
	private ScatterBase GetScatterContinuesSeries(Class<?> SampleType, 
			NumericXAxis numericX, 
			NumericYAxis numericY, List<?> testData){
		
		ScatterBase series;
		try {
			series = (ScatterBase)SampleType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}		
		series.setXAxis(numericX);
		series.setYAxis(numericY);
		series.setXMemberPath("x");
		series.setYMemberPath("y");
		series.setIsHighlightingEnabled(true);
		series.setDataSource(testData);
		return series;
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates the Scatter Continues Series.";
	}
}
