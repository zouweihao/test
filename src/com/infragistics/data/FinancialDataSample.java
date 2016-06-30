package com.infragistics.data;
 
public class FinancialDataSample 
	extends FinancialDataList {


	public FinancialDataSample() {
		//super(new TypeInfo(FinancialCategoryDataItem.class));
		
		//super(new TypeInfo(FinancialCategoryDataSampleList.class));
		
		FinancialDataList data;
		
		data = FinancialDataManager.GetLoadedData();
		//data = FinancialDataManager.GetRandomData();
		
		for (int i = 0; i < data.size(); i++){
			add(data.get(i));
		}
		//addRange(data);
	}
	
	
	public static FinancialDataList GetCompanyFinances(){
		
		String[] labels = new String[] {"IT", "Marketing", "Management", "Sales", "Development", "Support" };
		
		FinancialDataList data = new FinancialDataList();
		
		for (int i = 0; i < labels.length; i++){
			FinancialDataItem item = new FinancialDataItem();
			item.spendingValue = (Math.random() * (100 - 20)) + 20; 
			item.budgetValue = (Math.random() * (100 - 40)) + 40; 
			item.label = labels[i];
			data.add(item);
			
		}
		  return data;
	}
}



