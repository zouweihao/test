//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class DateTimeColumnImplementation
extends ColumnImplementation {
public static final String DateTimeFormatPropertyName = "DateTimeFormat";

private DateTimeFormats _dateTimeFormat;


public DateTimeFormats setDateTimeFormat(DateTimeFormats value) {

	DateTimeFormats oldValue = _dateTimeFormat;
	_dateTimeFormat = value;
	if (_dateTimeFormat != oldValue) {
		onPropertyChanged(DateTimeFormatPropertyName, CellPropertyAnimationType.DATE_VALUE, oldValue, _dateTimeFormat);
	}

return value;
}
public DateTimeFormats getDateTimeFormat() {

		return _dateTimeFormat;

}

public DateTimeColumnImplementation() {



		setDateTimeFormat(DateTimeFormats.DATE_SHORT);
}


protected CellModel createModelOverride(CellPath path) {
	return new DateTimeCellModel();
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "datetime";
}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onDataBind(cellModel, grid, resolvedValue);
	DateTimeCellModel dateTimeModel = (DateTimeCellModel)cellModel;
	dateTimeModel.setDateTimeValue(extractDateTime(resolvedValue));
	switch (this.getDateTimeFormat()) {
		case FULL:
			dateTimeModel.setRenderValue(com.infragistics.controls.DateHelpers.dateToString(dateTimeModel.getDateTimeValue(), "M/d/yyyy h:mm:ss tt"));
			break;
		case DATE_LONG:
			dateTimeModel.setRenderValue(com.infragistics.controls.DateHelpers.dateToString(dateTimeModel.getDateTimeValue(), "dddd, MMMM d, yyyy"));
			break;
		case DATE_SHORT:
			dateTimeModel.setRenderValue(com.infragistics.controls.DateHelpers.dateToString(dateTimeModel.getDateTimeValue(), "M/d/yyyy"));
			break;
		case TIME_LONG:
			dateTimeModel.setRenderValue(com.infragistics.controls.DateHelpers.dateToString(dateTimeModel.getDateTimeValue(), "h:mm:ss tt"));
			break;
		case TIME_SHORT:
			dateTimeModel.setRenderValue(com.infragistics.controls.DateHelpers.dateToString(dateTimeModel.getDateTimeValue(), "h:mm tt"));
			break;
	}

}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
	DateTimeCellModel dateTimeModel = (DateTimeCellModel)cellModel;
	dateTimeModel.setDateTimeFormat(this.getDateTimeFormat());
}


private java.util.Calendar extractDateTime(Object value) {
	if (value == null) {
		return com.infragistics.controls.DateHelpers.getMinValue();
	}

	if (value instanceof java.util.Calendar) {
		return (java.util.Calendar)value;
	}

	return com.infragistics.controls.DateHelpers.getMinValue();
}

}
