package com.infragistics.samples.chart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.infragistics.controls.*;
import com.infragistics.data.*;
import com.infragistics.extensions.Brushes;
import com.infragistics.extensions.Colors;
import com.infragistics.graphics.Brush;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.NumericIncrementEditor;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleInfo;
import com.infragistics.samplesbrowser.ToggleEditor;

import java.text.DecimalFormat;
import java.util.*;

public class StackedSeriesSample extends SampleChart {

	private int _defaultTransitionInDuration = 1000;

    //<editor-fold desc="GlobalVariables">
    private double globalGapVariable;
    public double getGlobalGapVariable() {
        return globalGapVariable;
    }

    public void setGlobalGapVariable(double value) {
        globalGapVariable = value;
    }
    //</editor-fold>

	public StackedSeriesSample(Activity activity, final SampleInfo info, boolean useLegend, boolean smallData) {
		super(activity, info, useLegend);

		List<?> testData;

		final CategoryXAxis xAxis = new CategoryXAxis();
		final NumericYAxis yAxis = new NumericYAxis();

        chart.setTitle("Budget");
        chart.setSubtitle("Company Budget Breakdown");

        testData = new StackData();

		xAxis.setDataSource(testData);
		xAxis.setLabel("Label");
		xAxis.setLabelAngle(45);

		yAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());

		chart.addAxis(xAxis);
		chart.addAxis(yAxis);

