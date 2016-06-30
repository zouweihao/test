//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class SpatialEngine {
private boolean _columnsDisplayed = false;

private List__1<ColumnInfo> _pendingColumnShowingAnimation = new List__1<ColumnInfo>(new TypeInfo(ColumnInfo.class));

private Dictionary__2<Long, ColumnInfo> _previousColumns = new Dictionary__2<Long, ColumnInfo>(new TypeInfo(Long.class), new TypeInfo(ColumnInfo.class));


public void invalidateLayoutData(GridImplementation controller, VisualModel model, int availableWidth) {
	model.setAbsoluteHeight(0);
	model.setAbsoluteWidth(0);
	model.setAbsoluteHeight((int)controller.getInset().getTop());
	model.setFixedRowHeight((int)controller.getInset().getTop());
	model.getSections().clear();
	_previousColumns.clear();
	for (int i = 0; i < controller.getModel().getColumns().getCount(); i++) {
		_previousColumns.add(controller.getModel().getColumns().inner[i].getUniqueID(), controller.getModel().getColumns().inner[i]);
	}

	model.resetColumns();
	model.setFixedColumnWidthLeft(0);
	model.setFixedColumnWidthRight(0);
	controller.getModel().setColumnSpacing(controller.getColumnSpacingWidth());
	if (controller.getAdapter() == null) {
		return;
	}

	int sectionCount = controller.getAdapter().getSectionCount();
	sectionCount = java.lang.Math.max(1, sectionCount);
	controller.getModel().setHeaderHeight(controller.getHeaderHeight());
	controller.getModel().setAbsoluteHeight(controller.getModel().getAbsoluteHeight() + controller.getModel().getHeaderHeight());
	controller.getModel().setFixedRowHeight(controller.getModel().getFixedRowHeight() + controller.getModel().getHeaderHeight());
	for (int sectionIndex = 0; sectionIndex < sectionCount; sectionIndex++) {
		SectionInfo sectionInfo = new SectionInfo();
		sectionInfo.setIndex(sectionIndex);
		sectionInfo.setOffset(model.getAbsoluteHeight());
		sectionInfo.setRowCount(controller.getAdapter().getRowCountForSection(sectionIndex));
		sectionInfo.setHeaderHeight(controller.getSectionHeaderHeight());
		sectionInfo.setFooterHeight(controller.getSectionFooterHeight());
		sectionInfo.setRowSeparatorHeight(controller.getRowSeparatorHeight());
		sectionInfo.setRowSpacing(controller.getRowSpacingHeight());
		sectionInfo.setRowHeight(controller.getRowHeight());
		sectionInfo.setTotalRowHeight(sectionInfo.getRowCount() * sectionInfo.getRowHeight());
		controller.getModel().setAbsoluteHeight(controller.getModel().getAbsoluteHeight() + sectionInfo.resolveTotalHeight());
		controller.getModel().getSections().add(sectionInfo);
	}

	ColumnWidthImplementation colWidth = controller.getDefaultColumnWidth();
	int columnIndex = 0;
	_pendingColumnShowingAnimation.clear();
	for (columnIndex = 0; columnIndex < controller.getActualColumns().getCount(); columnIndex++) {
		ColumnInfo info = new ColumnInfo();
		if (_previousColumns.containsKey(controller.getActualColumns().getItem(columnIndex).getUniqueId())) {
			info = _previousColumns.getItem(controller.getActualColumns().getItem(columnIndex).getUniqueId());
		}

		info.setIndex(columnIndex);
		ColumnImplementation column = controller.getActualColumns().getItem(columnIndex);
		info.setKey(column.getKey());
		info.setUniqueID(column.getUniqueId());
		if (column.getState() == ColumnStates.HIDDEN) {
			info.setLeftPercentOffset(-1);
		}

		if (column.getState() == ColumnStates.VISIBLE) {
			info.setLeftPercentOffset(0);
		}

		info.setState(column.getState());
		ColumnWidthImplementation width = null;
		colWidth = column.getWidth();
		if (width == null) {
		width = (colWidth == null) ? ColumnWidthImplementation.getDefault() : colWidth;
		}

		info.setWidth(width);
		info.setPosition(FixedCellPositions.NONE);
		controller.getModel().addColumn(info);
	}

	_previousColumns.clear();
	controller.getModel().setFixedColumnWidthLeft(0);
	controller.getModel().setFixedColumnWidthRight(0);
	this.invalidateColumnWidths(controller, model, availableWidth);
	controller.getEffectManager().forceTickRows();
	controller.getModel().setAbsoluteHeight(controller.getModel().getAbsoluteHeight() + (int)controller.getInset().getBottom());
}


