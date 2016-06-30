//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class GridEffectManager {
private ITickProvider _tickProvider;

private boolean _isTicking = false;


protected ITickProvider getTickProvider() {

		return _tickProvider;

}

public GridEffectManager(ITickProvider tickProvider, GridImplementation owner) {



		_tickProvider = tickProvider;
		setOwner(owner);
}


public void onRowInsertedAt(RowPath row) {
	for (int i = 0; i < _rowCellsEffects.getCount(); i++) {
		_rowCellsEffects.inner[i].onRowInsertedAt(row);
	}

	for (int i1 = 0; i1 < _rowEffects.getCount(); i1++) {
		_rowEffects.inner[i1].onRowInsertedAt(row);
	}

}


public void onRowRemovedAt(RowPath row) {
	for (int i = 0; i < _rowCellsEffects.getCount(); i++) {
		_rowCellsEffects.inner[i].onRowRemovedAt(row);
	}

	for (int i1 = 0; i1 < _rowEffects.getCount(); i1++) {
		_rowEffects.inner[i1].onRowRemovedAt(row);
	}

}

private List__1<ColumnEffect> _columnEffects = new List__1<ColumnEffect>(new TypeInfo(ColumnEffect.class));

private List__1<ColumnCellsEffect> _columnCellsEffects = new List__1<ColumnCellsEffect>(new TypeInfo(ColumnCellsEffect.class));

private List__1<RowEffect> _rowEffects = new List__1<RowEffect>(new TypeInfo(RowEffect.class));

private List__1<RowCellsEffect> _rowCellsEffects = new List__1<RowCellsEffect>(new TypeInfo(RowCellsEffect.class));

private List__1<CellEffect> _cellEffects = new List__1<CellEffect>(new TypeInfo(CellEffect.class));

private List__1<SpacerEffect> _spacerEffects = new List__1<SpacerEffect>(new TypeInfo(SpacerEffect.class));

private long lastRenderTime = -30;

private int _tickId = -1;


private GridImplementation _owner;
public GridImplementation setOwner(GridImplementation value) {
_owner = value;
return value;
}
public GridImplementation getOwner() {
	return _owner;
}


private void normalTick() {
	boolean hasColumnEffects = _columnEffects.getCount() > 0;
	tick(false);
	if (hasColumnEffects) {
		getOwner().getSpatialEngine().invalidateColumnWidths(getOwner(), getOwner().getModel(), (int)getOwner().getAvailableWidth());
		forceTickColumns();
	}

	getOwner().getRenderingEngine().invalidateVisibility(new Action() {
		 public void invoke() { 
			getOwner().getVisibilityEngine().calculate(getOwner());
		}
	});
	getOwner().getRenderingEngine().refresh(getOwner().getModel(), false);
}


public boolean forceTickColumns() {
	boolean hasColumnEffects = _columnEffects.getCount() > 0;
	long currentTime = getCurrentTime();
	VisualModel model = getOwner().getModel();
	GridLayerController controller = getOwner().getGridLayerController();
	tickColumnEffects(currentTime, model, controller);
	return hasColumnEffects;
}


public void forceTickRows() {
	long currentTime = getCurrentTime();
	VisualModel model = getOwner().getModel();
	GridLayerController controller = getOwner().getGridLayerController();
	tickRowEffects(currentTime, model, controller);
}


public void forceTickCells() {
	long currentTime = getCurrentTime();
	VisualModel model = getOwner().getModel();
	GridLayerController controller = getOwner().getGridLayerController();
	tickCellEffects(currentTime, model, controller);
}


public void tick(boolean force) {
	long currentTime = getCurrentTime();
	if ((currentTime - lastRenderTime < 15) && !force) {
		_tickProvider.requestFrame(_tickId);
		return;
	}

	VisualModel model = getOwner().getModel();
	GridLayerController controller = getOwner().getGridLayerController();
	boolean done = true;
	if (!tickColumnEffects(currentTime, model, controller)) {
		done = false;
	}

	if (!tickSpacerEffects(currentTime, model, controller)) {
		done = false;
	}

	if (!tickRowEffects(currentTime, model, controller)) {
		done = false;
	}

	if (!tickCellEffects(currentTime, model, controller)) {
		done = false;
	}

	if (done && _columnEffects.getCount() == 0 && _columnCellsEffects.getCount() == 0 && _cellEffects.getCount() == 0 && _rowEffects.getCount() == 0 && _rowCellsEffects.getCount() == 0 && _spacerEffects.getCount() == 0) {
		teardownTicking();

	} else {
		_tickProvider.requestFrame(_tickId);
	}

}


