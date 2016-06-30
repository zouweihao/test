//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class SelectionManager {
private GridImplementation _grid;

private GridAnimationManager _animationManager;

private FastIterationDictionary__2<Object, Integer> _selectedRows = new FastIterationDictionary__2<Object, Integer>(new TypeInfo(Object.class), new TypeInfo(Integer.class));

public SelectionManager(GridImplementation grid, GridAnimationManager animationManager) {



		_grid = grid;
		_animationManager = animationManager;
}


public void toggleSelection(CellModel model) {
	if (!model.getPath().getIsContentCell()) {
		return;
	}

	if (isSelected(model)) {
		unselectModel(model);

	} else {
		selectModel(model);
	}

}


public boolean isSelected(CellModel model) {
	return _selectedRows.containsKey(model.getPath().getRow());
}


private boolean isSelected(int rowIndex) {
	return _selectedRows.containsKey(rowIndex);
}


private void unselectModel(CellModel model) {
	int rowIndex = model.getPath().getRow();
	unselectRow(rowIndex);
}


private void selectModel(CellModel model) {
	if (_grid.getSelectionMode() == GridSelectionMode.NONE) {
		return;
	}

	if (_grid.getSelectionMode() == GridSelectionMode.SINGLE_ROW) {
		List__1<Object> keys = _selectedRows.getKeyList();
		List__1<Boolean> removed = _selectedRows.getRemovedList();
		IntList toRemove = new IntList();
		for (int i = 0; i < keys.getCount(); i++) {
			if (removed.inner[i]) {
				continue;
			}

			toRemove.add((Integer)keys.inner[i]);
		}

		for (int i1 = 0; i1 < toRemove.getCount(); i1++) {
			unselectRow(toRemove.inner[i1]);
		}

	}

	selectRow(model.getPath().getRow());
}


private void selectRow(int row) {
	if (!_selectedRows.containsKey(row)) {
		_selectedRows.add(row, row);
		_animationManager.startRowSelectionAnimation(_grid, row);
	}

	_grid.onRowSelected(row);
}


private void unselectRow(int row) {
	if (_selectedRows.containsKey(row)) {
		_selectedRows.remove(row);
		_animationManager.startRowUnselectionAnimation(_grid, row);
	}

	_grid.onRowUnselected(row);
}


public void updateSelectedState() {
	IList__1<Integer> resolvedSelection = getResolvedSelectedIndexes();
	Dictionary__2<Integer, Integer> _currentSelection = new Dictionary__2<Integer, Integer>(new TypeInfo(Integer.class), new TypeInfo(Integer.class));
	for (int i = 0; i < resolvedSelection.getCount(); i++) {
		int index = resolvedSelection.getItem(i);
		_currentSelection.add(index, index);
		if (!isSelected(index)) {
			selectRow(index);
		}

	}

	List__1<Object> keys = _selectedRows.getKeyList();
	List__1<Boolean> removedList = _selectedRows.getRemovedList();
	IntList toRemove = new IntList();
	for (int i1 = 0; i1 < keys.getCount(); i1++) {
		if (removedList.inner[i1]) {
			continue;
		}

		int key = (Integer)keys.inner[i1];
		if (!_currentSelection.containsKey(key)) {
			toRemove.add(key);
		}

	}

	for (int i2 = 0; i2 < toRemove.getCount(); i2++) {
		unselectRow(toRemove.inner[i2]);
	}

	for (int i3 = 0; i3 < _grid.getSelectedIndexes().getCount(); i3++) {
		if (!_currentSelection.containsKey(_grid.getSelectedIndexes().inner[i3])) {
			unselectRow(_grid.getSelectedIndexes().inner[i3]);
		}

	}

}


private IList__1<Integer> getResolvedSelectedIndexes() {
	IntList resolvedSelectedIndexes = new IntList();
	if (_grid.getSelectionMode() == GridSelectionMode.NONE) {
		return com.infragistics.controls.ListCaster.toIListInt(resolvedSelectedIndexes);
	}

	if (_grid.getSelectionMode() == GridSelectionMode.SINGLE_ROW) {
		if (_grid.getSelectedIndexes().getCount() == 0) {
			return com.infragistics.controls.ListCaster.toIListInt(resolvedSelectedIndexes);
		}

		resolvedSelectedIndexes.add(_grid.getSelectedIndexes().inner[0]);
		return com.infragistics.controls.ListCaster.toIListInt(resolvedSelectedIndexes);
	}

	return _grid.getSelectedIndexes();
}

}
