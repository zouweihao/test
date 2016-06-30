//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;






abstract class DefinitionPropertyUpdatedEventHandler
	extends com.infragistics.controls.FunctionDelegate {
	public DefinitionPropertyUpdatedEventHandler() {
		super();
	}
	public DefinitionPropertyUpdatedEventHandler(Object target, String targetMethod) {
		super(target, targetMethod);
	}
	public abstract void invoke(Object sender, DefinitionPropertyUpdatedEventArgs args);
	public FunctionDelegate combineCore(FunctionDelegate del1, FunctionDelegate del2) {
		return staticCombineCore(del1, del2);
	}
	private static FunctionDelegate staticCombineCore(FunctionDelegate del1, FunctionDelegate del2) {
		DefinitionPropertyUpdatedEventHandler p1 = (DefinitionPropertyUpdatedEventHandler)del1;
		DefinitionPropertyUpdatedEventHandler p2 = (DefinitionPropertyUpdatedEventHandler)del2;
		DefinitionPropertyUpdatedEventHandler ret = new DefinitionPropertyUpdatedEventHandler() {
		public void invoke(Object sender, DefinitionPropertyUpdatedEventArgs args) {
			for (int i = 0; i < getDelegateList().size(); i++) {
				DefinitionPropertyUpdatedEventHandler han = (DefinitionPropertyUpdatedEventHandler)getDelegateList().get(i);
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
	DefinitionPropertyUpdatedEventHandler p1 = (DefinitionPropertyUpdatedEventHandler)del1;
	DefinitionPropertyUpdatedEventHandler p2 = (DefinitionPropertyUpdatedEventHandler)del2;
	DefinitionPropertyUpdatedEventHandler ret = new DefinitionPropertyUpdatedEventHandler() {
	public void invoke(Object sender, DefinitionPropertyUpdatedEventArgs args) {
		for (int i = 0; i < getDelegateList().size(); i++) {
			DefinitionPropertyUpdatedEventHandler han = (DefinitionPropertyUpdatedEventHandler)getDelegateList().get(i);
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
