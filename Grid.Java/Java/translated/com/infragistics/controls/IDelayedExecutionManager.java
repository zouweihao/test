//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
interface IDelayedExecutionManager {

public int executeIn(Action action, int delayInMS);


public void cancelPending(int id);

}
