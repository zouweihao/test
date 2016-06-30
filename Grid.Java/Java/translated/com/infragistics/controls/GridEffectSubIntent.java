//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

enum GridEffectSubIntent {
	DEFAULT(0), 
	MOVE(1), 
	SHOW(2), 
	HIDE(3), 
	EXCHANGE(4), 
	HEADER_PROPERTY_CHANGE(5);
	private int _value;
	private GridEffectSubIntent(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static GridEffectSubIntent valueOf(int value) {
		switch (value) {
			case 0: 
				return DEFAULT;
			case 1: 
				return MOVE;
			case 2: 
				return SHOW;
			case 3: 
				return HIDE;
			case 4: 
				return EXCHANGE;
			case 5: 
				return HEADER_PROPERTY_CHANGE;
			default:
				return null;
		}
	}
}