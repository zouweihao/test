package com.infragistics.data;

import com.infragistics.extensions.StringList;

public class CountryDataSample {

	CountryDataSample() {
	
		Initialize();
			
	}
	private static void Initialize() {
		
		if (Years == null) {
			int[] years = {1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012};
			double[] ChinaPopulation = {983170638,996667562,1010574797,1025090475,1040397958,1056579219,1073792041,1091904967,1110339206,1128297564,1145195229,1160799514,1175230312,1188687527,1201522570,1213986610,1226134423,1237849861,1249020152,1259476966,1269116737,1277903627,1285933789,1293396654,1300552134,1307593489,1314581402,1321481935,1328275524,1334908820,1341335152,1347565324};
			double[] ChinaGDP = {523.9502539,544.180142,585.0213221,639.4813812,727.079904,814.0746264,872.6365967,958.3700843,1049.629343,1076.039515,1100.659931,1185.632603,1337.500032,1507.321586,1685.620731,1849.152636,2012.859331,2177.653613,2325.092775,2480.231467,2667.469383,2867.961183,3108.0518,3397.628437,3718.636985,4114.572834,4611.303228,5238.676581,5712.24562,6206.264294,6818.707496,7404.314282};
			
			double[] GermanyPopulation = {78288577,78124452,77944929,77784306,77686865,77684875,77783439,77974722,78260173,78637382,79098094,79651903,80282985,80926118,81495194,81929441,82200333,82326019,82350467,82341545,82349027,82384256,82432026,82484111,82524343,82540739,82536138,82516297,82475271,82405365,82302465,82162512};
			double[] GermanyGDP = {20860.6754,20939.16213,20876.33254,21260.25543,21936.11623,22496.99718,23001.05029,23287.7583,24056.92122,24801.76681,25881.05018,27005.63876,27313.48724,26862.60536,27431.2698,27809.43998,27948.33134,28392.29962,28916.54191,29438.55973,30297.62732,30704.74918,30656.27991,30524.27883,30885.4106,31114.53059,32302.18373,33402.79265,33828.87411,32175.88586,33414.44319,34436.8487};
			
			double[] RussiaPopulation = {138655363,139619492,140598335,141593874,142609801,143642108,144695549,145748948,146740928,147591465,148243501,148673813,148897737,148945559,148866314,148698582,148456965,148139274,147749214,147286725,146757517,146161742,145519641,144880469,144306982,143843159,143510059,143294533,143163100,143064078,142958164,142835555};
			double[] RussiaGDP = {17033.56834,16592.77347,16151.9786,15711.18373,15270.38886,14829.59399,14388.79911,13948.00424,13507.20937,13066.4145,12625.61963,11961.63224,10219.0094,9343.790602,8179.432344,7850.835818,7588.798928,7717.766162,7328.874682,7829.368262,8612.658286,9073.131172,9546.037536,10292.10332,11088.16108,11852.80594,12877.69003,14016.15479,14767.30437,13614.5467,14198.97165,14808.48399};
				
			double[] UnitedStatesPopulation = {229825004,232035086,234261242,236510688,238794274,241119752,243495805,245920994,248381577,250857751,253339097,255807342,258275919,260803255,263468980,266323717,269393632,272643340,275986072,279300030,282496310,285544778,288467308,291290823,294063120,296820296,299564470,302284564,304989064,307686729,310383948,313085380};
			double[] UnitedStatesGDP = {25509.517,25902.31233,25148.49092,26044.94593,27678.15117,28562.06183,29269.19665,29927.48329,30872.92791,31673.00735,31898.50294,31392.8714,32014.62688,32502.81819,33427.71144,33873.99635,34749.84595,35880.97867,37026.10801,38385.53612,39544.95555,39583.61008,39934.95799,40603.85346,41629.71122,42516.39347,43228.11115,43635.58521,43069.58199,41187.65533,42078.59411,42485.98336};
			
			double[] UnitedKingdomPopulation = {56303011,56317534,56341308,56379327,56436762,56516908,56622956,56753658,56902081,57058173,57214474,57369629,57525459,57681639,57838596,57997210,58156871,58318771,58488026,58671413,58874117,59097129,59339971,59604347,59891788,60202727,60538143,60896101,61270318,61652315,62035570,62417431};
			double[] UnitedKingdomGDP = {17381.7213,17164.29543,17548.63875,18190.16709,18650.22077,19282.24606,20009.89439,20878.3293,21880.28672,22321.28681,22428.08747,22047.49721,22020.19772,22455.63728,23357.25203,24006.59863,24636.45522,26098.417,27021.47898,27916.07171,29056.46827,29862.69405,30543.72469,31492.63429,32260.00078,32737.9538,33385.62467,34321.35301,33717.8864,32025.50077,32474.70243,32473.54772};

			double[] JapanPopulation = {115914688,116823958,117711145,118554190,119320901,119990547,120553260,121023579,121434677,121832924,122251184,122703017,123177552,123653405,124097649,124486744,124814986,125091571,125325617,125531619,125720310,125893623,126048366,126184149,126299414,126392944,126464789,126515486,126544640,126551705,126535920,126497241};
			double[] JapanGDP = {17834.50575,18442.66317,18936.47173,19383.51556,20120.72182,21264.6354,21733.82511,22515.51639,24021.92566,25208.5258,26522.55036,27319.33144,27474.79757,27453.95133,27596.85877,28025.68089,28683.53627,29064.95181,28410.86069,28300.49637,28889.19617,28928.27,28944.64887,29369.48615,30052.70233,30441.34813,30960.81029,31635.87641,31322.69952,29625.39008,30965.40566,30660.40345};

			double[] JapanDept = {17834.50575,18442.66317,18936.47173,19383.51556,20120.72182,21264.6354,21733.82511,22515.51639,24021.92566,25208.5258,26522.55036,27319.33144,27474.79757,27453.95133,27596.85877,28025.68089,28683.53627,29064.95181,28410.86069,28300.49637,28889.19617,28928.27,28944.64887,29369.48615,30052.70233,30441.34813,30960.81029,31635.87641,31322.69952,29625.39008,30965.40566,30660.40345};

			
//			double[] IndiaGDP = {879.404517,910.8402687,921.0834682,965.9773743,980.5128015,1009.215043,1034.268565,1052.001713,1128.643212,1170.60352,1209.819106,1197.759994,1238.222525,1271.669945,1330.340682,1404.231347,1482.473877,1514.754156,1580.143535,1684.453317,1722.097304,1777.762135,1817.841602,1931.746558,2051.631494,2208.58735,2377.742962,2573.136284,2635.33685,2812.582452,3038.807989,3203.002804};
//			
//			double[] IndonesiaPopulation = {150820044,154275429,157758440,161245684,164706919,168119209,171472345,174767379,178006800,181197879,184345939,187451800,190512441,193525648,196488446,199400339,202257039,205063468,207839287,210610776,213395411,216203499,219026365,221839235,224606531,227303175,229918547,232461746,234951154,237414495,239870937,242325638};
//			double[] IndonesiaGDP = {1322.896063,1398.644313,1382.865997,1467.282673,1539.472714,1560.675425,1621.422902,1675.168127,1749.213679,1874.520726,2008.364554,2151.420114,2269.704573,2396.447655,2538.281364,2711.225107,2877.217914,2971.21621,2546.719474,2533.089171,2623.037745,2683.297509,2767.892764,2863.434288,2970.435858,3102.28377,3235.708534,3403.369257,3569.809055,3696.297262,3885.09842,4094.062146};
	//	
	//			
//			double[] PakistanPopulation = {80492664,83280137,86187238,89200001,92300277,95470380,98710951,102011892,105332464,108621443,111844679,114970102,118010303,121029915,124121817,127346713,130737306,134255952,137808222,141261069,144522192,147557907,150407242,153139895,155860066,158645463,161513324,164445596,167442258,170494367,173593383,176745364};
//			double[] PakistanGDP = {1224.007467,1276.744356,1314.331335,1356.0206,1376.851356,1432.194011,1461.384294,1505.338585,1569.050935,1597.006131,1620.134127,1655.866264,1737.519689,1723.949014,1743.831207,1784.018887,1821.972972,1792.219444,1790.549207,1810.717347,1845.256305,1843.12308,1866.511068,1922.047729,2027.658589,2144.795404,2236.855033,2321.8254,2316.665123,2356.994567,2410.852891,2423.664428};
			
			Years = years;
			
			ChinaData = GetCountryData(Years, ChinaPopulation, ChinaGDP);
			ChinaData.Name = "China";
			
			GermanyData = GetCountryData(Years, GermanyPopulation, GermanyGDP);
			GermanyData.Name = "Germany";

			JapanData = GetCountryData(Years, JapanPopulation, JapanGDP);
			JapanData.Name = "Japan";
			
			RussiaData = GetCountryData(Years, RussiaPopulation, RussiaGDP);
			RussiaData.Name = "Russia";
			
			UnitedStatesData = GetCountryData(Years, UnitedStatesPopulation, UnitedStatesGDP);
			UnitedStatesData.Name = "United States";
		
			UnitedKingdomData = GetCountryData(Years, UnitedKingdomPopulation, UnitedKingdomGDP);
			UnitedKingdomData.Name = "United Kingdom";
	}
	}
	private static int[] Years;
	
