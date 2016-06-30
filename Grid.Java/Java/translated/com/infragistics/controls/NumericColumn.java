//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
/**
* Represents a Numeric grid column, used to allow the developer to display a formatted number in a cell.
*/
public class NumericColumn extends Column {

private NumericColumnImplementation __NumericColumnImplementation;
NumericColumnImplementation getImplementation() { return __NumericColumnImplementation; }
public NumericColumn() {
this(new NumericColumnImplementation());
}NumericColumn(NumericColumnImplementation NumericColumnImpl) {
super(NumericColumnImpl);
__NumericColumnImplementation = NumericColumnImpl;
}

/**
* The minimum number of decimal places to display when formatting
*/
public int getMinDecimalPlaces() {
return __NumericColumnImplementation.getMinDecimalPlaces();
}
/**
* The minimum number of decimal places to display when formatting
*/
public void setMinDecimalPlaces(int value) {
__NumericColumnImplementation.setMinDecimalPlaces(value);
}

/**
* The maximum number of decimal places to display when formatting
*/
public int getMaxDecimalPlaces() {
return __NumericColumnImplementation.getMaxDecimalPlaces();
}
/**
* The maximum number of decimal places to display when formatting
*/
public void setMaxDecimalPlaces(int value) {
__NumericColumnImplementation.setMaxDecimalPlaces(value);
}

}
