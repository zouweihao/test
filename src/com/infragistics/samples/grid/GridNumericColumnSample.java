package com.infragistics.samples.grid;

import android.app.Activity;
import android.widget.LinearLayout;
import com.infragistics.controls.DataGridView;
import com.infragistics.controls.GridSelectionMode;
import com.infragistics.controls.NumericColumn;
import com.infragistics.controls.TextColumn;
import com.infragistics.data.GridDataItem;
import com.infragistics.samplesbrowser.SampleLayout;

public class GridNumericColumnSample extends SampleLayout {

    public GridNumericColumnSample(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        DataGridView grid = new DataGridView(context);
        grid.setRowHeight(50);

        grid.setAutoGenerateColumns(false);

        TextColumn nameColumn = new TextColumn();
        nameColumn.setKey("Name");
        nameColumn.setHeaderText("Employee Name");

        NumericColumn numericColumn = new NumericColumn();
        numericColumn.setKey("Value");
        numericColumn.setHeaderText("Value");
        numericColumn.setMinDecimalPlaces(2);
        numericColumn.setMaxDecimalPlaces(4);

        grid.addColumn(nameColumn);
        grid.addColumn(numericColumn);

        grid.setDataSource(GridDataItem.GenerateData(200));

        layout.addView(grid);
        sampleContainer.addView(layout);

    }

    @Override
    protected String getDescription() {
        return "The Grid's Numeric Column has all the customization features of the Text Column, and control over the decimal places.";
    }
}