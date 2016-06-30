//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectTickHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectTickHandler() {
		super();
	}
	public GridEffectTickHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(double progress, Object fromValue, Object toValue, Object target, VisualModel model);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectTickHandler p1 = (GridEffectTickHandler)del1;
		GridEffectTickHandler p2 = (GridEffectTickHandler)del2;
		GridEffectTickHandler ret = new GridEffectTickHandler() {
		public void invoke(double progress, Object fromValue, Object toValue, Object target, VisualModel model) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectTickHandler han = (GridEffectTickHandler)getDelegateList().get(i);
				han.invoke(progress, fromValue, toValue, target, model);
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
	GridEffectTickHandler p1 = (GridEffectTickHandler)del1;
	GridEffectTickHandler p2 = (GridEffectTickHandler)del2;
	GridEffectTickHandler ret = new GridEffectTickHandler() {
	public void invoke(double progress, Object fromValue, Object toValue, Object target, VisualModel model) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectTickHandler han = (GridEffectTickHandler)getDelegateList().get(i);
			han.invoke(progress, fromValue, toValue, target, model);
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
