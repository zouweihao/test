package com.infragistics.samples.grid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.infragistics.controls.Column;
import com.infragistics.controls.ColumnExchangingStyle;
import com.infragistics.controls.ColumnMovingStyle;

public class GridExchangeColumnAnimation extends GridAnimationSampleBase {

    final Column YearToDateSalesColumn;
    boolean ytdShown;

    public GridExchangeColumnAnimation(Activity activity) {
        super(activity);

        //Create the Column to exchange later
        YearToDateSalesColumn = createTextColumn("yearToDateSales", "YTD Sales");
    }

    @Override
    int getDefaultAnimationStyle() {
        return GridView.getColumnExchangingAnimationStyle().getValue();
    }

    @Override
    void updateAnimationStyle(int style) {
        GridView.setColumnExchangingAnimationStyle(ColumnExchangingStyle.valueOf(style));
    }

    @Override
    SpinnerAdapter getStyleAdapter() {
        ArrayAdapter<ColumnExchangingStyle> arrayAdapter =
                new ArrayAdapter<ColumnExchangingStyle>(context, android.R.layout.simple_spinner_item, ColumnExchangingStyle.values());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return arrayAdapter;
    }

    @Override
    ViewGroup getButtonPanel() {
        LinearLayout layout = new LinearLayout(context);

        Button addCol = new Button(context);
        addCol.setText("Exchange");
        addCol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ytdShown) {
                    GridView.exchangeColumn(TerritoryColumn, YearToDateSalesColumn);
                    ytdShown = false;
                } else {
                    GridView.exchangeColumn(YearToDateSalesColumn, TerritoryColumn);
                    ytdShown = true;
                }

            }
        });


        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(addCol);

        return layout;
    }

    @Override
    void addPhases(ExpandedAnimationAdapter adapter) {
        adapter.addConfig("Exchange Main Phase", GridView.getColumnAnimationSettings().getColumnExchangingMainPhase());
        adapter.addConfig("Exchange Clean-up Phase", GridView.getColumnAnimationSettings().getColumnExchangingCleanupPhase());
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates Exchanging two Columns and the accompanying animations.";
    }
}
