package com.infragistics.samples.grid;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.infragistics.controls.*;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.MainActivity;
import com.infragistics.samplesbrowser.SampleLayout;

public class ResponsiveGridRotationSample extends SampleLayout {

    final private DataGridView _grid;

    public ResponsiveGridRotationSample(Activity activity) {
        super(activity);

        int contentWidth = ((MainActivity) activity).getContentWidth();
        int contentHeight = ((MainActivity) activity).getContentHeight();


        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        this.addView(layout);

        _grid = new DataGridView(context);
        _grid.setAutoGenerateColumns(false);
        _grid.setRowHeight(50);

        ImageColumn _imageColumn = new ImageColumn();
        _imageColumn.setKey("imageName");
        _imageColumn.setHeaderText("Photo");

        TextColumn _firstNameColumn = createTextColumn("firstName", "First Name");
        TextColumn _lastNameColumn = createTextColumn("lastName", "Last Name");
        TextColumn _yearToDateSalesColumn = createTextColumn("yearToDateSales", "Sales");
        TextColumn _territoryColumn = createTextColumn("territory", "Territory");
        TextColumn _fullNameColumn = createTextColumn("fullName", "Name");

        _grid.addColumn(_imageColumn);
        _grid.addColumn(_firstNameColumn);
        _grid.addColumn(_lastNameColumn);
        _grid.addColumn(_territoryColumn);
        _grid.addColumn(_yearToDateSalesColumn);

        _grid.setDataSource(IGSalesmanItem.GenerateData(200));
        _grid.setColumnExchangingAnimationStyle(ColumnExchangingStyle.SLIDE_TO_RIGHT);

        ResponsiveState rsbp0 = new ResponsiveState();
        rsbp0.setName("Landscape State");
        rsbp0.setIsManualState(true);

        rsbp0.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("territory", "IsHidden", false))
                .addColumnPropertySetter(new ColumnPropertySetter("lastName", "IsHidden", false))
                .addColumnPropertySetter(new ColumnPropertySetter("yearToDateSales", "IsHidden", false))
                .setDelayMilliseconds(200);


        rsbp0.addResponsivePhase()
                .addColumnExchanger(new ColumnExchanger(_firstNameColumn, 1));

        _grid.addResponsiveState(rsbp0);

        ResponsiveState rsbp1 = new ResponsiveState();
        rsbp1.setName("Portrait State");
        rsbp1.setIsManualState(true);

        rsbp1.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("territory", "IsHidden", true))
                .addColumnPropertySetter(new ColumnPropertySetter("lastName", "IsHidden", true))
                .addColumnPropertySetter(new ColumnPropertySetter("yearToDateSales", "IsHidden", true))
                .setDelayMilliseconds(200);

        rsbp1.addResponsivePhase()
                .addColumnExchanger(new ColumnExchanger(_fullNameColumn, 1));

        _grid.addResponsiveState(rsbp1);

        //Here we need to set the initial state...
        if (contentHeight > contentWidth) {
            _grid.setActiveResponsiveState("Portrait State");
        } else {
            _grid.setActiveResponsiveState("Landscape State");
        }

        layout.addView(_grid);
    }

    private TextColumn createTextColumn(String key, String headerText) {
        TextColumn col = new TextColumn();
        col.setKey(key);
        col.setHeaderText(headerText);
        return col;
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates dynamically changing the visible columns based on orientation.";
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //Here we respond to orientation changes.
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            _grid.setActiveResponsiveState("Landscape State");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            _grid.setActiveResponsiveState("Portrait State");
        }
    }
}
