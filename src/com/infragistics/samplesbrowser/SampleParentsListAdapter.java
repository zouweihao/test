package com.infragistics.samplesbrowser;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;
import java.util.Set;

public class SampleParentsListAdapter extends ArrayAdapter<SamplesParentData> {

    private MainActivity _main;

    public SampleParentsListAdapter(MainActivity activity, List<SamplesParentData> objects) {
        super(activity.getApplicationContext(), 0, objects);

        _main = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SamplesParentData parentData = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.samples_parent_item, parent, false);
        }

        TextView textName = (TextView) convertView.findViewById(R.id.parent_Name);
        TextView textDesc = (TextView) convertView.findViewById(R.id.parent_Desc);
        ImageView image = (ImageView) convertView.findViewById(R.id.parent_imageView);

        textName.setText(parentData.Name);
        textDesc.setText(parentData.Description);
        image.setImageResource(parentData.ImageResourceId);

        return convertView;

    }
}
