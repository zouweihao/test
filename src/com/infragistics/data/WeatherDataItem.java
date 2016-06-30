package com.infragistics.data;

import java.util.Date;

public class WeatherDataItem {
    public double x;
    public double y;
    public double r;
    public String label;

    public WeatherDataItem() {
        this(0.0, 0.0, 0.0);
    }
    public WeatherDataItem(int x, int y) {
        this((double)x, (double)y);
    }
    public WeatherDataItem(double x, double y)	{
        this(x, y, 0.0);
    }
    public WeatherDataItem(double x, double y, double r) {
        this(x, y, 0.0, "");
    }
    public WeatherDataItem(double x, double y, double r, String label) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.label = label;
    }

}