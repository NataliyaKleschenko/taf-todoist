package com.todoist.api.tests;
import com.todoist.api.pojos.LabelRequest;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static com.todoist.api.specifications.Specifications.labelRequestSpec;

public class PutRequestTest extends BaseTest{

    String id;
    @Test
    @Description("testing the POST(UPDATE) test query with updating the label data by the name field")
    public void putRequestCheckStatusCodeAndJsonBody() {
        id = RestAssured.given()
                .spec(labelRequestSpec)
                .body(new LabelRequest("patch", "red"))
                .post()
                .then()
                .assertThat()
                .body("name", Matchers.is("patch"))
                .body("color", Matchers.is("red"))
                .extract()
                .response()
                .body()
                .path("id");

        RestAssured.given()
                .spec(labelRequestSpec)
                .body(new LabelRequest("put", "yellow"))
                .post(id)
                .then()
                .assertThat()
                .body("name", Matchers.is("put"))
                .body("color", Matchers.is("yellow"));
    }
}
