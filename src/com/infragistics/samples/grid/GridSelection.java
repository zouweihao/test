package com.infragistics.samples.grid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.infragistics.controls.*;
import com.infragistics.data.IGSalesmanItem;
import com.infragistics.samplesbrowser.SampleLayout;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GridSelection extends SampleLayout {

    private final ArrayList<IGSalesmanItem> _dataSource;
    private final ImageView _personImage;
    private final TextView _personFullName;
    private final Handler _handler;
    private ReadImageTask _task;

    public GridSelection(Activity activity) {
        super(activity);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final DataGridView grid = new DataGridView(context);
        grid.setRowHeight(100);

        //grid.setColumnSpacingWidth(15);
        _dataSource = IGSalesmanItem.GenerateData(200);
        grid.setAutoGenerateColumns(false);
        grid.setDataSource(_dataSource);
        grid.setSelectionMode(GridSelectionMode.SINGLE_ROW);
        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0);
        gridParams.weight = 1;

        ImageColumn col = new ImageColumn();
        col.setKey("imageName");
        col.setHeaderText("Photo");
        grid.addColumn(col);

        grid.addColumn(createTextColumn("index", "Index"));
        grid.addColumn(createTextColumn("firstName", "First Name"));
        grid.addColumn(createTextColumn("lastName", "Last Name"));
        grid.addColumn(createTextColumn("territory", "Territory"));

        grid.setLayoutParams(gridParams);

        LinearLayout selectedArea = new LinearLayout(context);
        selectedArea.setOrientation(LinearLayout.VERTICAL);
        TextView title = new TextView(context);
        title.setText("Selected Item");
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        title.setLayoutParams(titleParams);
        selectedArea.addView(title);
        LinearLayout itemArea = new LinearLayout(context);
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, context.getResources().getDisplayMetrics()));
        itemParams.weight = 0;
        itemArea.setLayoutParams(itemParams);
        selectedArea.addView(itemArea);
        itemArea.setOrientation(LinearLayout.HORIZONTAL);

        _personImage = new ImageView(context);
        _personFullName = new TextView(context);

        itemArea.addView(_personImage);
        itemArea.addView(_personFullName);

        _handler = new Handler(context.getMainLooper());

        grid.setOnGridSelectedIndexesChangedListener(new OnGridSelectedIndexesChangedListener() {
            @Override
            public void selectedIndexesChanged(DataGridView dataGridView, GridSelectedIndexesChangedEvent gridSelectedIndexesChangedEvent) {
                final int index = dataGridView.getSelectedIndex();
                _currentSelectedIndex = index;

                _handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateCurrentItem(index);
                    }
                }, grid.getAnimationSettings().getRowSelectionMainPhase().getDurationMilliseconds());
            }
        });

        layout.addView(grid);
        layout.addView(selectedArea);
        sampleContainer.addView(layout);
    }

    private TextColumn createTextColumn(String key, String headerText) {
        TextColumn col = new TextColumn();
        col.setKey(key);
        col.setHeaderText(headerText);
        return col;
    }

    private void updateCurrentItem(int targetIndex) {
        if (targetIndex != _currentSelectedIndex) {
            return;
        }

        int index = _currentSelectedIndex;
        if (index == -1) {
            _personImage.setImageBitmap(null);
            _personFullName.setText("");
            return;
        }

        IGSalesmanItem item = _dataSource.get(index);
        String imageAsset = item.imageName;
        String fullName = item.firstName + " " + item.lastName;

        if (_task != null) {
            _task.cancel(true);
            _task = null;
        }
        _task = new ReadImageTask(_personImage);
        _task.execute(imageAsset);

        _personFullName.setText(fullName);
    }

    private int _currentSelectedIndex = -1;

    private class ReadImageTask extends AsyncTask<String, Void, Bitmap> {
        private final ImageView _target;

        public ReadImageTask(ImageView target) {
           _target = target;
        }

        protected Bitmap doInBackground(String... strings) {
            try {
                InputStream e = null;
                String file = strings[0].replace("asset://", "");
                e = GridSelection.this.getResources().getAssets().open(file);

                if(!this.isCancelled()) {
                    return BitmapFactory.decodeStream(e);
                }
            } catch (Exception var3) {
                var3.printStackTrace();
            }

            return null;
        }

        protected void onCancelled() {
            super.onCancelled();
        }

        protected void onPostExecute(Bitmap bitmap) {
            if(!this.isCancelled()) {
                _target.setImageBitmap(bitmap);
            }

        }
    }

    @Override
    protected String getDescription() {
        return "Here is a basic grid showing selection to support a master / detail view.";
    }
}
