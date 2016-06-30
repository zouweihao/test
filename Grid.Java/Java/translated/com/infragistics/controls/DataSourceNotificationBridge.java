//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



class DataSourceNotificationBridge
implements DataSourceUpdateNotifier {
private GridImplementation _owner;

public DataSourceNotificationBridge(GridImplementation grid) {



		_owner = grid;
}


public void rangeActualized(int startIndex, int endIndex) {
	_owner.onDataSourceRangeActualized(startIndex, endIndex);
}


public void notifySetItem(int index, Object oldItem, Object newItem) {
	_owner.onSetItem(index, oldItem, newItem);
}


public void notifyClearItems() {
	_owner.onClearItems();
}


public void notifyInsertItem(int index, Object newItem) {
	_owner.onInsertItem(index, newItem);
}


public void notifyRemoveItem(int index, Object oldItem) {
	_owner.onRemoveItem(index, oldItem);
}


public void notifySetItems(int startingIndex, java.util.List oldItems, java.util.List newItems) {
	_owner.onSetItems(startingIndex, new JavaListWrapper(oldItems), new JavaListWrapper(newItems));
}


public void notifyInsertItems(int startingIndex, java.util.List newItems) {
	_owner.onInsertItems(startingIndex, new JavaListWrapper(newItems));
}


public void notifyRemoveItems(int startingIndex, java.util.List oldItems) {
	_owner.onRemoveItems(startingIndex, new JavaListWrapper(oldItems));
}

}
