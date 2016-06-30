//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class GridAnimationManager {
public GridAnimationManager() {



		_rowDataAnimationSettings = new GridAnimationPhaseSettingsImplementation();
		_rowDataAnimationSettings.setDurationMilliseconds(0);
		_rowDataAnimationSettings.setShouldItemsFinishSimultaneously(true);
		_rowDataAnimationSettings.setPerItemDelayMilliseconds(0);
		_ensureCellShownSettings = new GridAnimationPhaseSettingsImplementation();
		_ensureCellShownSettings.setDurationMilliseconds(0);
		_ensureCellShownSettings.setShouldItemsFinishSimultaneously(true);
		_ensureCellShownSettings.setPerItemDelayMilliseconds(0);
}


public GridColumnAnimationSettingsImplementation getDefaultSettings() {

		return _defaultColumnSettings;

}

private static int _nextAnimationId = 0;


protected int getAnimationId() {
	int id = _nextAnimationId;
	_nextAnimationId++;
	return id;
}

private IntList _trackedAnimations = new IntList();

private boolean _tracking = false;


public void startTrackingAnimations() {
	_tracking = true;
	_trackedAnimations = new IntList();
}


public IntList endTrackingAnimations() {
	_tracking = false;
	return _trackedAnimations;
}

public GridAnimationManagerAnimationCreatedEventHandler animationCreated = null;
public void setAnimationCreated(GridAnimationManagerAnimationCreatedEventHandler __event) {
	animationCreated = __event;
}
public GridAnimationManagerAnimationCreatedEventHandler getAnimationCreated() {
	return animationCreated;
}

public GridAnimationManagerAnimationCompletedEventHandler animationCompleted = null;
public void setAnimationCompleted(GridAnimationManagerAnimationCompletedEventHandler __event) {
	animationCompleted = __event;
}
public GridAnimationManagerAnimationCompletedEventHandler getAnimationCompleted() {
	return animationCompleted;
}

public GridAnimationManagerAnimationCanceledEventHandler animationCanceled = null;
public void setAnimationCanceled(GridAnimationManagerAnimationCanceledEventHandler __event) {
	animationCanceled = __event;
}
public GridAnimationManagerAnimationCanceledEventHandler getAnimationCanceled() {
	return animationCanceled;
}


class __closure_GridAnimationManager_OnAnimationCreated {
	public int animationId;

}

protected void onAnimationCreated(int animationId) {
final __closure_GridAnimationManager_OnAnimationCreated __closure = new __closure_GridAnimationManager_OnAnimationCreated();
__closure.animationId = animationId;
	if (_tracking) {
		_trackedAnimations.add(__closure.animationId);
	}

	if (getAnimationCreated() != null) {
		getAnimationCreated().invoke(this, (new Object() { 
			public GridAnimationManagerAnimationCreatedEventArgs invoke() {
				GridAnimationManagerAnimationCreatedEventArgs __ret = new GridAnimationManagerAnimationCreatedEventArgs();
				__ret.setAnimationId(__closure.animationId);
				return __ret;
			}
		}).invoke());
	}

}


class __closure_GridAnimationManager_OnAnimationCanceled {
	public int animationId;

}

protected void onAnimationCanceled(int animationId) {
final __closure_GridAnimationManager_OnAnimationCanceled __closure = new __closure_GridAnimationManager_OnAnimationCanceled();
__closure.animationId = animationId;
	if (_tracking) {
		_trackedAnimations.remove(__closure.animationId);
	}

	if (getAnimationCanceled() != null) {
		getAnimationCanceled().invoke(this, (new Object() { 
			public GridAnimationManagerAnimationCanceledEventArgs invoke() {
				GridAnimationManagerAnimationCanceledEventArgs __ret = new GridAnimationManagerAnimationCanceledEventArgs();
				__ret.setAnimationId(__closure.animationId);
				return __ret;
			}
		}).invoke());
	}

}


class __closure_GridAnimationManager_OnAnimationCompleted {
	public int animationId;

}

protected void onAnimationCompleted(int animationId) {
final __closure_GridAnimationManager_OnAnimationCompleted __closure = new __closure_GridAnimationManager_OnAnimationCompleted();
__closure.animationId = animationId;
	if (_tracking) {
		_trackedAnimations.remove(__closure.animationId);
	}

	if (getAnimationCompleted() != null) {
		getAnimationCompleted().invoke(this, (new Object() { 
			public GridAnimationManagerAnimationCompletedEventArgs invoke() {
				GridAnimationManagerAnimationCompletedEventArgs __ret = new GridAnimationManagerAnimationCompletedEventArgs();
				__ret.setAnimationId(__closure.animationId);
				return __ret;
			}
		}).invoke());
	}

}

private GridColumnAnimationSettingsImplementation _defaultColumnSettings = new GridColumnAnimationSettingsImplementation();

private GridAnimationSettingsImplementation _defaultSettings = new GridAnimationSettingsImplementation();


class __closure_GridAnimationManager_StartShowingColumnAnimations {
	public int animationId;
	public ColumnImplementation actualColumn;
	public ColumnShowingStyle showingStyle;
	public double toOffset;
	public double fromOffset;
	public ColumnInfo col;
	public CellModel c;
	public CellModel cellModel;
	public double currentOffset;
	public double toOpacity;
	public double fromOpacity;
	public double opacity;
	public GridImplementation grid;
	public ColumnInfo column;
	public ColumnStates previousState;

}

public void startShowingColumnAnimations(GridImplementation grid, GridColumnAnimationSettingsImplementation animationSettings, ColumnInfo column, boolean isAdding, ColumnStates previousState) {
final __closure_GridAnimationManager_StartShowingColumnAnimations __closure = new __closure_GridAnimationManager_StartShowingColumnAnimations();
__closure.grid = grid;
__closure.column = column;
__closure.previousState = previousState;
	if (__closure.column == null) {
		return;
	}

	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation preSettings;
	GridAnimationPhaseSettingsImplementation mainSettings;
	__closure.actualColumn = __closure.grid.getColumnController().getColumnById(__closure.column.getUniqueID());
	GridEffectGroup finishedGrouping = new GridEffectGroup();
	finishedGrouping.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.actualColumn.setState(ColumnStates.VISIBLE);
				__closure.column.setState(ColumnStates.VISIBLE);
				__closure.grid.refreshLayout();
				__closure.grid.onColumnShowingAnimationCompleted(__closure.actualColumn);
				onAnimationCompleted(__closure.animationId);

		}
	}));
	finishedGrouping.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.grid.onColumnShowingAnimationCanceled(__closure.actualColumn);
				onAnimationCanceled(__closure.animationId);

		}
	}));
	if (isAdding) {
		if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnAddingPrePhase() != null) {
			preSettings = __closure.actualColumn.getAnimationSettings().getColumnAddingPrePhase();

		} else if (animationSettings != null && animationSettings.getColumnAddingPrePhase() != null) {
			preSettings = animationSettings.getColumnAddingPrePhase();

		} else {
			preSettings = _defaultColumnSettings.getColumnAddingPrePhase();
		}


		if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnAddingMainPhase() != null) {
			mainSettings = __closure.actualColumn.getAnimationSettings().getColumnAddingMainPhase();

		} else if (animationSettings != null && animationSettings.getColumnAddingMainPhase() != null) {
			mainSettings = animationSettings.getColumnAddingMainPhase();

		} else {
			mainSettings = _defaultColumnSettings.getColumnAddingMainPhase();
		}



	} else {
		if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnShowingPrePhase() != null) {
			preSettings = __closure.actualColumn.getAnimationSettings().getColumnShowingPrePhase();

		} else if (animationSettings != null && animationSettings.getColumnShowingPrePhase() != null) {
			preSettings = animationSettings.getColumnShowingPrePhase();

		} else {
			preSettings = _defaultColumnSettings.getColumnShowingPrePhase();
		}


		if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnShowingMainPhase() != null) {
			mainSettings = __closure.actualColumn.getAnimationSettings().getColumnShowingMainPhase();

		} else if (animationSettings != null && animationSettings.getColumnShowingMainPhase() != null) {
			mainSettings = animationSettings.getColumnShowingMainPhase();

		} else {
			mainSettings = _defaultColumnSettings.getColumnShowingMainPhase();
		}


	}

	__closure.showingStyle = __closure.grid.getColumnAddingAnimationStyle();
	if (!isAdding) {
		__closure.showingStyle = __closure.grid.getColumnShowingAnimationStyle();
	}

	if (__closure.showingStyle == ColumnShowingStyle.AUTO) {
		__closure.showingStyle = __closure.actualColumn.getPreferredShowingAnimationStyle();
	}

	if (__closure.previousState == ColumnStates.HIDDEN || __closure.previousState == ColumnStates.DETACHED) {
		switch (__closure.showingStyle) {
			case SLIDE_FROM_LEFT:
			case SLIDE_FROM_TOP:
			case SLIDE_FROM_BOTTOM:
			case SLIDE_FROM_LEFT_AND_FADE_IN:
			case SLIDE_FROM_TOP_AND_FADE_IN:
			case SLIDE_FROM_BOTTOM_AND_FADE_IN:
			case FADE_IN:
				__closure.column.setLeftPercentOffset(-1);
				break;
			case SLIDE_FROM_RIGHT:
			case SLIDE_FROM_RIGHT_AND_FADE_IN:
				__closure.column.setLeftPercentOffset(1);
				break;
		}

	}

	ColumnEffect columnEffect = new ColumnEffect();
	columnEffect.populateFromSettings(preSettings);
	columnEffect.setFromCurrentValue(true);
	columnEffect.setToValue(0d);
	columnEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.col = (ColumnInfo)target;
				__closure.col.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);

		}
	});
	columnEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				return __closure.column.getLeftPercentOffset();

		}
	});
	finishedGrouping.add(columnEffect);
	__closure.grid.getEffectManager().addColumnEffect(__closure.column, columnEffect);
	ColumnCellsEffect columnCellsEffect = new ColumnCellsEffect();
	columnCellsEffect.setIntent(GridEffectMainIntent.POSITION);
	columnCellsEffect.populateFromSettings(mainSettings);
	columnCellsEffect.setFromCurrentValue(true);
	columnCellsEffect.setToValue(0d);
	columnCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.c = (CellModel)target;
				switch (__closure.showingStyle) {
					case FADE_IN:
					case SLIDE_FROM_LEFT:
					case SLIDE_FROM_RIGHT:
					case SLIDE_FROM_LEFT_AND_FADE_IN:
					case SLIDE_FROM_RIGHT_AND_FADE_IN:
						__closure.c.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
					case SLIDE_FROM_TOP:
					case SLIDE_FROM_BOTTOM:
					case SLIDE_FROM_TOP_AND_FADE_IN:
					case SLIDE_FROM_BOTTOM_AND_FADE_IN:
						__closure.c.setTopOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
				}


		}
	});
	columnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				__closure.currentOffset = __closure.cellModel.getLeftPercentOffset();
				if (__closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_TOP || __closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_BOTTOM || __closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_TOP_AND_FADE_IN || __closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_BOTTOM_AND_FADE_IN) {
					__closure.currentOffset = __closure.cellModel.getTopOffset();
				}

				if (__closure.previousState == ColumnStates.DETACHED || __closure.previousState == ColumnStates.HIDDEN) {
					switch (__closure.showingStyle) {
						case FADE_IN:
							__closure.currentOffset = 0;
							__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
							__closure.cellModel.setTopPercentOffset(__closure.currentOffset);
							__closure.cellModel.setLeftOffset(0);
							__closure.cellModel.setTopOffset(0);
							break;
						case SLIDE_FROM_LEFT:
						case SLIDE_FROM_LEFT_AND_FADE_IN:
							__closure.currentOffset = -1d;
							__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
							__closure.cellModel.setLeftOffset(0);
							__closure.cellModel.setTopPercentOffset(0);
							__closure.cellModel.setTopOffset(0);
							break;
						case SLIDE_FROM_RIGHT:
						case SLIDE_FROM_RIGHT_AND_FADE_IN:
							__closure.currentOffset = 1d;
							__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
							__closure.cellModel.setLeftOffset(0);
							__closure.cellModel.setTopPercentOffset(0);
							__closure.cellModel.setTopOffset(0);
							break;
						case SLIDE_FROM_TOP:
						case SLIDE_FROM_TOP_AND_FADE_IN:
							__closure.currentOffset = (__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * -1d;
							__closure.cellModel.setTopOffset(__closure.currentOffset);
							__closure.cellModel.setLeftOffset(0);
							__closure.cellModel.setLeftPercentOffset(0);
							__closure.cellModel.setTopPercentOffset(0);
							break;
						case SLIDE_FROM_BOTTOM:
						case SLIDE_FROM_BOTTOM_AND_FADE_IN:
							__closure.currentOffset = (__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * 1d;
							__closure.cellModel.setTopOffset(__closure.currentOffset);
							__closure.cellModel.setLeftOffset(0);
							__closure.cellModel.setLeftPercentOffset(0);
							__closure.cellModel.setTopPercentOffset(0);
							break;
					}

				}

				return __closure.currentOffset;

		}
	});
	columnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	columnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	finishedGrouping.add(columnCellsEffect);
	if (__closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_TOP || __closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_TOP_AND_FADE_IN) {
		columnCellsEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.column, columnCellsEffect);
	ColumnCellsEffect columnCellsOpacityEffect = new ColumnCellsEffect();
	columnCellsOpacityEffect.setIntent(GridEffectMainIntent.OPACITY);
	columnCellsOpacityEffect.populateFromSettings(mainSettings);
	columnCellsOpacityEffect.setFromCurrentValue(true);
	columnCellsOpacityEffect.setToValue(1d);
	columnCellsOpacityEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOpacity = (Double)to;
				__closure.fromOpacity = (Double)from;
				__closure.c = (CellModel)target;
				__closure.opacity = __closure.fromOpacity + (__closure.toOpacity - __closure.fromOpacity) * p;
				if (__closure.opacity < 0) {
					__closure.opacity = 0;
				}

				__closure.c.setContentOpacity(__closure.opacity);

		}
	});
	columnCellsOpacityEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				if (__closure.previousState == ColumnStates.DETACHED || __closure.previousState == ColumnStates.HIDDEN) {
					switch (__closure.showingStyle) {
						case SLIDE_FROM_BOTTOM_AND_FADE_IN:
						case SLIDE_FROM_LEFT_AND_FADE_IN:
						case SLIDE_FROM_RIGHT_AND_FADE_IN:
						case SLIDE_FROM_TOP_AND_FADE_IN:
							__closure.cellModel.setContentOpacity(-1d);
							break;
						case FADE_IN:
							__closure.cellModel.setContentOpacity(0d);
							break;
					}

				}

				return __closure.cellModel.getContentOpacity();

		}
	});
	columnCellsOpacityEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	columnCellsOpacityEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	finishedGrouping.add(columnCellsOpacityEffect);
	if (__closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_TOP || __closure.showingStyle == ColumnShowingStyle.SLIDE_FROM_TOP_AND_FADE_IN) {
		columnCellsOpacityEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.column, columnCellsOpacityEffect);
}

