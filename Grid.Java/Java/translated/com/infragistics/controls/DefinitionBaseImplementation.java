//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;






abstract class DefinitionBaseImplementation
implements INotifyPropertyChanged {
public DefinitionBaseImplementation() {



		setActualBackgroundColor(getDefaultBackgroundColor());
		setActualTextColor(getDefaultTextColor());
}

public static final String ExternalObjectPropertyName = "ExternalObject";

private Object _externalObject;


public Object setExternalObject(Object value) {

	Object oldValue = _externalObject;
	_externalObject = value;
	if (_externalObject != oldValue) {
		onPropertyChanged(ExternalObjectPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _externalObject);
	}

return value;
}
public Object getExternalObject() {

		return _externalObject;

}

public static final String BackgroundColorPropertyName = "BackgroundColor";


private Brush __backgroundColor;
private Brush set_backgroundColor(Brush value) {
__backgroundColor = value;
return value;
}
private Brush get_backgroundColor() {
	return __backgroundColor;
}


public Brush setBackgroundColor(Brush value) {

	Brush oldValue = get_backgroundColor();
	set_backgroundColor(value);
	if (get_backgroundColor() != oldValue) {
		onPropertyChanged(BackgroundColorPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, get_backgroundColor());
	}

return value;
}
public Brush getBackgroundColor() {

		return get_backgroundColor();

}

public static final String ActualBackgroundColorPropertyName = "ActualBackgroundColor";


private Brush __actualBackgroundColor;
private Brush set_actualBackgroundColor(Brush value) {
__actualBackgroundColor = value;
return value;
}
private Brush get_actualBackgroundColor() {
	return __actualBackgroundColor;
}


public Brush setActualBackgroundColor(Brush value) {

	Brush oldValue = get_actualBackgroundColor();
	set_actualBackgroundColor(value);
	if (get_actualBackgroundColor() != oldValue) {
		onPropertyChanged(ActualBackgroundColorPropertyName, CellPropertyAnimationType.BRUSH_VALUE, oldValue, get_actualBackgroundColor());
	}

return value;
}
public Brush getActualBackgroundColor() {

		return get_actualBackgroundColor();

}

public static final String ContentOpacityPropertyName = "ContentOpacity";

private double _contentOpacity = 1d;


public double setContentOpacity(double value) {

	double oldValue = _contentOpacity;
	_contentOpacity = value;
	if (_contentOpacity != oldValue) {
		onPropertyChanged(ContentOpacityPropertyName, CellPropertyAnimationType.DOUBLE_VALUE, oldValue, _contentOpacity);
	}

return value;
}
public double getContentOpacity() {

		return _contentOpacity;

}

public static final String HorizontalAlignmentPropertyName = "HorizontalAlignment";

private HorizontalAlignment _horizontalAlignment;


public HorizontalAlignment setHorizontalAlignment(HorizontalAlignment value) {

	HorizontalAlignment oldValue = _horizontalAlignment;
	_horizontalAlignment = value;
	if (_horizontalAlignment != oldValue) {
		onPropertyChanged(HorizontalAlignmentPropertyName, CellPropertyAnimationType.ENUM_VALUE, oldValue, _horizontalAlignment);
	}

return value;
}
public HorizontalAlignment getHorizontalAlignment() {

		return _horizontalAlignment;

}

public static final String VerticalAlignmentPropertyName = "VerticalAlignment";

private VerticalAlignment _verticalAlignment;


public VerticalAlignment setVerticalAlignment(VerticalAlignment value) {

	VerticalAlignment oldValue = _verticalAlignment;
	_verticalAlignment = value;
	if (_verticalAlignment != oldValue) {
		onPropertyChanged(VerticalAlignmentPropertyName, CellPropertyAnimationType.ENUM_VALUE, oldValue, _verticalAlignment);
	}

return value;
}
public VerticalAlignment getVerticalAlignment() {

		return _verticalAlignment;

}

public static final String TextColorPropertyName = "TextColor";

private Brush _textColor;


public Brush setTextColor(Brush value) {

	Brush oldValue = _textColor;
	_textColor = value;
	if (_textColor != oldValue) {
		onPropertyChanged(TextColorPropertyName, CellPropertyAnimationType.IGNORED_VALUE, oldValue, _textColor);
	}

return value;
}
public Brush getTextColor() {

		return _textColor;

}

private Brush _actualTextColor;

public static final String ActualTextColorPropertyName = "ActualTextColor";


public Brush setActualTextColor(Brush value) {

	Brush oldValue = _actualTextColor;
	_actualTextColor = value;
	if (_actualTextColor != oldValue) {
		onPropertyChanged(ActualTextColorPropertyName, CellPropertyAnimationType.BRUSH_VALUE, oldValue, _actualTextColor);
	}

return value;
}
public Brush getActualTextColor() {

		return _actualTextColor;

}

public static final String FontInfoPropertyName = "FontInfo";

private FontInfo _fontInfo;


public FontInfo setFontInfo(FontInfo value) {

	FontInfo oldValue = _fontInfo;
	_fontInfo = value;
	if (_fontInfo != oldValue) {
		onPropertyChanged(FontInfoPropertyName, CellPropertyAnimationType.FONT_VALUE, oldValue, _fontInfo);
	}

return value;
}
public FontInfo getFontInfo() {

		return _fontInfo;

}


public CellModel createModel(CellPath path, String resolvedStyleKey) {
	CellModel model = createModelOverride(path);
	model.setStyleKey(resolvedStyleKey);
	return model;
}


protected abstract CellModel createModelOverride(CellPath path);


public abstract String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue);


