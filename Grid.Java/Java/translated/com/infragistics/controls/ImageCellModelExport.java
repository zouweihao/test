//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class ImageCellModelExport
extends CellModelExport {

private String _imagePath;
public String setImagePath(String value) {
_imagePath = value;
return value;
}
public String getImagePath() {
	return _imagePath;
}


protected String getType() {

		return "ImageCell";

}


protected void serializeOverride(IGStringBuilder sb) {
	super.serializeOverride(sb);
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("imagePath : \"", getImagePath()), "\", "));
}

}