private Dictionary__2<Long, List__1<Action>> _exchangingIn = new Dictionary__2<Long, List__1<Action>>(new TypeInfo(Long.class), new TypeInfo(List__1.class, new TypeInfo[] {}));


class __closure_GridAnimationManager_StartExchangingColumnAnimations {
	public int animationId;
	public GridAnimationPhaseSettingsImplementation postSettings;
	public GridAnimationPhaseSettingsImplementation mainSettings;
	public ColumnImplementation actualNewColumn;
	public ColumnImplementation actualOldColumn;
	public ColumnExchangingStyle actualExchangeStyle;
	public boolean fromRight;
	public GridImplementation grid;
	public ColumnInfo oldColumn;
	public ColumnInfo newColumn;

}

public void startExchangingColumnAnimations(GridImplementation grid, GridColumnAnimationSettingsImplementation animationSettings, ColumnInfo oldColumn, ColumnInfo newColumn, ColumnStates oldColumnPreviousState) {
final __closure_GridAnimationManager_StartExchangingColumnAnimations __closure = new __closure_GridAnimationManager_StartExchangingColumnAnimations();
__closure.grid = grid;
__closure.oldColumn = oldColumn;
__closure.newColumn = newColumn;
	if (__closure.oldColumn == null || __closure.newColumn == null) {
		return;
	}

	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	__closure.oldColumn.setState(ColumnStates.HIDING);
	__closure.newColumn.setState(ColumnStates.SHOWING);
	__closure.postSettings = null;
	__closure.mainSettings = null;
	__closure.actualNewColumn = __closure.grid.getColumnController().getColumnById(__closure.newColumn.getUniqueID());
	__closure.actualOldColumn = __closure.grid.getColumnController().getColumnById(__closure.oldColumn.getUniqueID());
	if (__closure.actualNewColumn.getAnimationSettings() != null && __closure.actualNewColumn.getAnimationSettings().getColumnExchangingCleanupPhase() != null) {
		__closure.postSettings = __closure.actualNewColumn.getAnimationSettings().getColumnExchangingCleanupPhase();

	} else if (__closure.actualOldColumn.getAnimationSettings() != null && __closure.actualOldColumn.getAnimationSettings().getColumnExchangingCleanupPhase() != null) {
		__closure.postSettings = __closure.actualOldColumn.getAnimationSettings().getColumnExchangingCleanupPhase();

	} else if (animationSettings != null && animationSettings.getColumnShowingPrePhase() != null) {
		__closure.postSettings = animationSettings.getColumnExchangingCleanupPhase();

	} else {
		__closure.postSettings = _defaultColumnSettings.getColumnExchangingCleanupPhase();
	}



	if (__closure.actualNewColumn.getAnimationSettings() != null && __closure.actualNewColumn.getAnimationSettings().getColumnExchangingMainPhase() != null) {
		__closure.mainSettings = __closure.actualNewColumn.getAnimationSettings().getColumnExchangingMainPhase();

	} else if (__closure.actualOldColumn.getAnimationSettings() != null && __closure.actualOldColumn.getAnimationSettings().getColumnExchangingMainPhase() != null) {
		__closure.mainSettings = __closure.actualOldColumn.getAnimationSettings().getColumnExchangingMainPhase();

	} else if (animationSettings != null && animationSettings.getColumnExchangingMainPhase() != null) {
		__closure.mainSettings = animationSettings.getColumnExchangingMainPhase();

	} else {
		__closure.mainSettings = _defaultColumnSettings.getColumnExchangingMainPhase();
	}



	__closure.actualExchangeStyle = __closure.grid.getColumnExchangingAnimationStyle();
	if (__closure.actualExchangeStyle == ColumnExchangingStyle.AUTO) {
		__closure.actualExchangeStyle = __closure.actualNewColumn.getPreferredExchangingAnimationStyle();
	}

	__closure.fromRight = false;
	if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_LEFT || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_LEFT_AND_CROSSFADE) {
		__closure.fromRight = true;
	}

	boolean fromLeft = false;
	if (__closure.fromRight) {
		__closure.newColumn.setLeftPercentOffset(1d);

	} else {
		__closure.newColumn.setLeftPercentOffset(-1d);
	}

	if (_exchangingIn.containsKey(__closure.oldColumn.getUniqueID())) {
		Debug.writeLine("queuing exchange animation");
		_exchangingIn.add(__closure.newColumn.getUniqueID(), new List__1<Action>(new TypeInfo(Action.class)));
		_exchangingIn.getItem(__closure.oldColumn.getUniqueID()).add(new Action() {
			 public void invoke() { 
					__closure.oldColumn = __closure.grid.getModel().getColumnById(__closure.oldColumn.getUniqueID());
					__closure.newColumn = __closure.grid.getModel().getColumnById(__closure.newColumn.getUniqueID());
					if (__closure.oldColumn == null || __closure.newColumn == null) {
						return;
					}

					__closure.actualOldColumn.setState(ColumnStates.HIDING);
					__closure.oldColumn.setState(ColumnStates.HIDING);
					__closure.actualNewColumn.setState(ColumnStates.SHOWING);
					__closure.newColumn.setState(ColumnStates.SHOWING);
					Debug.writeLine("starting queued exchange animation");
					queueExchange(__closure.grid, __closure.oldColumn, __closure.newColumn, __closure.postSettings, __closure.mainSettings, __closure.actualNewColumn, __closure.actualOldColumn, __closure.actualExchangeStyle, __closure.fromRight, __closure.animationId);

			}
		});

	} else {
		Debug.writeLine("starting exchange animation");
		_exchangingIn.add(__closure.newColumn.getUniqueID(), new List__1<Action>(new TypeInfo(Action.class)));
		queueExchange(__closure.grid, __closure.oldColumn, __closure.newColumn, __closure.postSettings, __closure.mainSettings, __closure.actualNewColumn, __closure.actualOldColumn, __closure.actualExchangeStyle, __closure.fromRight, __closure.animationId);
	}

}


class __closure_GridAnimationManager_QueueExchange {
	public ColumnInfo info;
	public ColumnInfo newInfo;
	public GridEffectGroup subGrouping;
	public List__1<Action> list;
	public Action first;
	public ColumnInfo info2;
	public ColumnInfo newInfo2;
	public double toOffset;
	public double fromOffset;
	public CellModel c;
	public CellModel cellModel;
	public double currentOffset;
	public ColumnCellsEffect newColumnCellsEffect;
	public double toOpacity;
	public double fromOpacity;
	public double currentOpaticy;
	public GridImplementation grid;
	public ColumnInfo oldColumn;
	public ColumnInfo newColumn;
	public GridAnimationPhaseSettingsImplementation postSettings;
	public ColumnImplementation actualNewColumn;
	public ColumnImplementation actualOldColumn;
	public ColumnExchangingStyle actualExchangeStyle;
	public boolean fromRight;
	public int animationId;

}

