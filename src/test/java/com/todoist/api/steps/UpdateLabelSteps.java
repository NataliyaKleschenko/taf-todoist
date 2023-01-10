package com.todoist.api.steps;
import com.todoist.api.pojos.LabelRequest;
import com.todoist.api.pojos.LabelResponse;

import static com.todoist.api.specifications.Specifications.labelRequestSpec;
import static com.todoist.api.specifications.Specifications.labelResponseSpec;
import static io.restassured.RestAssured.given;
public class UpdateLabelSteps {
    public static void updateLabel(String id,String name,String color) {
        given()
                .spec(labelRequestSpec)
                .pathParam("id", id)
                .body(new LabelRequest(name,color))
                .when()
                .post("{/id}")
                .then()
                .spec(labelResponseSpec);
    }
}
