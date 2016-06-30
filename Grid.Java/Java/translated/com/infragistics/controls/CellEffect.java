//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class CellEffect
extends GridEffect {

private CellPath _path;
public CellPath setPath(CellPath value) {
_path = value;
return value;
}
public CellPath getPath() {
	return _path;
}


public boolean appliesToCell(CellPath path, VisualModel model) {
	if (path.equals(getPath())) {
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

}
