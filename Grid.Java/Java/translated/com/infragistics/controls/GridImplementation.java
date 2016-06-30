//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;










class GridImplementation
implements INotifyPropertyChanged {
public static final int HeaderSectionIndex = -100;

public static final int HeaderRowIndex = -100;

public static final int SectionHeaderRowIndex = -200;

public static final int SectionFooterRowIndex = -201;

public static final int RowSeparatorColumnIndex = -300;

private Object _externalObject;


public Object setExternalObject(Object value) {

	_externalObject = value;
return value;
}
public Object getExternalObject() {

		return _externalObject;

}


private IPropertySetter _propertySetter;
public IPropertySetter setPropertySetter(IPropertySetter value) {
_propertySetter = value;
return value;
}
public IPropertySetter getPropertySetter() {
	return _propertySetter;
}


private IExternalGrid _externalGrid;
public IExternalGrid setExternalGrid(IExternalGrid value) {
_externalGrid = value;
return value;
}
public IExternalGrid getExternalGrid() {
	return _externalGrid;
}

private int _rowHeight = (int)DeviceUtils.toPixelUnits(30);

private DefaultDataSourceInitializedListener _dataSourceInitializedListener;

public EventHandler__1<EventArgs> columnExchangingAnimationCompleted = null;
public void setColumnExchangingAnimationCompleted(EventHandler__1<EventArgs> __event) {
	columnExchangingAnimationCompleted = __event;
}
public EventHandler__1<EventArgs> getColumnExchangingAnimationCompleted() {
	return columnExchangingAnimationCompleted;
}

public EventHandler__1<EventArgs> columnExchangingAnimationCanceled = null;
public void setColumnExchangingAnimationCanceled(EventHandler__1<EventArgs> __event) {
	columnExchangingAnimationCanceled = __event;
}
public EventHandler__1<EventArgs> getColumnExchangingAnimationCanceled() {
	return columnExchangingAnimationCanceled;
}


public void onColumnExchangingAnimationCompleted(ColumnImplementation column) {
	if (getColumnExchangingAnimationCompleted() != null) {
		getColumnExchangingAnimationCompleted().invoke(column.getExternalObject(), new EventArgs());
	}

}


public void onColumnExchangingAnimationCanceled(ColumnImplementation column) {
	if (getColumnExchangingAnimationCanceled() != null) {
		getColumnExchangingAnimationCanceled().invoke(column.getExternalObject(), new EventArgs());
	}

}

public EventHandler__1<EventArgs> columnShowingAnimationCompleted = null;
public void setColumnShowingAnimationCompleted(EventHandler__1<EventArgs> __event) {
	columnShowingAnimationCompleted = __event;
}
public EventHandler__1<EventArgs> getColumnShowingAnimationCompleted() {
	return columnShowingAnimationCompleted;
}

public EventHandler__1<EventArgs> columnShowingAnimationCanceled = null;
public void setColumnShowingAnimationCanceled(EventHandler__1<EventArgs> __event) {
	columnShowingAnimationCanceled = __event;
}
public EventHandler__1<EventArgs> getColumnShowingAnimationCanceled() {
	return columnShowingAnimationCanceled;
}


public void onColumnShowingAnimationCompleted(ColumnImplementation column) {
	if (getColumnShowingAnimationCompleted() != null) {
		getColumnShowingAnimationCompleted().invoke(column.getExternalObject(), new EventArgs());
	}

}


public void onColumnShowingAnimationCanceled(ColumnImplementation column) {
	if (getColumnShowingAnimationCanceled() != null) {
		getColumnShowingAnimationCanceled().invoke(column.getExternalObject(), new EventArgs());
	}

}

public EventHandler__1<EventArgs> columnMovingAnimationCompleted = null;
public void setColumnMovingAnimationCompleted(EventHandler__1<EventArgs> __event) {
	columnMovingAnimationCompleted = __event;
}
public EventHandler__1<EventArgs> getColumnMovingAnimationCompleted() {
	return columnMovingAnimationCompleted;
}

public EventHandler__1<EventArgs> columnMovingAnimationCanceled = null;
public void setColumnMovingAnimationCanceled(EventHandler__1<EventArgs> __event) {
	columnMovingAnimationCanceled = __event;
}
public EventHandler__1<EventArgs> getColumnMovingAnimationCanceled() {
	return columnMovingAnimationCanceled;
}


public void onColumnMovingAnimationCompleted(ColumnImplementation column) {
	if (getColumnMovingAnimationCompleted() != null) {
		getColumnMovingAnimationCompleted().invoke(column.getExternalObject(), new EventArgs());
	}

}


public void onColumnMovingAnimationCanceled(ColumnImplementation column) {
	if (getColumnMovingAnimationCanceled() != null) {
		getColumnMovingAnimationCanceled().invoke(column.getExternalObject(), new EventArgs());
	}

}

public EventHandler__1<EventArgs> columnHidingAnimationCompleted = null;
public void setColumnHidingAnimationCompleted(EventHandler__1<EventArgs> __event) {
	columnHidingAnimationCompleted = __event;
}
public EventHandler__1<EventArgs> getColumnHidingAnimationCompleted() {
	return columnHidingAnimationCompleted;
}

public EventHandler__1<EventArgs> columnHidingAnimationCanceled = null;
public void setColumnHidingAnimationCanceled(EventHandler__1<EventArgs> __event) {
	columnHidingAnimationCanceled = __event;
}
public EventHandler__1<EventArgs> getColumnHidingAnimationCanceled() {
	return columnHidingAnimationCanceled;
}


public void onColumnHidingAnimationCompleted(ColumnImplementation column) {
	if (getColumnHidingAnimationCompleted() != null) {
		getColumnHidingAnimationCompleted().invoke(column.getExternalObject(), new EventArgs());
	}

}


public void onColumnHidingAnimationCanceled(ColumnImplementation column) {
	if (getColumnHidingAnimationCanceled() != null) {
		getColumnHidingAnimationCanceled().invoke(column.getExternalObject(), new EventArgs());
	}

}

public GridImplementation() {



		_dataSourceInitializedListener = new DefaultDataSourceInitializedListener(this);
		_columnController = new ColumnController(_columns, getAutoGenerateColumns());
		_columnController.getActualColumns().setCollectionChanged(com.infragistics.controls.FunctionDelegate.combine(_columnController.getActualColumns().getCollectionChanged(), new NotifyCollectionChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.ActualColumns_CollectionChanged") { public void invoke(Object sender, NotifyCollectionChangedEventArgs e) { actualColumns_CollectionChanged(sender, e); } }));
		_adapter = new DataAdapter(_columnController);
		_responsiveEngine = new ResponsiveEngine(this);
		setIsClickActionDesired(resolveIsClickActionDesired());
		setSelectionManager(new SelectionManager(this, getAnimationManager()));
		_selectedIndexes.setCollectionChanged(com.infragistics.controls.FunctionDelegate.combine(_selectedIndexes.getCollectionChanged(), new NotifyCollectionChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.SelectedIndexes_CollectionChanged") { public void invoke(Object sender, NotifyCollectionChangedEventArgs e) { selectedIndexes_CollectionChanged(sender, e); } }));
}


void selectedIndexes_CollectionChanged(Object sender, NotifyCollectionChangedEventArgs e) {
	if (!getIgnoreSelectionChanged()) {
		getSelectionManager().updateSelectedState();
	}

}

private GridAnimationManager _animationManager = new GridAnimationManager();


public GridAnimationManager setAnimationManager(GridAnimationManager value) {

	_animationManager = value;
return value;
}
public GridAnimationManager getAnimationManager() {

		return _animationManager;

}


private IDelayedExecutionManager _delayedExecutionManager;
public IDelayedExecutionManager setDelayedExecutionManager(IDelayedExecutionManager value) {
_delayedExecutionManager = value;
return value;
}
public IDelayedExecutionManager getDelayedExecutionManager() {
	return _delayedExecutionManager;
}

private ResponsiveEngine _responsiveEngine = null;


public ResponsiveEngine getResponsiveEngine() {

		return _responsiveEngine;

}

private DataAdapter _adapter;


public DataAdapter setAdapter(DataAdapter value) {

	_adapter = value;
return value;
}
public DataAdapter getAdapter() {

		return _adapter;

}

private ColumnController _columnController;


public ColumnController setColumnController(ColumnController value) {

	_columnController = value;
return value;
}
public ColumnController getColumnController() {

		return _columnController;

}

private GridLayerController _gridLayerController = new GridLayerController();


public GridLayerController setGridLayerController(GridLayerController value) {

	_gridLayerController = value;
return value;
}
public GridLayerController getGridLayerController() {

		return _gridLayerController;

}

private SpatialEngine _spatialEngine = new SpatialEngine();


public SpatialEngine setSpatialEngine(SpatialEngine value) {

	_spatialEngine = value;
return value;
}
public SpatialEngine getSpatialEngine() {

		return _spatialEngine;

}

private GridEffectManager _effectManager;


public GridEffectManager setEffectManager(GridEffectManager value) {

	_effectManager = value;
return value;
}
public GridEffectManager getEffectManager() {

		return _effectManager;

}

private SelectionManager _selectionManager;


public SelectionManager setSelectionManager(SelectionManager value) {

	_selectionManager = value;
return value;
}
public SelectionManager getSelectionManager() {

		return _selectionManager;

}

private ITickProvider _tickProvider;


public ITickProvider setTickProvider(ITickProvider value) {

	_tickProvider = value;
	_effectManager = new GridEffectManager(_tickProvider, this);
return value;
}
public ITickProvider getTickProvider() {

		return _tickProvider;

}

private SectionHeaderImplementation _sectionHeader = new SectionHeaderImplementation();


public SectionHeaderImplementation setSectionHeader(SectionHeaderImplementation value) {

	_sectionHeader = value;
return value;
}
public SectionHeaderImplementation getSectionHeader() {

		return _sectionHeader;

}

private SectionHeaderImplementation _sectionFooter = new SectionHeaderImplementation();


public SectionHeaderImplementation setSectionFooter(SectionHeaderImplementation value) {

	_sectionFooter = value;
return value;
}
public SectionHeaderImplementation getSectionFooter() {

		return _sectionFooter;

}

private RowSeparatorImplementation _rowSeparator = new RowSeparatorImplementation();


public RowSeparatorImplementation setRowSeparator(RowSeparatorImplementation value) {

	_rowSeparator = value;
return value;
}
public RowSeparatorImplementation getRowSeparator() {

		return _rowSeparator;

}

private VisibilityEngine _visibilityEngine = new VisibilityEngine();


public VisibilityEngine setVisibilityEngine(VisibilityEngine value) {

	_visibilityEngine = value;
return value;
}
public VisibilityEngine getVisibilityEngine() {

		return _visibilityEngine;

}


private IViewportManager _viewportManager;
public IViewportManager setViewportManager(IViewportManager value) {
_viewportManager = value;
return value;
}
public IViewportManager getViewportManager() {
	return _viewportManager;
}

private double _availableWidth = 0;


public double setAvailableWidth(double value) {

	_availableWidth = value;
return value;
}
public double getAvailableWidth() {

		return _availableWidth;

}

private double _availableHeight = 0;


public double setAvailableHeight(double value) {

	_availableHeight = value;
return value;
}
public double getAvailableHeight() {

		return _availableHeight;

}

public static final String RowHeightPropertyName = "RowHeight";


public int setRowHeight(int value) {

	int oldValue = _rowHeight;
	_rowHeight = value;
	if (oldValue != _rowHeight) {
		onPropertyChanged(RowHeightPropertyName, oldValue, _rowHeight);
	}

return value;
}
public int getRowHeight() {

		return _rowHeight;

}

private ColumnWidthImplementation _defaultColumnWidth = ColumnWidthImplementation.getDefault();

public static final String DefaultColumnWidthPropertyName = "DefaultColumnWidth";


public ColumnWidthImplementation setDefaultColumnWidth(ColumnWidthImplementation value) {

	ColumnWidthImplementation oldValue = _defaultColumnWidth;
	_defaultColumnWidth = value;
	if (oldValue != _defaultColumnWidth) {
		onPropertyChanged(DefaultColumnWidthPropertyName, oldValue, _defaultColumnWidth);
	}

return value;
}
public ColumnWidthImplementation getDefaultColumnWidth() {

		return _defaultColumnWidth;

}

private int _headerHeight = (int)DeviceUtils.toPixelUnits(30);

public static final String HeaderHeightPropertyName = "HeaderHeight";


public int setHeaderHeight(int value) {

	int oldValue = _headerHeight;
	_headerHeight = value;
	if (oldValue != _headerHeight) {
		onPropertyChanged(HeaderHeightPropertyName, oldValue, _headerHeight);
	}

return value;
}
public int getHeaderHeight() {

		return _headerHeight;

}

private int _sectionHeaderHeight = (int)DeviceUtils.toPixelUnits(0);

public static final String SectionHeaderHeightPropertyName = "SectionHeaderHeight";


public int setSectionHeaderHeight(int value) {

	int oldValue = _sectionHeaderHeight;
	_sectionHeaderHeight = value;
	if (oldValue != _sectionHeaderHeight) {
		onPropertyChanged(SectionHeaderHeightPropertyName, oldValue, _sectionHeaderHeight);
	}

return value;
}
public int getSectionHeaderHeight() {

		return _sectionHeaderHeight;

}

private Object _itemsSource = null;

public static final String ItemSourcePropertyName = "ItemsSource";


public Object setItemsSource(Object value) {

	Object oldValue = _itemsSource;
	_itemsSource = value;
	if (oldValue != _itemsSource) {
		onPropertyChanged(ItemSourcePropertyName, oldValue, _itemsSource);
	}

return value;
}
public Object getItemsSource() {

		return _itemsSource;

}

private int _sectionFooterHeight = (int)DeviceUtils.toPixelUnits(0);

public static final String SectionFooterHeightPropertyName = "SectionFooterHeight";


public int setSectionFooterHeight(int value) {

	int oldValue = _sectionFooterHeight;
	_sectionFooterHeight = value;
	if (oldValue != _sectionFooterHeight) {
		onPropertyChanged(SectionFooterHeightPropertyName, oldValue, _sectionFooterHeight);
	}

return value;
}
public int getSectionFooterHeight() {

		return _sectionFooterHeight;

}

private int _rowSpacingHeight = (int)DeviceUtils.toPixelUnits(0);

public static final String RowSpacingHeightPropertyName = "RowSpacingHeight";


public int setRowSpacingHeight(int value) {

	int oldValue = _rowSpacingHeight;
	_rowSpacingHeight = value;
	if (oldValue != _rowSpacingHeight) {
		onPropertyChanged(RowSpacingHeightPropertyName, oldValue, _rowSpacingHeight);
	}

return value;
}
public int getRowSpacingHeight() {

		return _rowSpacingHeight;

}

private int _columnSpacingWidth = (int)DeviceUtils.toPixelUnits(0);

public static final String ColumnSpacingWidthPropertyName = "ColumnSpacingWidth";


public int setColumnSpacingWidth(int value) {

	int oldValue = _columnSpacingWidth;
	_columnSpacingWidth = value;
	if (oldValue != _columnSpacingWidth) {
		onPropertyChanged(ColumnSpacingWidthPropertyName, oldValue, _columnSpacingWidth);
	}

return value;
}
public int getColumnSpacingWidth() {

		return _columnSpacingWidth;

}

private boolean _allowsMultipleSelection = false;

public static final String AllowsMultipleSelectionPropertyName = "AllowsMultipleSelection";


public boolean setAllowsMultipleSelection(boolean value) {

	boolean oldValue = _allowsMultipleSelection;
	_allowsMultipleSelection = value;
	if (oldValue != _allowsMultipleSelection) {
		onPropertyChanged(AllowsMultipleSelectionPropertyName, oldValue, _allowsMultipleSelection);
	}

return value;
}
public boolean getAllowsMultipleSelection() {

		return _allowsMultipleSelection;

}

private boolean _autoGenerateColumns = true;

public static final String AutoGenerateColumnsPropertyName = "AutoGenerateColumns";


public boolean setAutoGenerateColumns(boolean value) {

	boolean oldValue = _autoGenerateColumns;
	_autoGenerateColumns = value;
	if (oldValue != _autoGenerateColumns) {
		onPropertyChanged(AutoGenerateColumnsPropertyName, oldValue, _autoGenerateColumns);
	}

return value;
}
public boolean getAutoGenerateColumns() {

		return _autoGenerateColumns;

}

private int _rowSeparatorHeight = (int)DeviceUtils.toPixelUnits(1);

public static final String RowSeparatorHeightPropertyName = "RowSeparatorHeight";


public int setRowSeparatorHeight(int value) {

	int oldValue = _rowSeparatorHeight;
	_rowSeparatorHeight = value;
	if (oldValue != _rowSeparatorHeight) {
		onPropertyChanged(RowSeparatorHeightPropertyName, oldValue, _rowSeparatorHeight);
	}

return value;
}
public int getRowSeparatorHeight() {

		return _rowSeparatorHeight;

}

private boolean _isPlaceholderRenderingEnabled = true;

public static final String IsPlaceholderRenderingEnabledPropertyName = "IsPlaceholderRenderingEnabled";


public boolean setIsPlaceholderRenderingEnabled(boolean value) {

	boolean oldValue = _isPlaceholderRenderingEnabled;
	_isPlaceholderRenderingEnabled = value;
	if (oldValue != _isPlaceholderRenderingEnabled) {
		onPropertyChanged(IsPlaceholderRenderingEnabledPropertyName, oldValue, _isPlaceholderRenderingEnabled);
	}

return value;
}
public boolean getIsPlaceholderRenderingEnabled() {

		return _isPlaceholderRenderingEnabled;

}


private boolean getIsColumnAddingAnimationEnabled() {

		return _columnAddingAnimationStyle != ColumnShowingStyle.NONE && getIsColumnAnimationEnabled();

}

public static final String ColumnAddingAnimationStylePropertyName = "ColumnAddingAnimationStyle";

private ColumnShowingStyle _columnAddingAnimationStyle = ColumnShowingStyle.AUTO;


public ColumnShowingStyle setColumnAddingAnimationStyle(ColumnShowingStyle value) {

	ColumnShowingStyle oldValue = _columnAddingAnimationStyle;
	_columnAddingAnimationStyle = value;
	onPropertyChanged(ColumnAddingAnimationStylePropertyName, oldValue, _columnAddingAnimationStyle);
return value;
}
public ColumnShowingStyle getColumnAddingAnimationStyle() {

		return _columnAddingAnimationStyle;

}


public boolean getIsColumnPropertyUpdatingAnimationEnabled() {

		return _columnPropertyUpdatingAnimationStyle != ColumnPropertyUpdatingStyle.NONE && getIsColumnAnimationEnabled();

}

public static final String ColumnPropertyUpdatingAnimationStylePropertyName = "ColumnPropertyUpdatingAnimationStyle";

private ColumnPropertyUpdatingStyle _columnPropertyUpdatingAnimationStyle = ColumnPropertyUpdatingStyle.AUTO;


public ColumnPropertyUpdatingStyle setColumnPropertyUpdatingAnimationStyle(ColumnPropertyUpdatingStyle value) {

	ColumnPropertyUpdatingStyle oldValue = _columnPropertyUpdatingAnimationStyle;
	_columnPropertyUpdatingAnimationStyle = value;
	onPropertyChanged(ColumnPropertyUpdatingAnimationStylePropertyName, oldValue, _columnPropertyUpdatingAnimationStyle);
return value;
}
public ColumnPropertyUpdatingStyle getColumnPropertyUpdatingAnimationStyle() {

		return _columnPropertyUpdatingAnimationStyle;

}


protected boolean getIsColumnAnimationEnabled() {

		return getRenderingEngine().getInitialRefreshFinished();

}


public boolean getIsCellActualizationAnimationEnabled() {

		return _cellActualizationAnimationStyle != CellActualizationStyle.NONE;

}

public static final String CellActualizationAnimationStylePropertyName = "CellActualizationAnimationStyle";

private CellActualizationStyle _cellActualizationAnimationStyle = CellActualizationStyle.AUTO;


public CellActualizationStyle setCellActualizationAnimationStyle(CellActualizationStyle value) {

	CellActualizationStyle oldValue = _cellActualizationAnimationStyle;
	_cellActualizationAnimationStyle = value;
	onPropertyChanged(CellActualizationAnimationStylePropertyName, oldValue, _cellActualizationAnimationStyle);
return value;
}
public CellActualizationStyle getCellActualizationAnimationStyle() {

		return _cellActualizationAnimationStyle;

}


public boolean getIsRowSelectionAnimationEnabled() {

		return _rowSelectionAnimationStyle != RowSelectionStyle.NONE;

}

public static final String RowSelectionAnimationStylePropertyName = "RowSelectionAnimationStyle";

private RowSelectionStyle _rowSelectionAnimationStyle = RowSelectionStyle.AUTO;


public RowSelectionStyle setRowSelectionAnimationStyle(RowSelectionStyle value) {

	RowSelectionStyle oldValue = _rowSelectionAnimationStyle;
	_rowSelectionAnimationStyle = value;
	onPropertyChanged(RowSelectionAnimationStylePropertyName, oldValue, _rowSelectionAnimationStyle);
return value;
}
public RowSelectionStyle getRowSelectionAnimationStyle() {

		return _rowSelectionAnimationStyle;

}

private GridColumnAnimationSettingsImplementation _columnAnimationSettings = new GridColumnAnimationSettingsImplementation();

public static final String ColumnAnimationSettingsPropertyName = "ColumnAnimationSettings";


public GridColumnAnimationSettingsImplementation setColumnAnimationSettings(GridColumnAnimationSettingsImplementation value) {

	GridColumnAnimationSettingsImplementation oldValue = _columnAnimationSettings;
	_columnAnimationSettings = value;
	if (oldValue != _columnAnimationSettings) {
		onPropertyChanged(ColumnAnimationSettingsPropertyName, oldValue, _columnAnimationSettings);
	}

return value;
}
public GridColumnAnimationSettingsImplementation getColumnAnimationSettings() {

		return _columnAnimationSettings;

}

private GridAnimationSettingsImplementation _animationSettings = new GridAnimationSettingsImplementation();

public static final String AnimationSettingsPropertyName = "AnimationSettings";


public GridAnimationSettingsImplementation setAnimationSettings(GridAnimationSettingsImplementation value) {

	GridAnimationSettingsImplementation oldValue = _animationSettings;
	_animationSettings = value;
	if (oldValue != _animationSettings) {
		onPropertyChanged(AnimationSettingsPropertyName, oldValue, _animationSettings);
	}

return value;
}
public GridAnimationSettingsImplementation getAnimationSettings() {

		return _animationSettings;

}


private boolean getIsColumnShowingAnimationEnabled() {

		return _columnShowingAnimationStyle != ColumnShowingStyle.NONE && getIsColumnAnimationEnabled();

}

public static final String ColumnShowingAnimationStylePropertyName = "ColumnShowingAnimationStyle";

private ColumnShowingStyle _columnShowingAnimationStyle = ColumnShowingStyle.AUTO;


public ColumnShowingStyle setColumnShowingAnimationStyle(ColumnShowingStyle value) {

	ColumnShowingStyle oldValue = _columnShowingAnimationStyle;
	_columnShowingAnimationStyle = value;
	onPropertyChanged(ColumnShowingAnimationStylePropertyName, oldValue, _columnShowingAnimationStyle);
return value;
}
public ColumnShowingStyle getColumnShowingAnimationStyle() {

		return _columnShowingAnimationStyle;

}


private boolean getIsColumnMovingAnimationEnabled() {

		return _columnMovingAnimationStyle != ColumnMovingStyle.NONE && getIsColumnAnimationEnabled();

}

public static final String ColumnMovingAnimationStylePropertyName = "ColumnMovingAnimationStyle";

private ColumnMovingStyle _columnMovingAnimationStyle = ColumnMovingStyle.AUTO;


public ColumnMovingStyle setColumnMovingAnimationStyle(ColumnMovingStyle value) {

	ColumnMovingStyle oldValue = _columnMovingAnimationStyle;
	_columnMovingAnimationStyle = value;
	onPropertyChanged(ColumnMovingAnimationStylePropertyName, oldValue, _columnMovingAnimationStyle);
return value;
}
public ColumnMovingStyle getColumnMovingAnimationStyle() {

		return _columnMovingAnimationStyle;

}


private boolean getIsColumnHidingAnimationEnabled() {

		return _columnHidingAnimationStyle != ColumnHidingStyle.NONE && getIsColumnAnimationEnabled();

}

public static final String ColumnHidingAnimationStylePropertyName = "ColumnHidingAnimationStyle";

private ColumnHidingStyle _columnHidingAnimationStyle = ColumnHidingStyle.AUTO;


public ColumnHidingStyle setColumnHidingAnimationStyle(ColumnHidingStyle value) {

	ColumnHidingStyle oldValue = _columnHidingAnimationStyle;
	_columnHidingAnimationStyle = value;
	onPropertyChanged(ColumnHidingAnimationStylePropertyName, oldValue, _columnHidingAnimationStyle);
return value;
}
public ColumnHidingStyle getColumnHidingAnimationStyle() {

		return _columnHidingAnimationStyle;

}


private boolean getIsColumnExchangingAnimationEnabled() {

		return _columnExchangingAnimationStyle != ColumnExchangingStyle.NONE && getIsColumnAnimationEnabled();

}

public static final String ColumnExchangingAnimationStylePropertyName = "ColumnExchangingAnimationStyle";

private ColumnExchangingStyle _columnExchangingAnimationStyle = ColumnExchangingStyle.AUTO;


public ColumnExchangingStyle setColumnExchangingAnimationStyle(ColumnExchangingStyle value) {

	ColumnExchangingStyle oldValue = _columnExchangingAnimationStyle;
	_columnExchangingAnimationStyle = value;
	onPropertyChanged(ColumnExchangingAnimationStylePropertyName, oldValue, _columnExchangingAnimationStyle);
return value;
}
public ColumnExchangingStyle getColumnExchangingAnimationStyle() {

		return _columnExchangingAnimationStyle;

}

private Thickness _inset = new Thickness(0, 0, 0, 0);

public static final String InsetPropertyName = "Inset";


public Thickness setInset(Thickness value) {

	Thickness oldValue = _inset;
	_inset = value;
	if (oldValue != _inset) {
		onPropertyChanged(InsetPropertyName, oldValue, _inset);
	}

return value;
}
public Thickness getInset() {

		return _inset;

}

private GridSelectionMode _selectionMode = GridSelectionMode.NONE;

public static final String SelectionModePropertyName = "SelectionMode";


public GridSelectionMode setSelectionMode(GridSelectionMode value) {

	GridSelectionMode oldValue = _selectionMode;
	_selectionMode = value;
	if (oldValue != _selectionMode) {
		onPropertyChanged(SelectionModePropertyName, oldValue, _selectionMode);
	}

return value;
}
public GridSelectionMode getSelectionMode() {

		return _selectionMode;

}

private boolean _ignoreSelectionChanges = false;


public boolean setIgnoreSelectionChanged(boolean value) {

	_ignoreSelectionChanges = true;
return value;
}
public boolean getIgnoreSelectionChanged() {

		return _ignoreSelectionChanges;

}

private GridSelectedIndexesCollection _selectedIndexes = new GridSelectedIndexesCollection();

public static final String SelectedIndexesPropertyName = "SelectedIndexes";


public GridSelectedIndexesCollection getSelectedIndexes() {

		return _selectedIndexes;

}

private int _selectedIndex;

public static final String SelectedIndexPropertyName = "SelectedIndex";


public int setSelectedIndex(int value) {

	int oldValue = _selectedIndex;
	_selectedIndex = value;
	if (oldValue != _selectedIndex) {
		onPropertyChanged(SelectedIndexPropertyName, oldValue, _selectedIndex);
	}

return value;
}
public int getSelectedIndex() {

		return _selectedIndex;

}

private IPlatformPixelConverter _platformPixelConverter = new DefaultPlatformPixelConverter();


public IPlatformPixelConverter setPlatformPixelConverter(IPlatformPixelConverter value) {

	_platformPixelConverter = value;
return value;
}
public IPlatformPixelConverter getPlatformPixelConverter() {

		return _platformPixelConverter;

}

private ICellRenderingEngine _renderingEngine;


public ICellRenderingEngine setRenderingEngine(ICellRenderingEngine value) {

	_renderingEngine = value;
	onRenderingEngineProvided(_renderingEngine);
return value;
}
public ICellRenderingEngine getRenderingEngine() {

		return _renderingEngine;

}


private void onRenderingEngineProvided(ICellRenderingEngine renderingEngine) {
	if (renderingEngine != null) {
		renderingEngine.refresh(getModel(), false);
	}

}


public ResponsiveStatesCollection getResponsiveStates() {

		return getResponsiveEngine().getResponsiveStates();

}

private VisualModel _model = new VisualModel();


public VisualModel setModel(VisualModel value) {

	_model = value;
return value;
}
public VisualModel getModel() {

		return _model;

}

public PropertyChangedEventHandler propertyChanged = null;
public void setPropertyChanged(PropertyChangedEventHandler __event) {
	propertyChanged = __event;
}
public PropertyChangedEventHandler getPropertyChanged() {
	return propertyChanged;
}


protected void onPropertyChanged(String propertyName, Object oldValue, Object newValue) {
	propertyUpdatedOverride(propertyName, oldValue, newValue);
}


public void reset() {
}


public void refreshLayout() {
	if (_availableWidth == 0) {
		return;
	}

	int currContentWidth = getModel().getAbsoluteWidth();
	int currContentHeight = getModel().getAbsoluteHeight();
	getSpatialEngine().invalidateLayoutData(this, getModel(), (int)getAvailableWidth());
	if (currContentWidth != getModel().getAbsoluteWidth() || currContentHeight != getModel().getAbsoluteHeight()) {
		getExternalGrid().onContentSizeChanged();
	}

	getRenderingEngine().invalidateVisibility(new Action() {
		 public void invoke() { 
			getVisibilityEngine().calculate(GridImplementation.this, getModel(), getSpatialEngine(), true);
		}
	});
	getRenderingEngine().refresh(getModel(), false);
}


public void refreshPosition() {
	getRenderingEngine().invalidateVisibility(new Action() {
		 public void invoke() { 
			getVisibilityEngine().calculate(GridImplementation.this);
		}
	});
	getRenderingEngine().refresh(getModel(), true);
}

private DataSource _actualDataSource;

public static final String ActualDataSourcePropertyName = "ActualDataSource";


public DataSource setActualDataSource(DataSource value) {

	DataSource oldValue = _actualDataSource;
	_actualDataSource = value;
	if (_actualDataSource != oldValue) {
		onPropertyChanged(ActualDataSourcePropertyName, oldValue, _actualDataSource);
	}

return value;
}
public DataSource getActualDataSource() {

		return _actualDataSource;

}


protected void propertyUpdatedOverride(String propertyName, Object oldValue, Object newValue) {
	if (com.infragistics.controls.StringHelper.areEqual(propertyName, ItemSourcePropertyName)) {
		if (_actualDataSource != null) {
			_actualDataSource.removeOnInitializedListener(_dataSourceInitializedListener);
			_actualDataSource.setUpdateNotifier(null);
		}

		if ((com.infragistics.controls.Caster.<DataSource>dynamicCast(getItemsSource(), DataSource.class) != null)) {
			setActualDataSource((DataSource)getItemsSource());

		} else {
			DataSource dataSource = getExternalGrid().createLocalDataSource(getItemsSource());
			setActualDataSource(dataSource);
		}

		if (_actualDataSource != null) {
			_actualDataSource.addOnInitializedListener(_dataSourceInitializedListener);
			_actualDataSource.setUpdateNotifier(new DataSourceNotificationBridge(this));
			if (_actualDataSource.getIsVirtual()) {
				getModel().setIsPlaceholderContentNeeded(getIsPlaceholderRenderingEnabled());
			}

			if (_actualDataSource.getIsInitialized()) {
				onDataSourceReady();
			}

		}

	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, AutoGenerateColumnsPropertyName)) {
		getColumnController().setAutoGenerateColumns(getAutoGenerateColumns());
	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, IsPlaceholderRenderingEnabledPropertyName)) {
		if (_actualDataSource != null && _actualDataSource.getIsVirtual()) {
			getModel().setIsPlaceholderContentNeeded(getIsPlaceholderRenderingEnabled());
		}

	}

	if (com.infragistics.controls.StringHelper.areEqual(propertyName, SelectionModePropertyName)) {
		setIsClickActionDesired(resolveIsClickActionDesired());
	}

}


public void onDataSourceInitialized(DataSource dataSource, DataSourceInitializedEvent initializedEvent) {
	onDataSourceReady();
}


private void onDataSourceReady() {
	_adapter.setDataSource(_actualDataSource);
	getColumnController().setSchema(_actualDataSource.getSchema());
	refreshLayout();
}


public void sizeChanged(double width, double height) {
	setAvailableWidth(width);
	setAvailableHeight(height);
	_responsiveEngine.sizeChanged(width, height);
	refreshLayout();
}


public void setViewport(double left, double top, double right, double bottom) {
	double width = right - left;
	getModel().setActualVisibleRegion(new Rect(left, top, right - left, bottom - top));
	refreshPosition();
}


public IList__1<ColumnImplementation> getActualColumns() {

		return _columnController.getActualColumns();

}

private GridColumnCollection _columns = new GridColumnCollection();


public GridColumnCollection getColumns() {

		return _columns;

}


public void onModelRejoined(CellModel cellModel, Object resolvedValue) {
	DefinitionBaseImplementation target = getTargetDefinition(cellModel.getPath());
	target.onAttaching(cellModel, this, resolvedValue);
	target.onDataBind(cellModel, this, resolvedValue);
}


public void onModelDataRefresh(CellModel cellModel, Object resolvedValue) {
	DefinitionBaseImplementation target = getTargetDefinition(cellModel.getPath());
	target.onDataBind(cellModel, this, resolvedValue);
}


public ColumnImplementation getContainingColumn(CellPath path) {
	return getColumnController().getContainingColumn(path);
}


public void hideThenRemoveColumn(ColumnImplementation column) {
	column.setInternalShouldRemoveWhenHidden(true);
	column.setIsHidden(true);
}


public void exchangeColumn(ColumnImplementation newColumn, ColumnImplementation oldColumn) {
	int oldColumnIndex = getColumns().indexOf(oldColumn);
	if (oldColumnIndex == -1) {
		return;
	}

	if (getColumns().contains(newColumn)) {
		if (newColumn.getIsHidden()) {
			getExternalGrid().removeExternalColumn(newColumn.getExternalObject());

		} else {
			return;
		}

	}

	ColumnExchangingStyle actualExchangeStyle = getColumnExchangingAnimationStyle();
	if (actualExchangeStyle == ColumnExchangingStyle.AUTO) {
		actualExchangeStyle = newColumn.getPreferredExchangingAnimationStyle();
	}

	boolean fromRight = false;
	if (actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_LEFT || actualExchangeStyle == ColumnExchangingStyle.SLIDE_TO_LEFT_AND_CROSSFADE) {
		fromRight = true;
	}

	newColumn.setState(ColumnStates.HIDDEN);
	if (fromRight) {
		getExternalGrid().insertExternalColumnAtIndex(oldColumnIndex + 1, newColumn.getExternalObject());

	} else {
		getExternalGrid().insertExternalColumnAtIndex(oldColumnIndex, newColumn.getExternalObject());
	}

	if (!getIsColumnExchangingAnimationEnabled()) {
		newColumn.setIsHidden(false);
		newColumn.setState(ColumnStates.VISIBLE);
		getExternalGrid().removeExternalColumn(oldColumn.getExternalObject());
		this.onColumnExchangingAnimationCompleted(newColumn);
	}

	refreshLayout();
	if (getIsColumnExchangingAnimationEnabled()) {
		ColumnStates oldColumnPreviousState = getModel().getColumnById(oldColumn.getUniqueId()).getState();
		oldColumn.setState(ColumnStates.HIDING);
		newColumn.setState(ColumnStates.SHOWING);
		getAnimationManager().startExchangingColumnAnimations(this, getColumnAnimationSettings(), getModel().getColumnById(oldColumn.getUniqueId()), getModel().getColumnById(newColumn.getUniqueId()), oldColumnPreviousState);
	}

}


void actualColumns_CollectionChanged(Object sender, NotifyCollectionChangedEventArgs e) {
	if (getSuppressColumnChangeReactions()) {
		return;
	}

	switch (e.getAction()) {
		case ADD:
			if (e.getNewItems() != null) {
				for (int i = 0; i < e.getNewItems().getCount(); i++) {
					onColumnInsertedAt(i + e.getNewStartingIndex(), (ColumnImplementation)e.getNewItems().getItemObject(i));
				}

			}

			break;
		case REMOVE:
			if (e.getOldItems() != null) {
				for (int i1 = 0; i1 < e.getOldItems().getCount(); i1++) {
					onColumnRemovedAt(e.getOldStartingIndex(), (ColumnImplementation)e.getOldItems().getItemObject(i1));
				}

			}

			break;
		case REPLACE:
			if (e.getOldItems() != null) {
				for (int i2 = 0; i2 < e.getOldItems().getCount(); i2++) {
					onColumnRemovedAt(e.getOldStartingIndex(), (ColumnImplementation)e.getOldItems().getItemObject(i2));
				}

			}

			if (e.getNewItems() != null) {
				for (int i3 = 0; i3 < e.getNewItems().getCount(); i3++) {
					onColumnInsertedAt(i3 + e.getNewStartingIndex(), (ColumnImplementation)e.getNewItems().getItemObject(i3));
				}

			}

			break;
		case RESET:
			onColumnsReset();
			break;
	}

	refreshLayout();
}


private void onColumnsReset() {
	getSpatialEngine().onColumnsReset(getGridLayerController(), getModel());
}


private void onColumnRemovedAt(int index, ColumnImplementation column) {
	column.setPropertyChanged(com.infragistics.controls.FunctionDelegate.remove(column.getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.column_PropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { column_PropertyChanged(sender, e); } }));
	column.setColumnCellsPropertyUpdating(com.infragistics.controls.FunctionDelegate.remove(column.getColumnCellsPropertyUpdating(), new ColumnCellsPropertyUpdatingHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.ColumnCellsPropertyUpdating") { public void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) { columnCellsPropertyUpdating(column, propertyName, propertyAnimationType, oldValue, newValue); } }));
	column.setColumnHeaderCellsPropertyUpdating(com.infragistics.controls.FunctionDelegate.remove(column.getColumnHeaderCellsPropertyUpdating(), new ColumnCellsPropertyUpdatingHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.ColumnHeaderCellsPropertyUpdating") { public void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) { columnHeaderCellsPropertyUpdating(column, propertyName, propertyAnimationType, oldValue, newValue); } }));
	getSpatialEngine().onColumnRemovedAt(getGridLayerController(), index, column, getModel());
	refreshLayout();
}


private void onColumnInsertedAt(int index, ColumnImplementation column) {
	column.setPropertyChanged(com.infragistics.controls.FunctionDelegate.combine(column.getPropertyChanged(), new PropertyChangedEventHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.column_PropertyChanged") { public void invoke(Object sender, PropertyChangedEventArgs e) { column_PropertyChanged(sender, e); } }));
	column.setColumnCellsPropertyUpdating(com.infragistics.controls.FunctionDelegate.combine(column.getColumnCellsPropertyUpdating(), new ColumnCellsPropertyUpdatingHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.ColumnCellsPropertyUpdating") { public void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) { columnCellsPropertyUpdating(column, propertyName, propertyAnimationType, oldValue, newValue); } }));
	column.setColumnHeaderCellsPropertyUpdating(com.infragistics.controls.FunctionDelegate.combine(column.getColumnHeaderCellsPropertyUpdating(), new ColumnCellsPropertyUpdatingHandler(this, "Infragistics.Controls.Grid.Implementation.Grid.ColumnHeaderCellsPropertyUpdating") { public void invoke(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) { columnHeaderCellsPropertyUpdating(column, propertyName, propertyAnimationType, oldValue, newValue); } }));
	getSpatialEngine().onColumnInsertedAt(index, column, getModel());
	if (column.getIsHidden()) {
		column.setState(ColumnStates.HIDDEN);
	}

	if (getIsColumnShowingAnimationEnabled() && !column.getIsHidden() && column.getState() != ColumnStates.HIDDEN) {
		ColumnStates previousState = column.getState();
		column.setState(ColumnStates.SHOWING);
		refreshLayout();
		getAnimationManager().startShowingColumnAnimations(this, getColumnAnimationSettings(), getModel().getColumnById(column.getUniqueId()), true, previousState);

	} else {
		refreshLayout();
	}

}


private void columnCellsPropertyUpdating(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) {
	if (propertyAnimationType == CellPropertyAnimationType.IGNORED_VALUE) {
		return;
	}

	ColumnInfo columnInfo = getModel().getColumnById(column.getUniqueId());
	if (columnInfo == null) {
		return;
	}

	if (com.infragistics.controls.StringHelper.areNotEqual(propertyName, null) && propertyName.startsWith("Actual")) {
		propertyName = propertyName.substring(6);
	}

	getAnimationManager().animateColumnCellsPropertyChange(this, columnInfo, propertyName, propertyAnimationType, oldValue, newValue, false);
}


private void columnHeaderCellsPropertyUpdating(ColumnImplementation column, String propertyName, CellPropertyAnimationType propertyAnimationType, Object oldValue, Object newValue) {
	if (propertyAnimationType == CellPropertyAnimationType.IGNORED_VALUE) {
		return;
	}

	ColumnInfo columnInfo = getModel().getColumnById(column.getUniqueId());
	if (columnInfo == null) {
		return;
	}

	if (com.infragistics.controls.StringHelper.areNotEqual(propertyName, null) && propertyName.startsWith("Actual")) {
		propertyName = propertyName.substring(6);
	}

	getAnimationManager().animateColumnCellsPropertyChange(this, columnInfo, propertyName, propertyAnimationType, oldValue, newValue, true);
}


private boolean _suppressColumnChangeReactions;
private boolean setSuppressColumnChangeReactions(boolean value) {
_suppressColumnChangeReactions = value;
return value;
}
private boolean getSuppressColumnChangeReactions() {
	return _suppressColumnChangeReactions;
}


public void moveColumn(int oldIndex, int newIndex) {
	ColumnImplementation movingColumn = getColumns().inner[oldIndex];
	setSuppressColumnChangeReactions(true);
	getExternalGrid().removeExternalColumn(movingColumn.getExternalObject());
	getExternalGrid().insertExternalColumnAtIndex(newIndex, movingColumn.getExternalObject());
	setSuppressColumnChangeReactions(false);
	onColumnMoved(oldIndex, newIndex, movingColumn);
}


private void onColumnMoved(int oldIndex, int newIndex, ColumnImplementation column) {
	if (getColumnController().isFixedLeft(column)) {
		column.setOldLeftPosition(getSpatialEngine().getFixedLeftColumnOffset(oldIndex, (double)getModel().getLeft(), this, getModel()));

	} else if (getColumnController().isFixedRight(column)) {
		column.setOldLeftPosition(getSpatialEngine().getFixedRightColumnOffset(oldIndex, (double)getModel().getRight(), this, getModel()));

	} else {
		column.setOldLeftPosition(getSpatialEngine().getColumnOffset(oldIndex, this, getModel()));
	}


	column.setOldIndex(oldIndex);
	ColumnStates previousState = column.getState();
	getSpatialEngine().onColumnMoved(getGridLayerController(), getModel(), oldIndex, newIndex, column.getUniqueId());
	if (!getIsColumnMovingAnimationEnabled() && previousState != ColumnStates.HIDDEN) {
		column.setState(ColumnStates.VISIBLE);
	}

	refreshLayout();
	if (getIsColumnMovingAnimationEnabled()) {
		column.setState(ColumnStates.MOVING);
		getAnimationManager().startMovingColumnAnimations(this, getColumnAnimationSettings(), getModel().getColumnById(column.getUniqueId()), previousState);
	}

}

private static java.util.HashMap<String, Integer> __switch_Grid_column_PropertyChanged0 = null;
private void column_PropertyChanged(Object sender, PropertyChangedEventArgs e) {
	ColumnImplementation column = (ColumnImplementation)sender;
	if (__switch_Grid_column_PropertyChanged0 == null) {
		__switch_Grid_column_PropertyChanged0 = new java.util.HashMap<String, Integer>();
		__switch_Grid_column_PropertyChanged0.put(ColumnImplementation.IsHiddenPropertyName, 0);
	}
	String __switch_Grid_column_PropertyChanged0__key = e.getPropertyName();
	int __switch_Grid_column_PropertyChanged0__index = __switch_Grid_column_PropertyChanged0.containsKey(__switch_Grid_column_PropertyChanged0__key) ? __switch_Grid_column_PropertyChanged0.get(__switch_Grid_column_PropertyChanged0__key) : -1;
	switch (__switch_Grid_column_PropertyChanged0__index) {
		case 0:
			if (column.getIsHidden()) {
				if (getIsColumnHidingAnimationEnabled()) {
					ColumnStates previousState = column.getState();
					column.setState(ColumnStates.HIDING);
					refreshLayout();
					getAnimationManager().startHidingColumnAnimations(this, getColumnAnimationSettings(), getModel().getColumnById(column.getUniqueId()), false, previousState);

				} else {
					column.setState(ColumnStates.HIDDEN);
					refreshLayout();
				}


			} else {
				if (getIsColumnShowingAnimationEnabled()) {
					ColumnStates previousState1 = column.getState();
					column.setState(ColumnStates.SHOWING);
					refreshLayout();
					getAnimationManager().startShowingColumnAnimations(this, getColumnAnimationSettings(), getModel().getColumnById(column.getUniqueId()), false, previousState1);

				} else {
					column.setState(ColumnStates.VISIBLE);
					getAnimationManager().startEnsureCellShownAnimations(this, getModel().getColumnById(column.getUniqueId()));
					getEffectManager().forceTickCells();
					refreshLayout();
				}

			}

			break;
	}
}


private DefinitionBaseImplementation getTargetDefinition(CellPath path) {
	if (path.getIsRowSeparator()) {
		return getRowSeparator();

	} else if (path.getIsSectionHeaderCell()) {
		return getSectionHeader();

	} else if (path.getIsSectionFooterCell()) {
		return getSectionFooter();

	} else {
		ColumnImplementation column = getContainingColumn(path);
		if (path.getIsHeaderCell()) {
			return column.getHeader();

		} else {
			return column;
		}

	}



}


public String getStyleKey(CellPath path, GridImplementation grid, Object resolvedValue) {
	return getTargetDefinition(path).getStyleKey(path, grid, resolvedValue);
}


public CellModel createModel(CellPath path, String resolvedStyleKey) {
	DefinitionBaseImplementation def = getTargetDefinition(path);
	return def.createModel(path, resolvedStyleKey);
}


public VisualModelExport exportVisualModel() {
	return this.getModel().export();
}


public String exportSerializedVisualModel() {
	return this.getModel().export().serialize();
}


public RowPath getRowPathForAbsoluteRow(int row) {
	return this.getAdapter().getRowPathForRow(row);
}


public void scrollToRowByIndex(double rowNumber) {
	int x = 0;
	int y = 0;
	int rowCount = 0;
	for (IEnumerator__1<SectionInfo> en = getModel().getSections().getEnumerator(); en.moveNext();) {
	SectionInfo section = (SectionInfo)en.getCurrent();
		if (rowCount + section.getRowCount() > rowNumber) {
			int rowIndex = (int)java.lang.Math.floor(rowNumber - rowCount);
			int rowHeight = section.getHeightForRow(rowIndex);
			y = section.getOffset() + section.getOffsetForRow(rowIndex);
			y += (int)java.lang.Math.round(rowHeight * ((rowNumber - rowCount) - rowIndex));

		} else {
			rowCount += section.getRowCount();
			continue;
		}


	}

	y -= this.getModel().getHeaderHeight();
	y = java.lang.Math.max(y, 0);
	getViewportManager().moveViewportTo(x, y);
}


public boolean getShouldAnimateColumnAdding() {

		return getIsColumnAddingAnimationEnabled();

}


public void onDataSourceRangeActualized(int startIndex, int endIndex) {
	int firstVisible = getFirstVisibleIndex();
	int lastVisible = getLastVisibleIndex();
	if (endIndex < firstVisible || startIndex > lastVisible) {
		return;
	}

	if (startIndex < firstVisible) {
		startIndex = firstVisible;
	}

	if (endIndex > lastVisible) {
		endIndex = lastVisible;
	}

	getAnimationManager().startActualizationAnimations(this, startIndex, endIndex);
}


private int getLastVisibleIndex() {
	return getSpatialEngine().getAbsoluteIndex(getModel(), getModel().getBottomRow());
}


private int getFirstVisibleIndex() {
	return getSpatialEngine().getAbsoluteIndex(getModel(), getModel().getTopRow());
}


public void onVisibleRangeChanged() {
	if (_actualDataSource != null) {
		int firstVisible = getFirstVisibleIndex();
		int lastVisible = getLastVisibleIndex();
		_actualDataSource.setActualDesiredFirstVisibleIndex(firstVisible);
		_actualDataSource.setActualDesiredLastVisibleIndex(lastVisible);
	}

}


public void onCellClicked(CellModel model) {
	getSelectionManager().toggleSelection(model);
}


private boolean _isClickActionDesired;
public boolean setIsClickActionDesired(boolean value) {
_isClickActionDesired = value;
return value;
}
public boolean getIsClickActionDesired() {
	return _isClickActionDesired;
}


private boolean resolveIsClickActionDesired() {
	return getSelectionMode() != GridSelectionMode.NONE;
}


public void onRowSelected(int row) {
	setIgnoreSelectionChanged(true);
	addSelectedIndex(row);
	setIgnoreSelectionChanged(false);
}


public void onRowUnselected(int row) {
	setIgnoreSelectionChanged(true);
	removeSelectedIndex(row);
	setIgnoreSelectionChanged(false);
}

public GridSelectedIndexesChangedEventHandler selectedIndexesChanged = null;
public void setSelectedIndexesChanged(GridSelectedIndexesChangedEventHandler __event) {
	selectedIndexesChanged = __event;
}
public GridSelectedIndexesChangedEventHandler getSelectedIndexesChanged() {
	return selectedIndexesChanged;
}


class __closure_Grid_AddSelectedIndex {
	public int row;

}

public void addSelectedIndex(int row) {
final __closure_Grid_AddSelectedIndex __closure = new __closure_Grid_AddSelectedIndex();
__closure.row = row;
	int result = ArrayUtil.<Integer>binarySearch(new TypeInfo(Integer.class), getSelectedIndexes(), new Func__2<Integer, Integer>() {
		 public Integer invoke(Integer item) { 
				if (__closure.row < item) {
					return -1;
				}

				if (__closure.row > item) {
					return 1;
				}

				return 0;

		}
	});
	if (result < 0) {
		result = ~result;
	}

	getSelectedIndexes().insert(result, __closure.row);
	if (getSelectedIndexes().getCount() > 0) {
		setSelectedIndex(getSelectedIndexes().inner[0]);

	} else {
		setSelectedIndex(-1);
	}

	GridSelectedIndexesChangedEventArgs args = new GridSelectedIndexesChangedEventArgs();
	IntList addedIndexes = new IntList();
	addedIndexes.add(__closure.row);
	args.setAddedIndexes(com.infragistics.controls.ListCaster.toIListInt(addedIndexes));
	if (getSelectedIndexesChanged() != null) {
		getSelectedIndexesChanged().invoke(this, args);
	}

}


public void removeSelectedIndex(int row) {
	getSelectedIndexes().remove(row);
	if (getSelectedIndexes().getCount() > 0) {
		setSelectedIndex(getSelectedIndexes().inner[0]);

	} else {
		setSelectedIndex(-1);
	}

	GridSelectedIndexesChangedEventArgs args = new GridSelectedIndexesChangedEventArgs();
	IntList removedIndexes = new IntList();
	removedIndexes.add(row);
	args.setRemovedIndexes(com.infragistics.controls.ListCaster.toIListInt(removedIndexes));
	if (getSelectedIndexesChanged() != null) {
		getSelectedIndexesChanged().invoke(this, args);
	}

}


public void onSetItem(int index, Object oldItem, Object newItem) {
	invalidateRow(index);
}


private void invalidateRow(int index) {
	getAnimationManager().startRowDataChangeAnimations(this, index, index);
}


public void onClearItems() {
	invalidateVisibleRows();
}


private void invalidateVisibleRows() {
	int firstVisible = getFirstVisibleIndex();
	int lastVisible = getLastVisibleIndex();
	invalidateRows(firstVisible, lastVisible);
}


private void invalidateRows(int startIndex, int endIndex) {
	int firstVisible = getFirstVisibleIndex();
	int lastVisible = getLastVisibleIndex();
	if (endIndex < firstVisible || startIndex > lastVisible) {
		return;
	}

	if (startIndex < firstVisible) {
		startIndex = firstVisible;
	}

	if (endIndex > lastVisible) {
		endIndex = lastVisible;
	}

	getAnimationManager().startActualizationAnimations(this, startIndex, endIndex);
	refreshPosition();
}


private void invalidateRowsBetween(RowPath startRow, RowPath endRow) {
	int startIndex = getSpatialEngine().getAbsoluteIndex(getModel(), startRow);
	int endIndex = getSpatialEngine().getAbsoluteIndex(getModel(), endRow);
	invalidateRows(startIndex, endIndex);
}


public void onInsertItem(int index, Object newItem) {
	RowPath row = getAdapter().getRowPathForRow(index);
	getEffectManager().onRowInsertedAt(row);
	getSpatialEngine().onRowInsertedAt(row, getModel());
	refreshPosition();
}


public void onRemoveItem(int index, Object oldItem) {
	RowPath row = getAdapter().getRowPathForRow(index);
	getEffectManager().onRowRemovedAt(row);
	getSpatialEngine().onRowRemovedAt(row, getModel());
	refreshPosition();
}


public void onSetItems(int startingIndex, IList oldItems, IList newItems) {
	int start = startingIndex;
	if (oldItems != null && oldItems.getCount() > 0) {
		int end = startingIndex + oldItems.getCount();
		RowPath startRow = getAdapter().getRowPathForRow(start);
		RowPath endRow = getAdapter().getRowPathForRow(end);
		invalidateRowsBetween(startRow, endRow);
		refreshPosition();
	}

}


public void onInsertItems(int startingIndex, IList newItems) {
	if (newItems != null) {
		for (int i = 0; i < newItems.getCount(); i++) {
			RowPath row = getAdapter().getRowPathForRow(startingIndex);
			getEffectManager().onRowInsertedAt(row);
			getSpatialEngine().onRowInsertedAt(row, getModel());
			startingIndex++;
		}

		refreshPosition();
	}

}


public void onRemoveItems(int startingIndex, IList oldItems) {
	if (oldItems != null) {
		for (int i = 0; i < oldItems.getCount(); i++) {
			RowPath row = getAdapter().getRowPathForRow(startingIndex);
			getEffectManager().onRowRemovedAt(row);
			getSpatialEngine().onRowRemovedAt(row, getModel());
		}

		refreshPosition();
	}

}


public void setActiveResponsiveState(String name) {
	for (int i = 0; i < _responsiveEngine.getResponsiveStates().getCount(); i++) {
		if (com.infragistics.controls.StringHelper.areEqual(_responsiveEngine.getResponsiveStates().inner[i].getName(), name)) {
			setActiveResponsiveState(_responsiveEngine.getResponsiveStates().inner[i]);
		}

	}

}


public void setActiveResponsiveState(ResponsiveStateImplementation state) {
	_responsiveEngine.setManualState(state);
}


public void notifySetItem(int index, Object oldItem, Object newItem) {
	if (_actualDataSource != null) {
		_actualDataSource.notifySetItem(index, oldItem, newItem);
	}

}


public void notifyClearItems() {
	if (_actualDataSource != null) {
		_actualDataSource.notifyClearItems();
	}

}


public void notifyInsertItem(int index, Object newItem) {
	if (_actualDataSource != null) {
		_actualDataSource.notifyInsertItem(index, newItem);
	}

	;}


public void notifyRemoveItem(int index, Object oldItem) {
	if (_actualDataSource != null) {
		_actualDataSource.notifyRemoveItem(index, oldItem);
	}

	;}


public void notifySetItems(int startingIndex, java.util.List oldItems, java.util.List newItems) {
	if (_actualDataSource != null) {
		_actualDataSource.notifySetItems(startingIndex, oldItems, newItems);
	}

}


public void notifyInsertItems(int startingIndex, java.util.List newItems) {
	if (_actualDataSource != null) {
		_actualDataSource.notifyInsertItems(startingIndex, newItems);
	}

}


public void notifyRemoveItems(int startingIndex, java.util.List oldItems) {
	if (_actualDataSource != null) {
		_actualDataSource.notifyRemoveItems(startingIndex, oldItems);
	}

}

}
