//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class GridStyleRepository {
private static Brush _rowSeparatorBackgroundColor;


public static Brush getRowSeparatorBackgroundColor() {

		if (_rowSeparatorBackgroundColor == null) {
			_rowSeparatorBackgroundColor = (new Object() { 
				public Brush invoke() {
					Brush __ret = new Brush();
					__ret.setFill("Black");
					return __ret;
				}
			}).invoke();
		}

		return _rowSeparatorBackgroundColor;

}


public static double getTextCellFontSize() {

		return 12;

}


public static String getTextCellFontFamily() {

		return "Segoe UI";

}

private static Brush _textCellTextColor = null;


public static Brush getTextCellTextColor() {

		if (_textCellTextColor == null) {
			_textCellTextColor = (new Object() { 
				public Brush invoke() {
					Brush __ret = new Brush();
					__ret.setFill("Black");
					return __ret;
				}
			}).invoke();
		}

		return _textCellTextColor;

}

private static Brush _defaultSelectedBackgroundColor = null;


public static Brush getDefaultSelectedBackgroundColor() {

		if (_defaultSelectedBackgroundColor == null) {
			_defaultSelectedBackgroundColor = new Brush();
			_defaultSelectedBackgroundColor.setFill("rgba(58,190,232,1)");
		}

		return _defaultSelectedBackgroundColor;

}

private static Brush _defaultBackgroundColor = null;


public static Brush getDefaultBackgroundColor() {

		if (_defaultBackgroundColor == null) {
			_defaultBackgroundColor = (new Object() { 
				public Brush invoke() {
					Brush __ret = new Brush();
					__ret.setFill("White");
					return __ret;
				}
			}).invoke();
		}

		return _defaultBackgroundColor;

}

private static Brush _headerBackgroundColor = null;


public static Brush getHeaderBackgroundColor() {

		if (_headerBackgroundColor == null) {
			_headerBackgroundColor = (new Object() { 
				public Brush invoke() {
					Brush __ret = new Brush();
					__ret.setFill("Black");
					return __ret;
				}
			}).invoke();
		}

		return _headerBackgroundColor;

}

private static Brush _headerTextColor = null;


public static Brush getHeaderTextColor() {

		if (_headerTextColor == null) {
			_headerTextColor = (new Object() { 
				public Brush invoke() {
					Brush __ret = new Brush();
					__ret.setFill("White");
					return __ret;
				}
			}).invoke();
		}

		return _headerTextColor;

}

}
