//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
interface IExternalTemplateColumn {

public String resolveStyleKey(String defaultKey, CellPath path, GridImplementation grid, Object resolvedValue);


public void raiseCreateOrUpdate(TemplateCellModel model, Object cell);

}
