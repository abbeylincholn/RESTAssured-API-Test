package org.apiautomation.api;


import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args) {

        //Validate uf Add place API is working as expected
        // Rest Assured is a Java library that makes it easy to test RESTful web services. below are methods to validate the API response
        // given - all input details
        // when - Submit the API - resource,http methods, etc.
        // then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(payload.AddPlace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

        System.out.println("responseBody: "+response);
        JsonPath jsonPath = new JsonPath(response);   // JsonPath is a library that allows you to extract data from JSON responses easily // parse the response to JsonPath object
        String placeId = jsonPath.getString("place_id"); // get the place id from the response

        System.out.println("Place ID: " + placeId);


        //Add place -> update place with new address -> Get place to validate if new address is present in the response






    }
}