public void onAttaching(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
	cellModel.setIsPlaceholdContentNeeded(grid.getModel().getIsPlaceholderContentNeeded());
	cellModel.setHorizontalAlignment(this.getHorizontalAlignment());
	cellModel.setVerticalAlignment(this.getVerticalAlignment());
	cellModel.setLeftOffset(0);
	cellModel.setTopOffset(0);
	cellModel.setLeftPercentOffset(0);
	cellModel.setTopPercentOffset(0);
	cellModel.setContentOpacity(1d);
	cellModel.setVirtualizationPercentage(0d);
	cellModel.setOpacity(1d);
	cellModel.setContentOpacity(this.getContentOpacity());
	cellModel.setTextColor(this.getActualTextColor());
	cellModel.setBackgroundColor(this.getActualBackgroundColor());
	cellModel.setFontInfo(this.getFontInfo());
	if (cellModel.getActionManager() == null) {
		cellModel.setActionManager(new CellActionManager(grid, cellModel));
	}

}


public void onDataBind(CellModel cellModel, GridImplementation grid, Object resolvedValue) {
}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}


class __closure_DefinitionBase_OnPropertyChanged {
	public String propertyName;
	public CellPropertyAnimationType propertyType;
	public Object oldValue;
	public Object newValue;

}

protected void onPropertyChanged(String propertyName, CellPropertyAnimationType propertyType, Object oldValue, Object newValue) {
final __closure_DefinitionBase_OnPropertyChanged __closure = new __closure_DefinitionBase_OnPropertyChanged();
__closure.propertyName = propertyName;
__closure.propertyType = propertyType;
__closure.oldValue = oldValue;
__closure.newValue = newValue;
	if (getPropertyChanged() != null) {
		getPropertyChanged().invoke(this, new PropertyChangedEventArgs(__closure.propertyName));
	}

	propertyUpdatedOverride(__closure.propertyName, __closure.propertyType, __closure.oldValue, __closure.newValue);
	if (getDefinitionPropertyUpdated() != null) {
		getDefinitionPropertyUpdated().invoke(this, (new Object() { 
			public DefinitionPropertyUpdatedEventArgs invoke() {
				DefinitionPropertyUpdatedEventArgs __ret = new DefinitionPropertyUpdatedEventArgs();
				__ret.setPropertyName(__closure.propertyName);
				__ret.setAnimationType(__closure.propertyType);
				__ret.setNewValue(__closure.newValue);
				__ret.setOldValue(__closure.oldValue);
				return __ret;
			}
		}).invoke());
	}

}

private static java.util.HashMap<String, Integer> __switch_DefinitionBase_PropertyUpdatedOverride0 = null;
protected void propertyUpdatedOverride(String propertyName, CellPropertyAnimationType propertyType, Object oldValue, Object newValue) {
	if (__switch_DefinitionBase_PropertyUpdatedOverride0 == null) {
		__switch_DefinitionBase_PropertyUpdatedOverride0 = new java.util.HashMap<String, Integer>();
		__switch_DefinitionBase_PropertyUpdatedOverride0.put(TextColorPropertyName, 0);
		__switch_DefinitionBase_PropertyUpdatedOverride0.put(BackgroundColorPropertyName, 1);
	}
	String __switch_DefinitionBase_PropertyUpdatedOverride0__key = propertyName;
	int __switch_DefinitionBase_PropertyUpdatedOverride0__index = __switch_DefinitionBase_PropertyUpdatedOverride0.containsKey(__switch_DefinitionBase_PropertyUpdatedOverride0__key) ? __switch_DefinitionBase_PropertyUpdatedOverride0.get(__switch_DefinitionBase_PropertyUpdatedOverride0__key) : -1;
	switch (__switch_DefinitionBase_PropertyUpdatedOverride0__index) {
		case 0:
			if (getTextColor() != null) {
				setActualTextColor(getTextColor());

			} else {
				setActualTextColor(getDefaultTextColor());
			}

			break;
		case 1:
			if (getBackgroundColor() != null) {
				setActualBackgroundColor(getBackgroundColor());

			} else {
				setActualBackgroundColor(getDefaultBackgroundColor());
			}

			break;
	}
}


protected Brush getDefaultTextColor() {
	return GridStyleRepository.getTextCellTextColor();
}


protected Brush getDefaultBackgroundColor() {
	return GridStyleRepository.getDefaultBackgroundColor();
}

public DefinitionPropertyUpdatedEventHandler definitionPropertyUpdated = null;
public void setDefinitionPropertyUpdated(DefinitionPropertyUpdatedEventHandler __event) {
	definitionPropertyUpdated = __event;
}
public DefinitionPropertyUpdatedEventHandler getDefinitionPropertyUpdated() {
	return definitionPropertyUpdated;
}

}
