//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
class TextHeaderImplementation
extends HeaderImplementation {

protected Brush getDefaultTextColor() {
	return GridStyleRepository.getHeaderTextColor();
}


protected Brush getDefaultBackgroundColor() {
	return GridStyleRepository.getHeaderBackgroundColor();
}


protected CellModel createModelOverride(CellPath path) {
	TextHeaderCellModel model = new TextHeaderCellModel();
	return model;
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "textHeader";
}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onDataBind(cellModel, grid, resolvedValue);
	TextHeaderCellModel textModel = (TextHeaderCellModel)cellModel;
	textModel.setTextValue(getActualHeaderText());
	textModel.setRenderValue(textModel.getTextValue());
}

}
