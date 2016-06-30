package com.infragistics.controls;

import com.infragistics.data.CategoryDataItem;

import java.util.List;

public class Playground {
    public static void Test() {
        List__1<CategoryDataItem> testList = new List__1<CategoryDataItem>(new TypeInfo(CategoryDataItem.class));

        CategoryDataItem i1 = new CategoryDataItem();
        i1.setValue(1);

        CategoryDataItem i2 = new CategoryDataItem();
        i2.setValue(2);

        CategoryDataItem i3 = new CategoryDataItem();
        i3.setValue(3);

        CategoryDataItem i4 = new CategoryDataItem();
        i4.setValue(4);

        CategoryDataItem i5 = new CategoryDataItem();
        i5.setValue(5);

        CategoryDataItem i6 = new CategoryDataItem();
        i6.setValue(6);

        testList.add(i1);
        testList.add(i2);
        testList.add(i3);
        testList.add(i4);

        List__1<CategoryDataItem> otherList = new List__1<CategoryDataItem>(new TypeInfo(CategoryDataItem.class));
        otherList.add(i5);
        otherList.add(i6);

        CategoryDataItem[] arr = new CategoryDataItem[2];
        arr[0] = i5;
        arr[1] = i6;

        List<CategoryDataItem> ls = new java.util.ArrayList<CategoryDataItem>();
        ls.add(i5);
        ls.add(i6);

        testList.insertRange(3,otherList);
    }
}
