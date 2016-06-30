//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



public enum ColumnPropertyUpdatingStyle {
	AUTO(0), 
	NONE(1), 
	INTERPOLATE(2), 
	INTERPOLATE_DEEP(3);
	private int _value;
	private ColumnPropertyUpdatingStyle(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ColumnPropertyUpdatingStyle valueOf(int value) {
		switch (value) {
			case 0: 
				return AUTO;
			case 1: 
				return NONE;
			case 2: 
				return INTERPOLATE;
			case 3: 
				return INTERPOLATE_DEEP;
			default:
				return null;
		}
	}
}