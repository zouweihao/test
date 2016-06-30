package com.infragistics.data;

import android.provider.CalendarContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class GridActivityItem {
    public GridActivityItem() {
    }

    public String imageName, location, notes;
    public float distance;
    public int timeInSeconds;
    public Calendar date;

    public GridActivityItem record;

    public String fullName;

    public static ArrayList<GridActivityItem> GenerateData(int count) {

        String[] activityImage = {
                "biking",
                "running",
                "swimming",
                "weights"
        };

        String[] notes = {
                "",
                "With Tom",
                "",
                "",
                "Way too hot out...",
                "With Karen",
                "",
                "",
                "Gave it my all!",
                "Went somewhere new",
                ""
        };

        String[] location = {
                "New York, NY",
                "Portland, OR",
                "Chicago, IL",
                "Boulder, CO",
                "Washington DC",
                "San Francisco, CA",
                "Austin, TX",
                "Boston, MA",
                "Atlanta, GA"
        };


        int min = 10;
        int max = 35;

        Random r = new Random();
        //int fontSize = r.nextInt(max - min + 1) + min;

        Calendar currDate = Calendar.getInstance();

        ArrayList<GridActivityItem> items = new ArrayList<GridActivityItem>();
        for (int i = 0; i < count; i++) {

            GridActivityItem item = new GridActivityItem();
            int locationIndex = r.nextInt(location.length - 1);
            item.location = location[locationIndex];

            int imageIndex = r.nextInt(activityImage.length - 1);
            item.imageName = "asset://Activities/" + activityImage[imageIndex] + ".png";

            int noteIndex = r.nextInt(notes.length - 1);
            item.notes = notes[noteIndex];

            item.timeInSeconds = r.nextInt(4000);
            item.distance = r.nextFloat() * 15;

            //Only a small chance to have an activity on the same day...
            if (r.nextInt(10) != 9) {
                currDate.add(Calendar.DATE, -1);
            }

            item.date = (Calendar) currDate.clone();

            item.record = item;

            items.add(item);
        }

        return items;
    }

}
