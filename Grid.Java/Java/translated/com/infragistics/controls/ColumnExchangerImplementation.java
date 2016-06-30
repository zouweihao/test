//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class ColumnExchangerImplementation {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}


private ColumnImplementation _column;
public ColumnImplementation setColumn(ColumnImplementation value) {
_column = value;
return value;
}
public ColumnImplementation getColumn() {
	return _column;
}


private int _targetIndex;
public int setTargetIndex(int value) {
_targetIndex = value;
return value;
}
public int getTargetIndex() {
	return _targetIndex;
}

}
