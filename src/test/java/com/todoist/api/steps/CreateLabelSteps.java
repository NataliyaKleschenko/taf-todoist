package com.todoist.api.steps;

import com.todoist.api.pojos.LabelRequest;
import com.todoist.api.pojos.LabelResponse;

import static com.todoist.api.specifications.Specifications.*;
import static io.restassured.RestAssured.given;

public class CreateLabelSteps {
    public static LabelResponse createNewLabel(String name, String color) {
        LabelRequest request = new LabelRequest();
        request.setName(name);
        request.setColor(color);
        return createNewLabel(request);
    }

    public static LabelResponse createNewLabel(LabelRequest request) {
        return given()
                .spec(labelRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(labelResponseSpec)
                .extract()
                .as(LabelResponse.class);
    }
    public static String createNewLabelWithError(String name, String color) {
        LabelRequest request = new LabelRequest();
        request.setName(name);
        request.setColor(color);
        return given()
                .spec(labelRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(errorResponseSpec)
                .extract().body().asString();
    }
}
