package com.infragistics.data;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class CountryDataList 
	extends ArrayList<CountryDataItem> {
	
	 
	protected static final long serialVersionUID = -1325207918447486070L;

	public CountryDataList() {
			
	}
	
	public String Name;
	 
	public void sortByDept(){
		Collections.sort(this, new Comparator<CountryDataItem>() {
			@Override
			public int compare(CountryDataItem d1, CountryDataItem d2) {
				if (d1.dept < d2.dept) { return -1; } 
				if (d1.dept == d2.dept) { return 0; } 
				return 1;
			}		
		});
	}
	public void sortByPopulation(){
		Collections.sort(this, new Comparator<CountryDataItem>() {
			@Override
			public int compare(CountryDataItem d1, CountryDataItem d2) {
				if (d1.population < d2.population) { return -1; } 
				if (d1.population == d2.population) { return 0; } 
				return 1;
			}		
		});
	}
	public void sortByGdp(){
		Collections.sort(this, new Comparator<CountryDataItem>() {
			@Override
			public int compare(CountryDataItem d1, CountryDataItem d2) {
				if (d1.gdp < d2.gdp) { return -1; } 
				if (d1.gdp == d2.gdp) { return 0; } 
				return 1;
			}		
		});
	}
}
