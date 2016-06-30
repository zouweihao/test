//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class GridAnimationPhaseSettingsImplementation
implements INotifyPropertyChanged {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}

public static final String DurationMillisecondsPropertyName = "DurationMilliseconds";

private int _durationMilliseconds = 300;


public int setDurationMilliseconds(int value) {

	int oldValue = _durationMilliseconds;
	_durationMilliseconds = value;
	if (oldValue != _durationMilliseconds) {
		onPropertyChanged(DurationMillisecondsPropertyName, oldValue, _durationMilliseconds);
	}

return value;
}
public int getDurationMilliseconds() {

		return _durationMilliseconds;

}

public static final String HoldInitialMillisecondsPropertyName = "HoldInitialMilliseconds";

private int _holdInitialMilliseconds = 0;


public int setHoldInitialMilliseconds(int value) {

	int oldValue = _holdInitialMilliseconds;
	_holdInitialMilliseconds = value;
	if (oldValue != _holdInitialMilliseconds) {
		onPropertyChanged(HoldInitialMillisecondsPropertyName, oldValue, _holdInitialMilliseconds);
	}

return value;
}
public int getHoldInitialMilliseconds() {

		return _holdInitialMilliseconds;

}

public static final String PerItemDelayMillisecondsPropertyName = "PerItemDelayMilliseconds";

private int _perItemDelayMilliseconds = -1;


public int setPerItemDelayMilliseconds(int value) {

	int oldValue = _perItemDelayMilliseconds;
	_perItemDelayMilliseconds = value;
	if (oldValue != _perItemDelayMilliseconds) {
		onPropertyChanged(PerItemDelayMillisecondsPropertyName, oldValue, _perItemDelayMilliseconds);
	}

return value;
}
public int getPerItemDelayMilliseconds() {

		return _perItemDelayMilliseconds;

}

public static final String SubItemDurationMillisecondsPropertyName = "SubItemDurationMilliseconds";

private int _subItemDurationMilliseconds = -1;


public int setSubItemDurationMilliseconds(int value) {

	int oldValue = _subItemDurationMilliseconds;
	_subItemDurationMilliseconds = value;
	if (oldValue != _subItemDurationMilliseconds) {
		onPropertyChanged(SubItemDurationMillisecondsPropertyName, oldValue, _subItemDurationMilliseconds);
	}

return value;
}
public int getSubItemDurationMilliseconds() {

		return _subItemDurationMilliseconds;

}

public static final String DesiredSubItemDurationMillisecondsPropertyName = "DesiredSubItemDurationMilliseconds";

private int _desiredSubItemDurationMilliseconds = 300;


public int setDesiredSubItemDurationMilliseconds(int value) {

	int oldValue = _desiredSubItemDurationMilliseconds;
	_desiredSubItemDurationMilliseconds = value;
	if (oldValue != _desiredSubItemDurationMilliseconds) {
		onPropertyChanged(DesiredSubItemDurationMillisecondsPropertyName, oldValue, _desiredSubItemDurationMilliseconds);
	}

return value;
}
public int getDesiredSubItemDurationMilliseconds() {

		return _desiredSubItemDurationMilliseconds;

}

public static final String ShouldItemsFinishSimultaneouslyPropertyName = "ShouldItemsFinishSimultaneously";

private boolean _shouldItemsFinishSimultaneously = false;


public boolean setShouldItemsFinishSimultaneously(boolean value) {

	boolean oldValue = _shouldItemsFinishSimultaneously;
	_shouldItemsFinishSimultaneously = value;
	if (oldValue != _shouldItemsFinishSimultaneously) {
		onPropertyChanged(ShouldItemsFinishSimultaneouslyPropertyName, oldValue, _shouldItemsFinishSimultaneously);
	}

return value;
}
public boolean getShouldItemsFinishSimultaneously() {

		return _shouldItemsFinishSimultaneously;

}

public static final String EasingFunctionTypePropertyName = "EasingFunctionType";

private GridEasingFunctionType _easingFunctionType = GridEasingFunctionType.CUBIC_IN_OUT;


public GridEasingFunctionType setEasingFunctionType(GridEasingFunctionType value) {

	GridEasingFunctionType oldValue = _easingFunctionType;
	_easingFunctionType = value;
	if (oldValue != _easingFunctionType) {
		onPropertyChanged(EasingFunctionTypePropertyName, oldValue, _easingFunctionType);
	}

return value;
}
public GridEasingFunctionType getEasingFunctionType() {

		return _easingFunctionType;

}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}


protected void onPropertyChanged(String propertyName, Object oldValue, Object newValue) {
	if (getPropertyChanged() != null) {
		getPropertyChanged().invoke(this, new PropertyChangedEventArgs(propertyName));
	}

}


public GridAnimationPhaseSettingsImplementation clone() {
	return (new Object() { 
		public GridAnimationPhaseSettingsImplementation invoke() {
			GridAnimationPhaseSettingsImplementation __ret = new GridAnimationPhaseSettingsImplementation();
			__ret.setDurationMilliseconds(GridAnimationPhaseSettingsImplementation.this.getDurationMilliseconds());
			__ret.setEasingFunctionType(GridAnimationPhaseSettingsImplementation.this.getEasingFunctionType());
			__ret.setHoldInitialMilliseconds(GridAnimationPhaseSettingsImplementation.this.getHoldInitialMilliseconds());
			__ret.setPerItemDelayMilliseconds(GridAnimationPhaseSettingsImplementation.this.getPerItemDelayMilliseconds());
			__ret.setShouldItemsFinishSimultaneously(GridAnimationPhaseSettingsImplementation.this.getShouldItemsFinishSimultaneously());
			__ret.setSubItemDurationMilliseconds(GridAnimationPhaseSettingsImplementation.this.getSubItemDurationMilliseconds());
			__ret.setDesiredSubItemDurationMilliseconds(GridAnimationPhaseSettingsImplementation.this.getDesiredSubItemDurationMilliseconds());
			return __ret;
		}
	}).invoke();
}

}
