package com.infragistics.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScatterDataList 
	extends ArrayList<ScatterDataItem> {

	public ScatterDataList() {
		
		 
	}
	public void sortByY(){
		Collections.sort(this, new Comparator<ScatterDataItem>() {
			@Override
			public int compare(ScatterDataItem d1, ScatterDataItem d2) {
				if (d1.y < d2.y) { return -1; } 
				if (d1.y == d2.y) { return 0; } 
				return 1; 
			}		
		});
	}
	public void sortByX(){
		Collections.sort(this, new Comparator<ScatterDataItem>() {
			@Override
			public int compare(ScatterDataItem d1, ScatterDataItem d2) {
				if (d1.x < d2.x) { return -1; } 
				if (d1.x == d2.x) { return 0; } 
				return 1;  
			}		
		});
	}
}

