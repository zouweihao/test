//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class TextHeaderCellModel
extends TextCellModel {

public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new TextHeaderCellModelExport();
	}

	export = super.createModelExport(export);
	return export;
}

}
