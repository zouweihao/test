package com.infragistics.samplesbrowser;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.*;

public class NumericIncrementEditor {

    public android.widget.Button DecrementButton;
    public android.widget.TextView TextView;
    public android.widget.Button IncrementButton;
    public LinearLayout Layout;

    public NumericIncrementEditor(String title, Activity context){

        float height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 35, context.getResources()
                        .getDisplayMetrics());

        float width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 60, context.getResources()
                        .getDisplayMetrics());

        FrameLayout.LayoutParams buttonParams = new FrameLayout.LayoutParams((int)width,(int)height);

        LinearLayout.LayoutParams lin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lin.weight = 1;

        this.DecrementButton = new Button(context);
        this.DecrementButton.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        this.DecrementButton.setLayoutParams(buttonParams);
        this.DecrementButton.setText("-");

        this.TextView = new TextView(context);
        this.TextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        this.TextView.setLayoutParams(lin);
        this.TextView.setText(title);

        this.IncrementButton = new Button(context);
        this.IncrementButton.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        this.IncrementButton.setLayoutParams(buttonParams);
        this.IncrementButton.setText("+");

        float width1 = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 15, context.getResources()
                        .getDisplayMetrics());
        float height1 = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 40, context.getResources()
                        .getDisplayMetrics());

        this.Layout = new LinearLayout(context);
        this.Layout.setOrientation(LinearLayout.HORIZONTAL);

        this.Layout.addView(this.DecrementButton);
        this.Layout.addView(this.TextView);
        this.Layout.addView(this.IncrementButton);

    }
}
