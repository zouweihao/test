//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
/**
* Used to configure the appearance of the section footer cells.
*/
public class SectionFooter extends DefinitionBase {

private SectionFooterImplementation __SectionFooterImplementation;
SectionFooterImplementation getImplementation() { return __SectionFooterImplementation; }
public SectionFooter() {
this(new SectionFooterImplementation());
}SectionFooter(SectionFooterImplementation SectionFooterImpl) {
super(SectionFooterImpl);
__SectionFooterImplementation = SectionFooterImpl;
}

}
