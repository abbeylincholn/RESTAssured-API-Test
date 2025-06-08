package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

    public static JsonPath rawToJson(String response) {
        JsonPath jsonPath = new JsonPath(response);   // JsonPath is a library that allows you to extract data from JSON responses easily // parse the response to JsonPath object
        return jsonPath; // return the JsonPath object for further use
    }

    public static JsonPath jsonPath(String getPlaceResponse) {
        JsonPath js = new JsonPath(getPlaceResponse);
        return js; // return the JsonPath object for further use
    }
}
