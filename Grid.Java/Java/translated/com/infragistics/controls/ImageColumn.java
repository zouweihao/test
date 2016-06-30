//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
/**
* Represents an Image grid column, used to allow the developer to display an image in a cell.
*/
public class ImageColumn extends Column {

private ImageColumnImplementation __ImageColumnImplementation;
ImageColumnImplementation getImplementation() { return __ImageColumnImplementation; }
public ImageColumn() {
this(new ImageColumnImplementation());
}ImageColumn(ImageColumnImplementation ImageColumnImpl) {
super(ImageColumnImpl);
__ImageColumnImplementation = ImageColumnImpl;
}

/**
* The stretch option to use when rendering images
*/
public com.infragistics.controls.ImageStretchOptions getImageStretchOption() {
return __ImageColumnImplementation.getImageStretchOption();
}
/**
* The stretch option to use when rendering images
*/
public void setImageStretchOption(com.infragistics.controls.ImageStretchOptions value) {
__ImageColumnImplementation.setImageStretchOption(value);
}

}
