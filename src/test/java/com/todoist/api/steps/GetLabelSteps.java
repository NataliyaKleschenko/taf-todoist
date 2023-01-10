package com.todoist.api.steps;

import com.todoist.api.pojos.LabelResponse;

import static com.todoist.api.specifications.Specifications.*;
import static io.restassured.RestAssured.given;

public class GetLabelSteps {
    public static LabelResponse getLabelById(String id) {
        return given()
                .spec(labelRequestSpec)
                .pathParam("id", id)
                .when()
                .get("{id}")
                .then()
                .spec(labelResponseSpec)
                .extract()
                .as(LabelResponse.class);
    }

    public static boolean isLabelExistsById(String id) {
        int statusCode = given()
                .spec(labelRequestSpec)
                .pathParam("id", id)
                .when()
                .get("{id}")
                .then()
                .spec(simpleResponseSpec)
                .extract()
                .statusCode();
        return statusCode != 404;
    }
}
