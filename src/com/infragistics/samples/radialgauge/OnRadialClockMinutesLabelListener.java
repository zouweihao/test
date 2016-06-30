package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;

public class OnRadialClockMinutesLabelListener implements OnRadialGaugeFormatLabelListener {
	
	@Override
	public void onFormatLabel(RadialGaugeView radialGauge, RadialGaugeFormatLabelEvent event) {
		event.setLabel("");
	}
}