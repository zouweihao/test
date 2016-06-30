//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
public enum ImageStretchOptions {
	UNIFORM(0), 
	FILL(1), 
	NONE(2);
	private int _value;
	private ImageStretchOptions(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ImageStretchOptions valueOf(int value) {
		switch (value) {
			case 0: 
				return UNIFORM;
			case 1: 
				return FILL;
			case 2: 
				return NONE;
			default:
				return null;
		}
	}
}