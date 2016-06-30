//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class RowPath {
private int _section;


public int setSection(int value) {

	_section = value;
	calculateHashCode();
return value;
}
public int getSection() {

		return _section;

}

private int _row;


public int setRow(int value) {

	_row = value;
	calculateHashCode();
return value;
}
public int getRow() {

		return _row;

}

private FixedCellPositions _fixedPosition;


public FixedCellPositions setFixedPosition(FixedCellPositions value) {

	_fixedPosition = value;
	calculateHashCode();
return value;
}
public FixedCellPositions getFixedPosition() {

		return _fixedPosition;

}

public RowPath(int section, int row) {



		setFixedPosition(FixedCellPositions.NONE);
		_section = section;
		_row = row;
		calculateHashCode();
}

private int _hashCode = -1;


protected void calculateHashCode() {
	_hashCode = (_section * 1000000) + _row;
}


public int hashCode() {
	return _hashCode;
}


public boolean equals(Object obj) {
	RowPath other = (RowPath)obj;
	if (_fixedPosition != other._fixedPosition) {
	return false;
	}

	if (_section != other._section) {
	return false;
	}

	if (_row != other._row) {
	return false;
	}

	return true;
}


public String toString() {
	return com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add("F", _fixedPosition), "."), _section), "."), _row);
}

public static final int HEADER_SECTION_INDEX = -100;

public static final int HEADER_ROW_INDEX = -100;

public static final int SECTION_HEADER_ROW_INDEX = -200;

public static final int SECTION_FOOTER_ROW_INDEX = -201;


public boolean getIsHeaderCell() {

		return (_row == HEADER_ROW_INDEX && _section == HEADER_SECTION_INDEX);

}


public boolean getIsSectionBoundingCell() {

		return (_row == SECTION_HEADER_ROW_INDEX || _row == SECTION_FOOTER_ROW_INDEX);

}


public boolean getIsSectionHeaderCell() {

		return (_row == SECTION_HEADER_ROW_INDEX);

}


public boolean getIsSectionFooterCell() {

		return (_row == SECTION_FOOTER_ROW_INDEX);

}


public Object clone() {
	RowPath ret = new RowPath(this.getSection(), this.getRow());
	ret.setFixedPosition(this.getFixedPosition());
	return ret;
}

}
