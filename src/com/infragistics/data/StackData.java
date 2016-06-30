package com.infragistics.data;

import java.util.ArrayList;

public class StackData
    extends ArrayList<StackDataItem> {
    public StackData() {
        add(new StackDataItem(
                "2001",
                20,
                40,
                50,
                40,
                15,
                20,
                10
        ));

        add(new StackDataItem(
                "2002",
                25,
                35,
                50,
                44,
                21,
                20,
                15
        ));

        add(new StackDataItem(
                "2003",
                22,
                39,
                47,
                48,
                18,
                22,
                13
        ));
    }
}
