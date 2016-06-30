//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class GridColumnSpacer {
public GridColumnSpacer() {



		_uniqueId = _currentId;
		_currentId++;
}

private static long _currentId = 0;

private double _actualWidth;


public double setActualWidth(double value) {

	_actualWidth = value;
return value;
}
public double getActualWidth() {

		return _actualWidth;

}

private double _startWidth;


public double setStartWidth(double value) {

	_startWidth = value;
return value;
}
public double getStartWidth() {

		return _startWidth;

}

private long _uniqueId;


public long getUniqueId() {

		return _uniqueId;

}

private boolean _isStar;


public boolean setIsStar(boolean value) {

	_isStar = value;
return value;
}
public boolean getIsStar() {

		return _isStar;

}

private long _owningColumnId;


public long setOwningColumnId(long value) {

	_owningColumnId = value;
return value;
}
public long getOwningColumnId() {

		return _owningColumnId;

}

private boolean _isShrinking;


public boolean setIsShrinking(boolean value) {

	_isShrinking = value;
return value;
}
public boolean getIsShrinking() {

		return _isShrinking;

}

private boolean _isRight;


public boolean setIsRight(boolean value) {

	_isRight = value;
return value;
}
public boolean getIsRight() {

		return _isRight;

}

}
