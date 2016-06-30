//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
class ImageColumnImplementation
extends ColumnImplementation {
public static final String ImageStretchOptionPropertyName = "ImageStretchOption";

private ImageStretchOptions _imageStretchOption = ImageStretchOptions.UNIFORM;


public ImageStretchOptions setImageStretchOption(ImageStretchOptions value) {

	ImageStretchOptions oldValue = _imageStretchOption;
	_imageStretchOption = value;
	if (_imageStretchOption != oldValue) {
		onPropertyChanged(ImageStretchOptionPropertyName, CellPropertyAnimationType.ENUM_VALUE, oldValue, _imageStretchOption);
	}

return value;
}
public ImageStretchOptions getImageStretchOption() {

		return _imageStretchOption;

}

public ImageColumnImplementation() {



		this.setImageStretchOption(ImageStretchOptions.UNIFORM);
		this.setVerticalAlignment(VerticalAlignment.STRETCH);
}


protected CellModel createModelOverride(CellPath path) {
	return new ImageCellModel();
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "image";
}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onDataBind(cellModel, grid, resolvedValue);
	ImageCellModel imageModel = (ImageCellModel)cellModel;
	imageModel.setRenderValue(resolvedValue.toString());
	imageModel.setImageStretchOption(this.getImageStretchOption());
	imageModel.setImagePath(extractImagePath(resolvedValue));
}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
}


private String extractImagePath(Object value) {
	if (value == null) {
		return "";
	}

	if (value instanceof String) {
		return (String)value;
	}

	return value.toString();
}

}
