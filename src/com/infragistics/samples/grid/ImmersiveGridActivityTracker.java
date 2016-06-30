package com.infragistics.samples.grid;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.infragistics.controls.*;
import com.infragistics.data.GridActivityItem;
import com.infragistics.extensions.Colors;
import com.infragistics.samplesbrowser.MainActivity;
import com.infragistics.samplesbrowser.SampleLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ImmersiveGridActivityTracker extends SampleLayout {

    private final DataGridView _grid = new DataGridView(context);

    public ImmersiveGridActivityTracker(Activity activity) {
        super(activity);

        int contentWidth = ((MainActivity) activity).getContentWidth();
        int contentHeight = ((MainActivity) activity).getContentHeight();

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        _grid.setColumnExchangingAnimationStyle(ColumnExchangingStyle.SLIDE_TO_RIGHT);

        _grid.setRowHeight(60);
        _grid.setAutoGenerateColumns(false);

        ImageColumn _imageCol = new ImageColumn();
        _imageCol.setKey("imageName");
        _imageCol.setHeaderText("Activity");
        ColumnWidth fixedWidth = new ColumnWidth();
        //fixedWidth.setMinimumWidth(100);
        fixedWidth.setValue(80);
        fixedWidth.setIsStarSized(false);
        _imageCol.setWidth(fixedWidth);

        TemplateColumn _durationCol = new TemplateColumn();
        _durationCol.setKey("timeInSeconds");
        _durationCol.setIsHidden(true);
        _durationCol.setHeaderText("Duration");
        _durationCol.setOnTemplateCellStateChangedListener(new OnTemplateCellStateChangedListener() {
            @Override
            public void cellCreatedOrUpdated(TemplateCellInfo templateCellInfo, ViewGroup viewGroup) {
                TextView durationText;
                if (viewGroup.getChildCount() == 0) {
                    durationText = new TextView(context);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
                    durationText.setTextColor(Colors.Black);
                    viewGroup.addView(durationText, lp);
                } else {
                    durationText = (TextView) viewGroup.getChildAt(0);
                }
                durationText.setText(getDurationString((Integer) templateCellInfo.getValue()));
            }
        });
        _durationCol.setOnStyleKeyResolvingListener(new OnStyleKeyResolvingListener() {
            @Override
            public String resolveStyleKey(String s, Object o, int i) {
                return "durationTemplate";
            }
        });

        TemplateColumn _distanceCol = new TemplateColumn();
        _distanceCol.setKey("distance");
        _distanceCol.setIsHidden(true);
        _distanceCol.setHeaderText("Distance");
        _distanceCol.setHorizontalAlignment(HorizontalAlignment.CENTER);
        _distanceCol.setVerticalAlignment(VerticalAlignment.CENTER);
        _distanceCol.setOnTemplateCellStateChangedListener(new OnTemplateCellStateChangedListener() {
            @Override
            public void cellCreatedOrUpdated(TemplateCellInfo templateCellInfo, ViewGroup viewGroup) {
                TextView distanceText;
                if (viewGroup.getChildCount() == 0) {
                    distanceText = new TextView(context);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
                    distanceText.setTextColor(Colors.Black);
                    viewGroup.addView(distanceText, lp);
                } else {
                    distanceText = (TextView) viewGroup.getChildAt(0);
                }
                distanceText.setText(String.format("%.2f miles", (Float) templateCellInfo.getValue()));
            }
        });
        _distanceCol.setOnStyleKeyResolvingListener(new OnStyleKeyResolvingListener() {
            @Override
            public String resolveStyleKey(String s, Object o, int i) {
                return "distanceTemplate";
            }
        });


        TextColumn _notesCol = createTextColumn("notes");
        _notesCol.setIsHidden(true);
        _notesCol.setHeaderText("Notes");
        ColumnWidth width2 = new ColumnWidth();
        width2.setValue(2);
        width2.setIsStarSized(true);
        _notesCol.setWidth(width2);

        TextColumn _locationCol = createTextColumn("location");
        _locationCol.setIsHidden(true);
        _locationCol.setHeaderText("Location");

        DateTimeColumn _dateCol = new DateTimeColumn();
        _dateCol.setKey("date");
        _dateCol.setDateTimeFormat(DateTimeFormats.DATE_LONG);
        _dateCol.setHeaderText("Date");

        TemplateColumn _activityDetailsCol = new TemplateColumn();
        _activityDetailsCol.setKey("record");
        _activityDetailsCol.setHeaderText("Details");
        _activityDetailsCol.setOnTemplateCellStateChangedListener(new ActivityColumnCellStateChanged());

        _grid.addColumn(_imageCol);
        _grid.addColumn(_activityDetailsCol);

        _grid.addColumn(_locationCol);
        _grid.addColumn(_distanceCol);
        _grid.addColumn(_durationCol);
        _grid.addColumn(_notesCol);

        ResponsiveState landscapeState = new ResponsiveState();
        landscapeState.setName("Landscape State");
        landscapeState.setIsManualState(true);

        landscapeState.addResponsivePhase()
                .addColumnExchanger(new ColumnExchanger(_dateCol, 1))
                .setDelayMilliseconds(200);
        landscapeState.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("location", "IsHidden", false))
                .addColumnPropertySetter(new ColumnPropertySetter("distance", "IsHidden", false))
                .addColumnPropertySetter(new ColumnPropertySetter("duration", "IsHidden", false))
                .addColumnPropertySetter(new ColumnPropertySetter("notes", "IsHidden", false));

        _grid.addResponsiveState(landscapeState);

        ResponsiveState portraitState = new ResponsiveState();
        portraitState.setName("Portrait State");
        portraitState.setIsManualState(true);

        portraitState.addResponsivePhase()
                .addColumnPropertySetter(new ColumnPropertySetter("location", "IsHidden", true))
                .addColumnPropertySetter(new ColumnPropertySetter("distance", "IsHidden", true))
                .addColumnPropertySetter(new ColumnPropertySetter("duration", "IsHidden", true))
                .addColumnPropertySetter(new ColumnPropertySetter("notes", "IsHidden", true))
                .setDelayMilliseconds(200);
        portraitState.addResponsivePhase()
                .addColumnExchanger(new ColumnExchanger(_activityDetailsCol, 1));

        _grid.addResponsiveState(portraitState);

        _grid.setDataSource(GridActivityItem.GenerateData(200));

        //Here we need to set the initial state...
        if (contentHeight > contentWidth) {
            _grid.setActiveResponsiveState("Portrait State");
        } else {
            _grid.setActiveResponsiveState("Landscape State");
        }

        layout.addView(_grid);
        sampleContainer.addView(layout);
    }

    private TextColumn createTextColumn(String key) {
        TextColumn col = new TextColumn();
        col.setKey(key);
        return col;
    }

    private class ActivityColumnCellStateChanged implements OnTemplateCellStateChangedListener {
        @Override
        public void cellCreatedOrUpdated(TemplateCellInfo cellInfo, ViewGroup viewGroup) {
            GridActivityItem item = (GridActivityItem) cellInfo.getValue();

            LinearLayout mainLayout;
            LinearLayout topRow;
            LinearLayout middleRow;
            TextView locationView;
            TextView distanceView;
            TextView durationView;
            TextView notesView;
            TextView dateView;

            if (viewGroup.getChildCount() == 0) {
                mainLayout = new LinearLayout(context);
                mainLayout.setOrientation(LinearLayout.VERTICAL);

                topRow = new LinearLayout(context);
                topRow.setOrientation(LinearLayout.HORIZONTAL);
                topRow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                mainLayout.addView(topRow);

                middleRow = new LinearLayout(context);
                middleRow.setOrientation(LinearLayout.HORIZONTAL);
                middleRow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                mainLayout.addView(middleRow);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);

                dateView = new TextView(context);
                topRow.addView(dateView);
                dateView.setTextColor(Colors.Black);
                dateView.setLayoutParams(lp);

                locationView = new TextView(context);
                topRow.addView(locationView);
                locationView.setTextColor(Colors.Black);
                locationView.setLayoutParams(lp);
                locationView.setGravity(Gravity.RIGHT);

                distanceView = new TextView(context);
                middleRow.addView(distanceView);
                distanceView.setTextColor(Colors.Black);
                distanceView.setLayoutParams(lp);

                durationView = new TextView(context);
                middleRow.addView(durationView);
                durationView.setTextColor(Colors.Black);
                durationView.setGravity(Gravity.RIGHT);
                durationView.setLayoutParams(lp);

                notesView = new TextView(context);
                mainLayout.addView(notesView);
                notesView.setTextColor(Colors.Black);

                viewGroup.addView(mainLayout);
            } else {
                mainLayout = (LinearLayout) viewGroup.getChildAt(0);
                topRow = (LinearLayout) mainLayout.getChildAt(0);
                middleRow = (LinearLayout) mainLayout.getChildAt(1);

                dateView = (TextView) topRow.getChildAt(0);
                locationView = (TextView) topRow.getChildAt(1);

                distanceView = (TextView) middleRow.getChildAt(0);
                durationView = (TextView) middleRow.getChildAt(1);

                notesView = (TextView) mainLayout.getChildAt(2);
            }

            DateFormat ndf = new SimpleDateFormat("MM/dd/yyyy");
            String formatted = ndf.format(item.date.getTime());
            dateView.setText(formatted);

            locationView.setText(item.location);
            distanceView.setText(String.format("%.2f miles", item.distance));

            durationView.setText(getDurationString(item.timeInSeconds));

            notesView.setText("Notes: " + item.notes);
        }
    }

    private String getDurationString(int timeInSeconds) {
        int hours = timeInSeconds / 3600;
        int minutes = (timeInSeconds % 3600) / 60;
        int seconds = timeInSeconds % 60;

        if (hours == 0) {
            return String.format("%dm %ds", minutes, seconds);
        } else {
            return String.format("%dh %dm %ds", hours, minutes, seconds);
        }
    }

    @Override
    protected String getDescription() {
        return "This sample demonstrates using the grid to simulate an application used to track exercise activities.";
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
