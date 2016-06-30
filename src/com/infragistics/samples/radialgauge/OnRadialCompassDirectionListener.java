package com.infragistics.samples.radialgauge;

import com.infragistics.controls.*;

public class OnRadialCompassDirectionListener implements OnRadialGaugeFormatLabelListener {
	
	@Override
	public void onFormatLabel(RadialGaugeView radialGauge, RadialGaugeFormatLabelEvent event) {
		//String label = String.format("", event.getValue());
		
		double value =  event.getValue();
		String label = String.format("%1$,.0f", value);
		
		if (value == 0.0 || value == 360.0 )
		{
			label = "N";
		}
		else if (value == 90.0)
			label = "E ";
		else if (value == 180.0)
			label = "S";
		else if (value == 270.0)
			label = " W";
		else if (value == 45.0)
			label = "NE";
		else if (value == 135.0)
			label = "SE";
		else if (value == 225.0)
			label = "SW";
		else if (value == 315.0)
			label = "NW";
		else
			label = "";
		
		event.setLabel(label);
	}
}
