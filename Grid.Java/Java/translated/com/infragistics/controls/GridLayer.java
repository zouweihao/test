//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class GridLayer
extends FastIterationDictionary__2<CellPath, CellModel> {

private String _name;
public String setName(String value) {
_name = value;
return value;
}
public String getName() {
	return _name;
}

public GridLayer(String name) {


	super(new TypeInfo(CellPath.class), new TypeInfo(CellModel.class));
		setName(name);
}

}
