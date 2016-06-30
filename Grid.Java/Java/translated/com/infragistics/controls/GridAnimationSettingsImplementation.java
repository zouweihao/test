//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class GridAnimationSettingsImplementation
implements INotifyPropertyChanged {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}

public GridAnimationSettingsImplementation() {



		_cellActualizationMainPhase = new GridAnimationPhaseSettingsImplementation();
		_cellActualizationMainPhase.setDurationMilliseconds(500);
		_cellActualizationMainPhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_cellActualizationMainPhase.setShouldItemsFinishSimultaneously(false);
		_rowSelectionMainPhase = new GridAnimationPhaseSettingsImplementation();
		_rowSelectionMainPhase.setDurationMilliseconds(500);
		_rowSelectionMainPhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_rowSelectionMainPhase.setPerItemDelayMilliseconds(0);
		_rowSelectionMainPhase.setShouldItemsFinishSimultaneously(true);
}

private GridAnimationPhaseSettingsImplementation _cellActualizationMainPhase;

public static final String CellActualizationMainPhasePropertyName = "CellActualizationMainPhase";


public GridAnimationPhaseSettingsImplementation setCellActualizationMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _cellActualizationMainPhase;
	_cellActualizationMainPhase = value;
	onPropertyChanged(CellActualizationMainPhasePropertyName, oldValue, _cellActualizationMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getCellActualizationMainPhase() {

		return _cellActualizationMainPhase;

}

private GridAnimationPhaseSettingsImplementation _rowSelectionMainPhase;

public static final String RowSelectionMainPhasePropertyName = "RowSelectionMainPhase";


public GridAnimationPhaseSettingsImplementation setRowSelectionMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _rowSelectionMainPhase;
	_rowSelectionMainPhase = value;
	onPropertyChanged(RowSelectionMainPhasePropertyName, oldValue, _rowSelectionMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getRowSelectionMainPhase() {

		return _rowSelectionMainPhase;

}


protected void onPropertyChanged(String propertyName, Object oldValue, Object newValue) {
	if (getPropertyChanged() != null) {
		getPropertyChanged().invoke(this, new PropertyChangedEventArgs(propertyName));
	}

	propertyUpdatedOverride(propertyName, oldValue, newValue);
}

private static java.util.HashMap<String, Integer> __switch_GridAnimationSettings_PropertyUpdatedOverride0 = null;
protected void propertyUpdatedOverride(String propertyName, Object oldValue, Object newValue) {
	if (__switch_GridAnimationSettings_PropertyUpdatedOverride0 == null) {
		__switch_GridAnimationSettings_PropertyUpdatedOverride0 = new java.util.HashMap<String, Integer>();
		__switch_GridAnimationSettings_PropertyUpdatedOverride0.put(CellActualizationMainPhasePropertyName, 0);
		__switch_GridAnimationSettings_PropertyUpdatedOverride0.put(RowSelectionMainPhasePropertyName, 1);
	}
	String __switch_GridAnimationSettings_PropertyUpdatedOverride0__key = propertyName;
	int __switch_GridAnimationSettings_PropertyUpdatedOverride0__index = __switch_GridAnimationSettings_PropertyUpdatedOverride0.containsKey(__switch_GridAnimationSettings_PropertyUpdatedOverride0__key) ? __switch_GridAnimationSettings_PropertyUpdatedOverride0.get(__switch_GridAnimationSettings_PropertyUpdatedOverride0__key) : -1;
	switch (__switch_GridAnimationSettings_PropertyUpdatedOverride0__index) {
		case 0:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridAnimationSettings.CellActualizationMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { cellActualizationMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridAnimationSettings.CellActualizationMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { cellActualizationMainPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 1:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridAnimationSettings.RowSelectionMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { rowSelectionMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridAnimationSettings.RowSelectionMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { rowSelectionMainPhasePropertyChanged(sender, e); } }));
			}

			break;
	}
}


private void cellActualizationMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(CellActualizationMainPhasePropertyName, getCellActualizationMainPhase(), getCellActualizationMainPhase());
}


private void rowSelectionMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(RowSelectionMainPhasePropertyName, getRowSelectionMainPhase(), getRowSelectionMainPhase());
}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}

}