public void invalidateColumnWidths(GridImplementation controller, VisualModel model, int availableWidth) {
	controller.getModel().setAbsoluteWidth(0);
	int totalWidth = controller.getModel().getColumnSpacing();
	int absoluteWidth = controller.getModel().getColumnSpacing();
	double starCount = 0;
	double totalStarOffset = 0;
	List__1<ColumnInfo> starCols = new List__1<ColumnInfo>(new TypeInfo(ColumnInfo.class));
	List__1<GridColumnSpacerCollection> spacers = model.getSpacers();
	for (IEnumerator__1<ColumnInfo> en = model.getColumns().getEnumerator(); en.moveNext();) {
	ColumnInfo col = (ColumnInfo)en.getCurrent();
		if (col.getWidth().getIsStarSized()) {
			starCount += col.getWidth().getValue() * getVisibleRatio(col);
			starCols.add(col);

		} else {
			col.setActualWidth(col.getWidth().getValue());
			if (col.getState() != ColumnStates.MOVING) {
				if (col.getState() != ColumnStates.HIDDEN) {
					absoluteWidth += (col.getActualWidth()) + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(col.getShiftAmount(model));
				}

				if (col.getState() == ColumnStates.MOVING) {
					totalWidth += (col.getActualWidth()) + controller.getModel().getColumnSpacing();

				} else {
					totalWidth += (col.getActualWidth()) + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(col.getShiftAmount(model));
				}

			}

		}


	}

	if (starCount > 0) {
		int beforeAbsolute = absoluteWidth;
		absoluteWidth = updateStarWidths(controller, model, availableWidth, totalWidth, absoluteWidth, starCount, starCols);
	}

	controller.getModel().setAbsoluteWidth(absoluteWidth);
	controller.getModel().setAbsoluteWidth(controller.getModel().getAbsoluteWidth() + (int)(controller.getInset().getLeft() + controller.getInset().getRight()));
}


public double getVisibleRatio(ColumnInfo col) {
	if (col.getState() == ColumnStates.MOVING) {
		return 1d;
	}

	if (col.getState() == ColumnStates.HIDDEN) {
		return 0d;
	}

	double offset = 1d - java.lang.Math.max(0d, java.lang.Math.min(1d, java.lang.Math.abs(col.getLeftPercentOffset())));
	return offset;
}


