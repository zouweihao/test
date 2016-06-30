//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
public enum DateTimeFormats {
	FULL(0), 
	DATE_LONG(1), 
	DATE_SHORT(2), 
	TIME_LONG(3), 
	TIME_SHORT(4);
	private int _value;
	private DateTimeFormats(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static DateTimeFormats valueOf(int value) {
		switch (value) {
			case 0: 
				return FULL;
			case 1: 
				return DATE_LONG;
			case 2: 
				return DATE_SHORT;
			case 3: 
				return TIME_LONG;
			case 4: 
				return TIME_SHORT;
			default:
				return null;
		}
	}
}