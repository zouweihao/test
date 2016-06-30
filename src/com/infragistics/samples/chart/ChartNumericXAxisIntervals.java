package com.infragistics.samples.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.*;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.*;
import com.infragistics.controls.*;
import com.infragistics.data.*;
import com.infragistics.extensions.Brushes;
import com.infragistics.extensions.Colors;
import com.infragistics.graphics.*;
import com.infragistics.graphics.GradientStop;
import com.infragistics.graphics.LinearGradientBrush;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleInfo;

import java.text.DecimalFormat;
import java.util.List;
import com.infragistics.controls.*;
import com.infragistics.data.ScatterDataSample;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleInfo;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

public class ChartNumericXAxisIntervals extends SampleLayout {

    private int _defaultTransitionInDuration = 1000;

    public ChartNumericXAxisIntervals(Activity activity, SampleInfo info, boolean useLegend, boolean smallData) {
        super(activity);

        //Main layout
        final LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        //Axis interval interaction layouts
        LinearLayout selectedAxisLayout = new LinearLayout(context);
        selectedAxisLayout.setOrientation(LinearLayout.HORIZONTAL);

        final LinearLayout intervalsLayout = new LinearLayout(context);
        intervalsLayout.setOrientation(LinearLayout.HORIZONTAL);

        final LinearLayout xIntervalsLayout = new LinearLayout(context);
        xIntervalsLayout.setOrientation(LinearLayout.VERTICAL);

        final LinearLayout yIntervalsLayout = new LinearLayout(context);
        yIntervalsLayout.setOrientation(LinearLayout.VERTICAL);

        //Chart and Legend layout
        FrameLayout chartLayout = new FrameLayout(context);

        //Interval interaction controls
        TextView axisSpinnerLabel = new TextView(context);
        final Spinner spinner1 = new Spinner(context);

        final CheckBox toggleXMajorInterval = new CheckBox(context);
        final CheckBox toggleYMinorInterval = new CheckBox(context);
        final CheckBox toggleYMajorInterval = new CheckBox(context);
        final CheckBox toggleXMinorInterval = new CheckBox(context);

        final NumericValueEditor xMajorIntervalThicknessSlider = new NumericValueEditor("MajorIntervalThickness:", context);
        final NumericValueEditor xMinorIntervalThicknessSlider = new NumericValueEditor("MinorIntervalThickness:", context);
        final NumericValueEditor xMinorIntervalSlider = new NumericValueEditor("MinorIntervalValue:   ", context);
        final NumericValueEditor yMajorIntervalThicknessSlider = new NumericValueEditor("MajorIntervalThickness:", context);
        final NumericValueEditor yMinorIntervalThicknessSlider = new NumericValueEditor("MinorIntervalThickness:", context);
        final NumericValueEditor yMinorIntervalSlider = new NumericValueEditor("MinorIntervalValue:", context);

        //Chart
        DataChartView chart = new DataChartView(context);

        //Axes
        final NumericXAxis xAxis = new NumericXAxis();
        final NumericYAxis yAxis = new NumericYAxis();

        //Legend
        LegendView legend = new LegendView(context);

        List<?> testData1;
        List<?> testData2;
        List<?> testData3;

        testData1 = WeatherDataSample.GetWeatherDataX(WeatherDataSample.TempRange.High, 25);
        testData2 = WeatherDataSample.GetWeatherDataX(WeatherDataSample.TempRange.Low, 25);
        testData3 = WeatherDataSample.GetWeatherDataX(WeatherDataSample.TempRange.Average, 25);

        //Setup Series
        ScatterSplineSeries series1 = CreateScatterLineSeries(xAxis, yAxis, testData1);
        ScatterSplineSeries series2 = CreateScatterLineSeries(xAxis, yAxis, testData2);
        ScatterSplineSeries series3 = CreateScatterLineSeries(xAxis, yAxis, testData3);

        series1.setBrush(Brushes.Blue);
        series2.setBrush(Brushes.Gray);
        series3.setBrush(Brushes.Black);

        series1.setThickness(2);
        series2.setThickness(2);
        series3.setThickness(2);

        //Setup Legend
        legend.setPadding(5, 5, 15, 0);
        legend.setBackgroundColor(Color.WHITE);
        chart.setLegend(legend);

        FrameLayout.LayoutParams legendLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        legendLayoutParams.gravity = Gravity.RIGHT;

        legend.setLayoutParams(legendLayoutParams);

        //Set titles and labels
        xAxis.setTitle("Days in Study");
        yAxis.setTitle("Temperature");
        chart.setTitle("Temperature Report");

        series1.setTitle("High");
        series2.setTitle("Low");
        series3.setTitle("Average");

        xAxis.setLabel("label");

        xAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
        yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());

