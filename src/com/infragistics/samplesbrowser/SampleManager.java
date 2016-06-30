package com.infragistics.samplesbrowser;

import java.util.HashMap;

import com.infragistics.controls.*;
import com.infragistics.extensions.StringList;

public class SampleManager {
 
	StringList samplesNames;
	HashMap<String, SampleInfo> samplesMap;
	
    public SampleManager() {
		
		samplesMap = new HashMap<String, SampleInfo>();
		samplesNames = new StringList();

        AddSample("Welcome Page");
        AddSample("  ");

		AddSample("CATEGORY CHARTS");
		AddSample("Area Series");
		AddSample("Line Series");
		AddSample("Spline Series");
		AddSample("Spline Area Series");
		AddSample("Column Series");
		//AddSample("Point Series");
		AddSample("Step Line Series");
		AddSample("Step Area Series");
		AddSample("Waterfall Series");
		AddSample("Range Column Series");
		AddSample("Range Area Series");
		AddSample("Bar Series");
		AddSample("Series Trendlines");
        AddSample("Series Markers");
        //AddSample("Chart Size Changing");

		AddSample("FINANCIAL CHARTS");
		AddSample("Candlestick Series");
		AddSample("OHLC Series");
		//AddSample("Indicator Series");
		//AddSample("Live Stock Chart");
	
		AddSample("SCATTER CHARTS");
		AddSample("Scatter Point Series");
        AddSample("Scatter Bubble Series");
        AddSample("Scatter Bubble Legend");
        AddSample("Scatter Line Series");
		AddSample("Scatter Spline Series");

        AddSample("STACKED CHARTS");
        AddSample("Stacked Column Series");
        AddSample("Stacked Line Series");
        AddSample("Stacked Area Series");
        AddSample("Stacked Spline Series");
        AddSample("Stacked Spline Area Series");
        AddSample("Stacked 100 Column Series");
        AddSample("Stacked 100 Line Series");
        AddSample("Stacked 100 Area Series");
        AddSample("Stacked 100 Spline Series");
        AddSample("Stacked 100 Spline Area Series");

        AddSample("RADIAL CHARTS");
		AddSample("Radial Line Series");
		AddSample("Radial Area Series");
		AddSample("Radial Column Series");
		AddSample("Radial Pie Series");
		
		AddSample("POLAR CHARTS");
		AddSample("Polar Scatter Series");
		AddSample("Polar Area Series");
		AddSample("Polar Line Series");
		AddSample("Polar Spline Series");
		AddSample("Polar Spline Area Series");
		
		AddSample("ANNOTATION LAYERS");
		AddSample("Crosshair Layer");
		AddSample("Category Highlight Layer");
		AddSample("Category Tooltip Layer");
		AddSample("Category Item Highlight Layer");
		AddSample("Item Tooltip Layer");

        AddSample("INTERVALS");
        AddSample("NumericXAxisIntervals");
        AddSample("CategoryXAxisIntervals");

        AddSample("GRID COLUMNS");
        AddSample("Text Column");
        AddSample("Date Column");
        AddSample("Numeric Column");
        AddSample("Image Column");
        AddSample("Template Column");
        AddSample("Column Adding");
        AddSample("Column Showing");
        AddSample("Column Hiding");
        AddSample("Column Moving");
        AddSample("Column Exchanging");

        AddSample("GRID DATA BINDING");
        AddSample("Auto-Generated Columns");
        AddSample("Remote Data (OData)");

        AddSample("GRID INTERACTIONS");
        AddSample("Property Updating");
		AddSample("Row Selection");

        AddSample("RESPONSIVE GRID");
        AddSample("Responsive Grid Side Bar");
        AddSample("Responsive Grid Rotation");
        AddSample("Activity Tracker");

        AddSample("PIE CHART");
        AddSample("Pie Chart Explosion");
        AddSample("Pie Chart Options");
        AddSample("Pie Chart Legend");
        AddSample("Pie Chart Gradient");

        AddSample("FUNNEL CHART");
        AddSample("Funnel Chart Options");
        AddSample("Funnel Chart Bezier Curve");
		
		AddSample("RADIAL GAUGE");
		AddSample("Radial Gauge Animation");
		AddSample("Radial Gauge Labels");
		AddSample("Radial Gauge Needle");
		AddSample("Radial Gauge Range");
		AddSample("Radial Gauge Compass");
		AddSample("Radial Gauge Clock");
		
		AddSample("LINEAR GAUGE");
		AddSample("Linear Gauge Animation");
		AddSample("Linear Gauge Labels");
		AddSample("Linear Gauge Needle");
		
		AddSample("BULLET GRAPH");
		AddSample("Bullet Graph Animation");
		AddSample("Bullet Graph Options");

        AddSample("BARCODE");
        AddSample("Barcode 128");
        AddSample("QR Barcode");
	}
	 