private long getCurrentTime() {
	java.util.Calendar time = java.util.Calendar.getInstance();
	return time.getTime().getTime();
}


private void teardownTicking() {
	Debug.writeLine("finished ticking");
	_tickProvider.teardownTicking(_tickId);
	_tickId = -1;
}


private void ensureTicking() {
	if (_tickId == -1) {
		_tickId = _tickProvider.setupTicking(new Action(this, "Infragistics.Controls.Grid.Implementation.GridEffectManager.NormalTick") { public void invoke() { normalTick(); } });
		_tickProvider.requestFrame(_tickId);
	}

}


public void addColumnEffect(ColumnInfo column, ColumnEffect effect) {
	effect.setColumnId(column.getUniqueID());
	effect.setStartTime(getCurrentTime());
	removeColumnEffect(column.getUniqueID(), true, effect);
	_columnEffects.add(effect);
	ensureTicking();
}


public void removeColumnEffect(long columnId, boolean isCancel, GridEffect canceledBy) {
	for (int i = _columnEffects.getCount() - 1; i >= 0; i--) {
		if (_columnEffects.inner[i].getColumnId() == columnId && _columnEffects.inner[i].intentsMatchForCancel(canceledBy)) {
			if (isCancel) {
				_columnEffects.inner[i].notifyCanceled(canceledBy);
			}

			_columnEffects.removeAt(i);
		}

	}

}


public void addSpacerEffect(GridColumnSpacer spacer, SpacerEffect effect) {
	effect.setSpacerId(spacer.getUniqueId());
	effect.setStartTime(getCurrentTime());
	removeSpacerEffect(spacer, true, effect);
	_spacerEffects.add(effect);
	ensureTicking();
}


public void removeSpacerEffect(GridColumnSpacer spacer, boolean isCancel, GridEffect canceledBy) {
	for (int i = _spacerEffects.getCount() - 1; i >= 0; i--) {
		if (_spacerEffects.inner[i].getSpacerId() == spacer.getUniqueId() && _spacerEffects.inner[i].intentsMatchForCancel(canceledBy)) {
			if (isCancel) {
				_spacerEffects.inner[i].notifyCanceled(canceledBy);
			}

			_spacerEffects.removeAt(i);
		}

	}

}


public void addColumnCellsEffect(ColumnInfo column, ColumnCellsEffect effect) {
	effect.setColumnId(column.getUniqueID());
	effect.setStartTime(getCurrentTime());
	removeColumnCellsEffect(column.getUniqueID(), true, effect);
	_columnCellsEffects.add(effect);
	ensureTicking();
}


public void removeColumnCellsEffect(long columnId, boolean isCancel, GridEffect canceledBy) {
	for (int i = _columnCellsEffects.getCount() - 1; i >= 0; i--) {
		if (_columnCellsEffects.inner[i].getColumnId() == columnId && _columnCellsEffects.inner[i].intentsMatchForCancel(canceledBy)) {
			if (isCancel) {
				_columnCellsEffects.inner[i].notifyCanceled(canceledBy);
			}

			_columnCellsEffects.removeAt(i);
		}

	}

}


public void addRowEffect(RowPath row, RowEffect effect) {
	effect.setPath(row);
	effect.setStartTime(getCurrentTime());
	removeRowEffect(row, true, effect);
	_rowEffects.add(effect);
	ensureTicking();
}


public void removeRowEffect(RowPath row, boolean isCancel, GridEffect canceledBy) {
	for (int i = _rowEffects.getCount() - 1; i >= 0; i--) {
		if (_rowEffects.inner[i].getPath().equals(row) && _rowEffects.inner[i].intentsMatchForCancel(canceledBy)) {
			if (isCancel) {
				_rowEffects.inner[i].notifyCanceled(canceledBy);
			}

			_rowEffects.removeAt(i);
		}

	}

}


public void addRowCellsEffect(RowPath row, RowCellsEffect effect) {
	effect.setPath(row);
	effect.setStartTime(getCurrentTime());
	removeRowCellsEffect(row, true, effect);
	_rowCellsEffects.add(effect);
	ensureTicking();
}


public void removeRowCellsEffect(RowPath row, boolean isCancel, GridEffect canceledBy) {
	for (int i = _rowCellsEffects.getCount() - 1; i >= 0; i--) {
		if (_rowCellsEffects.inner[i].getPath().equals(row) && _rowCellsEffects.inner[i].intentsMatchForCancel(canceledBy)) {
			if (isCancel) {
				_rowCellsEffects.inner[i].notifyCanceled(canceledBy);
			}

			_rowCellsEffects.removeAt(i);
		}

	}

}


