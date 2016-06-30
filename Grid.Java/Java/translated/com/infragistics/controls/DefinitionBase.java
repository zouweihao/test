//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.util.TypedValue;
import android.content.res.Resources;

/**
*   Represents the base class for a definition in the grid control.
*/
public abstract class DefinitionBase {

	private DefinitionBaseImplementation __DefinitionBaseImplementation;

	DefinitionBase(DefinitionBaseImplementation implementation) {
		__DefinitionBaseImplementation = implementation;
		__DefinitionBaseImplementation.setExternalObject(this);
		
	}

	/**
	* Gets the vertical alignment
	*/
	public VerticalAlignment getVerticalAlignment() {
		return __DefinitionBaseImplementation.getVerticalAlignment();
	}

	/**
	* Sets the vertical alignment
	*/
	public void setVerticalAlignment(VerticalAlignment VerticalAlignment) {
		__DefinitionBaseImplementation.setVerticalAlignment(VerticalAlignment);
	}
	
	/**
	* Gets the horizontal alignment
	*/
	public HorizontalAlignment getHorizontalAlignment() {
		return __DefinitionBaseImplementation.getHorizontalAlignment();
	}
	
	/**
	* Sets the horizontal alignment
	*/
	public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		__DefinitionBaseImplementation.setHorizontalAlignment(horizontalAlignment);
	}

	/**
	* Gets the current Font style
	*/
	public FontStyles getFontStyle() {
        FontInfo fi =  this.__DefinitionBaseImplementation.getFontInfo();
        if (fi == null) {
            fi = FontUtil.getDefaultFont();
        }

        return FontStyles.valueOf(DVAPIConverters.getFontStyle(fi));
    }

	/**
	* Sets the current Font style
	*/
    public void setFontStyle(FontStyles fontStyle) {
        FontInfo fi =  this.__DefinitionBaseImplementation.getFontInfo();
        if (fi == null) {
            fi = FontUtil.getDefaultFont();
        }

        DVAPIConverters.setFontStyle(fontStyle.getValue(), fi);

        this.__DefinitionBaseImplementation.setFontInfo(FontUtil.copyFontInfo(fi));
        FontHelper.refreshTypeface(this.__DefinitionBaseImplementation.getFontInfo());
    }

	/**
	* Gets the active Font family
	*/
	public String getFontFamily() {
		FontInfo fi =  this.__DefinitionBaseImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return fi.getFontFamily();
	}

	/**
	* Sets the active Font family
	*/
	public void setFontFamily(String fontFamily) {
		FontInfo fi = this.__DefinitionBaseImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		fi.setFontFamily(fontFamily);

		this.__DefinitionBaseImplementation.setFontInfo(FontUtil.copyFontInfo(fi));
		FontHelper.refreshTypeface(this.__DefinitionBaseImplementation.getFontInfo());
	}

	/**
	* Gets the active Font size
	*/
	public double getFontSize() {
		FontInfo fi =  __DefinitionBaseImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return fi.getFontSize();
	}
	
	/**
	* Sets the active Font size
	*/
	public void setFontSize(double value) {
		setFontSize(android.util.TypedValue.COMPLEX_UNIT_SP, value);
	}
	
	/**
	 * Sets the label's text size in the axis.
	 */
	public void setFontSize(int unit, double value) {
		FontInfo fi =  this.__DefinitionBaseImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		value = APIHelpers.toPixelUnits(unit, value);
		fi.setFontSize(value);
		
		this.__DefinitionBaseImplementation.setFontInfo(FontUtil.copyFontInfo(fi));
		FontHelper.refreshTypeface(this.__DefinitionBaseImplementation.getFontInfo());
	}

	/**
	 * Gets the label's Typeface. Note, if Typeface is set, this takes precedence over any font family settings.
	 * @return The Typeface used for the labels. May be null if font family has been specified instead.
	 */
	public android.graphics.Typeface getTypeface() {
		FontInfo fi = this.__DefinitionBaseImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return (android.graphics.Typeface)fi.getTypeFace();
	}

	/**
	 * Sets the label's Typeface. Note, if Typeface is set, this takes precedence over any font family settings.
	 * @param typeface The Typeface to use for the labels.
	 */
	public void setTypeface(android.graphics.Typeface typeface) {
		FontInfo fi = this.__DefinitionBaseImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		fi.setTypeFace(typeface);

		this.__DefinitionBaseImplementation.setFontInfo(FontUtil.copyFontInfo(fi));
	}




	/**
	* The background color used
	*/
	public com.infragistics.graphics.Brush getBackgroundColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__DefinitionBaseImplementation.getBackgroundColor());
	}
	/**
	* The background color used
	*/
	public void setBackgroundColor(com.infragistics.graphics.Brush value) {
	__DefinitionBaseImplementation.setBackgroundColor(com.infragistics.controls.APIConverters.convertBrush(value));
	}


	/**
	* The actual background color used
	*/
	public com.infragistics.graphics.Brush getActualBackgroundColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__DefinitionBaseImplementation.getActualBackgroundColor());
	}

	/**
	* The opacity of the content
	*/
	public double getContentOpacity() {
	return __DefinitionBaseImplementation.getContentOpacity();
	}
	/**
	* The opacity of the content
	*/
	public void setContentOpacity(double value) {
	__DefinitionBaseImplementation.setContentOpacity(value);
	}

	/**
	* The color to use for displaying text
	*/
	public com.infragistics.graphics.Brush getTextColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__DefinitionBaseImplementation.getTextColor());
	}
	/**
	* The color to use for displaying text
	*/
	public void setTextColor(com.infragistics.graphics.Brush value) {
	__DefinitionBaseImplementation.setTextColor(com.infragistics.controls.APIConverters.convertBrush(value));
	}

	/**
	* The actual color used for displaying text
	*/
	public com.infragistics.graphics.Brush getActualTextColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__DefinitionBaseImplementation.getActualTextColor());
	}

}
