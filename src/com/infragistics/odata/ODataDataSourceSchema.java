package com.infragistics.odata;

import com.infragistics.controls.DataSourceSchema;
import com.infragistics.controls.DataSourceSchemaValueType;

public class ODataDataSourceSchema implements DataSourceSchema {

    private String[] _valueNames;
    private DataSourceSchemaValueType[] _valueTypes;

    public ODataDataSourceSchema(String[] valueNames, DataSourceSchemaValueType[] valueTypes) {
        _valueNames = valueNames;
        _valueTypes = valueTypes;
    }

    @Override
    public String[] getValueNames() {
        return _valueNames;
    }

    @Override
    public DataSourceSchemaValueType[] getValueTypes() {
        return _valueTypes;
    }
}
