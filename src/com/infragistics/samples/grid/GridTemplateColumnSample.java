package com.infragistics.samples.grid;

import android.app.Activity;
import android.graphics.drawable.shapes.*;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.infragistics.controls.*;
import com.infragistics.data.GridDataItem;
import com.infragistics.extensions.Colors;
import com.infragistics.samplesbrowser.SampleLayout;

public class GridTemplateColumnSample extends SampleLayout {
    public GridTemplateColumnSample(Activity activity) {
        super(activity);


        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        DataGridView grid = new DataGridView(context);
        grid.setRowHeight(50);

        grid.setAutoGenerateColumns(false);

        TemplateColumn templateColumn = new TemplateColumn();
        templateColumn.setKey("Self");
        templateColumn.setHeaderText("Details");

        templateColumn.setOnStyleKeyResolvingListener(new OnStyleKeyResolvingListener() {
            @Override
            public String resolveStyleKey(String defaultStyleKey, Object resolvedValue, int rowNumber) {
                GridDataItem item = (GridDataItem) resolvedValue;

                if (item.Sales > 35000) {
                    return "goodSales";
                } else if (item.Sales < 15000) {
                    return "okSales";
                } else {
                    return "badSales";
                }
            }
        });

        templateColumn.setOnTemplateCellStateChangedListener(new OnTemplateCellStateChangedListener() {
            @Override
            public void cellCreatedOrUpdated(TemplateCellInfo templateCellInfo, ViewGroup viewGroup) {
                TextView descText;

                if (viewGroup.getChildCount() == 0) {
                    TextView stateText = new TextView(context);
                    String styleKey = templateCellInfo.getStyleKey();
                    stateText.setTextColor(Colors.White);

                    if (styleKey.equals("goodSales")) {
                        stateText.setText("Good");
                        stateText.setBackgroundColor(Colors.Green);
                    } else if (styleKey.equals("okSales")) {
                        stateText.setText("Ok");
                        stateText.setBackgroundColor(Colors.GrayLight);
                    } else {
                        stateText.setText("Bad");
                        stateText.setBackgroundColor(Colors.Red);
                    }
                    descText = new TextView(context);
                    stateText.setGravity(Gravity.CENTER_VERTICAL);
                    descText.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                    LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.2f);
                    LinearLayout.LayoutParams lp8 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.8f);
                    descText.setTextColor(Colors.Black);
                    viewGroup.addView(stateText, lp2);
                    viewGroup.addView(descText, lp8);
                } else {
                    descText = (TextView) viewGroup.getChildAt(1);
                }

                GridDataItem item = (GridDataItem) templateCellInfo.getValue();
                descText.setText(item.Name + " has sold " + item.Sales + " units in " + item.Territory);

            }
        });


        grid.addColumn(templateColumn);

        grid.setDataSource(GridDataItem.GenerateData(200));

        layout.addView(grid);
        sampleContainer.addView(layout);

    }

    @Override
    protected String getDescription() {
        return "The Grid's Template Column allows you to customize the layout of content in the column.";
    }
}