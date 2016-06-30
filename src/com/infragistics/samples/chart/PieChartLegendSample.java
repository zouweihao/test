package com.infragistics.samples.chart;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.infragistics.controls.ItemLegendView;
import com.infragistics.controls.OnSliceClickListener;
import com.infragistics.controls.PieChartView;
import com.infragistics.controls.SliceClickEvent;
import com.infragistics.data.CategoryDataSmallSample;
import com.infragistics.samplesbrowser.SampleLayout;

public class PieChartLegendSample extends SampleLayout {

	public PieChartLegendSample(Activity activity) {
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


    	FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);

        ItemLegendView legend = new ItemLegendView(context);

        FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params2.gravity = Gravity.TOP | Gravity.LEFT;
        legend.setIsHorizontal(true);
        legend.setLayoutParams(params2);

        view.setLegend(legend);
        
        HorizontalScrollView scrollView = new HorizontalScrollView(activity);
        scrollView.addView(legend);
       

        frame.addView(view);
        frame.addView(scrollView);

        this.sampleContainer.addView(frame);
	}

	@Override
	protected String getDescription() {
		return "This sample demonstrates how to show the Legend of the Pie Chart.";
	}
}
