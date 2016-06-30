package com.infragistics.samples.grid;

import android.app.Activity;
import android.widget.LinearLayout;
import com.infragistics.controls.*;
import com.infragistics.data.GridDataItem;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.SampleLayout;

public class GridDateTimeColumnSample extends SampleLayout {
    public GridDateTimeColumnSample(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        DataGridView grid = new DataGridView(context);
        grid.setRowHeight(50);

        grid.setAutoGenerateColumns(false);

        DateTimeColumn dateColumn = new DateTimeColumn();
        dateColumn.setKey("Date");
        dateColumn.setHeaderText("Long Date");
        dateColumn.setDateTimeFormat(DateTimeFormats.DATE_LONG);
        ColumnWidth twoStar = new ColumnWidth();
        twoStar.setIsStarSized(true);
        twoStar.setValue(2);
        dateColumn.setWidth(twoStar);

        DateTimeColumn dateColumn2 = new DateTimeColumn();
        dateColumn2.setKey("Date");
        dateColumn2.setHeaderText("Short Date");
        dateColumn2.setDateTimeFormat(DateTimeFormats.DATE_SHORT);

        DateTimeColumn timeColumn = new DateTimeColumn();
        timeColumn.setKey("Date");
        timeColumn.setHeaderText("Short Time");
        timeColumn.setDateTimeFormat(DateTimeFormats.TIME_SHORT);

        grid.addColumn(dateColumn);
        grid.addColumn(dateColumn2);
        grid.addColumn(timeColumn);

        grid.setDataSource(GridDataItem.GenerateData(200));

        layout.addView(grid);
        sampleContainer.addView(layout);
    }

	@Override
	protected String getDescription() {
		return "The Grid's DateTime Column has all the customization features of the Text Column, together with several pre defined DateTime formats to choose from, e.g. short date/time, long date/time.";
	}
}
