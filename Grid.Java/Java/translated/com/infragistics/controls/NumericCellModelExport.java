//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class NumericCellModelExport
extends CellModelExport {

private double _numericValue;
public double setNumericValue(double value) {
_numericValue = value;
return value;
}
public double getNumericValue() {
	return _numericValue;
}


private int _maxDecimalPlaces;
public int setMaxDecimalPlaces(int value) {
_maxDecimalPlaces = value;
return value;
}
public int getMaxDecimalPlaces() {
	return _maxDecimalPlaces;
}


private int _minDecimalPlaces;
public int setMinDecimalPlaces(int value) {
_minDecimalPlaces = value;
return value;
}
public int getMinDecimalPlaces() {
	return _minDecimalPlaces;
}


protected String getType() {

		return "NumericCell";

}


protected void serializeOverride(IGStringBuilder sb) {
	super.serializeOverride(sb);
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("numericValue : ", getNumericValue()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("maxDecimalPlaces : ", getMaxDecimalPlaces()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("minDecimalPlaces : ", getMinDecimalPlaces()), ", "));
}

}
