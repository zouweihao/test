//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*  Represents a based implementation of a grid column.
*/
public abstract class Column 
	extends DefinitionBase {

	private ColumnImplementation __ColumnImplementation;

	ColumnImplementation getImplementation() {
		return  __ColumnImplementation;
	}

	Column(ColumnImplementation implementation) {
		super(implementation);
		__ColumnImplementation = implementation;
		__ColumnImplementation.setExternalObject(this);
	}

	/**
	 * Gets the animation settings specific to this column
	 */
	public GridColumnAnimationSettings getAnimationSettings() {
		if (__ColumnImplementation.getAnimationSettings() != null) {
			return (GridColumnAnimationSettings) __ColumnImplementation.getAnimationSettings().getExternalObject();	
		}
		else {
			return null;
		}
	}
	
	/**
	 * Set the animation settings specific to this column
	 */
	public void setAnimationSettings(GridColumnAnimationSettings animationSettings) {
		if (animationSettings != null) {
			__ColumnImplementation.setAnimationSettings(animationSettings.getImplementation());
		}
		else {
			__ColumnImplementation.setAnimationSettings(null);
		}
	}

	/**
	 * Gets the column width class for this column
	 */
	public ColumnWidth getWidth() {
		return new ColumnWidth( __ColumnImplementation.getWidth());
	}

	/**
	 * Sets the column width class for this column
	 */
	public void setWidth(ColumnWidth width) {
		__ColumnImplementation.setWidth(width.getImplementation());
	}

	/**
	* Gets the vertical alignment for the header
	*/
	public VerticalAlignment getHeaderVerticalAlignment() {
		return __ColumnImplementation.getHeaderVerticalAlignment();
	}
	
	/**
	* Gets the vertical alignment for the header
	*/
	public void setHeaderVerticalAlignment(VerticalAlignment VerticalAlignment) {
		__ColumnImplementation.setHeaderVerticalAlignment(VerticalAlignment);
	}

	/**
	 * Gets the horizontal alignment for the header
	 */
	public HorizontalAlignment getHeaderHorizontalAlignment() {
		return __ColumnImplementation.getHeaderHorizontalAlignment();
	}

	/**
	 * Sets the horizontal alignment for the header
	 */
	public void setHeaderHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		__ColumnImplementation.setHeaderHorizontalAlignment(horizontalAlignment);
	}

	/**
	* Sets the current Font style on the header
	*/
	public void setHeaderFontStyle(FontStyles fontStyle) {
		FontInfo fi =  this.__ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		DVAPIConverters.setFontStyle(fontStyle.getValue(), fi);

		this.__ColumnImplementation.setHeaderFontInfo(FontUtil.copyFontInfo(fi));
		FontHelper.refreshTypeface(this.__ColumnImplementation.getHeaderFontInfo());
	}

	/**
	* Gets the current Font style on the header
	*/
	public FontStyles getHeaderFontStyle() {
        FontInfo fi =  this.__ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return FontStyles.valueOf(DVAPIConverters.getFontStyle(fi));
    }

	/**
	* Gets the active Font family for the header
	*/
	public String getHeaderFontFamily() {
		FontInfo fi =  this.__ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return fi.getFontFamily();
	}

	/**
	* Sets the active Font family for the header
	*/
	public void setHeaderFontFamily(String fontFamily) {
		FontInfo fi = this.__ColumnImplementation.getFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		fi.setFontFamily(fontFamily);

		this.__ColumnImplementation.setHeaderFontInfo(FontUtil.copyFontInfo(fi));
		FontHelper.refreshTypeface(this.__ColumnImplementation.getHeaderFontInfo());
	}

	/**
	* Gets the active Font size on the header
	*/
	public double getHeaderFontSize() {
		FontInfo fi =  __ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return fi.getFontSize();
	}

	/**
	* Sets the active Font size on the header
	*/
	public void setHeaderFontSize(double value) {
		setHeaderFontSize(android.util.TypedValue.COMPLEX_UNIT_SP, value);
	}
	/**
	 * Sets the label's text size in the axis.
	 */
	public void setHeaderFontSize(int unit, double value) {
		FontInfo fi =  this.__ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		value = APIHelpers.toPixelUnits(unit, value);
		fi.setFontSize(value);

		this.__ColumnImplementation.setHeaderFontInfo(FontUtil.copyFontInfo(fi));
		FontHelper.refreshTypeface(this.__ColumnImplementation.getHeaderFontInfo());
	}

	/**
	 * Gets the column header's Typeface. Note, if Typeface is set, this takes precedence over any font family settings.
	 * @return The Typeface used for the labels. May be null if font family has been specified instead.
	 */
	public android.graphics.Typeface getHeaderTypeface() {
		FontInfo fi = this.__ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		return (android.graphics.Typeface)fi.getTypeFace();
	}

	/**
	 * Sets the column header's Typeface. Note, if Typeface is set, this takes precedence over any font family settings.
	 * @param typeface The Typeface to use for the labels.
	 */
	public void setHeaderTypeface(android.graphics.Typeface typeface) {
		FontInfo fi = this.__ColumnImplementation.getHeaderFontInfo();
		if (fi == null) {
			fi = FontUtil.getDefaultFont();
		}

		fi.setTypeFace(typeface);

		this.__ColumnImplementation.setHeaderFontInfo(FontUtil.copyFontInfo(fi));
	}




	/**
	* The name of the Column
	*/
	public String getName() {
	return __ColumnImplementation.getName();
	}
	/**
	* The name of the Column
	*/
	public void setName(String value) {
	__ColumnImplementation.setName(value);
	}



	/**
	* The key used for the column binding
	*/
	public String getKey() {
	return __ColumnImplementation.getKey();
	}
	/**
	* The key used for the column binding
	*/
	public void setKey(String value) {
	__ColumnImplementation.setKey(value);
	}

	/**
	* The text displayed in the header of the column
	*/
	public String getHeaderText() {
	return __ColumnImplementation.getHeaderText();
	}
	/**
	* The text displayed in the header of the column
	*/
	public void setHeaderText(String value) {
	__ColumnImplementation.setHeaderText(value);
	}

	/**
	* The color of the header text
	*/
	public com.infragistics.graphics.Brush getHeaderTextColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__ColumnImplementation.getHeaderTextColor());
	}
	/**
	* The color of the header text
	*/
	public void setHeaderTextColor(com.infragistics.graphics.Brush value) {
	__ColumnImplementation.setHeaderTextColor(com.infragistics.controls.APIConverters.convertBrush(value));
	}

	/**
	* The color of the header background
	*/
	public com.infragistics.graphics.Brush getHeaderBackgroundColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__ColumnImplementation.getHeaderBackgroundColor());
	}
	/**
	* The color of the header background
	*/
	public void setHeaderBackgroundColor(com.infragistics.graphics.Brush value) {
	__ColumnImplementation.setHeaderBackgroundColor(com.infragistics.controls.APIConverters.convertBrush(value));
	}


	/**
	* The color of the selection background
	*/
	public com.infragistics.graphics.Brush getSelectedBackgroundColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__ColumnImplementation.getSelectedBackgroundColor());
	}
	/**
	* The color of the selection background
	*/
	public void setSelectedBackgroundColor(com.infragistics.graphics.Brush value) {
	__ColumnImplementation.setSelectedBackgroundColor(com.infragistics.controls.APIConverters.convertBrush(value));
	}


	/**
	* The actual color of the selected background
	*/
	public com.infragistics.graphics.Brush getActualSelectedBackgroundColor() {
	return com.infragistics.controls.APIConverters.convertBrush(__ColumnImplementation.getActualSelectedBackgroundColor());
	}


	/**
	* Configures whether or not a column is hidden from view
	*/
	public boolean getIsHidden() {
	return __ColumnImplementation.getIsHidden();
	}
	/**
	* Configures whether or not a column is hidden from view
	*/
	public void setIsHidden(boolean value) {
	__ColumnImplementation.setIsHidden(value);
	}

	/**
	* Configures if a column should be removed from the grid when it's hidden
	*/
	public boolean getShouldRemoveWhenHidden() {
	return __ColumnImplementation.getShouldRemoveWhenHidden();
	}
	/**
	* Configures if a column should be removed from the grid when it's hidden
	*/
	public void setShouldRemoveWhenHidden(boolean value) {
	__ColumnImplementation.setShouldRemoveWhenHidden(value);
	}



}
