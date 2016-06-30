//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class TextCellModelExport
extends CellModelExport {

private String _textValue;
public String setTextValue(String value) {
_textValue = value;
return value;
}
public String getTextValue() {
	return _textValue;
}


private String _formatString;
public String setFormatString(String value) {
_formatString = value;
return value;
}
public String getFormatString() {
	return _formatString;
}


protected String getType() {

		return "TextCell";

}


protected void serializeOverride(IGStringBuilder sb) {
	super.serializeOverride(sb);
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("textValue : \"", getTextValue()), "\", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("formatString : \"", getFormatString()), "\", "));
}

}
