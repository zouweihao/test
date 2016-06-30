//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
/**
* Represents a Text grid column, used to allow the developer to display a formatted text in a cell.
*/
public class TextColumn extends Column {

private TextColumnImplementation __TextColumnImplementation;
TextColumnImplementation getImplementation() { return __TextColumnImplementation; }
public TextColumn() {
this(new TextColumnImplementation());
}TextColumn(TextColumnImplementation TextColumnImpl) {
super(TextColumnImpl);
__TextColumnImplementation = TextColumnImpl;
}

/**
* The format string to apply to the text value
*/
public String getFormatString() {
return __TextColumnImplementation.getFormatString();
}
/**
* The format string to apply to the text value
*/
public void setFormatString(String value) {
__TextColumnImplementation.setFormatString(value);
}

}
