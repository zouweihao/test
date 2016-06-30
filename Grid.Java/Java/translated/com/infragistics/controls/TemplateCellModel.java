//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class TemplateCellModel
extends CellModel {
public static final String ValuePropertyName = "Value";

private Object _value;


public Object setValue(Object value) {

	Object oldValue = _value;
	_value = value;
	if (_value != oldValue) {
		onPropertyChanged(ValuePropertyName, oldValue, _value);
	}

return value;
}
public Object getValue() {

		return _value;

}


public void setPropertyValue(String propertyName, Object value) {
	super.setPropertyValue(propertyName, value);
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, ValuePropertyName)) {
		setValue((Object)value);
	}

}


public Object getPropertyValue(String propertyName) {
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, ValuePropertyName)) {
		return getValue();
	}

	return super.getPropertyValue(propertyName);
}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new TemplateCellModelExport();
	}

	export = super.createModelExport(export);
	TemplateCellModelExport templateExport = (TemplateCellModelExport)export;
	templateExport.setValue(this.getValue());
	return templateExport;
}

}
