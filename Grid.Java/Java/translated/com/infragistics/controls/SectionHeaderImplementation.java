//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
class SectionHeaderImplementation
extends DefinitionBaseImplementation {

public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return "sectionHeader";
}


protected CellModel createModelOverride(CellPath path) {
	return null;
}

}
