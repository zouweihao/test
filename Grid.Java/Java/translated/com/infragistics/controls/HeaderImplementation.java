//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
abstract class HeaderImplementation
extends DefinitionBaseImplementation {
public HeaderImplementation() {



		setActualHeaderText("");
}


private String _actualHeaderText;
public String setActualHeaderText(String value) {
_actualHeaderText = value;
return value;
}
public String getActualHeaderText() {
	return _actualHeaderText;
}

}