private static int updateStarWidths(GridImplementation controller, VisualModel model, int availableWidth, int totalWidth, int absoluteWidth, double starCount, List__1<ColumnInfo> starCols) {
	availableWidth -= totalWidth;
	availableWidth -= (int)(controller.getInset().getLeft() + controller.getInset().getRight());
	availableWidth -= (starCols.getCount() * controller.getModel().getColumnSpacing());
	availableWidth -= controller.getModel().getSeparatorLeft() + controller.getModel().getSeparatorRight();
	int totalStarWidth = 0;
	double starSize = (double)(availableWidth) / starCount;
	if (starSize < 0) {
	starSize = 0;
	}

	double startPos = 0d;
	for (IEnumerator__1<ColumnInfo> en = starCols.getEnumerator(); en.moveNext();) {
	ColumnInfo col = (ColumnInfo)en.getCurrent();
		double newWidth = java.lang.Math.max((double)col.getWidth().getMinimumWidth(), starSize * col.getWidth().getValue());
		double newEnd = startPos + newWidth;
		startPos += newWidth;
		if (java.lang.Math.round(newEnd) >= newEnd) {
			col.setActualWidth((int)java.lang.Math.ceil(newWidth));

		} else {
			col.setActualWidth((int)java.lang.Math.floor(newWidth));
		}

		if (col.getPosition() == FixedCellPositions.LEFT) {
			controller.getModel().setFixedColumnWidthLeft(controller.getModel().getFixedColumnWidthLeft() + col.getActualWidth());
		}

		if (col.getPosition() == FixedCellPositions.RIGHT) {
			controller.getModel().setFixedColumnWidthRight(controller.getModel().getFixedColumnWidthRight() + col.getActualWidth());
		}

		if (col.getPosition() == FixedCellPositions.NONE) {
			absoluteWidth += controller.getModel().getColumnSpacing();
			totalWidth += controller.getModel().getColumnSpacing();
			totalStarWidth += controller.getModel().getColumnSpacing();
			startPos += (double)controller.getModel().getColumnSpacing();
		}

		if (col.getState() != ColumnStates.HIDDEN) {
			if (col.getState() == ColumnStates.MOVING) {
				absoluteWidth += col.getActualWidth();

			} else {
				absoluteWidth += col.getActualWidth() - (int)java.lang.Math.round(col.getShiftAmount(model));
			}

		}

		if (col.getState() == ColumnStates.MOVING) {
			totalWidth += col.getActualWidth();
			totalStarWidth += col.getActualWidth();

		} else {
			totalWidth += col.getActualWidth() - (int)java.lang.Math.round(col.getShiftAmount(model));
			totalStarWidth += col.getActualWidth() - (int)java.lang.Math.round(col.getShiftAmount(model));
		}


	}

	if (totalStarWidth < availableWidth) {
		int delta = (availableWidth - totalStarWidth - controller.getModel().getColumnSpacing());
		starCols.inner[starCols.getCount() - 1].setActualWidth(starCols.inner[starCols.getCount() - 1].getActualWidth() + delta);
		absoluteWidth += delta;
		totalWidth += delta;
	}

	if (totalStarWidth > availableWidth) {
		int delta1 = (availableWidth - totalStarWidth - controller.getModel().getColumnSpacing());
		starCols.inner[starCols.getCount() - 1].setActualWidth(starCols.inner[starCols.getCount() - 1].getActualWidth() + delta1);
		absoluteWidth += delta1;
		totalWidth += delta1;
	}

	return absoluteWidth;
}


public int getFixedLeftColumnOffset(int col, double leftEdge, GridImplementation controller, VisualModel model) {
	int width = 0;
	for (int i = 0; i < col; i++) {
		if (model.getFixedLeftColumns().inner[i].getState() != ColumnStates.MOVING) {
			width += model.getFixedLeftColumns().inner[i].getActualWidth() + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(model.getFixedLeftColumns().inner[i].getShiftAmount(model));
		}

	}

	int offset = (int)leftEdge + width;
	offset = (int)(offset + (int)java.lang.Math.round(model.getFixedLeftColumns().inner[col].getResolvedLeftOffset(model)));
	return offset;
}


public int getFixedRightColumnOffset(int col, double rightEdge, GridImplementation controller, VisualModel model) {
	rightEdge = java.lang.Math.min(rightEdge, (double)model.getAbsoluteWidth());
	int width = model.getFixedColumnWidthRight();
	for (int i = 0; i < col; i++) {
		if (model.getFixedRightColumns().inner[i].getState() != ColumnStates.MOVING) {
			width -= model.getFixedRightColumns().inner[i].getActualWidth() + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(model.getFixedRightColumns().inner[i].getShiftAmount(model));
		}

	}

	int offset = (int)rightEdge - (width + (int)controller.getInset().getLeft());
	offset = (int)(offset + (int)java.lang.Math.round(model.getFixedRightColumns().inner[col].getResolvedLeftOffset(model)));
	return offset;
}


