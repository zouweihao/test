package com.infragistics.samples.grid;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.infragistics.controls.*;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.MainActivity;
import com.infragistics.samplesbrowser.SampleLayout;
import org.w3c.dom.Text;

public class ResponsiveGridSideBarSample extends SampleLayout {

    public ResponsiveGridSideBarSample(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final int maxContentWidth = ((MainActivity) activity).getContentWidth(); //(int) APIHelpers.fromPixelUnits(TypedValue.COMPLEX_UNIT_DIP, ((MainActivity) activity).getContentWidth());
        final int leftGutterFirstStop = (int) (maxContentWidth * .25);
        final int leftGutterSecondStop = (int) (maxContentWidth * .4);
        final int firstResponsiveBreakPoint = maxContentWidth - leftGutterFirstStop;
        final int secondResponsiveBreakPoint = maxContentWidth - leftGutterSecondStop;

        LinearLayout buttonBar = new LinearLayout(context);
        buttonBar.setOrientation(LinearLayout.HORIZONTAL);

        layout.addView(buttonBar);

        LinearLayout contentLayout = new LinearLayout(context);
        contentLayout.setOrientation(LinearLayout.HORIZONTAL);

        layout.addView(contentLayout);

        final FrameLayout leftGutter = new FrameLayout(context);
        leftGutter.setMinimumWidth(0);
        leftGutter.setMinimumHeight(100);

        contentLayout.addView(leftGutter);

        Button toggleBarButton = new Button(context);
        toggleBarButton.setText("Change Grid Size");

        buttonBar.addView(toggleBarButton);
        toggleBarButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (leftGutter.getWidth() == 0) {
                    resizeAnimationHelper(leftGutter, leftGutterFirstStop);
                } else if (leftGutter.getWidth() == leftGutterFirstStop) {
                    resizeAnimationHelper(leftGutter, leftGutterSecondStop);
                } else if (leftGutter.getWidth() == leftGutterSecondStop) {
                    resizeAnimationHelper(leftGutter, 0);
                }
            }
        });

        DataGridView grid = new DataGridView(context);
        grid.setAutoGenerateColumns(false);
        grid.setRowHeight(50);

        ImageColumn col = new ImageColumn();
        col.setKey("imageName");
        col.setHeaderText("Photo");
        grid.addColumn(col);

        grid.addColumn(createTextColumn("index", "Index"));
        grid.addColumn(createTextColumn("firstName", "First Name"));
        grid.addColumn(createTextColumn("lastName", "Last Name"));
        grid.addColumn(createTextColumn("territory", "Territory"));

        grid.setDataSource(IGSalesmanItem.GenerateData(200));

        ResponsiveState rsbp2 = new ResponsiveState();
        rsbp2.setName("Second Breakpoint");
        rsbp2.setMaximumWidth(TypedValue.COMPLEX_UNIT_PX, secondResponsiveBreakPoint);
        rsbp2.setMinimumWidth(0);

        rsbp2.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("index", "IsHidden", true))
                .addColumnPropertySetter(new ColumnPropertySetter("territory", "IsHidden", true));

        grid.addResponsiveState(rsbp2);

        ResponsiveState rsbp1 = new ResponsiveState();
        rsbp1.setName("First Breakpoint");
        rsbp1.setMaximumWidth(TypedValue.COMPLEX_UNIT_PX, firstResponsiveBreakPoint);
        rsbp1.setMinimumWidth(TypedValue.COMPLEX_UNIT_PX, secondResponsiveBreakPoint + 1);

        rsbp1.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("territory", "IsHidden", true));

        grid.addResponsiveState(rsbp1);

        ResponsiveState rsbp0 = new ResponsiveState();
        rsbp0.setName("Default State");
        rsbp0.setMaximumWidth(TypedValue.COMPLEX_UNIT_PX, Integer.MAX_VALUE);
        rsbp0.setMinimumWidth(TypedValue.COMPLEX_UNIT_PX, firstResponsiveBreakPoint + 1);

        rsbp0.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("territory", "IsHidden", false))
                .addColumnPropertySetter(new ColumnPropertySetter("index", "IsHidden", false));

        grid.addResponsiveState(rsbp0);

        contentLayout.addView(grid);
        this.addView(layout);
    }

    private void resizeAnimationHelper(final View view, int ending) {
        Log.i("Grid Sample", "Animating to: " + ending);
        int starting = view.getWidth();
        ValueAnimator resizerAnimator = ValueAnimator.ofInt(starting, ending);
        resizerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                view.setMinimumWidth(val);
            }
        });
        resizerAnimator.setDuration(500);
        resizerAnimator.start();
    }

    private TextColumn createTextColumn(String key, String headerText) {
        TextColumn col = new TextColumn();
        col.setKey(key);
        col.setHeaderText(headerText);
        return col;
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates dynamically changing the visible columns based on available width.";
    }
}

