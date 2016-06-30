package com.infragistics.samples.chart;

import android.graphics.PointF;
import android.view.ViewGroup;
import com.infragistics.controls.*;
import com.infragistics.data.CategoryDataPieSample;
import com.infragistics.data.FunnelDataSample;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleLayout;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.infragistics.samplesbrowser.ToggleEditor;

public class FunnelChartBezierSample extends SampleLayout {

    public FunnelChartBezierSample(Activity activity) {
        super(activity);

        FunnelDataSample data = new FunnelDataSample();

        final FunnelChartView chart = new FunnelChartView(context);
        chart.setBackgroundColor(Color.WHITE);
        chart.setDataSource(data);
        chart.setValueMemberPath("Value");
        chart.setUseOuterLabelsForLegend(true);
        chart.setInnerLabelMemberPath("Value");
        chart.setOuterLabelMemberPath("Label");
        chart.setAreOuterLabelsVisible(true);
        chart.setUseUnselectedStyle(true);
        chart.setAllowSliceSelection(false);
        chart.setUseBezierCurve(true);

        chart.setLayoutParams(sampleLayoutParams);

        final LinearLayout sampleSubOptions = new LinearLayout(context);
        sampleSubOptions.setOrientation(LinearLayout.VERTICAL);

        final com.infragistics.graphics.Point upperBezier = new com.infragistics.graphics.Point((float) .25, (float) .25);
        final com.infragistics.graphics.Point lowerBezier = new com.infragistics.graphics.Point((float) .25, (float) .25);

        LinearLayout invertChartLayout = new LinearLayout(context);
        invertChartLayout.setOrientation(LinearLayout.VERTICAL);

        NumericValueEditor editor2 = new NumericValueEditor("Upper Bezier X:", context);
        editor2.SeekBar.setMax(60);
        editor2.SeekBar.setProgress(25);
        editor2.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                float value = (float) progress / 100;
                upperBezier.setY(value);
                chart.setUpperBezierControlPoint(upperBezier);
                invalidate();
            }
        });

        NumericValueEditor editor3 = new NumericValueEditor("Upper Bezier Y:", context);
        editor3.SeekBar.setMax(100);
        editor3.SeekBar.setProgress(25);
        editor3.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                float value = (float) progress/100;
                upperBezier.setX(value);
                chart.setUpperBezierControlPoint(upperBezier);
                invalidate();
            }
        });

        NumericValueEditor editor4 = new NumericValueEditor("Lower Bezier X:", context);
        editor4.SeekBar.setMax(70);
        editor4.SeekBar.setProgress(65);
        editor4.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                float value = (float) progress/100;
                lowerBezier.setY(value);
                chart.setLowerBezierControlPoint(lowerBezier);
                invalidate();
            }
        });

        NumericValueEditor editor5 = new NumericValueEditor("Lower Bezier Y:", context);
        editor5.SeekBar.setMax(100);
        editor5.SeekBar.setProgress(40);
        editor5.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                float value = (float) progress / 100;
                lowerBezier.setX(value);
                chart.setLowerBezierControlPoint(lowerBezier);
                invalidate();
            }
        });

        invertChartLayout.addView(editor2.Layout);
        invertChartLayout.addView(editor3.Layout);
        invertChartLayout.addView(editor4.Layout);
        invertChartLayout.addView(editor5.Layout);

        this.sampleOptions.addView(invertChartLayout);
        this.sampleContainer.addView(chart);
        this.sampleContainer.setBackgroundColor(Color.WHITE);

    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates how to make the appearance of a Funnel Chart more appealing by using Bezier Curves for the shape of the chart and configuring its lower and upper X and Y points.";
    }
}