//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class ResponsiveStateImplementation {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}


private String _name;
public String setName(String value) {
_name = value;
return value;
}
public String getName() {
	return _name;
}


private double _minimumWidth;
public double setMinimumWidth(double value) {
_minimumWidth = value;
return value;
}
public double getMinimumWidth() {
	return _minimumWidth;
}


private double _maximumWidth;
public double setMaximumWidth(double value) {
_maximumWidth = value;
return value;
}
public double getMaximumWidth() {
	return _maximumWidth;
}

public ResponsiveStateEnteringEventHandler stateEntering = null;
public void setStateEntering(ResponsiveStateEnteringEventHandler __event) {
	stateEntering = __event;
}
public ResponsiveStateEnteringEventHandler getStateEntering() {
	return stateEntering;
}

public ResponsiveStateEnteredEventHandler stateEntered = null;
public void setStateEntered(ResponsiveStateEnteredEventHandler __event) {
	stateEntered = __event;
}
public ResponsiveStateEnteredEventHandler getStateEntered() {
	return stateEntered;
}

public ResponsiveStateExitedEventHandler stateExited = null;
public void setStateExited(ResponsiveStateExitedEventHandler __event) {
	stateExited = __event;
}
public ResponsiveStateExitedEventHandler getStateExited() {
	return stateExited;
}

private boolean _isManualState = false;


public boolean setIsManualState(boolean value) {

	_isManualState = value;
return value;
}
public boolean getIsManualState() {

		return _isManualState;

}


private int _activePhase;
public int setActivePhase(int value) {
_activePhase = value;
return value;
}
public int getActivePhase() {
	return _activePhase;
}

private ResponsivePhasesCollection _responsivePhases = new ResponsivePhasesCollection();


public ResponsivePhasesCollection getResponsivePhases() {

		return _responsivePhases;

}


public void onStateEntering() {
	if (getStateEntering() != null) {
		getStateEntering().invoke(this, new ResponsiveStateEnteringEventArgs());
	}

}


public void onStateEntered() {
	if (getStateEntered() != null) {
		getStateEntered().invoke(this, new ResponsiveStateEnteredEventArgs());
	}

}


public void onStateExited() {
	if (getStateExited() != null) {
		getStateExited().invoke(this, new ResponsiveStateExitedEventArgs());
	}

}

}
