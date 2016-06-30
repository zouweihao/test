//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;





abstract class ColumnImplementation
extends DefinitionBaseImplementation {
public ColumnImplementation() {



		setHeader(new TextHeaderImplementation());
		setHorizontalAlignment(HorizontalAlignment.LEFT);
		setVerticalAlignment(VerticalAlignment.CENTER);
		setActualSelectedBackgroundColor(getDefaultSelectedBackgroundColor());
		setUniqueId(_currentUniqueId++);
}


protected Brush getDefaultSelectedBackgroundColor() {
	return GridStyleRepository.getDefaultSelectedBackgroundColor();
}

private static long _currentUniqueId = 0;


private long _uniqueId;
public long setUniqueId(long value) {
_uniqueId = value;
return value;
}
public long getUniqueId() {
	return _uniqueId;
}

public static final String StatePropertyName = "State";

private ColumnStates _state = ColumnStates.DETACHED;


public ColumnStates setState(ColumnStates value) {

	ColumnStates oldValue = _state;
	_state = value;
	if (_state != oldValue) {
		onPropertyChanged(StatePropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _state);
	}

return value;
}
public ColumnStates getState() {

		return _state;

}

public static final String NamePropertyName = "Name";

private String _name = "";


public String setName(String value) {

	String oldValue = _name;
	_name = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_name, oldValue)) {
		onPropertyChanged(NamePropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _name);
	}

return value;
}
public String getName() {

		return _name;

}

private int _oldLeftPosition = 0;


public int setOldLeftPosition(int value) {

	_oldLeftPosition = value;
return value;
}
public int getOldLeftPosition() {

		return _oldLeftPosition;

}

private int _oldIndex = 0;


public int setOldIndex(int value) {

	_oldIndex = value;
return value;
}
public int getOldIndex() {

		return _oldIndex;

}

private String _key;


public String setKey(String value) {

	_key = value;
	if (getHeader() != null && com.infragistics.controls.StringHelper.isNullOrEmpty(getHeader().getActualHeaderText())) {
		getHeader().setActualHeaderText(_key);
	}

return value;
}
public String getKey() {

		return _key;

}

public static final String HeaderTextPropertyName = "HeaderText";

private String _headerText;


public String setHeaderText(String value) {

	String oldValue = _headerText;
	_headerText = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_headerText, oldValue)) {
		onPropertyChanged(HeaderTextPropertyName, CellPropertyAnimationType.STRING_VALUE, oldValue, _headerText);
	}

return value;
}
public String getHeaderText() {

		return _headerText;

}

public static final String HeaderTextColorPropertyName = "HeaderTextColor";

private Brush _headerTextColor;


public Brush setHeaderTextColor(Brush value) {

	Brush oldValue = _headerTextColor;
	_headerTextColor = value;
	if (_headerTextColor != oldValue) {
		onPropertyChanged(HeaderTextColorPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _headerTextColor);
	}

return value;
}
public Brush getHeaderTextColor() {

		return _headerTextColor;

}

public static final String HeaderBackgroundColorPropertyName = "HeaderBackgroundColor";

private Brush _headerBackgroundColor;


public Brush setHeaderBackgroundColor(Brush value) {

	Brush oldValue = _headerBackgroundColor;
	_headerBackgroundColor = value;
	if (_headerBackgroundColor != oldValue) {
		onPropertyChanged(HeaderBackgroundColorPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _headerBackgroundColor);
	}

return value;
}
public Brush getHeaderBackgroundColor() {

		return _headerBackgroundColor;

}

public static final String SelectedBackgroundColorPropertyName = "SelectedBackgroundColor";


private Brush __selectedBackgroundColor;
private Brush set_selectedBackgroundColor(Brush value) {
__selectedBackgroundColor = value;
return value;
}
private Brush get_selectedBackgroundColor() {
	return __selectedBackgroundColor;
}


public Brush setSelectedBackgroundColor(Brush value) {

	Brush oldValue = get_selectedBackgroundColor();
	set_selectedBackgroundColor(value);
	if (get_selectedBackgroundColor() != oldValue) {
		onPropertyChanged(SelectedBackgroundColorPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, get_selectedBackgroundColor());
	}

return value;
}
public Brush getSelectedBackgroundColor() {

		return get_selectedBackgroundColor();

}

