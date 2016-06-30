package com.infragistics.data;

import java.util.ArrayList;

public class FunnelDataSample extends ArrayList<FunnelDataItem> {

    public FunnelDataSample(){
        add(new FunnelDataItem("Impressions",3000));
        add(new FunnelDataItem("Clicks",2000));
        add(new FunnelDataItem("Free Downloads",1000));
        add(new FunnelDataItem("Purchase",3000));
        add(new FunnelDataItem("Repeat Purchase",500));

    }

}