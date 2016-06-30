//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class CellModelExport {

private int _x;
public int setX(int value) {
_x = value;
return value;
}
public int getX() {
	return _x;
}


private int _y;
public int setY(int value) {
_y = value;
return value;
}
public int getY() {
	return _y;
}


private int _height;
public int setHeight(int value) {
_height = value;
return value;
}
public int getHeight() {
	return _height;
}


private int _width;
public int setWidth(int value) {
_width = value;
return value;
}
public int getWidth() {
	return _width;
}


private boolean _isSelected;
public boolean setIsSelected(boolean value) {
_isSelected = value;
return value;
}
public boolean getIsSelected() {
	return _isSelected;
}


private BrushAppearanceData _backgroundBrushData;
public BrushAppearanceData setBackgroundBrushData(BrushAppearanceData value) {
_backgroundBrushData = value;
return value;
}
public BrushAppearanceData getBackgroundBrushData() {
	return _backgroundBrushData;
}


private HorizontalAlignment _horizontalAlignment;
public HorizontalAlignment setHorizontalAlignment(HorizontalAlignment value) {
_horizontalAlignment = value;
return value;
}
public HorizontalAlignment getHorizontalAlignment() {
	return _horizontalAlignment;
}


private VerticalAlignment _verticalAlignment;
public VerticalAlignment setVerticalAlignment(VerticalAlignment value) {
_verticalAlignment = value;
return value;
}
public VerticalAlignment getVerticalAlignment() {
	return _verticalAlignment;
}


private String _renderValue;
public String setRenderValue(String value) {
_renderValue = value;
return value;
}
public String getRenderValue() {
	return _renderValue;
}


private BrushAppearanceData _textColor;
public BrushAppearanceData setTextColor(BrushAppearanceData value) {
_textColor = value;
return value;
}
public BrushAppearanceData getTextColor() {
	return _textColor;
}


private String _fontStyle;
public String setFontStyle(String value) {
_fontStyle = value;
return value;
}
public String getFontStyle() {
	return _fontStyle;
}


private String _fontVariant;
public String setFontVariant(String value) {
_fontVariant = value;
return value;
}
public String getFontVariant() {
	return _fontVariant;
}


private String _fontWeight;
public String setFontWeight(String value) {
_fontWeight = value;
return value;
}
public String getFontWeight() {
	return _fontWeight;
}


private double _fontSize;
public double setFontSize(double value) {
_fontSize = value;
return value;
}
public double getFontSize() {
	return _fontSize;
}


private String _fontFamily;
public String setFontFamily(String value) {
_fontFamily = value;
return value;
}
public String getFontFamily() {
	return _fontFamily;
}


private String _fontStretch;
public String setFontStretch(String value) {
_fontStretch = value;
return value;
}
public String getFontStretch() {
	return _fontStretch;
}


public String serialize() {
	IGStringBuilder sb = new IGStringBuilder();
	sb.append("{ ");
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("type : \"", getType()), "\", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("x : ", getX()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("y : ", getY()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("height : ", getHeight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("width : ", getWidth()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("isSelected : ", com.infragistics.controls.BooleanUtil.booleanToString(getIsSelected()).toLowerCase()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("backgroundBrushData : ", getBackgroundBrushData().serialize()), ", "));
	if (getHorizontalAlignment() != null) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("horizontalAlignment : ", (int)getHorizontalAlignment().getValue()), ", "));
	}

	if (getVerticalAlignment() != null) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("verticalAlignment : ", (int)getVerticalAlignment().getValue()), ", "));
	}

	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("renderValue : \"", getRenderValue()), "\", "));
	if (this.getTextColor() != null) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("textColor : ", getTextColor().serialize()), ", "));
	}

	if (!com.infragistics.controls.StringHelper.isNullOrEmpty(this.getFontStyle())) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fontStyle : \"", getFontStyle()), "\", "));
	}

	if (!com.infragistics.controls.StringHelper.isNullOrEmpty(this.getFontVariant())) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fontVariant : \"", getFontVariant()), "\", "));
	}

	if (!com.infragistics.controls.StringHelper.isNullOrEmpty(this.getFontWeight())) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fontWeight : \"", getFontWeight()), "\", "));
	}

	if (!com.infragistics.controls.StringHelper.isNullOrEmpty(this.getFontFamily())) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fontFamily : \"", getFontFamily()), "\", "));
	}

	if (!com.infragistics.controls.StringHelper.isNullOrEmpty(this.getFontStretch())) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fontStretch : \"", getFontStretch()), "\", "));
	}

	if (!Double.isNaN(this.getFontSize())) {
		sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fontSize : ", getFontSize()), ", "));
	}

	serializeOverride(sb);
	String result = sb.toString();
	if (result.endsWith(", ")) {
		result = com.infragistics.controls.StringHelper.substring(result, 0, result.length() - 2);
	}

	result += "} ";
	return result;
}


protected String getType() {

		return "Cell";

}


protected void serializeOverride(IGStringBuilder sb) {
}

}
