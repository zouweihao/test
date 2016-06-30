//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



public enum RowSelectionStyle {
	AUTO(0), 
	NONE(1), 
	COLOR_BLEND(2);
	private int _value;
	private RowSelectionStyle(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static RowSelectionStyle valueOf(int value) {
		switch (value) {
			case 0: 
				return AUTO;
			case 1: 
				return NONE;
			case 2: 
				return COLOR_BLEND;
			default:
				return null;
		}
	}
}