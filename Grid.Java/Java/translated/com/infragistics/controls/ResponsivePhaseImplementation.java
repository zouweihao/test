//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class ResponsivePhaseImplementation {

private Object _externalObject;
public Object setExternalObject(Object value) {
_externalObject = value;
return value;
}
public Object getExternalObject() {
	return _externalObject;
}


private String _name;
public String setName(String value) {
_name = value;
return value;
}
public String getName() {
	return _name;
}


private int _delayMilliseconds;
public int setDelayMilliseconds(int value) {
_delayMilliseconds = value;
return value;
}
public int getDelayMilliseconds() {
	return _delayMilliseconds;
}

private ColumnPropertySettersCollection _columnPropertySetters = new ColumnPropertySettersCollection();


public ColumnPropertySettersCollection getColumnPropertySetters() {

		return _columnPropertySetters;

}

private ColumnExchangersCollection _columnExchangers = new ColumnExchangersCollection();


public ColumnExchangersCollection getColumnExchangers() {

		return _columnExchangers;

}

}