	private static CountryDataList ChinaData;
	private static CountryDataList GermanyData;
	private static CountryDataList JapanData;
	private static CountryDataList RussiaData;
	private static CountryDataList UnitedStatesData;
	private static CountryDataList UnitedKingdomData;

	public static CountryDataList GetUnitedKingdomData(){
		if (UnitedKingdomData == null)
			Initialize();
		return UnitedKingdomData;
	}
	public static CountryDataList GetUnitedStatesData(){
		if (UnitedStatesData == null)
			Initialize();
		return UnitedStatesData;
	}
	public static CountryDataList GetChinaData(){
		if (ChinaData == null)
			Initialize();
		return ChinaData;
	}
	public static CountryDataList GetGermanyData(){
		if (GermanyData == null)
			Initialize();
		return GermanyData;
	}
	public static CountryDataList GetJapanData(){
		if (JapanData == null)
			Initialize();
		return JapanData;
	}
	public static CountryDataList GetRussiaData(){
		if (RussiaData == null)
			Initialize();
		return RussiaData;
	}
	 
	private static CountryDataList GetCountryData(int[] years, double[] population, double[] gdp){
		int count = Math.min(years.length, population.length);
		count = Math.min(count, gdp.length);
		CountryDataList data = new CountryDataList();
		
		for (int i = 0; i < count; i++){
			CountryDataItem item = new CountryDataItem();
			item.population = population[i] / 1000000;
			item.gdp = gdp[i];
			item.year = years[i];
			data.add(item); 
		}
		return data;
	}
	protected static CountryDataList LoadedData;
	
