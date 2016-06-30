package com.infragistics.data;

import android.support.v4.util.LogWriter;

import java.util.Random;

public class WeatherDataSample
        extends WeatherDataList {

    public enum TempRange {High, Low, Average}

    public static WeatherDataList GetWeatherDataX(TempRange temp, int dataPoints) {

        Random randomNum = new Random();

        WeatherDataList dataHigh;
        WeatherDataList dataLow;
        WeatherDataList dataAverage;

        //High
        dataHigh = new WeatherDataList();
        for (int high = 0; high < dataPoints; high++) {

            WeatherDataItem newItemHigh = new WeatherDataItem();
            newItemHigh.x = high;
            newItemHigh.y = generateRandomTempInRange(80, 90, randomNum);
            //newItemHigh.label = String.valueOf(newItemHigh.y);
            newItemHigh.label = Integer.toString(high);
            dataHigh.add(newItemHigh);
        }

        //Low
        dataLow = new WeatherDataList();
        for (int low = 0; low < dataPoints; low++) {

            WeatherDataItem newItemLow = new WeatherDataItem();
            newItemLow.x = low;
            newItemLow.y = generateRandomTempInRange(42, 60, randomNum);
            newItemLow.label = Integer.toString(low);
            dataLow.add(newItemLow);

        }

        //Average
        dataAverage = new WeatherDataList();
        for(int average = 0; average < dataPoints; average++) {
            WeatherDataItem newItemAverage = new WeatherDataItem();
            newItemAverage.x = average;
            newItemAverage.y = ((dataLow.get(average).y + dataHigh.get(average).y)/2);
            newItemAverage.label = Integer.toString(average);
            dataAverage.add(newItemAverage);
        }

        switch (temp) {
            case High:
                return dataHigh;

            case Low:
                return dataLow;

            case Average:
                return dataAverage;

            default:
                return null;
        }
    }

    private static int generateRandomTempInRange(int min, int max, Random random){
        if (min > max) {
            throw new IllegalArgumentException("min cannot exceed max.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)max - (long)min + 7;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * random.nextDouble());
        int randomNumber =  (int)(fraction + min);
        return randomNumber;
    }
}

