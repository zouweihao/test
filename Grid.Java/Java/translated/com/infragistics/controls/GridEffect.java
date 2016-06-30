//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

abstract class GridEffect {
public GridEffect() {



}


public void notifyFinished() {
	if (getOnFinished() != null) {
		getOnFinished().invoke(this);
	}

}


public void notifyCanceled(GridEffect canceledBy) {
	if (getOnCanceled() != null) {
		getOnCanceled().invoke(this, canceledBy);
	}

}

private GridEffectMainIntent _intent = GridEffectMainIntent.DEFAULT;


public GridEffectMainIntent setIntent(GridEffectMainIntent value) {

	_intent = value;
return value;
}
public GridEffectMainIntent getIntent() {

		return _intent;

}


public boolean intentsMatchForCancel(GridEffect other) {
	if (other == null) {
		return false;
	}

	if (other._intent != _intent) {
		return false;
	}

	if (!_subIntentMustMatchToCancel) {
		return true;
	}

	if (other._subIntent != _subIntent) {
		return false;
	}

	if (com.infragistics.controls.StringHelper.areNotEqual(other._subIntentModifier, _subIntentModifier)) {
		return false;
	}

	return true;
}

private GridEffectSubIntent _subIntent = GridEffectSubIntent.DEFAULT;


public GridEffectSubIntent setSubIntent(GridEffectSubIntent value) {

	_subIntent = value;
return value;
}
public GridEffectSubIntent getSubIntent() {

		return _subIntent;

}

private String _subIntentModifier = "";


public String setSubIntentModifier(String value) {

	_subIntentModifier = value;
return value;
}
public String getSubIntentModifier() {

		return _subIntentModifier;

}

private boolean _subIntentMustMatchToCancel = false;


public boolean setSubIntentMustMatchToCancel(boolean value) {

	_subIntentMustMatchToCancel = value;
return value;
}
public boolean getSubIntentMustMatchToCancel() {

		return _subIntentMustMatchToCancel;

}

private boolean _markFinished = false;


public boolean setMarkFinished(boolean value) {

	_markFinished = value;
return value;
}
public boolean getMarkFinished() {

		return _markFinished;

}

public GridEffectAnimationOnFinishedHandler onFinished = null;
public void setOnFinished(GridEffectAnimationOnFinishedHandler __event) {
	onFinished = __event;
}
public GridEffectAnimationOnFinishedHandler getOnFinished() {
	return onFinished;
}

public GridEffectAnimationOnCanceledHandler onCanceled = null;
public void setOnCanceled(GridEffectAnimationOnCanceledHandler __event) {
	onCanceled = __event;
}
public GridEffectAnimationOnCanceledHandler getOnCanceled() {
	return onCanceled;
}

private int _durationMilliseconds = 0;

private int _adjustedDuration = 0;


public int setDurationMilliseconds(int value) {

	_durationMilliseconds = value;
	_adjustedDuration = value;
return value;
}
public int getDurationMilliseconds() {

		return _durationMilliseconds;

}

private GridEffectAnimationDelayForItemHandler _animationDelayForItem = null;


public GridEffectAnimationDelayForItemHandler setAnimationDelayForItem(GridEffectAnimationDelayForItemHandler value) {

	_animationDelayForItem = value;
return value;
}
public GridEffectAnimationDelayForItemHandler getAnimationDelayForItem() {

		return _animationDelayForItem;

}

private int _perItemDelayMilliseconds = -1;


public int setPerItemDelayMilliseconds(int value) {

	_perItemDelayMilliseconds = value;
return value;
}
public int getPerItemDelayMilliseconds() {

		return _perItemDelayMilliseconds;

}

private int _subItemDurationMilliseconds = -1;


public int setSubItemDurationMilliseconds(int value) {

	_subItemDurationMilliseconds = value;
return value;
}
public int getSubItemDurationMilliseconds() {

		return _subItemDurationMilliseconds;

}

private int _desiredSubItemDurationMilliseconds = 300;


public int setDesiredSubItemDurationMilliseconds(int value) {

	_desiredSubItemDurationMilliseconds = value;
return value;
}
public int getDesiredSubItemDurationMilliseconds() {

		return _desiredSubItemDurationMilliseconds;

}

private GridEffectAnimationDurationForItemHandler _animationDurationForItem = null;


public GridEffectAnimationDurationForItemHandler setAnimationDurationForItem(GridEffectAnimationDurationForItemHandler value) {

	_animationDurationForItem = value;
return value;
}
public GridEffectAnimationDurationForItemHandler getAnimationDurationForItem() {

		return _animationDurationForItem;

}

private int _holdInitialMilliseconds = 0;


public int setHoldInitialMilliseconds(int value) {

	_holdInitialMilliseconds = value;
return value;
}
public int getHoldInitialMilliseconds() {

		return _holdInitialMilliseconds;

}

private CellPath _startItem;


public CellPath setStartItem(CellPath value) {

	_startItem = value;
return value;
}
public CellPath getStartItem() {

		return _startItem;

}

private CellPath _lastItem;


public CellPath setLastItem(CellPath value) {

	_lastItem = value;
return value;
}
public CellPath getLastItem() {

		return _lastItem;

}

private int _numberOfItems = -1;


public int setNumberOfItems(int value) {

	_numberOfItems = value;
return value;
}
public int getNumberOfItems() {

		return _numberOfItems;

}

private boolean _shouldItemsFinishSimultaneously = false;


public boolean setShouldItemsFinishSimultaneously(boolean value) {

	_shouldItemsFinishSimultaneously = value;
return value;
}
public boolean getShouldItemsFinishSimultaneously() {

		return _shouldItemsFinishSimultaneously;

}

private boolean _isItemDelayInverted = false;


public boolean setIsItemDelayInverted(boolean value) {

	_isItemDelayInverted = value;
return value;
}
public boolean getIsItemDelayInverted() {

		return _isItemDelayInverted;

}

private long _startTime = -1;


public long setStartTime(long value) {

	_startTime = value;
return value;
}
public long getStartTime() {

		return _startTime;

}

private Object _fromValue = null;


public Object setFromValue(Object value) {

	_fromValue = value;
return value;
}
public Object getFromValue() {

		return _fromValue;

}

private Object _toValue = null;


public Object setToValue(Object value) {

	_toValue = value;
return value;
}
public Object getToValue() {

		return _toValue;

}

private GridEffectTickHandler _tick = null;


public GridEffectTickHandler setTick(GridEffectTickHandler value) {

	_tick = value;
return value;
}
public GridEffectTickHandler getTick() {

		return _tick;

}

private GridEffectEasingFunction _easingFunction = null;


public GridEffectEasingFunction setEasingFunction(GridEffectEasingFunction value) {

	_easingFunction = value;
return value;
}
public GridEffectEasingFunction getEasingFunction() {

		return _easingFunction;

}

private boolean _fromCurrentValue = false;


public boolean setFromCurrentValue(boolean value) {

	_fromCurrentValue = value;
return value;
}
public boolean getFromCurrentValue() {

		return _fromCurrentValue;

}

private GridEffectCurrentValueHandler _getInitialValue;


public GridEffectCurrentValueHandler setGetInitialValue(GridEffectCurrentValueHandler value) {

	_getInitialValue = value;
return value;
}
public GridEffectCurrentValueHandler getGetInitialValue() {

		return _getInitialValue;

}

private boolean _shouldWaitTillAfterHold = false;


public boolean setShouldWaitTillAfterHold(boolean value) {

	_shouldWaitTillAfterHold = value;
return value;
}
public boolean getShouldWaitTillAfterHold() {

		return _shouldWaitTillAfterHold;

}


public void populateFromSettings(GridAnimationPhaseSettingsImplementation settings) {
	setDurationMilliseconds(settings.getDurationMilliseconds());
	setHoldInitialMilliseconds(settings.getHoldInitialMilliseconds());
	setPerItemDelayMilliseconds(settings.getPerItemDelayMilliseconds());
	setSubItemDurationMilliseconds(settings.getSubItemDurationMilliseconds());
	setShouldItemsFinishSimultaneously(settings.getShouldItemsFinishSimultaneously());
	setEasingFunction(getEasingFunction(settings.getEasingFunctionType()));
}


private GridEffectEasingFunction getEasingFunction(GridEasingFunctionType gridEasingFunctionType) {
	switch (gridEasingFunctionType) {
		case LINEAR:
			return null;
		case CUBIC_IN_OUT:
			return new GridEffectEasingFunction(EasingFunctions.class, "Infragistics.EasingFunctions.CubicEase") { public double invoke(double progress) { return EasingFunctions.cubicEase(progress); } };
		case CIRCLE_IN_OUT:
			return new GridEffectEasingFunction(EasingFunctions.class, "Infragistics.EasingFunctions.CircleEase") { public double invoke(double progress) { return EasingFunctions.circleEase(progress); } };
		case EXPONENTIAL_IN_OUT:
			return new GridEffectEasingFunction(EasingFunctions.class, "Infragistics.EasingFunctions.ExponentialEase") { public double invoke(double progress) { return EasingFunctions.exponentialEase(progress); } };
	}

	return null;
}

private Dictionary__2<Object, Object> _fromValues = null;


public boolean tickForColumn(ColumnInfo column, VisualModel model, GridLayerController controller, long currentTime) {
	if (getShouldWaitTillAfterHold() && isDuringHold(currentTime)) {
		return false;
	}

	double elapsedTime = getElapsedTime(currentTime);
	double progress = elapsedTime / (double)_durationMilliseconds;
	boolean finished = false;
	if (_tick == null) {
		return true;
	}

	if (progress >= 1d) {
		progress = 1d;
		finished = true;
	}

	if (_easingFunction != null) {
		progress = _easingFunction.invoke(progress);
	}

	Object fromValue = resolveFromValue(_fromValue, model, column, column.getUniqueID());
	_tick.invoke(progress, fromValue, _toValue, column, model);
	return finished;
}


public boolean tickForObject(Object spacer, VisualModel model, GridLayerController controller, long currentTime) {
	if (getShouldWaitTillAfterHold() && isDuringHold(currentTime)) {
		return false;
	}

	double elapsedTime = getElapsedTime(currentTime);
	double progress = elapsedTime / (double)_durationMilliseconds;
	boolean finished = false;
	if (_tick == null) {
		return true;
	}

	if (progress >= 1d) {
		progress = 1d;
		finished = true;
	}

	if (_easingFunction != null) {
		progress = _easingFunction.invoke(progress);
	}

	Object fromValue = resolveFromValue(_fromValue, model, spacer, spacer);
	_tick.invoke(progress, fromValue, _toValue, spacer, model);
	return finished;
}


private double getElapsedTime(long currentTime) {
	int elapsedTime = (int)(currentTime - _startTime);
	if (_holdInitialMilliseconds > 0) {
		if (elapsedTime < _holdInitialMilliseconds) {
			elapsedTime = 0;

		} else {
			elapsedTime -= _holdInitialMilliseconds;
		}

	}

	return (double)elapsedTime;
}


private boolean isDuringHold(long currentTime) {
	int elapsedTime = (int)(currentTime - _startTime);
	if (_holdInitialMilliseconds > 0) {
		if (elapsedTime < _holdInitialMilliseconds) {
			return true;
		}

	}

	return false;
}


public void updateTimeExpansion(CellPath cellPath, VisualModel model, GridLayerController controller, long currentTime) {
	int cellIndex = getAbsoluteIndex(model, cellPath);
	if (getMaxSeenItem() == null) {
		return;
	}

	int absoluteIndex = getAbsoluteIndex(model, getMaxSeenItem());
	double ratio = (double)absoluteIndex / (double)_numberOfItems;
	if (ratio > 5d) {
		ratio = 5d;
	}

	if (ratio == _lastRatio) {
		return;
	}

	double deltaRatio = ratio / _lastRatio;
	_lastRatio = ratio;
	int newDuration = (int)java.lang.Math.round((double)_adjustedDuration * deltaRatio);
	if (newDuration <= 0) {
		int a = 0;
		a += 1;
	}

		_adjustedDuration = newDuration;

}


public boolean tickForCell(CellModel cell, VisualModel model, GridLayerController controller, long currentTime) {
	boolean finished = false;
	if (cell.getPath().getRow() == 15) {
		int a = 0;
		a += 1;
	}

	updateTimeExpansion(cell.getPath(), model, controller, currentTime);
	if (getShouldWaitTillAfterHold() && isDuringHold(currentTime)) {
		return false;
	}

	double elapsedTime = getElapsedTime(currentTime);
	double startDelay = (double)getStartDelayForItem(model, controller, cell.getPath(), currentTime);
	double duration = (double)getDurationForItem(model, controller, cell.getPath(), currentTime);
	if (duration < 300) {
		int a1 = 0;
		a1 += 1;
	}

	double relativeTime = elapsedTime - startDelay;
	if (relativeTime < 0) {
		relativeTime = 0;
	}

	double progress = relativeTime / duration;
	if (progress >= 1d) {
		progress = 1d;
		finished = true;
	}

	if (_easingFunction != null) {
		progress = _easingFunction.invoke(progress);
	}

	Object fromValue = resolveFromValue(_fromValue, model, cell, cell.getPath());
	_tick.invoke(progress, fromValue, _toValue, cell, model);
	return finished;
}

private double _lastRatio = 1d;


public void updateFromValue(Object fromValue, VisualModel model, Object item) {
	if (_fromValues == null) {
		_fromValues = new Dictionary__2<Object, Object>(new TypeInfo(Object.class), new TypeInfo(Object.class));
	}

	_fromValues.setItem(item, fromValue);
}


private Object resolveFromValue(Object fromValue, VisualModel model, Object item, Object key) {
	if (getFromCurrentValue()) {
		if (_fromValues == null) {
			_fromValues = new Dictionary__2<Object, Object>(new TypeInfo(Object.class), new TypeInfo(Object.class));
		}

		if (_fromValues.containsKey(key)) {
			return _fromValues.getItem(key);
		}

		Object value = getGetInitialValue().invoke(item, model);
		_fromValues.setItem(key, value);
		return value;

	} else {
		return _fromValue;
	}

}


public boolean tickForRowSection(SectionInfo sectionInfo, VisualModel model, GridLayerController controller, long currentTime) {
	if (getShouldWaitTillAfterHold() && isDuringHold(currentTime)) {
		return false;
	}

	double elapsedTime = getElapsedTime(currentTime);
	double progress = elapsedTime / (double)_durationMilliseconds;
	boolean finished = false;
	if (_tick == null) {
		return true;
	}

	if (progress >= 1d) {
		progress = 1d;
		finished = true;
	}

	if (_easingFunction != null) {
		progress = _easingFunction.invoke(progress);
	}

	_tick.invoke(progress, _fromValue, _toValue, sectionInfo, model);
	return finished;
}


public boolean appliesToCell(CellPath path, VisualModel model) {
	return false;
}


public boolean appliesToColumn(ColumnInfo column, VisualModel model) {
	return false;
}


public boolean appliesToRow(RowPath path, VisualModel model) {
	return false;
}


public boolean appliesToSpacer(GridColumnSpacer spacer, VisualModel model) {
	return false;
}


public void onRowInsertedAt(RowPath path) {
}


public void onRowRemovedAt(RowPath path) {
}

private int _maxAbsoluteIndex = -1;

private CellPath _maxSeenItem;


protected CellPath getMaxSeenItem() {

		return _maxSeenItem;

}


public int getStartDelayForItem(VisualModel model, GridLayerController controller, CellPath item, long currentTime) {
	int absoluteIndex = getAbsoluteIndex(model, item);
	int maxCount = getMaxCountForItem(model, controller, item, currentTime);
	int duration = _durationMilliseconds;
	if (_shouldItemsFinishSimultaneously) {
		duration = (int)(((double)maxCount / (double)_numberOfItems) * (double)duration);
	}

	int perItemDelay = _perItemDelayMilliseconds;
	if (perItemDelay == -1) {
		perItemDelay = (int)((double)duration / (double)maxCount);
		if ((duration - (int)((double)maxCount * (double)perItemDelay)) < _desiredSubItemDurationMilliseconds) {
			perItemDelay = (int)((double)(duration - _desiredSubItemDurationMilliseconds) / (double)maxCount);
		}

		if (perItemDelay < 0) {
			perItemDelay = 0;
		}

	}

	int delay = perItemDelay * absoluteIndex;
	if (_animationDelayForItem != null) {
		delay = _animationDelayForItem.invoke(_startItem, _numberOfItems, item);
	}

	int trueMax = _adjustedDuration;
	if (delay < (trueMax * -1)) {
		delay = (trueMax * -1);
	}

	if (delay > (trueMax)) {
		delay = trueMax - _desiredSubItemDurationMilliseconds;
	}

	if (_shouldItemsFinishSimultaneously && getElapsedTime(currentTime) > delay && item != null && !_cachedMaxCounts.containsKey(item)) {
		_cachedMaxCounts.add(item, maxCount);
	}

	return delay;
}

private Dictionary__2<CellPath, Integer> _cachedMaxCounts = new Dictionary__2<CellPath, Integer>(new TypeInfo(CellPath.class), new TypeInfo(Integer.class));


private int getMaxCountForItem(VisualModel model, GridLayerController controller, CellPath item, long currentTime) {
	if (getMaxSeenItem() == null || !_shouldItemsFinishSimultaneously) {
		return _numberOfItems;
	}

	if (_cachedMaxCounts.containsKey(item)) {
		return _cachedMaxCounts.getItem(item);
	}

	int maxCount = getAbsoluteIndex(model, getMaxSeenItem());
	return maxCount;
}


private int getAbsoluteIndex(VisualModel model, CellPath item) {
	int relativeIndex = getRelativeIndex(model, item);
	if (_numberOfItems == -1) {
		_numberOfItems = getRelativeIndex(model, _lastItem);
	}

	if (_isItemDelayInverted) {
		relativeIndex = ((_numberOfItems - 1) - relativeIndex);
	}

	int absoluteIndex = relativeIndex;
	if (absoluteIndex > _numberOfItems && absoluteIndex > _maxAbsoluteIndex) {
		_maxAbsoluteIndex = absoluteIndex;
		_maxSeenItem = item;
	}

	return absoluteIndex;
}


public int getRelativeIndex(VisualModel model, CellPath item) {
	return 0;
}


public int getDurationForItem(VisualModel model, GridLayerController controller, CellPath item, long currentTime) {
	int duration = _adjustedDuration;
	if (_animationDurationForItem != null) {
		if (_numberOfItems == -1) {
			_numberOfItems = getRelativeIndex(model, _lastItem);
		}

		duration = _animationDurationForItem.invoke(_startItem, _numberOfItems, item);

	} else {
		if (_subItemDurationMilliseconds == -1) {
			if (_shouldItemsFinishSimultaneously) {
				int maxCount = getMaxCountForItem(model, controller, item, currentTime);
				duration = _durationMilliseconds;
				duration = (int)(((double)maxCount / (double)_numberOfItems) * (double)duration);
				duration = duration - getStartDelayForItem(model, controller, item, currentTime);

			} else {
				if (_isItemDelayInverted) {
					duration = _durationMilliseconds - getStartDelayForItem(model, controller, getTrueStart(model), currentTime);

				} else {
					duration = _durationMilliseconds - getStartDelayForItem(model, controller, _lastItem, currentTime);
				}

			}


		} else {
			duration = _subItemDurationMilliseconds;
		}

	}

	return duration;
}


protected CellPath getTrueStart(VisualModel model) {
	return _startItem;
}


protected RowPath modifyRowForInsertion(RowPath toModify, RowPath insertedRow) {
	if (insertedRow.getSection() == toModify.getSection()) {
		if (insertedRow.getRow() <= toModify.getRow()) {
			toModify = (RowPath)toModify.clone();
			toModify.setRow(toModify.getRow() + 1);
		}

	}

	return toModify;
}


protected RowPath modifyRowForRemoval(RowPath toModify, RowPath removedRow) {
	if (removedRow.getSection() == toModify.getSection()) {
		if (removedRow.getRow() < toModify.getRow()) {
			toModify = (RowPath)toModify.clone();
			toModify.setRow(toModify.getRow() - 1);
		}

	}

	return toModify;
}


public boolean durationHasElapsed(VisualModel model, GridLayerController controller, long currentTime) {
	double elapsed = getElapsedTime(currentTime);
	return elapsed >= _adjustedDuration;
}

}
