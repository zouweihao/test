//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class CellActionManager
implements ICellActionManager {
private GridImplementation _grid;

private CellModel _model;

public CellActionManager(GridImplementation grid, CellModel model) {



		_grid = grid;
		_model = model;
}


public void clickCell() {
	if (_grid != null && _model != null) {
		_grid.onCellClicked(_model);
	}

}


public boolean getIsClickActionDesired() {

		return _grid.getIsClickActionDesired();

}

}
