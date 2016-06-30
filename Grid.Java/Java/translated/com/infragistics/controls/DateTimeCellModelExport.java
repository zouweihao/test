//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class DateTimeCellModelExport
extends CellModelExport {

private java.util.Calendar _dateTimeValue;
public java.util.Calendar setDateTimeValue(java.util.Calendar value) {
_dateTimeValue = value;
return value;
}
public java.util.Calendar getDateTimeValue() {
	return _dateTimeValue;
}


private int _dateTimeFormat;
public int setDateTimeFormat(int value) {
_dateTimeFormat = value;
return value;
}
public int getDateTimeFormat() {
	return _dateTimeFormat;
}


protected String getType() {

		return "DateTimeCell";

}


protected void serializeOverride(IGStringBuilder sb) {
	super.serializeOverride(sb);
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("dateTimeFormat : ", getDateTimeFormat()), ", "));
}

}
