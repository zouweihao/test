//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class SectionFooterImplementation
extends DefinitionBaseImplementation {

protected CellModel createModelOverride(CellPath path) {
	return null;
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "sectionFooter";
}

}
