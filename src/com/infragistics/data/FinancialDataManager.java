package com.infragistics.data;

//for csv file reading
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FinancialDataManager {
	
		protected static FinancialDataList RandomData;
		protected static FinancialDataList LoadedData;
		
		protected FinancialDataManager() {
			
			//RandomData = GenerateRandomData();
			RandomData = null;
			LoadedData = null;
			RandomDate = new DateTime();
			//RandomDate.set(Calendar.MINUTE, 1.0);
			
			RandomDate.setMinutes(0);
			RandomDate.setSeconds(0);
		}
		
		protected static DateTime RandomDate = new DateTime(12,0,0);
		protected static int RandomDataCounter = 0;
		
		public static FinancialDataItem GetRandomDataItem(FinancialDataItem previous){
			return GetRandomDataItem(previous.closeValue, previous.volumeValue);
		}
		public static FinancialDataItem GetRandomDataItem(FinancialDataList data){
			FinancialDataItem last = data.get(data.size() - 1);
			return GetRandomDataItem(last);
		}
		public static FinancialDataItem GetRandomDataItem(double previousPrice, double previousVolume){
			
			double curr = previousPrice;
			double currHigh = 500;
			double currLow = 500;
			double currOpen = 500;
			double currClose = 500;
			double currVolume = previousVolume;
		
			if (Math.random() > .5) {
	            curr += Math.random() * 2.0;
	            currVolume += Math.random() * 10.0;
	        } else {
	            curr -= Math.random() * 2.0;
	            currVolume -= Math.random() * 10.0;
	        }
						
			if (Math.random() > .5) {
	            currOpen = curr + Math.random() * 20.0;
	            currClose = curr - Math.random() * 20.0;
	            currHigh = currOpen + Math.random() * 5.0;
	            currLow = currClose - Math.random() * 5.0;
	        } else {
	            currOpen -= Math.random() * 20.0;
	            currClose += Math.random() * 20.0;
	            currHigh = currClose + Math.random() * 5.0;
	            currLow = currOpen - Math.random() * 5.0;
	        }
			
			FinancialDataItem dataItem = new FinancialDataItem();
			//dataItem.label = ((Integer)(RandomDataCounter)).toString();
			dataItem.index = RandomDataCounter;
			dataItem.lowValue = currLow;
			dataItem.highValue = currHigh;
			dataItem.openValue = currOpen;
			dataItem.closeValue = currClose;
			dataItem.volumeValue = currVolume;
			dataItem.date = new DateTime(RandomDate);
			dataItem.label = dataItem.date.toTimeString();
			
			RandomDataCounter++;
			RandomDate.AddMinutes(1);;
			
			return dataItem;
		}
		
		public static FinancialDataList GetRandomData(){
			
			if (RandomData != null) return RandomData;
			
			RandomData = new FinancialDataList();
			
			double currPrice = 500;
//			double currHigh = 10000;
//			double currLow = 10000;
//			double currOpen = 10000;
//			double currClose = 10000;
			double currVolume = 500;
				
			for (int i = 0; i <= 60; i++) {
			
				FinancialDataItem dataItem = GetRandomDataItem(currPrice, currVolume);
				
				RandomData.add(dataItem);
				currPrice = dataItem.closeValue;
				currVolume = dataItem.volumeValue;
				
//				dataItem = GetRandomDataItem(dataItem.closeValue, dataItem.volumeValue);
				
			}
			
			return RandomData;
		}
	
		public static FinancialDataList GetLoadedData() {
			
			String fileName = "DowJonesData.csv";
			
			if (LoadedData != null){
				
				System.out.println("Loading Data from: " + fileName + " skipped.");
				return LoadedData;
			}
						
			LoadedData = new FinancialDataList();
			
			BufferedReader reader = null;
			String line = "";
			String seperator = ","; // use comma as separator
			System.out.println("Loading Data from: " + fileName + " started...");
			
			int itemsCount = 0;
			try {
				
				double previous = 0.0;
				InputStream in = FinancialDataSample.class.getResourceAsStream(fileName);
			    reader = new BufferedReader(new InputStreamReader(in));
				reader.readLine(); // skip first line
				while((line = reader.readLine()) != null){
			    	   
			        String[] items = line.split(seperator);
					double curr = Double.parseDouble(items[1]) / 100.0;
					if (previous == 0.0) 
						previous = curr;
					
					FinancialDataItem newItem = new FinancialDataItem();
				 	newItem.label = items[0].toString();//.replace("-", "/");
					 
					newItem.lowValue = curr - (curr * 0.01);
					newItem.highValue = curr + (curr * 0.01);
					newItem.openValue = previous;
					newItem.closeValue = curr;
					newItem.volumeValue = (curr * 100) - (curr * 10);
					
					previous = curr;
					LoadedData.add(newItem);		
					
					itemsCount++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("Loading Data failed on finding: " + fileName);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Loading Data failed on reading: " + fileName);
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Loading Data failed on error: " + fileName);
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						System.out.println("Loading Data failed on closing: " + fileName);
						e.printStackTrace();
					}
				}
				System.out.println("Loading Data from: " + fileName + " completed with " + itemsCount + " items.");
			}
			
			 return LoadedData;
		}
		
	}

