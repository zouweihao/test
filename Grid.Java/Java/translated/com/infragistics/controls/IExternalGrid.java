//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;










interface IExternalGrid {

public void insertExternalColumnAtIndex(int index, Object column);


public void removeExternalColumn(Object column);


public void onContentSizeChanged();


public DataSource createLocalDataSource(Object itemsSource);

}
