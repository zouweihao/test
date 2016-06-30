//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class VisibilityEngine {
private int _leftCol;
private int _rightCol;

private RowPath _topRow;
private RowPath _bottomRow;

public VisibilityEngine() {



}


public void calculate(GridImplementation controller) {
	calculate(controller, controller.getModel(), controller.getSpatialEngine(), false);
}


public void calculate(GridImplementation controller, VisualModel model, SpatialEngine spatialEngine, boolean forceRefresh) {
	Rect actualVisibleRegion = model.getActualVisibleRegion();
	if (actualVisibleRegion.getIsEmpty()) {
		return;
	}

	if (actualVisibleRegion._width == 0 || actualVisibleRegion._height == 0) {
		return;
	}

	if (model.getColumns().getCount() == 0) {
	return;
	}

	if (controller.getAdapter() == null) {
		return;
	}

	CalculationParameters parameters;
	parameters = new CalculationParameters();
	parameters.top = actualVisibleRegion._top;
	parameters.bottom = actualVisibleRegion._bottom;
	parameters.left = actualVisibleRegion._left;
	parameters.right = actualVisibleRegion._right;
	parameters.adjustedLeft = java.lang.Math.max(parameters.left, controller.getInset().getLeft());
	parameters.adjustRight = java.lang.Math.min(parameters.right, model.getAbsoluteWidth() - controller.getInset().getRight());
	parameters.adjustedMaxWidth = parameters.adjustRight - parameters.adjustedLeft;
	parameters.topRow = spatialEngine.positionToRow(parameters.top, model);
	parameters.bottomRow = spatialEngine.positionToRow(parameters.bottom, model);
	parameters.leftColumn = spatialEngine.positionToColumn(parameters.left, controller, model);
	parameters.rightColumn = spatialEngine.positionToColumn(parameters.right, controller, model);
	for (int i = 0; i < model.getColumns().getCount(); i++) {
		if (model.getColumns().inner[i].getState() == ColumnStates.HIDING || model.getColumns().inner[i].getState() == ColumnStates.SHOWING || model.getColumns().inner[i].getState() == ColumnStates.MOVING) {
			parameters.leftColumn = java.lang.Math.min(parameters.leftColumn, i);
			parameters.rightColumn = java.lang.Math.max(parameters.rightColumn, i);
		}

	}

	model.setTopRow(parameters.topRow);
	model.setBottomRow(parameters.bottomRow);
	model.setLeftColumn(parameters.leftColumn);
	model.setRightColumn(parameters.rightColumn);
	controller.onVisibleRangeChanged();
	if (parameters.leftColumn == -1 | parameters.rightColumn == -1) {
		return;
	}

	if (!forceRefresh && (_leftCol == parameters.leftColumn) & (_rightCol == parameters.rightColumn) & (_topRow == parameters.topRow) & (_bottomRow == parameters.bottomRow)) {
		return;

	} else {
		_leftCol = parameters.leftColumn;
		_rightCol = parameters.rightColumn;
		_topRow = parameters.topRow;
		_bottomRow = parameters.bottomRow;
	}

	GridLayerController layersController = controller.getGridLayerController();
	hideNonVisibleModels(controller, model, parameters, layersController);
	calculateHeaders(controller, model, parameters, layersController);
	parameters.top += (double)model.getFixedRowHeight();
	if (_bottomRow.getRow() == -1) {
		return;
	}

	calculateSections(controller, model, parameters);
	controller.getEffectManager().forceTickCells();
}


