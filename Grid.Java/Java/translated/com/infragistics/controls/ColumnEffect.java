//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class ColumnEffect
extends GridEffect {

private long _columnId;
public long setColumnId(long value) {
_columnId = value;
return value;
}
public long getColumnId() {
	return _columnId;
}


public boolean appliesToColumn(ColumnInfo column, VisualModel model) {
	if (getColumnId() == column.getUniqueID()) {
		return true;
	}

	return false;
}

}
