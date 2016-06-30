//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
/**
* This class is used to group the settings to define an animation phase.
*/
public class GridAnimationPhaseSettings {

private GridAnimationPhaseSettingsImplementation __GridAnimationPhaseSettingsImplementation;
GridAnimationPhaseSettingsImplementation getImplementation() { return __GridAnimationPhaseSettingsImplementation; }
public GridAnimationPhaseSettings() {
this(new GridAnimationPhaseSettingsImplementation());
}GridAnimationPhaseSettings(GridAnimationPhaseSettingsImplementation GridAnimationPhaseSettingsImpl) {

__GridAnimationPhaseSettingsImplementation = GridAnimationPhaseSettingsImpl;
}


/**
* The duration of an animation, in milliseconds
*/
public int getDurationMilliseconds() {
return __GridAnimationPhaseSettingsImplementation.getDurationMilliseconds();
}
/**
* The duration of an animation, in milliseconds
*/
public void setDurationMilliseconds(int value) {
__GridAnimationPhaseSettingsImplementation.setDurationMilliseconds(value);
}

/**
* The amount of time to delay an animation, in milliseconds.
*/
public int getHoldInitialMilliseconds() {
return __GridAnimationPhaseSettingsImplementation.getHoldInitialMilliseconds();
}
/**
* The amount of time to delay an animation, in milliseconds.
*/
public void setHoldInitialMilliseconds(int value) {
__GridAnimationPhaseSettingsImplementation.setHoldInitialMilliseconds(value);
}

/**
* The amount of time to delay each item animating, in milliseconds
*/
public int getPerItemDelayMilliseconds() {
return __GridAnimationPhaseSettingsImplementation.getPerItemDelayMilliseconds();
}
/**
* The amount of time to delay each item animating, in milliseconds
*/
public void setPerItemDelayMilliseconds(int value) {
__GridAnimationPhaseSettingsImplementation.setPerItemDelayMilliseconds(value);
}

/**
* The amount of time each item animating should take, in milliseconds
*/
public int getSubItemDurationMilliseconds() {
return __GridAnimationPhaseSettingsImplementation.getSubItemDurationMilliseconds();
}
/**
* The amount of time each item animating should take, in milliseconds
*/
public void setSubItemDurationMilliseconds(int value) {
__GridAnimationPhaseSettingsImplementation.setSubItemDurationMilliseconds(value);
}

/**
* The desired amount of time each item animating should take, in milliseconds
*/
public int getDesiredSubItemDurationMilliseconds() {
return __GridAnimationPhaseSettingsImplementation.getDesiredSubItemDurationMilliseconds();
}
/**
* The desired amount of time each item animating should take, in milliseconds
*/
public void setDesiredSubItemDurationMilliseconds(int value) {
__GridAnimationPhaseSettingsImplementation.setDesiredSubItemDurationMilliseconds(value);
}

/**
* Configures whether all items animating should finish simultaneously
*/
public boolean getShouldItemsFinishSimultaneously() {
return __GridAnimationPhaseSettingsImplementation.getShouldItemsFinishSimultaneously();
}
/**
* Configures whether all items animating should finish simultaneously
*/
public void setShouldItemsFinishSimultaneously(boolean value) {
__GridAnimationPhaseSettingsImplementation.setShouldItemsFinishSimultaneously(value);
}

/**
* Configures the Easing function used to animate the individual items
*/
public com.infragistics.controls.GridEasingFunctionType getEasingFunctionType() {
return __GridAnimationPhaseSettingsImplementation.getEasingFunctionType();
}
/**
* Configures the Easing function used to animate the individual items
*/
public void setEasingFunctionType(com.infragistics.controls.GridEasingFunctionType value) {
__GridAnimationPhaseSettingsImplementation.setEasingFunctionType(value);
}

}
