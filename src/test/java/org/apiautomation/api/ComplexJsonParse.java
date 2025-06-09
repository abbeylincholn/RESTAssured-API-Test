package org.apiautomation.api;

import files.payload;
import groovy.json.JsonParser;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {

        JsonPath js = new JsonPath(payload.CoursePrice());

        // Print number of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println("Number of courses: " + count);

        // Print purchase amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount: " + purchaseAmount);

        // Print title of the first course
        String title = js.getString("courses[0].title");
        System.out.println("Title of the first course: " + title);

        // Print all course titles and their respective prices
        for (int i = 0; i < count; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            int coursePrice = js.getInt("courses[" + i + "].price");
            System.out.println("Course Title: " + courseTitle + ", Price: " + coursePrice);
        }

        // Print number of copies sold by RPA course
        int rpaCopies = js.getInt("courses.find { it.title == 'RPA' }.copies");
        System.out.println("Number of copies sold by RPA course: " + rpaCopies);

        //OR
        for (int i = 0; i < count; i++) {
            String courseTitle = js.get("courses[" + i + "].title");

            if (courseTitle.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }


        // Print all courses with price more than 40
       /* js.getInt("courses.findAll { it.price > 40 }.each { course -> " +)
                "println('Course Title: ' + course.title + ', Price: ' + course.price) }");*/


    }
}
