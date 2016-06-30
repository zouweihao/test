//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class TemplateCellModelExport
extends CellModelExport {

private Object _value;
public Object setValue(Object value) {
_value = value;
return value;
}
public Object getValue() {
	return _value;
}


protected String getType() {

		return "TemplateCell";

}


protected void serializeOverride(IGStringBuilder sb) {
	super.serializeOverride(sb);
}

}
