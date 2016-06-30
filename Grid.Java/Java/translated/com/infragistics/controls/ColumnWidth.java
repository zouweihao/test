//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import android.util.TypedValue;
import com.infragistics.controls.*;

/**
*  Represents a class used to define the width of a grid column.
*/
public class ColumnWidth {

	private ColumnWidthImplementation __ColumnWidthImplementation;

	ColumnWidthImplementation getImplementation() {
		return  __ColumnWidthImplementation;
	}

	public ColumnWidth() {
		this(new ColumnWidthImplementation());
	}

	ColumnWidth(ColumnWidthImplementation implementation) {
		__ColumnWidthImplementation = implementation;
		__ColumnWidthImplementation.setExternalObject(this);
	}

	/**
	* Gets the value of the width of the column
	*/
	public int getValue() {
		return __ColumnWidthImplementation.getValue();
	}
	
	/**
	* Sets the value of the width of the column
	*/
	public void setValue(int value) {
		this.setValue(TypedValue.COMPLEX_UNIT_DIP, value);
	}

	/**
	* Sets the value of the width of the column
	*/
	public void setValue(int unit, int value) {
		value = (int) APIHelpers.toPixelUnits(unit, value);
		__ColumnWidthImplementation.setValue(value);
	}

	/**
	* Gets the value of the minimum width of the column
	*/
	public int getMinimumWidth() {
	return __ColumnWidthImplementation.getMinimumWidth();
	}

	/**
	* Sets the value of the minimum width of the column
	*/
	public void setMinimumWidth(int value) {
		this.setMinimumWidth(TypedValue.COMPLEX_UNIT_DIP, value);
	}

	/**
	* Sets the value of the minimum width of the column
	*/
	public void setMinimumWidth(int unit, int value) {
		value = (int) APIHelpers.toPixelUnits(unit, value);
		__ColumnWidthImplementation.setMinimumWidth(value);
	}

	/**
	* Gets an instance of the Column Width Object with default values set.
	*/
	public ColumnWidth getDefault() {
		ColumnWidthImplementation inner = __ColumnWidthImplementation.getDefault();
		ColumnWidth columnWidth = new ColumnWidth(inner);
		return columnWidth;
	}


	/**
	* Configures whether to use star sizing for the column's width
	*/
	public boolean getIsStarSized() {
	return __ColumnWidthImplementation.getIsStarSized();
	}
	/**
	* Configures whether to use star sizing for the column's width
	*/
	public void setIsStarSized(boolean value) {
	__ColumnWidthImplementation.setIsStarSized(value);
	}

}
