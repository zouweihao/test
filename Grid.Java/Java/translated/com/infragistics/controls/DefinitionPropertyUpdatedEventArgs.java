//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;






class DefinitionPropertyUpdatedEventArgs
extends EventArgs {

private String _propertyName;
public String setPropertyName(String value) {
_propertyName = value;
return value;
}
public String getPropertyName() {
	return _propertyName;
}


private CellPropertyAnimationType _animationType;
public CellPropertyAnimationType setAnimationType(CellPropertyAnimationType value) {
_animationType = value;
return value;
}
public CellPropertyAnimationType getAnimationType() {
	return _animationType;
}


private Object _oldValue;
public Object setOldValue(Object value) {
_oldValue = value;
return value;
}
public Object getOldValue() {
	return _oldValue;
}


private Object _newValue;
public Object setNewValue(Object value) {
_newValue = value;
return value;
}
public Object getNewValue() {
	return _newValue;
}

}
