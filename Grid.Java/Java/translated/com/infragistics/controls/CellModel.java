//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;






abstract class CellModel
implements INotifyPropertyChanged {

private ICellPresenter _presenter;
public ICellPresenter setPresenter(ICellPresenter value) {
_presenter = value;
return value;
}
public ICellPresenter getPresenter() {
	return _presenter;
}

public static final String StatePropertyName = "State";

private ModelStates _state;


public ModelStates setState(ModelStates value) {

	ModelStates oldValue = _state;
	_state = value;
	if (_state != oldValue) {
		onPropertyChanged(StatePropertyName, oldValue, _state);
	}

return value;
}
public ModelStates getState() {

		return _state;

}


private String _styleKey;
public String setStyleKey(String value) {
_styleKey = value;
return value;
}
public String getStyleKey() {
	return _styleKey;
}


private CellPath _path;
public CellPath setPath(CellPath value) {
_path = value;
return value;
}
public CellPath getPath() {
	return _path;
}


private boolean _isPositionDirty;
public boolean setIsPositionDirty(boolean value) {
_isPositionDirty = value;
return value;
}
public boolean getIsPositionDirty() {
	return _isPositionDirty;
}


private boolean _isSizeDirty;
public boolean setIsSizeDirty(boolean value) {
_isSizeDirty = value;
return value;
}
public boolean getIsSizeDirty() {
	return _isSizeDirty;
}


private boolean _isContentDirty;
public boolean setIsContentDirty(boolean value) {
_isContentDirty = value;
return value;
}
public boolean getIsContentDirty() {
	return _isContentDirty;
}


private boolean _isLayerDirty;
public boolean setIsLayerDirty(boolean value) {
_isLayerDirty = value;
return value;
}
public boolean getIsLayerDirty() {
	return _isLayerDirty;
}


private boolean _isDataDirty;
public boolean setIsDataDirty(boolean value) {
_isDataDirty = value;
return value;
}
public boolean getIsDataDirty() {
	return _isDataDirty;
}


private boolean _isPlaceholdContentNeeded;
public boolean setIsPlaceholdContentNeeded(boolean value) {
_isPlaceholdContentNeeded = value;
return value;
}
public boolean getIsPlaceholdContentNeeded() {
	return _isPlaceholdContentNeeded;
}


private ICellActionManager _actionManager;
public ICellActionManager setActionManager(ICellActionManager value) {
_actionManager = value;
return value;
}
public ICellActionManager getActionManager() {
	return _actionManager;
}

private Dictionary__2<String, Boolean> _dirtyFields = new Dictionary__2<String, Boolean>(new TypeInfo(String.class), new TypeInfo(Boolean.class));


public boolean isDirty(String propertyName) {
	if (_dirtyFields.containsKey(propertyName)) {
		return _dirtyFields.getItem(propertyName);
	}

	return false;
}


private void markDirty(String propertyName) {
	_dirtyFields.setItem(propertyName, true);
}


protected void onPropertyChanged(String propertyName, Object oldValue, Object newValue) {
	markDirty(propertyName);
	propertyChangedOverride(propertyName, oldValue, newValue);
}

private static java.util.HashMap<String, Integer> __switch_CellModel_PropertyChangedOverride0 = null;
protected void propertyChangedOverride(String propertyName, Object oldValue, Object newValue) {
	if (__switch_CellModel_PropertyChangedOverride0 == null) {
		__switch_CellModel_PropertyChangedOverride0 = new java.util.HashMap<String, Integer>();
		__switch_CellModel_PropertyChangedOverride0.put(StatePropertyName, 0);
		__switch_CellModel_PropertyChangedOverride0.put(LeftOffsetPropertyName, 1);
		__switch_CellModel_PropertyChangedOverride0.put(TopOffsetPropertyName, 1);
		__switch_CellModel_PropertyChangedOverride0.put(LeftPercentOffsetPropertyName, 1);
		__switch_CellModel_PropertyChangedOverride0.put(TopPercentOffsetPropertyName, 1);
		__switch_CellModel_PropertyChangedOverride0.put(XPropertyName, 1);
		__switch_CellModel_PropertyChangedOverride0.put(YPropertyName, 1);
		__switch_CellModel_PropertyChangedOverride0.put(WidthPropertyName, 2);
		__switch_CellModel_PropertyChangedOverride0.put(HeightPropertyName, 2);
	}
	String __switch_CellModel_PropertyChangedOverride0__key = propertyName;
	int __switch_CellModel_PropertyChangedOverride0__index = __switch_CellModel_PropertyChangedOverride0.containsKey(__switch_CellModel_PropertyChangedOverride0__key) ? __switch_CellModel_PropertyChangedOverride0.get(__switch_CellModel_PropertyChangedOverride0__key) : -1;
	switch (__switch_CellModel_PropertyChangedOverride0__index) {
		case 0:
			setIsPositionDirty(true);
			setIsSizeDirty(true);
			setIsContentDirty(true);
			break;
		case 1:
			setIsPositionDirty(true);
			break;
		case 2:
			setIsSizeDirty(true);
			break;
		default:
			setIsContentDirty(true);
			break;
	}
}

public CellModel() {



		this.setState(ModelStates.NEW);
		reset();
		this.setBackgroundColor(GridStyleRepository.getDefaultBackgroundColor());
}


public void reset() {
	resetOverride();
}


protected void resetOverride() {
	_dirtyFields.clear();
	setSelectedStatus(0);
	setIsContentDirty(true);
	setIsPositionDirty(true);
	setIsSizeDirty(true);
	setIsLayerDirty(false);
}

public static final String CurrentLayerPropertyName = "CurrentLayer";

private GridLayer _currentLayer = null;


public GridLayer setCurrentLayer(GridLayer value) {

	GridLayer oldValue = _currentLayer;
	_currentLayer = value;
	if (_currentLayer != oldValue) {
		setIsLayerDirty(true);
	}

return value;
}
public GridLayer getCurrentLayer() {

		return _currentLayer;

}

public static final String XPropertyName = "X";

private int _x;


public int setX(int value) {

	int oldValue = _x;
	_x = value;
	if (_x != oldValue) {
		onPropertyChanged(XPropertyName, oldValue, _x);
	}

return value;
}
public int getX() {

		return _x;

}

public static final String YPropertyName = "Y";

private int _y;


public int setY(int value) {

	int oldValue = _y;
	_y = value;
	if (_y != oldValue) {
		onPropertyChanged(YPropertyName, oldValue, _y);
	}

return value;
}
public int getY() {

		return _y;

}

public static final String ContentOpacityPropertyName = "ContentOpacity";

private double _contentOpacity = 1d;


public double setContentOpacity(double value) {

	double oldValue = _contentOpacity;
	_contentOpacity = value;
	if (_contentOpacity != oldValue) {
		onPropertyChanged(ContentOpacityPropertyName, oldValue, _contentOpacity);
	}

return value;
}
public double getContentOpacity() {

		return _contentOpacity;

}

public static final String OpacityPropertyName = "Opacity";

private double _opacity = 1d;


public double setOpacity(double value) {

	double oldValue = _opacity;
	_opacity = value;
	if (_opacity != oldValue) {
		onPropertyChanged(OpacityPropertyName, oldValue, _opacity);
	}

return value;
}
public double getOpacity() {

		return _opacity;

}

public static final String LeftOffsetPropertyName = "LeftOffset";

private double _leftOffset = 0;


public double setLeftOffset(double value) {

	double oldValue = _leftOffset;
	_leftOffset = value;
	if (_leftOffset != oldValue) {
		onPropertyChanged(LeftOffsetPropertyName, oldValue, _leftOffset);
	}

return value;
}
public double getLeftOffset() {

		return _leftOffset;

}

public static final String TopOffsetPropertyName = "TopOffset";

private double _topOffset = 0;


public double setTopOffset(double value) {

	double oldValue = _topOffset;
	_topOffset = value;
	if (_topOffset != oldValue) {
		onPropertyChanged(TopOffsetPropertyName, oldValue, _topOffset);
	}

return value;
}
public double getTopOffset() {

		return _topOffset;

}

public static final String LeftPercentOffsetPropertyName = "LeftPercentOffset";

private double _leftPercentOffset = 0;


public double setLeftPercentOffset(double value) {

	double oldValue = _leftPercentOffset;
	_leftPercentOffset = value;
	if (_leftPercentOffset != oldValue) {
		onPropertyChanged(LeftPercentOffsetPropertyName, oldValue, _leftPercentOffset);
	}

return value;
}
public double getLeftPercentOffset() {

		return _leftPercentOffset;

}

public static final String TopPercentOffsetPropertyName = "TopPercentOffset";

private double _topPercentOffset = 0;


public double setTopPercentOffset(double value) {

	double oldValue = _topPercentOffset;
	_topPercentOffset = value;
	if (_topPercentOffset != oldValue) {
		onPropertyChanged(TopPercentOffsetPropertyName, oldValue, _topPercentOffset);
	}

return value;
}
public double getTopPercentOffset() {

		return _topPercentOffset;

}

public static final String HeightPropertyName = "Height";

private int _height;


public int setHeight(int value) {

	int oldValue = _height;
	_height = value;
	if (_height != oldValue) {
		onPropertyChanged(HeightPropertyName, oldValue, _height);
	}

return value;
}
public int getHeight() {

		return _height;

}

public static final String WidthPropertyName = "Width";

private int _width;


public int setWidth(int value) {

	int oldValue = _width;
	_width = value;
	if (_width != oldValue) {
		onPropertyChanged(WidthPropertyName, oldValue, _width);
	}

return value;
}
public int getWidth() {

		return _width;

}

public static final String IsSelectedPropertyName = "IsSelected";

private boolean _isSelected;


public boolean setIsSelected(boolean value) {

	boolean oldValue = _isSelected;
	_isSelected = value;
	if (_isSelected != oldValue) {
		onPropertyChanged(IsSelectedPropertyName, oldValue, _isSelected);
	}

return value;
}
public boolean getIsSelected() {

		return _isSelected;

}

public static final String ModelTypePropertyName = "ModelType";

private ModelTypes _modelType;


public ModelTypes setModelType(ModelTypes value) {

	ModelTypes oldValue = _modelType;
	_modelType = value;
	if (_modelType != oldValue) {
		onPropertyChanged(ModelTypePropertyName, oldValue, _modelType);
	}

return value;
}
public ModelTypes getModelType() {

		return _modelType;

}

public static final String SelectedStatusPropertyName = "SelectedStatus";

private double _selectedStatus;


public double setSelectedStatus(double value) {

	double oldValue = _selectedStatus;
	_selectedStatus = value;
	if (_selectedStatus != oldValue) {
		onPropertyChanged(SelectedStatusPropertyName, oldValue, _selectedStatus);
	}

return value;
}
public double getSelectedStatus() {

		return _selectedStatus;

}

public static final String HorizontalAlignmentPropertyName = "HorizontalAlignment";

private HorizontalAlignment _horizontalAlignment = HorizontalAlignment.LEFT;


public HorizontalAlignment setHorizontalAlignment(HorizontalAlignment value) {

	HorizontalAlignment oldValue = _horizontalAlignment;
	_horizontalAlignment = value;
	if (_horizontalAlignment != oldValue) {
		onPropertyChanged(HorizontalAlignmentPropertyName, oldValue, _horizontalAlignment);
	}

return value;
}
public HorizontalAlignment getHorizontalAlignment() {

		return _horizontalAlignment;

}

public static final String VerticalAlignmentPropertyName = "VerticalAlignment";

private VerticalAlignment _verticalAlignment = VerticalAlignment.CENTER;


public VerticalAlignment setVerticalAlignment(VerticalAlignment value) {

	VerticalAlignment oldValue = _verticalAlignment;
	_verticalAlignment = value;
	if (_verticalAlignment != oldValue) {
		onPropertyChanged(VerticalAlignmentPropertyName, oldValue, _horizontalAlignment);
	}

return value;
}
public VerticalAlignment getVerticalAlignment() {

		return _verticalAlignment;

}

public static final String BackgroundColorPropertyName = "BackgroundColor";

private Brush _backgroundColor;


public Brush setBackgroundColor(Brush value) {

	Brush oldValue = _backgroundColor;
	_backgroundColor = value;
	if (_backgroundColor != oldValue) {
		onPropertyChanged(BackgroundColorPropertyName, oldValue, _backgroundColor);
	}

return value;
}
public Brush getBackgroundColor() {

		return _backgroundColor;

}

public static final String SelectedBackgroundColorPropertyName = "SelectedBackgroundColor";

private Brush _selectedBackgroundColor;


public Brush setSelectedBackgroundColor(Brush value) {

	Brush oldValue = _selectedBackgroundColor;
	_selectedBackgroundColor = value;
	if (_selectedBackgroundColor != oldValue) {
		onPropertyChanged(SelectedBackgroundColorPropertyName, oldValue, _selectedBackgroundColor);
	}

return value;
}
public Brush getSelectedBackgroundColor() {

		return _selectedBackgroundColor;

}

public static final String RenderValuePropertyName = "RenderValue";

private String _renderValue;


public String setRenderValue(String value) {

	String oldValue = _renderValue;
	_renderValue = value;
	if (com.infragistics.controls.StringHelper.areNotEqual(_renderValue, oldValue)) {
		onPropertyChanged(RenderValuePropertyName, oldValue, _renderValue);
	}

return value;
}
public String getRenderValue() {

		return _renderValue;

}

public static final String TextColorPropertyName = "TextColor";

private Brush _textColor;


public Brush setTextColor(Brush value) {

	Brush oldValue = _textColor;
	_textColor = value;
	if (_textColor != oldValue) {
		onPropertyChanged(TextColorPropertyName, oldValue, _textColor);
	}

return value;
}
public Brush getTextColor() {

		return _textColor;

}

public static final String FontInfoPropertyName = "FontInfo";

private FontInfo _fontInfo;


public FontInfo setFontInfo(FontInfo value) {

	FontInfo oldValue = _fontInfo;
	_fontInfo = value;
	if (_fontInfo != oldValue) {
		onPropertyChanged(FontInfoPropertyName, oldValue, _fontInfo);
	}

return value;
}
public FontInfo getFontInfo() {

		return _fontInfo;

}

public static final String VirtualizationPercentagePropertyName = "VirtualizationPercentage";

private double _virtualizationPercentage;


public double setVirtualizationPercentage(double value) {

	double oldValue = _virtualizationPercentage;
	_virtualizationPercentage = value;
	if (_virtualizationPercentage != oldValue) {
		onPropertyChanged(VirtualizationPercentagePropertyName, oldValue, _virtualizationPercentage);
	}

return value;
}
public double getVirtualizationPercentage() {

		return _virtualizationPercentage;

}


public void cleanDirtyFlags() {
	cleanDirtyFlagsOverride();
}


protected void cleanDirtyFlagsOverride() {
	setIsPositionDirty(false);
	setIsSizeDirty(false);
	setIsContentDirty(false);
	setIsLayerDirty(false);
	setIsDataDirty(false);
	_dirtyFields.clear();
}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}