public int getColumnOffset(int col, GridImplementation controller, VisualModel model) {
	long columnId = model.getColumns().inner[col].getUniqueID();
	int offset = (int)controller.getInset().getLeft() + model.getFixedColumnWidthLeft() + model.getColumnSpacing();
	for (int i = 0; i < col; i++) {
		offset += (int)java.lang.Math.round(model.getSpacers().inner[i].getLeftActualWidth(columnId));
		if (model.getColumns().inner[i].getState() != ColumnStates.MOVING) {
			offset += (model.getColumns().inner[i].getActualWidth()) + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(model.getColumns().inner[i].getShiftAmount(model));
		}

		offset += (int)java.lang.Math.round(model.getSpacers().inner[i].getRightActualWidth(columnId));
	}

	offset += (int)java.lang.Math.round(model.getSpacers().inner[col].getLeftActualWidth(columnId));
	return (int)(offset + java.lang.Math.round(model.getColumns().inner[col].getResolvedLeftOffset(model)));
}


public int getStartOfColumnArea(int col, GridImplementation controller, VisualModel model) {
	long columnId = model.getColumns().inner[col].getUniqueID();
	int offset = (int)controller.getInset().getLeft() + model.getFixedColumnWidthLeft() + model.getColumnSpacing();
	for (int i = 0; i < col; i++) {
		offset += (int)java.lang.Math.round(model.getSpacers().inner[i].getLeftActualWidth(columnId));
		if (model.getColumns().inner[i].getState() != ColumnStates.MOVING) {
			offset += (model.getColumns().inner[i].getActualWidth()) + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(model.getColumns().inner[i].getShiftAmount(model));
		}

		offset += (int)java.lang.Math.round(model.getSpacers().inner[i].getRightActualWidth(columnId));
	}

	offset += (int)java.lang.Math.round(model.getSpacers().inner[col].getLeftActualWidth(columnId));
	return (int)(offset);
}


public int positionToColumn(double position, GridImplementation controller, VisualModel model) {
	int col = 0;
	int width = 0;
	int startingOffset = model.getFixedColumnWidthLeft() + (int)controller.getInset().getLeft();
	width += startingOffset;
	for (IEnumerator__1<ColumnInfo> en = model.getColumns().getEnumerator(); en.moveNext();) {
	ColumnInfo columnInfo = (ColumnInfo)en.getCurrent();
		width += (int)java.lang.Math.round(model.getSpacers().inner[col].getLeftActualWidth(-1));
		if (columnInfo.getState() != ColumnStates.MOVING) {
			width += (columnInfo.getActualWidth()) + controller.getModel().getColumnSpacing() - (int)java.lang.Math.round(columnInfo.getShiftAmount(model));
		}

		if (position <= width) {
			return col;
		}

		width += (int)java.lang.Math.round(model.getSpacers().inner[col].getRightActualWidth(-1));
		col++;

	}

	int limit = model.getColumns().getCount() - 1;
	if (col > limit) {
	col = limit;
	}

	return col;
}


public RowPath positionToRow(double position, VisualModel model) {
	int sectionCount = model.getSections().getCount();
	for (int i = 0; i < sectionCount; i++) {
		SectionInfo sectionInfo = model.getSections().inner[i];
		int sectionTop = sectionInfo.getOffset();
		int sectionBottom = sectionTop + sectionInfo.resolveTotalHeight();
		if (position <= sectionBottom) {
			if (position < sectionTop) {
			position = (double)sectionTop;
			}

			return sectionInfo.findRowAtLocation(position);
		}

	}

	return new RowPath(model.getSections().getCount() - 1, model.getSections().inner[model.getSections().getCount() - 1].getRowCount() - 1);
}


