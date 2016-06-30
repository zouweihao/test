package com.infragistics.samples.grid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.infragistics.controls.GridAnimationPhaseSettings;
import com.infragistics.samplesbrowser.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ExpandedAnimationAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<String> _animationTypes;
    private ArrayList<GridAnimationPhaseSettings> _configOptions;

    public ExpandedAnimationAdapter(Context context) {
        _context = context;
        _animationTypes = new ArrayList<String>();
        _configOptions = new ArrayList<GridAnimationPhaseSettings>();
    }

    public void addConfig(String animationType, GridAnimationPhaseSettings opts) {
        _animationTypes.add(animationType);
        _configOptions.add(opts);
    }

    @Override
    public int getGroupCount() {
        return _configOptions.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return _animationTypes.get(i);
    }

    @Override
    public Object getChild(int groupPos, int childPos) {
        return _configOptions.get(groupPos);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LinearLayout layout = new LinearLayout(_context);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(_context);
            layout.addView(textView);

            int[] attrs = new int[]{android.R.attr.expandableListPreferredChildPaddingLeft /* index 0 */};
            TypedArray ta = _context.obtainStyledAttributes(attrs);
            int padding = (int) ta.getDimension(0, 0f);
            textView.setPadding(padding, 5, 5, 5);

            convertView = layout;
        }

        TextView tv = (TextView) ((LinearLayout) convertView).getChildAt(0);
        tv.setText(headerTitle);
        tv.setTypeface(null, Typeface.BOLD);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //PhaseConfigurationView configView = (PhaseConfigurationView)convertView;
        return new PhaseConfigurationView(_context, _configOptions.get(groupPosition));
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
