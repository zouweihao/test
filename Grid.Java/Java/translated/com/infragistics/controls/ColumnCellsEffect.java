//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class ColumnCellsEffect
extends GridEffect {

private long _columnId;
public long setColumnId(long value) {
_columnId = value;
return value;
}
public long getColumnId() {
	return _columnId;
}


public boolean appliesToCell(CellPath path, VisualModel model) {
	ColumnInfo column = model.getColumnById(getColumnId());
	if (column == null) {
		return false;
	}

	if (path.getColumn() == column.getIndex() && column.getPosition() == path.getFixedPosition()) {
		return true;
	}

	return false;
}


protected CellPath getTrueStart(VisualModel model) {
	if (model.getHeaderHeight() > 0) {
		CellPath start = getStartItem();
		CellPath actualStart = new CellPath(start.getFixedPosition(), start.getColumn(), CellPath.HEADER_SECTION_INDEX, CellPath.HEADER_ROW_INDEX);
		return actualStart;

	} else {
		return getStartItem();
	}

}


public int getRelativeIndex(VisualModel model, CellPath item) {
	CellPath startPath = getStartItem();
	CellPath targetPath = item;
	if (targetPath == null) {
		return 0;
	}

	if (targetPath.getIsHeaderCell()) {
		return 0;
	}

	int offset = 0;
	if (model.getHeaderHeight() > 0) {
		offset++;
	}

	if (startPath == null) {
		return 0;
	}

	if (targetPath.getSection() == startPath.getSection()) {
		return (targetPath.getRow() - startPath.getRow()) + offset;
	}

	int relativeIndex = offset;
	int currentSectionIndex = startPath.getSection();
	if (targetPath.getSection() > startPath.getSection()) {
		while (currentSectionIndex <= targetPath.getSection()) {
			if (currentSectionIndex == startPath.getSection()) {
				relativeIndex += (model.getSections().inner[currentSectionIndex].getRowCount() - 1) - startPath.getRow();
				if (model.getSections().inner[currentSectionIndex].getFooterHeight() > 0) {
					relativeIndex++;
				}


			} else if (currentSectionIndex == targetPath.getSection()) {
				if (model.getSections().inner[currentSectionIndex].getHeaderHeight() > 0) {
					relativeIndex++;
				}

				relativeIndex += (targetPath.getRow() + 1);

			} else {
				if (model.getSections().inner[currentSectionIndex].getHeaderHeight() > 0) {
					relativeIndex++;
				}

				relativeIndex += model.getSections().inner[currentSectionIndex].getRowCount();
				if (model.getSections().inner[currentSectionIndex].getFooterHeight() > 0) {
					relativeIndex++;
				}

			}


			currentSectionIndex++;

		}

	} else if (targetPath.getSection() < startPath.getSection()) {
		while (currentSectionIndex >= targetPath.getSection()) {
			if (currentSectionIndex == startPath.getSection()) {
				relativeIndex -= startPath.getRow();
				if (model.getSections().inner[currentSectionIndex].getFooterHeight() > 0) {
					relativeIndex++;
				}


			} else if (currentSectionIndex == targetPath.getSection()) {
				if (model.getSections().inner[currentSectionIndex].getFooterHeight() > 0) {
					relativeIndex--;
				}

				relativeIndex -= (model.getSections().inner[currentSectionIndex].getRowCount() - targetPath.getRow());

			} else {
				if (model.getSections().inner[currentSectionIndex].getHeaderHeight() > 0) {
					relativeIndex--;
				}

				relativeIndex -= model.getSections().inner[currentSectionIndex].getRowCount();
				if (model.getSections().inner[currentSectionIndex].getFooterHeight() > 0) {
					relativeIndex--;
				}

			}


			currentSectionIndex--;

		}
	}


	return relativeIndex;
}

}
