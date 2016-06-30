//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffectEasingFunction
	extends com.infragistics.controls.FunctionDelegate {
	public GridEffectEasingFunction() {
		super();
	}
	public GridEffectEasingFunction(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract double invoke(double progress);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		GridEffectEasingFunction p1 = (GridEffectEasingFunction)del1;
		GridEffectEasingFunction p2 = (GridEffectEasingFunction)del2;
		GridEffectEasingFunction ret = new GridEffectEasingFunction() {
		public double invoke(double progress) {
			double last = 0;
			for (int i = 0; i < getDelegateList().size(); i++) {
				GridEffectEasingFunction han = (GridEffectEasingFunction)getDelegateList().get(i);
				last = han.invoke(progress);
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
	GridEffectEasingFunction p1 = (GridEffectEasingFunction)del1;
	GridEffectEasingFunction p2 = (GridEffectEasingFunction)del2;
	GridEffectEasingFunction ret = new GridEffectEasingFunction() {
	public double invoke(double progress) {
		double last = 0;
		for (int i = 0; i < getDelegateList().size(); i++) {
			GridEffectEasingFunction han = (GridEffectEasingFunction)getDelegateList().get(i);
			last = han.invoke(progress);
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
