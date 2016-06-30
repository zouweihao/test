package com.infragistics.samples.chart;

import java.text.DecimalFormat;

import com.infragistics.controls.*;

public class OnAxisNumericLabelListener implements OnAxisFormatLabelListener {
	
	private boolean UseCustomLabelsFormat = true;
	@Override
	public void onFormatLabel(Axis axis, AxisFormatLabelEvent event) {
		
		String label = event.getItem().toString();
		DecimalFormat df = new DecimalFormat("#.#");
		label = df.format(Double.valueOf(label));
		event.setLabel(label);
	}
}
