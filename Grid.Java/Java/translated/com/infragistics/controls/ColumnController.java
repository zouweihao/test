//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;





class ColumnController {
private GridColumnCollection _actualColumns;

private GridColumnCollection _userDefinedColumns;

private GridColumnCollection _autoGenerated;

private boolean _autoGenerateColumns;

private DataSourceSchema _schema;


public boolean setAutoGenerateColumns(boolean value) {

	_autoGenerateColumns = value;
	updateAutoGeneratedColumns();
return value;
}
public boolean getAutoGenerateColumns() {

		return _autoGenerateColumns;

}


public DataSourceSchema setSchema(DataSourceSchema value) {

	_schema = value;
	updateAutoGeneratedColumns();
return value;
}
public DataSourceSchema getSchema() {

		return _schema;

}


public GridColumnCollection getActualColumns() {

		return _actualColumns;

}


private void updateAutoGeneratedColumns() {
	Dictionary__2<String, Boolean> userKeys = new Dictionary__2<String, Boolean>(new TypeInfo(String.class), new TypeInfo(Boolean.class));
	for (int i = 0; i < _userDefinedColumns.getCount(); i++) {
		ColumnImplementation col = _userDefinedColumns.inner[i];
		userKeys.setItem(col.getKey(), true);
	}

	if (_autoGenerateColumns && _schema != null) {
		autogenerateColumns(userKeys, _schema);
	}

}


private void autogenerateColumns(Dictionary__2<String, Boolean> userKeys, DataSourceSchema schema) {
	GridColumnCollection newAutoColumns = new GridColumnCollection();
	for (int i = 0; i < schema.getValueNames().length; i++) {
		String name = schema.getValueNames()[i];
		if (!userKeys.containsKey(name)) {
			ColumnImplementation column = createColumnFromSchemaType(name, schema.getValueTypes()[i]);
			newAutoColumns.add(column);
			userKeys.setItem(name, true);
		}

	}

	Dictionary__2<String, Boolean> autoKeys = new Dictionary__2<String, Boolean>(new TypeInfo(String.class), new TypeInfo(Boolean.class));
	for (int i1 = 0; i1 < newAutoColumns.getCount(); i1++) {
		autoKeys.setItem(newAutoColumns.inner[i1].getKey(), true);
	}

	for (int j = _actualColumns.getCount() - 1; j >= _userDefinedColumns.getCount(); j--) {
		if (!autoKeys.containsKey(_actualColumns.inner[j].getKey())) {
			_actualColumns.removeAt(j);
		}

	}

	Dictionary__2<String, Boolean> existingAutoKeys = new Dictionary__2<String, Boolean>(new TypeInfo(String.class), new TypeInfo(Boolean.class));
	for (int k = _userDefinedColumns.getCount(); k < _actualColumns.getCount(); k++) {
		existingAutoKeys.setItem(_actualColumns.inner[k].getKey(), true);
	}

	int sharedCount = (int)java.lang.Math.min(newAutoColumns.getCount(), _actualColumns.getCount() - _userDefinedColumns.getCount());
	for (int m = 0; m < sharedCount; m++) {
		if (com.infragistics.controls.StringHelper.areNotEqual(_actualColumns.inner[m + _userDefinedColumns.getCount()].getKey(), newAutoColumns.inner[m].getKey())) {
			if (existingAutoKeys.containsKey(newAutoColumns.inner[m].getKey())) {
				int existingIndex = -1;
				for (int n = m + _userDefinedColumns.getCount(); n < _actualColumns.getCount(); n++) {
					if (_actualColumns.inner[n].getKey().equals(newAutoColumns.inner[m].getKey())) {
						existingIndex = n;
						break;
					}

				}

				if (existingIndex != -1) {
					ColumnImplementation column1 = _actualColumns.inner[existingIndex];
					_actualColumns.removeAt(existingIndex);
					_actualColumns.insert(m + _userDefinedColumns.getCount(), column1);
				}


			} else {
				_actualColumns.insert(m + _userDefinedColumns.getCount(), newAutoColumns.inner[m]);
			}

		}

		sharedCount = (int)java.lang.Math.min(newAutoColumns.getCount(), _actualColumns.getCount() - _userDefinedColumns.getCount());
	}

	for (int n1 = sharedCount; n1 < newAutoColumns.getCount(); n1++) {
		_actualColumns.insert(n1, newAutoColumns.inner[n1]);
	}

	_autoGenerated = newAutoColumns;
}


private ColumnImplementation createColumnFromSchemaType(String name, DataSourceSchemaValueType dataSourceSchemaValueType) {
	ColumnImplementation column = null;
	switch (dataSourceSchemaValueType) {
		case DATE_TIME_VALUE:
			column = new DateTimeColumnImplementation();
			break;
		case DOUBLE_VALUE:
		case FLOAT_VALUE:
		case INT_VALUE:
		case LONG_VALUE:
		case SHORT_VALUE:
			column = new NumericColumnImplementation();
			break;
		case OBJECT_VALUE:
			column = new TextColumnImplementation();
			break;
		case STRING_VALUE:
			column = new TextColumnImplementation();
			break;
	}

	column.setKey(name);
	column.setIsAutoGenerated(true);
	return column;
}

public ColumnController(GridColumnCollection userDefinedColumns, boolean autoGenerateColumns) {



		_autoGenerateColumns = autoGenerateColumns;
		_userDefinedColumns = userDefinedColumns;
		_actualColumns = new GridColumnCollection();
		for (int i = 0; i < _userDefinedColumns.getCount(); i++) {
			_actualColumns.add(_userDefinedColumns.inner[i]);
		}

		_userDefinedColumns.setCollectionChanged(com.infragistics.controls.FunctionDelegate.combine(_userDefinedColumns.getCollectionChanged(), new NotifyCollectionChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.ColumnController.UserDefinedColumns_CollectionChanged") { public void invoke(Object sender, NotifyCollectionChangedEventArgs e) { userDefinedColumns_CollectionChanged(sender, e); } }));
}


void userDefinedColumns_CollectionChanged(Object sender, NotifyCollectionChangedEventArgs e) {
	switch (e.getAction()) {
		case ADD:
			if (e.getNewItems() != null) {
				for (int i = 0; i < e.getNewItems().getCount(); i++) {
					_actualColumns.insert(i + e.getNewStartingIndex(), (ColumnImplementation)e.getNewItems().getItemObject(i));
				}

			}

			break;
		case REMOVE:
			if (e.getOldItems() != null) {
				for (int j = 0; j < e.getOldItems().getCount(); j++) {
					_actualColumns.removeAt(e.getOldStartingIndex());
				}

			}

			break;
		case REPLACE:
			if (e.getOldItems() != null) {
				for (int k = 0; k < e.getOldItems().getCount(); k++) {
					_actualColumns.removeAt(e.getOldStartingIndex());
				}

			}

			if (e.getNewItems() != null) {
				for (int m = 0; m < e.getNewItems().getCount(); m++) {
					_actualColumns.insert(m + e.getNewStartingIndex(), (ColumnImplementation)e.getNewItems().getItemObject(m));
				}

			}

			break;
		case RESET:
			int userCount = _actualColumns.getCount() - _autoGenerated.getCount();
			for (int n = 0; n < userCount; n++) {
				_actualColumns.removeAt(0);
			}

			for (int p = 0; p < _userDefinedColumns.getCount(); p++) {
				_actualColumns.insert(p, _userDefinedColumns.inner[p]);
			}

			break;
	}

}


public ColumnImplementation getContainingColumn(CellPath path) {
	return _actualColumns.inner[path.getColumn()];
}


public ColumnImplementation getColumnById(long uniqueId) {
	for (int i = 0; i < _actualColumns.getCount(); i++) {
		if (_actualColumns.inner[i].getUniqueId() == uniqueId) {
			return _actualColumns.inner[i];
		}

	}

	return null;
}


public boolean isFixedLeft(ColumnImplementation column) {
	return false;
}


public boolean isFixedRight(ColumnImplementation column) {
	return false;
}

}