//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;










class DefaultDataSourceInitializedListener
implements OnDataSourceInitializedListener {
private GridImplementation _owner;

public DefaultDataSourceInitializedListener(GridImplementation owner) {



		_owner = owner;
}


public void onInitialized(DataSource dataSource, DataSourceInitializedEvent initializedEvent) {
	_owner.onDataSourceInitialized(dataSource, initializedEvent);
}

}
