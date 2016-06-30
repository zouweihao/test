package com.infragistics.samples.grid;

import android.app.Activity;
import android.widget.LinearLayout;
import com.infragistics.controls.*;
import com.infragistics.data.GridDataItem;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.SampleLayout;

public class GridImageColumnSample extends SampleLayout {
    public GridImageColumnSample(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        DataGridView grid = new DataGridView(context);
        grid.setRowHeight(100);

        grid.setAutoGenerateColumns(false);

        ImageColumn imageColumn = new ImageColumn();
        imageColumn.setKey("imageName");
        imageColumn.setHeaderText("Photo");
        //imageColumn.setImageStretchOption(ImageStretchOptions.);
        grid.addColumn(imageColumn);

        grid.setDataSource(IGSalesmanItem.GenerateData(200));

        layout.addView(grid);
        sampleContainer.addView(layout);
    }

    @Override
    protected String getDescription() {
        return "The Grid's Image Column has all the customization features of the Text Column, and image stretch options.";
    }
}
