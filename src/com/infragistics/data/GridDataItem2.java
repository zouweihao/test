package com.infragistics.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class GridDataItem2 {
    public GridDataItem2() {
    }

    public String Territory;
    public int Sales;
    public String Name;
    public Calendar Date;
    public Double Value;

    public static ArrayList<GridDataItem2> GenerateData(int count) {

        String[] firstNames = {
                "Kyle",
                "Gina",
                "Irene",
                "Katie",
                "Michael",
                "Oscar",
                "Ralph",
                "Torrey",
                "William",
                "Bill",
                "Daniel",
                "Frank",
                "Brenda",
                "Danielle",
                "Fiona",
                "Howard",
                "Jack",
                "Larry",
                "Holly",
                "Jennifer",
                "Liz",
                "Pete",
                "Steve",
                "Vince",
                "Zeke"
        };

        String[] lastNames = {
                "Adams",
                "Crowley",
                "Ellis",
                "Gable",
                "Irvine",
                "Keefe",
                "Mendoza",
                "Owens",
                "Rooney",
                "Waddell",
                "Thomas",
                "Betts",
                "Doran",
                "Fitzgerald",
                "Holmes",
                "Jefferson",
                "Landry",
                "Newberry",
                "Perez",
                "Spencer",
                "Vargas",
                "Grimes",
                "Edwards",
                "Stark",
                "Cruise",
                "Fitz",
                "Chief",
                "Blanc",
                "Perry",
                "Stone",
                "Williams",
                "Lane",
                "Jobs"
        };

        String[] genders = {
                "GUY",
                "GIRL",
                "GIRL",
                "GIRL",
                "GUY",
                "GUY",
                "GUY",
                "GUY",
                "GUY",
                "GUY",
                "GUY",
                "GUY",
                "GIRL",
                "GIRL",
                "GIRL",
                "GUY",
                "GUY",
                "GUY",
                "GIRL",
                "GIRL",
                "GIRL",
                "GUY",
                "GUY",
                "GUY",
                "GUY"
        };

        String[] territories = {
                "Australia",
                "Canada",
                "Egypt",
                "Greece",
                "Italy",
                "Kenya",
                "Mexico",
                "Oman",
                "Qatar",
                "Sweden",
                "Uruguay",
                "Yemen",
                "Bulgaria",
                "Denmark",
                "France",
                "Hungary",
                "Japan",
                "Latvia",
                "Netherlands",
                "Portugal",
                "Russia",
                "Turkey",
                "Venezuela",
                "Zimbabwe"
        };

        int min = 10;
        int max = 35;

        Random r = new Random();
        //int fontSize = r.nextInt(max - min + 1) + min;

        Calendar currDate = Calendar.getInstance();

        ArrayList<GridDataItem2> items = new ArrayList<GridDataItem2>();
        for (int i = 0; i < count; i++) {


            GridDataItem2 item = new GridDataItem2();
            int firstIndex = r.nextInt(firstNames.length - 1);

            item.Name = firstNames[firstIndex] + " " + lastNames[r.nextInt(lastNames.length - 1)];

            int randomIndex = r.nextInt(firstNames.length - 1);
            if (randomIndex == 0)
                randomIndex = 1;

            item.Territory = territories[r.nextInt(territories.length - 1)];
            item.Sales = r.nextInt(50000);

            currDate.add(Calendar.DATE, r.nextInt(10));
            currDate.add(Calendar.HOUR, r.nextInt(24));
            currDate.add(Calendar.MINUTE, r.nextInt(60));
            currDate.add(Calendar.SECOND, r.nextInt(60));

            item.Date = (Calendar)currDate.clone();

            item.Value = r.nextDouble() * 100;

            items.add(item);
        }

        return items;
    }

}
