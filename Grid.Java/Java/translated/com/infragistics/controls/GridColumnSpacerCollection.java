//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class GridColumnSpacerCollection
extends List__1<GridColumnSpacer> {
public GridColumnSpacerCollection() {


	super(new TypeInfo(GridColumnSpacer.class));
}

public double getActualWidth() {
	int count = getCount();
	double width = 0;
	for (int i = 0; i < count; i++) {
		width = width + this.inner[i].getActualWidth();
	}

	return width;
}


public double getStarActualWidth() {
	int count = getCount();
	double width = 0;
	for (int i = 0; i < count; i++) {
		if (this.inner[i].getIsStar()) {
			width = width + this.inner[i].getActualWidth();
		}

	}

	return width;
}


public double getNonStarActualWidth() {
	int count = getCount();
	double width = 0;
	for (int i = 0; i < count; i++) {
		if (!this.inner[i].getIsStar()) {
			width = width + this.inner[i].getActualWidth();
		}

	}

	return width;
}


public double getStartWidth() {
	int count = getCount();
	double width = 0;
	for (int i = 0; i < count; i++) {
		if (this.inner[i].getActualWidth() > 0) {
			width = width + this.inner[i].getStartWidth();
		}

	}

	return width;
}


public double getLeftActualWidth(long ignoreColumn) {
	int count = getCount();
	double width = 0;
	for (int i = 0; i < count; i++) {
		if (!this.inner[i].getIsRight() && !(this.inner[i].getOwningColumnId() == ignoreColumn)) {
			width = width + this.inner[i].getActualWidth();
		}

	}

	return width;
}


public double getRightActualWidth(long ignoreColumn) {
	int count = getCount();
	double width = 0;
	for (int i = 0; i < count; i++) {
		if (this.inner[i].getIsRight() && !(this.inner[i].getOwningColumnId() == ignoreColumn)) {
			width = width + this.inner[i].getActualWidth();
		}

	}

	return width;
}

}