private void hideNonVisibleModels(GridImplementation controller, VisualModel model, CalculationParameters parameters, GridLayerController layersController) {
	int startSection = _topRow.getSection();
	int endSection = _bottomRow.getSection();
	int startRow = _topRow.getRow();
	int endRow = _bottomRow.getRow();
	int startColumn = _leftCol;
	int endColumn = _rightCol;
	int currSection = 0;
	int currRow = 0;
	int currColumn = 0;
	boolean currHidden = false;
	boolean currSpansColumns = false;
	boolean currIsRowPinned = false;
	boolean currIsHeader = false;
	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		GridLayer currLayer = model.getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			currSpansColumns = false;
			currHidden = false;
			currSection = currKey.getSection();
			currRow = currKey.getRow();
			currColumn = currKey.getColumn();
			currSpansColumns = currKey.getIsRowSeparator() || currKey.getIsSectionBoundingCell();
			currIsHeader = currKey.getIsHeaderCell();
			currIsRowPinned = currKey.getIsHeaderCell();
			if (!currSpansColumns && (currColumn < startColumn || currColumn > endColumn)) {
				currHidden = true;

			} else if (!currIsHeader && (currSection < startSection || currSection > endSection)) {
				currHidden = true;

			} else {
				if (!currIsRowPinned) {
					if (currSection == startSection && currRow < startRow) {
						currHidden = true;
					}

					if (currSection == endSection && currRow > endRow) {
						currHidden = true;
					}

				}

			}


			if (currHidden) {
				controller.getGridLayerController().removeModel(currKey, model);
			}

		}

	}

}


private void calculateSections(GridImplementation controller, VisualModel model, CalculationParameters parameters) {
	RowPath topRow = parameters.topRow;
	RowPath bottomRow = parameters.bottomRow;
	int bottomRowSection = bottomRow.getSection();
	CellPath reusablePath = new CellPath(0, 0, 0);
	for (int sectionIndex = topRow.getSection(); sectionIndex <= bottomRowSection; sectionIndex++) {
		calculateSection(sectionIndex, controller, model, parameters, reusablePath);
	}

}


private void calculateSection(int sectionIndex, GridImplementation controller, VisualModel model, CalculationParameters parameters, CellPath reusablePath) {
	RowPath topRow = parameters.topRow;
	RowPath bottomRow = parameters.bottomRow;
	List__1<SectionInfo> sections = model.getSections();
	GridLayerController layersController = controller.getGridLayerController();
	int bottomRowSection = bottomRow.getSection();
	double adjustedLeft = parameters.adjustedLeft;
	double adjustedRight = parameters.adjustRight;
	double adjustedMaxWidth = parameters.adjustedMaxWidth;
	SectionInfo sectionInfo = sections.inner[sectionIndex];
	int endRowIndex = sectionIndex == bottomRowSection ? bottomRow.getRow() : sectionInfo.getRowCount() - 1;
	if (endRowIndex == GridImplementation.SectionFooterRowIndex) {
	endRowIndex = sectionInfo.getRowCount() - 1;
	}

	int startIndex = 0;
	if (topRow.getSection() == sectionIndex) {
		startIndex = topRow.getRow() == GridImplementation.SectionHeaderRowIndex ? 0 : topRow.getRow();
	}

	if (startIndex == GridImplementation.SectionFooterRowIndex) {
		CellPath path = new CellPath(0, sectionIndex, GridImplementation.SectionHeaderRowIndex);
		updateSectionVisual(path, model, adjustedLeft, (double)sectionInfo.getOffset() + sectionInfo.resolveTotalHeight() - sectionInfo.getFooterHeight(), adjustedMaxWidth, sectionIndex, false, controller);
		reusablePath.setSection(sectionIndex);
		reusablePath.setRow(GridImplementation.SectionFooterRowIndex);
		reusablePath.setColumn(0);
		return;
	}

	if (sectionInfo.getHeaderHeight() > 0) {
		calculateSectionHeader(sectionIndex, controller, model, parameters, reusablePath, topRow, sectionInfo, startIndex);
	}

	if (sectionInfo.getFooterHeight() > 0) {
		calculateSectionFooter(sectionIndex, controller, model, parameters, reusablePath, layersController, bottomRowSection, sectionInfo);
	}

	reusablePath.setSection(sectionIndex);
	for (int rowIndex = startIndex; rowIndex <= endRowIndex; rowIndex++) {
		calculateRow(sectionIndex, controller, model, parameters, reusablePath, layersController, sectionInfo, rowIndex);
	}

}


