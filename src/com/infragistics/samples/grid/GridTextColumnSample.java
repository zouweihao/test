package com.infragistics.samples.grid;

import android.app.Activity;
import android.widget.LinearLayout;
import com.infragistics.controls.DataGridView;
import com.infragistics.controls.GridSelectionMode;
import com.infragistics.controls.TextColumn;
import com.infragistics.data.GridDataItem;
import com.infragistics.samplesbrowser.SampleLayout;

public class GridTextColumnSample extends SampleLayout {
    public GridTextColumnSample(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        DataGridView grid = new DataGridView(context);
        grid.setRowHeight(50);

        grid.setAutoGenerateColumns(false);

        TextColumn nameColumn = new TextColumn();
        nameColumn.setKey("Name");
        nameColumn.setHeaderText("Employee Name");

        TextColumn territoryColumn = new TextColumn();
        territoryColumn.setKey("Territory");
        territoryColumn.setHeaderText("Employee Location");

        grid.addColumn(nameColumn);
        grid.addColumn(territoryColumn);

        grid.setDataSource(GridDataItem.GenerateData(200));

        layout.addView(grid);
        sampleContainer.addView(layout);
    }

    @Override
    protected String getDescription() {
        return "The Grid's Text Column can be customized by setting properties like text color, font size, background color, alignment, and width.";
    }
}
