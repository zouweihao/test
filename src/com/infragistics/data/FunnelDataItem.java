package com.infragistics.data;

public class FunnelDataItem {
    private String _label;

    public String getLabel() {
        return _label;
    }
    public String setLabel(String label) {
        _label = label;
        return label;
    }

    private double _value;

    public double getValue(){
        return _value;
    }
    public double setValue(double value) {
        _value = value;
        return _value;
    }

    public FunnelDataItem(String label, double value){
        _label = label;
        _value = value;
    }
}
