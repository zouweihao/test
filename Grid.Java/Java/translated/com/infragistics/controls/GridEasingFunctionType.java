//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

public enum GridEasingFunctionType {
	LINEAR(0), 
	CUBIC_IN_OUT(1), 
	EXPONENTIAL_IN_OUT(2), 
	CIRCLE_IN_OUT(3);
	private int _value;
	private GridEasingFunctionType(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static GridEasingFunctionType valueOf(int value) {
		switch (value) {
			case 0: 
				return LINEAR;
			case 1: 
				return CUBIC_IN_OUT;
			case 2: 
				return EXPONENTIAL_IN_OUT;
			case 3: 
				return CIRCLE_IN_OUT;
			default:
				return null;
		}
	}
}