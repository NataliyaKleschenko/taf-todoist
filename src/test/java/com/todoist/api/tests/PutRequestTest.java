package com.todoist.api.tests;

import com.todoist.api.pojos.LabelPojo;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.todoist.api.specifications.Specifications.requestSpecification;

public class PutRequestTest {
    String id;
    @Test
    @Description("testing the POST(UPDATE) test query with updating the label data by the name field")
    public void putRequestCheckStatusCodeAndJsonBody() {
        id = RestAssured.given()
                .spec(requestSpecification())
                .body(new LabelPojo("patch", "red"))
                .post("/labels")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("name", Matchers.is("patch"))
                .body("color", Matchers.is("red"))
                .extract()
                .response()
                .body()
                .path("id");

        RestAssured.given()
                .spec(requestSpecification())
                .body(new LabelPojo("put", "yellow"))
                .post("/labels/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("name", Matchers.is("put"))
                .body("color", Matchers.is("yellow"));
    }
    @AfterMethod
    public void deleteContent() {
        RestAssured.given()
                .spec(requestSpecification())
                .delete("/labels/" + id)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
