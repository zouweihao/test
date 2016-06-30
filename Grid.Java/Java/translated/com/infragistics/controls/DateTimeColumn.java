//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*  Represents a DateTime grid column, used to display Calendar Objects with a variety of formats.
*/
public class DateTimeColumn 
	extends Column {

	private DateTimeColumnImplementation __DateTimeColumnImplementation;

    DateTimeColumnImplementation getImplementation() {
        return __DateTimeColumnImplementation;
    }

    public DateTimeColumn() {
        this(new DateTimeColumnImplementation());
    }

    DateTimeColumn(DateTimeColumnImplementation DateTimeColumnImpl) {
        super(DateTimeColumnImpl);
        __DateTimeColumnImplementation = DateTimeColumnImpl;
    }

	/**
	* Gets DateTimeFormat of the column
	*/
    public DateTimeFormats getDateTimeFormat() {
        return this.__DateTimeColumnImplementation.getDateTimeFormat();
    }

	/**
	* Sets the DateTimeFormat of the column
	*/
    public void setDateTimeFormat(DateTimeFormats dateTimeFormat) {
        this.__DateTimeColumnImplementation.setDateTimeFormat(dateTimeFormat);
    }


}
