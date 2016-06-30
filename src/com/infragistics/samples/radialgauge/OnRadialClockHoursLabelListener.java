package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;

public class OnRadialClockHoursLabelListener implements OnRadialGaugeFormatLabelListener {
	
	@Override
	public void onFormatLabel(RadialGaugeView radialGauge, RadialGaugeFormatLabelEvent event) {
		
		double value =  event.getValue();
		String label = String.format("%1$,.0f", value);
		
		if (value == 0.0 || value == 12.0 )
			label = "12";
		
		event.setLabel(label);
	}
}