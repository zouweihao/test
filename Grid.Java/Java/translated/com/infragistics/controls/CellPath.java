//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class CellPath
extends RowPath {
public static final int ROW_SEPARATOR_COLUMN_INDEX = -300;

public static final int TEMP_YANKED_COLUMN_INDEX = -800;

private int _column;


public int setColumn(int value) {

	_column = value;
	calculateHashCode();
return value;
}
public int getColumn() {

		return _column;

}

private int _cellHashCode = -1;


protected void calculateHashCode() {
	super.calculateHashCode();
	_cellHashCode = (getColumn() * 100000000) + super.hashCode();
}

public CellPath(FixedCellPositions position, int column, int section, int row) {


	this(column, section, row);
		setFixedPosition(position);
		calculateHashCode();
}

public CellPath(int column, int section, int row) {


	super(section, row);
		_column = column;
		calculateHashCode();
}


public int hashCode() {
	return _cellHashCode;
}


public boolean equals(Object obj) {
	if (!super.equals(obj)) {
	return false;
	}

	CellPath other = (CellPath)obj;
	if (obj == null) {
	return false;
	}

	if (_column != other._column) {
	return false;
	}

	return true;
}


public String toString() {
	return com.infragistics.controls.StringHelper.add(com.infragistics.controls.StringHelper.add(_column, "."), super.toString());
}


public Object clone() {
	return new CellPath(this.getFixedPosition(), _column, this.getSection(), this.getRow());
}


public boolean getIsRowSeparator() {

		return (_column == ROW_SEPARATOR_COLUMN_INDEX);

}


public boolean getIsContentCell() {

		return ((_column >= 0 || _column == TEMP_YANKED_COLUMN_INDEX) && getRow() >= 0 && getRow() >= 0);

}

}
