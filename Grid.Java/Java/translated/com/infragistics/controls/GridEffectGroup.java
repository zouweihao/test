//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


class GridEffectGroup {
private List__1<GridEffect> _finishingGroup;

private int _areFinished;

private boolean _autoReset;

private boolean _hasOneCanceled;

public EventHandler__1<EventArgs> effectsFinished = null;
public void setEffectsFinished(EventHandler__1<EventArgs> __event) {
	effectsFinished = __event;
}
public EventHandler__1<EventArgs> getEffectsFinished() {
	return effectsFinished;
}

public EventHandler__1<EventArgs> effectsCanceled = null;
public void setEffectsCanceled(EventHandler__1<EventArgs> __event) {
	effectsCanceled = __event;
}
public EventHandler__1<EventArgs> getEffectsCanceled() {
	return effectsCanceled;
}

public GridEffectGroup(boolean autoReset) {



		_autoReset = autoReset;
		_finishingGroup = new List__1<GridEffect>(new TypeInfo(GridEffect.class));
		_hasOneCanceled = false;
}

public GridEffectGroup() {


	this(true);
}


public void reset() {
	_hasOneCanceled = false;
	for (int i = 0; i < _finishingGroup.getCount(); i++) {
		_finishingGroup.inner[i].setOnFinished(com.infragistics.controls.FunctionDelegate.remove(_finishingGroup.inner[i].getOnFinished(), new GridEffectAnimationOnFinishedHandler(this, "Infragistics.Controls.Grid.Implementation.GridEffectGroup.Effect_OnFinished") { public void invoke(Object target) { effect_OnFinished(target); } }));
		_finishingGroup.inner[i].setOnCanceled(com.infragistics.controls.FunctionDelegate.remove(_finishingGroup.inner[i].getOnCanceled(), new GridEffectAnimationOnCanceledHandler(this, "Infragistics.Controls.Grid.Implementation.GridEffectGroup.Effect_OnCanceled") { public void invoke(Object target, GridEffect canceledBy) { effect_OnCanceled(target, canceledBy); } }));
	}

	_areFinished = 0;
	_finishingGroup.clear();
}


public void add(GridEffect effect) {
	_finishingGroup.add(effect);
	effect.setOnFinished(com.infragistics.controls.FunctionDelegate.combine(effect.getOnFinished(), new GridEffectAnimationOnFinishedHandler(this, "Infragistics.Controls.Grid.Implementation.GridEffectGroup.Effect_OnFinished") { public void invoke(Object target) { effect_OnFinished(target); } }));
	effect.setOnCanceled(com.infragistics.controls.FunctionDelegate.combine(effect.getOnCanceled(), new GridEffectAnimationOnCanceledHandler(this, "Infragistics.Controls.Grid.Implementation.GridEffectGroup.Effect_OnCanceled") { public void invoke(Object target, GridEffect canceledBy) { effect_OnCanceled(target, canceledBy); } }));
}


private void effect_OnCanceled(Object target, GridEffect canceledBy) {
	_hasOneCanceled = true;
	_areFinished++;
	if (_areFinished == _finishingGroup.getCount()) {
		onEffectsFinished();
	}

}


private void effect_OnFinished(Object target) {
	_areFinished++;
	if (_areFinished == _finishingGroup.getCount()) {
		onEffectsFinished();
	}

}


protected void onEffectsFinished() {
	if (_hasOneCanceled) {
		if (getEffectsCanceled() != null) {
			getEffectsCanceled().invoke(this, new EventArgs());
		}


	} else {
		if (getEffectsFinished() != null) {
			getEffectsFinished().invoke(this, new EventArgs());
		}

	}

	if (_autoReset) {
		reset();
	}

}

}
