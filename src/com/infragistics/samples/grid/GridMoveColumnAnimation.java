package com.infragistics.samples.grid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.infragistics.controls.ColumnMovingStyle;
import com.infragistics.controls.ColumnShowingStyle;

public class GridMoveColumnAnimation extends GridAnimationSampleBase {

    public GridMoveColumnAnimation(Activity activity) {
        super(activity);
    }

    @Override
    int getDefaultAnimationStyle() {
        return GridView.getColumnMovingAnimationStyle().getValue();
    }

    @Override
    void updateAnimationStyle(int style) {
        GridView.setColumnMovingAnimationStyle(ColumnMovingStyle.valueOf(style));
    }

    @Override
    SpinnerAdapter getStyleAdapter() {
        ArrayAdapter<ColumnMovingStyle> arrayAdapter =
                new ArrayAdapter<ColumnMovingStyle>(context, android.R.layout.simple_spinner_item, ColumnMovingStyle.values());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return arrayAdapter;
    }

    @Override
    ViewGroup getButtonPanel() {
        LinearLayout layout = new LinearLayout(context);

        Button addCol = new Button(context);
        addCol.setText("Move");
        addCol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GridView.getColumnAt(0) == FirstNameColumn) {
                    GridView.moveColumn(0,2);
                } else {
                    GridView.moveColumn(2,0);
                }

            }
        });


        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(addCol);

        return layout;
    }

    @Override
    void addPhases(ExpandedAnimationAdapter adapter) {
        adapter.addConfig("Moving Pre Phase", GridView.getColumnAnimationSettings().getColumnMovingPrePhase());
        adapter.addConfig("Moving Main Phase", GridView.getColumnAnimationSettings().getColumnMovingMainPhase());
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates moving a Column to a different index and the accompanying animations.";
    }

}
