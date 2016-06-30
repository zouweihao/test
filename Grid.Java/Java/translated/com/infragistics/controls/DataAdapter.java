//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;




class DataAdapter
implements INotifyPropertyChanged {
private String _groupingKeyPath;

private SectionInformation[] _sections;

private Dictionary__2<Object, Integer> _sectionMap = new Dictionary__2<Object, Integer>(new TypeInfo(Object.class), new TypeInfo(Integer.class));


private ColumnController _columnController;
public ColumnController setColumnController(ColumnController value) {
_columnController = value;
return value;
}
public ColumnController getColumnController() {
	return _columnController;
}

public DataAdapter(ColumnController columnController) {



		setColumnController(columnController);
}

private DataSource _dataSource;


public DataSource setDataSource(DataSource value) {

	DataSource oldValue = _dataSource;
	_dataSource = value;
	if (_dataSource != oldValue) {
		onPropertyChanged("DataSource", oldValue, _dataSource);
	}

return value;
}
public DataSource getDataSource() {

		return _dataSource;

}


private void onPropertyChanged(String propertyName, Object oldValue, Object newValue) {
	if (getPropertyChanged() != null) {
		getPropertyChanged().invoke(this, new PropertyChangedEventArgs(propertyName));
	}

	propertyChangedOverride(propertyName, oldValue, newValue);
}

private static java.util.HashMap<String, Integer> __switch_DataAdapter_PropertyChangedOverride0 = null;
protected void propertyChangedOverride(String propertyName, Object oldValue, Object newValue) {
	if (__switch_DataAdapter_PropertyChangedOverride0 == null) {
		__switch_DataAdapter_PropertyChangedOverride0 = new java.util.HashMap<String, Integer>();
		__switch_DataAdapter_PropertyChangedOverride0.put("DataSource", 0);
	}
	String __switch_DataAdapter_PropertyChangedOverride0__key = propertyName;
	int __switch_DataAdapter_PropertyChangedOverride0__index = __switch_DataAdapter_PropertyChangedOverride0.containsKey(__switch_DataAdapter_PropertyChangedOverride0__key) ? __switch_DataAdapter_PropertyChangedOverride0.get(__switch_DataAdapter_PropertyChangedOverride0__key) : -1;
	switch (__switch_DataAdapter_PropertyChangedOverride0__index) {
		case 0:
			_sections = null;
			_sectionMap.clear();
			if (getDataSource() != null) {
				_sections = getDataSource().getSectionInformation();
				for (int i = 0; i < _sections.length; i++) {
					if (_sections[i].getSectionKey() != null) {
						_sectionMap.add(_sections[i].getSectionKey(), i);
					}

				}

			}

			break;
	}
}


public int getRowCount() {
	return getRowCountForSection(0);
}


public int getRowCountForSection(int section) {
	if (com.infragistics.controls.StringHelper.isNullOrEmpty(_groupingKeyPath)) {
		if (_dataSource == null) {
			return 0;
		}

		return _dataSource.getCount();
	}

	if (section >= _sections.length) {
	return -1;
	}

	return getRowCountForSectionIndex(section);
}


public int getRowCountForSectionIndex(int section) {
	if (section > (_sections.length - 1)) {
		return -1;
	}

	if (section == (_sections.length - 1)) {
		return _dataSource.getCount() - _sections[section].getStartIndex();
	}

	return _sections[section + 1].getStartIndex() - _sections[section].getStartIndex();
}


public int getSectionCount() {

		if (_sections == null) {
			return 0;
		}

		return _sections.length;

}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}


private CellPath normalizePath(CellPath path) {
	return path;
}


public Object resolveValue(CellPath path, String key) {
	path = this.normalizePath(path);
	Object obj = null;
	if (path == null) {
	return null;
	}

	if (_sections == null || _sections.length < 1) {
		if (_dataSource.getCount() > path.getRow()) {
		obj = _dataSource.getItemValueAtIndex(path.getRow(), key);
		}


	} else {
		int sectionOffset = _sections[path.getSection()].getStartIndex();
		int fullRow = sectionOffset + path.getRow();
		obj = _dataSource.getItemValueAtIndex(fullRow, key);
	}

	return obj;
}


public Object resolveValueForRow(CellPath path) {
	path = this.normalizePath(path);
	Object obj = null;
	if (path == null) {
	return null;
	}

	if (_sections == null || _sections.length < 1) {
		if (_dataSource.getCount() > path.getRow()) {
		obj = _dataSource.getItemAtIndex(path.getRow());
		}


	} else {
		int sectionOffset = _sections[path.getSection()].getStartIndex();
		int fullRow = sectionOffset + path.getRow();
		obj = _dataSource.getItemAtIndex(fullRow);
	}

	return obj;
}


public int getSectionForRow(int row) {
	if (_sections == null || _sections.length < 2) {
		return 0;
	}

	for (int i = 0; i < _sections.length; i++) {
		if (i < _sections.length - 1) {
			if (row > _sections[i + 1].getStartIndex()) {
				continue;
			}

		}

		return i;
	}

	return _sections.length - 1;
}


public RowPath getRowPathForRow(int row) {
	int section = getSectionForRow(row);
	return new RowPath(section, row - _sections[section].getStartIndex());
}


public boolean isPlaceholderValue(CellPath path, String p) {
	if (_dataSource == null) {
		return false;
	}

	return (com.infragistics.controls.Caster.<DataSourcePlaceholderItem>dynamicCast(resolveValueForRow(path), DataSourcePlaceholderItem.class) != null);
}

}
