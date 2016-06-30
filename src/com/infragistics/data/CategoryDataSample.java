package com.infragistics.data;

public class CategoryDataSample 
	extends CategoryDataList {

	public CategoryDataSample() {
		
		double curr = 100;
		double curr2 = 300;
		
		String[] months = new String[] { "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar", "Apr", "May" };

		for (int i = 0; i < 12; i++) {
			curr += Math.random() * 4 - 2;
			curr2 += Math.random() * 4 - 2;
			
			CategoryDataItem newItem = new CategoryDataItem();
			newItem.label = months[i];
			newItem.setValue(Math.min(curr, curr2));
			newItem.highValue = Math.max(curr, curr2);
			add(newItem);
		}
	}
	public static CategoryDataList GetTemperatureData(){
		
		double offset = 2;
		double low = 0;
		double high = 15;
		CategoryDataList data = new CategoryDataList();
		
		String[] months = new String[] { "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar", "Apr", "May" };

		for (int i = 0; i < months.length; i++) {
			
			CategoryDataItem newItem = new CategoryDataItem();
			newItem.label = months[i];
			newItem.lowValue = Math.min(low, high);
			newItem.highValue = Math.max(low, high);
			data.add(newItem);
			
			if (i <= 6){
				low += Math.random() * 5;
				high += Math.random() * 2;
			}
			else{
				low -= Math.random() * 7;
				high -= Math.random() * 3;
			}
		}
		
		return data;
	}

}

