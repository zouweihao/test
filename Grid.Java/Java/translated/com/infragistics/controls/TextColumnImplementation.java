//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class TextColumnImplementation
extends ColumnImplementation {

protected Brush getDefaultTextColor() {
	return this.setTextColor(GridStyleRepository.getTextCellTextColor());
}

public static final String FormatStringPropertyName = "FormatString";

private String _formatString;


public String setFormatString(String value) {

	String oldValue = _formatString;
	_formatString = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_formatString, oldValue)) {
		onPropertyChanged(FormatStringPropertyName, CellPropertyAnimationType.STRING_VALUE, oldValue, _formatString);
	}

return value;
}
public String getFormatString() {

		return _formatString;

}


protected CellModel createModelOverride(CellPath path) {
	return new TextCellModel();
}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onDataBind(cellModel, grid, resolvedValue);
	TextCellModel textModel = (TextCellModel)cellModel;
	if (resolvedValue != null) {
		textModel.setTextValue(resolvedValue.toString());

	} else {
		textModel.setTextValue(null);
	}

	if (!com.infragistics.controls.StringHelper.isNullOrEmpty(getFormatString())) {
		resolvedValue = String.format(this.getFormatString(), resolvedValue);;
	}

	textModel.setRenderValue(extractString(resolvedValue));
}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
	TextCellModel textModel = (TextCellModel)cellModel;
	textModel.setFormatString(this.getFormatString());
}


private String extractString(Object value) {
	if (value == null) {
		return "";
	}

	if (value instanceof String) {
		return (String)value;
	}

	return value.toString();
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "text";
}

}
