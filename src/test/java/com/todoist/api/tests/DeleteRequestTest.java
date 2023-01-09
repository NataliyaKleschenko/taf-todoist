package com.todoist.api.tests;

import com.todoist.api.pojos.LabelPojo;
import com.todoist.ui.util.RandomString;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.todoist.api.specifications.Specifications.requestSpecification;

public class DeleteRequestTest {
    @Test
    @Description("testing a DELETE Request with label deletion by id")
    public void deleteRequestCheckStatusCode() {
        String id;
        id = RestAssured.given()
                .spec(requestSpecification())
                .body(new LabelPojo(RandomString.generateRandomString(), "red"))
                .post("/labels")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .body()
                .path("id");

        RestAssured.given()
                .spec(requestSpecification())
                .delete("/labels/" + id)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}

