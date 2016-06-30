package com.infragistics.samplesbrowser;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.*;
import android.widget.LinearLayout.LayoutParams;

public class ToggleEditor {
    public TextView TextView;
    public ToggleButton ToggleButton;
    public LinearLayout Layout;

    public ToggleEditor(String title, Activity context){
        float width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 170, context.getResources()
                        .getDisplayMetrics());
        float height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 35, context.getResources()
                        .getDisplayMetrics());

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int)width,(int)height);

        this.TextView = new TextView(context);
        this.TextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        this.TextView.setLayoutParams(params);
        this.TextView.setText(title);

        this.ToggleButton = new ToggleButton(context);
        this.ToggleButton.setChecked(false);

        float width1 = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 130, context.getResources()
                        .getDisplayMetrics());
        float height1 = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 40, context.getResources()
                        .getDisplayMetrics());

        this.ToggleButton.setLayoutParams(new LayoutParams(750, 95));
        LinearLayout.LayoutParams lin = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        lin.weight = 1;
        this.ToggleButton.setLayoutParams(lin);

        this.Layout = new LinearLayout(context);
        this.Layout.setOrientation(LinearLayout.HORIZONTAL);
        this.Layout.addView(this.TextView);
        this.Layout.addView(this.ToggleButton);
    }
}
