//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class DateTimeCellModel
extends CellModel {
public static final String DateTimeValuePropertyName = "DateTimeValue";

private java.util.Calendar _dateTimeValue = com.infragistics.controls.DateHelpers.getMinValue();


public java.util.Calendar setDateTimeValue(java.util.Calendar value) {

	java.util.Calendar oldValue = _dateTimeValue;
	_dateTimeValue = value;
	if (com.infragistics.controls.DateHelpers.areNotEqual(_dateTimeValue, oldValue)) {
		onPropertyChanged(DateTimeValuePropertyName, oldValue, _dateTimeValue);
	}

return value;
}
public java.util.Calendar getDateTimeValue() {

		return _dateTimeValue;

}

public static final String DateTimeFormatPropertyName = "DateTimeFormat";

private DateTimeFormats _dateTimeFormat;


public DateTimeFormats setDateTimeFormat(DateTimeFormats value) {

	DateTimeFormats oldValue = _dateTimeFormat;
	_dateTimeFormat = value;
	if (_dateTimeFormat != oldValue) {
		onPropertyChanged(DateTimeFormatPropertyName, oldValue, _dateTimeFormat);
	}

return value;
}
public DateTimeFormats getDateTimeFormat() {

		return _dateTimeFormat;

}


public void setPropertyValue(String propertyName, Object value) {
	super.setPropertyValue(propertyName, value);
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, DateTimeFormatPropertyName)) {
		setDateTimeFormat((DateTimeFormats)value);
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, DateTimeValuePropertyName)) {
		setDateTimeValue((java.util.Calendar)value);
	}

}


public Object getPropertyValue(String propertyName) {
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, DateTimeFormatPropertyName)) {
		return getDateTimeFormat();
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, DateTimeValuePropertyName)) {
		return getDateTimeValue();
	}

	return super.getPropertyValue(propertyName);
}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new DateTimeCellModelExport();
	}

	export = super.createModelExport(export);
	DateTimeCellModelExport dateTimeExport = (DateTimeCellModelExport)export;
	dateTimeExport.setDateTimeValue(this.getDateTimeValue());
	dateTimeExport.setDateTimeFormat((int)this.getDateTimeFormat().getValue());
	return dateTimeExport;
}

}
