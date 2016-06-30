//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectCurrentValueHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectCurrentValueHandler() {
		super();
	}
	public GridEffectCurrentValueHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract Object invoke(Object target, VisualModel model);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectCurrentValueHandler p1 = (GridEffectCurrentValueHandler)del1;
		GridEffectCurrentValueHandler p2 = (GridEffectCurrentValueHandler)del2;
		GridEffectCurrentValueHandler ret = new GridEffectCurrentValueHandler() {
		public Object invoke(Object target, VisualModel model) {
			Object last = null;
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectCurrentValueHandler han = (GridEffectCurrentValueHandler)getDelegateList().get(i);
				last = han.invoke(target, model);
			}
			return last;
		}
	};
	combineLists(ret, p1, p2);
	return ret;
}
public FunctionDelegate removeCore(FunctionDelegate del1, FunctionDelegate del2) {
	return staticRemoveCore(del1, del2);
}
private static FunctionDelegate staticRemoveCore(FunctionDelegate del1, FunctionDelegate del2) {
	GridEffectCurrentValueHandler p1 = (GridEffectCurrentValueHandler)del1;
	GridEffectCurrentValueHandler p2 = (GridEffectCurrentValueHandler)del2;
	GridEffectCurrentValueHandler ret = new GridEffectCurrentValueHandler() {
	public Object invoke(Object target, VisualModel model) {
		Object last = null;
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectCurrentValueHandler han = (GridEffectCurrentValueHandler)getDelegateList().get(i);
			last = han.invoke(target, model);
		}
		return last;
	}
};
removeLists(ret, p1, p2);
if (p1.getDelegateList().size() < 1) {
return null;
}
return ret;
}
}