private void calculateRow(int sectionIndex, GridImplementation controller, VisualModel model, CalculationParameters parameters, CellPath reusablePath, GridLayerController layersController, SectionInfo sectionInfo, int rowIndex) {
	reusablePath.setRow(rowIndex);
	List__1<ColumnInfo> columns = model.getColumns();
	int leftColumn = parameters.leftColumn;
	int rightColumn = parameters.rightColumn;
	double adjustedLeft = parameters.adjustedLeft;
	double adjustedRight = parameters.adjustRight;
	double adjustedMaxWidth = parameters.adjustedMaxWidth;
	int sectionInfoRowSeparatorHeight = sectionInfo.getRowSeparatorHeight();
	for (int col = leftColumn; col <= rightColumn; col++) {
		ColumnInfo colInfo = columns.inner[col];
		reusablePath.setColumn(colInfo.getIndex());
		reusablePath.setFixedPosition(colInfo.getPosition());
		updateCellModel(colInfo, (CellPath)reusablePath.clone(), model, parameters.left, parameters.right, controller);
	}

	if (sectionInfoRowSeparatorHeight > 0) {
		reusablePath.setColumn(GridImplementation.RowSeparatorColumnIndex);
		updateSeparatorVisual(new CellPath(GridImplementation.RowSeparatorColumnIndex, sectionIndex, rowIndex), model, adjustedLeft, adjustedMaxWidth, (double)sectionInfo.getRowSeparatorHeight(), controller);
	}

}


private void calculateSectionFooter(int sectionIndex, GridImplementation controller, VisualModel model, CalculationParameters parameters, CellPath reusablePath, GridLayerController layersController, int bottomRowSection, SectionInfo sectionInfo) {
	double adjustedLeft = parameters.adjustedLeft;
	double adjustedRight = parameters.adjustRight;
	double adjustedMaxWidth = parameters.adjustedMaxWidth;
	reusablePath.setSection(sectionIndex);
	reusablePath.setRow(GridImplementation.SectionFooterRowIndex);
	reusablePath.setColumn(0);
	CellPath finalPath = new CellPath(reusablePath.getColumn(), reusablePath.getSection(), reusablePath.getRow());
	int actualSectionBottom = sectionInfo.getOffset() + sectionInfo.resolveTotalHeight() - sectionInfo.getFooterHeight();
	double bottomRowTop = (double)actualSectionBottom;
	if (sectionIndex == bottomRowSection) {
		bottomRowTop = parameters.bottom - sectionInfo.getFooterHeight();
		if (bottomRowTop < (sectionInfo.getOffset() + sectionInfo.getHeaderHeight())) {
		bottomRowTop = (double)(sectionInfo.getOffset() + sectionInfo.getHeaderHeight());
		}

		updateSectionVisual(finalPath, model, adjustedLeft, java.lang.Math.min((double)actualSectionBottom, bottomRowTop), adjustedMaxWidth, sectionIndex, false, true, controller);

	} else {
		updateSectionVisual(finalPath, model, adjustedLeft, java.lang.Math.min((double)actualSectionBottom, bottomRowTop), adjustedMaxWidth, sectionIndex, false, controller);
	}

}


