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
        String newAddress = "112 Bronte Court, Salford";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"place_id\": \""+placeId+"\",\n" +
                        "    \"address\": \""+newAddress+"\",\n" +
                        "    \"key\":\"qaclick123\"\n" +
                        "   \n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        //Get the place to validate if new address is present in the response

        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(getPlaceResponse);
        String actualAddress = js.getString("address");
        System.out.println("Actual Address: " + actualAddress);

        //Cucumber JUnit, TestNG







    }
}