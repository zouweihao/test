package com.infragistics.data;

public class CategoryDataSmallSample 
	extends CategoryDataList {

	public CategoryDataSmallSample() {
		
		double curr = 10.0;
		double curr2 = 20.0;
		
		String[] daysOfWeek = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
		
		for (int i = 0; i < 5; i++) {
			curr += Math.random() * 4.0 - 2.0;
			curr2 += Math.random() * 4.0 - 2.0;
			
			CategoryDataItem newItem = new CategoryDataItem();
			newItem.label = daysOfWeek[i % 5];
			newItem.setValue(Math.min(curr, curr2));
			newItem.highValue = Math.max(curr, curr2);
			add(newItem);
		}
	}

}

