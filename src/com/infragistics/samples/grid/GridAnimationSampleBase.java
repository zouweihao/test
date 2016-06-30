package com.infragistics.samples.grid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.infragistics.controls.Column;
import com.infragistics.controls.ColumnShowingStyle;
import com.infragistics.controls.DataGridView;
import com.infragistics.controls.TextColumn;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.SampleLayout;

public abstract class GridAnimationSampleBase extends SampleLayout {

    final DataGridView GridView;
    final Column FirstNameColumn;
    final Column LastNameColumn;
    final Column TerritoryColumn;

    public GridAnimationSampleBase(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout controlsLayout = new LinearLayout(context);
        controlsLayout.setOrientation(LinearLayout.HORIZONTAL);

        GridView = new DataGridView(context);
        GridView.setAutoGenerateColumns(false);
        GridView.setRowHeight(50);

        FirstNameColumn = createTextColumn("firstName", "First Name");
        LastNameColumn = createTextColumn("lastName", "Last Name");
        TerritoryColumn = createTextColumn("territory", "Territory");

        GridView.addColumn(FirstNameColumn);
        GridView.addColumn(LastNameColumn);
        GridView.addColumn(TerritoryColumn);

        GridView.setDataSource(IGSalesmanItem.GenerateData(200));

        controlsLayout.addView(getButtonPanel());
        Spinner animOpt = new Spinner(context);
        animOpt.setAdapter(getStyleAdapter());

        animOpt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                updateAnimationStyle(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        animOpt.setSelection(getDefaultAnimationStyle());

        controlsLayout.addView(animOpt);

        //ExpandableListView listView = new ExpandableListView(context);
        //ExpandedAnimationAdapter adapter = new ExpandedAnimationAdapter(context);

        //addPhases(adapter);

        //listView.setAdapter(adapter);

        layout.addView(controlsLayout);
        //layout.addView(listView);
        layout.addView(GridView);

        sampleContainer.addView(layout);
    }

    TextColumn createTextColumn(String key, String headerText) {
        TextColumn col = new TextColumn();
        col.setKey(key);
        col.setHeaderText(headerText);
        return col;
    }

    abstract int getDefaultAnimationStyle();

    abstract void updateAnimationStyle(int style);

    abstract SpinnerAdapter getStyleAdapter();

    abstract ViewGroup getButtonPanel();

    abstract void addPhases(ExpandedAnimationAdapter adapter);

}
