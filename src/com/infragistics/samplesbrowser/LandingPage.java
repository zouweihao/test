package com.infragistics.samplesbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LandingPage extends SampleLayout {
    public LandingPage(MainActivity activity) {
        super(activity);

        sampleContainer.addView(LayoutInflater.from(getContext()).inflate(R.layout.welcome_page, this, false));

        SampleParentsListAdapter parentsListAdapter = new SampleParentsListAdapter((MainActivity) context, SamplesParentData.getSampleData());

        ListView listView = (ListView) findViewById(R.id.welcome_listView);
        listView.setAdapter(parentsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SamplesParentData data = (SamplesParentData) adapterView.getItemAtPosition(i);
                if (data.SubLinks.size() == 1) {
                    String sample = data.SubLinks.entrySet().iterator().next().getValue();
                    ((MainActivity) context).jumpToSample(sample);
                } else {
                    setupTopicChooser(data);
                }
            }
        });
    }

    private void setupTopicChooser(final SamplesParentData data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose a Topic!");
        final CharSequence[] options = new CharSequence[data.SubLinks.size()];

        int i = 0;
        for (String s : data.SubLinks.keySet()) {
            options[i++] = s;
        }

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String sampleName = data.SubLinks.get(options[i]);
                ((MainActivity) context).jumpToSample(sampleName);
            }
        });

        builder.create().show();
    }

    @Override
    protected String getDescription() {
        return "Welcome to the Infragistics Android Samples Browser.";
    }
}
