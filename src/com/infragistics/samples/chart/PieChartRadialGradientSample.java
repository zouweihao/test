package com.infragistics.samples.chart;

import android.app.Activity;
import android.graphics.Color;
import android.provider.CalendarContract.Colors;
import android.view.Gravity;
import android.widget.FrameLayout;
import com.infragistics.controls.ItemLegendView;
import com.infragistics.controls.OnSliceClickListener;
import com.infragistics.controls.PieChartView;
import com.infragistics.controls.SliceClickEvent;
import com.infragistics.data.CategoryDataSmallSample;
import com.infragistics.extensions.Brushes;
import com.infragistics.graphics.BrushPalette;
import com.infragistics.graphics.GradientStop;
import com.infragistics.graphics.RadialGradientBrush;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleLayout;

public class PieChartRadialGradientSample extends SampleLayout {

	public PieChartRadialGradientSample(Activity activity) {
		super(activity);

        FrameLayout frame = new FrameLayout(context);

		PieChartView view = new PieChartView(context);
		view.setBackgroundColor(Color.WHITE);

		CategoryDataSmallSample smt = new CategoryDataSmallSample();
		view.explodeSlice(1);

		view.setDataSource(smt);
		view.setLabelMemberPath("label");
		view.setValueMemberPath("Value");

		view.setAllowSliceExplosion(true);
		view.setExplodedRadius(0.2);
		view.setRadiusFactor(0.7);

        view.setOnSliceClickListener(new OnSliceClickListener() {
        	public void onSliceClick(PieChartView view, SliceClickEvent event) {
				event.setIsExploded(!event.getIsExploded());
				event.setIsSelected(!event.getIsSelected());
        	}
        });


    	LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);

        view.setBrushes(getRadialGradientPalette());
        view.setOutlines(getRadialGradientPalette());

        ItemLegendView legend = new ItemLegendView(context);

        LayoutParams params2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params2.gravity = Gravity.TOP | Gravity.RIGHT;
        legend.setLayoutParams(params2);

        view.setLegend(legend);

        frame.addView(view);
        frame.addView(legend);

        this.sampleContainer.addView(frame);
		
	}

    private BrushPalette getRadialGradientPalette() {
        BrushPalette b = new BrushPalette();
        b.getBrushes().add(Brushes.GetBrush(Color.rgb(245,73,88)));

        b.getBrushes().add(Brushes.GetBrush(Color.rgb(245,147,49)));

        b.getBrushes().add(Brushes.GetBrush(Color.rgb(245,196,49)));

        b.getBrushes().add(Brushes.GetBrush(Color.rgb(36,179,107)));

        b.getBrushes().add(Brushes.GetBrush(Color.rgb(36,179,179)));


        return b;
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates how to set radial gradient on the slices of the Pie Chart.";
    }

}
