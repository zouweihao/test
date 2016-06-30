package com.infragistics.data;

public class StackDataItem {
    public StackDataItem(String label,
                         double administration,
                         double sales,
                         double IT,
                         double marketing,
                         double development,
                         double support,
                         double HR) {
        _label = label;
        _administration = administration;
        _sales = sales;
        _IT = IT;
        _marketing = marketing;
        _development = development;
        _support = support;
        _HR = HR;
    }

    private String _label;
    public void setLabel(String value) {
        _label = value;
    }
    public String getLabel() {
        return _label;
    }

    private double _administration;
    public void setAdmininstration(double value) {
        _administration = value;
    }
    public double getAdministration() {
        return _administration;
    }

    private double _sales;
    public void setSales(double value) {
        _sales = value;
    }
    public double getSales() {
        return _sales;
    }

    private double _IT;
    public void setIT(double value) {
        _IT = value;
    }
    public double getIT() {
        return _IT;
    }

    private double _marketing;
    public void setMarketing(double value) {
        _marketing = value;
    }
    public double getMarketing() {
        return _marketing;
    }

    private double _development;
    public void setDevelopment(double value) {
        _development = value;
    }
    public double getDevelopment() {
        return _development;
    }

    private double _support;
    public void setSupport(double value) {
        _support = value;
    }
    public double getSupport() {
        return _support;
    }

    private double _HR;
    public void setHR(double value) {
        _HR = value;
    }
    public double getHR() {
        return _HR;
    }
}
