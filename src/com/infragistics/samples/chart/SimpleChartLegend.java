package com.infragistics.samples.chart;

import java.util.List;

import com.infragistics.controls.*;
import com.infragistics.graphics.Brush;
import com.infragistics.graphics.GradientStop;
import com.infragistics.graphics.LinearGradientBrush;
import com.infragistics.graphics.SolidColorBrush;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class SimpleChartLegend 
	extends FrameLayout {

	private DataChartView _view;
	private LinearLayout _lin;
	
	private Context _context;
	
	public SimpleChartLegend(Context context, DataChartView view) {
		super(context);
		
		_context = context;
		_lin = new LinearLayout(context);
		_lin.setOrientation(LinearLayout.VERTICAL);
		_view = view;
		this.addView(_lin);
		
		UpdateItems();
	}
	
	@SuppressLint("NewApi")
	public void UpdateItems() {
		if (_view == null) {
			return;
		}
		
		_lin.removeAllViews();
		
		for (int i = 0; i < _view.getSeriesCount(); i++) {
			Series currSeries = _view.getSeriesAt(i);
			if (currSeries.getIsAnnotationLayer()) {
				continue;
			}
			
			Brush seriesBrush = currSeries.getActualBrush();
			int seriesColor = Color.BLACK;
			
			if (seriesBrush instanceof SolidColorBrush) {
				seriesColor = ((SolidColorBrush)seriesBrush).getColor();
			} else if (seriesBrush != null) {
				List<GradientStop> stops = ((LinearGradientBrush)seriesBrush).getGradientStops();
				if (stops != null && stops.size() > 0) {
					seriesColor = stops.get(0).getColor();
				}
			}
			
			
			String seriesTitle = "Series Title";
			if (currSeries.getTitle() != null) {
				seriesTitle = currSeries.getTitle().toString();
			}
			
			LinearLayout item = new LinearLayout(_context);
			item.setOrientation(LinearLayout.HORIZONTAL);
			
			FrameLayout badge = new FrameLayout(_context);
			
			GradientDrawable gd = new GradientDrawable();
			gd.setColor(seriesColor);
			LinearLayout.LayoutParams pm = new LinearLayout.LayoutParams(30, 30);
			pm.gravity = Gravity.CENTER_VERTICAL;
			badge.setPadding(4, 4, 4, 4);
			badge.setLayoutParams(pm);
			
			if (android.os.Build.VERSION.SDK_INT >= 16) {
				badge.setBackground(gd);
			} else {
				badge.setBackgroundDrawable(gd);
			}
			
			item.addView(badge);
			
			int paddingAmount = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 
					5, getResources().getDisplayMetrics());
			TextView titleText = new TextView(_context);
			titleText.setText(seriesTitle);
			//titleText.setBackgroundColor(Color.GRAY);
			LinearLayout.LayoutParams pm2 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			pm2.topMargin = paddingAmount;
			pm2.leftMargin = paddingAmount;
			pm2.rightMargin = paddingAmount;
			pm2.bottomMargin = paddingAmount;
			pm2.weight = 1;
			titleText.setLayoutParams(pm2);
			titleText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
			
			item.addView(titleText);
			
			_lin.addView(item);
		}
	}

	
}
