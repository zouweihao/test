//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


enum ModelStates {
	NEW(0), 
	RECYCLED(1), 
	INVIEW(2);
	private int _value;
	private ModelStates(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ModelStates valueOf(int value) {
		switch (value) {
			case 0: 
				return NEW;
			case 1: 
				return RECYCLED;
			case 2: 
				return INVIEW;
			default:
				return null;
		}
	}
}