//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class ColumnWidthImplementation {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}


private boolean _isStarSized;
public boolean setIsStarSized(boolean value) {
_isStarSized = value;
return value;
}
public boolean getIsStarSized() {
	return _isStarSized;
}


private int _value;
public int setValue(int value) {
_value = value;
return value;
}
public int getValue() {
	return _value;
}


private int _minimumWidth;
public int setMinimumWidth(int value) {
_minimumWidth = value;
return value;
}
public int getMinimumWidth() {
	return _minimumWidth;
}


public static ColumnWidthImplementation getDefault() {

		return (new Object() { 
			public ColumnWidthImplementation invoke() {
				ColumnWidthImplementation __ret = new ColumnWidthImplementation();
				__ret.setIsStarSized(true);
				__ret.setMinimumWidth(0);
				__ret.setValue(1);
				return __ret;
			}
		}).invoke();

}

}
