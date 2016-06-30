package com.infragistics.samples.chart;

import com.infragistics.controls.*;
import com.infragistics.data.FinancialDataSample;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.util.TypedValue;

public class ChartFinancialIndicatorSample extends SampleChart {

    public ChartFinancialIndicatorSample(Activity activity, SampleInfo info, boolean useLegend) {
        super(activity, info, useLegend);

        FinancialDataSample testData = new FinancialDataSample();

        CategoryXAxis xAxis = new CategoryXAxis();
        xAxis.setUseClusteringMode(true);
        xAxis.setDataSource(testData);
        xAxis.setLabel("label");
        xAxis.setTitle("Date");
        xAxis.setLabelAngle(90);

        NumericYAxis yAxis = new NumericYAxis();
        yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());

        chart.addAxis(xAxis);
        chart.addAxis(yAxis);

        BollingerBandsOverlay series = new BollingerBandsOverlay();

        series.setXAxis(xAxis);
        series.setYAxis(yAxis);
        series.setLowMemberPath("lowValue");
        series.setHighMemberPath("highValue");
        series.setOpenMemberPath("openValue");
        series.setCloseMemberPath("closeValue");
        series.setVolumeMemberPath("volumeValue");

        series.setDataSource(testData);
        series.setTitle("Bollinger Bands");
        series.setIsTransitionInEnabled(true);
        series.setTransitionInDuration(1000);
        series.setThickness(TypedValue.COMPLEX_UNIT_DIP, 1);
        series.setAreaFillOpacity(.7);

        chart.addSeries(series);
    }

    @Override
    protected String getDescription() {
        return "This sample shows the Bollinger Bands Overlay.";
    }
}