public CellModelExport createModelExport(CellModelExport export) {
	if (export == null) {
		export = new CellModelExport();
	}

	export.setX(this.getX());
	export.setY(this.getY());
	export.setHeight(this.getHeight());
	export.setWidth(this.getWidth());
	export.setIsSelected(this.getIsSelected());
	export.setBackgroundBrushData(AppearanceHelper.fromBrushExtended(this.getBackgroundColor()));
	export.setHorizontalAlignment(this.getHorizontalAlignment());
	export.setVerticalAlignment(this.getVerticalAlignment());
	export.setRenderValue(this.getRenderValue());
	export.setTextColor(AppearanceHelper.fromBrushExtended(this.getTextColor()));
	if (getFontInfo() != null) {
		if (com.infragistics.controls.StringHelper.areNotEqual(getFontInfo().getFontFamily(), null)) {
			export.setFontFamily(getFontInfo().getFontFamily());
		}

		if (!Double.isNaN(getFontInfo().getFontSize())) {
			export.setFontSize(getFontInfo().getFontSize());
		}

		if (com.infragistics.controls.StringHelper.areNotEqual(getFontInfo().getFontWeight(), null)) {
			export.setFontWeight(getFontInfo().getFontWeight());
		}

		if (com.infragistics.controls.StringHelper.areNotEqual(getFontInfo().getFontStyle(), null)) {
			export.setFontStyle(getFontInfo().getFontStyle());
		}

		if (com.infragistics.controls.StringHelper.areNotEqual(getFontInfo().getFontStretch(), null)) {
			export.setFontStretch(getFontInfo().getFontStyle());
		}

	}

	return export;
}