private void calculateSectionHeader(int sectionIndex, GridImplementation controller, VisualModel model, CalculationParameters parameters, CellPath reusablePath, RowPath topRow, SectionInfo sectionInfo, int startIndex) {
	double adjustedLeft = parameters.adjustedLeft;
	double adjustedRight = parameters.adjustRight;
	double adjustedMaxWidth = parameters.adjustedMaxWidth;
	reusablePath.setSection(sectionIndex);
	reusablePath.setRow(GridImplementation.SectionHeaderRowIndex);
	reusablePath.setColumn(0);
	CellPath finalPath = new CellPath(reusablePath.getColumn(), reusablePath.getSection(), reusablePath.getRow());
	if (sectionIndex == topRow.getSection()) {
		if (startIndex == sectionInfo.getRowCount() - 1) {
			int lastRowHeight = sectionInfo.resolveFullHeightForRow(startIndex);
			int lastRowPos = sectionInfo.getOffsetForRow(startIndex) + sectionInfo.getOffset();
			int proposedTop = (lastRowPos + lastRowHeight) - sectionInfo.getHeaderHeight();
			updateSectionVisual(finalPath, model, adjustedLeft, java.lang.Math.min((double)proposedTop, parameters.top), adjustedMaxWidth, sectionIndex, true, true, controller);

		} else {
			updateSectionVisual(finalPath, model, adjustedLeft, java.lang.Math.max((double)sectionInfo.getOffset(), parameters.top - controller.getInset().getTop()), adjustedMaxWidth, sectionIndex, true, true, controller);
		}


	} else {
		updateSectionVisual(finalPath, model, adjustedLeft, (double)sectionInfo.getOffset(), adjustedMaxWidth, sectionIndex, true, controller);
	}

}


private void calculateHeaders(GridImplementation controller, VisualModel model, CalculationParameters parameters, GridLayerController layersController) {
	int leftColumn = parameters.leftColumn;
	int rightColumn = parameters.rightColumn;
	List__1<ColumnInfo> columns = model.getColumns();
	Thickness inset = controller.getInset();
	double topInset = inset.getTop();
	if (model.getHeaderHeight() > 0) {
		for (int col = leftColumn; col <= rightColumn; col++) {
			ColumnInfo colInfo = columns.inner[col];
			CellPath path = new CellPath(colInfo.getIndex(), GridImplementation.HeaderSectionIndex, GridImplementation.HeaderRowIndex);
			path.setFixedPosition(colInfo.getPosition());
			updateHeaderVisual(path, model, java.lang.Math.max(parameters.top, topInset), controller);
		}

	}

}


private void prepareModel(GridImplementation controller, VisualModel model, CellPath path, GridLayer desiredLayer, ModelTypes modelType, double left, double top, double width, double height) {
	controller.getGridLayerController().ensureModelReady(path, controller, model, desiredLayer, modelType);
	CellModel cellModel = controller.getGridLayerController().getModel(path, model);
	controller.getGridLayerController().positionModel(cellModel, model, left, top, width, height);
}


private void updateCellModel(ColumnInfo column, CellPath path, VisualModel model, double leftEdge, double rightEdge, GridImplementation controller) {
	int left = 0;
	int width = 0;
	GridLayer desiredLayer = model.getContentLayer();
	FixedCellPositions fixedPosition = path.getFixedPosition();
	SpatialEngine spatialEngine = controller.getSpatialEngine();
	if (fixedPosition == FixedCellPositions.NONE) {
		left = spatialEngine.getColumnOffset(path.getColumn(), controller, model);
		width = model.getColumns().inner[path.getColumn()].getActualWidth();
		if (model.getColumns().inner[path.getColumn()].getState() == ColumnStates.SHOWING || model.getColumns().inner[path.getColumn()].getState() == ColumnStates.HIDING || model.getColumns().inner[path.getColumn()].getState() == ColumnStates.HIDDEN) {
			desiredLayer = model.getSubContentLayer();
		}

		if (model.getColumns().inner[path.getColumn()].getState() == ColumnStates.MOVING) {
			desiredLayer = model.getSuperContentLayer();
		}

	}

	if (fixedPosition == FixedCellPositions.LEFT) {
		left = controller.getSpatialEngine().getFixedLeftColumnOffset(path.getColumn(), leftEdge, controller, model);
		desiredLayer = model.getFixedLayer();
		width = model.getFixedLeftColumns().inner[path.getColumn()].getActualWidth();
	}

	if (fixedPosition == FixedCellPositions.RIGHT) {
		left = controller.getSpatialEngine().getFixedRightColumnOffset(path.getColumn(), rightEdge, controller, model);
		desiredLayer = model.getFixedLayer();
		width = model.getFixedRightColumns().inner[path.getColumn()].getActualWidth();
	}

	SectionInfo sectionInfo = model.getSections().inner[path.getSection()];
	prepareModel(controller, model, path, desiredLayer, ModelTypes.CELL, (double)left, (double)sectionInfo.getOffsetForRow(path.getRow()) + sectionInfo.getOffset(), (double)width, (double)sectionInfo.getHeightForRow(path.getRow()));
}


