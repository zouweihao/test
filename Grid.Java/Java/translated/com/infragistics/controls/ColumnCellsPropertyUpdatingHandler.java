//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;





abstract class ColumnCellsPropertyUpdatingHandler
	extends com.infragistics.controls.FunctionDelegate {
	public ColumnCellsPropertyUpdatingHandler() {
		super();
	}
	public ColumnCellsPropertyUpdatingHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		ColumnCellsPropertyUpdatingHandler p1 = (ColumnCellsPropertyUpdatingHandler)del1;
		ColumnCellsPropertyUpdatingHandler p2 = (ColumnCellsPropertyUpdatingHandler)del2;
		ColumnCellsPropertyUpdatingHandler ret = new ColumnCellsPropertyUpdatingHandler() {
		public void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				ColumnCellsPropertyUpdatingHandler han = (ColumnCellsPropertyUpdatingHandler)getDelegateList().get(i);
				han.invoke(column, propertyName, propertyAnimationType, oldValue, newValue);
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
	ColumnCellsPropertyUpdatingHandler p1 = (ColumnCellsPropertyUpdatingHandler)del1;
	ColumnCellsPropertyUpdatingHandler p2 = (ColumnCellsPropertyUpdatingHandler)del2;
	ColumnCellsPropertyUpdatingHandler ret = new ColumnCellsPropertyUpdatingHandler() {
	public void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			ColumnCellsPropertyUpdatingHandler han = (ColumnCellsPropertyUpdatingHandler)getDelegateList().get(i);
			han.invoke(column, propertyName, propertyAnimationType, oldValue, newValue);
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
