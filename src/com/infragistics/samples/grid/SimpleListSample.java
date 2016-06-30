package com.infragistics.samples.grid;

import android.app.Activity;
import android.widget.LinearLayout;
import com.infragistics.controls.*;
import com.infragistics.data.GridDataItem2;
import com.infragistics.samplesbrowser.SampleLayout;

public class SimpleListSample extends SampleLayout {

    public SimpleListSample(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        DataGridView grid = new DataGridView(context);
        grid.setRowHeight(50);

        grid.setDataSource(GridDataItem2.GenerateData(200));
        grid.setSelectionMode(GridSelectionMode.MULTIPLE_ROW);

        layout.addView(grid);
        sampleContainer.addView(layout);
    }

    @Override
    protected String getDescription() {
        return "Here is a basic grid showing auto-generated columns.";
    }
}
