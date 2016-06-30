//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
import android.util.TypedValue;
import android.content.res.Resources;

/**
*  Represents a Responsive State on the grid, which is used to dynamically respond to the width of the Grid changing.
*/
public class ResponsiveState {

	private ResponsiveStateImplementation __ResponsiveStateImplementation;

	ResponsiveStateImplementation getImplementation() {
		return  __ResponsiveStateImplementation;
	}

	public ResponsiveState() {
		//super(implementation);
		__ResponsiveStateImplementation = new ResponsiveStateImplementation();
		__ResponsiveStateImplementation.setExternalObject(this);
	}

	private OnResponsiveStateEnteringListener _onStateEnteringListener = null;
	private ResponsiveStateEnteringEventHandler _innerResponsiveStateEnteringEventHandler = null;
	/**
	*  Sets listener for state Entering.
	*/
	public void setOnStateEnteringListener(final OnResponsiveStateEnteringListener listener) {
		_onStateEnteringListener = listener;
		final ResponsiveState responsiveState = this;
		_innerResponsiveStateEnteringEventHandler = new ResponsiveStateEnteringEventHandler() { 
			@Override
				public void invoke(Object sender, ResponsiveStateEnteringEventArgs e) {
					ResponsiveStateEnteringEvent event = new ResponsiveStateEnteringEvent(e);
						
					_onStateEnteringListener.onEntering(responsiveState, event);
				}
		};
			
		if (listener != null) {
			__ResponsiveStateImplementation.setStateEntering(com.infragistics.controls.FunctionDelegate.combine(__ResponsiveStateImplementation.getStateEntering(), _innerResponsiveStateEnteringEventHandler));
		} else {
			__ResponsiveStateImplementation.setStateEntering(com.infragistics.controls.FunctionDelegate.remove(__ResponsiveStateImplementation.getStateEntering(), _innerResponsiveStateEnteringEventHandler));
		}
	}

    private OnResponsiveStateEnteredListener _onStateEnteredListener = null;
	private ResponsiveStateEnteredEventHandler _innerResponsiveStateEnteredEventHandler = null;
	/**
	*  Sets listener for state entered.
	*/
	public void setOnStateEnteredListener(final OnResponsiveStateEnteredListener listener) {
		_onStateEnteredListener = listener;
		final ResponsiveState responsiveState = this;
		_innerResponsiveStateEnteredEventHandler = new ResponsiveStateEnteredEventHandler() { 
			@Override
				public void invoke(Object sender, ResponsiveStateEnteredEventArgs e) {
					ResponsiveStateEnteredEvent event = new ResponsiveStateEnteredEvent(e);
						
					_onStateEnteredListener.onEntered(responsiveState, event);
				}
		};
			
		if (listener != null) {
			__ResponsiveStateImplementation.setStateEntered(com.infragistics.controls.FunctionDelegate.combine(__ResponsiveStateImplementation.getStateEntered(), _innerResponsiveStateEnteredEventHandler));
		} else {
			__ResponsiveStateImplementation.setStateEntered(com.infragistics.controls.FunctionDelegate.remove(__ResponsiveStateImplementation.getStateEntered(), _innerResponsiveStateEnteredEventHandler));
		}
	}		

	private OnResponsiveStateExitedListener _onStateExitedListener = null;
	private ResponsiveStateExitedEventHandler _innerResponsiveStateExitedEventHandler = null;
	/**
	*  Sets listener for state exited.
	*/
	public void setOnStateExitedListener(final OnResponsiveStateExitedListener listener) {
		_onStateExitedListener = listener;
		final ResponsiveState responsiveState = this;
		_innerResponsiveStateExitedEventHandler = new ResponsiveStateExitedEventHandler() { 
			@Override
				public void invoke(Object sender, ResponsiveStateExitedEventArgs e) {
					ResponsiveStateExitedEvent event = new ResponsiveStateExitedEvent(e);
						
					_onStateExitedListener.onExited(responsiveState, event);
				}
		};
			
		if (listener != null) {
			__ResponsiveStateImplementation.setStateExited(com.infragistics.controls.FunctionDelegate.combine(__ResponsiveStateImplementation.getStateExited(), _innerResponsiveStateExitedEventHandler));
		} else {
			__ResponsiveStateImplementation.setStateExited(com.infragistics.controls.FunctionDelegate.remove(__ResponsiveStateImplementation.getStateExited(), _innerResponsiveStateExitedEventHandler));
		}
	}	
	
