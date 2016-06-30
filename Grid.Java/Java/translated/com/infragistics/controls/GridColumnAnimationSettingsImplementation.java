//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class GridColumnAnimationSettingsImplementation
implements INotifyPropertyChanged {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}

public GridColumnAnimationSettingsImplementation() {



		_columnAddingMainPhase = new GridAnimationPhaseSettingsImplementation();
		_columnAddingMainPhase.setDurationMilliseconds(1000);
		_columnAddingMainPhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_columnAddingMainPhase.setHoldInitialMilliseconds(500);
		_columnAddingMainPhase.setShouldItemsFinishSimultaneously(false);
		_columnShowingMainPhase = _columnAddingMainPhase.clone();
		_columnPropertyUpdatingMainPhase = new GridAnimationPhaseSettingsImplementation();
		_columnPropertyUpdatingMainPhase.setDurationMilliseconds(1000);
		_columnPropertyUpdatingMainPhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_columnPropertyUpdatingMainPhase.setShouldItemsFinishSimultaneously(false);
		_columnAddingPrePhase = new GridAnimationPhaseSettingsImplementation();
		_columnAddingPrePhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_columnAddingPrePhase.setDurationMilliseconds(300);
		_columnShowingPrePhase = _columnAddingPrePhase.clone();
		_columnHidingMainPhase = _columnAddingMainPhase.clone();
		_columnHidingMainPhase.setHoldInitialMilliseconds(0);
		_columnHidingPostPhase = new GridAnimationPhaseSettingsImplementation();
		_columnHidingPostPhase.setHoldInitialMilliseconds(1200);
		_columnHidingPostPhase.setDurationMilliseconds(300);
		_columnHidingPostPhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_columnMovingMainPhase = new GridAnimationPhaseSettingsImplementation();
		_columnMovingMainPhase.setDurationMilliseconds(1000);
		_columnMovingMainPhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_columnMovingMainPhase.setHoldInitialMilliseconds(500);
		_columnMovingMainPhase.setShouldItemsFinishSimultaneously(false);
		_columnMovingPrePhase = new GridAnimationPhaseSettingsImplementation();
		_columnMovingPrePhase.setEasingFunctionType(GridEasingFunctionType.CUBIC_IN_OUT);
		_columnMovingPrePhase.setDurationMilliseconds(800);
		_columnExchangingMainPhase = _columnAddingMainPhase.clone();
		_columnExchangingMainPhase.setHoldInitialMilliseconds(0);
		_columnExchangingCleanupPhase = new GridAnimationPhaseSettingsImplementation();
		_columnExchangingCleanupPhase.setHoldInitialMilliseconds(0);
		_columnExchangingCleanupPhase.setDurationMilliseconds(300);
		_columnExchangingCleanupPhase.setEasingFunctionType(GridEasingFunctionType.LINEAR);
}

private GridAnimationPhaseSettingsImplementation _columnPropertyUpdatingMainPhase;

public static final String ColumnPropertyUpdatingMainPhasePropertyName = "ColumnPropertyUpdatingMainPhase";


