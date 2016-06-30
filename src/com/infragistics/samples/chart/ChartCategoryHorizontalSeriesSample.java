package com.infragistics.samples.chart;

import java.text.DecimalFormat;
import java.util.List;
import android.graphics.Typeface;
import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataItem;
import com.infragistics.data.CategoryDataSample;
import com.infragistics.data.CategoryDataSmallSample;
import com.infragistics.extensions.Brushes;
import com.infragistics.graphics.Brush;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleInfo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChartCategoryHorizontalSeriesSample extends SampleChart {

	private int _defaultTransitionInDuration = 1000;
	
	public ChartCategoryHorizontalSeriesSample(Activity activity, SampleInfo info, boolean useLegend, boolean smallData) {
		super(activity, info, useLegend);

		List<?> testData;
		List<?> testData2;
		 
		CategoryXAxis xAxis = new CategoryXAxis();
		NumericYAxis yAxis = new NumericYAxis();
		 
		if (smallData) {
			testData = new CategoryDataSmallSample();
			testData2 = new CategoryDataSmallSample();
			yAxis.setTitle("Millions of People");
			yAxis.setMinimumValue(6);
			yAxis.setMaximumValue(18);
			yAxis.setInterval(2);
			chart.setTitle("Commuters Per Day");
			chart.setSubtitle("Bus vs Train");
			
		} else {
			testData = new CategoryDataSample();
			testData2 = new CategoryDataSample();
			xAxis.setTitle("Months");
			yAxis.setTitle("Millions of Dollars");
			chart.setTitle("Monthly Sales");
			chart.setSubtitle("Per Region");
		}

		xAxis.setDataSource(testData);
		xAxis.setLabel("label");
		
        xAxis.setTickLength(0);
        xAxis.setStroke(new SolidColorBrush(Color.rgb(31, 34, 38)));
		
//        yAxis.setMaximumValue(120);
//        yAxis.setMinimumValue(90);
        
//        yAxis.setInterval(30);
		yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		yAxis.setStroke(new SolidColorBrush(Color.rgb(31, 34, 38)));

        chart.addAxis(xAxis);
		chart.addAxis(yAxis);
	 
		HorizontalAnchoredCategorySeries series1 = GetHorizontalSeries(xAxis, yAxis, info.seriesClass, testData);
		HorizontalAnchoredCategorySeries series2 = GetHorizontalSeries(xAxis, yAxis, info.seriesClass, testData2);
		 
		series1.setTitle("NA");
		series2.setTitle("Europe");
		
		ChartToolTipAdapter tip = new ChartToolTipAdapter(context) {
			@SuppressLint("NewApi")
			@Override
			public View getView(ChartDataContext chartContext, View existingView, CustomContentUpdateInfo updateInfo) {
				TextView tv;
				android.widget.LinearLayout lin = (android.widget.LinearLayout)existingView;
				if (lin == null) {
					lin = new android.widget.LinearLayout(context);
					lin.setBackgroundColor(Color.TRANSPARENT);
					existingView = lin;
					tv = new TextView(context);
					tv.setPadding(4, 4, 4, 4);
					tv.setTextColor(Color.GRAY);
					
					GradientDrawable gd = new GradientDrawable();
					Brush brush = chartContext.getSeries().getActualBrush();
					int c;
					c = Color.BLACK;
					if (brush != null && brush instanceof SolidColorBrush)
					{
						SolidColorBrush b = (SolidColorBrush)brush;
						c = b.getColor();
					}
					
					gd.setColor(c);
					FrameLayout fl = new FrameLayout(context);
					LinearLayout.LayoutParams pm = new LinearLayout.LayoutParams(30, 30);
					pm.gravity = Gravity.CENTER_VERTICAL;
					fl.setPadding(4, 4, 4, 4);
					fl.setLayoutParams(pm);
					
					if (android.os.Build.VERSION.SDK_INT >= 16) {
						fl.setBackground(gd);
					} else {
						fl.setBackgroundDrawable(gd);
					}
					
					lin.addView(fl);
					lin.addView(tv);
				}
				else {
					tv = (TextView)((LinearLayout)existingView).getChildAt(1);
				}

				CategoryDataItem it = (CategoryDataItem)chartContext.getItem();
				if (it != null) {
					String val = new DecimalFormat("#.00").format(it.getValue());
					if (val == null) {
						val = "NaN";
					}
					tv.setText(val);
				}
				
				return existingView;
			}
		};
		
		series1.setToolTip(tip);
		series2.setToolTip(tip);

//		series1.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 0.5);
//		series2.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 0.5);
//		
		chart.addSeries(series1);
//		chart.addSeries(series2);
	}

	private HorizontalAnchoredCategorySeries GetHorizontalSeries(CategoryXAxis xAxis, NumericYAxis yAxis, Class<?> sampleType, List<?> testData){
		
		HorizontalAnchoredCategorySeries series;
		try {
			series = (HorizontalAnchoredCategorySeries)sampleType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		
		series.setXAxis(xAxis);
		series.setYAxis(yAxis);
		series.setValueMemberPath("Value");
		series.setDataSource(testData);
		series.setIsTransitionInEnabled(true);
	
		series.setAreaFillOpacity(.7);

		return series;
	}

	@Override
	protected String getDescription() {
		return "This sample shows the Anchored Category Series with a category x-axis and a numeric y-axis.";
	}
}