	private void AddSample(String name) {

        SampleInfo sampleInfo = null;
        if (name == "Welcome Page")
            sampleInfo = new SampleInfo(name, LandingPage.class, SampleType.WELCOME_PAGE);
        else if (name == "  ")      //Hack for spacing
            sampleInfo = new SampleInfo(name);
        // Category
        else if (name == "CATEGORY CHARTS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Area Series")
            sampleInfo = new SampleInfo(name, AreaSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES);
        else if (name == "Line Series")
            sampleInfo = new SampleInfo(name, LineSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES);
        else if (name == "Spline Series")
            sampleInfo = new SampleInfo(name, SplineSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES);
        else if (name == "Spline Area Series")
            sampleInfo = new SampleInfo(name, SplineAreaSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES);
        else if (name == "Point Series")
            sampleInfo = new SampleInfo(name, PointSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES);
        else if (name == "Column Series")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES_SMALLDATA);
        else if (name == "Step Line Series")
            sampleInfo = new SampleInfo(name, StepLineSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES_SMALLDATA);
        else if (name == "Step Area Series")
            sampleInfo = new SampleInfo(name, StepAreaSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES_SMALLDATA);
        else if (name == "Waterfall Series")
            sampleInfo = new SampleInfo(name, WaterfallSeries.class, SampleType.CATEGORY_HORIZONTAL_SERIES_SMALLDATA);
        else if (name == "Range Column Series")
            sampleInfo = new SampleInfo(name, RangeColumnSeries.class, SampleType.CATEGORY_RANGE_SMALLDATA);
        else if (name == "Range Area Series")
            sampleInfo = new SampleInfo(name, RangeAreaSeries.class, SampleType.CATEGORY_RANGE);
        else if (name == "Series Trendlines")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.TRENDLINES);
        else if (name == "Series Markers")
            sampleInfo = new SampleInfo(name, LineSeries.class, SampleType.CATEGORY_MARKERS);
        else if (name == "Bar Series")
            sampleInfo = new SampleInfo(name, BarSeries.class, SampleType.CATEGORY_BAR);
        //else if (name == "Chart Size Changing")
        //    sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.CATEGORY_SIZECHANGE);

            // Financial
        else if (name == "FINANCIAL CHARTS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Candlestick Series")
            sampleInfo = new SampleInfo(name, FinancialPriceSeries.class, SampleType.FINANCIAL_PRICE);
        else if (name == "OHLC Series")
            sampleInfo = new SampleInfo(name, FinancialPriceSeries.class, SampleType.FINANCIAL_PRICE);
        else if (name == "Indicator Series")
            sampleInfo = new SampleInfo(name, FinancialPriceSeries.class, SampleType.FINANCIAL_INDICATOR);
        else if (name == "Live Stock Chart")
            sampleInfo = new SampleInfo(name, FinancialPriceSeries.class, SampleType.FINANCIAL_LIVE);

            // Scatter
        else if (name == "SCATTER CHARTS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Scatter Point Series")
            sampleInfo = new SampleInfo(name, ScatterSeries.class, SampleType.SCATTER_POINT);
        else if (name == "Scatter Bubble Series")
            sampleInfo = new SampleInfo(name, ScatterSeries.class, SampleType.SCATTER_BUBBLE);
        else if (name == "Scatter Bubble Legend")
            sampleInfo = new SampleInfo(name, ScatterSeries.class, SampleType.SCATTER_BUBBLE_LEGEND);
        else if (name == "Scatter Line Series")
            sampleInfo = new SampleInfo(name, ScatterLineSeries.class, SampleType.SCATTER_CONTINUES);
        else if (name == "Scatter Spline Series")
            sampleInfo = new SampleInfo(name, ScatterSplineSeries.class, SampleType.SCATTER_CONTINUES);

        //Stacked
        else if (name == "STACKED CHARTS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Stacked Column Series")
            sampleInfo = new SampleInfo(name, StackedColumnSeries.class, SampleType.STACKED);
        else if (name == "Stacked Line Series")
            sampleInfo = new SampleInfo(name, StackedLineSeries.class, SampleType.STACKED);
        else if (name == "Stacked Area Series")
            sampleInfo = new SampleInfo(name, StackedAreaSeries.class, SampleType.STACKED);
        else if (name == "Stacked Spline Series")
            sampleInfo = new SampleInfo(name, StackedSplineSeries.class, SampleType.STACKED);
        else if (name == "Stacked Spline Area Series")
            sampleInfo = new SampleInfo(name, StackedSplineAreaSeries.class, SampleType.STACKED);
        else if (name == "Stacked 100 Column Series")
            sampleInfo = new SampleInfo(name, Stacked100ColumnSeries.class, SampleType.STACKED);
        else if (name == "Stacked 100 Line Series")
            sampleInfo = new SampleInfo(name, Stacked100LineSeries.class, SampleType.STACKED);
        else if (name == "Stacked 100 Area Series")
            sampleInfo = new SampleInfo(name, Stacked100AreaSeries.class, SampleType.STACKED);
        else if (name == "Stacked 100 Spline Series")
            sampleInfo = new SampleInfo(name, Stacked100SplineSeries.class, SampleType.STACKED);
        else if (name == "Stacked 100 Spline Area Series")
            sampleInfo = new SampleInfo(name, Stacked100SplineAreaSeries.class, SampleType.STACKED);

            // Radial
        else if (name == "RADIAL CHARTS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Radial Line Series")
            sampleInfo = new SampleInfo(name, RadialLineSeries.class, SampleType.RADIAL_SERIES);
        else if (name == "Radial Area Series")
            sampleInfo = new SampleInfo(name, RadialAreaSeries.class, SampleType.RADIAL_SERIES);
        else if (name == "Radial Column Series")
            sampleInfo = new SampleInfo(name, RadialColumnSeries.class, SampleType.RADIAL_SERIES);
        else if (name == "Radial Pie Series")
            sampleInfo = new SampleInfo(name, RadialPieSeries.class, SampleType.RADIAL_SERIES);

            // Polar
        else if (name == "POLAR CHARTS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Polar Scatter Series")
            sampleInfo = new SampleInfo(name, PolarScatterSeries.class, SampleType.POLAR_SERIES);
        else if (name == "Polar Line Series")
            sampleInfo = new SampleInfo(name, PolarLineSeries.class, SampleType.POLAR_SERIES);
        else if (name == "Polar Spline Series")
            sampleInfo = new SampleInfo(name, PolarSplineSeries.class, SampleType.POLAR_SERIES);
        else if (name == "Polar Spline Area Series")
            sampleInfo = new SampleInfo(name, PolarSplineAreaSeries.class, SampleType.POLAR_SERIES);
        else if (name == "Polar Area Series")
            sampleInfo = new SampleInfo(name, PolarAreaSeries.class, SampleType.POLAR_SERIES);

            // Annotation Layers
        else if (name == "ANNOTATION LAYERS")
            sampleInfo = new SampleInfo(name);
        else if (name == "Crosshair Layer")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.ANNOTATION_LAYERS);
        else if (name == "Category Highlight Layer")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.ANNOTATION_LAYERS);
        else if (name == "Category Tooltip Layer")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.ANNOTATION_LAYERS);
        else if (name == "Category Item Highlight Layer")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.ANNOTATION_LAYERS);
        else if (name == "Item Tooltip Layer")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.ANNOTATION_LAYERS);

            //Intervals
        else if (name == "INTERVALS")
            sampleInfo = new SampleInfo(name);
        else if (name == "NumericXAxisIntervals")
            sampleInfo = new SampleInfo(name, LineSeries.class, SampleType.NUMERIC_INTERVALS);
        else if (name == "CategoryXAxisIntervals")
            sampleInfo = new SampleInfo(name, ColumnSeries.class, SampleType.CATEGORY_INTERVALS);

            // Pie
        else if (name == "PIE CHART")
            sampleInfo = new SampleInfo(name);
        else if (name == "Pie Chart Explosion")
            sampleInfo = new SampleInfo(name, PieChartView.class, SampleType.PIE_EXPLOSION);
        else if (name == "Pie Chart Options")
            sampleInfo = new SampleInfo(name, PieChartView.class, SampleType.PIE_OPTIONS);
        else if (name == "Pie Chart Legend")
            sampleInfo = new SampleInfo(name, PieChartView.class, SampleType.PIE_LEGEND);
        else if (name == "Pie Chart Gradient")
            sampleInfo = new SampleInfo(name, PieChartView.class, SampleType.PIE_GRADIENT);

            //Funnel
        else if(name == "FUNNEL CHART")
            sampleInfo = new SampleInfo(name);
        else if(name == "Funnel Chart Bezier Curve")
            sampleInfo = new SampleInfo(name, FunnelChartView.class, SampleType.FUNNEL_BEZIER);
        else if (name == "Funnel Chart Options")
            sampleInfo = new SampleInfo(name, FunnelChartView.class, SampleType.FUNNEL_OPTIONS);

            //Grid
        else if (name == "GRID DATA BINDING")
            sampleInfo = new SampleInfo(name);
        else if (name == "GRID INTERACTIONS")
            sampleInfo = new SampleInfo(name);
        else if (name == "RESPONSIVE GRID")
            sampleInfo = new SampleInfo(name);
		else if (name == "GRID COLUMNS")
			sampleInfo = new SampleInfo(name);

        else if (name == "Auto-Generated Columns")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_SIMPLE);
        else if (name == "Responsive Grid Side Bar")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_RESPONSIVE_SIDE_BAR);
        else if (name == "Responsive Grid Rotation")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_RESPONSIVE_ROTATION);
        else if (name == "Activity Tracker")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_IMMERSIVE_ACTIVITY_TRACKER);
        else if (name == "Column Adding")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_ANIMATION_ADD_COLUMN);
        else if (name == "Column Showing")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_ANIMATION_SHOW_COLUMN);
        else if (name == "Column Hiding")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_ANIMATION_HIDE_COLUMN);
        else if (name == "Column Moving")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_ANIMATION_MOVE_COLUMN);
        else if (name == "Column Exchanging")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_ANIMATION_XCHG_COLUMN);
        else if (name == "Property Updating")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_ANIMATION_PROP_UPDATE);
        else if (name == "Remote Data (OData)")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_REMOTE_LIST);
        else if (name == "Row Selection")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_SELECTION);
        else if (name == "Text Column")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_TEXT_COLUMN);
        else if (name == "Date Column")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_DATE_COLUMN);
        else if (name == "Numeric Column")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_NUMERIC_COLUMN);
        else if (name == "Image Column")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_IMAGE_COLUMN);
        else if (name == "Template Column")
            sampleInfo = new SampleInfo(name, DataGridView.class, SampleType.GRID_TEMPLATE_COLUMN);
            // Radial Gauge
        else if (name == "RADIAL GAUGE")
            sampleInfo = new SampleInfo(name);
        else if (name == "Radial Gauge Animation")
            sampleInfo = new SampleInfo(name, RadialGaugeView.class, SampleType.RADIAL_GAUGE_ANIMATION);
        else if (name == "Radial Gauge Labels")
            sampleInfo = new SampleInfo(name, RadialGaugeView.class, SampleType.RADIAL_GAUGE_LABELS);
        else if (name == "Radial Gauge Needle")
            sampleInfo = new SampleInfo(name, RadialGaugeView.class, SampleType.RADIAL_GAUGE_NEEDLE);
        else if (name == "Radial Gauge Compass")
            sampleInfo = new SampleInfo(name, RadialGaugeView.class, SampleType.RADIAL_GAUGE_COMPASS);
        else if (name == "Radial Gauge Range")
            sampleInfo = new SampleInfo(name, RadialGaugeView.class, SampleType.RADIAL_GAUGE_RANGE);
        else if (name == "Radial Gauge Clock")
            sampleInfo = new SampleInfo(name, RadialGaugeView.class, SampleType.RADIAL_GAUGE_CLOCK);

            // Linear Gauge
        else if (name == "LINEAR GAUGE")
            sampleInfo = new SampleInfo(name);
        else if (name == "Linear Gauge Animation")
            sampleInfo = new SampleInfo(name, LinearGaugeView.class, SampleType.LINEAR_GAUGE_ANIMATION);
        else if (name == "Linear Gauge Labels")
            sampleInfo = new SampleInfo(name, LinearGaugeView.class, SampleType.LINEAR_GAUGE_LABELS);
        else if (name == "Linear Gauge Needle")
            sampleInfo = new SampleInfo(name, LinearGaugeView.class, SampleType.LINEAR_GAUGE_NEEDLE);

            // Bullet Graph
        else if (name == "BULLET GRAPH")
            sampleInfo = new SampleInfo(name);
        else if (name == "Bullet Graph Animation")
            sampleInfo = new SampleInfo(name, BulletGraphView.class, SampleType.BULLET_GRAPH_ANIMATION);
        else if (name == "Bullet Graph Options")
            sampleInfo = new SampleInfo(name, BulletGraphView.class, SampleType.BULLET_GRAPH_OPTIONS);

        // Barcode
        else if (name == "BARCODE")
            sampleInfo = new SampleInfo(name);
        else if (name == "Barcode 128")
            sampleInfo = new SampleInfo(name, Code128BarcodeView.class, SampleType.BARCODE_128_SAMPLE);
        else if (name == "QR Barcode")
            sampleInfo = new SampleInfo(name, QRCodeBarcodeView.class, SampleType.BARCODE_QR_SAMPLE);

        samplesNames.add(name);
        samplesMap.put(name, sampleInfo);
    }
	
}