public GridAnimationPhaseSettingsImplementation setColumnPropertyUpdatingMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnPropertyUpdatingMainPhase;
	_columnPropertyUpdatingMainPhase = value;
	onPropertyChanged(ColumnPropertyUpdatingMainPhasePropertyName, oldValue, _columnPropertyUpdatingMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnPropertyUpdatingMainPhase() {

		return _columnPropertyUpdatingMainPhase;

}

private GridAnimationPhaseSettingsImplementation _columnAddingMainPhase;

public static final String ColumnAddingMainPhasePropertyName = "ColumnAddingMainPhase";


public GridAnimationPhaseSettingsImplementation setColumnAddingMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnAddingMainPhase;
	_columnAddingMainPhase = value;
	onPropertyChanged(ColumnAddingMainPhasePropertyName, oldValue, _columnAddingMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnAddingMainPhase() {

		return _columnAddingMainPhase;

}

private GridAnimationPhaseSettingsImplementation _columnAddingPrePhase;

public static final String ColumnAddingPrePhasePropertyName = "ColumnAddingPrePhase";


public GridAnimationPhaseSettingsImplementation setColumnAddingPrePhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnAddingPrePhase;
	_columnAddingPrePhase = value;
	onPropertyChanged(ColumnAddingPrePhasePropertyName, oldValue, _columnAddingPrePhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnAddingPrePhase() {

		return _columnAddingPrePhase;

}

private GridAnimationPhaseSettingsImplementation _columnShowingMainPhase;

public static final String ColumnShowingMainPhasePropertyName = "ColumnShowingMainPhase";


public GridAnimationPhaseSettingsImplementation setColumnShowingMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnShowingMainPhase;
	_columnShowingMainPhase = value;
	onPropertyChanged(ColumnShowingMainPhasePropertyName, oldValue, _columnShowingMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnShowingMainPhase() {

		return _columnShowingMainPhase;

}

private GridAnimationPhaseSettingsImplementation _columnShowingPrePhase;

public static final String ColumnShowingPrePhasePropertyName = "ColumnShowingPrePhase";


public GridAnimationPhaseSettingsImplementation setColumnShowingPrePhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnShowingPrePhase;
	_columnShowingPrePhase = value;
	onPropertyChanged(ColumnShowingPrePhasePropertyName, oldValue, _columnShowingPrePhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnShowingPrePhase() {

		return _columnShowingPrePhase;

}

private GridAnimationPhaseSettingsImplementation _columnMovingMainPhase;

public static final String ColumnMovingMainPhasePropertyName = "ColumnMovingMainPhase";


public GridAnimationPhaseSettingsImplementation setColumnMovingMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnMovingMainPhase;
	_columnMovingMainPhase = value;
	onPropertyChanged(ColumnMovingMainPhasePropertyName, oldValue, _columnMovingMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnMovingMainPhase() {

		return _columnMovingMainPhase;

}

private GridAnimationPhaseSettingsImplementation _columnMovingPrePhase;

public static final String ColumnMovingPrePhasePropertyName = "ColumnMovingPrePhase";


public GridAnimationPhaseSettingsImplementation setColumnMovingPrePhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnMovingPrePhase;
	_columnMovingPrePhase = value;
	onPropertyChanged(ColumnMovingPrePhasePropertyName, oldValue, _columnMovingPrePhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnMovingPrePhase() {

		return _columnMovingPrePhase;

}

private GridAnimationPhaseSettingsImplementation _columnHidingMainPhase;

public static final String ColumnHidingMainPhasePropertyName = "ColumnHidingMainPhase";


public GridAnimationPhaseSettingsImplementation setColumnHidingMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnHidingMainPhase;
	_columnHidingMainPhase = value;
	onPropertyChanged(ColumnHidingMainPhasePropertyName, oldValue, _columnHidingMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnHidingMainPhase() {

		return _columnHidingMainPhase;

}

private GridAnimationPhaseSettingsImplementation _columnHidingPostPhase;

public static final String ColumnHidingPostPhasePropertyName = "ColumnHidingPostPhase";


public GridAnimationPhaseSettingsImplementation setColumnHidingPostPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnHidingPostPhase;
	_columnHidingPostPhase = value;
	onPropertyChanged(ColumnHidingPostPhasePropertyName, oldValue, _columnHidingPostPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnHidingPostPhase() {

		return _columnHidingPostPhase;

}

private GridAnimationPhaseSettingsImplementation _columnExchangingMainPhase;

public static final String ColumnExchangingMainPhasePropertyName = "ColumnExchangingMainPhase";


public GridAnimationPhaseSettingsImplementation setColumnExchangingMainPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnExchangingMainPhase;
	_columnExchangingMainPhase = value;
	onPropertyChanged(ColumnExchangingMainPhasePropertyName, oldValue, _columnExchangingMainPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnExchangingMainPhase() {

		return _columnExchangingMainPhase;

}

private GridAnimationPhaseSettingsImplementation _columnExchangingCleanupPhase;

public static final String ColumnExchangingCleanupPhasePropertyName = "ColumnExchangingCleanupPhase";


public GridAnimationPhaseSettingsImplementation setColumnExchangingCleanupPhase(GridAnimationPhaseSettingsImplementation value) {

	GridAnimationPhaseSettingsImplementation oldValue = _columnExchangingCleanupPhase;
	_columnExchangingCleanupPhase = value;
	onPropertyChanged(ColumnExchangingCleanupPhasePropertyName, oldValue, _columnExchangingCleanupPhase);
return value;
}
public GridAnimationPhaseSettingsImplementation getColumnExchangingCleanupPhase() {

		return _columnExchangingCleanupPhase;

}


protected void onPropertyChanged(String propertyName, Object oldValue, Object newValue) {
	if (getPropertyChanged() != null) {
		getPropertyChanged().invoke(this, new PropertyChangedEventArgs(propertyName));
	}

	propertyUpdatedOverride(propertyName, oldValue, newValue);
}

private static java.util.HashMap<String, Integer> __switch_GridColumnAnimationSettings_PropertyUpdatedOverride0 = null;
protected void propertyUpdatedOverride(String propertyName, Object oldValue, Object newValue) {
	if (__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0 == null) {
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0 = new java.util.HashMap<String, Integer>();
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnAddingMainPhasePropertyName, 0);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnAddingPrePhasePropertyName, 1);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnShowingMainPhasePropertyName, 2);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnShowingPrePhasePropertyName, 3);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnMovingMainPhasePropertyName, 4);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnMovingPrePhasePropertyName, 5);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnHidingMainPhasePropertyName, 6);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnHidingPostPhasePropertyName, 7);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnExchangingMainPhasePropertyName, 8);
		__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.put(ColumnExchangingCleanupPhasePropertyName, 9);
	}
	String __switch_GridColumnAnimationSettings_PropertyUpdatedOverride0__key = propertyName;
	int __switch_GridColumnAnimationSettings_PropertyUpdatedOverride0__index = __switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.containsKey(__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0__key) ? __switch_GridColumnAnimationSettings_PropertyUpdatedOverride0.get(__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0__key) : -1;
	switch (__switch_GridColumnAnimationSettings_PropertyUpdatedOverride0__index) {
		case 0:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnAddingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnAddingMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnAddingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnAddingMainPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 1:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnAddingPrePhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnAddingPrePhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnAddingPrePhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnAddingPrePhasePropertyChanged(sender, e); } }));
			}

			break;
		case 2:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnShowingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnShowingMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnShowingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnShowingMainPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 3:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnShowingPrePhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnShowingPrePhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnShowingPrePhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnShowingPrePhasePropertyChanged(sender, e); } }));
			}

			break;
		case 4:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnMovingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnMovingMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnMovingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnMovingMainPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 5:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnMovingPrePhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnMovingPrePhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnMovingPrePhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnMovingPrePhasePropertyChanged(sender, e); } }));
			}

			break;
		case 6:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnHidingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnHidingMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnHidingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnHidingMainPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 7:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnHidingPostPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnHidingPostPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnHidingPostPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnHidingPostPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 8:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnExchangingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnExchangingMainPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnExchangingMainPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnExchangingMainPhasePropertyChanged(sender, e); } }));
			}

			break;
		case 9:
			if (oldValue != null) {
				((INotifyPropertyChanged)oldValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(((INotifyPropertyChanged)oldValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnExchangingCleanupPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnExchangingCleanupPhasePropertyChanged(sender, e); } }));
			}

			if (newValue != null) {
				((INotifyPropertyChanged)newValue).setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(((INotifyPropertyChanged)newValue).getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.GridColumnAnimationSettings.ColumnExchangingCleanupPhasePropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { columnExchangingCleanupPhasePropertyChanged(sender, e); } }));
			}

			break;
	}
}


