//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



public enum ColumnShowingStyle {
	AUTO(0), 
	NONE(1), 
	SLIDE_FROM_LEFT(2), 
	SLIDE_FROM_RIGHT(3), 
	SLIDE_FROM_TOP(4), 
	SLIDE_FROM_BOTTOM(5), 
	FADE_IN(6), 
	SLIDE_FROM_LEFT_AND_FADE_IN(7), 
	SLIDE_FROM_RIGHT_AND_FADE_IN(8), 
	SLIDE_FROM_TOP_AND_FADE_IN(9), 
	SLIDE_FROM_BOTTOM_AND_FADE_IN(10);
	private int _value;
	private ColumnShowingStyle(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ColumnShowingStyle valueOf(int value) {
		switch (value) {
			case 0: 
				return AUTO;
			case 1: 
				return NONE;
			case 2: 
				return SLIDE_FROM_LEFT;
			case 3: 
				return SLIDE_FROM_RIGHT;
			case 4: 
				return SLIDE_FROM_TOP;
			case 5: 
				return SLIDE_FROM_BOTTOM;
			case 6: 
				return FADE_IN;
			case 7: 
				return SLIDE_FROM_LEFT_AND_FADE_IN;
			case 8: 
				return SLIDE_FROM_RIGHT_AND_FADE_IN;
			case 9: 
				return SLIDE_FROM_TOP_AND_FADE_IN;
			case 10: 
				return SLIDE_FROM_BOTTOM_AND_FADE_IN;
			default:
				return null;
		}
	}
}