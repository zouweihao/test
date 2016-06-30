package com.infragistics.samples.chart;

import java.util.List;

import android.graphics.*;
import com.infragistics.controls.*;
import com.infragistics.data.CountryDataList;
import com.infragistics.data.CountryDataSample;
import com.infragistics.graphics.*;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;

public class ChartScatterBubbleSeriesSample extends SampleChart {

	public ChartScatterBubbleSeriesSample(Activity activity, SampleInfo info, boolean useLegend, boolean smallData) {
		super(activity, info, useLegend);

		CountryDataList testData1;
		testData1 = CountryDataSample.GetWorldData();
        testData1.sortByPopulation();

        if (smallData) {
            CountryDataList newData = new CountryDataList();
            for (int i = testData1.size() - 1; i >= testData1.size() - 6; i--) {
                newData.add(testData1.get(i));
            }
            testData1 = newData;
        }

		NumericXAxis xAxis = new NumericXAxis();
		NumericYAxis yAxis = new NumericYAxis();
		
		xAxis.setIsLogarithmic(true);
		xAxis.setLogarithmBase(10);
	
		yAxis.setIsLogarithmic(true);
		yAxis.setLogarithmBase(10);
		
		yAxis.setTitle("Population (M)");
		xAxis.setTitle("GDP per person ($)");
	
		xAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		chart.addAxis(xAxis);
		chart.addAxis(yAxis);
	
		ScatterBase series1 = GetBubbleSeries(xAxis, yAxis, testData1);
		chart.addSeries(series1);
		
		chart.setTitle("Population vs GDP vs Dept");
		chart.setSubtitle("All countries in the world ");

	}

    @Override
    protected LegendViewBase createLegend() {
        return new ItemLegendView(context);
    }
	
	private ScatterBase GetBubbleSeries(NumericXAxis numericX, NumericYAxis numericY, List<?> testData){
		
		BubbleSeries series = new BubbleSeries();
		series.setXAxis(numericX);
		series.setYAxis(numericY);
		series.setXMemberPath("gdp");
		series.setYMemberPath("population"); 
		series.setRadiusMemberPath("dept");
		series.setDataSource(testData);
		series.setTitle("GDP vs Population");

        SizeScale size = new SizeScale();
        size.setMinimumValue(10);
        size.setMaximumValue(40);
        size.setIsLogarithmic(true);
        series.setRadiusScale(size);

        series.setFillMemberPath("dept");
        ValueBrushScale v = new ValueBrushScale();
        BrushPalette b = new BrushPalette();
        b.getBrushes().add(new SolidColorBrush(Color.RED));
        b.getBrushes().add(new SolidColorBrush(Color.YELLOW));
        v.setBrushes(b);
        v.setIsLogarithmic(true);

        series.setFillScale(v);
        series.setLabelMemberPath("name");
	
		return series;
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates the Scatter Bubble Series.";
	}
}
