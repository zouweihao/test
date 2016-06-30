//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


interface ICellRenderingEngine {

public void refresh(VisualModel visualModel, boolean immediate);


public void viewportChanged();


public void invalidateVisibility(Action validateVisibility);


public boolean getInitialRefreshFinished();

}
