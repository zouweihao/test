//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;




class VisualModel {

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


public int getTop() {

		return (int)getActualVisibleRegion()._top;

}


public int getLeft() {

		return (int)getActualVisibleRegion()._left;

}


public int getRight() {

		return (int)getActualVisibleRegion()._right;

}


public int getHeight() {

		return (int)getActualVisibleRegion()._height;

}


public int getWidth() {

		return (int)getActualVisibleRegion()._width;

}

private GridLayer _subContentLayer;


public GridLayer setSubContentLayer(GridLayer value) {

	_subContentLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getSubContentLayer() {

		return _subContentLayer;

}

private GridLayer _contentLayer;


public GridLayer setContentLayer(GridLayer value) {

	_contentLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getContentLayer() {

		return _contentLayer;

}

private GridLayer _superContentLayer;


public GridLayer setSuperContentLayer(GridLayer value) {

	_superContentLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getSuperContentLayer() {

		return _superContentLayer;

}

private GridLayer _fixedLayer;


public GridLayer setFixedLayer(GridLayer value) {

	_fixedLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getFixedLayer() {

		return _fixedLayer;

}

private GridLayer _decoratorLayer;


public GridLayer setDecoratorLayer(GridLayer value) {

	_decoratorLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getDecoratorLayer() {

		return _decoratorLayer;

}

private GridLayer _subHeaderLayer;


public GridLayer setSubHeaderLayer(GridLayer value) {

	_subHeaderLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getSubHeaderLayer() {

		return _subHeaderLayer;

}

private GridLayer _headerLayer;


public GridLayer setHeaderLayer(GridLayer value) {

	_headerLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getHeaderLayer() {

		return _headerLayer;

}

private GridLayer _superHeaderLayer;


public GridLayer setSuperHeaderLayer(GridLayer value) {

	_superHeaderLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getSuperHeaderLayer() {

		return _superHeaderLayer;

}

private GridLayer _fixedHeaderLayer;


public GridLayer setFixedHeaderLayer(GridLayer value) {

	_fixedHeaderLayer = value;
	updateLayerOrder();
return value;
}
public GridLayer getFixedHeaderLayer() {

		return _fixedHeaderLayer;

}

private FastIterationDictionary__2<CellPath, List__1<CellModel>> _hiddenLayer;


public FastIterationDictionary__2<CellPath, List__1<CellModel>> setHiddenLayer(FastIterationDictionary__2<CellPath, List__1<CellModel>> value) {

	_hiddenLayer = value;
return value;
}
public FastIterationDictionary__2<CellPath, List__1<CellModel>> getHiddenLayer() {

		return _hiddenLayer;

}


private List__1<SectionInfo> _sections;
public List__1<SectionInfo> setSections(List__1<SectionInfo> value) {
_sections = value;
return value;
}
public List__1<SectionInfo> getSections() {
	return _sections;
}


private List__1<ColumnInfo> _fixedLeftColumns;
public List__1<ColumnInfo> setFixedLeftColumns(List__1<ColumnInfo> value) {
_fixedLeftColumns = value;
return value;
}
public List__1<ColumnInfo> getFixedLeftColumns() {
	return _fixedLeftColumns;
}


private Dictionary__2<Long, Integer> _fixedLeftColumnIndexes;
public Dictionary__2<Long, Integer> setFixedLeftColumnIndexes(Dictionary__2<Long, Integer> value) {
_fixedLeftColumnIndexes = value;
return value;
}
public Dictionary__2<Long, Integer> getFixedLeftColumnIndexes() {
	return _fixedLeftColumnIndexes;
}


private List__1<ColumnInfo> _fixedRightColumns;
public List__1<ColumnInfo> setFixedRightColumns(List__1<ColumnInfo> value) {
_fixedRightColumns = value;
return value;
}
public List__1<ColumnInfo> getFixedRightColumns() {
	return _fixedRightColumns;
}


private Dictionary__2<Long, Integer> _fixedRightColumnIndexes;
public Dictionary__2<Long, Integer> setFixedRightColumnIndexes(Dictionary__2<Long, Integer> value) {
_fixedRightColumnIndexes = value;
return value;
}
public Dictionary__2<Long, Integer> getFixedRightColumnIndexes() {
	return _fixedRightColumnIndexes;
}


private List__1<ColumnInfo> _columns;
public List__1<ColumnInfo> setColumns(List__1<ColumnInfo> value) {
_columns = value;
return value;
}
public List__1<ColumnInfo> getColumns() {
	return _columns;
}


private boolean _isPlaceholderContentNeeded;
public boolean setIsPlaceholderContentNeeded(boolean value) {
_isPlaceholderContentNeeded = value;
return value;
}
public boolean getIsPlaceholderContentNeeded() {
	return _isPlaceholderContentNeeded;
}

private List__1<GridColumnSpacerCollection> _spacers = new List__1<GridColumnSpacerCollection>(new TypeInfo(GridColumnSpacerCollection.class));


public List__1<GridColumnSpacerCollection> setSpacers(List__1<GridColumnSpacerCollection> value) {

	_spacers = value;
return value;
}
public List__1<GridColumnSpacerCollection> getSpacers() {

		while (_spacers.getCount() < getColumns().getCount()) {
			_spacers.add(new GridColumnSpacerCollection());

		}
		return _spacers;

}


private Dictionary__2<Long, Integer> _columnIndexes;
public Dictionary__2<Long, Integer> setColumnIndexes(Dictionary__2<Long, Integer> value) {
_columnIndexes = value;
return value;
}
public Dictionary__2<Long, Integer> getColumnIndexes() {
	return _columnIndexes;
}


private RowPath _topRow;
public RowPath setTopRow(RowPath value) {
_topRow = value;
return value;
}
public RowPath getTopRow() {
	return _topRow;
}


private RowPath _bottomRow;
public RowPath setBottomRow(RowPath value) {
_bottomRow = value;
return value;
}
public RowPath getBottomRow() {
	return _bottomRow;
}


public ColumnInfo getColumnById(long uniqueId) {
	if (getColumnIndexes().containsKey(uniqueId)) {
		return getColumns().inner[getColumnIndexes().getItem(uniqueId)];

	} else if (getFixedLeftColumnIndexes().containsKey(uniqueId)) {
		return getFixedLeftColumns().inner[getFixedLeftColumnIndexes().getItem(uniqueId)];

	} else if (getFixedRightColumnIndexes().containsKey(uniqueId)) {
		return getFixedRightColumns().inner[getFixedRightColumnIndexes().getItem(uniqueId)];
	}



	return null;
}


public void addColumn(ColumnInfo column) {
	getColumns().add(column);
	getColumnIndexes().add(column.getUniqueID(), getColumns().getCount() - 1);
}


public void addFixedLeftColumn(ColumnInfo column) {
	getFixedLeftColumns().add(column);
	getFixedLeftColumnIndexes().add(column.getUniqueID(), getFixedLeftColumns().getCount() - 1);
}


public void addFixedRightColumn(ColumnInfo column) {
	getFixedRightColumns().add(column);
	getFixedRightColumnIndexes().add(column.getUniqueID(), getFixedLeftColumns().getCount() - 1);
}

public VisualModel() {



		setActualVisibleRegion(Rect.getEmpty());
		_subContentLayer = new GridLayer("SubContentLayer");
		_contentLayer = new GridLayer("ContentLayer");
		_superContentLayer = new GridLayer("SuperContentLayer");
		_fixedLayer = new GridLayer("FixedLayer");
		_decoratorLayer = new GridLayer("DecoratorLayer");
		_subHeaderLayer = new GridLayer("SubHeaderLayer");
		_headerLayer = new GridLayer("HeaderLayer");
		_superHeaderLayer = new GridLayer("SuperHeaderLayer");
		_fixedHeaderLayer = new GridLayer("FixedHeaderLayer");
		_hiddenLayer = new FastIterationDictionary__2<CellPath, List__1<CellModel>>(new TypeInfo(CellPath.class), new TypeInfo(List__1.class, new TypeInfo[] {}));
		updateLayerOrder();
		setSections(new List__1<SectionInfo>(new TypeInfo(SectionInfo.class)));
		setColumns(new List__1<ColumnInfo>(new TypeInfo(ColumnInfo.class)));
		setColumnIndexes(new Dictionary__2<Long, Integer>(new TypeInfo(Long.class), new TypeInfo(Integer.class)));
		setFixedRightColumns(new List__1<ColumnInfo>(new TypeInfo(ColumnInfo.class)));
		setFixedRightColumnIndexes(new Dictionary__2<Long, Integer>(new TypeInfo(Long.class), new TypeInfo(Integer.class)));
		setFixedLeftColumns(new List__1<ColumnInfo>(new TypeInfo(ColumnInfo.class)));
		setFixedLeftColumnIndexes(new Dictionary__2<Long, Integer>(new TypeInfo(Long.class), new TypeInfo(Integer.class)));
}


private void updateLayerOrder() {
	_gridLayers = new List__1<GridLayer>(new TypeInfo(GridLayer.class));
	_gridLayers.add(getSubContentLayer());
	_gridLayers.add(getContentLayer());
	_gridLayers.add(getSuperContentLayer());
	_gridLayers.add(getDecoratorLayer());
	_gridLayers.add(getFixedLayer());
	_gridLayers.add(getSubHeaderLayer());
	_gridLayers.add(getHeaderLayer());
	_gridLayers.add(getSuperHeaderLayer());
	_gridLayers.add(getFixedHeaderLayer());
}

private List__1<GridLayer> _gridLayers;


public List__1<GridLayer> getGridLayers() {

		return _gridLayers;

}


public void resetColumns() {
	getColumns().clear();
	getColumnIndexes().clear();
	getFixedLeftColumns().clear();
	getFixedRightColumns().clear();
}


public void reset() {
	resetColumns();
	getSections().clear();
	getContentLayer().clear();
	getFixedLayer().clear();
	getDecoratorLayer().clear();
	getHeaderLayer().clear();
	getFixedHeaderLayer().clear();
}


public VisualModelExport export() {
	VisualModelExport export = new VisualModelExport();
	export.setActualVisibleRegion(new Rect(this.getActualVisibleRegion()._x, this.getActualVisibleRegion()._y, this.getActualVisibleRegion()._width, this.getActualVisibleRegion()._height));
	export.setAbsoluteWidth(this.getAbsoluteWidth());
	export.setAbsoluteHeight(this.getAbsoluteHeight());
	export.setHeaderHeight(this.getHeaderHeight());
	export.setFixedRowHeight(this.getFixedRowHeight());
	export.setFixedColumnWidthLeft(this.getFixedColumnWidthLeft());
	export.setFixedColumnWidthRight(this.getFixedColumnWidthRight());
	export.setColumnSpacing(this.getColumnSpacing());
	export.setSeparatorLeft(this.getSeparatorLeft());
	export.setSeparatorRight(this.getSeparatorRight());
	export.setTop(this.getTop());
	export.setLeft(this.getLeft());
	export.setHeight(this.getHeight());
	export.setWidth(this.getWidth());
	export.setSubContentLayer(createGridLayerExport(this.getSubContentLayer()));
	export.setContentLayer(createGridLayerExport(this.getContentLayer()));
	export.setDecoratorLayer(createGridLayerExport(this.getDecoratorLayer()));
	export.setFixedLayer(createGridLayerExport(this.getFixedLayer()));
	export.setHeaderLayer(createGridLayerExport(this.getHeaderLayer()));
	export.setFixedHeaderLayer(createGridLayerExport(this.getFixedHeaderLayer()));
	export.updateLayerOrder();
	return export;
}


private GridLayerExport createGridLayerExport(GridLayer gridLayer) {
	GridLayerExport export = new GridLayerExport(gridLayer.getName());
	for (IEnumerator__1<CellModel> en = gridLayer.getValues().getEnumerator(); en.moveNext();) {
	CellModel cell = (CellModel)en.getCurrent();
		export.add(cell.createModelExport(null));

	}

	return export;
}


private int _leftColumn;
public int setLeftColumn(int value) {
_leftColumn = value;
return value;
}
public int getLeftColumn() {
	return _leftColumn;
}


private int _rightColumn;
public int setRightColumn(int value) {
_rightColumn = value;
return value;
}
public int getRightColumn() {
	return _rightColumn;
}


public GridColumnSpacer createSpacer(int index, ColumnInfo column, double actualWidth, boolean isStar, boolean isRight) {
	GridColumnSpacer spacer = new GridColumnSpacer();
	spacer.setActualWidth(actualWidth);
	spacer.setStartWidth(actualWidth);
	spacer.setIsStar(isStar);
	spacer.setOwningColumnId(column.getUniqueID());
	spacer.setIsRight(isRight);
	getSpacers().inner[index].add(spacer);
	return spacer;
}


public void removeSpacer(GridColumnSpacer spacer) {
	List__1<GridColumnSpacerCollection> spacers = getSpacers();
	for (int i = 0; i < spacers.getCount(); i++) {
		GridColumnSpacerCollection currSpacers = spacers.inner[i];
		for (int j = currSpacers.getCount() - 1; j >= 0; j--) {
			if (currSpacers.inner[j].getUniqueId() == spacer.getUniqueId()) {
				currSpacers.removeAt(j);
			}

		}

	}

}


public List__1<GridColumnSpacer> getSpacersForColumn(ColumnInfo column) {
	List__1<GridColumnSpacer> ret = new List__1<GridColumnSpacer>(new TypeInfo(GridColumnSpacer.class));
	List__1<GridColumnSpacerCollection> spacers = getSpacers();
	for (int i = 0; i < spacers.getCount(); i++) {
		GridColumnSpacerCollection currSpacers = spacers.inner[i];
		for (int j = currSpacers.getCount() - 1; j >= 0; j--) {
			if (currSpacers.inner[j].getOwningColumnId() == column.getUniqueID()) {
				ret.add(currSpacers.inner[j]);
			}

		}

	}

	return ret;
}


public List__1<CellModel> getCellsForColumn(ColumnInfo col) {
	List__1<CellModel> cells = new List__1<CellModel>(new TypeInfo(CellModel.class));
	for (int i = 0; i < getGridLayers().getCount(); i++) {
		List__1<CellModel> toIncrement = new List__1<CellModel>(new TypeInfo(CellModel.class));
		GridLayer currLayer = getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellModel currModel = currLayer.getValueList().inner[p];
			if (currModel.getPath().getColumn() == col.getIndex() && currModel.getPath().getFixedPosition() == col.getPosition()) {
				cells.add(currModel);
			}

		}

	}

	return cells;
}

}