public void addCellEffect(CellPath cell, CellEffect effect) {
	effect.setPath(cell);
	effect.setStartTime(getCurrentTime());
	removeCellEffect(cell, true, effect);
	_cellEffects.add(effect);
	ensureTicking();
}


public void removeCellEffect(CellPath cell, boolean isCancel, GridEffect canceledBy) {
	for (int i = _cellEffects.getCount() - 1; i >= 0; i--) {
		if (_cellEffects.inner[i].getPath().equals(cell) && _cellEffects.inner[i].intentsMatchForCancel(canceledBy)) {
			if (isCancel) {
				_cellEffects.inner[i].notifyCanceled(canceledBy);
			}

			_cellEffects.removeAt(i);
		}

	}

}


public boolean tickColumnEffects(long currentTime, VisualModel model, GridLayerController controller) {
	boolean done = true;
	ColumnInfo column;
	ColumnEffect columnEffect;
	List__1<ColumnEffect> finishedEffects = new List__1<ColumnEffect>(new TypeInfo(ColumnEffect.class));
	for (int j = 0; j < _columnEffects.getCount(); j++) {
		if (model.getColumnById(_columnEffects.inner[j].getColumnId()) == null) {
			removeColumnEffect(_columnEffects.inner[j].getColumnId(), false, _columnEffects.inner[j]);
		}

	}

	for (int i = 0; i < model.getColumns().getCount(); i++) {
		column = model.getColumns().inner[i];
		for (int j1 = 0; j1 < _columnEffects.getCount(); j1++) {
			columnEffect = _columnEffects.inner[j1];
			if (columnEffect.appliesToColumn(column, model)) {
				if (!columnEffect.tickForColumn(column, model, controller, currentTime)) {
					done = false;

				} else {
					finishedEffects.add(columnEffect);
				}

			}

		}

	}

	for (int i1 = 0; i1 < finishedEffects.getCount(); i1++) {
		removeColumnEffect(finishedEffects.inner[i1].getColumnId(), false, finishedEffects.inner[i1]);
		finishedEffects.inner[i1].notifyFinished();
	}

	return done;
}


public boolean tickSpacerEffects(long currentTime, VisualModel model, GridLayerController controller) {
	boolean done = true;
	List__1<GridColumnSpacerCollection> spacers = model.getSpacers();
	List__1<GridColumnSpacer> finishedSpacers = new List__1<GridColumnSpacer>(new TypeInfo(GridColumnSpacer.class));
	List__1<SpacerEffect> finishedEffects = new List__1<SpacerEffect>(new TypeInfo(SpacerEffect.class));
	for (int i = 0; i < spacers.getCount(); i++) {
		GridColumnSpacerCollection spacerCollection = spacers.inner[i];
		for (int j = 0; j < spacerCollection.getCount(); j++) {
			GridColumnSpacer currSpacer = spacerCollection.inner[j];
			for (int k = 0; k < _spacerEffects.getCount(); k++) {
				if (_spacerEffects.inner[k].appliesToSpacer(currSpacer, model)) {
					if (!_spacerEffects.inner[k].tickForObject(currSpacer, model, controller, currentTime)) {
						done = false;

					} else {
						finishedSpacers.add(currSpacer);
						finishedEffects.add(_spacerEffects.inner[k]);
					}

				}

			}

		}

	}

	for (int i1 = 0; i1 < finishedSpacers.getCount(); i1++) {
		removeSpacerEffect(finishedSpacers.inner[i1], false, finishedEffects.inner[i1]);
		finishedEffects.inner[i1].notifyFinished();
	}

	return done;
}


public boolean tickRowEffects(long currentTime, VisualModel model, GridLayerController controller) {
	boolean done = true;
	CellPath path = new CellPath(0, 0, 0);
	RowEffect rowEffect;
	for (int i = 0; i < _rowEffects.getCount(); i++) {
		rowEffect = _rowEffects.inner[i];
		path.setFixedPosition(rowEffect.getPath().getFixedPosition());
		path.setRow(rowEffect.getPath().getRow());
		path.setSection(rowEffect.getPath().getSection());
		if (!rowEffect.tickForRowSection(model.getSections().inner[path.getSection()], model, controller, currentTime)) {
			done = false;
		}

	}

	return done;
}


