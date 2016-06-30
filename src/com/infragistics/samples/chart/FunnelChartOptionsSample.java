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

public class FunnelChartOptionsSample extends SampleLayout {

    public FunnelChartOptionsSample(Activity activity) {
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

        chart.setLayoutParams(sampleLayoutParams);

        final LinearLayout sampleSubOptions = new LinearLayout(context);
        sampleSubOptions.setOrientation(LinearLayout.VERTICAL);

        final PointF upperBezier = new PointF((float).25,(float).25);
        final PointF lowerBezier = new PointF((float).25,(float).25);

        LinearLayout invertChartLayout = new LinearLayout(context);
        invertChartLayout.setOrientation(LinearLayout.VERTICAL);
        //Invert Axes
        final ToggleEditor invertChart = new ToggleEditor("Invert Chart: ", context);
        invertChart.ToggleButton.setChecked(false);
        invertChart.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean invertChartVar = invertChart.ToggleButton.isChecked();
                chart.setIsInverted(invertChartVar);
                invalidate();
            }
        });

        final ToggleEditor useBezier = new ToggleEditor("Use Bezier Curve: ", context);
        useBezier.ToggleButton.setChecked(false);
        useBezier.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bezierVar = useBezier.ToggleButton.isChecked();
                chart.setUseBezierCurve(bezierVar);
                invalidate();
            }
        });

        final ToggleEditor weightedDisplay = new ToggleEditor("Weighted Slices: ", context);
        weightedDisplay.ToggleButton.setChecked(false);
        weightedDisplay.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean weightedVar = weightedDisplay.ToggleButton.isChecked();
                if (weightedVar == true) {
                    chart.setFunnelSliceDisplay(FunnelSliceDisplay.WEIGHTED);
                    invalidate();
                } else {
                    chart.setFunnelSliceDisplay(FunnelSliceDisplay.UNIFORM);
                    invalidate();
                }
            }
        });

        invertChartLayout.addView(invertChart.Layout);
        invertChartLayout.addView(useBezier.Layout);
        invertChartLayout.addView(weightedDisplay.Layout);

        this.sampleOptions.addView(invertChartLayout);
        this.sampleContainer.addView(chart);
        this.sampleContainer.setBackgroundColor(Color.WHITE);

    }

    @Override
    protected String getDescription() {
        return "A single series chart that displays data in a funnel shape with a variable number of sections each representing the data as different portions of 100%. The Funnel Chart can be configured to be inverted, to use Bezier Curve or weighted slices.";
    }

}
