//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



public enum ColumnMovingStyle {
	AUTO(0), 
	NONE(1), 
	SLIDE_OVER(2);
	private int _value;
	private ColumnMovingStyle(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ColumnMovingStyle valueOf(int value) {
		switch (value) {
			case 0: 
				return AUTO;
			case 1: 
				return NONE;
			case 2: 
				return SLIDE_OVER;
			default:
				return null;
		}
	}
}