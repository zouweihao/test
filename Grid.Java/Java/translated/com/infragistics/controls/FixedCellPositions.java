//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


enum FixedCellPositions {
	NONE(0), 
	LEFT(1), 
	RIGHT(2), 
	TOP(3), 
	BOTTOM(4);
	private int _value;
	private FixedCellPositions(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static FixedCellPositions valueOf(int value) {
		switch (value) {
			case 0: 
				return NONE;
			case 1: 
				return LEFT;
			case 2: 
				return RIGHT;
			case 3: 
				return TOP;
			case 4: 
				return BOTTOM;
			default:
				return null;
		}
	}
}