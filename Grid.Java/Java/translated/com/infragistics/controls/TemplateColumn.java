//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import android.view.ViewGroup;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*  Represents a Template grid column, used to allow the developer to have complete control over the column's cell display.
*/
public class TemplateColumn 
	extends Column {

	private TemplateColumnImplementation __TemplateColumnImplementation;

    TemplateColumnImplementation getImplementation() {
        return __TemplateColumnImplementation;
    }

    public TemplateColumn() {
        this(new TemplateColumnImplementation());
    }

    TemplateColumn(TemplateColumnImplementation TemplateColumnImpl) {
        super(TemplateColumnImpl);
        __TemplateColumnImplementation = TemplateColumnImpl;
		__TemplateColumnImplementation.setExternalTemplateProxy(new TemplateColumnWrapper(this));
    }

	private OnTemplateCellStateChangedListener _cellChangedCallBack;
    
	/**
	* Sets the listener to respond to when the state of the cell has changed.
	*/
    public void setOnTemplateCellStateChangedListener(OnTemplateCellStateChangedListener cellStateChanged) {
        _cellChangedCallBack = cellStateChanged;
    }

	/**
	* Gets the listener to respond to when the state of the cell has changed.
	*/
    public OnTemplateCellStateChangedListener getOnTemplateCellStateChangedListener() {
        return  _cellChangedCallBack;
    }

    private OnStyleKeyResolvingListener _styleKeyResolver;

	/**
	* Sets the listener to respond to when the grid requests the style key for a cell, which is used for recycling
	*/
    public void setOnStyleKeyResolvingListener(OnStyleKeyResolvingListener cellStateChanged) {
        _styleKeyResolver = cellStateChanged;
    }

	/**
	* Gets the listener to respond to when the grid requests the style key for a cell
	*/
    public OnStyleKeyResolvingListener getOnStyleKeyResolvingListener() {
        return  _styleKeyResolver;
    }
    

}