public static final String ActualSelectedBackgroundColorPropertyName = "ActualSelectedBackgroundColor";


private Brush __actualSelectedBackgroundColor;
private Brush set_actualSelectedBackgroundColor(Brush value) {
__actualSelectedBackgroundColor = value;
return value;
}
private Brush get_actualSelectedBackgroundColor() {
	return __actualSelectedBackgroundColor;
}


public Brush setActualSelectedBackgroundColor(Brush value) {

	Brush oldValue = get_actualSelectedBackgroundColor();
	set_actualSelectedBackgroundColor(value);
	if (get_actualSelectedBackgroundColor() != oldValue) {
		onPropertyChanged(ActualSelectedBackgroundColorPropertyName, CellPropertyAnimationType.BRUSH_VALUE, oldValue, get_actualSelectedBackgroundColor());
	}

return value;
}
public Brush getActualSelectedBackgroundColor() {

		return get_actualSelectedBackgroundColor();

}

public static final String HeaderFontInfoPropertyName = "HeaderFontInfo";

private FontInfo _headerFontInfo;


public FontInfo setHeaderFontInfo(FontInfo value) {

	FontInfo oldValue = _headerFontInfo;
	_headerFontInfo = value;
	if (_headerFontInfo != oldValue) {
		onPropertyChanged(HeaderFontInfoPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _headerFontInfo);
	}

return value;
}
public FontInfo getHeaderFontInfo() {

		return _headerFontInfo;

}

public static final String HeaderHorizontalAlignmentPropertyName = "HeaderHorizontalAlignment";

private HorizontalAlignment _headerHorizontalAlignment;


public HorizontalAlignment setHeaderHorizontalAlignment(HorizontalAlignment value) {

	HorizontalAlignment oldValue = _headerHorizontalAlignment;
	_headerHorizontalAlignment = value;
	if (_headerHorizontalAlignment != oldValue) {
		onPropertyChanged(HeaderHorizontalAlignmentPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _headerHorizontalAlignment);
	}

return value;
}
public HorizontalAlignment getHeaderHorizontalAlignment() {

		return _headerHorizontalAlignment;

}

public static final String HeaderVerticalAlignmentPropertyName = "HeaderVerticalAlignment";

private VerticalAlignment _headerVerticalAlignment;


public VerticalAlignment setHeaderVerticalAlignment(VerticalAlignment value) {

	VerticalAlignment oldValue = _headerVerticalAlignment;
	_headerVerticalAlignment = value;
	if (_headerVerticalAlignment != oldValue) {
		onPropertyChanged(HeaderVerticalAlignmentPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _headerVerticalAlignment);
	}

return value;
}
public VerticalAlignment getHeaderVerticalAlignment() {

		return _headerVerticalAlignment;

}

public static final String AnimationSettingsPropertyName = "AnimationSettings";

private GridColumnAnimationSettingsImplementation _animationSettings = null;


public GridColumnAnimationSettingsImplementation setAnimationSettings(GridColumnAnimationSettingsImplementation value) {

	GridColumnAnimationSettingsImplementation oldValue = _animationSettings;
	_animationSettings = value;
	if (_animationSettings != oldValue) {
		onPropertyChanged(AnimationSettingsPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, AnimationSettingsPropertyName);
	}

return value;
}
public GridColumnAnimationSettingsImplementation getAnimationSettings() {

		return _animationSettings;

}


private ColumnWidthImplementation _width;
public ColumnWidthImplementation setWidth(ColumnWidthImplementation value) {
_width = value;
return value;
}
public ColumnWidthImplementation getWidth() {
	return _width;
}


private boolean _isAutoGenerated;
public boolean setIsAutoGenerated(boolean value) {
_isAutoGenerated = value;
return value;
}
public boolean getIsAutoGenerated() {
	return _isAutoGenerated;
}

public static final String HeaderPropertyName = "Header";

private HeaderImplementation _header;


