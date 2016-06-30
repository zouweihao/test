//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
/**
* Represents a base class used to configure the appearance of the column header cells.
*/
public class Header extends DefinitionBase {

private HeaderImplementation __HeaderImplementation;
HeaderImplementation getImplementation() { return __HeaderImplementation; }
Header(HeaderImplementation HeaderImpl) {
super(HeaderImpl);
__HeaderImplementation = HeaderImpl;
}


}
