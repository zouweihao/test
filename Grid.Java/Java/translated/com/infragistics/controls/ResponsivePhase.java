//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*  Represents a Responsive Phase, which is used to change the properties of and exchange columns in a Responsive State.
*/
public class ResponsivePhase {

	private ResponsivePhaseImplementation __ResponsivePhaseImplementation;

	ResponsivePhaseImplementation getImplementation() {
		return  __ResponsivePhaseImplementation;
	}

	public ResponsivePhase() {
		__ResponsivePhaseImplementation = new ResponsivePhaseImplementation();
		__ResponsivePhaseImplementation.setExternalObject(this);
	}

	/**
	* Adds a new Column Property Setter for dynamically changing the properties of a column
	*/
	public ResponsivePhase addColumnPropertySetter(ColumnPropertySetter setter) {
		__ResponsivePhaseImplementation.getColumnPropertySetters().add(setter.getImplementation());
		return this;
	}

	/**
	* Remove an existing Column Property Setter
	*/
	public void removeColumnPropertySetter(ColumnPropertySetter setter) {
		__ResponsivePhaseImplementation.getColumnPropertySetters().remove(setter.getImplementation());
	}

	/**
	* Clears the Column Property Setter collection
	*/
	public void clearColumnPropertySetter() {
		__ResponsivePhaseImplementation.getColumnPropertySetters().clear();
	}

	/**
	* Gets an array of all active Column Property Setters
	*/
	public ColumnPropertySetter[] getColumnPropertySetter() {
		ColumnPropertySetter[] setters = new ColumnPropertySetter[__ResponsivePhaseImplementation.getColumnPropertySetters().getCount()];
		for (int i = 0; i < __ResponsivePhaseImplementation.getColumnPropertySetters().getCount(); i++) {
			setters[i] = (ColumnPropertySetter) __ResponsivePhaseImplementation.getColumnPropertySetters().getItem(i).getExternalObject();
		}

		return setters;
	}

	/**
	* Adds a new Column Exchanger for dynamically exchanging a column
	*/
	public ResponsivePhase addColumnExchanger(ColumnExchanger exchanger) {
		__ResponsivePhaseImplementation.getColumnExchangers().add(exchanger.getImplementation());
		return this;
	}
	
	/**
	* Remove an existing Column Exchanger
	*/
	public void removeColumnExchanger(ColumnExchanger exchanger) {
		__ResponsivePhaseImplementation.getColumnExchangers().remove(exchanger.getImplementation());
	}

	/**
	* Clears the Column Exchanger collection
	*/
	public void clearColumnExchanger() {
		__ResponsivePhaseImplementation.getColumnExchangers().clear();
	}

	/**
	* Gets an array of all active Column Exchangers
	*/
	public ColumnExchanger[] getColumnExchanger() {
		ColumnExchanger[] exchangers = new ColumnExchanger[__ResponsivePhaseImplementation.getColumnExchangers().getCount()];
		for (int i = 0; i < __ResponsivePhaseImplementation.getColumnExchangers().getCount(); i++) {
			exchangers[i] = (ColumnExchanger) __ResponsivePhaseImplementation.getColumnExchangers().getItem(i).getExternalObject();
		}

		return exchangers;
	}

    

	/**
	* The name of this responsive phase
	*/
	public String getName() {
	return __ResponsivePhaseImplementation.getName();
	}
	/**
	* The name of this responsive phase
	*/
	public void setName(String value) {
	__ResponsivePhaseImplementation.setName(value);
	}

	/**
	* The amount of time to delay the responsive phase from starting, in milliseconds
	*/
	public int getDelayMilliseconds() {
	return __ResponsivePhaseImplementation.getDelayMilliseconds();
	}
	/**
	* The amount of time to delay the responsive phase from starting, in milliseconds
	*/
	public void setDelayMilliseconds(int value) {
	__ResponsivePhaseImplementation.setDelayMilliseconds(value);
	}



}
