//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectAnimationOnFinishedHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectAnimationOnFinishedHandler() {
		super();
	}
	public GridEffectAnimationOnFinishedHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object target);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectAnimationOnFinishedHandler p1 = (GridEffectAnimationOnFinishedHandler)del1;
		GridEffectAnimationOnFinishedHandler p2 = (GridEffectAnimationOnFinishedHandler)del2;
		GridEffectAnimationOnFinishedHandler ret = new GridEffectAnimationOnFinishedHandler() {
		public void invoke(Object target) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectAnimationOnFinishedHandler han = (GridEffectAnimationOnFinishedHandler)getDelegateList().get(i);
				han.invoke(target);
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
	GridEffectAnimationOnFinishedHandler p1 = (GridEffectAnimationOnFinishedHandler)del1;
	GridEffectAnimationOnFinishedHandler p2 = (GridEffectAnimationOnFinishedHandler)del2;
	GridEffectAnimationOnFinishedHandler ret = new GridEffectAnimationOnFinishedHandler() {
	public void invoke(Object target) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectAnimationOnFinishedHandler han = (GridEffectAnimationOnFinishedHandler)getDelegateList().get(i);
			han.invoke(target);
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
