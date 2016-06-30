//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class SpacerEffect
extends GridEffect {

private long _spacerId;
public long setSpacerId(long value) {
_spacerId = value;
return value;
}
public long getSpacerId() {
	return _spacerId;
}


public boolean appliesToSpacer(GridColumnSpacer spacer, VisualModel model) {
	return spacer.getUniqueId() == getSpacerId();
}

}
