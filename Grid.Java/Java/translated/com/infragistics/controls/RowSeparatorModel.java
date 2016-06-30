//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;




class RowSeparatorModel
extends CellModel {
public RowSeparatorModel() {



}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new RowSeparatorModelExport();
	}

	export = super.createModelExport(export);
	return export;
}

}