private void queueExchange(GridImplementation grid, ColumnInfo oldColumn, ColumnInfo newColumn, GridAnimationPhaseSettingsImplementation postSettings, GridAnimationPhaseSettingsImplementation mainSettings, ColumnImplementation actualNewColumn, ColumnImplementation actualOldColumn, ColumnExchangingStyle actualExchangeStyle, boolean fromRight, int animationId) {
final __closure_GridAnimationManager_QueueExchange __closure = new __closure_GridAnimationManager_QueueExchange();
__closure.grid = grid;
__closure.oldColumn = oldColumn;
__closure.newColumn = newColumn;
__closure.postSettings = postSettings;
__closure.actualNewColumn = actualNewColumn;
__closure.actualOldColumn = actualOldColumn;
__closure.actualExchangeStyle = actualExchangeStyle;
__closure.fromRight = fromRight;
__closure.animationId = animationId;
	if (__closure.oldColumn == null || __closure.newColumn == null) {
		return;
	}

	GridEffectGroup finishedGrouping = new GridEffectGroup();
	finishedGrouping.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.info = __closure.grid.getModel().getColumnById(__closure.oldColumn.getUniqueID());
				__closure.newInfo = __closure.grid.getModel().getColumnById(__closure.newColumn.getUniqueID());
				__closure.subGrouping = new GridEffectGroup();
				__closure.subGrouping.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(__closure.subGrouping.getEffectsFinished(), new EventHandler__1<EventArgs>() {
					 public void invoke(Object obj, EventArgs ea) { 
							__closure.actualOldColumn.setState(ColumnStates.HIDDEN);
							__closure.oldColumn.setState(ColumnStates.HIDDEN);
							Debug.writeLine("removing old column");
							__closure.grid.getExternalGrid().removeExternalColumn(__closure.actualOldColumn.getExternalObject());
							__closure.actualNewColumn.setState(ColumnStates.VISIBLE);
							__closure.newColumn.setState(ColumnStates.VISIBLE);
							__closure.grid.refreshLayout();
							if (_exchangingIn.containsKey(__closure.newColumn.getUniqueID())) {
								__closure.list = _exchangingIn.getItem(__closure.newColumn.getUniqueID());
								if (__closure.list.getCount() == 0) {
									_exchangingIn.removeKey(__closure.newColumn.getUniqueID());

								} else {
									__closure.first = __closure.list.inner[0];
									__closure.list.removeAt(0);
									__closure.first.invoke();
								}

							}

							__closure.grid.onColumnExchangingAnimationCompleted(__closure.actualNewColumn);
							onAnimationCompleted(__closure.animationId);

					}
				}));
				__closure.subGrouping.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(__closure.subGrouping.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
					 public void invoke(Object obj, EventArgs ea) { 
							__closure.grid.onColumnExchangingAnimationCanceled(__closure.actualNewColumn);
							onAnimationCanceled(__closure.animationId);

					}
				}));
				doExchangeOldColumnRemoval(__closure.grid, __closure.info, __closure.newInfo, __closure.postSettings, __closure.actualOldColumn, __closure.fromRight, __closure.subGrouping);
				doExchangeCleanupAnimation(__closure.grid, __closure.info, __closure.newInfo, __closure.postSettings, __closure.actualNewColumn, __closure.actualOldColumn, __closure.fromRight, __closure.subGrouping);

		}
	}));
	finishedGrouping.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.grid.onColumnExchangingAnimationCanceled(__closure.actualNewColumn);
				__closure.subGrouping = new GridEffectGroup();
				__closure.subGrouping.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(__closure.subGrouping.getEffectsFinished(), new EventHandler__1<EventArgs>() {
					 public void invoke(Object obj, EventArgs ea) { 
							__closure.actualOldColumn.setState(ColumnStates.HIDDEN);
							__closure.oldColumn.setState(ColumnStates.HIDDEN);
							Debug.writeLine("removing old column");
							__closure.grid.getExternalGrid().removeExternalColumn(__closure.actualOldColumn.getExternalObject());
							__closure.grid.refreshLayout();

					}
				}));
				__closure.subGrouping.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(__closure.subGrouping.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
					 public void invoke(Object obj, EventArgs ea) { 

					}
				}));
				__closure.info2 = __closure.grid.getModel().getColumnById(__closure.oldColumn.getUniqueID());
				__closure.newInfo2 = __closure.grid.getModel().getColumnById(__closure.newColumn.getUniqueID());
				doExchangeOldColumnRemoval(__closure.grid, __closure.info2, __closure.newInfo2, __closure.postSettings, __closure.actualOldColumn, __closure.fromRight, __closure.subGrouping);

		}
	}));
	ColumnCellsEffect oldColumnCellsEffect = new ColumnCellsEffect();
	oldColumnCellsEffect.setIntent(GridEffectMainIntent.POSITION);
	oldColumnCellsEffect.populateFromSettings(mainSettings);
	oldColumnCellsEffect.setFromCurrentValue(true);
	finishedGrouping.add(oldColumnCellsEffect);
	if (__closure.fromRight) {
		oldColumnCellsEffect.setToValue(-1d - __closure.oldColumn.getLeftPercentOffset());

	} else {
		oldColumnCellsEffect.setToValue(1d + __closure.oldColumn.getLeftPercentOffset());
	}

	boolean isTopOrBottom = false;
	switch (__closure.actualExchangeStyle) {
		case SLIDE_TO_TOP:
		case SLIDE_TO_TOP_AND_CROSSFADE:
			oldColumnCellsEffect.setToValue((__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * -1d);
			isTopOrBottom = true;
			break;
		case SLIDE_TO_BOTTOM:
		case SLIDE_TO_BOTTOM_AND_CROSSFADE:
			oldColumnCellsEffect.setToValue((__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * 1d);
			isTopOrBottom = true;
			break;
	}

	if (isTopOrBottom) {
		oldColumnCellsEffect.setPerItemDelayMilliseconds(0);
	}

	oldColumnCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.c = (CellModel)target;
				switch (__closure.actualExchangeStyle) {
					case SLIDE_TO_LEFT:
					case SLIDE_TO_RIGHT:
					case SLIDE_TO_LEFT_AND_CROSSFADE:
					case SLIDE_TO_RIGHT_AND_CROSSFADE:
						__closure.c.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
					case SLIDE_TO_TOP:
					case SLIDE_TO_BOTTOM:
					case SLIDE_TO_TOP_AND_CROSSFADE:
					case SLIDE_TO_BOTTOM_AND_CROSSFADE:
						__closure.c.setTopOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
				}


		}
	});
	oldColumnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				__closure.currentOffset = __closure.cellModel.getLeftPercentOffset();
				if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP_AND_CROSSFADE || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE) {
					__closure.currentOffset = __closure.cellModel.getTopOffset();
				}

				if (__closure.actualExchangeStyle == ColumnExchangingStyle.CROSSFADE) {
					__closure.currentOffset = 0;
				}

				switch (__closure.actualExchangeStyle) {
					case SLIDE_TO_LEFT:
					case SLIDE_TO_LEFT_AND_CROSSFADE:
					case CROSSFADE:
						__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setTopPercentOffset(0);
						__closure.cellModel.setTopOffset(0);
						break;
					case SLIDE_TO_RIGHT:
					case SLIDE_TO_RIGHT_AND_CROSSFADE:
						__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setTopPercentOffset(0);
						__closure.cellModel.setTopOffset(0);
						break;
					case SLIDE_TO_TOP:
					case SLIDE_TO_TOP_AND_CROSSFADE:
						__closure.currentOffset = __closure.cellModel.getTopOffset();
						__closure.cellModel.setTopOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setLeftPercentOffset(0d);
						__closure.cellModel.setTopPercentOffset(0);
						break;
					case SLIDE_TO_BOTTOM:
					case SLIDE_TO_BOTTOM_AND_CROSSFADE:
						__closure.currentOffset = __closure.cellModel.getTopOffset();
						__closure.cellModel.setTopOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setLeftPercentOffset(0d);
						__closure.cellModel.setTopPercentOffset(0);
						break;
				}

				return __closure.currentOffset;

		}
	});
	oldColumnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.oldColumn.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	oldColumnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.oldColumn.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	oldColumnCellsEffect.setOnFinished(com.infragistics.controls.FunctionDelegate.combine(oldColumnCellsEffect.getOnFinished(), new GridEffectAnimationOnFinishedHandler() {
		 public void invoke(Object e) { 

		}
	}));
	if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP_AND_CROSSFADE) {
		oldColumnCellsEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.oldColumn, oldColumnCellsEffect);
	__closure.newColumnCellsEffect = new ColumnCellsEffect();
	__closure.newColumnCellsEffect.setIntent(GridEffectMainIntent.POSITION);
	__closure.newColumnCellsEffect.populateFromSettings(mainSettings);
	__closure.newColumnCellsEffect.setFromCurrentValue(true);
	finishedGrouping.add(__closure.newColumnCellsEffect);
	if (__closure.fromRight) {
		__closure.newColumnCellsEffect.setToValue(-1d);

	} else {
		__closure.newColumnCellsEffect.setToValue(1d);
	}

	if (isTopOrBottom) {
		__closure.newColumnCellsEffect.setToValue(0d);
	}

	if (isTopOrBottom) {
		__closure.newColumnCellsEffect.setPerItemDelayMilliseconds(0);
	}

	__closure.newColumnCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.c = (CellModel)target;
				switch (__closure.actualExchangeStyle) {
					case SLIDE_TO_LEFT:
					case SLIDE_TO_RIGHT:
					case SLIDE_TO_LEFT_AND_CROSSFADE:
					case SLIDE_TO_RIGHT_AND_CROSSFADE:
						__closure.c.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
					case SLIDE_TO_TOP:
					case SLIDE_TO_BOTTOM:
					case SLIDE_TO_TOP_AND_CROSSFADE:
					case SLIDE_TO_BOTTOM_AND_CROSSFADE:
						__closure.c.setTopOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
				}


		}
	});
	__closure.newColumnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				__closure.currentOffset = __closure.cellModel.getLeftPercentOffset();
				if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP_AND_CROSSFADE || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE) {
					__closure.currentOffset = __closure.cellModel.getTopOffset();
				}

				if (__closure.actualExchangeStyle == ColumnExchangingStyle.CROSSFADE) {
					__closure.currentOffset = (Double)__closure.newColumnCellsEffect.getToValue();

				} else {
					__closure.currentOffset = 0d;
				}

				switch (__closure.actualExchangeStyle) {
					case SLIDE_TO_LEFT:
					case SLIDE_TO_LEFT_AND_CROSSFADE:
					case CROSSFADE:
						__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setTopPercentOffset(0);
						__closure.cellModel.setTopOffset(0);
						break;
					case SLIDE_TO_RIGHT:
					case SLIDE_TO_RIGHT_AND_CROSSFADE:
						__closure.cellModel.setLeftPercentOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setTopPercentOffset(0);
						__closure.cellModel.setTopOffset(0);
						break;
					case SLIDE_TO_TOP:
					case SLIDE_TO_TOP_AND_CROSSFADE:
						__closure.currentOffset = (__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * 1d;
						__closure.cellModel.setTopOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setLeftPercentOffset(1d);
						__closure.cellModel.setTopPercentOffset(0);
						break;
					case SLIDE_TO_BOTTOM:
					case SLIDE_TO_BOTTOM_AND_CROSSFADE:
						__closure.currentOffset = (__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * -1d;
						__closure.cellModel.setTopOffset(__closure.currentOffset);
						__closure.cellModel.setLeftOffset(0);
						__closure.cellModel.setLeftPercentOffset(1d);
						__closure.cellModel.setTopPercentOffset(0);
						break;
				}

				return __closure.currentOffset;

		}
	});
	__closure.newColumnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.newColumn.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	__closure.newColumnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.newColumn.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE) {
		__closure.newColumnCellsEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.newColumn, __closure.newColumnCellsEffect);
	ColumnCellsEffect oldColumnCellsOpacityEffect = new ColumnCellsEffect();
	oldColumnCellsOpacityEffect.setIntent(GridEffectMainIntent.OPACITY);
	oldColumnCellsOpacityEffect.populateFromSettings(mainSettings);
	oldColumnCellsOpacityEffect.setFromCurrentValue(true);
	oldColumnCellsOpacityEffect.setToValue(0d);
	finishedGrouping.add(oldColumnCellsOpacityEffect);
	if (__closure.actualExchangeStyle != ColumnExchangingStyle.CROSSFADE && __closure.actualExchangeStyle != ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE && __closure.actualExchangeStyle != ColumnExchangingStyle.SLIDE_TO_LEFT_AND_CROSSFADE && __closure.actualExchangeStyle != ColumnExchangingStyle.SLIDE_TO_TOP_AND_CROSSFADE) {
		oldColumnCellsOpacityEffect.setToValue(1d);
	}

	oldColumnCellsOpacityEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOpacity = (Double)to;
				__closure.fromOpacity = (Double)from;
				__closure.c = (CellModel)target;
				__closure.c.setOpacity(__closure.fromOpacity + (__closure.toOpacity - __closure.fromOpacity) * p);

		}
	});
	oldColumnCellsOpacityEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				__closure.currentOpaticy = __closure.cellModel.getOpacity();
				return __closure.currentOpaticy;

		}
	});
	oldColumnCellsOpacityEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.oldColumn.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	oldColumnCellsOpacityEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.oldColumn.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	oldColumnCellsOpacityEffect.setOnFinished(com.infragistics.controls.FunctionDelegate.combine(oldColumnCellsOpacityEffect.getOnFinished(), new GridEffectAnimationOnFinishedHandler() {
		 public void invoke(Object e) { 

		}
	}));
	if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE) {
		oldColumnCellsOpacityEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.oldColumn, oldColumnCellsOpacityEffect);
	ColumnCellsEffect newColumnCellsOpacityEffect = new ColumnCellsEffect();
	newColumnCellsOpacityEffect.setIntent(GridEffectMainIntent.OPACITY);
	newColumnCellsOpacityEffect.populateFromSettings(mainSettings);
	newColumnCellsOpacityEffect.setFromCurrentValue(true);
	newColumnCellsOpacityEffect.setToValue(1d);
	finishedGrouping.add(newColumnCellsOpacityEffect);
	newColumnCellsOpacityEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOpacity = (Double)to;
				__closure.fromOpacity = (Double)from;
				__closure.c = (CellModel)target;
				__closure.c.setOpacity(__closure.fromOpacity + (__closure.toOpacity - __closure.fromOpacity) * p);

		}
	});
	newColumnCellsOpacityEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				__closure.currentOpaticy = __closure.cellModel.getOpacity();
				if (__closure.actualExchangeStyle == ColumnExchangingStyle.CROSSFADE || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_RIGHT_AND_CROSSFADE || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_LEFT_AND_CROSSFADE || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_TOP_AND_CROSSFADE) {
					__closure.currentOpaticy = 0d;
				}

				__closure.cellModel.setOpacity(__closure.currentOpaticy);
				return __closure.currentOpaticy;

		}
	});
	newColumnCellsOpacityEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.newColumn.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	newColumnCellsOpacityEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.newColumn.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	if (__closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM || __closure.actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_BOTTOM_AND_CROSSFADE) {
		newColumnCellsOpacityEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.newColumn, newColumnCellsOpacityEffect);
}