	public static CountryDataList GetWorldData(){
		
		String fileName = "gm-world-stats.csv";
		String seperator = ","; // use comma as separator
		
		if (LoadedData != null){
			
			System.out.println("Loading Data from: " + fileName + " skipped.");
			return LoadedData;
		}
					
		LoadedData = new CountryDataList();
		StringList lines = CsvDataProvider.LoadData(fileName);
		
		int countriesCount = 0;
		try {
			for (int i = 1; i < lines.size(); i++){
				
				String[] items = lines.get(i).split(seperator);
				   
				String name = items[0].toString();
				double dept = Double.parseDouble(items[1]);
				double gdp = Double.parseDouble(items[2]);
				double population = Double.parseDouble(items[3]);
				
				if (dept != 0){
					CountryDataItem country = new CountryDataItem();
					country.population = population / 1000000;
					country.gdp = gdp;
					country.dept = population;
					country.name = name;
					LoadedData.add(country);		
					countriesCount++;
				}
			}
		} catch (Exception e) {
			System.out.println("Loading Data failed on parsing: " + fileName);
			e.printStackTrace();
		} finally {
			 
			System.out.println("Loading Data from: " + fileName + " completed with " + countriesCount + " countries.");
		}
		
		LoadedData.sortByDept();
		 
		return LoadedData;
			
	}
}