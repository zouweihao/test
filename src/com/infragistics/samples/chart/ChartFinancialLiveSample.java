package com.infragistics.samples.chart;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.*;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infragistics.controls.*;
import com.infragistics.data.FinancialDataItem;
import com.infragistics.data.FinancialDataList;
import com.infragistics.data.FinancialDataManager;
import com.infragistics.samplesbrowser.SampleInfo;

public class ChartFinancialLiveSample extends SampleChart {

	private Timer financialTimer;
	private FinancialDataList LiveData = FinancialDataManager.GetRandomData();
	
	public ChartFinancialLiveSample(Activity activity, SampleInfo info, boolean useLegend, boolean useCandlestick) {
		super(activity, info, useLegend); 
		
		LiveData = FinancialDataManager.GetRandomData();

		CategoryXAxis xAxis = new CategoryXAxis();
		xAxis.setUseClusteringMode(true);
		xAxis.setDataSource(LiveData);
		xAxis.setLabel("label");
		xAxis.setTitle("Time");
		xAxis.setInterval(10);
		xAxis.setLabelAngle(90);
		
		NumericYAxis yAxis = new NumericYAxis();
		yAxis.setTitle("Price ($)");
		
		yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		chart.addAxis(xAxis);
		chart.addAxis(yAxis);

		FinancialSeries series = GetFinancialSeries(xAxis, yAxis, info.seriesClass, true, LiveData);

		series.setIsTransitionInEnabled(false);
		series.setTitle("Price");
		
    	chart.addSeries(series);

    	financialTimer = new Timer();
    	TimerTask task = new UpdateFinancialDataTask(LiveData);
    	financialTimer.scheduleAtFixedRate(task, 200, 1000);

	}
	class UpdateFinancialDataTask extends TimerTask  {

		FinancialDataList LiveData;

	     public UpdateFinancialDataTask(FinancialDataList data) {
		        this.LiveData = data;
		     }
		
			@Override
	     public void run() {
	    	 LiveData.remove(0);
	    	 LiveData.add(FinancialDataManager.GetRandomDataItem(LiveData));
	     }
	}
	public void cleanup() {
		
		super.cleanup();
		
		if (financialTimer != null) 
		{
			financialTimer.cancel();
			financialTimer.purge();
		}
		
	}
	private FinancialSeries GetFinancialSeries(CategoryXAxis xAxis, NumericYAxis yAxis, 
			Class<?> sampleType, boolean useCandlestick, List<?> testData){
		
		FinancialSeries series = null;
		try {
			series = (FinancialSeries)sampleType.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (series instanceof FinancialPriceSeries) {
			series.setResolution(8);
			if (useCandlestick) {
				((FinancialPriceSeries)series).setDisplayType(PriceDisplayType.CANDLESTICK);
			} else {
				((FinancialPriceSeries)series).setDisplayType(PriceDisplayType.OHLC);
			}
		}
		series.setXAxis(xAxis);
		series.setYAxis(yAxis);
		series.setLowMemberPath("lowValue");
		series.setHighMemberPath("highValue");
		series.setOpenMemberPath("openValue");
		series.setCloseMemberPath("closeValue");
		series.setVolumeMemberPath("volumeValue");
		
		series.setDataSource(testData);
		series.setTitle("Price");
		series.setIsTransitionInEnabled(true);
		series.setTransitionInDuration(_defaultTransitionInDuration);
		series.setThickness(TypedValue.COMPLEX_UNIT_DIP, 1);
		series.setAreaFillOpacity(.7);
		
		final Activity activity = context;
		ChartToolTipAdapter tip = new ChartToolTipAdapter(context) {
			@Override
			public View getView(ChartDataContext chartContext, View existingView, CustomContentUpdateInfo updateInfo) {
				LinearLayout lin;
				TextView open;
				TextView high;
				TextView low;
				TextView close;
				if (existingView == null) {
					lin = new LinearLayout(activity);
					lin.setOrientation(LinearLayout.VERTICAL);
					existingView = lin;
					open = new TextView(activity);
					high = new TextView(activity);
					low = new TextView(activity);
					close = new TextView(activity);
                    open.setTextColor(Color.GRAY);
                    high.setTextColor(Color.GRAY);
                    low.setTextColor(Color.GRAY);
                    close.setTextColor(Color.GRAY);
					lin.addView(open);
					lin.addView(high);
					lin.addView(low);
					lin.addView(close);
				}
				else {
					lin = (LinearLayout)existingView;
					open = (TextView)lin.getChildAt(0);
					high = (TextView)lin.getChildAt(1);
					low = (TextView)lin.getChildAt(2);
					close = (TextView)lin.getChildAt(3);
				}

				FinancialDataItem it = (FinancialDataItem)chartContext.getItem();
				if (it != null) {
					String openString = new DecimalFormat("#.00").format(it.openValue);
					if (openString == null) {
						openString = "NaN";
					}
					open.setText("O: " + openString);
					
					String highString = new DecimalFormat("#.00").format(it.highValue);
					if (highString == null) {
						highString = "NaN";
					}
					high.setText("H: " + highString);
					
					String lowString = new DecimalFormat("#.00").format(it.lowValue);
					if (lowString == null) {
						lowString = "NaN";
					}
					low.setText("L: " + lowString);
					
					String closeString = new DecimalFormat("#.00").format(it.closeValue);
					if (closeString == null) {
						closeString = "NaN";
					}
					close.setText("C: " + closeString);
				}
				
				return existingView;
			}
		};
		
		series.setToolTip(tip);

		return series;
	}
	
	private int _defaultTransitionInDuration = 1000;

	@Override
	protected String getDescription() {
		return "This sample demonstrates the Financial Series with live data.";
	}
	
}