class __closure_GridAnimationManager_DoExchangeOldColumnRemoval {
	public ColumnEffect oldColumnEffect;
	public double toOffset;
	public double fromOffset;
	public ColumnInfo col;
	public ColumnInfo oldColumn;
	public ColumnInfo newColumn;

}

private void doExchangeOldColumnRemoval(GridImplementation grid, ColumnInfo oldColumn, ColumnInfo newColumn, GridAnimationPhaseSettingsImplementation postSettings, ColumnImplementation actualOldColumn, boolean fromRight, GridEffectGroup subGroup) {
final __closure_GridAnimationManager_DoExchangeOldColumnRemoval __closure = new __closure_GridAnimationManager_DoExchangeOldColumnRemoval();
__closure.oldColumn = oldColumn;
__closure.newColumn = newColumn;
	if (__closure.oldColumn == null) {
		return;
	}

	__closure.oldColumnEffect = new ColumnEffect();
	__closure.oldColumnEffect.populateFromSettings(postSettings);
	__closure.oldColumnEffect.setFromCurrentValue(true);
	subGroup.add(__closure.oldColumnEffect);
	if (fromRight) {
		__closure.oldColumnEffect.setToValue(-1d);

	} else {
		__closure.oldColumnEffect.setToValue(1d);
	}

	__closure.oldColumnEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.col = (ColumnInfo)target;
				__closure.col.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);

		}
	});
	__closure.oldColumnEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				if (columnsSameSize(__closure.oldColumn, __closure.newColumn)) {
					__closure.oldColumn.setLeftPercentOffset((Double)__closure.oldColumnEffect.getToValue());
					return __closure.oldColumnEffect.getToValue();
				}

				return __closure.oldColumn.getLeftPercentOffset();

		}
	});
	grid.getEffectManager().addColumnEffect(__closure.oldColumn, __closure.oldColumnEffect);
}


class __closure_GridAnimationManager_DoExchangeCleanupAnimation {
	public ColumnEffect newColumnEffect;
	public double toOffset;
	public double fromOffset;
	public ColumnInfo col;
	public ColumnCellsEffect newColumnCellsPostEffect;
	public CellModel cell;
	public ColumnInfo oldColumn;
	public ColumnInfo newColumn;

}

private void doExchangeCleanupAnimation(GridImplementation grid, ColumnInfo oldColumn, ColumnInfo newColumn, GridAnimationPhaseSettingsImplementation postSettings, ColumnImplementation actualNewColumn, ColumnImplementation actualOldColumn, boolean fromRight, GridEffectGroup subGroup) {
final __closure_GridAnimationManager_DoExchangeCleanupAnimation __closure = new __closure_GridAnimationManager_DoExchangeCleanupAnimation();
__closure.oldColumn = oldColumn;
__closure.newColumn = newColumn;
	if (__closure.newColumn == null) {
		return;
	}

	__closure.newColumnEffect = new ColumnEffect();
	__closure.newColumnEffect.populateFromSettings(postSettings);
	__closure.newColumnEffect.setFromCurrentValue(true);
	__closure.newColumnEffect.setToValue(0d);
	subGroup.add(__closure.newColumnEffect);
	__closure.newColumnEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.col = (ColumnInfo)target;
				__closure.col.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);

		}
	});
	__closure.newColumnEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				if (columnsSameSize(__closure.oldColumn, __closure.newColumn)) {
					__closure.newColumn.setLeftPercentOffset((Double)__closure.newColumnEffect.getToValue());
					return __closure.newColumn.getLeftPercentOffset();
				}

				return __closure.newColumn.getLeftPercentOffset();

		}
	});
	grid.getEffectManager().addColumnEffect(__closure.newColumn, __closure.newColumnEffect);
	__closure.newColumnCellsPostEffect = new ColumnCellsEffect();
	__closure.newColumnCellsPostEffect.populateFromSettings(postSettings);
	__closure.newColumnCellsPostEffect.setFromCurrentValue(true);
	__closure.newColumnCellsPostEffect.setToValue(0d);
	subGroup.add(__closure.newColumnCellsPostEffect);
	__closure.newColumnCellsPostEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.cell = (CellModel)target;
				__closure.cell.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);

		}
	});
	__closure.newColumnCellsPostEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cell = (CellModel)target;
				if (columnsSameSize(__closure.oldColumn, __closure.newColumn)) {
					__closure.cell.setLeftPercentOffset((Double)__closure.newColumnCellsPostEffect.getToValue());
					return __closure.cell.getLeftPercentOffset();
				}

				return __closure.cell.getLeftPercentOffset();

		}
	});
	grid.getEffectManager().addColumnCellsEffect(__closure.newColumn, __closure.newColumnCellsPostEffect);
}


private boolean columnsSameSize(ColumnInfo oldColumn, ColumnInfo newColumn) {
	if (oldColumn == null) {
		return true;
	}

	if (newColumn == null) {
		return true;
	}

	if (oldColumn.getWidth() == null && newColumn.getWidth() == null) {
		return true;
	}

	if (oldColumn.getWidth() == null && (newColumn.getWidth().getIsStarSized() && newColumn.getWidth().getValue() == 1)) {
		return true;
	}

	if ((oldColumn.getWidth().getIsStarSized() && oldColumn.getWidth().getValue() == 1) && newColumn.getWidth() == null) {
		return true;
	}

	if (oldColumn.getWidth().getIsStarSized() && newColumn.getWidth().getIsStarSized() && oldColumn.getWidth().getValue() == newColumn.getWidth().getValue()) {
		return true;
	}

	if (!oldColumn.getWidth().getIsStarSized() && !newColumn.getWidth().getIsStarSized() && oldColumn.getWidth().getValue() == newColumn.getWidth().getValue()) {
		return true;
	}

	return false;
}


private int getColumnOffset(GridImplementation grid, ColumnInfo column) {
	if (column.getPosition() == FixedCellPositions.LEFT) {
		return grid.getSpatialEngine().getFixedLeftColumnOffset(column.getIndex(), (double)grid.getModel().getLeft(), grid, grid.getModel());

	} else if (column.getPosition() == FixedCellPositions.RIGHT) {
		return grid.getSpatialEngine().getFixedRightColumnOffset(column.getIndex(), (double)grid.getModel().getRight(), grid, grid.getModel());

	} else {
		return grid.getSpatialEngine().getColumnOffset(column.getIndex(), grid, grid.getModel());
	}


}


class __closure_GridAnimationManager_StartMovingColumnAnimations {
	public int animationId;
	public ColumnImplementation actualColumn;
	public ColumnInfo endCol;
	public List__1<GridColumnSpacer> columnSpacers;
	public int i;
	public int displacement;
	public ColumnEffect columnEffect;
	public boolean cellsTicking;
	public double prevOffset;
	public int prevIndex;
	public int prevLeft;
	public double intersection;
	public double toOffset;
	public double fromOffset;
	public ColumnInfo col;
	public int thisArea;
	public int newDisp;
	public int deltaDisp;
	public double newOffset;
	public double newFrom;
	public List__1<CellModel> cells;
	public CellModel cell;
	public CellModel c;
	public CellModel cm;
	public GridImplementation grid;
	public ColumnInfo column;

}

