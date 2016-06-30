//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectAnimationOnCanceledHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectAnimationOnCanceledHandler() {
		super();
	}
	public GridEffectAnimationOnCanceledHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object target, GridEffect canceledBy);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectAnimationOnCanceledHandler p1 = (GridEffectAnimationOnCanceledHandler)del1;
		GridEffectAnimationOnCanceledHandler p2 = (GridEffectAnimationOnCanceledHandler)del2;
		GridEffectAnimationOnCanceledHandler ret = new GridEffectAnimationOnCanceledHandler() {
		public void invoke(Object target, GridEffect canceledBy) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectAnimationOnCanceledHandler han = (GridEffectAnimationOnCanceledHandler)getDelegateList().get(i);
				han.invoke(target, canceledBy);
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
	GridEffectAnimationOnCanceledHandler p1 = (GridEffectAnimationOnCanceledHandler)del1;
	GridEffectAnimationOnCanceledHandler p2 = (GridEffectAnimationOnCanceledHandler)del2;
	GridEffectAnimationOnCanceledHandler ret = new GridEffectAnimationOnCanceledHandler() {
	public void invoke(Object target, GridEffect canceledBy) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectAnimationOnCanceledHandler han = (GridEffectAnimationOnCanceledHandler)getDelegateList().get(i);
			han.invoke(target, canceledBy);
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
