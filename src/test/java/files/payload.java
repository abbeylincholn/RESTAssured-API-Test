package files;

public class payload {
    public static String AddPlace(){
            return "{\n" +
                    "  \"location\": {\n" +
                    "    \"lat\": -38.383494,\n" +
                    "    \"lng\": 33.427362\n" +
                    "  },\n" +
                    "  \"accuracy\": 50,\n" +
                    "  \"name\": \"Godwitus Global\",\n" +
                    "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                    "  \"address\": \"29, side layout, cohen 09\",\n" +
                    "  \"types\": [\n" +
                    "    \"shoe park\",\n" +
                    "    \"shop\"\n" +
                    "  ],\n" +
                    "  \"website\": \"http://google.com\",\n" +
                    "  \"language\": \"French-IN\"\n" +
                    "}\n";
    }

    public static String CoursePrice() {
       return "{\n" +
               "  \"dashboard\": {\n" +
               "    \"purchaseAmount\": 910,\n" +
               "    \"website\": \"rahulshettyacademy.com\"\n" +
               "  },\n" +
               "  \"courses\": [\n" +
               "    {\n" +
               "      \"title\": \"Selenium Python\",\n" +
               "      \"price\": 50,\n" +
               "      \"copies\": 6\n" +
               "    },\n" +
               "    {\n" +
               "      \"title\": \"Cypress\",\n" +
               "      \"price\": 40,\n" +
               "      \"copies\": 4\n" +
               "    },\n" +
               "    {\n" +
               "      \"title\": \"RPA\",\n" +
               "      \"price\": 45,\n" +
               "      \"copies\": 10\n" +
               "    }\n" +
               "  ]\n" +
               "}\n";
    }

}