public void startMovingColumnAnimations(GridImplementation grid, GridColumnAnimationSettingsImplementation animationSettings, ColumnInfo column, ColumnStates previousState) {
final __closure_GridAnimationManager_StartMovingColumnAnimations __closure = new __closure_GridAnimationManager_StartMovingColumnAnimations();
__closure.grid = grid;
__closure.column = column;
	if (__closure.column == null) {
		return;
	}

	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation preSettings;
	GridAnimationPhaseSettingsImplementation mainSettings;
	__closure.actualColumn = __closure.grid.getColumnController().getColumnById(__closure.column.getUniqueID());
	if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnMovingPrePhase() != null) {
		preSettings = __closure.actualColumn.getAnimationSettings().getColumnMovingPrePhase();

	} else if (animationSettings != null && animationSettings.getColumnMovingPrePhase() != null) {
		preSettings = animationSettings.getColumnMovingPrePhase();

	} else {
		preSettings = _defaultColumnSettings.getColumnMovingPrePhase();
	}


	if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnMovingMainPhase() != null) {
		mainSettings = __closure.actualColumn.getAnimationSettings().getColumnMovingMainPhase();

	} else if (animationSettings != null && animationSettings.getColumnShowingMainPhase() != null) {
		mainSettings = animationSettings.getColumnMovingMainPhase();

	} else {
		mainSettings = _defaultColumnSettings.getColumnMovingMainPhase();
	}


	ColumnMovingStyle movingStyle = __closure.grid.getColumnMovingAnimationStyle();
	GridEffectGroup finishedGrouping = new GridEffectGroup();
	finishedGrouping.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.endCol = __closure.grid.getModel().getColumnById(__closure.column.getUniqueID());
				__closure.columnSpacers = __closure.grid.getModel().getSpacersForColumn(__closure.endCol);
				for (__closure.i = 0; __closure.i < __closure.columnSpacers.getCount(); __closure.i++) {
					__closure.grid.getModel().removeSpacer(__closure.columnSpacers.inner[__closure.i]);
				}

				__closure.actualColumn.setState(ColumnStates.VISIBLE);
				__closure.grid.refreshLayout();
				__closure.grid.onColumnMovingAnimationCompleted(__closure.actualColumn);
				onAnimationCompleted(__closure.animationId);

		}
	}));
	finishedGrouping.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.grid.onColumnMovingAnimationCanceled(__closure.actualColumn);
				onAnimationCanceled(__closure.animationId);

		}
	}));
	if (movingStyle == ColumnMovingStyle.AUTO) {
		movingStyle = ColumnMovingStyle.SLIDE_OVER;
	}

	int newLeft = 0;
	double oldOffset = __closure.column.getLeftPercentOffset();
	__closure.column.setLeftPercentOffset(0);
	newLeft = getColumnOffset(__closure.grid, __closure.column);
	__closure.column.setLeftPercentOffset(oldOffset);
	int spacerIndex = __closure.actualColumn.getOldIndex();
	boolean leftMove = false;
	if (__closure.column.getIndex() < spacerIndex) {
		leftMove = true;
	}

	GridColumnSpacer fromSpacer = null;
	if (previousState != ColumnStates.MOVING) {
		fromSpacer = __closure.grid.getModel().createSpacer(spacerIndex, __closure.column, (__closure.column.getActualWidth() + __closure.grid.getModel().getColumnSpacing()) - __closure.column.getShiftAmount(__closure.grid.getModel()), __closure.column.getWidth() == null || __closure.column.getWidth().getIsStarSized(), leftMove);
	}

	List__1<GridColumnSpacer> spacers = __closure.grid.getModel().getSpacersForColumn(__closure.column);
	for (int i = 0; i < spacers.getCount(); i++) {
		spacers.inner[i].setIsShrinking(true);
	}

	int toSpacerIndex = __closure.column.getIndex();
	GridColumnSpacer existingTo = null;
	List__1<GridColumnSpacerCollection> allSpacers = __closure.grid.getModel().getSpacers();
	if (allSpacers.inner[toSpacerIndex].getCount() > 0) {
		for (int i1 = 0; i1 < allSpacers.inner[toSpacerIndex].getCount(); i1++) {
			if (allSpacers.inner[toSpacerIndex].inner[i1].getOwningColumnId() == __closure.column.getUniqueID()) {
				existingTo = allSpacers.inner[toSpacerIndex].inner[i1];
				break;
			}

		}

	}

	GridColumnSpacer toSpacer;
	if (existingTo != null) {
		toSpacer = existingTo;
		toSpacer.setIsShrinking(false);

	} else {
		toSpacer = __closure.grid.getModel().createSpacer(toSpacerIndex, __closure.column, 0, __closure.column.getWidth() == null || __closure.column.getWidth().getIsStarSized(), !leftMove);
		toSpacer.setIsShrinking(false);
	}

	__closure.displacement = newLeft - __closure.actualColumn.getOldLeftPosition();
	double shiftAmount = -1d * __closure.displacement;
	__closure.column.setLeftPercentOffset(shiftAmount / __closure.column.getActualWidth());
	__closure.column.setState(ColumnStates.MOVING);
	__closure.columnEffect = new ColumnEffect();
	__closure.columnEffect.populateFromSettings(preSettings);
	__closure.columnEffect.setFromCurrentValue(true);
	__closure.columnEffect.setToValue(0d);
	int currWidth = __closure.column.getActualWidth();
	__closure.cellsTicking = false;
	__closure.prevOffset = 0d;
	__closure.prevIndex = __closure.column.getIndex();
	__closure.prevLeft = __closure.grid.getSpatialEngine().getColumnOffset(__closure.column.getIndex(), __closure.grid, __closure.grid.getModel());
	__closure.intersection = getVisualIntersectionWithColumnZone(__closure.grid, __closure.column, __closure.column.getIndex());
	__closure.prevLeft = updateSpacersFromIntersection(__closure.grid, __closure.column, __closure.prevLeft, __closure.grid.getModel().getSpacersForColumn(__closure.column), __closure.intersection);
	finishedGrouping.add(__closure.columnEffect);
	__closure.columnEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.col = (ColumnInfo)target;
				__closure.col.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
				if (__closure.col.getActualWidth() > 0) {
					__closure.thisArea = __closure.grid.getSpatialEngine().getStartOfColumnArea(__closure.col.getIndex(), __closure.grid, model);
					if (__closure.thisArea - __closure.actualColumn.getOldLeftPosition() != __closure.displacement) {
						__closure.newDisp = __closure.thisArea - __closure.actualColumn.getOldLeftPosition();
						__closure.deltaDisp = __closure.displacement - __closure.newDisp;
						__closure.newOffset = __closure.prevOffset + (__closure.deltaDisp / (double)__closure.col.getActualWidth());
						__closure.newFrom = __closure.newOffset / (1 - p);
						__closure.columnEffect.updateFromValue(__closure.newFrom, model, __closure.col.getUniqueID());
						__closure.col.setLeftPercentOffset(__closure.newOffset);
						__closure.prevOffset = __closure.newOffset;
						__closure.displacement = __closure.newDisp;
						__closure.col.setLeftPercentOffset(__closure.newFrom + (__closure.toOffset - __closure.newFrom) * p);
					}

					if (!__closure.cellsTicking) {
						__closure.cells = __closure.grid.getModel().getCellsForColumn(__closure.col);
						for (__closure.i = 0; __closure.i < __closure.cells.getCount(); __closure.i++) {
							__closure.cell = __closure.cells.inner[__closure.i];
							__closure.cell.setLeftPercentOffset(__closure.cell.getLeftPercentOffset() + (__closure.prevOffset - __closure.col.getLeftPercentOffset()));
						}

					}

					__closure.prevOffset = __closure.col.getLeftPercentOffset();
					__closure.prevIndex = __closure.col.getIndex();
					__closure.columnSpacers = __closure.grid.getModel().getSpacersForColumn(__closure.col);
					__closure.intersection = getVisualIntersectionWithColumnZone(__closure.grid, __closure.col, __closure.col.getIndex());
					__closure.prevLeft = updateSpacersFromIntersection(__closure.grid, __closure.col, __closure.prevLeft, __closure.columnSpacers, __closure.intersection);
				}


		}
	});
	__closure.columnEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.prevOffset = __closure.column.getLeftPercentOffset();
				return __closure.column.getLeftPercentOffset();

		}
	});
	__closure.grid.getEffectManager().addColumnEffect(__closure.column, __closure.columnEffect);
	ColumnCellsEffect columnCellsEffect = new ColumnCellsEffect();
	columnCellsEffect.setShouldWaitTillAfterHold(true);
	columnCellsEffect.populateFromSettings(mainSettings);
	columnCellsEffect.setFromCurrentValue(true);
	columnCellsEffect.setToValue(0d);
	finishedGrouping.add(columnCellsEffect);
	columnCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				if (p > 0) {
					__closure.cellsTicking = true;
				}

				if (__closure.cellsTicking) {
					__closure.toOffset = (Double)to;
					__closure.fromOffset = (Double)from;
					__closure.c = (CellModel)target;
					__closure.newOffset = __closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p;
					__closure.c.setLeftPercentOffset(__closure.newOffset);
				}


		}
	});
	columnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cm = (CellModel)target;
				return __closure.cm.getLeftPercentOffset();

		}
	});
	columnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	columnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.column, columnCellsEffect);
}


private int updateSpacersFromIntersection(GridImplementation grid, ColumnInfo col, int prevLeft, List__1<GridColumnSpacer> columnSpacers, double intersection) {
	if (intersection > 0) {
		double delta = 0d;
		for (int i = 0; i < columnSpacers.getCount(); i++) {
			if (!columnSpacers.inner[i].getIsShrinking()) {
				if (intersection > columnSpacers.inner[i].getActualWidth()) {
					delta = java.lang.Math.abs(columnSpacers.inner[i].getActualWidth() - intersection);
					columnSpacers.inner[i].setActualWidth(intersection);
				}

			}

		}

		double sum = 0;
		for (int i1 = 0; i1 < columnSpacers.getCount(); i1++) {
			if (columnSpacers.inner[i1].getIsShrinking()) {
				sum += columnSpacers.inner[i1].getActualWidth();
			}

		}

		double newSum = sum - delta;
		if (newSum < 0) {
			newSum = 0;
		}

		double reductionRatio = 1d;
		if (sum == 0) {
			reductionRatio = 0;

		} else {
			reductionRatio = newSum / sum;
		}

		for (int i2 = 0; i2 < columnSpacers.getCount(); i2++) {
			if (columnSpacers.inner[i2].getIsShrinking()) {
				columnSpacers.inner[i2].setActualWidth(columnSpacers.inner[i2].getActualWidth() * reductionRatio);
			}

		}

	}

	if (col.getUniqueID() == 0) {
		prevLeft = grid.getSpatialEngine().getColumnOffset(col.getIndex(), grid, grid.getModel());
	}

	return prevLeft;
}


