//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



enum CellPropertyAnimationType {
	DOUBLE_VALUE(0), 
	NUMBER_VALUE(1), 
	BRUSH_VALUE(2), 
	FONT_VALUE(3), 
	ENUM_VALUE(4), 
	BOOL_VALUE(5), 
	INT_VALUE(6), 
	DATE_VALUE(7), 
	STRING_VALUE(8), 
	OBJECT_VALUE(9), 
	IGNORED_VALUE(10);
	private int _value;
	private CellPropertyAnimationType(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static CellPropertyAnimationType valueOf(int value) {
		switch (value) {
			case 0: 
				return DOUBLE_VALUE;
			case 1: 
				return NUMBER_VALUE;
			case 2: 
				return BRUSH_VALUE;
			case 3: 
				return FONT_VALUE;
			case 4: 
				return ENUM_VALUE;
			case 5: 
				return BOOL_VALUE;
			case 6: 
				return INT_VALUE;
			case 7: 
				return DATE_VALUE;
			case 8: 
				return STRING_VALUE;
			case 9: 
				return OBJECT_VALUE;
			case 10: 
				return IGNORED_VALUE;
			default:
				return null;
		}
	}
}