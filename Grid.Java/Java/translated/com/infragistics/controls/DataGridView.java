//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.util.TypedValue;
import android.content.res.Resources;
import android.view.ViewGroup;

/**
*   Represents a control for viewing the grid.
*/
public class DataGridView 
	extends ScrollView2d {

		private GridImplementation __GridImplementation;
		private GridContentLayout _cellLayoutViewGroup;

		private Context _context;

		DataGridView(final Context context, GridImplementation implementation) {
			super(context);

			this.setBackgroundColor(android.graphics.Color.WHITE);

			_context = context;
			__GridImplementation = implementation; 
			__GridImplementation.setExternalObject(this);
			__GridImplementation.setExternalGrid(new GridExternalWrapper(this));
			__GridImplementation.setTickProvider(new AndroidTickProvider());
			__GridImplementation.setPlatformPixelConverter(new IPlatformPixelConverter() {
				@Override
				public int devicePixelsToPixel(int pixels) {
					return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixels, Resources.getSystem().getDisplayMetrics());
				}
			});	
			
			_cellLayoutViewGroup = new GridContentLayout(this.getContext(), new PresenterManager(__GridImplementation));
			__GridImplementation.setRenderingEngine(_cellLayoutViewGroup);
			__GridImplementation.setViewportManager(new GridViewportManager(this));
			__GridImplementation.setDelayedExecutionManager(new DelayedExecutionManager());
			__GridImplementation.setPropertySetter(new PropertySetter());
			this.setViewportChangedCallBack(new ScrollViewportChangedProxy(this));
			this.addView(_cellLayoutViewGroup);
		}

		public DataGridView(Context context) {
			this(context, new GridImplementation());
		}

		void refreshContentSize() {
			this.setContentSize(__GridImplementation.getModel().getAbsoluteWidth(), __GridImplementation.getModel().getAbsoluteHeight());
		}

		private List<Column> _columns = new ArrayList<Column>();

		/**
		*  Returns the index of the column from the internal collection.
		*/
		protected int getIndexOfInternalColumn(Object col) {
			return _columns.indexOf(col);
		}

		/**
		* Adds a column to this  Grid.
		*/
		public void addColumn(Column column) {
			_columns.add(column);
			ColumnImplementation impl = column.getImplementation();
			impl.setExternalObject(column);
			__GridImplementation.getColumns().add(impl);
		}
	
		/**
		* Removes column from this instance of Grid.
		*/
		public void removeColumn(Column column) {
			_columns.remove(column);
			ColumnImplementation impl = column.getImplementation();
			__GridImplementation.getColumns().remove(impl);
		}
	
		/**
		*  Inserts a column into the Grid's column collection.
		* @param index index at which to insert new column
		* @param column the new column which will be inserted
		*/
		public void insertColumn(int index, Column column) {
			_columns.add(index, column);
			ColumnImplementation impl = column.getImplementation();
			impl.setExternalObject(column);
			__GridImplementation.getColumns().insert(index, impl);
		}
	
		/**
		*  Returns the count of columns this Grid contains.
		*/
		public int getColumnCount() {
			return _columns.size();
		}
	
		/**
		*  Returns column at specified index.
		*/
		public Column getColumnAt(int index) {
			return _columns.get(index);
		}

		/**
		*  Clears all columns in this instance of the Grid.
		*/
		public void clearColumns() {
			_columns.clear();
			__GridImplementation.getColumns().clear();
		}

		/**
		*  Removes column at specified index.
		*/
		public void removeColumnAt(int index) {
			_columns.remove(index);
			__GridImplementation.getColumns().removeAt(index);
		}
		
		/**
		*  Measure override required to update control internals
		*/
		@Override
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			//_gridController.getUpdateScheduler().flush();
			int height = MeasureSpec.getSize(heightMeasureSpec);// this.getHeight();
			int width = MeasureSpec.getSize(widthMeasureSpec); //this.getWidth();

			if (__GridImplementation.getModel().getActualVisibleRegion().getWidth() == 0 || __GridImplementation.getModel().getActualVisibleRegion().getHeight() == 0) {
				__GridImplementation.sizeChanged(width, height);
			}

			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}

		/**
		*  Size Changed override required to update control internals
		*/
		@Override
		protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			//this.flush();
			super.onSizeChanged(w, h, oldw, oldh);
			__GridImplementation.sizeChanged(w,h);
			__GridImplementation.setViewport(this.getScrollX(), this.getScrollY(), this.getScrollX() + w, this.getScrollY() + h);
		}

		/**
		*  Scroll Viewport changed callback required to update control internals
		*/
		protected void onScrollViewportChanged(int l, int t, int r, int b) {
			__GridImplementation.setViewport(l, t, r, b);
		}

		private Object _data;

		/**
		* Attaches a data source to this instance of Grid.
		*/
	    public void setDataSource(Object value) {
			_data = value;
			if (value != null) {
				__GridImplementation.setItemsSource(value);
			} else {
				__GridImplementation.setItemsSource(null);
			}
		}

		/**
		* Returns the current grid data source
		*/
		public Object getDataSource() {
			return _data;
		}

		/**
		* Gets the default animation settings for the grid
		*/
		public com.infragistics.controls.GridAnimationSettings getAnimationSettings() {
			GridAnimationSettingsImplementation value = __GridImplementation.getAnimationSettings();
			if (value == null) {
				return null;
			}

			GridAnimationSettings ext = (GridAnimationSettings)value.getExternalObject();
			if (ext == null) {
				ext = new GridAnimationSettings(value);
				value.setExternalObject(ext);
			}

			return ext;
		}

		/**
		* Sets the default animation settings for the grid
		*/
		public void setAnimationSettings(com.infragistics.controls.GridAnimationSettings value) {
			if (value == null) {
				__GridImplementation.setAnimationSettings(null);
			}
			__GridImplementation.setAnimationSettings(value.getImplementation());
		}

		/**
		* Gets the default column animation settings for the grid
		*/
		public com.infragistics.controls.GridColumnAnimationSettings getColumnAnimationSettings() {
			GridColumnAnimationSettingsImplementation value = __GridImplementation.getColumnAnimationSettings();
			if (value == null) {
				return null;
			}

			GridColumnAnimationSettings ext = (GridColumnAnimationSettings)value.getExternalObject();
			if (ext == null) {
				ext = new GridColumnAnimationSettings(value);
				value.setExternalObject(ext);
			}

			return ext;
		}

		/**
		* Sets the default column animation settings for the grid
		*/
		public void setColumnAnimationSettings(com.infragistics.controls.GridColumnAnimationSettings value) {
			if (value == null) {
				__GridImplementation.setColumnAnimationSettings(null);
			}
			__GridImplementation.setColumnAnimationSettings(value.getImplementation());
		}

		/**
		* Moves a column, using the configured animations, from one index to another
		*/
		public void moveColumn(int oldIndex, int newIndex) {
			__GridImplementation.moveColumn(oldIndex, newIndex);
		}

		/**
		* Exchanges a column on the grid for another column not on the grid, using the configured animations.
		*/
		public void exchangeColumn(Column newColumn, Column existingColumn) {
			if (newColumn == null || existingColumn == null) {
				return;
			}
			__GridImplementation.exchangeColumn(newColumn.getImplementation(), existingColumn.getImplementation());
		}

		/**
		* Sets a listener for the completion for the showing animation
		*/
		public void setOnShowingAnimationCompletedListener(final OnGridAnimationEffectCompletedListener handler) {
			__GridImplementation.setColumnShowingAnimationCompleted(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCompleted((Column) sender);
				}
			});
		}

		/**
		* Sets a listener for the cancelation for the showing animation
		*/
		public void setOnShowingAnimationCanceledListener(final OnGridAnimationEffectCanceledListener handler) {
			__GridImplementation.setColumnShowingAnimationCanceled(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCanceled((Column) sender);
				}
			});
		}
	
		/**
		* Sets a listener for the completion for the hiding animation
		*/
		public void setOnHidingAnimationCompletedListener(final OnGridAnimationEffectCompletedListener handler) {
			__GridImplementation.setColumnHidingAnimationCompleted(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCompleted((Column) sender);
				}
			});
		}

		/**
		* Sets a listener for the cancelation for the hiding animation
		*/
		public void setOnHidingAnimationCanceledListener(final OnGridAnimationEffectCanceledListener handler) {
			__GridImplementation.setColumnHidingAnimationCanceled(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCanceled((Column) sender);
				}
			});
		}

		/**
		* Sets a listener for the completion for the moving animation
		*/
		public void setOnMovingAnimationCompletedListener(final OnGridAnimationEffectCompletedListener handler) {
			__GridImplementation.setColumnMovingAnimationCompleted(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCompleted((Column) sender);
				}
			});
		}

		/**
		* Sets a listener for the cancelation for the moving animation
		*/
		public void setOnMovingAnimationCanceledListener(final OnGridAnimationEffectCanceledListener handler) {
			__GridImplementation.setColumnMovingAnimationCanceled(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCanceled((Column) sender);
				}
			});
		}

		/**
		* Sets a listener for the completion for the exchanging animation
		*/
		public void setOnExchangingAnimationCompletedListener(final OnGridAnimationEffectCompletedListener handler) {
			__GridImplementation.setColumnExchangingAnimationCompleted(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCompleted((Column) sender);
				}
			});
		}

		/**
		* Sets a listener for the cancelation for the exchanging animation
		*/
		public void setOnExchangingAnimationCanceledListner(final OnGridAnimationEffectCanceledListener handler) {
			__GridImplementation.setColumnExchangingAnimationCanceled(new EventHandler__1<EventArgs>() {
				@Override
				public void invoke(Object sender, EventArgs e) {
					handler.animationCanceled((Column) sender);
				}
			});
		}

		/**
		* Add the given index to the selected Indexes collection
		*/
		public void addSelectedIndex(int index) {
			__GridImplementation.addSelectedIndex(index);
		}

		/**
		* Remove the given index from the selected Indexes collection
		*/
		public void removeSelectedIndex(int index) {
			__GridImplementation.removeSelectedIndex(index);
		}

		/**
		* Clear the selected Indexes collection
		*/
		public void clearSelectedIndexes() {
			__GridImplementation.getSelectedIndexes().clear();
		}

		/**
		* Returns an array of all of the selected Indexes
		*/
		public int[] getSelectedIndexes() {
			int[] indexes = new int[__GridImplementation.getSelectedIndexes().getCount()];
			for (int i = 0; i < __GridImplementation.getSelectedIndexes().getCount(); i++) {
				indexes[i] = __GridImplementation.getSelectedIndexes().getItem(i);
			}
			return indexes;
		}
	
		/**
		* Adds the given responsive state to the grid
		*/
		public void addResponsiveState(ResponsiveState state) {
			__GridImplementation.getResponsiveStates().add(state.getImplementation());
		}

		/**
		* Removes the given responsive state from the grid
		*/
		public void removeResponsiveState(ResponsiveState state) {
			__GridImplementation.getResponsiveStates().remove(state.getImplementation());
		}

		/**
		* Clears the responsive states collection
		*/
		public void clearResponsiveState() {
			__GridImplementation.getResponsiveStates().clear();
		}

		/**
		* Returns an array of all of the responsive states
		*/
		public ResponsiveState[] getResponsiveState() {
			ResponsiveState[] states = new ResponsiveState[__GridImplementation.getResponsiveStates().getCount()];
			for (int i = 0; i < __GridImplementation.getResponsiveStates().getCount(); i++) {
				states[i] = (ResponsiveState) __GridImplementation.getResponsiveStates().getItem(i).getExternalObject();
			}
		
			return states;
		}

		/**
		* Gets the underlying data source object used to interact with the data.
		*/
		public DataSource getActualDataSource() {
			return __GridImplementation.getActualDataSource();
		}

		private OnGridSelectedIndexesChangedListener _onGridSelectedIndexesChangedListener = null;
		private GridSelectedIndexesChangedEventHandler _innerGridSelectedChangedEventHandler = null;
		
		/**
		 *  Sets listener for selected indexes changing.
		 */
		public void setOnGridSelectedIndexesChangedListener(final OnGridSelectedIndexesChangedListener listener) {
			_onGridSelectedIndexesChangedListener = listener;
			final DataGridView grid = this;
			_innerGridSelectedChangedEventHandler = new GridSelectedIndexesChangedEventHandler() {
				@Override
				public void invoke(Object sender, GridSelectedIndexesChangedEventArgs e) {
					GridSelectedIndexesChangedEvent event = new GridSelectedIndexesChangedEvent(e);


					_onGridSelectedIndexesChangedListener.selectedIndexesChanged(grid, event);
				}
			};

			if (listener != null) {
				__GridImplementation.setSelectedIndexesChanged(com.infragistics.controls.FunctionDelegate.combine(__GridImplementation.getSelectedIndexesChanged(), _innerGridSelectedChangedEventHandler));
			} else {
				__GridImplementation.setSelectedIndexesChanged(com.infragistics.controls.FunctionDelegate.remove(__GridImplementation.getSelectedIndexesChanged(), _innerGridSelectedChangedEventHandler));
			}
		}

		/**
		* Gets the height of a single row
		*/
		public int getRowHeight() {
			return __GridImplementation.getRowHeight();
		}

		/**
		* Sets the height of a single row
		*/
		public void setRowHeight(int value) {
			this.setRowHeight(TypedValue.COMPLEX_UNIT_DIP, value);
		}

		/**
		* Sets the height of a single row
		*/
		public void setRowHeight(int unit, int value) {
			value = (int) APIHelpers.toPixelUnits(unit, value);
			__GridImplementation.setRowHeight(value);
		}

		/**
		* Gets the height of a row separator
		*/
		public int getRowSeparatorHeight() {
			return __GridImplementation.getRowSeparatorHeight();
		}
		
		/**
		* Sets the height of a row separator
		*/
		public void setRowSeparatorHeight(int value) {
			this.setRowSeparatorHeight(TypedValue.COMPLEX_UNIT_DIP, value);
		}

		/**
		* Sets the height of a row separator
		*/
		public void setRowSeparatorHeight(int unit, int value) {
			value = (int) APIHelpers.toPixelUnits(unit, value);
			__GridImplementation.setRowSeparatorHeight(value);
		}

		/**
		* Gets the height of the header row
		*/
		public int getHeaderHeight() {
			return __GridImplementation.getHeaderHeight();
		}

		/**
		* Sets the height of the header row
		*/
		public void setHeaderHeight(int value) {
			this.setHeaderHeight(TypedValue.COMPLEX_UNIT_DIP, value);
		}

		/**
		* Sets the height of the header row
		*/
		public void setHeaderHeight(int unit, int value) {
			value = (int) APIHelpers.toPixelUnits(unit, value);
			__GridImplementation.setHeaderHeight(value);
		}

		/**
		* Manually set the active responsive state of the grid.
		*/
		public void setActiveResponsiveState(ResponsiveState state) {
			__GridImplementation.setActiveResponsiveState(state.getImplementation());
		}





















	/**
	* Configures whether or not the grid will autogenerate columns when the data source is set.
	*/
	public boolean getAutoGenerateColumns() {
	return __GridImplementation.getAutoGenerateColumns();
	}
	/**
	* Configures whether or not the grid will autogenerate columns when the data source is set.
	*/
	public void setAutoGenerateColumns(boolean value) {
	__GridImplementation.setAutoGenerateColumns(value);
	}

	/**
	* Configures whether or not place holders are used for cells who do not have their data yet.
	*/
	public boolean getIsPlaceholderRenderingEnabled() {
	return __GridImplementation.getIsPlaceholderRenderingEnabled();
	}
	/**
	* Configures whether or not place holders are used for cells who do not have their data yet.
	*/
	public void setIsPlaceholderRenderingEnabled(boolean value) {
	__GridImplementation.setIsPlaceholderRenderingEnabled(value);
	}


	/**
	* Configures the Column Adding Animation Style
	*/
	public com.infragistics.controls.ColumnShowingStyle getColumnAddingAnimationStyle() {
	return __GridImplementation.getColumnAddingAnimationStyle();
	}
	/**
	* Configures the Column Adding Animation Style
	*/
	public void setColumnAddingAnimationStyle(com.infragistics.controls.ColumnShowingStyle value) {
	__GridImplementation.setColumnAddingAnimationStyle(value);
	}


	/**
	* Configures the Column Property Updating Animation Style
	*/
	public com.infragistics.controls.ColumnPropertyUpdatingStyle getColumnPropertyUpdatingAnimationStyle() {
	return __GridImplementation.getColumnPropertyUpdatingAnimationStyle();
	}
	/**
	* Configures the Column Property Updating Animation Style
	*/
	public void setColumnPropertyUpdatingAnimationStyle(com.infragistics.controls.ColumnPropertyUpdatingStyle value) {
	__GridImplementation.setColumnPropertyUpdatingAnimationStyle(value);
	}



	/**
	* Configures the Cell Actualization Animation Style
	*/
	public com.infragistics.controls.CellActualizationStyle getCellActualizationAnimationStyle() {
	return __GridImplementation.getCellActualizationAnimationStyle();
	}
	/**
	* Configures the Cell Actualization Animation Style
	*/
	public void setCellActualizationAnimationStyle(com.infragistics.controls.CellActualizationStyle value) {
	__GridImplementation.setCellActualizationAnimationStyle(value);
	}


	/**
	* Configures the Row Selection Animation Style
	*/
	public com.infragistics.controls.RowSelectionStyle getRowSelectionAnimationStyle() {
	return __GridImplementation.getRowSelectionAnimationStyle();
	}
	/**
	* Configures the Row Selection Animation Style
	*/
	public void setRowSelectionAnimationStyle(com.infragistics.controls.RowSelectionStyle value) {
	__GridImplementation.setRowSelectionAnimationStyle(value);
	}


	/**
	* Configures the Column Showing Animation Style
	*/
	public com.infragistics.controls.ColumnShowingStyle getColumnShowingAnimationStyle() {
	return __GridImplementation.getColumnShowingAnimationStyle();
	}
	/**
	* Configures the Column Showing Animation Style
	*/
	public void setColumnShowingAnimationStyle(com.infragistics.controls.ColumnShowingStyle value) {
	__GridImplementation.setColumnShowingAnimationStyle(value);
	}


	/**
	* Configures the Column Moving Animation Style
	*/
	public com.infragistics.controls.ColumnMovingStyle getColumnMovingAnimationStyle() {
	return __GridImplementation.getColumnMovingAnimationStyle();
	}
	/**
	* Configures the Column Moving Animation Style
	*/
	public void setColumnMovingAnimationStyle(com.infragistics.controls.ColumnMovingStyle value) {
	__GridImplementation.setColumnMovingAnimationStyle(value);
	}


	/**
	* Configures the Column Hiding Animation Style
	*/
	public com.infragistics.controls.ColumnHidingStyle getColumnHidingAnimationStyle() {
	return __GridImplementation.getColumnHidingAnimationStyle();
	}
	/**
	* Configures the Column Hiding Animation Style
	*/
	public void setColumnHidingAnimationStyle(com.infragistics.controls.ColumnHidingStyle value) {
	__GridImplementation.setColumnHidingAnimationStyle(value);
	}


	/**
	* Configures the Column Exchanging Animation Style
	*/
	public com.infragistics.controls.ColumnExchangingStyle getColumnExchangingAnimationStyle() {
	return __GridImplementation.getColumnExchangingAnimationStyle();
	}
	/**
	* Configures the Column Exchanging Animation Style
	*/
	public void setColumnExchangingAnimationStyle(com.infragistics.controls.ColumnExchangingStyle value) {
	__GridImplementation.setColumnExchangingAnimationStyle(value);
	}

	/**
	* Configures the grid selection mode
	*/
	public com.infragistics.controls.GridSelectionMode getSelectionMode() {
	return __GridImplementation.getSelectionMode();
	}
	/**
	* Configures the grid selection mode
	*/
	public void setSelectionMode(com.infragistics.controls.GridSelectionMode value) {
	__GridImplementation.setSelectionMode(value);
	}


	/**
	* The index of the currently selected item on the grid
	*/
	public int getSelectedIndex() {
	return __GridImplementation.getSelectedIndex();
	}
	/**
	* The index of the currently selected item on the grid
	*/
	public void setSelectedIndex(int value) {
	__GridImplementation.setSelectedIndex(value);
	}









	/**
	* Returns a serialized copy of the exported visual model
	*/
	public String exportSerializedVisualModel() {
		return __GridImplementation.exportSerializedVisualModel();
	}

	/**
	* Scrolls the grid to given row, by index
	* @param rowNumber 
	*/
	public void scrollToRowByIndex(double rowNumber) {
		__GridImplementation.scrollToRowByIndex(rowNumber);
	}

	/**
	* Manually set the active responsive state of the grid.
	* @param name 
	*/
	public void setActiveResponsiveState(String name) {
		__GridImplementation.setActiveResponsiveState(name);
	}

	/**
	* Manually notifies the grid's data source that an item has been changed in the data it is bound to.
	* This should not be called the data that the grid is bound to is already observable.
	* @param index The index of the changed item.
	* @param oldItem The old item at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	* @param newItem The new item at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	*/
	public void notifySetItem(int index, Object oldItem, Object newItem) {
		__GridImplementation.notifySetItem(index, oldItem, newItem);
	}

	/**
	* Manually notifies the grid's data source that the data it has bound to has been cleared and needs to be re-examined.
	* This should not be called if the data that the grid is bound to is already observable.
	*/
	public void notifyClearItems() {
		__GridImplementation.notifyClearItems();
	}

	/**
	* Manually notifies the grid's data source that an item has been inserted in the data it is bound to.
	* This should not be called if the data that the grid is bound to is already observable.
	* @param index The index of the inserted item.
	* @param newItem The new item at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	*/
	public void notifyInsertItem(int index, Object newItem) {
		__GridImplementation.notifyInsertItem(index, newItem);
	}

	/**
	* Manually notifies the grid's data source that an item has been removed in the data it is bound to.
	* This should not be called if the data that the grid is bound to is already observable.
	* @param index The index of the removed item.
	* @param oldItem The old item at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	*/
	public void notifyRemoveItem(int index, Object oldItem) {
		__GridImplementation.notifyRemoveItem(index, oldItem);
	}

	/**
	* Manually notifies the grid's data source that some items have been changed in the data it is bound to.
	* This should not be called if the data that the data source is bound to is already observable.
	* @param startingIndex The starting index of the changed items.
	* @param oldItems The old items starting at the desginated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	* @param newItems The new items starting at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	*/
	public void notifySetItems(int startingIndex, java.util.List oldItems, java.util.List newItems) {
		__GridImplementation.notifySetItems(startingIndex, oldItems, newItems);
	}

	/**
	* Manually notifies the grid's data source that some items have been inserted in the data it is bound to.
	* This should not be called if the data that the data source is bound to is already observable.
	* @param startingIndex The starting index of the inserted items.
	* @param newItems The new items starting at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	*/
	public void notifyInsertItems(int startingIndex, java.util.List newItems) {
		__GridImplementation.notifyInsertItems(startingIndex, newItems);
	}

	/**
	* Manually notifies the grid's data source that some items have been removed in the data it is bound to.
	* This should not be called if the data that the data source is bound to is already observable.
	* @param startingIndex The starting index of the removed items.
	* @param oldItems The old items starting at the designated index. You can optionally omit this value only if IsVirtual == true for the grid's data source.
	*/
	public void notifyRemoveItems(int startingIndex, java.util.List oldItems) {
		__GridImplementation.notifyRemoveItems(startingIndex, oldItems);
	}

}