private double getVisualIntersectionWithColumnZone(GridImplementation grid, ColumnInfo column, int zoneIndex) {
	int left = grid.getSpatialEngine().getStartOfColumnArea(zoneIndex, grid, grid.getModel());
	int right = left + column.getActualWidth();
	int columnLeft = grid.getSpatialEngine().getColumnOffset(column.getIndex(), grid, grid.getModel());
	if (left > columnLeft) {
		return (double)java.lang.Math.max(0, (columnLeft + column.getActualWidth()) - left);

	} else {
		return (double)java.lang.Math.max(0, (left + column.getActualWidth()) - columnLeft);
	}

}


class __closure_GridAnimationManager_StartHidingColumnAnimations {
	public int animationId;
	public ColumnImplementation actualColumn;
	public ColumnHidingStyle hidingStyle;
	public double toOffset;
	public double fromOffset;
	public CellModel c;
	public CellModel cellModel;
	public double currentOffset;
	public ColumnInfo col;
	public double toOpacity;
	public double fromOpacity;
	public double opacity;
	public GridImplementation grid;
	public ColumnInfo column;
	public ColumnStates previousState;

}

public void startHidingColumnAnimations(GridImplementation grid, GridColumnAnimationSettingsImplementation animationSettings, ColumnInfo column, boolean shouldRemove, ColumnStates previousState) {
final __closure_GridAnimationManager_StartHidingColumnAnimations __closure = new __closure_GridAnimationManager_StartHidingColumnAnimations();
__closure.grid = grid;
__closure.column = column;
__closure.previousState = previousState;
	if (__closure.column == null) {
		return;
	}

	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings;
	GridAnimationPhaseSettingsImplementation postSettings;
	__closure.actualColumn = __closure.grid.getColumnController().getColumnById(__closure.column.getUniqueID());
	if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnHidingMainPhase() != null) {
		mainSettings = __closure.actualColumn.getAnimationSettings().getColumnHidingMainPhase();

	} else if (animationSettings != null && animationSettings.getColumnHidingMainPhase() != null) {
		mainSettings = animationSettings.getColumnHidingMainPhase();

	} else {
		mainSettings = _defaultColumnSettings.getColumnHidingMainPhase();
	}


	if (__closure.actualColumn.getAnimationSettings() != null && __closure.actualColumn.getAnimationSettings().getColumnHidingPostPhase() != null) {
		postSettings = __closure.actualColumn.getAnimationSettings().getColumnHidingPostPhase();

	} else if (animationSettings != null && animationSettings.getColumnHidingPostPhase() != null) {
		postSettings = animationSettings.getColumnHidingPostPhase();

	} else {
		postSettings = _defaultColumnSettings.getColumnHidingPostPhase();
	}


	__closure.hidingStyle = __closure.grid.getColumnHidingAnimationStyle();
	GridEffectGroup finishedGrouping = new GridEffectGroup();
	finishedGrouping.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.actualColumn.setState(ColumnStates.HIDDEN);
				__closure.column.setState(ColumnStates.HIDDEN);
				if (__closure.actualColumn.getActualShouldRemoveWhenHidden()) {
					__closure.grid.getExternalGrid().removeExternalColumn(__closure.actualColumn.getExternalObject());
				}

				__closure.grid.refreshLayout();
				__closure.grid.onColumnHidingAnimationCompleted(__closure.actualColumn);
				onAnimationCompleted(__closure.animationId);

		}
	}));
	finishedGrouping.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(finishedGrouping.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				__closure.grid.onColumnHidingAnimationCanceled(__closure.actualColumn);
				onAnimationCanceled(__closure.animationId);

		}
	}));
	if (__closure.hidingStyle == ColumnHidingStyle.AUTO) {
		__closure.hidingStyle = __closure.actualColumn.getPreferredHidingAnimationStyle();
	}

	double targetCellOffset = 0;
	switch (__closure.hidingStyle) {
		case SLIDE_TO_LEFT:
		case SLIDE_TO_LEFT_AND_FADE_OUT:
			targetCellOffset = -1d;
			break;
		case SLIDE_TO_RIGHT:
		case SLIDE_TO_RIGHT_AND_FADE_OUT:
			targetCellOffset = 1d;
			break;
		case SLIDE_TO_TOP:
		case SLIDE_TO_TOP_AND_FADE_OUT:
			targetCellOffset = (__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * -1d;
			break;
		case SLIDE_TO_BOTTOM:
		case SLIDE_TO_BOTTOM_AND_FADE_OUT:
			targetCellOffset = (__closure.grid.getAvailableHeight() + __closure.grid.getModel().getHeaderHeight()) * 1d;
			break;
	}

	ColumnCellsEffect columnCellsEffect = new ColumnCellsEffect();
	columnCellsEffect.populateFromSettings(mainSettings);
	columnCellsEffect.setIntent(GridEffectMainIntent.POSITION);
	columnCellsEffect.setFromCurrentValue(true);
	columnCellsEffect.setToValue(targetCellOffset);
	finishedGrouping.add(columnCellsEffect);
	columnCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.c = (CellModel)target;
				switch (__closure.hidingStyle) {
					case SLIDE_TO_LEFT:
					case SLIDE_TO_RIGHT:
					case SLIDE_TO_LEFT_AND_FADE_OUT:
					case SLIDE_TO_RIGHT_AND_FADE_OUT:
						__closure.c.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
					case SLIDE_TO_TOP:
					case SLIDE_TO_BOTTOM:
					case SLIDE_TO_TOP_AND_FADE_OUT:
					case SLIDE_TO_BOTTOM_AND_FADE_OUT:
						__closure.c.setTopOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);
						break;
				}


		}
	});
	columnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				__closure.currentOffset = __closure.cellModel.getLeftPercentOffset();
				if (__closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_TOP || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_BOTTOM) {
					__closure.currentOffset = __closure.cellModel.getTopOffset();
				}

				return __closure.currentOffset;

		}
	});
	columnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	columnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	if (__closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_BOTTOM || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_BOTTOM_AND_FADE_OUT) {
		columnCellsEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.column, columnCellsEffect);
	double targetOffset = 0;
	switch (__closure.hidingStyle) {
		case SLIDE_TO_LEFT:
		case SLIDE_TO_TOP:
		case SLIDE_TO_BOTTOM:
		case SLIDE_TO_LEFT_AND_FADE_OUT:
		case SLIDE_TO_TOP_AND_FADE_OUT:
		case SLIDE_TO_BOTTOM_AND_FADE_OUT:
		case FADE_OUT:
			targetOffset = -1;
			break;
		case SLIDE_TO_RIGHT:
		case SLIDE_TO_RIGHT_AND_FADE_OUT:
			targetOffset = 1;
			break;
	}

	ColumnEffect columnEffect = new ColumnEffect();
	columnEffect.populateFromSettings(postSettings);
	columnEffect.setFromCurrentValue(true);
	columnEffect.setToValue(targetOffset);
	finishedGrouping.add(columnEffect);
	columnEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOffset = (Double)to;
				__closure.fromOffset = (Double)from;
				__closure.col = (ColumnInfo)target;
				__closure.col.setLeftPercentOffset(__closure.fromOffset + (__closure.toOffset - __closure.fromOffset) * p);

		}
	});
	columnEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				return __closure.column.getLeftPercentOffset();

		}
	});
	__closure.grid.getEffectManager().addColumnEffect(__closure.column, columnEffect);
	ColumnCellsEffect columnCellsOpacityEffect = new ColumnCellsEffect();
	columnCellsOpacityEffect.setIntent(GridEffectMainIntent.OPACITY);
	columnCellsOpacityEffect.populateFromSettings(mainSettings);
	columnCellsOpacityEffect.setFromCurrentValue(true);
	if (__closure.hidingStyle == ColumnHidingStyle.FADE_OUT || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_BOTTOM_AND_FADE_OUT || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_LEFT_AND_FADE_OUT || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_RIGHT_AND_FADE_OUT || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_TOP_AND_FADE_OUT) {
		columnCellsOpacityEffect.setToValue(0d);

	} else {
		columnCellsOpacityEffect.setToValue(1d);
	}

	columnCellsOpacityEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
				__closure.toOpacity = (Double)to;
				__closure.fromOpacity = (Double)from;
				__closure.c = (CellModel)target;
				__closure.opacity = __closure.fromOpacity + (__closure.toOpacity - __closure.fromOpacity) * p;
				if (__closure.opacity < 0) {
					__closure.opacity = 0;
				}

				__closure.c.setContentOpacity(__closure.opacity);

		}
	});
	columnCellsOpacityEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				if (__closure.previousState == ColumnStates.DETACHED || __closure.previousState == ColumnStates.HIDDEN) {
					switch (__closure.hidingStyle) {
						case SLIDE_TO_BOTTOM_AND_FADE_OUT:
						case SLIDE_TO_LEFT_AND_FADE_OUT:
						case SLIDE_TO_RIGHT_AND_FADE_OUT:
						case SLIDE_TO_TOP_AND_FADE_OUT:
							__closure.cellModel.setContentOpacity(1d);
							break;
						case FADE_OUT:
							__closure.cellModel.setContentOpacity(1d);
							break;
					}

				}

				return __closure.cellModel.getContentOpacity();

		}
	});
	columnCellsOpacityEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
	columnCellsOpacityEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.column.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
	finishedGrouping.add(columnCellsOpacityEffect);
	if (__closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_BOTTOM || __closure.hidingStyle == ColumnHidingStyle.SLIDE_TO_BOTTOM_AND_FADE_OUT) {
		columnCellsOpacityEffect.setIsItemDelayInverted(true);
	}

	__closure.grid.getEffectManager().addColumnCellsEffect(__closure.column, columnCellsOpacityEffect);
}


class __closure_GridAnimationManager_AnimateColumnCellsPropertyChange {
	public int animationId;
	public CellModel c;
	public double fromNumber;
	public double toNumber;
	public double actualNumber;
	public double fromDouble;
	public double toDouble;
	public double actualDouble;
	public Brush fromBrush;
	public Brush toBrush;
	public Brush actualBrush;
	public FontInfo fromFont;
	public FontInfo toFont;
	public FontInfo actualFont;
	public int fromInt;
	public int toInt;
	public int actualInt;
	public CellModel cellModel;
	public String propertyName;
	public boolean isHeaderChange;

}

