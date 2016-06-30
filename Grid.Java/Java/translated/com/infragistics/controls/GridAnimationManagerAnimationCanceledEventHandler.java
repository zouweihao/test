//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


abstract class GridAnimationManagerAnimationCanceledEventHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridAnimationManagerAnimationCanceledEventHandler() {
		super();
	}
	public GridAnimationManagerAnimationCanceledEventHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object sender, GridAnimationManagerAnimationCanceledEventArgs args);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridAnimationManagerAnimationCanceledEventHandler p1 = (GridAnimationManagerAnimationCanceledEventHandler)del1;
		GridAnimationManagerAnimationCanceledEventHandler p2 = (GridAnimationManagerAnimationCanceledEventHandler)del2;
		GridAnimationManagerAnimationCanceledEventHandler ret = new GridAnimationManagerAnimationCanceledEventHandler() {
		public void invoke(Object sender, GridAnimationManagerAnimationCanceledEventArgs args) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridAnimationManagerAnimationCanceledEventHandler han = (GridAnimationManagerAnimationCanceledEventHandler)getDelegateList().get(i);
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
	GridAnimationManagerAnimationCanceledEventHandler p1 = (GridAnimationManagerAnimationCanceledEventHandler)del1;
	GridAnimationManagerAnimationCanceledEventHandler p2 = (GridAnimationManagerAnimationCanceledEventHandler)del2;
	GridAnimationManagerAnimationCanceledEventHandler ret = new GridAnimationManagerAnimationCanceledEventHandler() {
	public void invoke(Object sender, GridAnimationManagerAnimationCanceledEventArgs args) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridAnimationManagerAnimationCanceledEventHandler han = (GridAnimationManagerAnimationCanceledEventHandler)getDelegateList().get(i);
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
