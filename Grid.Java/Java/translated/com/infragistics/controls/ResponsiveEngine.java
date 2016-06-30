//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class ResponsiveEngine {
private ResponsiveStateImplementation _lastExecutedState;

private int _orientationDelayMS = 500;

private int _sizeChangedDelayMS = 200;

private java.util.Calendar _lastSizeChange;

private boolean _isFirstTime;

private boolean _isPending;

private IntList _pendingAnimationIds;

private GridImplementation _grid;


private ResponsiveStatesCollection _responsiveStates;
private ResponsiveStatesCollection setResponsiveStates(ResponsiveStatesCollection value) {
_responsiveStates = value;
return value;
}
public ResponsiveStatesCollection getResponsiveStates() {
	return _responsiveStates;
}

private ResponsiveStateImplementation _enteringState;

private ResponsiveStateImplementation _manualStateRequested;

public ResponsiveEngine(GridImplementation grid) {



		_grid = grid;
		setResponsiveStates(new ResponsiveStatesCollection());
		_pendingAnimationIds = new IntList();
		_isFirstTime = true;
		_manualStateRequested = null;
}


public void setManualState(ResponsiveStateImplementation state) {
	if (_enteringState == state) {
		return;
	}

	_manualStateRequested = state;
	if (_isFirstTime) {

	} else {
		requestResponsiveExecute();
	}

}


public void sizeChanged(double width, double height) {
	Debug.writeLine(com.infragistics.controls.StringHelper.add("SC: Width - ", width));
	_lastSizeChange = java.util.Calendar.getInstance();
	if (_isFirstTime) {
		executeResponsiveHandler();
		_isFirstTime = false;

	} else {
		requestResponsiveExecute();
	}

}


private void requestResponsiveExecute() {
	if (_isPending) {
		return;
	}

	int delayInMS = resolveRemainingDelayInMS();
	_isPending = true;
	_grid.getDelayedExecutionManager().executeIn(new Action() {
		 public void invoke() { 
				if (!_isPending) {
					return;
				}

				_isPending = false;
				if (resolveRemainingDelayInMS() < 1) {
					executeResponsiveHandler();

				} else {
					requestResponsiveExecute();
				}


		}
	}, delayInMS);
}


private void executeResponsiveHandler() {
	if (_enteringState != null) {
		return;
	}

	ResponsiveStateImplementation toState = null;
	if (getResponsiveStates().getCount() > 0) {
		toState = findProperState(_grid.getAvailableWidth());
	}

	if (toState == _lastExecutedState) {
		return;
	}

	if (_lastExecutedState != null && toState != null) {
		_lastExecutedState.onStateExited();
		_lastExecutedState = null;
	}

	if (toState != null) {
		if (_manualStateRequested != null) {
			_manualStateRequested = null;
		}

		_enteringState = toState;
		Debug.writeLine(com.infragistics.controls.StringHelper.add("State Starting... ", toState.getName()));
		_lastExecutedState = toState;
		_lastExecutedState.setActivePhase(0);
		_lastExecutedState.onStateEntering();
		processPhases(_lastExecutedState);
		_lastExecutedState.onStateEntered();
	}

}


class __closure_ResponsiveEngine_ProcessPhases {
	public ResponsiveStateImplementation state;

}

private void processPhases(ResponsiveStateImplementation state) {
final __closure_ResponsiveEngine_ProcessPhases __closure = new __closure_ResponsiveEngine_ProcessPhases();
__closure.state = state;
	if (__closure.state.getResponsivePhases().getCount() == __closure.state.getActivePhase()) {
		_enteringState = null;
		ResponsiveStateImplementation properState = findProperState(_grid.getAvailableWidth());
			if (properState != _lastExecutedState) {
				requestResponsiveExecute();
			}


		return;
	}

	if (_isFirstTime) {
		processPhasesCore(__closure.state);
		_lastExecutedState.setActivePhase(_lastExecutedState.getActivePhase() + 1);
		processPhases(__closure.state);

	} else {
		_grid.getDelayedExecutionManager().executeIn(new Action() {
			 public void invoke() { 
					_grid.getAnimationManager().setAnimationCompleted(com.infragistics.controls.FunctionDelegate.combine(_grid.getAnimationManager().getAnimationCompleted(), new GridAnimationManagerAnimationCompletedEventHandler(this, "Infragistics.Controls.Grid.Implementation.ResponsiveEngine.AnimationManager_AnimationCompleted") { public void invoke(Object sender, GridAnimationManagerAnimationCompletedEventArgs args) { animationManager_AnimationCompleted(sender, args); } }));
					_grid.getAnimationManager().setAnimationCanceled(com.infragistics.controls.FunctionDelegate.combine(_grid.getAnimationManager().getAnimationCanceled(), new GridAnimationManagerAnimationCanceledEventHandler(this, "Infragistics.Controls.Grid.Implementation.ResponsiveEngine.AnimationManager_AnimationCanceled") { public void invoke(Object sender, GridAnimationManagerAnimationCanceledEventArgs args) { animationManager_AnimationCanceled(sender, args); } }));
					_grid.getAnimationManager().startTrackingAnimations();
					processPhasesCore(__closure.state);
					_pendingAnimationIds = _grid.getAnimationManager().endTrackingAnimations();
					if (_pendingAnimationIds.getCount() == 0) {
						handleAnimationCompleted(-1);
					}


			}
		}, __closure.state.getResponsivePhases().inner[0].getDelayMilliseconds());
	}

}


