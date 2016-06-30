package com.infragistics.samples.grid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.infragistics.controls.ColumnShowingStyle;
import com.infragistics.controls.GridAnimationPhaseSettings;
import com.infragistics.controls.DataGridView;
import com.infragistics.controls.TextColumn;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.SampleLayout;

import java.util.ArrayList;

public class GridAddColumnAnimation extends GridAnimationSampleBase {

    public GridAddColumnAnimation(Activity activity) {
        super(activity);

    }

    @Override
    int getDefaultAnimationStyle() {
        return GridView.getColumnAddingAnimationStyle().getValue();
    }

    @Override
    void updateAnimationStyle(int style) {
        GridView.setColumnAddingAnimationStyle(ColumnShowingStyle.valueOf(style));
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

        Button addCol = new Button(context);
        addCol.setText("Add");
        addCol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                GridView.addColumn(createTextColumn("firstName", "First Name"));
            }
        });

        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(addCol);

        return layout;
    }

    @Override
    void addPhases(ExpandedAnimationAdapter adapter) {
        adapter.addConfig("Adding Pre Phase", GridView.getColumnAnimationSettings().getColumnAddingPrePhase());
        adapter.addConfig("Adding Main Phase", GridView.getColumnAnimationSettings().getColumnAddingMainPhase());
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates adding a Column and the accompanying animations.";
    }
}