        final HorizontalStackedSeriesBase series;
        try {
            series = (HorizontalStackedSeriesBase)info.seriesClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        series.setDataSource(testData);

        StackedFragmentSeries c1 = new StackedFragmentSeries();
        c1.setValueMemberPath("Administration");
        c1.setTitle("Administration");

        StackedFragmentSeries c2 = new StackedFragmentSeries();
        c2.setValueMemberPath("Sales");
        c2.setTitle("Sales");

        StackedFragmentSeries c3 = new StackedFragmentSeries();
        c3.setValueMemberPath("IT");
        c3.setTitle("IT");

        StackedFragmentSeries c4 = new StackedFragmentSeries();
        c4.setValueMemberPath("Marketing");
        c4.setTitle("Marketing");

        StackedFragmentSeries c5 = new StackedFragmentSeries();
        c5.setValueMemberPath("Development");
        c5.setTitle("Development");

        StackedFragmentSeries c6 = new StackedFragmentSeries();
        c6.setValueMemberPath("Support");
        c6.setTitle("Support");

        StackedFragmentSeries c7 = new StackedFragmentSeries();
        c7.setValueMemberPath("HR");
        c7.setTitle("HR");

        series.addSeries(c1);
        series.addSeries(c2);
        series.addSeries(c3);
        series.addSeries(c4);
        series.addSeries(c5);
        series.addSeries(c6);
        series.addSeries(c7);

        series.setXAxis(xAxis);
        series.setYAxis(yAxis);

        chart.addSeries(series);

        globalGapVariable = 0.5;

        final DecimalFormat  roundToDecimal = new DecimalFormat("#.#");

        //Create layout for SubOptions
        final LinearLayout sampleSubOptions = new LinearLayout(context);
        sampleSubOptions.setOrientation(LinearLayout.VERTICAL);

        //<editor-fold desc="Invert axis options">
        //Invert Axes
        LinearLayout invertAxisLayout = new LinearLayout(context);
        invertAxisLayout.setOrientation(LinearLayout.VERTICAL);
        //Invert Axes
        final ToggleEditor invertXAxis = new ToggleEditor("Invert X-Axis: ", context);
        invertXAxis.ToggleButton.setChecked(false);
        invertXAxis.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean invertXAxisVar = invertXAxis.ToggleButton.isChecked() ? true : false;
                xAxis.setIsInverted(invertXAxisVar);
            }
        });
        invertAxisLayout.addView(invertXAxis.Layout);

        final ToggleEditor invertYAxis = new ToggleEditor("Invert Y-Axis: ", context);
        invertYAxis.ToggleButton.setChecked(false);
        invertYAxis.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean invertYAxisVar = invertYAxis.ToggleButton.isChecked() ? true : false;
                yAxis.setIsInverted(invertYAxisVar);
            }
        });
        invertAxisLayout.addView(invertYAxis.Layout);

        //</editor-fold>

        //<editor-fold desc="Set Gap on CategoryX and CategoryDateTimeXAxis">
        //Set Gap on CategoryX and CategoryDateTimeXAxis
        //Use sliders to Modify the Gap value
        final NumericIncrementEditor categoryGapEditor = new NumericIncrementEditor("Gap: 0.5", context);
        categoryGapEditor.DecrementButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(globalGapVariable > 0.1) {
                    globalGapVariable = globalGapVariable - 0.1;

                    xAxis.setGap(globalGapVariable);
                    categoryGapEditor.TextView.setText("Gap: " + Double.toString(Double.valueOf(roundToDecimal.format(globalGapVariable))));
                }
            }
        });
        categoryGapEditor.IncrementButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(globalGapVariable < 0.9) {
                    globalGapVariable = globalGapVariable + 0.1;

                    xAxis.setGap(globalGapVariable);
                    categoryGapEditor.TextView.setText("Gap: " + Double.toString(Double.valueOf(roundToDecimal.format(globalGapVariable))));
                }
            }
        });
        //</editor-fold>

        //<editor-fold desc="Set Min/Max values for NumericYAxis">
        //Set Min/Max values for NumericYAxis
        //Use sliders to Modify the NumericYAxis MinValue
        final NumericValueEditor minSlider = new NumericValueEditor("Y-Axis MinValue: ", context);
        minSlider.SeekBar.setMax(250);
        minSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yAxis.setMinimumValue(progress);
                minSlider.TextView.setText("Y-Axis MinValue: " + progress);
            }
        });

        //Use sliders to Modify the NumericYAxis MaxValue
        final NumericValueEditor maxSlider = new NumericValueEditor("Y-Axis MaxValue: ", context);
        maxSlider.SeekBar.setMax(250);
        maxSlider.SeekBar.setProgress(250);
        maxSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yAxis.setMaximumValue(progress);
                maxSlider.TextView.setText("Y-Axis MaxValue: " + progress);
            }
        });
        //</editor-fold>

        //<editor-fold desc="LogarithmicScale Interactions on NumericYAxis">
        //TODO Set LogarithmicScale on NumericYAxis
        //Use toggle for yAxis IsLogarithmic
        //Use slider to set LogarithmicBase
        final ToggleEditor yAxisIsLogarithmicToggle = new ToggleEditor("IsLogarithmic: ", context);
        final NumericValueEditor logarithmicBaseEditor = new NumericValueEditor("LogarithmBase: ", context);

        yAxisIsLogarithmicToggle.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!yAxisIsLogarithmicToggle.ToggleButton.isChecked()) {
                    yAxis.setIsLogarithmic(false);
                } else if (yAxisIsLogarithmicToggle.ToggleButton.isChecked()) {
                    yAxis.setIsLogarithmic(true);
                }
            }
        });

        logarithmicBaseEditor.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                yAxis.setLogarithmBase(progress);
                logarithmicBaseEditor.TextView.setText("LogarithmBase: " + Integer.toString(progress));
            }
        });
        final LinearLayout logarithmicOptionsLayout = new LinearLayout(context);
        logarithmicOptionsLayout.setOrientation(LinearLayout.VERTICAL);
        logarithmicOptionsLayout.addView(yAxisIsLogarithmicToggle.Layout);
        logarithmicOptionsLayout.addView(logarithmicBaseEditor.Layout);

        //</editor-fold>

        //<editor-fold desc="ZoomEnabled Toggle buttons to enable/disable zoom on chart">
        final LinearLayout zoomLayout = new LinearLayout(context);
        zoomLayout.setOrientation(LinearLayout.VERTICAL);

        final ToggleEditor verticalZoomTgl = new ToggleEditor("Vertical Zoom: ", context);
        verticalZoomTgl.ToggleButton.setChecked(true);
        verticalZoomTgl.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean verticalZoomEnabled = verticalZoomTgl.ToggleButton.isChecked() ? true : false;
                chart.setVerticalZoomable(verticalZoomEnabled);
            }
        });
        zoomLayout.addView(verticalZoomTgl.Layout);

        final ToggleEditor horizontalZoomTgl = new ToggleEditor("Horizontal Zoom: ", context);
        horizontalZoomTgl.ToggleButton.setChecked(true);

        horizontalZoomTgl.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean horizontalZoomEnabled = verticalZoomTgl.ToggleButton.isChecked() ? true : false;
                chart.setHorizontalZoomable(horizontalZoomEnabled);
            }
        });
        zoomLayout.addView(horizontalZoomTgl.Layout);

        //</editor-fold>

        //<editor-fold desc="MarkerType">
        //TODO Series Marker Properties, (MarkerType)
        //Use Spinner for MarkerType
        //MarkerType
        final Spinner markerTypeSpinner = new Spinner(context);
        TextView markerTypeLbl = new TextView(context);
        markerTypeLbl.setText("MarkerType: ");

        List<String> markerTypeList = new ArrayList<String>();
        markerTypeList.add("Automatic");
        markerTypeList.add("Circle");
        markerTypeList.add("Diamond");
        markerTypeList.add("Hexagon");
        markerTypeList.add("Hexagram");
        markerTypeList.add("Pentagon");
        markerTypeList.add("Pentagram");
        markerTypeList.add("Pyramid");
        markerTypeList.add("Square");
        markerTypeList.add("Tetragram");
        markerTypeList.add("Triangle");
        markerTypeList.add("Unset");
        markerTypeList.add("None");

        ArrayAdapter markerBrushAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, markerTypeList);
        markerBrushAdapter.setDropDownViewResource(android.R.layout.simple_gallery_item);

        markerTypeSpinner.setAdapter(markerBrushAdapter);
        markerTypeSpinner.setSelection(0);

        markerTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(markerTypeSpinner.getSelectedItemPosition()) {
                    case 0: {
                        series.setMarkerType(MarkerType.AUTOMATIC);
                        break;
                    }
                    case 1: {
                        series.setMarkerType(MarkerType.CIRCLE);
                        break;
                    }
                    case 2: {
                        series.setMarkerType(MarkerType.DIAMOND);
                        break;
                    }
                    case 3: {
                        series.setMarkerType(MarkerType.HEXAGON);
                        break;
                    }
                    case 4: {
                        series.setMarkerType(MarkerType.HEXAGRAM);
                        break;
                    }
                    case 5: {
                        series.setMarkerType(MarkerType.PENTAGON);
                        break;
                    }
                    case 6: {
                        series.setMarkerType(MarkerType.PENTAGRAM);
                        break;
                    }
                    case 7: {
                        series.setMarkerType(MarkerType.PYRAMID);
                        break;
                    }
                    case 8: {
                        series.setMarkerType(MarkerType.SQUARE);
                        break;
                    }
                    case 9: {
                        series.setMarkerType(MarkerType.TETRAGRAM);
                        break;
                    }
                    case 10: {
                        series.setMarkerType(MarkerType.TRIANGLE);
                        break;
                    }
                    case 11: {
                        series.setMarkerType(MarkerType.UNSET);
                        break;
                    }
                    case 12: {
                        series.setMarkerType(MarkerType.NONE);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final LinearLayout markerLayout = new LinearLayout(context);
        markerLayout.setOrientation(LinearLayout.HORIZONTAL);
        markerLayout.addView(markerTypeLbl);
        markerLayout.addView(markerTypeSpinner);
        //</editor-fold>

        //<editor-fold desc="Interval interaction controls">
        //TODO Intervals, IntervalValue, MinorIntervalValue, IntervalThickness, MinorIntervalThickness, IntervalBrush, MinorIntervalBrush
        //Interval interaction controls
        TextView axisSpinnerLabel = new TextView(context);
        final Spinner selectedAxisSpinner = new Spinner(context);

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

        //Axis interval interaction layouts
        LinearLayout selectedAxisLayout = new LinearLayout(context);
        selectedAxisLayout.setOrientation(LinearLayout.HORIZONTAL);

        final LinearLayout intervalsLayout = new LinearLayout(context);
        intervalsLayout.setOrientation(LinearLayout.HORIZONTAL);

        final LinearLayout xIntervalsLayout = new LinearLayout(context);
        xIntervalsLayout.setOrientation(LinearLayout.VERTICAL);

        final LinearLayout yIntervalsLayout = new LinearLayout(context);
        yIntervalsLayout.setOrientation(LinearLayout.VERTICAL);

        //Setup Interval Toggle Buttons
        toggleXMajorInterval.setText("Toggle Major Interval on  X Axis                                     ");
        toggleXMajorInterval.setChecked(false);

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
        toggleYMajorInterval.setChecked(false);

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
        toggleYMinorInterval.setChecked(false);

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
        toggleXMinorInterval.setChecked(false);

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
        xMinorIntervalSlider.SeekBar.setMax(100);
        xMinorIntervalSlider.SeekBar.setProgress(10);
        xMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress >= 0.1) {
                    xAxis.setMinorInterval(progress * 0.01);
                    xMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + new DecimalFormat("#.##").format(progress * 0.01));
                }
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
        yMinorIntervalSlider.SeekBar.setMax(25);
        yMinorIntervalSlider.SeekBar.setProgress(1);
        yMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress > 0) {
                    yAxis.setMinorInterval(progress);
                    yMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + Integer.toString(progress));
                }
            }
        });

        //Set initial text on interval sliders
        xMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: ");
        xMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: ");
        xMinorIntervalSlider.TextView.setText("MinorIntervalValue: ");

        yMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: ");
        yMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: ");
        yMinorIntervalSlider.TextView.setText("MinorIntervalValue: ");

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
        //</editor-fold>

        //<editor-fold desc="SeriesOutlineBrush, SeriesOutlineThickness">
        //TODO SeriesOutlineBrush, SeriesOutlineThickness
        //Use a dropdown for BrushSelection and Slider for the SeriesOutlineThickness
        final NumericValueEditor seriesOutlineThickness = new NumericValueEditor("SeriesOutlineThickness: ", context);
        seriesOutlineThickness.SeekBar.setMax(25);
        seriesOutlineThickness.SeekBar.setProgress(1);
        seriesOutlineThickness.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                series.setThickness(progress);
                seriesOutlineThickness.TextView.setText("OutlineThickness: " + Integer.toString(progress));
            }
        });

        //Series Outline Brush Spinner
        final Spinner seriesBrushSpinner = new Spinner(context);
        TextView seriesBrushLbl = new TextView(context);
        seriesBrushLbl.setText("SeriesOutlineBrush: ");

        List<String> seriesBrushList = new ArrayList<String>();
        seriesBrushList.add("DarkBlue");
        seriesBrushList.add("Blue");
        seriesBrushList.add("LightBlue");
        seriesBrushList.add("Green");
        seriesBrushList.add("DarkGold");
        seriesBrushList.add("Gold");
        seriesBrushList.add("Red");
        seriesBrushList.add("Black");
        seriesBrushList.add("Transparent");

        ArrayAdapter seriesBrushAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, seriesBrushList);
        seriesBrushAdapter.setDropDownViewResource(android.R.layout.simple_gallery_item);

        seriesBrushSpinner.setAdapter(seriesBrushAdapter);
        seriesBrushSpinner.setSelection(0);

        seriesBrushSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (seriesBrushSpinner.getSelectedItemPosition()) {
                    case 0: {
                        series.setOutline(Brushes.BlueDark);
                        break;
                    }
                    case 1: {
                        series.setOutline(Brushes.Blue);
                        break;
                    }
                    case 2: {
                        series.setOutline(Brushes.BlueLight);
                        break;
                    }
                    case 3: {
                        series.setOutline(Brushes.Green);
                        break;
                    }
                    case 4: {
                        series.setOutline(Brushes.GoldDark);
                        break;
                    }
                    case 5: {
                        series.setOutline(Brushes.Gold);
                        break;
                    }
                    case 6: {
                        series.setOutline(Brushes.Red);
                        break;
                    }
                    case 7: {
                        series.setOutline(Brushes.Black);
                        break;
                    }
                    case 8: {
                        series.setOutline(Brushes.Transparent);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final LinearLayout seriesBrushSelectorLayout = new LinearLayout(context);
        seriesBrushSelectorLayout.setOrientation(LinearLayout.HORIZONTAL);
        seriesBrushSelectorLayout.addView(seriesBrushLbl);
        seriesBrushSelectorLayout.addView(seriesBrushSpinner);
        //</editor-fold>

        //<editor-fold desc="Legend Visibility, ReverseLegendOrder">
        //TODO Legend Visibility, ReverseLegendOrder
        final ToggleEditor legendVisiblityTgl = new ToggleEditor("Legend Visibility: ", context);
        legendVisiblityTgl.ToggleButton.setChecked(true);
        legendVisiblityTgl.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean legendVisible = legendVisiblityTgl.ToggleButton.isChecked() ? true : false;
                if(legendVisible) legend.setVisibility(View.VISIBLE);
                else if(!legendVisible) legend.setVisibility(View.INVISIBLE);
            }
        });

        final ToggleEditor legendOrderReverseTgl = new ToggleEditor("ReverseLegendOrder: ", context);
        legendOrderReverseTgl.ToggleButton.setChecked(false);
        legendOrderReverseTgl.ToggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean legendReverseOrder = legendOrderReverseTgl.ToggleButton.isChecked() ? true : false;
                series.setReverseLegendOrder(legendReverseOrder);
            }
        });
        //</editor-fold>

        //<editor-fold desc="Properties Spinner">
        //Properties Spinner
        final Spinner propertiesSelectionSpinner = new Spinner(context);
        TextView propertiesSetLbl = new TextView(context);
        propertiesSetLbl.setText("Properties set: ");

        List<String> propertiesList = new ArrayList<String>();
        propertiesList.add("Axes");
        propertiesList.add("X Intervals");
        propertiesList.add("Y Intervals");
        propertiesList.add("Legend");
        propertiesList.add("Series Markers");
        propertiesList.add("Series Misc.");

        ArrayAdapter propAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, propertiesList);
        propAdapter.setDropDownViewResource(android.R.layout.simple_gallery_item);

        propertiesSelectionSpinner.setAdapter(propAdapter);
        propertiesSelectionSpinner.setSelection(0);
        //</editor-fold>

        //<editor-fold desc="Collect layouts for Axes Options">
        final LinearLayout axesOptions = new LinearLayout(context);
        axesOptions.setOrientation(LinearLayout.VERTICAL);

        axesOptions.addView(minSlider.Layout);
        axesOptions.addView(maxSlider.Layout);
        axesOptions.addView(categoryGapEditor.Layout);
        axesOptions.addView(invertAxisLayout);

        //Container for properties selection spinner
        final LinearLayout propertiesSetLayout = new LinearLayout(context);
        propertiesSetLayout.setOrientation(LinearLayout.HORIZONTAL);

        //Add properties selector to OptionsPane
        sampleOptions.addView(propertiesSetLayout);
        sampleOptions.addView(sampleSubOptions);

        propertiesSetLayout.addView(propertiesSetLbl);
        propertiesSetLayout.addView(propertiesSelectionSpinner);
        //</editor-fold>


        //<editor-fold desc="Properties Set Selection with OptionsLayout">
        propertiesSelectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(propertiesSelectionSpinner.getSelectedItemPosition()){
                    //Axes
                    case 0:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(axesOptions);

                        if((info.name == "Stacked Line Series" || info.name == "Stacked Area Series" || info.name == "Stacked Spline Series" || info.name == "Stacked Spline Area Series"
                                || info.name == "Stacked 100 Line Series" || info.name == "Stacked 100 Area Series" || info.name == "Stacked 100 Spline Series" || info.name == "Stacked Spline Area Series"))
                        {
                            axesOptions.removeViewAt(2);
                        }

                        break;
                    }
                    //X Intervals
                    case 1:
                    {
                        sampleSubOptions.removeAllViews();

                        toggleXMinorInterval.setEnabled(true);
                        xMinorIntervalThicknessSlider.SeekBar.setEnabled(true);
                        xMinorIntervalSlider.SeekBar.setEnabled(true);

                        if((info.name == "Stacked Area Series") || info.name == "Stacked Line Series" || info.name == "Stacked Spline Series" || info.name == "Stacked 100 Area Series" ||
                                info.name == "Stacked Spline Area Series" || info.name == "Stacked 100 Line Series" || info.name == "Stacked 100 Spline Series" || info.name == "Stacked 100 Spline Area Series")
                        {
                            toggleXMinorInterval.setEnabled(false);
                            xMinorIntervalThicknessSlider.SeekBar.setEnabled(false);
                            xMinorIntervalThicknessSlider.TextView.setEnabled(false);
                            xMinorIntervalSlider.SeekBar.setEnabled(false);
                            xMinorIntervalSlider.SeekBar.setEnabled(false);
                        }

                        sampleSubOptions.addView(xIntervalsLayout);
                        break;
                    }
                    //Y Intervals
                    case 2:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(yIntervalsLayout);
                        break;
                    }
                    //Legend
                    case 3:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(legendVisiblityTgl.Layout);
                        sampleSubOptions.addView(legendOrderReverseTgl.Layout);
                        break;
                    }
                    //Series Markers
                    case 4:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(markerLayout);
                        break;
                    }
                    //Series Misc.
                    case 5:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(logarithmicOptionsLayout);
                        sampleSubOptions.addView(zoomLayout);
                        break;
                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //</editor-fold>

		ChartToolTipAdapter tip = new ChartToolTipAdapter(context) {
			@SuppressLint("NewApi")
			@Override
			public View getView(ChartDataContext chartContext, View existingView, CustomContentUpdateInfo updateInfo) {
				TextView tv;
				LinearLayout lin = (LinearLayout)existingView;
				if (lin == null) {
					lin = new LinearLayout(context);
					lin.setBackgroundColor(Color.TRANSPARENT);
					existingView = lin;
					tv = new TextView(context);
					tv.setPadding(4, 4, 4, 4);
                    tv.setTextColor(Color.GRAY);
					
					GradientDrawable gd = new GradientDrawable();
					Brush brush = chartContext.getFragmentSeries().getActualBrush();
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

                StackedFragmentSeries series = chartContext.getFragmentSeries();
                StackDataItem it = (StackDataItem)chartContext.getItem();
                double value = Double.NaN;

                if (series.getValueMemberPath() == "Administration") {
                    value = it.getAdministration();
                }
                else if (series.getValueMemberPath() == "Sales") {
                    value = it.getSales();
                }
                else if (series.getValueMemberPath() == "IT") {
                    value = it.getIT();
                }
                else if (series.getValueMemberPath() == "Marketing") {
                    value = it.getMarketing();
                }
                else if (series.getValueMemberPath() == "Development") {
                    value = it.getDevelopment();
                }
                else if (series.getValueMemberPath() == "HR") {
                    value = it.getHR();
                }
                else if (series.getValueMemberPath() == "Support") {
                    value = it.getSupport();
                }

				if (it != null) {
					String val = new DecimalFormat("#.00").format(value);
					if (val == null) {
						val = "NaN";
					}
					tv.setText(val);
				}
				
				return existingView;
			}
		};

		c1.setToolTip(tip);
        c2.setToolTip(tip);
        c3.setToolTip(tip);
        c4.setToolTip(tip);
        c5.setToolTip(tip);
        c6.setToolTip(tip);
        c7.setToolTip(tip);

	}

    @Override
    protected String getDescription() {
        return "This sample shows the Stacked Series. Among the main features that can be configured on the Stacked Series are labels' and title's color, margins, extent and font properties, major and minor grid lines' intervals, colors and thickness, stripe's color and thickness, minimum and maximum values for the axes, logarithmic along with linear axis scale, highlighting, zooming, legend, markers, etc.";
    }
}
