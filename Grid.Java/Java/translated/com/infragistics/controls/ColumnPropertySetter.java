//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*  Represents a class used to dynamically set a property on a column for a Responsive Phase.
*/
public class ColumnPropertySetter {

    private ColumnPropertySetterImplementation __ColumnPropertySetterImplementation;

    ColumnPropertySetterImplementation getImplementation() {
        return __ColumnPropertySetterImplementation;
    }

	public ColumnPropertySetter(String columnName, String propertyName, Object value) {
		this();

		this.setColumnName(columnName);
		this.setPropertyName(propertyName);
		this.setValue(value);
	}


    public ColumnPropertySetter() {
        this(new ColumnPropertySetterImplementation());
    }

    ColumnPropertySetter(ColumnPropertySetterImplementation ColumnPropertySetterImpl) {

        __ColumnPropertySetterImplementation = ColumnPropertySetterImpl;
    }

	

	/**
	* The name or key of the column to change the property of
	*/
	public String getColumnName() {
	return __ColumnPropertySetterImplementation.getColumnName();
	}
	/**
	* The name or key of the column to change the property of
	*/
	public void setColumnName(String value) {
	__ColumnPropertySetterImplementation.setColumnName(value);
	}

	/**
	* The name of the property to change
	*/
	public String getPropertyName() {
	return __ColumnPropertySetterImplementation.getPropertyName();
	}
	/**
	* The name of the property to change
	*/
	public void setPropertyName(String value) {
	__ColumnPropertySetterImplementation.setPropertyName(value);
	}

	/**
	* The new value of the property
	*/
	public Object getValue() {
	return __ColumnPropertySetterImplementation.getValue();
	}
	/**
	* The new value of the property
	*/
	public void setValue(Object value) {
	__ColumnPropertySetterImplementation.setValue(value);
	}

}
