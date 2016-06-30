package com.infragistics.data;

import java.util.ArrayList;
import java.util.Random;

public class IGSalesmanItem {
    public IGSalesmanItem() {
    }

    public String imageName, territory, lastName, firstName;
    public int index;
    public int yearToDateSales;

    public String fullName;

    /*public int getIndex() { return index; }
    public void setIndex(int idx) { this.index = idx; }

    public int getYearToDateSales() {
        return yearToDataSales;
    }

    public void setYearToDateSales(int yearToDataSales) {
        this.yearToDataSales = yearToDataSales;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }*/

    public static ArrayList<IGSalesmanItem> GenerateData(int count) {

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

        ArrayList<IGSalesmanItem> items = new ArrayList<IGSalesmanItem>();
        for (int i = 0; i < count; i++) {


            IGSalesmanItem item = new IGSalesmanItem();
            int firstIndex = r.nextInt(firstNames.length - 1);

            item.firstName = firstNames[firstIndex];

            item.lastName = lastNames[r.nextInt(lastNames.length - 1)];
            item.index = i;

            int randomIndex = r.nextInt(firstNames.length - 1);
            if (randomIndex == 0)
                randomIndex = 1;

            String number = Integer.toString(randomIndex);
            if (randomIndex < 10)
                number = "0" + number;
            item.imageName = "asset://People/" + genders[firstIndex] + number + ".png";
            item.territory = territories[r.nextInt(territories.length - 1)];
            item.yearToDateSales = r.nextInt(50000);

            item.fullName = item.firstName + " " + item.lastName;

            items.add(item);
        }

        return items;
    }

}

