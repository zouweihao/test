package com.infragistics.samples.chart;

import java.util.List;

import com.infragistics.controls.*;
import com.infragistics.data.CountryDataSample;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.util.TypedValue;

public class ChartScatterPointSeriesSample extends SampleChart {

	public ChartScatterPointSeriesSample(Activity activity, SampleInfo info, boolean useLegend) {
		super(activity, info, useLegend);

		List<?> testData1 = CountryDataSample.GetWorldData();
		NumericXAxis xAxis = new NumericXAxis();
		NumericYAxis yAxis = new NumericYAxis();
		
		yAxis.setTitle("Population (M)");
		xAxis.setTitle("GDP ($)");
		xAxis.setIsLogarithmic(true);
		xAxis.setLogarithmBase(10);
		xAxis.setLabelTopMargin(TypedValue.COMPLEX_UNIT_DIP, 15);
		yAxis.setIsLogarithmic(true);
		yAxis.setLogarithmBase(10);
				
		xAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		xAxis.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 30);
		
		chart.addAxis(xAxis);
		chart.addAxis(yAxis);
				
		ScatterBase series1 = GetScatterSeries(info.seriesClass, xAxis, yAxis, testData1);
		
		chart.addSeries(series1);
		
		chart.setTitle("Population vs GDP");
		chart.setSubtitle("All countries in the world ");
	
		chart.setRightMargin(TypedValue.COMPLEX_UNIT_DIP, 30);
	}
	
	private ScatterBase GetScatterSeries(Class<?> SampleType, 
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
		series.setXMemberPath("gdp");
		series.setYMemberPath("population"); 
		series.setMarkerType(MarkerType.CIRCLE);
		
		series.setIsHighlightingEnabled(true);
		series.setDataSource(testData);
		
		return series;
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates the Scatter Series.";
	}
}