private static Dictionary__2<String, Action__2<CellModel, Object>> _setterMap = null;


protected void ensureSetterMap() {
	if (_setterMap == null) {
		_setterMap = new Dictionary__2<String, Action__2<CellModel, Object>>(new TypeInfo(String.class), new TypeInfo(Action__2.class, new TypeInfo[] {}));
		_setterMap.add(XPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setX((Integer)o);
			}
		});
		_setterMap.add(YPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setY((Integer)o);
			}
		});
		_setterMap.add(ContentOpacityPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setContentOpacity((Double)o);
			}
		});
		_setterMap.add(OpacityPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setOpacity((Double)o);
			}
		});
		_setterMap.add(LeftOffsetPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setLeftOffset((Double)o);
			}
		});
		_setterMap.add(LeftPercentOffsetPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setLeftPercentOffset((Double)o);
			}
		});
		_setterMap.add(TopOffsetPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setTopOffset((Double)o);
			}
		});
		_setterMap.add(TopPercentOffsetPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setTopPercentOffset((Double)o);
			}
		});
		_setterMap.add(HeightPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setHeight((Integer)o);
			}
		});
		_setterMap.add(WidthPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setWidth((Integer)o);
			}
		});
		_setterMap.add(IsSelectedPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setIsSelected((Boolean)o);
			}
		});
		_setterMap.add(ModelTypePropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setModelType((ModelTypes)o);
			}
		});
		_setterMap.add(SelectedStatusPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setSelectedStatus((Double)o);
			}
		});
		_setterMap.add(HorizontalAlignmentPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setHorizontalAlignment((HorizontalAlignment)o);
			}
		});
		_setterMap.add(VerticalAlignmentPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setVerticalAlignment((VerticalAlignment)o);
			}
		});
		_setterMap.add(BackgroundColorPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setBackgroundColor((Brush)o);
			}
		});
		_setterMap.add(SelectedBackgroundColorPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setSelectedBackgroundColor((Brush)o);
			}
		});
		_setterMap.add(RenderValuePropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setRenderValue((String)o);
			}
		});
		_setterMap.add(TextColorPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setTextColor((Brush)o);
			}
		});
		_setterMap.add(FontInfoPropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setFontInfo((FontInfo)o);
			}
		});
		_setterMap.add(VirtualizationPercentagePropertyName, new Action__2<CellModel, Object>() {
			 public void invoke(CellModel c, Object o) { 
				c.setVirtualizationPercentage((Double)o);
			}
		});
	}

}

