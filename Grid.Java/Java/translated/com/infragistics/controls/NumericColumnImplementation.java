//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class NumericColumnImplementation
extends ColumnImplementation {
public static final String MinDecimalPlacesPropertyName = "MinDecimalPlaces";

private int _minDecimalPlaces = 0;


public int setMinDecimalPlaces(int value) {

	int oldValue = _minDecimalPlaces;
	_minDecimalPlaces = value;
	if (_minDecimalPlaces != oldValue) {
		onPropertyChanged(MinDecimalPlacesPropertyName, CellPropertyAnimationType.INT_VALUE, oldValue, _minDecimalPlaces);
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
		onPropertyChanged(MaxDecimalPlacesPropertyName, CellPropertyAnimationType.INT_VALUE, oldValue, _maxDecimalPlaces);
	}

return value;
}
public int getMaxDecimalPlaces() {

		return _maxDecimalPlaces;

}


protected CellModel createModelOverride(CellPath path) {
	return new NumericCellModel();
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "numeric";
}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onDataBind(cellModel, grid, resolvedValue);
	NumericCellModel numericModel = (NumericCellModel)cellModel;
	numericModel.setNumericValue(extractDouble(resolvedValue));
	java.text.DecimalFormat df = new java.text.DecimalFormat();
	df.setMinimumFractionDigits(this.getMinDecimalPlaces());
	df.setMaximumFractionDigits(this.getMaxDecimalPlaces());
	numericModel.setRenderValue(df.format(numericModel.getNumericValue()));
}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
	NumericCellModel numericModel = (NumericCellModel)cellModel;
	numericModel.setMinDecimalPlaces(this.getMinDecimalPlaces());
	numericModel.setMaxDecimalPlaces(this.getMaxDecimalPlaces());
}


private double extractDouble(Object value) {
	if (value == null) {
		return Double.NaN;
	}

	if (value instanceof Integer) {
		return (double)(Integer)value;
	}

	if (value instanceof Double) {
		return (Double)value;
	}

	if (value instanceof Float) {
		return (Float)value;
	}

	return Double.NaN;
}

}
