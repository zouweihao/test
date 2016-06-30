//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectAnimationDurationForItemHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectAnimationDurationForItemHandler() {
		super();
	}
	public GridEffectAnimationDurationForItemHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract int invoke(CellPath startItem, int numberOfItems, CellPath item);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectAnimationDurationForItemHandler p1 = (GridEffectAnimationDurationForItemHandler)del1;
		GridEffectAnimationDurationForItemHandler p2 = (GridEffectAnimationDurationForItemHandler)del2;
		GridEffectAnimationDurationForItemHandler ret = new GridEffectAnimationDurationForItemHandler() {
		public int invoke(CellPath startItem, int numberOfItems, CellPath item) {
			int last = 0;
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectAnimationDurationForItemHandler han = (GridEffectAnimationDurationForItemHandler)getDelegateList().get(i);
				last = han.invoke(startItem, numberOfItems, item);
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
	GridEffectAnimationDurationForItemHandler p1 = (GridEffectAnimationDurationForItemHandler)del1;
	GridEffectAnimationDurationForItemHandler p2 = (GridEffectAnimationDurationForItemHandler)del2;
	GridEffectAnimationDurationForItemHandler ret = new GridEffectAnimationDurationForItemHandler() {
	public int invoke(CellPath startItem, int numberOfItems, CellPath item) {
		int last = 0;
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectAnimationDurationForItemHandler han = (GridEffectAnimationDurationForItemHandler)getDelegateList().get(i);
			last = han.invoke(startItem, numberOfItems, item);
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