        xAxis.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 30);

        //Setup Intervals on xAxis
        xAxis.setMajorStroke(Brushes.Green);
        xAxis.setMinorStroke(Brushes.Red);

        xAxis.setMajorStrokeThickness(1);
        xAxis.setMinorStrokeThickness(1);

        xAxis.setInterval(5);
        xAxis.setMinorInterval(2.5);

        //Setup Intervals on yAxis
        yAxis.setMajorStroke(Brushes.Green);
        yAxis.setMinorStroke(Brushes.Red);

        yAxis.setMajorStrokeThickness(1);
        yAxis.setMinorStrokeThickness(1);

        yAxis.setInterval(10);
        yAxis.setMinorInterval(5);

        //Setup Chart
        chart.setHorizontalZoomable(true);
        chart.setVerticalZoomable(true);
        chart.setBackgroundColor(Color.WHITE);

        chart.addAxis(xAxis);
        chart.addAxis(yAxis);

        chart.addSeries(series1);
        chart.addSeries(series2);
        chart.addSeries(series3);

        int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,height);
        params.gravity = Gravity.CENTER;

        chart.setLayoutParams(params);

        //Setup Selected Axis Spinner and label
        List<String> list = new ArrayList<String>();
        list.add("X Axis");
        list.add("Y Axis");

        ArrayAdapter adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_gallery_item);

        axisSpinnerLabel.setText("Selected Axis: ");
        axisSpinnerLabel.setPadding(5, 0, 10, 0);

        spinner1.setAdapter(adapter1);
        spinner1.setSelection(0);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner1.getSelectedItemPosition() == 0)
                {
                    intervalsLayout.removeViewAt(0);
                    intervalsLayout.addView(xIntervalsLayout);
                }
                //if Y Axis is selected
                else if(spinner1.getSelectedItemPosition() == 1)
                {
                    intervalsLayout.removeViewAt(0);
                    intervalsLayout.addView(yIntervalsLayout);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Setup Interval Toggle Buttons
        toggleXMajorInterval.setText("Toggle Major Interval on  X Axis                                     ");
        toggleXMajorInterval.setChecked(true);

        toggleXMajorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!toggleXMajorInterval.isChecked()) {
                    xAxis.setMajorStroke(Brushes.Transparent);
                }
                else if(toggleXMajorInterval.isChecked())
                {
                    xAxis.setMajorStroke(Brushes.Green);
                }
            }
        });

        toggleYMajorInterval.setText("Toggle Major Interval on  Y Axis                                     ");
        toggleYMajorInterval.setChecked(true);

        toggleYMajorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!toggleYMajorInterval.isChecked()) {
                    yAxis.setMajorStroke(Brushes.Transparent);
                }
                else if(toggleYMajorInterval.isChecked())
                {
                    yAxis.setMajorStroke(Brushes.Green);
                }
            }
        });

        toggleYMinorInterval.setText("Toggle Minor Interval on  Y Axis");
        toggleYMinorInterval.setChecked(true);

        toggleYMinorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!toggleYMinorInterval.isChecked()) {
                    yAxis.setMinorStroke(Brushes.Transparent);
                }
                else if(toggleYMinorInterval.isChecked())
                {
                    yAxis.setMinorStroke(Brushes.Red);
                }
            }
        });

        toggleXMinorInterval.setText("Toggle Minor Interval on  X Axis");
        toggleXMinorInterval.setChecked(true);

        toggleXMinorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!toggleXMinorInterval.isChecked()) {
                    xAxis.setMinorStroke(Brushes.Transparent);
                }
                else if(toggleXMinorInterval.isChecked())
                {
                    xAxis.setMinorStroke(Brushes.Red);
                }
            }
        });

        //X Interval Sliders
        xMajorIntervalThicknessSlider.SeekBar.setMax(10);
        xMajorIntervalThicknessSlider.SeekBar.setProgress(1);

        xMajorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                xAxis.setMajorStrokeThickness(progress);
                xMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: " + Integer.toString(progress));
            }
        });
        xMinorIntervalThicknessSlider.SeekBar.setMax(10);
        xMinorIntervalThicknessSlider.SeekBar.setProgress(1);
        xMinorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                xAxis.setMinorStrokeThickness(progress);
                xMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: " + Integer.toString(progress));
            }
        });
        xMinorIntervalSlider.SeekBar.setMax(10);
        xMinorIntervalSlider.SeekBar.setProgress(10);
        xMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                xAxis.setMinorInterval(progress * 0.25);
                xMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + Double.toString(progress * 0.25));
            }
        });

        //Y Interval Sliders
        yMajorIntervalThicknessSlider.SeekBar.setMax(10);
        yMajorIntervalThicknessSlider.SeekBar.setProgress(1);
        yMajorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yAxis.setMajorStrokeThickness(progress);
                yMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: " + Integer.toString(progress));
            }
        });
        yMinorIntervalThicknessSlider.SeekBar.setMax(10);
        yMinorIntervalThicknessSlider.SeekBar.setProgress(1);
        yMinorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yAxis.setMinorStrokeThickness(progress);
                yMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: " + Integer.toString(progress));
            }
        });
        yMinorIntervalSlider.SeekBar.setMax(10);
        yMinorIntervalSlider.SeekBar.setProgress(1);
        yMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yAxis.setMinorInterval(progress);
                yMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + Integer.toString(progress));
            }
        });

        //Set initial text on interval sliders
        xMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: 1");
        xMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: 1");
        xMinorIntervalSlider.TextView.setText("MinorIntervalValue: 2.5");

        yMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: 1");
        yMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: 1");
        yMinorIntervalSlider.TextView.setText("MinorIntervalValue: 5");

        //Assign controls to appropriate layout
        selectedAxisLayout.addView(axisSpinnerLabel);
        selectedAxisLayout.addView(spinner1);

        xIntervalsLayout.addView(toggleXMajorInterval);
        xIntervalsLayout.addView(toggleXMinorInterval);
        xIntervalsLayout.addView(xMajorIntervalThicknessSlider.Layout);
        xIntervalsLayout.addView(xMinorIntervalThicknessSlider.Layout);
        xIntervalsLayout.addView(xMinorIntervalSlider.Layout);

        yIntervalsLayout.addView(toggleYMajorInterval);
        yIntervalsLayout.addView(toggleYMinorInterval);
        yIntervalsLayout.addView(yMajorIntervalThicknessSlider.Layout);
        yIntervalsLayout.addView(yMinorIntervalThicknessSlider.Layout);
        yIntervalsLayout.addView(yMinorIntervalSlider.Layout);

        intervalsLayout.addView(xIntervalsLayout);

        layout.addView(selectedAxisLayout);
        layout.addView(intervalsLayout);
        chartLayout.addView(chart);
        chartLayout.addView(legend);

        layout.addView(chartLayout);

        this.addView(layout);
    }

    private  ScatterSplineSeries CreateScatterLineSeries(NumericXAxis xAxis, NumericYAxis yAxis, List<?> data)
    {
    	ScatterSplineSeries series = new ScatterSplineSeries();
        

        
        LinearGradientBrush coalBrush = new LinearGradientBrush();

        coalBrush.setUseCustomDirection(true);
        coalBrush.setStartX(0.5);
        coalBrush.setStartY(0);

        coalBrush.setEndX(0.5);
        coalBrush.setEndY(1);
       
        GradientStop coalStop1 = new GradientStop();
        coalStop1.setOffset(0);
        coalStop1.setColor(Color.argb(255, 51,57, 64));

        GradientStop coalStop2 = new GradientStop();
        coalStop2.setOffset(1);
        coalStop2.setColor(Color.TRANSPARENT);

        coalBrush.getGradientStops().add(coalStop1);
        coalBrush.getGradientStops().add(coalStop2);

        series.setXAxis(xAxis);
        series.setYAxis(yAxis);
     
        series.setBrush(coalBrush); 
        series.setXMemberPath("x");
        series.setYMemberPath("y");
        series.setIsHighlightingEnabled(true);
        series.setTransitionInDuration(_defaultTransitionInDuration);
        series.setDataSource(data);

        return series;
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates the use of Major and Minor Axis Intervals on the ScatterLineSeries of the chart control.";
    }
}
