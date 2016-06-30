package com.infragistics.samplesbrowser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class SampleDescDialog extends DialogFragment {

    private String _desc;

    public void setDescription(String desc) {
        _desc = desc;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(_desc)
			.setNegativeButton("Close", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {

				}
			})
        .setPositiveButton("Download Now!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
				Uri uri = Uri.parse("http://www.infragistics.com/products/android");
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }});
        return builder.create();
    }
}