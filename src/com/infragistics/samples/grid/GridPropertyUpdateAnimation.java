package com.infragistics.samples.grid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.infragistics.controls.ColumnPropertyUpdatingStyle;
import com.infragistics.controls.ColumnShowingStyle;
import com.infragistics.extensions.Colors;
import com.infragistics.graphics.SolidColorBrush;

public class GridPropertyUpdateAnimation extends GridAnimationSampleBase {

    private  boolean _isBlue;

    public GridPropertyUpdateAnimation(Activity activity) {
        super(activity);
        _isBlue = false;
        FirstNameColumn.setTextColor(new SolidColorBrush(Colors.Red));
        LastNameColumn.setBackgroundColor(new SolidColorBrush(Colors.GrayLight));
    }

    @Override
    int getDefaultAnimationStyle() {
        return GridView.getColumnPropertyUpdatingAnimationStyle().getValue();
    }

    @Override
    void updateAnimationStyle(int style) {
        GridView.setColumnPropertyUpdatingAnimationStyle(ColumnPropertyUpdatingStyle.valueOf(style));
    }

    @Override
    SpinnerAdapter getStyleAdapter() {
        ArrayAdapter<ColumnPropertyUpdatingStyle> arrayAdapter =
                new ArrayAdapter<ColumnPropertyUpdatingStyle>(context, android.R.layout.simple_spinner_item, ColumnPropertyUpdatingStyle.values());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return arrayAdapter;
    }

    @Override
    ViewGroup getButtonPanel() {
        LinearLayout layout = new LinearLayout(context);

        Button addCol = new Button(context);
        addCol.setText("Toggle Colors");
        addCol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_isBlue) {
                    FirstNameColumn.setTextColor( new SolidColorBrush(Colors.Red));
                    _isBlue = false;
                    LastNameColumn.setBackgroundColor(new SolidColorBrush(Colors.GrayLight));
                } else {
                    FirstNameColumn.setTextColor( new SolidColorBrush(Colors.Blue));
                    _isBlue = true;
                    LastNameColumn.setBackgroundColor(new SolidColorBrush(Colors.White));
                }

            }
        });

        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(addCol);

        return layout;
    }

    @Override
    void addPhases(ExpandedAnimationAdapter adapter) {
        adapter.addConfig("Property Update Main Phase", GridView.getColumnAnimationSettings().getColumnPropertyUpdatingMainPhase());
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates dynamically changing properties on a column and the accompanying animations.";
    }
}
