//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class ImageCellModel
extends CellModel {
public static final String ImagePathPropertyName = "ImagePath";

private String _imagePath = "";


public String setImagePath(String value) {

	String oldValue = _imagePath;
	_imagePath = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_imagePath, oldValue)) {
		onPropertyChanged(ImagePathPropertyName, oldValue, _imagePath);
	}

return value;
}
public String getImagePath() {

		return _imagePath;

}

public static final String ImageStretchOptionPropertyName = "ImageStretchOption";

private ImageStretchOptions _imageStretchOption = ImageStretchOptions.UNIFORM;


public ImageStretchOptions setImageStretchOption(ImageStretchOptions value) {

	ImageStretchOptions oldValue = _imageStretchOption;
	_imageStretchOption = value;
	if (_imageStretchOption != oldValue) {
		onPropertyChanged(ImageStretchOptionPropertyName, oldValue, _imageStretchOption);
	}

return value;
}
public ImageStretchOptions getImageStretchOption() {

		return _imageStretchOption;

}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new ImageCellModelExport();
	}

	export = super.createModelExport(export);
	ImageCellModelExport imageExport = (ImageCellModelExport)export;
	imageExport.setImagePath(this.getImagePath());
	return imageExport;
}

}
