package com.infragistics.samplesbrowser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

class SamplesParentData {

    public String Name;
    public String Description;
    public LinkedHashMap<String, String> SubLinks;
    public int ImageResourceId;

    public static List<SamplesParentData> getSampleData() {
        ArrayList<SamplesParentData> data =new ArrayList<SamplesParentData>();

        data.add(createChartData());
        data.add(createGridData());
        data.add(createPieData());
        data.add(createFunnelData());
        data.add(createRadialData());
        data.add(createLinearData());
        data.add(createBulletData());
        data.add(createBarcodeData());
        return data;
    }

    private static SamplesParentData createBarcodeData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Barcodes";
        data.Description = "Infragistics Premier Android Barcodes";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("General", "Barcode 128");

        data.ImageResourceId = R.drawable.barcode_icon;

        return data;
    }


    private static SamplesParentData createBulletData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Bullet Graph";
        data.Description = "Infragistics Premier Android Bullet Graph";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("General", "Bullet Graph Animation");

        data.ImageResourceId = R.drawable.bulletgraph_icon;

        return data;
    }

    private static SamplesParentData createLinearData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Linear Gauge";
        data.Description = "Infragistics Premier Android Linear Gauge";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("General", "Linear Gauge Animation");

        data.ImageResourceId = R.drawable.lineargauge_icon;

        return data;
    }

    private static SamplesParentData createRadialData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Radial Gauge";
        data.Description = "Infragistics Premier Android Radial Gauge";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("General", "Radial Gauge Animation");

        data.ImageResourceId = R.drawable.radialgauge_icon;

        return data;
    }

    private static SamplesParentData createFunnelData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Funnel Chart";
        data.Description = "Infragistics Premier Android Funnel Chart";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("General", "Funnel Chart Options");

        data.ImageResourceId = R.drawable.funnelchart_icon;

        return data;
    }

    private static SamplesParentData createPieData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Pie Chart";
        data.Description = "Infragistics Premier Android Pie Chart";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("General", "Pie Chart Explosion");

        data.ImageResourceId = R.drawable.piechart_icon;

        return data;
    }

    private static SamplesParentData createGridData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Grid";
        data.Description = "Infragistics Premier Android Grid";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("Grid Columns","Text Column");
        data.SubLinks.put("Grid Data Binding","Auto-Generated Columns");
        data.SubLinks.put("Grid Interactions", "Property Updating");
        data.SubLinks.put("Responsive Grid", "Responsive Grid Side Bar");


        data.ImageResourceId = R.drawable.grid_icon;

        return data;
    }

    private static SamplesParentData createChartData() {
        SamplesParentData data = new SamplesParentData();
        data.Name = "Data Chart";
        data.Description = "Infragistics Premier Android Data Chart";

        data.SubLinks = new LinkedHashMap<String, String>();
        data.SubLinks.put("Category Charts","Area Series");
        data.SubLinks.put("Financial Charts","Candlestick Series");
        data.SubLinks.put("Scatter Charts","Scatter Point Series");
        data.SubLinks.put("Stacked Charts","Stacked Column Series");
        data.SubLinks.put("Radial Charts","Radial Line Series");
        data.SubLinks.put("Polar Charts","Polar Scatter Series");
        data.SubLinks.put("Annotation Layers","Crosshair Layer");
        data.SubLinks.put("Intervals","NumericXAxisIntervals");

        data.ImageResourceId = R.drawable.chart_icon;

        return data;
    }
}