public void animateColumnCellsPropertyChange(GridImplementation grid, ColumnInfo column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue, boolean isHeaderChange) {
final __closure_GridAnimationManager_AnimateColumnCellsPropertyChange __closure = new __closure_GridAnimationManager_AnimateColumnCellsPropertyChange();
__closure.propertyName = propertyName;
__closure.isHeaderChange = isHeaderChange;
	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings = _defaultColumnSettings.getColumnPropertyUpdatingMainPhase();
	if (grid.getColumnAnimationSettings() != null && grid.getColumnAnimationSettings().getColumnPropertyUpdatingMainPhase() != null) {
		mainSettings = grid.getColumnAnimationSettings().getColumnPropertyUpdatingMainPhase();
	}

	ColumnPropertyUpdatingStyle updatingStyle = grid.getColumnPropertyUpdatingAnimationStyle();
	ColumnCellsEffect columnCellsEffect = new ColumnCellsEffect();
	columnCellsEffect.populateFromSettings(mainSettings);
	columnCellsEffect.setIntent(GridEffectMainIntent.COLUMN_PROPERTY_CHANGE);
	columnCellsEffect.setSubIntentMustMatchToCancel(true);
	if (__closure.isHeaderChange) {
		columnCellsEffect.setSubIntent(GridEffectSubIntent.HEADER_PROPERTY_CHANGE);
	}

	columnCellsEffect.setSubIntentModifier(__closure.propertyName);
	columnCellsEffect.setFromCurrentValue(true);
	columnCellsEffect.setToValue(newValue);
	columnCellsEffect.setOnFinished(com.infragistics.controls.FunctionDelegate.combine(columnCellsEffect.getOnFinished(), new GridEffectAnimationOnFinishedHandler() {
		 public void invoke(Object t) { 
				onAnimationCompleted(__closure.animationId);

		}
	}));
	columnCellsEffect.setOnCanceled(com.infragistics.controls.FunctionDelegate.combine(columnCellsEffect.getOnCanceled(), new GridEffectAnimationOnCanceledHandler() {
		 public void invoke(Object t, GridEffect c) { 
				onAnimationCanceled(__closure.animationId);

		}
	}));
	if (updatingStyle == ColumnPropertyUpdatingStyle.AUTO) {
		updatingStyle = ColumnPropertyUpdatingStyle.INTERPOLATE;
	}

	if (propertyAnimationType == CellPropertyAnimationType.BOOL_VALUE || propertyAnimationType == CellPropertyAnimationType.ENUM_VALUE || propertyAnimationType == CellPropertyAnimationType.OBJECT_VALUE || propertyAnimationType == CellPropertyAnimationType.STRING_VALUE || (updatingStyle != ColumnPropertyUpdatingStyle.INTERPOLATE_DEEP && (propertyAnimationType == CellPropertyAnimationType.DATE_VALUE || propertyAnimationType == CellPropertyAnimationType.NUMBER_VALUE || propertyAnimationType == CellPropertyAnimationType.FONT_VALUE))) {
		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
					__closure.c = (CellModel)target;
					if (__closure.isHeaderChange != __closure.c.getPath().getIsHeaderCell()) {
						return;
					}

					if (p > 0.5) {
						__closure.c.setPropertyValue(__closure.propertyName, to);

					} else {
						__closure.c.setPropertyValue(__closure.propertyName, from);
					}


			}
		});
	}

	if (updatingStyle == ColumnPropertyUpdatingStyle.INTERPOLATE_DEEP && propertyAnimationType == CellPropertyAnimationType.NUMBER_VALUE) {
		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
					__closure.c = (CellModel)target;
					if (__closure.isHeaderChange != __closure.c.getPath().getIsHeaderCell()) {
						return;
					}

					__closure.fromNumber = (Double)from;
					__closure.toNumber = (Double)to;
					__closure.actualNumber = __closure.fromNumber + (__closure.toNumber - __closure.fromNumber) * p;
					__closure.c.setPropertyValue(__closure.propertyName, __closure.actualNumber);

			}
		});
	}

	if (propertyAnimationType == CellPropertyAnimationType.DOUBLE_VALUE) {
		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
					__closure.c = (CellModel)target;
					if (__closure.isHeaderChange != __closure.c.getPath().getIsHeaderCell()) {
						return;
					}

					__closure.fromDouble = (Double)from;
					__closure.toDouble = (Double)to;
					__closure.actualDouble = __closure.fromDouble + (__closure.toDouble - __closure.fromDouble) * p;
					__closure.c.setPropertyValue(__closure.propertyName, __closure.actualDouble);

			}
		});
	}

	if (propertyAnimationType == CellPropertyAnimationType.BRUSH_VALUE) {
		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
					__closure.c = (CellModel)target;
					if (__closure.isHeaderChange != __closure.c.getPath().getIsHeaderCell()) {
						return;
					}

					__closure.fromBrush = (Brush)from;
					__closure.toBrush = (Brush)to;
					__closure.actualBrush = BrushUtil.getInterpolation(__closure.fromBrush, p, __closure.toBrush, InterpolationMode.RGB);
					__closure.c.setPropertyValue(__closure.propertyName, __closure.actualBrush);

			}
		});
	}

	if (propertyAnimationType == CellPropertyAnimationType.FONT_VALUE) {
		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
					__closure.c = (CellModel)target;
					if (__closure.isHeaderChange != __closure.c.getPath().getIsHeaderCell()) {
						return;
					}

					__closure.fromFont = (FontInfo)from;
					__closure.toFont = (FontInfo)to;
					__closure.actualFont = new FontInfo();
					FontUtil.interpolateFont(__closure.actualFont, p, __closure.fromFont, __closure.toFont);
					__closure.c.setPropertyValue(__closure.propertyName, __closure.actualFont);

			}
		});
	}

	if (propertyAnimationType == CellPropertyAnimationType.INT_VALUE) {
		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel model) { 
					__closure.c = (CellModel)target;
					if (__closure.isHeaderChange != __closure.c.getPath().getIsHeaderCell()) {
						return;
					}

					__closure.fromInt = (Integer)from;
					__closure.toInt = (Integer)to;
					__closure.actualInt = (int)(java.lang.Math.round((double)__closure.fromInt + ((double)__closure.toInt - (double)__closure.fromInt) * p));
					__closure.c.setPropertyValue(__closure.propertyName, __closure.actualInt);

			}
		});
	}

	columnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel model) { 
				__closure.cellModel = ((CellModel)target);
				return __closure.cellModel.getPropertyValue(__closure.propertyName);

		}
	});
	columnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, column.getIndex(), grid.getModel().getTopRow().getSection(), grid.getModel().getTopRow().getRow()));
	columnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, column.getIndex(), grid.getModel().getBottomRow().getSection(), grid.getModel().getBottomRow().getRow()));
	if (!grid.getIsColumnPropertyUpdatingAnimationEnabled()) {
		columnCellsEffect.setDurationMilliseconds(0);
	}

	grid.getEffectManager().addColumnCellsEffect(column, columnCellsEffect);
}

private GridAnimationPhaseSettingsImplementation _rowDataAnimationSettings;


class __closure_GridAnimationManager_StartRowDataChangeAnimations {
	public int animationId;
	public CellModel cellModel;
	public ColumnImplementation col;
	public Object resolvedValue;
	public GridImplementation grid;

}

public void startRowDataChangeAnimations(GridImplementation grid, int startRow, int endRow) {
final __closure_GridAnimationManager_StartRowDataChangeAnimations __closure = new __closure_GridAnimationManager_StartRowDataChangeAnimations();
__closure.grid = grid;
	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings = _rowDataAnimationSettings;
	VisualModel model = __closure.grid.getModel();
	GridEffectGroup effectGroup = new GridEffectGroup();
	effectGroup.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(effectGroup.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				onAnimationCanceled(__closure.animationId);

		}
	}));
	effectGroup.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(effectGroup.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				onAnimationCompleted(__closure.animationId);

		}
	}));
	for (int i = startRow; i <= endRow; i++) {
		RowCellsEffect rowCellsEffect = new RowCellsEffect();
		effectGroup.add(rowCellsEffect);
		rowCellsEffect.setIntent(GridEffectMainIntent.DATA_CHANGE);
		rowCellsEffect.populateFromSettings(mainSettings);
		rowCellsEffect.setFromCurrentValue(true);
		rowCellsEffect.setToValue(1d);
		rowCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel m) { 

			}
		});
		rowCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
			 public Object invoke(Object target, VisualModel m) { 
					__closure.cellModel = ((CellModel)target);
					if (__closure.cellModel.getPath().getIsContentCell()) {
						__closure.col = __closure.grid.getContainingColumn(__closure.cellModel.getPath());
						__closure.resolvedValue = __closure.grid.getAdapter().resolveValue(__closure.cellModel.getPath(), __closure.col.getKey());
						__closure.grid.onModelDataRefresh(__closure.cellModel, __closure.resolvedValue);
					}

					return __closure.cellModel.getRenderValue();

			}
		});
		RowPath path = __closure.grid.getRowPathForAbsoluteRow(i);
		rowCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, __closure.grid.getModel().getLeftColumn(), path.getSection(), path.getRow()));
		rowCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, __closure.grid.getModel().getRightColumn(), path.getSection(), path.getRow()));
		if (!__closure.grid.getIsRowSelectionAnimationEnabled()) {
			rowCellsEffect.setDurationMilliseconds(0);
		}

		__closure.grid.getEffectManager().addRowCellsEffect(path, rowCellsEffect);
	}

}

private GridAnimationPhaseSettingsImplementation _ensureCellShownSettings;


class __closure_GridAnimationManager_StartEnsureCellShownAnimations {
	public int animationId;
	public ColumnInfo columnInfo;
	public CellModel cellModel;
	public GridImplementation grid;

}

public void startEnsureCellShownAnimations(GridImplementation grid, ColumnInfo column) {
final __closure_GridAnimationManager_StartEnsureCellShownAnimations __closure = new __closure_GridAnimationManager_StartEnsureCellShownAnimations();
__closure.grid = grid;
	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings = _ensureCellShownSettings;
	VisualModel model = __closure.grid.getModel();
	GridEffectGroup group = new GridEffectGroup();
	group.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(group.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				onAnimationCompleted(__closure.animationId);

		}
	}));
	group.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(group.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				onAnimationCanceled(__closure.animationId);

		}
	}));
	ColumnImplementation actualColumn = __closure.grid.getColumnController().getColumnById(column.getUniqueID());
	ColumnEffect columnEffect = new ColumnEffect();
	group.add(columnEffect);
	columnEffect.populateFromSettings(mainSettings);
	columnEffect.setFromCurrentValue(true);
	columnEffect.setToValue(1d);
	columnEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel m) { 

		}
	});
	columnEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel m) { 
				__closure.columnInfo = ((ColumnInfo)target);
				__closure.columnInfo.setLeftOffset(0);
				__closure.columnInfo.setLeftPercentOffset(0);
				__closure.columnInfo.setTopOffset(0);
				__closure.grid.refreshLayout();
				return __closure.columnInfo.getLeftOffset();

		}
	});
	__closure.grid.getEffectManager().addColumnEffect(column, columnEffect);
	ColumnCellsEffect columnCellsEffect = new ColumnCellsEffect();
	group.add(columnCellsEffect);
	columnCellsEffect.setIntent(GridEffectMainIntent.POSITION);
	columnCellsEffect.populateFromSettings(mainSettings);
	columnCellsEffect.setFromCurrentValue(true);
	columnCellsEffect.setToValue(1d);
	columnCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel m) { 

		}
	});
	columnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel m) { 
				__closure.cellModel = ((CellModel)target);
				__closure.cellModel.setLeftOffset(0);
				__closure.cellModel.setLeftPercentOffset(0);
				__closure.cellModel.setTopOffset(0);
				__closure.cellModel.setTopPercentOffset(0);
				__closure.cellModel.setContentOpacity(1d);
				return __closure.cellModel.getLeftOffset();

		}
	});
	__closure.grid.getEffectManager().addColumnCellsEffect(column, columnCellsEffect);
}


