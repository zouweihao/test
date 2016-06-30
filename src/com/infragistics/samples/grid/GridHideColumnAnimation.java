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

public class GridHideColumnAnimation extends GridAnimationSampleBase {

    public GridHideColumnAnimation(Activity activity) {
        super(activity);
        //GridView.setColumnShowingAnimationStyle(ColumnShowingStyle.NONE);
    }

    @Override
    int getDefaultAnimationStyle() {
        return GridView.getColumnHidingAnimationStyle().getValue();
    }

    @Override
    void updateAnimationStyle(int style) {
        GridView.setColumnHidingAnimationStyle(ColumnHidingStyle.valueOf(style));
    }

    @Override
    SpinnerAdapter getStyleAdapter() {
        ArrayAdapter<ColumnHidingStyle> arrayAdapter =
                new ArrayAdapter<ColumnHidingStyle>(context, android.R.layout.simple_spinner_item, ColumnHidingStyle.values());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return arrayAdapter;
    }

    @Override
    ViewGroup getButtonPanel() {
        LinearLayout layout = new LinearLayout(context);

        final Button addCol = new Button(context);
        addCol.setText("Hide");
        addCol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LastNameColumn.getIsHidden()) {
                    LastNameColumn.setIsHidden(false);
                    addCol.setText("Hide");
                }
                else {
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
        adapter.addConfig("Hiding Main Phase", GridView.getColumnAnimationSettings().getColumnHidingMainPhase());
        adapter.addConfig("Hiding Post Phase", GridView.getColumnAnimationSettings().getColumnHidingPostPhase());
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates hiding a Column and the accompanying animations.";
    }

}
