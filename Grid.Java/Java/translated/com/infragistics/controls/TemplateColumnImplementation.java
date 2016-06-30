//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class TemplateColumnImplementation
extends ColumnImplementation {
public static final String ExternalTemplateProxyPropertyName = "ExternalTemplateProxy";

private IExternalTemplateColumn _externalTemplateProxy = null;


public IExternalTemplateColumn setExternalTemplateProxy(IExternalTemplateColumn value) {

	IExternalTemplateColumn oldValue = _externalTemplateProxy;
	_externalTemplateProxy = value;
	if (_externalTemplateProxy != oldValue) {
		onPropertyChanged(ExternalObjectPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _externalTemplateProxy);
	}

return value;
}
public IExternalTemplateColumn getExternalTemplateProxy() {

		return _externalTemplateProxy;

}


protected CellModel createModelOverride(CellPath path) {
	return new TemplateCellModel();
}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	String defaultKey = com.infragistics.controls.StringHelper.add("template-", this.getUniqueId());
	return _externalTemplateProxy != null ? _externalTemplateProxy.resolveStyleKey(defaultKey, path, grid, resolvedValue) : defaultKey;
}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onDataBind(cellModel, grid, resolvedValue);
	TemplateCellModel templateModel = (TemplateCellModel)cellModel;
	templateModel.setValue(resolvedValue);
}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
}


public void prepareCreateOrUpdateCall(TemplateCellModel model, Object cell) {
	_externalTemplateProxy.raiseCreateOrUpdate(model, cell);
}

}
