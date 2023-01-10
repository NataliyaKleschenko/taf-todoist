package com.todoist.api.steps;

import com.todoist.api.pojos.LabelResponse;
import io.restassured.path.json.JsonPath;
import static com.todoist.api.specifications.Specifications.*;
import static io.restassured.RestAssured.given;
public class DeleteLabelSteps {
    public static void deleteLabel(String id) {
        given()
                .spec(labelRequestSpec)
                .pathParam("id", id)
                .when()
                .delete("{id}")
                .then()
                .spec(taskDeletionResponseSpec);
    }
    public static void deleteLabel(LabelResponse label) {
        String id = label.getId();
        deleteLabel(id);
    }
    public static void deleteAllLabels() {
        JsonPath response = given()
                .spec(labelRequestSpec)
                .when()
                .get()
                .then()
                .spec(labelResponseSpec)
                .extract()
                .body().
                jsonPath();
        LabelResponse[] labels = response.getObject("$", LabelResponse[].class);
        for (LabelResponse label : labels) {
            deleteLabel(label);
        }
    }
}
