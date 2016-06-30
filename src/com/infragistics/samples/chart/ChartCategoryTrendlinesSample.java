package com.infragistics.samples.chart;

import com.infragistics.controls.*;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ChartCategoryTrendlinesSample extends ChartCategoryHorizontalSeriesSample {

    public ChartCategoryTrendlinesSample(Activity activity, SampleInfo info,
                                         boolean useLegend, boolean smallData) {
        super(activity, info, useLegend, smallData);

        final ColumnSeries s1 = (ColumnSeries) chart.getSeriesAt(0);
        final ColumnSeries s2 = (ColumnSeries) chart.getSeriesAt(1);
        s1.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
        s2.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 2);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(450, 70);
        TextView textView1 = new TextView(context);
		textView1.setLayoutParams(params);
		textView1.setText("Select Trendline Type:");
		textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        Spinner spinner = new Spinner(context);
        ArrayAdapter adapter = new ArrayAdapter<TrendLineType>(context, android.R.layout.simple_spinner_item, TrendLineType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(2);
        spinner.setPrompt("Select TrendLineType");
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int pos, long arg3) {
                TrendLineType trendlineType = TrendLineType.values()[pos];
                s1.setTrendLineType(trendlineType);
                s2.setTrendLineType(trendlineType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                s1.setTrendLineType(TrendLineType.NONE);
                s2.setTrendLineType(TrendLineType.NONE);
            }

        });

        this.sampleOptions.addView(textView1);
        this.sampleOptions.addView(spinner);
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates various Trend lines available in the Data Chart. They can be used to show trends in stock prices.";
    }
}
