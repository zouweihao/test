//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class ColumnInfo {
public ColumnInfo() {



		setLeftOffset(0);
		setLeftPercentOffset(0);
		setTopOffset(0);
}


private int _index;
public int setIndex(int value) {
_index = value;
return value;
}
public int getIndex() {
	return _index;
}


private ColumnWidthImplementation _width;
public ColumnWidthImplementation setWidth(ColumnWidthImplementation value) {
_width = value;
return value;
}
public ColumnWidthImplementation getWidth() {
	return _width;
}


private int _actualWidth;
public int setActualWidth(int value) {
_actualWidth = value;
return value;
}
public int getActualWidth() {
	return _actualWidth;
}


private String _key;
public String setKey(String value) {
_key = value;
return value;
}
public String getKey() {
	return _key;
}


private long _uniqueID;
public long setUniqueID(long value) {
_uniqueID = value;
return value;
}
public long getUniqueID() {
	return _uniqueID;
}


private FixedCellPositions _position;
public FixedCellPositions setPosition(FixedCellPositions value) {
_position = value;
return value;
}
public FixedCellPositions getPosition() {
	return _position;
}


private double _leftOffset;
public double setLeftOffset(double value) {
_leftOffset = value;
return value;
}
public double getLeftOffset() {
	return _leftOffset;
}


private double _topOffset;
public double setTopOffset(double value) {
_topOffset = value;
return value;
}
public double getTopOffset() {
	return _topOffset;
}


private double _leftPercentOffset;
public double setLeftPercentOffset(double value) {
_leftPercentOffset = value;
return value;
}
public double getLeftPercentOffset() {
	return _leftPercentOffset;
}


public double getResolvedLeftOffset(VisualModel model) {
	double actualLeftOffset = getLeftPercentOffset();
	if (getState() != ColumnStates.MOVING) {
		if (actualLeftOffset > 0d && actualLeftOffset < 1d) {
			actualLeftOffset = 0;
		}

		if (actualLeftOffset >= 1d) {
			actualLeftOffset = actualLeftOffset - 1d;
		}

	}

	return getLeftOffset() + actualLeftOffset * (double)(this.getActualWidth() + model.getColumnSpacing());
}


public double getShiftAmount(VisualModel model) {
	double shiftAmount = java.lang.Math.abs(getLeftOffset() + getLeftPercentOffset() * (double)(this.getActualWidth() + model.getColumnSpacing()));
	if (shiftAmount < (-1d * (this.getActualWidth() + model.getColumnSpacing()))) {
		shiftAmount = (-1d * (this.getActualWidth() + model.getColumnSpacing()));
	}

	if (shiftAmount > (this.getActualWidth() + model.getColumnSpacing())) {
		shiftAmount = (double)(this.getActualWidth() + model.getColumnSpacing());
	}

	return shiftAmount;
}


private ColumnStates _state;
public ColumnStates setState(ColumnStates value) {
_state = value;
return value;
}
public ColumnStates getState() {
	return _state;
}

}
