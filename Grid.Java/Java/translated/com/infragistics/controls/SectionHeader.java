//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
/**
* Used to configure the appearance of the section header cells.
*/
public class SectionHeader extends DefinitionBase {

private SectionHeaderImplementation __SectionHeaderImplementation;
SectionHeaderImplementation getImplementation() { return __SectionHeaderImplementation; }
public SectionHeader() {
this(new SectionHeaderImplementation());
}SectionHeader(SectionHeaderImplementation SectionHeaderImpl) {
super(SectionHeaderImpl);
__SectionHeaderImplementation = SectionHeaderImpl;
}

}
