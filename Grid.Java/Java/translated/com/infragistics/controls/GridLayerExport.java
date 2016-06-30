//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class GridLayerExport {
private List__1<CellModelExport> _cells;


private String _name;
public String setName(String value) {
_name = value;
return value;
}
public String getName() {
	return _name;
}


public List__1<CellModelExport> getCells() {

		return _cells;

}

public GridLayerExport(String name) {



		setName(name);
		_cells = new List__1<CellModelExport>(new TypeInfo(CellModelExport.class));
}


public void add(CellModelExport export) {
	_cells.add(export);
}


public void clear() {
	_cells.clear();
}


public String serialize() {
	IGStringBuilder sb = new IGStringBuilder();
	sb.append("[");
	for (int i = 0; i < _cells.getCount(); i++) {
		sb.append(_cells.inner[i].serialize());
		if (i < _cells.getCount() - 1) {
			sb.append(", ");
		}

	}

	sb.append("]");
	return sb.toString();
}

}
