package com.infragistics.samples.chart;

import java.text.DecimalFormat;
import java.util.*;

import android.view.View;
import android.widget.*;
import com.infragistics.controls.*;
import com.infragistics.data.ScatterDataSample;
import com.infragistics.extensions.Brushes;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.NumericIncrementEditor;
import com.infragistics.samplesbrowser.NumericValueEditor;
import com.infragistics.samplesbrowser.SampleInfo;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import com.infragistics.samplesbrowser.ToggleEditor;

public class ChartPolarSeriesSample extends SampleChart {

	//<editor-fold desc="GlobalVariables">
	private double globalRadiusExtentVariable;
	public double getREGlobalVarValue() {
		return globalRadiusExtentVariable;
	}

	public void setREGlobalVarValue(double value) {
		globalRadiusExtentVariable = value;
	}

	private double globalRadiusInnerExtentVariable;
	public double getRIEGlobalVarValue() {
		return globalRadiusInnerExtentVariable;
	}

	public void setRIEGlobalVarValue(double value) {
		globalRadiusInnerExtentVariable = value;
	}

	//</editor-fold>

	public ChartPolarSeriesSample(Activity activity, SampleInfo info, boolean useLegend) {
		super(activity, info, useLegend); 
		 
		List<?> testData1 = ScatterDataSample.GetWindData(3.0);  
		List<?> testData2 = ScatterDataSample.GetWindData(2.0); 
		List<?> testData3 = ScatterDataSample.GetWindData(1.0);  
		
		final NumericAngleAxis  angleAxis =  new NumericAngleAxis();
		final NumericRadiusAxis radiusAxis = new NumericRadiusAxis();
		
		radiusAxis.setCrossingAxis(angleAxis);
		radiusAxis.setInnerRadiusExtentScale(0.1);
		radiusAxis.setLabelExtent(TypedValue.COMPLEX_UNIT_DIP, 30);
		radiusAxis.setLabelVerticalAlignment(VerticalAlignment.CENTER);
		radiusAxis.setLabelLocation(AxisLabelsLocation.INSIDE_BOTTOM);
		radiusAxis.setMinimumValue(0);
		radiusAxis.setMaximumValue(100);
		radiusAxis.setInterval(50);
		
		SolidColorBrush brush = new SolidColorBrush();
		brush.setColor(Color.parseColor("#7f7f7f"));
		radiusAxis.setLabelTextColor(brush);
		
		angleAxis.setCrossingAxis(radiusAxis);
		angleAxis.setStartAngleOffset(-90);
		angleAxis.setInterval(45);
		angleAxis.setMinimumValue(0);
		angleAxis.setMaximumValue(360);
		angleAxis.setLabelTextColor(brush);
		
		angleAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		radiusAxis.setOnFormatLabelListener(new OnAxisNumericLabelListener());
		
		chart.addAxis(angleAxis);
		chart.addAxis(radiusAxis);
		
		PolarBase series1 = GetPolarSeries(angleAxis, radiusAxis, info.seriesClass, testData1);
		PolarBase series2 = GetPolarSeries(angleAxis, radiusAxis, info.seriesClass, testData2);
		PolarBase series3 = GetPolarSeries(angleAxis, radiusAxis, info.seriesClass, testData3);
		
		series1.setTitle("2012");
		series2.setTitle("2013");
		series3.setTitle("2014");

		chart.addSeries(series1);
		chart.addSeries(series2);
		chart.addSeries(series3);

		chart.setTitle("Wind Patterns");
		chart.setSubtitle("between 2012-2014 years");

        ///////////////////////////////////////////////////////////////////
		globalRadiusExtentVariable = 1;
		globalRadiusInnerExtentVariable = 1;

		final DecimalFormat  roundToDecimal = new DecimalFormat("#.#");

		//<editor-fold desc="NumericAngleAxis Property manipulations">
		//<editor-fold desc="AngleAxis Visibility - No property exposed yet***">
		//Setting visibility false on axis with major and minor stroke set should not display axis and gridlines
        ToggleEditor numericAngleAxisVisibilityTgl = new ToggleEditor("AxisVisibility: ", context);
        numericAngleAxisVisibilityTgl.ToggleButton.setChecked(true);
        numericAngleAxisVisibilityTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //No visibility property on Axis, (aside from labels and title)
            }
        });

        //Invert NumericAngleAxis, verify that labels are rendered correctly
        final ToggleEditor nAAInvertedTgl = new ToggleEditor("InvertAxis: ", context);
        nAAInvertedTgl.ToggleButton.setChecked(false);
        nAAInvertedTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean invertAxis = nAAInvertedTgl.ToggleButton.isChecked() ? true : false ;
                angleAxis.setIsInverted(invertAxis);
            }
        });
		//</editor-fold>

		//Manual Range, (min/max) and intervals, verify label positions
		//Use Sliders for Min/Max manipulation
		//Min slider angleAxisMinSlider
		//<editor-fold desc="Min slider angleAxisMinSlider">
		final NumericValueEditor angleAxisMinSlider = new NumericValueEditor("Angle-Axis Min: ", context);
		angleAxisMinSlider.SeekBar.setMax(360);
		angleAxisMinSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleAxis.setMinimumValue(progress);
				angleAxisMinSlider.TextView.setText("Angle-Axis Min: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		//</editor-fold>

		//Max slider angleMaxSlider
		//<editor-fold desc="Max slider angleMaxSlider">
		final NumericValueEditor angleAxisMaxSlider = new NumericValueEditor("Angle-Axis Max: ", context);
		angleAxisMaxSlider.SeekBar.setMax(360);
		angleAxisMaxSlider.SeekBar.setProgress(360);
		angleAxisMaxSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleAxis.setMaximumValue(progress);
				angleAxisMaxSlider.TextView.setText("Angle-Axis Max: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//Interval sliders for yAxis
		//<editor-fold desc="Interval interaction controls - toggleAngleAxisMinorInterval, toggleAngleAxisMajorInterval, angleAxisMajorIntervalThicknessSlider, angleAxisMinorIntervalThicknessSlider, angleAxisMinorIntervalSlider">
		final CheckBox toggleAngleAxisMinorInterval = new CheckBox(context);
		final CheckBox toggleAngleAxisMajorInterval = new CheckBox(context);

		final NumericValueEditor angleAxisMajorIntervalThicknessSlider = new NumericValueEditor("MajorIntervalThickness:", context);
		final NumericValueEditor angleAxisMinorIntervalThicknessSlider = new NumericValueEditor("MinorIntervalThickness:", context);
		final NumericValueEditor angleAxisMinorIntervalSlider = new NumericValueEditor("MinorIntervalValue:", context);

		toggleAngleAxisMajorInterval.setText("Toggle Major Interval on NumericAngleAxis:                                     ");
		toggleAngleAxisMajorInterval.setChecked(false);

		toggleAngleAxisMajorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(!toggleAngleAxisMajorInterval.isChecked()) {
					angleAxis.setMajorStroke(Brushes.Transparent);
				}
				else if(toggleAngleAxisMajorInterval.isChecked())
				{
					angleAxis.setMajorStroke(Brushes.Green);
				}
			}
		});

		toggleAngleAxisMinorInterval.setText("Toggle Minor Interval on NumericAngleAxis: ");
		toggleAngleAxisMinorInterval.setChecked(false);

		toggleAngleAxisMinorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(!toggleAngleAxisMinorInterval.isChecked()) {
					angleAxis.setMinorStroke(Brushes.Transparent);
				}
				else if(toggleAngleAxisMinorInterval.isChecked())
				{
					angleAxis.setMinorStroke(Brushes.Red);
				}
			}
		});

		//AngleAxis Interval Sliders
		angleAxisMajorIntervalThicknessSlider.SeekBar.setMax(10);
		angleAxisMajorIntervalThicknessSlider.SeekBar.setProgress(1);
		angleAxisMajorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleAxis.setMajorStrokeThickness(progress);
				angleAxisMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: " + Integer.toString(progress));
			}
		});
		angleAxisMinorIntervalThicknessSlider.SeekBar.setMax(10);
		angleAxisMinorIntervalThicknessSlider.SeekBar.setProgress(1);
		angleAxisMinorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleAxis.setMinorStrokeThickness(progress);
				angleAxisMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: " + Integer.toString(progress));
			}
		});
		angleAxisMinorIntervalSlider.SeekBar.setMax(25);
		angleAxisMinorIntervalSlider.SeekBar.setProgress(1);
		angleAxisMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if(progress > 0) {
					angleAxis.setMinorInterval(progress);
					angleAxisMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + Integer.toString(progress));
				}
			}
		});

		angleAxisMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: ");
		angleAxisMinorIntervalSlider.TextView.setText("MinorIntervalValue: ");
		//</editor-fold>

		//Logarithmic manipulations
		//<editor-fold desc="Logarithmic manipulations - angleAxisIsLogarithmicTgl, logarithmBaseSlider">
		//IsLogarithmicToggle
		final ToggleEditor angleAxisIsLogarithmicTgl = new ToggleEditor("IsLogarithmic: ", context);
		angleAxisIsLogarithmicTgl.ToggleButton.setChecked(false);
		angleAxisIsLogarithmicTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean isLogarithmicBool = angleAxisIsLogarithmicTgl.ToggleButton.isChecked() ? true : false;
				angleAxis.setIsLogarithmic(isLogarithmicBool);
			}
		});
		//SetLogarithmBaseSlider
		final NumericValueEditor logarithmBaseSlider = new NumericValueEditor("LogarithmBase: " + Integer.toString(angleAxis.getLogarithmBase()), context);
		logarithmBaseSlider.SeekBar.setMax(250);
		logarithmBaseSlider.SeekBar.setProgress(10);
		logarithmBaseSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleAxis.setLogarithmBase(progress);
				logarithmBaseSlider.TextView.setText("LogarithmBase: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//Set Zoom enabled on chart
		//Horizontal Zoom Enabled - horizontalZoomEnabled, verticalZoomEnabled
		//<editor-fold desc="Horizontal Zoom Enabled - horizontalZoomEnabled, verticalZoomEnabled">
		final ToggleEditor horizontalZoomEnabled = new ToggleEditor("HorizontalZoom: ", context);
		horizontalZoomEnabled.ToggleButton.setChecked(true);
		horizontalZoomEnabled.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Boolean horizontalZoomBool = horizontalZoomEnabled.ToggleButton.isChecked() ? true : false;
				chart.setHorizontalZoomable(horizontalZoomBool);
			}
		});

		//Vertical Zoom Enabled
		final ToggleEditor verticalZoomEnabled = new ToggleEditor("VerticalZoom: ", context);
		verticalZoomEnabled.ToggleButton.setChecked(true);
		verticalZoomEnabled.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Boolean verticalZoomBool = verticalZoomEnabled.ToggleButton.isChecked() ? true : false;
			}
		});
		//</editor-fold>

		//Manipulate StartAngleOffset
		//<editor-fold desc="StartAngleOffSet - startAngleSlider">
		//StartAngleOffsetSlider, verify that by modifying the start angle, the axis may be rotated by 90 degrees
		final NumericValueEditor startAngleSlider = new NumericValueEditor("StartAngle: ", context);
		startAngleSlider.SeekBar.setMax(360);
		startAngleSlider.SeekBar.setProgress(0);
		startAngleSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleAxis.setStartAngleOffset(progress);
				startAngleSlider.TextView.setText("StartAngle: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//</editor-fold>

		//<editor-fold desc="NumericRadiusAxis Property Manipulations">
		//NumericRadiusAxis
		//<editor-fold desc="Set MajorStrokeColor - radiusAxisApplyMajorStrokeTgl">
		//Set MajorStrokeColor
		final ToggleEditor rAApplyMajorStrokeTgl = new ToggleEditor("ApplyMajorStroke: ", context);
		rAApplyMajorStrokeTgl.ToggleButton.setChecked(false);
		rAApplyMajorStrokeTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean checked = rAApplyMajorStrokeTgl.ToggleButton.isChecked() ? true : false;
				if(checked) radiusAxis.setMajorStroke(Brushes.Green);
				else radiusAxis.setMajorStroke(Brushes.Transparent);
			}
		});
		//</editor-fold>

		//Set MinorStrokeColor
		//<editor-fold desc="Set MinorStrokeColor - radiusAxisApplyMinorStrokeTgl">
		final ToggleEditor rAApplyMinorStrokeTgl = new ToggleEditor("ApplyMinorStroke: ", context);
		rAApplyMinorStrokeTgl.ToggleButton.setChecked(false);
		rAApplyMinorStrokeTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean checked = rAApplyMinorStrokeTgl.ToggleButton.isChecked() ? true : false;
				if(checked) radiusAxis.setMinorStroke(Brushes.Red);
				else radiusAxis.setMinorStroke(Brushes.Transparent);
			}
		});
		//</editor-fold>

		//Set StrokeColor
		//<editor-fold desc="Set StrokeColor - radiusAxisApplyStrokeTgl">
		final ToggleEditor rAApplyStrokeTgl = new ToggleEditor("ApplyStroke: ", context);
		rAApplyStrokeTgl.ToggleButton.setChecked(false);
		rAApplyStrokeTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean checked = rAApplyStrokeTgl.ToggleButton.isChecked() ? true : false;
				if(checked) radiusAxis.setStroke(Brushes.Blue);
				else radiusAxis.setStroke(Brushes.Transparent);
			}
		});
		//</editor-fold>

		//Set MajorStrokeThickness
		//<editor-fold desc="Set MajorStrokeThickness - rAMajorStrokeThickness">
		final NumericValueEditor rAMajorStrokeThickness = new NumericValueEditor("MajorStrokeThickness: ", context);
		rAMajorStrokeThickness.SeekBar.setMax(25);
		rAMajorStrokeThickness.SeekBar.setProgress(2);
		rAMajorStrokeThickness.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setMajorStrokeThickness(progress);
				rAMajorStrokeThickness.TextView.setText("MajorStrokeThickness: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//Set MinorStrokeThickness
		//<editor-fold desc="Set MinorStrokeThickness - rAMinorStrokeThickness">
		final NumericValueEditor rAMinorStrokeThickness = new NumericValueEditor("MinorStrokeThickness: ", context);
		rAMinorStrokeThickness.SeekBar.setMax(25);
		rAMinorStrokeThickness.SeekBar.setProgress(1);
		rAMinorStrokeThickness.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setMinorStrokeThickness(progress);
				rAMinorStrokeThickness.TextView.setText("MinorStrokeThickness: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//Set StrokeThickness
		//<editor-fold desc="Set StrokeThickness - rAStrokeThickness">
		final NumericValueEditor rAStrokeThickness = new NumericValueEditor("StrokeThickness: ", context);
		rAStrokeThickness.SeekBar.setMax(25);
		rAStrokeThickness.SeekBar.setProgress(1);
		rAStrokeThickness.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setStrokeThickness(progress);
				rAStrokeThickness.TextView.setText("StrokeThickness: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//Set StripBrush
		//<editor-fold desc="Set Strip Brush - rAApplyStripBrushTgl">
		//Set Strip Brush
		final ToggleEditor rAApplyStripBrushTgl = new ToggleEditor("ApplyStripBrush: ", context);
		rAApplyStripBrushTgl.ToggleButton.setChecked(false);
		rAApplyStripBrushTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean checked = rAApplyStripBrushTgl.ToggleButton.isChecked() ? true : false;
				if(checked) radiusAxis.setStrip(Brushes.Blue);
				else radiusAxis.setStrip(Brushes.Transparent);
			}
		});
		//</editor-fold>

		//Invert NumericRadiusAxis
		//<editor-fold desc="Invert NumericRadiusAxis - nRAInvertedTgl">
		final ToggleEditor nRAInvertedTgl = new ToggleEditor("InvertRadiusAxis: ", context);
		nRAInvertedTgl.ToggleButton.setChecked(false);
		nRAInvertedTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean checked = nRAInvertedTgl.ToggleButton.isChecked() ? true : false;
				radiusAxis.setIsInverted(checked);
			}
		});
		//</editor-fold>

		//Set RadiusExtentScale
		//<editor-fold desc="Set RadiusExtentScale - rARadiusExtentScale">
		final NumericIncrementEditor radiusExtentScaleEditor = new NumericIncrementEditor("RadiusExtentScale: 0.8", context);
		globalRadiusExtentVariable = 0.8;
		radiusExtentScaleEditor.DecrementButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(globalRadiusExtentVariable > 0.1) {
					globalRadiusExtentVariable = globalRadiusExtentVariable - 0.1;

					radiusAxis.setRadiusExtentScale(globalRadiusExtentVariable);
					radiusExtentScaleEditor.TextView.setText("RadiusExtentScale: " + Double.toString(Double.valueOf(roundToDecimal.format(globalRadiusExtentVariable))));
				}
			}
		});
		radiusExtentScaleEditor.IncrementButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(globalRadiusExtentVariable < 1) {
					globalRadiusExtentVariable = globalRadiusExtentVariable + 0.1;

					radiusAxis.setRadiusExtentScale(globalRadiusExtentVariable);
					radiusExtentScaleEditor.TextView.setText("RadiusExtentScale: " + Double.toString(Double.valueOf(roundToDecimal.format(globalRadiusExtentVariable))));
				}
			}
		});
		//</editor-fold>

		//Set InnerRadiusExtentScale
		//<editor-fold desc="Set InnerRadiusExtentScale - rAInnerRadiusExtentScale">
		final NumericIncrementEditor radiusInnerExtentScaleEditor = new NumericIncrementEditor("RadiusInnerExtentScale: 0.1", context);
		globalRadiusInnerExtentVariable = 0.1;
		radiusInnerExtentScaleEditor.DecrementButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(globalRadiusInnerExtentVariable > 0.1) {
					globalRadiusInnerExtentVariable = globalRadiusInnerExtentVariable - 0.1;

					radiusAxis.setInnerRadiusExtentScale(globalRadiusInnerExtentVariable);
					radiusInnerExtentScaleEditor.TextView.setText("RadiusInnerExtentScale: " + Double.toString(Double.valueOf(roundToDecimal.format(globalRadiusInnerExtentVariable))));
				}
			}
		});
		radiusInnerExtentScaleEditor.IncrementButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(globalRadiusInnerExtentVariable < 1) {
					globalRadiusInnerExtentVariable = globalRadiusInnerExtentVariable + 0.1;

					radiusAxis.setInnerRadiusExtentScale(globalRadiusInnerExtentVariable);
					radiusInnerExtentScaleEditor.TextView.setText("RadiusInnerExtentScale: " + Double.toString(Double.valueOf(roundToDecimal.format(globalRadiusInnerExtentVariable))));
				}
			}
		});

		//</editor-fold>

		//Set Manual Range, (Min/Max) and Intervals
		//<editor-fold desc="Min slider angleAxisMinSlider">
		final NumericValueEditor rAMinSlider = new NumericValueEditor("RadiusAxis Min: ", context);
		rAMinSlider.SeekBar.setMax(360);
		rAMinSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setMinimumValue(progress);
				rAMinSlider.TextView.setText("RadiusAxis Min: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		//</editor-fold>

		//Max slider angleMaxSlider
		//<editor-fold desc="Max slider angleMaxSlider">
		final NumericValueEditor rAMaxSlider = new NumericValueEditor("RadiusAxis Max: ", context);
		rAMaxSlider.SeekBar.setMax(360);
		rAMaxSlider.SeekBar.setProgress(360);
		rAMaxSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setMaximumValue(progress);
				rAMaxSlider.TextView.setText("RadiusAxis Max: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//Interval sliders for RadiusAxis
		//<editor-fold desc="Interval interaction controls - toggleRAMinorInterval, toggleRAMajorInterval, rAMajorIntervalThicknessSlider, rAMinorIntervalThicknessSlider, rAMinorIntervalSlider">
		final CheckBox toggleRAMinorInterval = new CheckBox(context);
		final CheckBox toggleRAMajorInterval = new CheckBox(context);

		final NumericValueEditor rAMajorIntervalThicknessSlider = new NumericValueEditor("MajorIntervalThickness:", context);
		final NumericValueEditor rAMinorIntervalThicknessSlider = new NumericValueEditor("MinorIntervalThickness:", context);
		final NumericValueEditor rAMinorIntervalSlider = new NumericValueEditor("MinorIntervalValue:", context);

		toggleRAMajorInterval.setText("Toggle Major Interval on RadiusAxis:                                     ");
		toggleRAMajorInterval.setChecked(false);

		toggleRAMajorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(!toggleRAMajorInterval.isChecked()) {
					radiusAxis.setMajorStroke(Brushes.Transparent);
				}
				else if(toggleRAMajorInterval.isChecked())
				{
					radiusAxis.setMajorStroke(Brushes.Green);
				}
			}
		});

		toggleRAMinorInterval.setText("Toggle Minor Interval on RadiusAxis: ");
		toggleRAMinorInterval.setChecked(false);

		toggleRAMinorInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(!toggleRAMinorInterval.isChecked()) {
					radiusAxis.setMinorStroke(Brushes.Transparent);
				}
				else if(toggleRAMinorInterval.isChecked())
				{
					radiusAxis.setMinorStroke(Brushes.Red);
				}
			}
		});

		//RadiusAxis Interval Sliders
		rAMajorIntervalThicknessSlider.SeekBar.setMax(10);
		rAMajorIntervalThicknessSlider.SeekBar.setProgress(1);
		rAMajorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setMajorStrokeThickness(progress);
				rAMajorIntervalThicknessSlider.TextView.setText("MajorIntervalThickness: " + Integer.toString(progress));
			}
		});
		rAMinorIntervalThicknessSlider.SeekBar.setMax(10);
		rAMinorIntervalThicknessSlider.SeekBar.setProgress(1);
		rAMinorIntervalThicknessSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setMinorStrokeThickness(progress);
				rAMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: " + Integer.toString(progress));
			}
		});
		rAMinorIntervalSlider.SeekBar.setMax(25);
		rAMinorIntervalSlider.SeekBar.setProgress(1);
		rAMinorIntervalSlider.SeekBar.setOnSeekBarChangeListener(new OnNumericBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if(progress > 0) {
					radiusAxis.setMinorInterval(progress);
					rAMinorIntervalSlider.TextView.setText("MinorIntervalValue: " + Integer.toString(progress));
				}
			}
		});

		rAMinorIntervalThicknessSlider.TextView.setText("MinorIntervalThickness: ");
		rAMinorIntervalSlider.TextView.setText("MinorIntervalValue: ");
		//</editor-fold>

		//Set IsLogarithmic
		//<editor-fold desc="Set IsLogarithmicToggle - raLogarithmBaseSlider">
		//IsLogarithmicToggle
		final ToggleEditor rAIsLogarithmicTgl = new ToggleEditor("IsLogarithmic: ", context);
		rAIsLogarithmicTgl.ToggleButton.setChecked(false);
		rAIsLogarithmicTgl.ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				boolean isLogarithmicBool = rAIsLogarithmicTgl.ToggleButton.isChecked() ? true : false;
				radiusAxis.setIsLogarithmic(isLogarithmicBool);
			}
		});
		//</editor-fold>

		//SetLogarithmBaseSlider
		//<editor-fold desc="SetLogarithmBase - raLogarithmBaseSlider">
		final NumericValueEditor raLogarithmBaseSlider = new NumericValueEditor("LogarithmBase: " + Integer.toString(angleAxis.getLogarithmBase()), context);
		raLogarithmBaseSlider.SeekBar.setMax(250);
		raLogarithmBaseSlider.SeekBar.setProgress(10);
		raLogarithmBaseSlider.SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				radiusAxis.setLogarithmBase(progress);
				raLogarithmBaseSlider.TextView.setText("LogarithmBase: " + Integer.toString(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
		//</editor-fold>

		//</editor-fold>

		//Option Layouts
		final LinearLayout sampleSubOptions = new LinearLayout(context);
		sampleSubOptions.setOrientation(LinearLayout.VERTICAL);

		//<editor-fold desc="Properties Spinner">
		//Properties Spinner
		final Spinner polarAxesPropSpinner = new Spinner(context);
		TextView propertiesSetLbl = new TextView(context);
		propertiesSetLbl.setText("Property Set: ");

		List<String> propertiesList = new ArrayList<String>();
		propertiesList.add("AngleAxis Range");
		propertiesList.add("AngleAxis Logarithmic");
		propertiesList.add("AngleAxis Intervals");
        propertiesList.add("RadiusAxis Range");
        propertiesList.add("RadiusAxis Logarithmic");
        propertiesList.add("RadiusAxis Intervals");
        propertiesList.add("RadiusAxis Stroke");
        propertiesList.add("RadiusAxis Extents");

		ArrayAdapter propAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, propertiesList);
		propAdapter.setDropDownViewResource(android.R.layout.simple_gallery_item);

		polarAxesPropSpinner.setAdapter(propAdapter);
		polarAxesPropSpinner.setSelection(0);
		//</editor-fold>

		polarAxesPropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				switch(polarAxesPropSpinner.getSelectedItemPosition()){
                    //AngleAxis Range
                    case 0:
					{
						sampleSubOptions.removeAllViews();
						sampleSubOptions.addView(angleAxisMinSlider.Layout);
						sampleSubOptions.addView(angleAxisMaxSlider.Layout);
						break;
					}
                    //AngleAxis Logarithmic
					case 1:
					{
						sampleSubOptions.removeAllViews();
						sampleSubOptions.addView(angleAxisIsLogarithmicTgl.Layout);
						sampleSubOptions.addView(logarithmBaseSlider.Layout);
						break;
					}
                    //AngleAxis Intervals
					case 2:
					{
						sampleSubOptions.removeAllViews();
						sampleSubOptions.addView(toggleAngleAxisMajorInterval);
						sampleSubOptions.addView(angleAxisMajorIntervalThicknessSlider.Layout);
						sampleSubOptions.addView(toggleAngleAxisMinorInterval);
						sampleSubOptions.addView(angleAxisMinorIntervalThicknessSlider.Layout);
						sampleSubOptions.addView(angleAxisMinorIntervalSlider.Layout);
						break;
					}
                    //"RadiusAxis Range");
                    case 3:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(angleAxisMinSlider.Layout);
                        sampleSubOptions.addView(angleAxisMaxSlider.Layout);
                        break;
                    }
                    //"RadiusAxis Logarithmic");
                    case 4:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(rAIsLogarithmicTgl.Layout);
                        sampleSubOptions.addView(raLogarithmBaseSlider.Layout);
                        break;
                    }
                    //"RadiusAxis Intervals");
                    case 5:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(toggleRAMajorInterval);
                        sampleSubOptions.addView(rAMajorIntervalThicknessSlider.Layout);
                        sampleSubOptions.addView(toggleRAMinorInterval);
                        sampleSubOptions.addView(rAMinorIntervalThicknessSlider.Layout);
                        sampleSubOptions.addView(rAMinorIntervalSlider.Layout);
                        break;
                    }
                    //"RadiusAxis Stroke");
                    case 6:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(rAApplyMajorStrokeTgl.Layout);
                        sampleSubOptions.addView(rAMajorStrokeThickness.Layout);
                        sampleSubOptions.addView(rAApplyMinorStrokeTgl.Layout);
                        sampleSubOptions.addView(rAMinorStrokeThickness.Layout);
                        sampleSubOptions.addView(rAApplyStrokeTgl.Layout);
                        sampleSubOptions.addView(rAStrokeThickness.Layout);
                        sampleSubOptions.addView(rAApplyStripBrushTgl.Layout);
                        break;
                    }
                    //"RadiusAxis Extents");
                    case 7:
                    {
                        sampleSubOptions.removeAllViews();
                        sampleSubOptions.addView(radiusExtentScaleEditor.Layout);
                        sampleSubOptions.addView(radiusInnerExtentScaleEditor.Layout);
                        break;
                    }
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		sampleOptions.addView(polarAxesPropSpinner);
		sampleOptions.addView(sampleSubOptions);

	}

	private PolarBase GetPolarSeries(
			NumericAngleAxis angleAxis, 
			NumericRadiusAxis radiusAxis, 
			Class<?> SampleType, List<?> testData){
		
		PolarBase series;
		try {
			series = (PolarBase)SampleType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	 
		series.setAngleAxis(angleAxis);
		series.setRadiusAxis(radiusAxis);
		series.setAngleMemberPath("x");
		series.setRadiusMemberPath("y");
		series.setMarkerType(MarkerType.CIRCLE);
		series.setDataSource(testData);
		series.setAreaFillOpacity(0.5);
		
		return series;
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates the Polar Series in the chart. Among the main features that can be configured on the Polar Series are labels' and title's color, margins, extent and font properties, major and minor grid lines' intervals, colors and thickness, stripe's color and thickness, minimum and maximum values for the axes, radius extent of the axes, logarithmic along with linear axis scale, highlighting, zooming, legend, markers, etc.";
	}
}
