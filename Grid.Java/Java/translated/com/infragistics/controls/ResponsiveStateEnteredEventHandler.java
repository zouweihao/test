//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class ResponsiveStateEnteredEventHandler
	extends com.infragistics.controls.FunctionDelegate {
	public ResponsiveStateEnteredEventHandler() {
		super();
	}
	public ResponsiveStateEnteredEventHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object sender, ResponsiveStateEnteredEventArgs eventArgs);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		ResponsiveStateEnteredEventHandler p1 = (ResponsiveStateEnteredEventHandler)del1;
		ResponsiveStateEnteredEventHandler p2 = (ResponsiveStateEnteredEventHandler)del2;
		ResponsiveStateEnteredEventHandler ret = new ResponsiveStateEnteredEventHandler() {
		public void invoke(Object sender, ResponsiveStateEnteredEventArgs eventArgs) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				ResponsiveStateEnteredEventHandler han = (ResponsiveStateEnteredEventHandler)getDelegateList().get(i);
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
	ResponsiveStateEnteredEventHandler p1 = (ResponsiveStateEnteredEventHandler)del1;
	ResponsiveStateEnteredEventHandler p2 = (ResponsiveStateEnteredEventHandler)del2;
	ResponsiveStateEnteredEventHandler ret = new ResponsiveStateEnteredEventHandler() {
	public void invoke(Object sender, ResponsiveStateEnteredEventArgs eventArgs) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			ResponsiveStateEnteredEventHandler han = (ResponsiveStateEnteredEventHandler)getDelegateList().get(i);
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
