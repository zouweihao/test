package com.infragistics.samples.chart;

import java.util.*;

import android.view.View;
import android.widget.*;
import com.infragistics.controls.*;
import com.infragistics.extensions.Brushes;
import com.infragistics.graphics.*;
import com.infragistics.data.FinancialDataSample;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;

public class ChartRadialSeriesSample extends SampleChart {

	public ChartRadialSeriesSample(Activity activity, final SampleInfo info, boolean useLegend) {
		super(activity, info, useLegend);

		List<?> testData = FinancialDataSample.GetCompanyFinances();
	 	
		SolidColorBrush gridColor = new SolidColorBrush();
		gridColor.setColor(Color.parseColor("#989EA3"));
		
		final CategoryAngleAxis angleAxis = new CategoryAngleAxis();
		angleAxis.setDataSource(testData);
		angleAxis.setMajorStroke(gridColor);
		angleAxis.setLabel("label");
		angleAxis.setCrossingValue(50);
		//angleAxis.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 40);
		
		NumericRadiusAxis radiusAxis = new NumericRadiusAxis();
		radiusAxis.setCrossingValue(0.0);
		radiusAxis.setInnerRadiusExtentScale(0.1);
		radiusAxis.setRadiusExtentScale(0.8);
		radiusAxis.setMinimumValue(0);
		radiusAxis.setMaximumValue(100);
		radiusAxis.setInterval(25);
		radiusAxis.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 30);
		radiusAxis.setLabelVerticalAlignment(VerticalAlignment.CENTER);
		radiusAxis.setLabelLocation(AxisLabelsLocation.INSIDE_BOTTOM);
	
		SolidColorBrush brush = new SolidColorBrush();
		brush.setColor(Color.parseColor("#7f7f7f"));
		radiusAxis.setLabelTextColor(brush);
			
		radiusAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		chart.addAxis(angleAxis);
		chart.addAxis(radiusAxis);
 	 
		AnchoredRadialSeries series1 = GetRadialSeries(angleAxis, radiusAxis, info.seriesClass, testData);
		AnchoredRadialSeries series2 = GetRadialSeries(angleAxis, radiusAxis, info.seriesClass, testData);
	
		series1.setValueMemberPath("spendingValue");
		series2.setValueMemberPath("budgetValue");
		series1.setTitle("Spending");
		series2.setTitle("Budget");
		
		chart.addSeries(series1);
		chart.addSeries(series2);
		
		chart.setTitle("Company Finances");
		chart.setRightMargin(TypedValue.COMPLEX_UNIT_DIP, 10);
		chart.setLeftMargin(TypedValue.COMPLEX_UNIT_DIP, 25);

        //Intervals
        final CheckBox toggleAAMinorInterval = new CheckBox(context);
        final CheckBox toggleAAMajorInterval = new CheckBox(context);

        final NumericValueEditor aAMajorIntervalThicknessSlider = new NumericValueEditor("MajorIntervalThickness:", context);
        final NumericValueEditor aAMinorIntervalThicknessSlider = new NumericValueEditor("MinorIntervalThickness:", context);
        final NumericValueEditor aAMinorIntervalSlider = new NumericValueEditor("MinorIntervalValue:", context);

        toggleAAMajorInterval.setText("Toggle Major Interval on CategoryAngleAxis:                                     ");
        toggleAAMajorInterval.setChecked(false);

        toggleAAMajorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!toggleAAMajorInterval.isChecked()) {
                    angleAxis.setMajorStroke(Brushes.Transparent);
                }
                else if(toggleAAMajorInterval.isChecked())
                {
                    angleAxis.setMajorStroke(Brushes.Green);
                }
            }
        });

        toggleAAMinorInterval.setText("Toggle Minor Interval on CategoryAngleAxis: ");
        toggleAAMinorInterval.setChecked(false);

        toggleAAMinorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!toggleAAMinorInterval.isChecked()) {
                    angleAxis.setMinorStroke(Brushes.Transparent);
                }
                else if(toggleAAMinorInterval.isChecked())
                {
                    angleAxis.setMinorStroke(Brushes.Red);
                }
            }
        });

        //RadiusAxis Interval Sliders
        aAMajorIntervalThicknessSlider.SeekBar.setMax(10);
        aAMajorIntervalThicknessSlider.SeekBar.setProgress(1);
        aAMajorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                angleAxis.setMajorStrokeThickness(progress);
                aAMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: " + Integer.toString(progress));
            }
        });
        aAMinorIntervalThicknessSlider.SeekBar.setMax(10);
        aAMinorIntervalThicknessSlider.SeekBar.setProgress(1);
        aAMinorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                angleAxis.setMinorStrokeThickness(progress);
                aAMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: " + Integer.toString(progress));
            }
        });
        aAMinorIntervalSlider.SeekBar.setMax(25);
        aAMinorIntervalSlider.SeekBar.setProgress(1);
        aAMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        angleAxis.setMinorInterval(progress);
        aAMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + Integer.toString(progress));
            }
        });

        aAMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: ");
        aAMinorIntervalSlider.TextView.setText("MinorIntervalValue: ");
        //</editor-fold>

        //RangeChangedEvent

        //<editor-fold desc="Set StartAngleOffset - aAStartAngleSlider">
        //StartAngleOffset
        final NumericValueEditor aAStartAngleSlider = new NumericValueEditor("StartAngle: ", context);
        aAStartAngleSlider.SeekBar.setMax(360);
        aAStartAngleSlider.SeekBar.setProgress(0);
        aAStartAngleSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                angleAxis.setStartAngleOffset(progress);
                aAStartAngleSlider.TextView.setText("StartAngle: " + Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //</editor-fold>

        //Option Layouts
        final LinearLayout sampleSubOptions = new LinearLayout(context);
        sampleSubOptions.setOrientation(LinearLayout.VERTICAL);

        //<editor-fold desc="Properties Spinner">
        //Properties Spinner
        final Spinner angleAxisPropSpinner = new Spinner(context);
        TextView propertiesSetLbl = new TextView(context);
        propertiesSetLbl.setText("CategoryAngleAxis Property Set: ");

        List<String> propertiesList = new ArrayList<String>();
        propertiesList.add("AngleOffset");
        propertiesList.add("Intervals");

        ArrayAdapter propAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, propertiesList);
        propAdapter.setDropDownViewResource(android.R.layout.simple_gallery_item);

        angleAxisPropSpinner.setAdapter(propAdapter);
        angleAxisPropSpinner.setSelection(0);
        //</editor-fold>

        angleAxisPropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(angleAxisPropSpinner.getSelectedItemPosition()){
                    case 0:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(aAStartAngleSlider.Layout);
                        break;
                    }
                    case 1:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(toggleAAMajorInterval);
                        sampleSubOptions.addView(aAMajorIntervalThicknessSlider.Layout);

                        break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sampleOptions.addView(angleAxisPropSpinner);
        sampleOptions.addView(sampleSubOptions);

	}
	private AnchoredRadialSeries GetRadialSeries(CategoryAngleAxis angleAxis, NumericRadiusAxis radiusAxis, Class<?> SampleType, List<?> testData){
		
		AnchoredRadialSeries series;
		try {
			series = (AnchoredRadialSeries)SampleType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	 
		series.setAngleAxis(angleAxis);
		series.setValueAxis(radiusAxis);
		series.setValueMemberPath("spendingValue");
		series.setDataSource(testData);
		series.setTitle("Spending");
		series.setIsHighlightingEnabled(true);
		series.setThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
		series.setAreaFillOpacity(.7);
		series.setAreaFillOpacity(0.5);
		
		String SampleTypeName = SampleType.toString().toLowerCase();
		
		if (SampleTypeName.contains("radiallineseries") ||
			SampleTypeName.contains("radialareaseries"))
		{	
			series.setMarkerType(MarkerType.CIRCLE);
		}
		else
		{	
			series.setMarkerType(MarkerType.NONE);
		}
		
		return series;
	}

    @Override
    protected String getDescription() {
        return "This sample demonstrates the Radial Series in the chart. Among the main features that can be configured on the Radial Series are labels' and title's color, margins, extent and font properties, start angle, major and minor grid lines' intervals, colors and thickness, stripe's color and thickness, minimum and maximum values for the axes, radius extent of the axes, logarithmic along with linear axis scale, angle offset, highlighting, zooming, legend, markers, etc.";
    }
}
