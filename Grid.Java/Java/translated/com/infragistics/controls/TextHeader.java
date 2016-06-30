//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
/**
* Represents a class used to configure the appearance of a text column header cells.
*/
public class TextHeader extends Header {

private TextHeaderImplementation __TextHeaderImplementation;
TextHeaderImplementation getImplementation() { return __TextHeaderImplementation; }
public TextHeader() {
this(new TextHeaderImplementation());
}TextHeader(TextHeaderImplementation TextHeaderImpl) {
super(TextHeaderImpl);
__TextHeaderImplementation = TextHeaderImpl;
}

}
