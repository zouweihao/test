package com.infragistics.data;

public class CategoryDataPieSample 
	extends CategoryDataList {

	public CategoryDataPieSample() {
				
		String[] dep = new String[] { "Admininstration", "Sales", "IT", "Marketing", "Development", "Support", "HR" };
		for (int i = 0; i < 7; i++) {
			CategoryDataItem newItem = new CategoryDataItem();
			newItem.label = dep[i];
			switch(i)
			{
			case 0 : newItem.highValue = 20 ; break ; 
			case 1 : newItem.highValue = 40 ; break ; 
			case 2 : newItem.highValue = 50 ; break ; 
			case 3 : newItem.highValue = 40 ; break ; 
			case 4 : newItem.highValue = 15 ; break ; 
			case 5 : newItem.highValue = 20 ; break ;
			case 6 : newItem.highValue = 10 ; break ;
	  	   }
			add(newItem);
		}
	}

}

