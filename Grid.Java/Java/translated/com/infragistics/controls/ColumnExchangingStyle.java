//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



public enum ColumnExchangingStyle {
	AUTO(0), 
	NONE(1), 
	SLIDE_TO_LEFT(2), 
	SLIDE_TO_RIGHT(3), 
	SLIDE_TO_TOP(4), 
	SLIDE_TO_BOTTOM(5), 
	CROSSFADE(6), 
	SLIDE_TO_LEFT_AND_CROSSFADE(7), 
	SLIDE_TO_RIGHT_AND_CROSSFADE(8), 
	SLIDE_TO_TOP_AND_CROSSFADE(9), 
	SLIDE_TO_BOTTOM_AND_CROSSFADE(10);
	private int _value;
	private ColumnExchangingStyle(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ColumnExchangingStyle valueOf(int value) {
		switch (value) {
			case 0: 
				return AUTO;
			case 1: 
				return NONE;
			case 2: 
				return SLIDE_TO_LEFT;
			case 3: 
				return SLIDE_TO_RIGHT;
			case 4: 
				return SLIDE_TO_TOP;
			case 5: 
				return SLIDE_TO_BOTTOM;
			case 6: 
				return CROSSFADE;
			case 7: 
				return SLIDE_TO_LEFT_AND_CROSSFADE;
			case 8: 
				return SLIDE_TO_RIGHT_AND_CROSSFADE;
			case 9: 
				return SLIDE_TO_TOP_AND_CROSSFADE;
			case 10: 
				return SLIDE_TO_BOTTOM_AND_CROSSFADE;
			default:
				return null;
		}
	}
}