//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class ResponsiveStateExitedEventHandler
	extends com.infragistics.controls.FunctionDelegate {
	public ResponsiveStateExitedEventHandler() {
		super();
	}
	public ResponsiveStateExitedEventHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object sender, ResponsiveStateExitedEventArgs eventArgs);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		ResponsiveStateExitedEventHandler p1 = (ResponsiveStateExitedEventHandler)del1;
		ResponsiveStateExitedEventHandler p2 = (ResponsiveStateExitedEventHandler)del2;
		ResponsiveStateExitedEventHandler ret = new ResponsiveStateExitedEventHandler() {
		public void invoke(Object sender, ResponsiveStateExitedEventArgs eventArgs) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				ResponsiveStateExitedEventHandler han = (ResponsiveStateExitedEventHandler)getDelegateList().get(i);
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
	ResponsiveStateExitedEventHandler p1 = (ResponsiveStateExitedEventHandler)del1;
	ResponsiveStateExitedEventHandler p2 = (ResponsiveStateExitedEventHandler)del2;
	ResponsiveStateExitedEventHandler ret = new ResponsiveStateExitedEventHandler() {
	public void invoke(Object sender, ResponsiveStateExitedEventArgs eventArgs) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			ResponsiveStateExitedEventHandler han = (ResponsiveStateExitedEventHandler)getDelegateList().get(i);
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
