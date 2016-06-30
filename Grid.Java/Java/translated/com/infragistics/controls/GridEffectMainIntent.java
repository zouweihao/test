//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

enum GridEffectMainIntent {
	DEFAULT(0), 
	POSITION(1), 
	OPACITY(2), 
	VIRTUALIZATION(3), 
	DIMENSIONS(4), 
	SELECTION(5), 
	DATA_CHANGE(6), 
	COLUMN_PROPERTY_CHANGE(7);
	private int _value;
	private GridEffectMainIntent(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static GridEffectMainIntent valueOf(int value) {
		switch (value) {
			case 0: 
				return DEFAULT;
			case 1: 
				return POSITION;
			case 2: 
				return OPACITY;
			case 3: 
				return VIRTUALIZATION;
			case 4: 
				return DIMENSIONS;
			case 5: 
				return SELECTION;
			case 6: 
				return DATA_CHANGE;
			case 7: 
				return COLUMN_PROPERTY_CHANGE;
			default:
				return null;
		}
	}
}