class __closure_GridAnimationManager_StartActualizationAnimations {
	public int animationId;
	public CellModel c;
	public double fromPercent;
	public double toPercent;
	public ColumnImplementation col;
	public CellModel cellModel;
	public Object resolvedValue;
	public GridImplementation grid;

}

public void startActualizationAnimations(GridImplementation grid, int startIndex, int endIndex) {
final __closure_GridAnimationManager_StartActualizationAnimations __closure = new __closure_GridAnimationManager_StartActualizationAnimations();
__closure.grid = grid;
	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings = _defaultSettings.getCellActualizationMainPhase();
	if (__closure.grid.getColumnAnimationSettings() != null && __closure.grid.getAnimationSettings().getCellActualizationMainPhase() != null) {
		mainSettings = __closure.grid.getAnimationSettings().getCellActualizationMainPhase();
	}

	CellActualizationStyle actualizationStyle = __closure.grid.getCellActualizationAnimationStyle();
	VisualModel model = __closure.grid.getModel();
	GridEffectGroup group = new GridEffectGroup();
	group.setEffectsFinished(com.infragistics.controls.FunctionDelegate.combine(group.getEffectsFinished(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				onAnimationCompleted(__closure.animationId);

		}
	}));
	group.setEffectsCanceled(com.infragistics.controls.FunctionDelegate.combine(group.getEffectsCanceled(), new EventHandler__1<EventArgs>() {
		 public void invoke(Object o, EventArgs e) { 
				onAnimationCanceled(__closure.animationId);

		}
	}));
	for (int i = 0; i < model.getColumns().getCount(); i++) {
		ColumnInfo column = model.getColumns().inner[i];
		ColumnImplementation actualColumn = __closure.grid.getColumnController().getColumnById(column.getUniqueID());
		ColumnCellsEffect columnCellsEffect = new ColumnCellsEffect();
		group.add(columnCellsEffect);
		columnCellsEffect.setIntent(GridEffectMainIntent.VIRTUALIZATION);
		columnCellsEffect.populateFromSettings(mainSettings);
		columnCellsEffect.setFromCurrentValue(true);
		columnCellsEffect.setToValue(0d);
		if (actualizationStyle == CellActualizationStyle.AUTO) {
			actualizationStyle = CellActualizationStyle.CROSS_FADE;
		}

		columnCellsEffect.setTick(new GridEffectTickHandler() {
			 public void invoke(double p, Object from, Object to, Object target, VisualModel m) { 
					__closure.c = (CellModel)target;
					__closure.fromPercent = (Double)from;
					__closure.toPercent = (Double)to;
					if (__closure.c.getPath().getIsContentCell()) {
						__closure.col = __closure.grid.getContainingColumn(__closure.c.getPath());
						if (__closure.grid.getAdapter().isPlaceholderValue(__closure.c.getPath(), __closure.col.getKey())) {
							p = 0d;
						}

					}

					__closure.c.setVirtualizationPercentage(__closure.fromPercent + (__closure.toPercent - __closure.fromPercent) * p);

			}
		});
		columnCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
			 public Object invoke(Object target, VisualModel m) { 
					__closure.cellModel = ((CellModel)target);
					if (__closure.cellModel.getPath().getIsContentCell()) {
						__closure.col = __closure.grid.getContainingColumn(__closure.cellModel.getPath());
						__closure.resolvedValue = __closure.grid.getAdapter().resolveValue(__closure.cellModel.getPath(), __closure.col.getKey());
						__closure.grid.onModelDataRefresh(__closure.cellModel, __closure.resolvedValue);
					}

					return __closure.cellModel.getVirtualizationPercentage();

			}
		});
		columnCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, column.getIndex(), __closure.grid.getModel().getTopRow().getSection(), __closure.grid.getModel().getTopRow().getRow()));
		columnCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, column.getIndex(), __closure.grid.getModel().getBottomRow().getSection(), __closure.grid.getModel().getBottomRow().getRow()));
		if (!__closure.grid.getIsColumnPropertyUpdatingAnimationEnabled()) {
			columnCellsEffect.setDurationMilliseconds(0);
		}

		__closure.grid.getEffectManager().addColumnCellsEffect(column, columnCellsEffect);
	}

}


class __closure_GridAnimationManager_StartRowSelectionAnimation {
	public int animationId;
	public CellModel c;
	public double fromStatus;
	public double toStatus;
	public CellModel cellModel;

}

public void startRowSelectionAnimation(GridImplementation grid, int row) {
final __closure_GridAnimationManager_StartRowSelectionAnimation __closure = new __closure_GridAnimationManager_StartRowSelectionAnimation();
	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings = _defaultSettings.getRowSelectionMainPhase();
	if (grid.getColumnAnimationSettings() != null && grid.getAnimationSettings().getRowSelectionMainPhase() != null) {
		mainSettings = grid.getAnimationSettings().getRowSelectionMainPhase();
	}

	RowSelectionStyle selectionStyle = grid.getRowSelectionAnimationStyle();
	VisualModel model = grid.getModel();
	RowCellsEffect rowCellsEffect = new RowCellsEffect();
	rowCellsEffect.setOnFinished(com.infragistics.controls.FunctionDelegate.combine(rowCellsEffect.getOnFinished(), new GridEffectAnimationOnFinishedHandler() {
		 public void invoke(Object t) { 
				onAnimationCompleted(__closure.animationId);

		}
	}));
	rowCellsEffect.setOnCanceled(com.infragistics.controls.FunctionDelegate.combine(rowCellsEffect.getOnCanceled(), new GridEffectAnimationOnCanceledHandler() {
		 public void invoke(Object t, GridEffect c) { 
				onAnimationCanceled(__closure.animationId);

		}
	}));
	rowCellsEffect.setIntent(GridEffectMainIntent.SELECTION);
	rowCellsEffect.populateFromSettings(mainSettings);
	rowCellsEffect.setFromCurrentValue(true);
	rowCellsEffect.setToValue(1d);
	if (selectionStyle == RowSelectionStyle.AUTO) {
		selectionStyle = RowSelectionStyle.COLOR_BLEND;
	}

	rowCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel m) { 
				__closure.c = (CellModel)target;
				__closure.fromStatus = (Double)from;
				__closure.toStatus = (Double)to;
				if (__closure.c.getPath().getIsContentCell()) {
					__closure.c.setSelectedStatus(__closure.fromStatus + (__closure.toStatus - __closure.fromStatus) * p);

				} else {
					__closure.c.setSelectedStatus(0);
				}


		}
	});
	rowCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel m) { 
				__closure.cellModel = ((CellModel)target);
				return __closure.cellModel.getSelectedStatus();

		}
	});
	RowPath path = grid.getRowPathForAbsoluteRow(row);
	rowCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, grid.getModel().getLeftColumn(), path.getSection(), path.getRow()));
	rowCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, grid.getModel().getRightColumn(), path.getSection(), path.getRow()));
	if (!grid.getIsRowSelectionAnimationEnabled()) {
		rowCellsEffect.setDurationMilliseconds(0);
	}

	grid.getEffectManager().addRowCellsEffect(path, rowCellsEffect);
}


class __closure_GridAnimationManager_StartRowUnselectionAnimation {
	public int animationId;
	public CellModel c;
	public double fromStatus;
	public double toStatus;
	public CellModel cellModel;

}

public void startRowUnselectionAnimation(GridImplementation grid, int row) {
final __closure_GridAnimationManager_StartRowUnselectionAnimation __closure = new __closure_GridAnimationManager_StartRowUnselectionAnimation();
	__closure.animationId = getAnimationId();
	onAnimationCreated(__closure.animationId);
	GridAnimationPhaseSettingsImplementation mainSettings = _defaultSettings.getRowSelectionMainPhase();
	if (grid.getColumnAnimationSettings() != null && grid.getAnimationSettings().getRowSelectionMainPhase() != null) {
		mainSettings = grid.getAnimationSettings().getRowSelectionMainPhase();
	}

	RowSelectionStyle selectionStyle = grid.getRowSelectionAnimationStyle();
	VisualModel model = grid.getModel();
	RowCellsEffect rowCellsEffect = new RowCellsEffect();
	rowCellsEffect.setOnFinished(com.infragistics.controls.FunctionDelegate.combine(rowCellsEffect.getOnFinished(), new GridEffectAnimationOnFinishedHandler() {
		 public void invoke(Object t) { 
				onAnimationCompleted(__closure.animationId);

		}
	}));
	rowCellsEffect.setOnCanceled(com.infragistics.controls.FunctionDelegate.combine(rowCellsEffect.getOnCanceled(), new GridEffectAnimationOnCanceledHandler() {
		 public void invoke(Object t, GridEffect c) { 
				onAnimationCanceled(__closure.animationId);

		}
	}));
	rowCellsEffect.setIntent(GridEffectMainIntent.SELECTION);
	rowCellsEffect.populateFromSettings(mainSettings);
	rowCellsEffect.setFromCurrentValue(true);
	rowCellsEffect.setToValue(0d);
	if (selectionStyle == RowSelectionStyle.AUTO) {
		selectionStyle = RowSelectionStyle.COLOR_BLEND;
	}

	rowCellsEffect.setTick(new GridEffectTickHandler() {
		 public void invoke(double p, Object from, Object to, Object target, VisualModel m) { 
				__closure.c = (CellModel)target;
				__closure.fromStatus = (Double)from;
				__closure.toStatus = (Double)to;
				if (__closure.c.getPath().getIsContentCell()) {
					__closure.c.setSelectedStatus(__closure.fromStatus + (__closure.toStatus - __closure.fromStatus) * p);

				} else {
					__closure.c.setSelectedStatus(0);
				}


		}
	});
	rowCellsEffect.setGetInitialValue(new GridEffectCurrentValueHandler() {
		 public Object invoke(Object target, VisualModel m) { 
				__closure.cellModel = ((CellModel)target);
				return __closure.cellModel.getSelectedStatus();

		}
	});
	RowPath path = grid.getRowPathForAbsoluteRow(row);
	rowCellsEffect.setStartItem(new CellPath(FixedCellPositions.NONE, grid.getModel().getLeftColumn(), path.getSection(), path.getRow()));
	rowCellsEffect.setLastItem(new CellPath(FixedCellPositions.NONE, grid.getModel().getRightColumn(), path.getSection(), path.getRow()));
	if (!grid.getIsRowSelectionAnimationEnabled()) {
		rowCellsEffect.setDurationMilliseconds(0);
	}

	grid.getEffectManager().addRowCellsEffect(path, rowCellsEffect);
}

}
