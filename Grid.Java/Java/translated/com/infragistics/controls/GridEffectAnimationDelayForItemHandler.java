//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectAnimationDelayForItemHandler
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectAnimationDelayForItemHandler() {
		super();
	}
	public GridEffectAnimationDelayForItemHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract int invoke(CellPath startItem, int numberOfItems, CellPath item);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectAnimationDelayForItemHandler p1 = (GridEffectAnimationDelayForItemHandler)del1;
		GridEffectAnimationDelayForItemHandler p2 = (GridEffectAnimationDelayForItemHandler)del2;
		GridEffectAnimationDelayForItemHandler ret = new GridEffectAnimationDelayForItemHandler() {
		public int invoke(CellPath startItem, int numberOfItems, CellPath item) {
			int last = 0;
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectAnimationDelayForItemHandler han = (GridEffectAnimationDelayForItemHandler)getDelegateList().get(i);
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
	GridEffectAnimationDelayForItemHandler p1 = (GridEffectAnimationDelayForItemHandler)del1;
	GridEffectAnimationDelayForItemHandler p2 = (GridEffectAnimationDelayForItemHandler)del2;
	GridEffectAnimationDelayForItemHandler ret = new GridEffectAnimationDelayForItemHandler() {
	public int invoke(CellPath startItem, int numberOfItems, CellPath item) {
		int last = 0;
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectAnimationDelayForItemHandler han = (GridEffectAnimationDelayForItemHandler)getDelegateList().get(i);
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