public boolean tickCellEffects(long currentTime, VisualModel model, GridLayerController controller) {
	boolean done = true;
	if (_columnCellsEffects.getCount() == 0 && _rowCellsEffects.getCount() == 0 && _cellEffects.getCount() == 0) {
		return true;
	}

	for (int v = 0; v < _columnCellsEffects.getCount(); v++) {
		_columnCellsEffects.inner[v].setMarkFinished(true);
	}

	for (int x = 0; x < _rowCellsEffects.getCount(); x++) {
		_rowCellsEffects.inner[x].setMarkFinished(true);
	}

	for (int y = 0; y < _cellEffects.getCount(); y++) {
		_cellEffects.inner[y].setMarkFinished(true);
	}

	for (int i = 0; i < model.getGridLayers().getCount(); i++) {
		GridLayer currLayer = model.getGridLayers().inner[i];
		for (int p = 0; p < currLayer.getKeyList().getCount(); p++) {
			if (currLayer.getRemovedList().inner[p]) {
				continue;
			}

			CellPath currKey = currLayer.getKeyList().inner[p];
			for (int k = 0; k < _columnCellsEffects.getCount(); k++) {
				ColumnCellsEffect columnCellsEffect = _columnCellsEffects.inner[k];
				if (columnCellsEffect.appliesToCell(currKey, model)) {
					if (!columnCellsEffect.tickForCell(currLayer.getValueList().inner[p], model, controller, currentTime)) {
						columnCellsEffect.setMarkFinished(false);
					}

				}

			}

			for (int k1 = 0; k1 < _rowCellsEffects.getCount(); k1++) {
				RowCellsEffect rowCellsEffect = _rowCellsEffects.inner[k1];
				if (rowCellsEffect.appliesToCell(currKey, model)) {
					if (!rowCellsEffect.tickForCell(currLayer.getValueList().inner[p], model, controller, currentTime)) {
						rowCellsEffect.setMarkFinished(false);
					}

				}

			}

			for (int k2 = 0; k2 < _cellEffects.getCount(); k2++) {
				CellEffect cellEffect = _cellEffects.inner[k2];
				if (cellEffect.appliesToCell(currKey, model)) {
					if (!cellEffect.tickForCell(currLayer.getValueList().inner[p], model, controller, currentTime)) {
						cellEffect.setMarkFinished(false);
					}

				}

			}

		}

	}

	List__1<ColumnCellsEffect> finishedColumnCellEffects = new List__1<ColumnCellsEffect>(new TypeInfo(ColumnCellsEffect.class));
	for (int n = 0; n < _columnCellsEffects.getCount(); n++) {
		if (_columnCellsEffects.inner[n].durationHasElapsed(model, controller, currentTime) && _columnCellsEffects.inner[n].getMarkFinished()) {
			finishedColumnCellEffects.add(_columnCellsEffects.inner[n]);

		} else {
			done = false;
		}

	}

	List__1<RowCellsEffect> finishedRowCellEffects = new List__1<RowCellsEffect>(new TypeInfo(RowCellsEffect.class));
	for (int p1 = 0; p1 < _rowCellsEffects.getCount(); p1++) {
		if (_rowCellsEffects.inner[p1].durationHasElapsed(model, controller, currentTime) && _rowCellsEffects.inner[p1].getMarkFinished()) {
			finishedRowCellEffects.add(_rowCellsEffects.inner[p1]);

		} else {
			done = false;
		}

	}

	List__1<CellEffect> finishedCellEffects = new List__1<CellEffect>(new TypeInfo(CellEffect.class));
	for (int q = 0; q < _cellEffects.getCount(); q++) {
		if (_cellEffects.inner[q].durationHasElapsed(model, controller, currentTime) && _cellEffects.inner[q].getMarkFinished()) {
			finishedCellEffects.add(_cellEffects.inner[q]);

		} else {
			done = false;
		}

	}

	for (int r = 0; r < finishedColumnCellEffects.getCount(); r++) {
		removeColumnCellsEffect(finishedColumnCellEffects.inner[r].getColumnId(), false, finishedColumnCellEffects.inner[r]);
		finishedColumnCellEffects.inner[r].notifyFinished();
	}

	for (int s = 0; s < finishedRowCellEffects.getCount(); s++) {
		removeRowCellsEffect(finishedRowCellEffects.inner[s].getPath(), false, finishedRowCellEffects.inner[s]);
		finishedRowCellEffects.inner[s].notifyFinished();
	}

	for (int t = 0; t < finishedCellEffects.getCount(); t++) {
		removeCellEffect(finishedCellEffects.inner[t].getPath(), false, finishedCellEffects.inner[t]);
		finishedCellEffects.inner[t].notifyFinished();
	}

	return done;
}

}