public void onColumnRemovedAt(GridLayerController layerController, int index, ColumnImplementation column, VisualModel model) {
	yankColumn(layerController, index, model, false);
	for (int i = index + 1; i < model.getColumns().getCount(); i++) {
		shiftColumn(i, model, false, index);
	}

}


public void onColumnInsertedAt(int index, ColumnImplementation column, VisualModel model) {
	for (int i = model.getColumns().getCount() - 1; i >= index; i--) {
		shiftColumn(i, model, true, index);
	}

}


public void onRowInsertedAt(RowPath row, VisualModel model) {
	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		List__1<CellModel> toIncrement = new List__1<CellModel>(new TypeInfo(CellModel.class));
		GridLayer currLayer = model.getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			if (currKey.getSection() > row.getSection() || (currKey.getSection() == row.getSection() && currKey.getRow() >= row.getRow())) {
				toIncrement.add(currLayer.getValueList().inner[p]);
			}

		}

		for (int j = 0; j < toIncrement.getCount(); j++) {
			CellModel currModel = toIncrement.inner[j];
			currLayer.remove(currModel.getPath());
			currModel.getPath().setRow(currModel.getPath().getRow() + 1);
		}

		for (int j1 = 0; j1 < toIncrement.getCount(); j1++) {
			CellModel currModel1 = toIncrement.inner[j1];
			currLayer.add(currModel1.getPath(), currModel1);
		}

	}

}


public void onRowRemovedAt(RowPath row, VisualModel model) {
	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		List__1<CellModel> toIncrement = new List__1<CellModel>(new TypeInfo(CellModel.class));
		GridLayer currLayer = model.getGridLayers().inner[i];
		List__1<CellPath> toRemove = new List__1<CellPath>(new TypeInfo(CellPath.class));
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			if (currKey.getSection() > row.getSection() || (currKey.getSection() == row.getSection() && currKey.getRow() > row.getRow())) {
				toIncrement.add(currLayer.getValueList().inner[p]);
			}

			if (currKey.getSection() == row.getSection() && currKey.getRow() == row.getRow()) {
				toRemove.add(currKey);
			}

		}

		for (int k = 0; k < toRemove.getCount(); k++) {
			CellPath currRemove = toRemove.inner[k];
			currLayer.remove(currRemove);
		}

		for (int j = 0; j < toIncrement.getCount(); j++) {
			CellModel currModel = toIncrement.inner[j];
			currLayer.remove(currModel.getPath());
			currModel.getPath().setRow(currModel.getPath().getRow() - 1);
			currLayer.add(currModel.getPath(), currModel);
		}

	}

}


private void shiftColumn(int index, VisualModel model, boolean up, int startIndex) {
	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		List__1<CellModel> toIncrement = new List__1<CellModel>(new TypeInfo(CellModel.class));
		GridLayer currLayer = model.getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			if (currKey.getColumn() == index && (currKey.getIsContentCell() || currKey.getIsHeaderCell())) {
				toIncrement.add(currLayer.getValueList().inner[p]);
			}

		}

		for (int j = 0; j < toIncrement.getCount(); j++) {
			CellModel currModel = toIncrement.inner[j];
			currLayer.remove(currModel.getPath());
			if (up) {
				currModel.getPath().setColumn(currModel.getPath().getColumn() + 1);

			} else {
				currModel.getPath().setColumn(currModel.getPath().getColumn() - 1);
			}

			currLayer.add(currModel.getPath(), currModel);
		}

	}

	List__1<GridColumnSpacerCollection> spacers = model.getSpacers();
	if (up) {
		if (index == spacers.getCount() - 1) {
			spacers.add(new GridColumnSpacerCollection());
		}

		for (int i1 = spacers.inner[index].getCount() - 1; i1 >= 0; i1--) {
			if (index != startIndex || spacers.inner[index].inner[i1].getIsRight()) {
				spacers.inner[index + 1].add(spacers.inner[index].inner[i1]);
				spacers.inner[index].removeAt(i1);
			}

		}


	} else {
		for (int i2 = spacers.inner[index].getCount() - 1; i2 >= 0; i2--) {
			spacers.inner[index - 1].add(spacers.inner[index].inner[i2]);
			spacers.inner[index].removeAt(i2);
		}

	}

}

