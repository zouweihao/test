//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class NumericCellModel
extends CellModel {
public static final String NumericValuePropertyName = "NumericValue";

private double _numericValue = Double.NaN;


public double setNumericValue(double value) {

	double oldValue = _numericValue;
	_numericValue = value;
	if (_numericValue != oldValue) {
		onPropertyChanged(NumericValuePropertyName, oldValue, _numericValue);
	}

return value;
}
public double getNumericValue() {

		return _numericValue;

}

public static final String MinDecimalPlacesPropertyName = "MinDecimalPlaces";

private int _minDecimalPlaces = 0;


public int setMinDecimalPlaces(int value) {

	int oldValue = _minDecimalPlaces;
	_minDecimalPlaces = value;
	if (_minDecimalPlaces != oldValue) {
		onPropertyChanged(MinDecimalPlacesPropertyName, oldValue, _minDecimalPlaces);
	}

return value;
}
public int getMinDecimalPlaces() {

		return _minDecimalPlaces;

}

public static final String MaxDecimalPlacesPropertyName = "MaxDecimalPlaces";

private int _maxDecimalPlaces = 5;


public int setMaxDecimalPlaces(int value) {

	int oldValue = _maxDecimalPlaces;
	_maxDecimalPlaces = value;
	if (_maxDecimalPlaces != oldValue) {
		onPropertyChanged(MaxDecimalPlacesPropertyName, oldValue, _maxDecimalPlaces);
	}

return value;
}
public int getMaxDecimalPlaces() {

		return _maxDecimalPlaces;

}


public void setPropertyValue(String propertyName, Object value) {
	super.setPropertyValue(propertyName, value);
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, NumericValuePropertyName)) {
		setNumericValue((Double)value);
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, MinDecimalPlacesPropertyName)) {
		setMinDecimalPlaces((Integer)value);
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, MaxDecimalPlacesPropertyName)) {
		setMaxDecimalPlaces((Integer)value);
	}

}


public Object getPropertyValue(String propertyName) {
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, NumericValuePropertyName)) {
		return getNumericValue();
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, MinDecimalPlacesPropertyName)) {
		return getMinDecimalPlaces();
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, MaxDecimalPlacesPropertyName)) {
		return getMinDecimalPlaces();
	}

	return super.getPropertyValue(propertyName);
}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new NumericCellModelExport();
	}

	export = super.createModelExport(export);
	NumericCellModelExport numericExport = (NumericCellModelExport)export;
	numericExport.setNumericValue(this.getNumericValue());
	return numericExport;
}

}
