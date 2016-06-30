//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;




class VisualModelExport {

private Rect _actualVisibleRegion;
public Rect setActualVisibleRegion(Rect value) {
_actualVisibleRegion = value;
return value;
}
public Rect getActualVisibleRegion() {
	return _actualVisibleRegion;
}


private int _absoluteWidth;
public int setAbsoluteWidth(int value) {
_absoluteWidth = value;
return value;
}
public int getAbsoluteWidth() {
	return _absoluteWidth;
}


private int _absoluteHeight;
public int setAbsoluteHeight(int value) {
_absoluteHeight = value;
return value;
}
public int getAbsoluteHeight() {
	return _absoluteHeight;
}


private int _headerHeight;
public int setHeaderHeight(int value) {
_headerHeight = value;
return value;
}
public int getHeaderHeight() {
	return _headerHeight;
}


private int _fixedRowHeight;
public int setFixedRowHeight(int value) {
_fixedRowHeight = value;
return value;
}
public int getFixedRowHeight() {
	return _fixedRowHeight;
}


private int _fixedColumnWidthLeft;
public int setFixedColumnWidthLeft(int value) {
_fixedColumnWidthLeft = value;
return value;
}
public int getFixedColumnWidthLeft() {
	return _fixedColumnWidthLeft;
}


private int _fixedColumnWidthRight;
public int setFixedColumnWidthRight(int value) {
_fixedColumnWidthRight = value;
return value;
}
public int getFixedColumnWidthRight() {
	return _fixedColumnWidthRight;
}


private int _columnSpacing;
public int setColumnSpacing(int value) {
_columnSpacing = value;
return value;
}
public int getColumnSpacing() {
	return _columnSpacing;
}


private int _separatorLeft;
public int setSeparatorLeft(int value) {
_separatorLeft = value;
return value;
}
public int getSeparatorLeft() {
	return _separatorLeft;
}


private int _separatorRight;
public int setSeparatorRight(int value) {
_separatorRight = value;
return value;
}
public int getSeparatorRight() {
	return _separatorRight;
}


private int _top;
public int setTop(int value) {
_top = value;
return value;
}
public int getTop() {
	return _top;
}


private int _left;
public int setLeft(int value) {
_left = value;
return value;
}
public int getLeft() {
	return _left;
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


private GridLayerExport _subContentLayer;
public GridLayerExport setSubContentLayer(GridLayerExport value) {
_subContentLayer = value;
return value;
}
public GridLayerExport getSubContentLayer() {
	return _subContentLayer;
}


private GridLayerExport _contentLayer;
public GridLayerExport setContentLayer(GridLayerExport value) {
_contentLayer = value;
return value;
}
public GridLayerExport getContentLayer() {
	return _contentLayer;
}


private GridLayerExport _fixedLayer;
public GridLayerExport setFixedLayer(GridLayerExport value) {
_fixedLayer = value;
return value;
}
public GridLayerExport getFixedLayer() {
	return _fixedLayer;
}


private GridLayerExport _decoratorLayer;
public GridLayerExport setDecoratorLayer(GridLayerExport value) {
_decoratorLayer = value;
return value;
}
public GridLayerExport getDecoratorLayer() {
	return _decoratorLayer;
}


private GridLayerExport _headerLayer;
public GridLayerExport setHeaderLayer(GridLayerExport value) {
_headerLayer = value;
return value;
}
public GridLayerExport getHeaderLayer() {
	return _headerLayer;
}


private GridLayerExport _fixedHeaderLayer;
public GridLayerExport setFixedHeaderLayer(GridLayerExport value) {
_fixedHeaderLayer = value;
return value;
}
public GridLayerExport getFixedHeaderLayer() {
	return _fixedHeaderLayer;
}


private GridLayerExport _hiddenLayer;
public GridLayerExport setHiddenLayer(GridLayerExport value) {
_hiddenLayer = value;
return value;
}
public GridLayerExport getHiddenLayer() {
	return _hiddenLayer;
}

public VisualModelExport() {



		setActualVisibleRegion(Rect.getEmpty());
		setSubContentLayer(new GridLayerExport("SubContentLayer"));
		setContentLayer(new GridLayerExport("ContentLayer"));
		setFixedLayer(new GridLayerExport("FixedLayer"));
		setDecoratorLayer(new GridLayerExport("DecoratorLayer"));
		setHeaderLayer(new GridLayerExport("HeaderLayer"));
		setFixedHeaderLayer(new GridLayerExport("FixedHeaderLayer"));
		setHiddenLayer(new GridLayerExport("HiddenLayer"));
}


public void updateLayerOrder() {
	setGridLayers(new List__1<GridLayerExport>(new TypeInfo(GridLayerExport.class)));
	getGridLayers().add(getContentLayer());
	getGridLayers().add(getDecoratorLayer());
	getGridLayers().add(getFixedLayer());
	getGridLayers().add(getHeaderLayer());
	getGridLayers().add(getFixedHeaderLayer());
}


private List__1<GridLayerExport> _gridLayers;
private List__1<GridLayerExport> setGridLayers(List__1<GridLayerExport> value) {
_gridLayers = value;
return value;
}
public List__1<GridLayerExport> getGridLayers() {
	return _gridLayers;
}


public void reset() {
	getContentLayer().clear();
	getFixedLayer().clear();
	getDecoratorLayer().clear();
	getHeaderLayer().clear();
	getFixedHeaderLayer().clear();
}


public String serialize() {
	IGStringBuilder sb = new IGStringBuilder();
	sb.append("{");
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("top : ", getTop()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("left : ", getLeft()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("height : ", getHeight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("width : ", getWidth()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("absoluteWidth : ", getAbsoluteWidth()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("absoluteHeight : ", getAbsoluteHeight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("headerHeight : ", getHeaderHeight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fixedRowHeight : ", getFixedRowHeight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fixedColumnWidthLeft : ", getFixedColumnWidthLeft()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fixedColumnWidthRight : ", getFixedColumnWidthRight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("columnSpacing : ", getColumnSpacing()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("separatorLeft : ", getSeparatorLeft()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("separatorRight : ", getSeparatorRight()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("subContentLayer: ", getSubContentLayer().serialize()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("contentLayer : ", getContentLayer().serialize()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fixedLayer : ", getFixedLayer().serialize()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("decoratorLayer : ", getDecoratorLayer().serialize()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("headerLayer : ", getHeaderLayer().serialize()), ", "));
	sb.append(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("fixedHeaderLayer : ", getFixedHeaderLayer().serialize()), " "));
	sb.append("}");
	return sb.toString();
}

}