private void processPhasesCore(ResponsiveStateImplementation state) {
	ResponsivePhaseImplementation phase = state.getResponsivePhases().inner[state.getActivePhase()];
	processPropertySetters(phase.getColumnPropertySetters());
	processColumnExchangers(phase.getColumnExchangers());
}


private void animationManager_AnimationCanceled(Object sender, GridAnimationManagerAnimationCanceledEventArgs args) {
	handleAnimationCompleted(args.getAnimationId());
}


private void animationManager_AnimationCompleted(Object sender, GridAnimationManagerAnimationCompletedEventArgs args) {
	handleAnimationCompleted(args.getAnimationId());
}


private void handleAnimationCompleted(int id) {
	if (_pendingAnimationIds.contains(id)) {
		_pendingAnimationIds.remove(id);
	}

	if (_pendingAnimationIds.getCount() == 0) {
		_grid.getAnimationManager().setAnimationCompleted(com.infragistics.controls.FunctionDelegate.remove(_grid.getAnimationManager().getAnimationCompleted(), new GridAnimationManagerAnimationCompletedEventHandler(this, "Infragistics.Controls.Grid.Implementation.ResponsiveEngine.AnimationManager_AnimationCompleted") { public void invoke(Object sender, GridAnimationManagerAnimationCompletedEventArgs args) { animationManager_AnimationCompleted(sender, args); } }));
		_grid.getAnimationManager().setAnimationCanceled(com.infragistics.controls.FunctionDelegate.remove(_grid.getAnimationManager().getAnimationCanceled(), new GridAnimationManagerAnimationCanceledEventHandler(this, "Infragistics.Controls.Grid.Implementation.ResponsiveEngine.AnimationManager_AnimationCanceled") { public void invoke(Object sender, GridAnimationManagerAnimationCanceledEventArgs args) { animationManager_AnimationCanceled(sender, args); } }));
		_lastExecutedState.setActivePhase(_lastExecutedState.getActivePhase() + 1);
		processPhases(_lastExecutedState);
	}

}


class __closure_ResponsiveEngine_ProcessPropertySetters {
	public ColumnPropertySetterImplementation setter;

}

private void processPropertySetters(ColumnPropertySettersCollection propSetters) {
final __closure_ResponsiveEngine_ProcessPropertySetters __closure = new __closure_ResponsiveEngine_ProcessPropertySetters();
	for (int i = 0; i < propSetters.getCount(); i++) {
		__closure.setter = propSetters.inner[i];
		ColumnImplementation col = EnumerableLinq.<ColumnImplementation>firstOrDefault(new TypeInfo(ColumnImplementation.class), EnumerableLinq.<ColumnImplementation>where(new TypeInfo(ColumnImplementation.class), _grid.getActualColumns(), new Func__2<ColumnImplementation, Boolean>() {
			 public Boolean invoke(ColumnImplementation c) { 
				return com.infragistics.controls.StringHelper.areEqual(c.getName(), __closure.setter.getColumnName());
			}
		}));
		if (col == null) {
			col = EnumerableLinq.<ColumnImplementation>firstOrDefault(new TypeInfo(ColumnImplementation.class), EnumerableLinq.<ColumnImplementation>where(new TypeInfo(ColumnImplementation.class), _grid.getActualColumns(), new Func__2<ColumnImplementation, Boolean>() {
				 public Boolean invoke(ColumnImplementation c) { 
					return com.infragistics.controls.StringHelper.areEqual(c.getKey(), __closure.setter.getColumnName());
				}
			}));
		}

		if (col == null) {
			continue;
		}

		_grid.getPropertySetter().setProperty(col, __closure.setter.getPropertyName(), __closure.setter.getValue());
	}

}


private void processColumnExchangers(ColumnExchangersCollection columnExchangers) {
	for (int i = 0; i < columnExchangers.getCount(); i++) {
		ColumnExchangerImplementation exchanger = columnExchangers.inner[i];
		if (exchanger.getColumn() == null) {
			continue;
		}

		if (exchanger.getTargetIndex() >= _grid.getActualColumns().getCount()) {
			continue;
		}

		ColumnImplementation oldCol = _grid.getActualColumns().getItem(exchanger.getTargetIndex());
		_grid.exchangeColumn(exchanger.getColumn(), oldCol);
	}

}


private ResponsiveStateImplementation findProperState(double width) {
	if (_manualStateRequested != null) {
		return _manualStateRequested;
	}

	for (int i = 0; i < getResponsiveStates().getCount(); i++) {
		ResponsiveStateImplementation state = getResponsiveStates().inner[i];
		if (width >= state.getMinimumWidth() && width <= state.getMaximumWidth() && !state.getIsManualState()) {
			return state;
		}

	}

	return null;
}


private int resolveRemainingDelayInMS() {
	long timeFromLastSizeChanged = com.infragistics.controls.DateHelpers.getTimeSpanFromMilliseconds(_sizeChangedDelayMS);
	long timeFromLastOrientation = com.infragistics.controls.DateHelpers.getTimeSpanFromMilliseconds(_orientationDelayMS);
	if (com.infragistics.controls.DateHelpers.areNotEqual(_lastSizeChange, null)) {
		timeFromLastSizeChanged = com.infragistics.controls.DateHelpers.subtract(java.util.Calendar.getInstance(), _lastSizeChange);
	}

	long timeFromLastSizeChangedMilliseconds = (Long)timeFromLastSizeChanged;
	int diffSizeChanged = (int)(_sizeChangedDelayMS - timeFromLastSizeChangedMilliseconds);
	if (diffSizeChanged < 1) {
		diffSizeChanged = 0;
	}

	return diffSizeChanged;
}

}
