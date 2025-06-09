package org.apiautomation.api;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

    @Test
    public void testSumValidation() {
        int sum = 0;
        JsonPath js = new JsonPath(payload.CoursePrice());
        int count = js.getInt("courses.size()");
        for (int i = 0; i < count; i++) {
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int total = price * copies;
            System.out.println("Total for course " + (i + 1) + ": " + total);
            sum = sum + total; // Accumulate the total for all courses
        }
        System.out.println("Total sum of all courses: " + sum);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }
}
