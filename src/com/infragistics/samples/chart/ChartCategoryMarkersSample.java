package com.infragistics.samples.chart;

import android.app.Activity;
import android.graphics.*;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.infragistics.controls.*;
import com.infragistics.samplesbrowser.SampleInfo;

public class ChartCategoryMarkersSample extends ChartCategoryHorizontalSeriesSample {

    public ChartCategoryMarkersSample(Activity activity, SampleInfo info,
                                      boolean useLegend, boolean smallData) {
        super(activity, info, useLegend, smallData);

        final HorizontalAnchoredCategorySeries s1 = (HorizontalAnchoredCategorySeries) chart.getSeriesAt(0);
        final HorizontalAnchoredCategorySeries s2 = (HorizontalAnchoredCategorySeries) chart.getSeriesAt(1);
        s1.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 2);
        s2.setTrendLineThickness(TypedValue.COMPLEX_UNIT_DIP, 2);

        LayoutParams params = new LayoutParams(450, 70);
        TextView textView1 = new TextView(context);
        textView1.setLayoutParams(params);
        textView1.setText("Select Marker Type:");
        textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        Spinner spinner = new Spinner(context);

        MarkerType[] markerTypes = MarkerType.values();
        final String[] markerTypeStrings = new String[markerTypes.length];
        for (int i = 0; i < markerTypes.length; i++) {
            String val = markerTypes[i].toString();
            if (val.equals("UNSET")) {
                val = "CUSTOM";
            }

            markerTypeStrings[i] = val;
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, markerTypeStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(2);
        spinner.setPrompt("Select Marker Type");
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int pos, long arg3) {

                String sType = markerTypeStrings[pos];
                if (sType.equals("CUSTOM")) {
                    CustomRenderTemplate ct = new CustomRenderTemplate() {
                        @Override
                        public void measure(CustomRenderTemplateMeasureInfo info) {
                            info.setWidth(16);
                            info.setHeight(16);
                        }

                        @Override
                        public void render(CustomRenderTemplateRenderInfo info) {
                            Canvas c = info.getContext();
                            float halfHeight = (float) info.getAvailableHeight() / 2.0f;
                            float halfWidth = (float) info.getAvailableWidth() / 2.0f;
                            float top = (float) info.getYPosition() - halfHeight;
                            float left = (float) info.getXPosition() - halfWidth;
                            float right = left + (float) info.getAvailableWidth();
                            float bottom = top + (float) info.getAvailableHeight();
                            Paint p = new Paint();
                            p.setColor(Color.RED);
                            p.setStyle(Paint.Style.FILL);
                            c.drawRect(new RectF(left, top, right, bottom), p);
                        }
                    };

                    s1.setMarkerTemplate(ct);
                    s2.setMarkerTemplate(ct);

                } else {
                    MarkerType markerType = MarkerType.values()[pos];
                    s1.setMarkerTemplate(null);
                    s2.setMarkerTemplate(null);
                    s1.setMarkerType(markerType);
                    s2.setMarkerType(markerType);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                s1.setMarkerTemplate(null);
                s2.setMarkerTemplate(null);
                s1.setMarkerType(MarkerType.NONE);
                s2.setMarkerType(MarkerType.NONE);
            }

        });

        this.sampleOptions.addView(textView1);
        this.sampleOptions.addView(spinner);
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates various Marker types that are available in the Data Chart. These built-in markers can be used to mark specific data points, or custom markers can be created using data template objects.";
    }

}