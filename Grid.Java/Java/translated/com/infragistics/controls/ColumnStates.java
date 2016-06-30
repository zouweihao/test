//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


enum ColumnStates {
	DETACHED(0), 
	SHOWING(1), 
	HIDING(2), 
	HIDDEN(3), 
	SWAPPING(4), 
	VISIBLE(5), 
	MOVING(6);
	private int _value;
	private ColumnStates(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ColumnStates valueOf(int value) {
		switch (value) {
			case 0: 
				return DETACHED;
			case 1: 
				return SHOWING;
			case 2: 
				return HIDING;
			case 3: 
				return HIDDEN;
			case 4: 
				return SWAPPING;
			case 5: 
				return VISIBLE;
			case 6: 
				return MOVING;
			default:
				return null;
		}
	}
}