private void updateFixedLeftHeaderVisual(CellPath path, VisualModel model, double top, double leftEdge, GridImplementation controller) {
	int left = controller.getSpatialEngine().getFixedLeftColumnOffset(path.getColumn(), (double)(int)leftEdge, controller, model);
	prepareModel(controller, model, path, model.getFixedHeaderLayer(), ModelTypes.COLUMN_HEADER, (double)left, top, (double)model.getFixedLeftColumns().inner[path.getColumn()].getActualWidth(), (double)model.getHeaderHeight());
}


private void updateFixedRightHeaderVisual(CellPath path, VisualModel model, double top, double rightEdge, GridImplementation controller) {
	int left = controller.getSpatialEngine().getFixedRightColumnOffset(path.getColumn(), (double)(int)rightEdge, controller, model);
	prepareModel(controller, model, path, model.getFixedHeaderLayer(), ModelTypes.COLUMN_HEADER, (double)left, top, (double)model.getFixedRightColumns().inner[path.getColumn()].getActualWidth(), (double)model.getHeaderHeight());
}


private void updateHeaderVisual(CellPath path, VisualModel model, double top, GridImplementation controller) {
	GridLayer desiredLayer = model.getHeaderLayer();
	if (model.getColumns().inner[path.getColumn()].getState() == ColumnStates.SHOWING || model.getColumns().inner[path.getColumn()].getState() == ColumnStates.HIDING || model.getColumns().inner[path.getColumn()].getState() == ColumnStates.HIDDEN) {
		desiredLayer = model.getSubHeaderLayer();
	}

	if (model.getColumns().inner[path.getColumn()].getState() == ColumnStates.MOVING) {
		desiredLayer = model.getSuperHeaderLayer();
	}

	prepareModel(controller, model, path, desiredLayer, ModelTypes.COLUMN_HEADER, (double)controller.getSpatialEngine().getColumnOffset(path.getColumn(), controller, model), top, (double)model.getColumns().inner[path.getColumn()].getActualWidth(), (double)model.getHeaderHeight());
}


private void updateSectionVisual(CellPath path, VisualModel model, double x, double y, double width, int section, boolean isHeader, GridImplementation controller) {
	updateSectionVisual(path, model, x, y, width, section, isHeader, false, controller);
}


private void updateSectionVisual(CellPath path, VisualModel model, double x, double y, double width, int section, boolean isHeader, boolean bringToFront, GridImplementation controller) {
	int height = isHeader ? model.getSections().inner[section].getHeaderHeight() : model.getSections().inner[section].getFooterHeight();
	ModelTypes modelType = ModelTypes.SECTION_FOOTER;
	GridLayer desiredLayer = model.getContentLayer();
	if (isHeader) {
		modelType = ModelTypes.SECTION_HEADER;
	}

	if (bringToFront) {
		desiredLayer = model.getDecoratorLayer();
	}

	prepareModel(controller, model, path, desiredLayer, modelType, x, y, width, (double)height);
}


private void updateSeparatorVisual(CellPath path, VisualModel model, double left, double width, double height, GridImplementation controller) {
	SectionInfo sectionInfo = model.getSections().inner[path.getSection()];
	int y = sectionInfo.resolveFullHeightForRow(path.getRow()) + sectionInfo.getOffsetForRow(path.getRow()) + sectionInfo.getOffset() - sectionInfo.getRowSeparatorHeight();
	prepareModel(controller, model, path, model.getDecoratorLayer(), ModelTypes.ROW_SEPARATOR, left, (double)y, width, height);
}

}
