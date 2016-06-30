//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
public enum GridSelectionMode {
	NONE(0), 
	SINGLE_ROW(1), 
	MULTIPLE_ROW(2);
	private int _value;
	private GridSelectionMode(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static GridSelectionMode valueOf(int value) {
		switch (value) {
			case 0: 
				return NONE;
			case 1: 
				return SINGLE_ROW;
			case 2: 
				return MULTIPLE_ROW;
			default:
				return null;
		}
	}
}