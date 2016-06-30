package com.infragistics.samples.grid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.infragistics.controls.ColumnHidingStyle;
import com.infragistics.controls.ColumnShowingStyle;
import com.infragistics.controls.DataGridView;

public class GridShowColumnAnimation extends GridAnimationSampleBase {
    public GridShowColumnAnimation(Activity activity) {
        super(activity);

        LastNameColumn.setIsHidden(true);
        //GridView.setColumnHidingAnimationStyle(ColumnHidingStyle.NONE);
    }

    @Override
    int getDefaultAnimationStyle() {
        return GridView.getColumnShowingAnimationStyle().getValue();
    }

    @Override
    void updateAnimationStyle(int style) {
        GridView.setColumnShowingAnimationStyle(ColumnShowingStyle.valueOf(style));
    }

    @Override
    SpinnerAdapter getStyleAdapter() {
        ArrayAdapter<ColumnShowingStyle> arrayAdapter =
                new ArrayAdapter<ColumnShowingStyle>(context, android.R.layout.simple_spinner_item, ColumnShowingStyle.values());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return arrayAdapter;
    }

    @Override
    ViewGroup getButtonPanel() {
        LinearLayout layout = new LinearLayout(context);

        final Button addCol = new Button(context);
        addCol.setText("Show");
        addCol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LastNameColumn.getIsHidden()) {
                    LastNameColumn.setIsHidden(false);
                    addCol.setText("Hide");
                } else {
                    LastNameColumn.setIsHidden(true);
                    addCol.setText("Show");
                }

            }
        });

        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(addCol);

        return layout;
    }

    @Override
    void addPhases(ExpandedAnimationAdapter adapter) {
        adapter.addConfig("Showing Pre Phase", GridView.getColumnAnimationSettings().getColumnShowingPrePhase());
        adapter.addConfig("Showing Main Phase", GridView.getColumnAnimationSettings().getColumnShowingMainPhase());
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates showing a Column and the accompanying animations.";
    }

}
