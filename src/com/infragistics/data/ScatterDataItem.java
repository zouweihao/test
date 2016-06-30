package com.infragistics.data;

public class ScatterDataItem {
	public double x;
	public double y;
	public double r;
	public String label;
	
	public ScatterDataItem() {
		this(0.0, 0.0, 0.0);
	}
	public ScatterDataItem(int x, int y) {
		this((double)x, (double)y);
	}
	public ScatterDataItem(double x, double y)	{
		this(x, y, 0.0);
	}
	public ScatterDataItem(double x, double y, double r) {
		this(x, y, 0.0, "");
	}
	public ScatterDataItem(double x, double y, double r, String label) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.label = label;
	}
	
}