private void columnAddingMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnAddingMainPhasePropertyName, getColumnAddingMainPhase(), getColumnAddingMainPhase());
}


private void columnAddingPrePhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnAddingPrePhasePropertyName, getColumnAddingPrePhase(), getColumnAddingPrePhase());
}


private void columnShowingMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnShowingMainPhasePropertyName, getColumnShowingMainPhase(), getColumnShowingMainPhase());
}


private void columnShowingPrePhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnShowingPrePhasePropertyName, getColumnShowingPrePhase(), getColumnShowingPrePhase());
}


private void columnMovingMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnMovingMainPhasePropertyName, getColumnMovingMainPhase(), getColumnMovingMainPhase());
}


private void columnMovingPrePhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnMovingPrePhasePropertyName, getColumnMovingPrePhase(), getColumnMovingPrePhase());
}


private void columnHidingMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnHidingMainPhasePropertyName, getColumnHidingMainPhase(), getColumnHidingMainPhase());
}


private void columnHidingPostPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnHidingPostPhasePropertyName, getColumnHidingPostPhase(), getColumnHidingPostPhase());
}


private void columnExchangingMainPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnExchangingMainPhasePropertyName, getColumnExchangingMainPhase(), getColumnExchangingMainPhase());
}


private void columnExchangingCleanupPhasePropertyChanged(Object sender, PropertyChangedEventArgs e) {
	onPropertyChanged(ColumnExchangingCleanupPhasePropertyName, getColumnExchangingCleanupPhase(), getColumnExchangingCleanupPhase());
}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}

}