private GridColumnSpacerCollection _yankedSpacers = new GridColumnSpacerCollection();


private void yankColumn(GridLayerController layerController, int index, VisualModel model, boolean tempYank) {
	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		List__1<CellModel> toYank = new List__1<CellModel>(new TypeInfo(CellModel.class));
		GridLayer currLayer = model.getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			if (currKey.getColumn() == index && (currKey.getIsContentCell() || currKey.getIsHeaderCell())) {
				toYank.add(currLayer.getValueList().inner[p]);
			}

		}

		for (int j = 0; j < toYank.getCount(); j++) {
			CellModel currModel = toYank.inner[j];
			if (tempYank) {
				currLayer.remove(currModel.getPath());
				currModel.getPath().setColumn(CellPath.TEMP_YANKED_COLUMN_INDEX);
				currLayer.add(currModel.getPath(), currModel);

			} else {
				layerController.removeModel(currModel.getPath(), model);
			}

		}

	}

	List__1<GridColumnSpacerCollection> spacers = model.getSpacers();
	for (int i1 = spacers.inner[index].getCount() - 1; i1 >= 0; i1--) {
		_yankedSpacers.add(spacers.inner[index].inner[i1]);
		spacers.inner[index].removeAt(i1);
	}

}


private void restoreColumn(int index, VisualModel model) {
	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		List__1<CellModel> toRestore = new List__1<CellModel>(new TypeInfo(CellModel.class));
		GridLayer currLayer = model.getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			if (currKey.getColumn() == CellPath.TEMP_YANKED_COLUMN_INDEX && (currKey.getIsContentCell() || currKey.getIsHeaderCell())) {
				toRestore.add(currLayer.getValueList().inner[p]);
			}

		}

		for (int j = 0; j < toRestore.getCount(); j++) {
			CellModel currModel = toRestore.inner[j];
			currLayer.remove(currModel.getPath());
			currModel.getPath().setColumn(index);
			currLayer.add(currModel.getPath(), currModel);
		}

	}

}


public void onColumnsReset(GridLayerController layerController, VisualModel model) {
	for (int i = 0; i < model.getColumns().getCount(); i++) {
		yankColumn(layerController, i, model, false);
	}

}


public void onColumnMoved(GridLayerController layerController, VisualModel model, int oldIndex, int newIndex, long columnId) {
	yankColumn(layerController, oldIndex, model, true);
	for (int i = oldIndex + 1; i < model.getColumns().getCount(); i++) {
		shiftColumn(i, model, false, oldIndex);
	}

	for (int i1 = model.getColumns().getCount() - 1; i1 >= newIndex; i1--) {
		shiftColumn(i1, model, true, newIndex);
	}

	restoreColumn(newIndex, model);
	List__1<GridColumnSpacerCollection> spacers = model.getSpacers();
	for (int i2 = _yankedSpacers.getCount() - 1; i2 >= 0; i2--) {
		spacers.inner[oldIndex].add(_yankedSpacers.inner[i2]);
		_yankedSpacers.removeAt(i2);
	}

}


public int getAbsoluteIndex(VisualModel model, RowPath rowPath) {
	if (rowPath == null) {
		return 0;
	}

	int index = 0;
	for (int i = 0; i < rowPath.getSection(); i++) {
		index += model.getSections().inner[index].getRowCount();
	}

	index += rowPath.getRow();
	return index;
}

}
