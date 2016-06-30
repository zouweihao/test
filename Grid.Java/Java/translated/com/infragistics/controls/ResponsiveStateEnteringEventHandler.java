//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class ResponsiveStateEnteringEventHandler
	extends com.infragistics.controls.FunctionDelegate {
	public ResponsiveStateEnteringEventHandler() {
		super();
	}
	public ResponsiveStateEnteringEventHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object sender, ResponsiveStateEnteringEventArgs eventArgs);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		ResponsiveStateEnteringEventHandler p1 = (ResponsiveStateEnteringEventHandler)del1;
		ResponsiveStateEnteringEventHandler p2 = (ResponsiveStateEnteringEventHandler)del2;
		ResponsiveStateEnteringEventHandler ret = new ResponsiveStateEnteringEventHandler() {
		public void invoke(Object sender, ResponsiveStateEnteringEventArgs eventArgs) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				ResponsiveStateEnteringEventHandler han = (ResponsiveStateEnteringEventHandler)getDelegateList().get(i);
				han.invoke(sender, eventArgs);
			}
		}
	};
	combineLists(ret, p1, p2);
	return ret;
}
public FunctionDelegate removeCore(FunctionDelegate del1, FunctionDelegate del2) {
	return staticRemoveCore(del1, del2);
}
private static FunctionDelegate staticRemoveCore(FunctionDelegate del1, FunctionDelegate del2) {
	ResponsiveStateEnteringEventHandler p1 = (ResponsiveStateEnteringEventHandler)del1;
	ResponsiveStateEnteringEventHandler p2 = (ResponsiveStateEnteringEventHandler)del2;
	ResponsiveStateEnteringEventHandler ret = new ResponsiveStateEnteringEventHandler() {
	public void invoke(Object sender, ResponsiveStateEnteringEventArgs eventArgs) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			ResponsiveStateEnteringEventHandler han = (ResponsiveStateEnteringEventHandler)getDelegateList().get(i);
			han.invoke(sender, eventArgs);
		}
	}
};
removeLists(ret, p1, p2);
if (p1.getDelegateList().size() < 1) {
return null;
}
return ret;
}
}
