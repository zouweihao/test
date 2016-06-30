//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class TextCellModel
extends CellModel {
public static final String TextValuePropertyName = "TextValue";

private String _textValue = "";


public String setTextValue(String value) {

	String oldValue = _textValue;
	_textValue = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_textValue, oldValue)) {
		onPropertyChanged(TextValuePropertyName, oldValue, _textValue);
	}

return value;
}
public String getTextValue() {

		return _textValue;

}

public static final String FormatStringPropertyName = "FormatString";

private String _formatString;


public String setFormatString(String value) {

	String oldValue = _formatString;
	_formatString = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_formatString, oldValue)) {
		onPropertyChanged(FormatStringPropertyName, oldValue, _formatString);
	}

return value;
}
public String getFormatString() {

		return _formatString;

}


public void setPropertyValue(String propertyName, Object value) {
	super.setPropertyValue(propertyName, value);
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, TextValuePropertyName)) {
		setTextValue((String)value);
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, FormatStringPropertyName)) {
		setFormatString((String)value);
	}

}


public Object getPropertyValue(String propertyName) {
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, TextValuePropertyName)) {
		return getTextValue();
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, FormatStringPropertyName)) {
		return getFormatString();
	}

	return super.getPropertyValue(propertyName);
}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new TextCellModelExport();
	}

	export = super.createModelExport(export);
	TextCellModelExport textExport = (TextCellModelExport)export;
	textExport.setTextValue(this.getTextValue());
	textExport.setFormatString(this.getFormatString());
	return textExport;
}

}
