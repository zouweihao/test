//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


abstract class GridAnimationManagerAnimationCompletedEventHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridAnimationManagerAnimationCompletedEventHandler() {
		super();
	}
	public GridAnimationManagerAnimationCompletedEventHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object sender, GridAnimationManagerAnimationCompletedEventArgs args);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridAnimationManagerAnimationCompletedEventHandler p1 = (GridAnimationManagerAnimationCompletedEventHandler)del1;
		GridAnimationManagerAnimationCompletedEventHandler p2 = (GridAnimationManagerAnimationCompletedEventHandler)del2;
		GridAnimationManagerAnimationCompletedEventHandler ret = new GridAnimationManagerAnimationCompletedEventHandler() {
		public void invoke(Object sender, GridAnimationManagerAnimationCompletedEventArgs args) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridAnimationManagerAnimationCompletedEventHandler han = (GridAnimationManagerAnimationCompletedEventHandler)getDelegateList().get(i);
				han.invoke(sender, args);
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
	GridAnimationManagerAnimationCompletedEventHandler p1 = (GridAnimationManagerAnimationCompletedEventHandler)del1;
	GridAnimationManagerAnimationCompletedEventHandler p2 = (GridAnimationManagerAnimationCompletedEventHandler)del2;
	GridAnimationManagerAnimationCompletedEventHandler ret = new GridAnimationManagerAnimationCompletedEventHandler() {
	public void invoke(Object sender, GridAnimationManagerAnimationCompletedEventArgs args) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridAnimationManagerAnimationCompletedEventHandler han = (GridAnimationManagerAnimationCompletedEventHandler)getDelegateList().get(i);
			han.invoke(sender, args);
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
