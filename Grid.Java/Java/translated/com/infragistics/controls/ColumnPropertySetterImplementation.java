//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class ColumnPropertySetterImplementation {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}


private String _columnName;
public String setColumnName(String value) {
_columnName = value;
return value;
}
public String getColumnName() {
	return _columnName;
}


private String _propertyName;
public String setPropertyName(String value) {
_propertyName = value;
return value;
}
public String getPropertyName() {
	return _propertyName;
}


private Object _value;
public Object setValue(Object value) {
_value = value;
return value;
}
public Object getValue() {
	return _value;
}

}
