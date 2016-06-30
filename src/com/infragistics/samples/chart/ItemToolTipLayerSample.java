package com.infragistics.samples.chart;

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
import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataItem;
import com.infragistics.data.CategoryDataSample;
import com.infragistics.data.CategoryDataSmallSample;
import com.infragistics.graphics.Brush;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleInfo;

import java.text.DecimalFormat;
import java.util.List;

public class ItemToolTipLayerSample extends SampleChart {

	public ItemToolTipLayerSample(Activity activity, SampleInfo info,
                                  boolean useLegend) {
		super(activity, info, useLegend);

		CreateHorizontalCategorySeries(info.seriesClass, true);

		ItemToolTipLayer layer = new ItemToolTipLayer();
		layer.setTransitionDuration(500);
		layer.setUseInterpolation(false);
		chart.addSeries(layer);
		chart.setTitle("Press, hold and drag to activate!");
	}
	private void CreateHorizontalCategorySeries(Class<?> sampleType, final boolean smallData) {
		List<?> testData;
		List<?> testData2;

		CategoryXAxis xAxis = new CategoryXAxis();
		NumericYAxis yAxis = new NumericYAxis();

		if (smallData) {
			testData = new CategoryDataSmallSample();
			testData2 = new CategoryDataSmallSample();
			yAxis.setTitle("Millions of People");
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
		xAxis.setLabelAngle(45);

		yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());

		chart.addAxis(xAxis);
		chart.addAxis(yAxis);

		HorizontalAnchoredCategorySeries series;
		try {
			series = (HorizontalAnchoredCategorySeries)sampleType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return;
		}

		series.setXAxis(xAxis);
		series.setYAxis(yAxis);
		series.setValueMemberPath("Value");
		series.setDataSource(testData);
		series.setTitle("NA");
		series.setIsTransitionInEnabled(true);
		series.setTransitionInDuration(1000);
		series.setThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
		series.setAreaFillOpacity(.7);

		HorizontalAnchoredCategorySeries series2;
		try {
			series2 = (HorizontalAnchoredCategorySeries)sampleType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return;
		}

		series2.setXAxis(xAxis);
		series2.setYAxis(yAxis);
		series2.setValueMemberPath("Value");
		series2.setDataSource(testData2);
		series2.setTitle("Europe");
		series2.setIsTransitionInEnabled(true);
		series2.setTransitionInDuration(1000);
		series2.setThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
		series2.setAreaFillOpacity(.7);

		final Activity activity = context;

		ChartToolTipAdapter tip = new ChartToolTipAdapter(context) {
			@SuppressLint("NewApi")
			@Override
			public View getView(ChartDataContext chartContext, View existingView, CustomContentUpdateInfo updateInfo) {
				TextView tv;
				LinearLayout lin = (LinearLayout)existingView;
				if (lin == null) {
					lin = new LinearLayout(activity);
					lin.setBackgroundColor(Color.TRANSPARENT);
					existingView = lin;
					tv = new TextView(activity);
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
		
		series.setToolTip(tip);
		series2.setToolTip(tip);

		series.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 0.5);
		series2.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 0.5);
		
		chart.addSeries(series);
		chart.addSeries(series2);
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates the Item Tooltip Layer that displays tooltips for all target series individually.";
	}
}