public HeaderImplementation setHeader(HeaderImplementation value) {

	HeaderImplementation oldValue = _header;
	_header = value;
	if (_header != oldValue) {
		onPropertyChanged(HeaderPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _header);
	}

return value;
}
public HeaderImplementation getHeader() {

		return _header;

}

public static final String IsHiddenPropertyName = "IsHidden";

private boolean _isHidden;


public boolean setIsHidden(boolean value) {

	boolean oldValue = _isHidden;
	_isHidden = value;
	if (_isHidden != oldValue) {
		onPropertyChanged(IsHiddenPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _isHidden);
	}

return value;
}
public boolean getIsHidden() {

		return _isHidden;

}

public static final String ShouldRemoveWhenHiddenPropertyName = "ShouldRemoveWhenHidden";

private boolean _shouldRemoveWhenHidden = false;


public boolean setShouldRemoveWhenHidden(boolean value) {

	boolean oldValue = _shouldRemoveWhenHidden;
	_shouldRemoveWhenHidden = value;
	if (_shouldRemoveWhenHidden != oldValue) {
		onPropertyChanged(ShouldRemoveWhenHiddenPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _shouldRemoveWhenHidden);
	}

return value;
}
public boolean getShouldRemoveWhenHidden() {

		return _shouldRemoveWhenHidden;

}

public static final String InternalShouldRemoveWhenHiddenPropertyName = "InternalShouldRemoveWhenHidden";

private boolean _internalShouldRemoveWhenHidden = false;


public boolean setInternalShouldRemoveWhenHidden(boolean value) {

	boolean oldValue = _internalShouldRemoveWhenHidden;
	_internalShouldRemoveWhenHidden = value;
	if (_internalShouldRemoveWhenHidden != oldValue) {
		onPropertyChanged(InternalShouldRemoveWhenHiddenPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _internalShouldRemoveWhenHidden);
	}

return value;
}
public boolean getInternalShouldRemoveWhenHidden() {

		return _internalShouldRemoveWhenHidden;

}


public boolean getActualShouldRemoveWhenHidden() {

		if (_internalShouldRemoveWhenHidden) {
			return true;
		}

		return _shouldRemoveWhenHidden;

}


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	super.onAttaching(cellModel, grid, resolvedValue);
	if (grid.getSelectionManager().isSelected(cellModel)) {
		cellModel.setSelectedStatus(1d);

	} else {
		cellModel.setSelectedStatus(0d);
	}

	cellModel.setSelectedBackgroundColor(getActualSelectedBackgroundColor());
}

