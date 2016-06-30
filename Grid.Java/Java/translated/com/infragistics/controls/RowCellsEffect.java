//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class RowCellsEffect
extends GridEffect {

private RowPath _path;
public RowPath setPath(RowPath value) {
_path = value;
return value;
}
public RowPath getPath() {
	return _path;
}


public boolean appliesToCell(CellPath path, VisualModel model) {
	if (getPath().getSection() == path.getSection() && getPath().getRow() == path.getRow() && getPath().getFixedPosition() == path.getFixedPosition()) {
		return true;
	}

	return false;
}


public void onRowInsertedAt(RowPath path) {
	setPath((CellPath)modifyRowForInsertion(getPath(), path));
}


public void onRowRemovedAt(RowPath path) {
	setPath((CellPath)modifyRowForRemoval(getPath(), path));
}


public int getRelativeIndex(VisualModel model, CellPath item) {
	return item.getColumn() - getStartItem().getColumn();
}

}
