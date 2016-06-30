//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*  Represents a class used to define a column exchange animation for a Responsive Phase.
*/
public class ColumnExchanger {

    private ColumnExchangerImplementation __ColumnExchangerImplementation;

    ColumnExchangerImplementation getImplementation() {
        return __ColumnExchangerImplementation;
    }

    public ColumnExchanger() {
        this(new ColumnExchangerImplementation());
    }
    
    public ColumnExchanger(Column column, int targetIndex) {
		this();
        __ColumnExchangerImplementation.setColumn(column.getImplementation());
        __ColumnExchangerImplementation.setTargetIndex(targetIndex);
    }

    ColumnExchanger(ColumnExchangerImplementation ColumnExchangerImpl) {

        __ColumnExchangerImplementation = ColumnExchangerImpl;
    }

	/**
	* Gets the Column to exchange in.
	*/
	public Column getColumn() {
        return (Column) __ColumnExchangerImplementation.getColumn().getExternalObject();
    }
    
	/**
	* Sets the Column to exchange in.
	*/
    public void setColumn(Column column) {
        __ColumnExchangerImplementation.setColumn(column.getImplementation());
    }



	/**
	* The desired location of the new column
	*/
	public int getTargetIndex() {
	return __ColumnExchangerImplementation.getTargetIndex();
	}
	/**
	* The desired location of the new column
	*/
	public void setTargetIndex(int value) {
	__ColumnExchangerImplementation.setTargetIndex(value);
	}


}