private static Dictionary__2<String, Func__2<CellModel, Object>> _getterMap = null;


protected void ensureGetterMap() {
	if (_getterMap == null) {
		_getterMap = new Dictionary__2<String, Func__2<CellModel, Object>>(new TypeInfo(String.class), new TypeInfo(Func__2.class, new TypeInfo[] {}));
		_getterMap.add(XPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getX();
			}
		});
		_getterMap.add(YPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getY();
			}
		});
		_getterMap.add(ContentOpacityPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getContentOpacity();
			}
		});
		_getterMap.add(OpacityPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getOpacity();
			}
		});
		_getterMap.add(LeftOffsetPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getLeftOffset();
			}
		});
		_getterMap.add(LeftPercentOffsetPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getLeftPercentOffset();
			}
		});
		_getterMap.add(TopOffsetPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getTopOffset();
			}
		});
		_getterMap.add(TopPercentOffsetPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getTopPercentOffset();
			}
		});
		_getterMap.add(HeightPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getHeight();
			}
		});
		_getterMap.add(WidthPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getWidth();
			}
		});
		_getterMap.add(IsSelectedPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getIsSelected();
			}
		});
		_getterMap.add(ModelTypePropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getModelType();
			}
		});
		_getterMap.add(SelectedStatusPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getSelectedStatus();
			}
		});
		_getterMap.add(HorizontalAlignmentPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getHorizontalAlignment();
			}
		});
		_getterMap.add(VerticalAlignmentPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getVerticalAlignment();
			}
		});
		_getterMap.add(BackgroundColorPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getBackgroundColor();
			}
		});
		_getterMap.add(SelectedBackgroundColorPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getSelectedBackgroundColor();
			}
		});
		_getterMap.add(RenderValuePropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getRenderValue();
			}
		});
		_getterMap.add(TextColorPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getTextColor();
			}
		});
		_getterMap.add(FontInfoPropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getFontInfo();
			}
		});
		_getterMap.add(VirtualizationPercentagePropertyName, new Func__2<CellModel, Object>() {
			 public Object invoke(CellModel c) { 
				return c.getVirtualizationPercentage();
			}
		});
	}

}


public void setPropertyValue(String propertyName, Object value) {
	ensureSetterMap();
	if (_setterMap.containsKey(propertyName)) {
		_setterMap.getItem(propertyName).invoke(this, value);
	}

}


public Object getPropertyValue(String propertyName) {
	ensureGetterMap();
	if (_getterMap.containsKey(propertyName)) {
		return _getterMap.getItem(propertyName).invoke(this);
	}

	return null;
}

}
