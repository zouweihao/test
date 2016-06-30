//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class SectionInfo {

private int _index;
public int setIndex(int value) {
_index = value;
return value;
}
public int getIndex() {
	return _index;
}


private int _rowCount;
public int setRowCount(int value) {
_rowCount = value;
return value;
}
public int getRowCount() {
	return _rowCount;
}


private int _totalRowHeight;
public int setTotalRowHeight(int value) {
_totalRowHeight = value;
return value;
}
public int getTotalRowHeight() {
	return _totalRowHeight;
}


private int _rowSeparatorHeight;
public int setRowSeparatorHeight(int value) {
_rowSeparatorHeight = value;
return value;
}
public int getRowSeparatorHeight() {
	return _rowSeparatorHeight;
}


private int _headerHeight;
public int setHeaderHeight(int value) {
_headerHeight = value;
return value;
}
public int getHeaderHeight() {
	return _headerHeight;
}


private int _footerHeight;
public int setFooterHeight(int value) {
_footerHeight = value;
return value;
}
public int getFooterHeight() {
	return _footerHeight;
}


private int _rowHeight;
public int setRowHeight(int value) {
_rowHeight = value;
return value;
}
public int getRowHeight() {
	return _rowHeight;
}


private int _rowSpacing;
public int setRowSpacing(int value) {
_rowSpacing = value;
return value;
}
public int getRowSpacing() {
	return _rowSpacing;
}


private int _offset;
public int setOffset(int value) {
_offset = value;
return value;
}
public int getOffset() {
	return _offset;
}


private IntList _rowHeights;
public IntList setRowHeights(IntList value) {
_rowHeights = value;
return value;
}
public IntList getRowHeights() {
	return _rowHeights;
}


private IntList _rowOffsets;
public IntList setRowOffsets(IntList value) {
_rowOffsets = value;
return value;
}
public IntList getRowOffsets() {
	return _rowOffsets;
}


public int resolveTotalHeight() {
	return getTotalRowHeight() + getHeaderHeight() + getFooterHeight() + ((getRowSeparatorHeight() + getRowSpacing()) * getRowCount());
}


public int getHeightForRow(int row) {
	if (row == GridImplementation.SectionHeaderRowIndex) {
		return getHeaderHeight();
	}

	if (row == GridImplementation.SectionFooterRowIndex) {
		return getFooterHeight();
	}

	if (getRowHeights() == null) {
	return getRowHeight();

	} else {
	return getRowHeights().inner[row];
	}

}


public int getOffsetForRow(int row) {
	if (getRowOffsets() == null) {
		if (row == GridImplementation.SectionHeaderRowIndex) {
		return 0;

		} else if (row == GridImplementation.SectionFooterRowIndex) {
		return resolveTotalHeight() - getHeaderHeight();
		}


		return (row * resolveFullRowHeight()) + getHeaderHeight();

	} else {
		if (row == GridImplementation.SectionHeaderRowIndex) {
			return 0;

		} else if (row == GridImplementation.SectionFooterRowIndex) {
			return resolveTotalHeight() - getFooterHeight();
		}


		return getRowOffsets().inner[row];
	}

}


public int resolveFullRowHeight() {
	return getRowHeight() + getRowSpacing() + getRowSeparatorHeight();
}


public int resolveFullHeightForRow(int rowIndex) {
	if (this.getRowOffsets() == null) {
	return getRowHeight() + getRowSpacing() + getRowSeparatorHeight();

	} else {
	return getRowHeights().inner[rowIndex] + getRowSeparatorHeight() + getRowSpacing();
	}

}


public RowPath findRowAtLocation(double y) {
	y -= (double)this.getOffset();
	if (y < this.getHeaderHeight()) {
		return new RowPath(this.getIndex(), GridImplementation.SectionHeaderRowIndex);

	} else if (y > this.resolveTotalHeight() - getFooterHeight()) {
		return new RowPath(this.getIndex(), GridImplementation.SectionFooterRowIndex);
	}


	y -= (double)getHeaderHeight();
	if (this.getRowHeights() == null) {
		int height = this.resolveFullRowHeight();
		int i = (int)(y / height);
		if (i >= this.getRowCount()) {
		i = this.getRowCount() - 1;
		}

		return new RowPath(this.getIndex(), i);

	} else {
		for (int i1 = 0; i1 < this.getRowCount(); i1++) {
			int rowTop = this.getRowOffsets().inner[i1];
			int height1 = this.resolveFullHeightForRow(i1);
			if (y >= rowTop && y <= rowTop + height1) {
				return new RowPath(this.getIndex(), i1);
			}

		}

	}

	return null;
}

}
