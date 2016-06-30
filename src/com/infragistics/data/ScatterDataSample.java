package com.infragistics.data;


public class ScatterDataSample 
	extends ScatterDataList {

	public ScatterDataSample() {
		  
		int dataPoints = 95;
		int rMin = 5;
		int rRange= 40;
		int xMin = 0;
		int xRange = 5;
		int yRange = 50;
		int yMin = 50;
		
		 int value = yMin;
         for (int i = xMin; i < dataPoints; i++)
         {
        	 double change = Math.random();
             if (change > .5)
             {
                 value += (int)(change * 20);
             }
             else
             {
                 value -= (int)(change * 20);
             }
             ScatterDataItem newItem = new ScatterDataItem();
			 newItem.label = ((Integer)(i + 1)).toString();
             newItem.x = (Math.random() * xRange) + i; 
             newItem.y = (Math.random() * (yRange + yRange)) + value - yRange; 
             newItem.r = (Math.random() * rRange) + rMin;
			 add(newItem);

         }
	}

	
	// x is mass, y is height
	public static ScatterDataList GetBMI(double heightMin, double heightMax, double massRange, double bmi){
		
		//Random r = new Random();
		ScatterDataList data = new ScatterDataList();
		for (int i = 0; i < 100; i++){
			
			double height = (Math.random() * (heightMax - heightMin)) + heightMin; 
			//r.nextInt(High-Low) + Low;
			double mass =  bmi * height * height;
			double massMin = mass - massRange;
			double massMax = mass + massRange;
			mass = (Math.random() * (massMax - massMin)) + massMin; 
			
			ScatterDataItem newItem = new ScatterDataItem();
			newItem.x = mass; 
			newItem.y = height; 
			data.add(newItem);
		}
		data.sortByY();
		return data;
	}
	// x is direction, y is speed
	public static ScatterDataList GetWindData(double offset){
		
		ScatterDataList data = new ScatterDataList();
		data.add(new ScatterDataItem(0, 10 * offset));
		data.add(new ScatterDataItem(45, 15 * offset));
       
        data.add(new ScatterDataItem(90, 10 * offset));
        data.add(new ScatterDataItem(135, 5 * offset));
     
        data.add(new ScatterDataItem(180, 10 * offset));
        data.add(new ScatterDataItem(225, 25 * offset));
     
        data.add(new ScatterDataItem(270, 10 * offset));
        data.add(new ScatterDataItem(315, 30 * offset));
        data.add(new ScatterDataItem(360, 10 * offset));
		 
		//data.sortByY();
		return data;
	}

	
}