private static java.util.HashMap<String, Integer> __switch_Column_PropertyUpdatedOverride0 = null;
protected void propertyUpdatedOverride(String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) {
	super.propertyUpdatedOverride(propertyName, propertyAnimationType, oldValue, newValue);
	if (__switch_Column_PropertyUpdatedOverride0 == null) {
		__switch_Column_PropertyUpdatedOverride0 = new java.util.HashMap<String, Integer>();
		__switch_Column_PropertyUpdatedOverride0.put(HeaderPropertyName, 0);
		__switch_Column_PropertyUpdatedOverride0.put(HeaderTextPropertyName, 1);
		__switch_Column_PropertyUpdatedOverride0.put(HeaderBackgroundColorPropertyName, 2);
		__switch_Column_PropertyUpdatedOverride0.put(HeaderTextColorPropertyName, 3);
		__switch_Column_PropertyUpdatedOverride0.put(HeaderFontInfoPropertyName, 4);
		__switch_Column_PropertyUpdatedOverride0.put(HeaderVerticalAlignmentPropertyName, 5);
		__switch_Column_PropertyUpdatedOverride0.put(HeaderHorizontalAlignmentPropertyName, 6);
		__switch_Column_PropertyUpdatedOverride0.put(SelectedBackgroundColorPropertyName, 7);
	}
	String __switch_Column_PropertyUpdatedOverride0__key = propertyName;
	int __switch_Column_PropertyUpdatedOverride0__index = __switch_Column_PropertyUpdatedOverride0.containsKey(__switch_Column_PropertyUpdatedOverride0__key) ? __switch_Column_PropertyUpdatedOverride0.get(__switch_Column_PropertyUpdatedOverride0__key) : -1;
	switch (__switch_Column_PropertyUpdatedOverride0__index) {
		case 0:
			HeaderImplementation oldHeader = (HeaderImplementation)oldValue;
			HeaderImplementation newHeader = (HeaderImplementation)newValue;
			if (oldHeader != null) {
				oldHeader.setDefinitionPropertyUpdated(com.infragistics.controls.FunctionDelegate.remove(oldHeader.getDefinitionPropertyUpdated(), new DefinitionPropertyUpdatedEventHandler(this, "Infragistics.Controls.Grid.Implementation.Column.Header_DefinitionPropertyUpdated") { public void invoke(Object sender, DefinitionPropertyUpdatedEventArgs args) { header_DefinitionPropertyUpdated(sender, args); } }));
			}

			if (newHeader != null) {
				newHeader.setDefinitionPropertyUpdated(com.infragistics.controls.FunctionDelegate.combine(newHeader.getDefinitionPropertyUpdated(), new DefinitionPropertyUpdatedEventHandler(this, "Infragistics.Controls.Grid.Implementation.Column.Header_DefinitionPropertyUpdated") { public void invoke(Object sender, DefinitionPropertyUpdatedEventArgs args) { header_DefinitionPropertyUpdated(sender, args); } }));
			}

			break;
		case 1:
			getHeader().setActualHeaderText((String)newValue);
			break;
		case 2:
			getHeader().setBackgroundColor((Brush)newValue);
			break;
		case 3:
			getHeader().setTextColor((Brush)newValue);
			break;
		case 4:
			getHeader().setFontInfo((FontInfo)newValue);
			break;
		case 5:
			getHeader().setVerticalAlignment((VerticalAlignment)newValue);
			break;
		case 6:
			getHeader().setHorizontalAlignment((HorizontalAlignment)newValue);
			break;
		case 7:
			setActualSelectedBackgroundColor(getSelectedBackgroundColor());
			break;
	}
	updateColumnCells(propertyName, propertyAnimationType, oldValue, newValue);
}


private void header_DefinitionPropertyUpdated(Object sender, DefinitionPropertyUpdatedEventArgs args) {
	updateHeaderCells(this, args.getPropertyName(), args.getAnimationType(), args.getOldValue(), args.getNewValue());
}


private void updateHeaderCells(ColumnImplementation column, String propertyName, CellPropertyAnimationType animationType, Object oldValue, Object newValue) {
	if (getColumnHeaderCellsPropertyUpdating() != null) {
		getColumnHeaderCellsPropertyUpdating().invoke(this, propertyName, animationType, oldValue, newValue);
	}

}

public ColumnCellsPropertyUpdatingHandler columnCellsPropertyUpdating = null;
public void setColumnCellsPropertyUpdating(ColumnCellsPropertyUpdatingHandler __event) {
	columnCellsPropertyUpdating = __event;
}
public ColumnCellsPropertyUpdatingHandler getColumnCellsPropertyUpdating() {
	return columnCellsPropertyUpdating;
}

public ColumnCellsPropertyUpdatingHandler columnHeaderCellsPropertyUpdating = null;
public void setColumnHeaderCellsPropertyUpdating(ColumnCellsPropertyUpdatingHandler __event) {
	columnHeaderCellsPropertyUpdating = __event;
}
public ColumnCellsPropertyUpdatingHandler getColumnHeaderCellsPropertyUpdating() {
	return columnHeaderCellsPropertyUpdating;
}


protected void updateColumnCells(String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) {
	if (getColumnCellsPropertyUpdating() != null) {
		getColumnCellsPropertyUpdating().invoke(this, propertyName, propertyAnimationType, oldValue, newValue);
	}

}


public ColumnHidingStyle getPreferredHidingAnimationStyle() {
	return ColumnHidingStyle.FADE_OUT;
}


public ColumnShowingStyle getPreferredShowingAnimationStyle() {
	return ColumnShowingStyle.FADE_IN;
}


public ColumnExchangingStyle getPreferredExchangingAnimationStyle() {
	return ColumnExchangingStyle.CROSSFADE;
}

}
