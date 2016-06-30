//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;



public enum CellActualizationStyle {
	AUTO(0), 
	NONE(1), 
	CROSS_FADE(2);
	private int _value;
	private CellActualizationStyle(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static CellActualizationStyle valueOf(int value) {
		switch (value) {
			case 0: 
				return AUTO;
			case 1: 
				return NONE;
			case 2: 
				return CROSS_FADE;
			default:
				return null;
		}
	}
}