	/**
	* Adds a new responsive phase to this responsive state
	*/
	public ResponsiveState addResponsivePhase(ResponsivePhase phase) {
		__ResponsiveStateImplementation.getResponsivePhases().add(phase.getImplementation());
		return this;
	}

	/**
	* Adds a new responsive phase to this responsive state
	*/
	public ResponsivePhase addResponsivePhase() {
		ResponsivePhase phase = new ResponsivePhase();
		this.addResponsivePhase(phase);
		return phase;
	}

	/**
	* Removes an existing responsive phase from this responsive state
	*/
	public void removeResponsivePhase(ResponsivePhase phase) {
		__ResponsiveStateImplementation.getResponsivePhases().remove(phase.getImplementation());
	}

	/**
	* Clears all active responsive phases on this responsive state
	*/
	public void clearResponsivePhase() {
		__ResponsiveStateImplementation.getResponsivePhases().clear();
	}

	/**
	* Gets an array of the responsive phases on this responsive state
	*/
	public ResponsivePhase[] getResponsivePhase() {
		ResponsivePhase[] phases = new ResponsivePhase[__ResponsiveStateImplementation.getResponsivePhases().getCount()];
		for (int i = 0; i < __ResponsiveStateImplementation.getResponsivePhases().getCount(); i++) {
			phases[i] = (ResponsivePhase) __ResponsiveStateImplementation.getResponsivePhases().getItem(i).getExternalObject();
		}

		return phases;
	}	

	private double toPixelUnits(int unit, double size) {
        return (double)TypedValue.applyDimension(unit, (float)size, Resources.getSystem().getDisplayMetrics());
    }

	/**
	* Gets the minimum width for the range that this responsive state will respond to
	*/
	public double getMinimumWidth() {
		return __ResponsiveStateImplementation.getMinimumWidth();
	}

	/**
	* Sets the minimum width for the range that this responsive state will respond to
	*/
	public void setMinimumWidth(int unit, double width) {
        width = toPixelUnits(unit, width);
		__ResponsiveStateImplementation.setMinimumWidth(width);
    }

	/**
	* Sets the minimum width for the range that this responsive state will respond to
	*/
    public void setMinimumWidth(double width) {
        setMinimumWidth(TypedValue.COMPLEX_UNIT_DIP, width);
    }

	/**
	* Gets the maximum width for the range that this responsive state will respond to
	*/
	public double getMaximumWidth() {
		return __ResponsiveStateImplementation.getMaximumWidth();
	}
	
	/**
	* Sets the maximum width for the range that this responsive state will respond to
	*/
	public void setMaximumWidth(int unit, double width) {
		width = toPixelUnits(unit, width);
		__ResponsiveStateImplementation.setMaximumWidth(width);
	}

	/**
	* Sets the maximum width for the range that this responsive state will respond to
	*/
	public void setMaximumWidth(double width) {
		setMaximumWidth(TypedValue.COMPLEX_UNIT_DIP, width);
	}


	/**
	* The name of the responsive state
	*/
	public String getName() {
	return __ResponsiveStateImplementation.getName();
	}
	/**
	* The name of the responsive state
	*/
	public void setName(String value) {
	__ResponsiveStateImplementation.setName(value);
	}

	/**
	* Configures this responsive state to only be manually actived
	*/
	public boolean getIsManualState() {
	return __ResponsiveStateImplementation.getIsManualState();
	}
	/**
	* Configures this responsive state to only be manually actived
	*/
	public void setIsManualState(boolean value) {
	__ResponsiveStateImplementation.setIsManualState(value);
	}



}
