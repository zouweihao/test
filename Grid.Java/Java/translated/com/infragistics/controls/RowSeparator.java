//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
/**
* Represents a Row separator, this is used to visually separate the rows in a grid
*/
public class RowSeparator extends DefinitionBase {

private RowSeparatorImplementation __RowSeparatorImplementation;
RowSeparatorImplementation getImplementation() { return __RowSeparatorImplementation; }
public RowSeparator() {
this(new RowSeparatorImplementation());
}RowSeparator(RowSeparatorImplementation RowSeparatorImpl) {
super(RowSeparatorImpl);
__RowSeparatorImplementation = RowSeparatorImpl;
}

}
