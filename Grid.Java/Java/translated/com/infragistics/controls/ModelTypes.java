//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;


enum ModelTypes {
	COLUMN_HEADER(0), 
	CELL(1), 
	SECTION_HEADER(2), 
	SECTION_FOOTER(3), 
	ROW_SEPARATOR(4);
	private int _value;
	private ModelTypes(int value) {
		_value = value;
	}
	public int getValue() {
		return _value;
	}
	public static ModelTypes valueOf(int value) {
		switch (value) {
			case 0: 
				return COLUMN_HEADER;
			case 1: 
				return CELL;
			case 2: 
				return SECTION_HEADER;
			case 3: 
				return SECTION_FOOTER;
			case 4: 
				return ROW_SEPARATOR;
			default:
				return null;
		}
	}
}