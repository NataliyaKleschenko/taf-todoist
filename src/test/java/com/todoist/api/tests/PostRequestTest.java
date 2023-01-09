package com.todoist.api.tests;

import com.todoist.api.pojos.LabelPojo;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.todoist.api.specifications.Specifications.requestSpecification;

public class PostRequestTest {
    String firstId;
    String secondId;

    @Test
    @Description("testing a POST test request with status code = 200")
    public void postRequestCheckStatusCode() {
        firstId = RestAssured.given()
                .spec(requestSpecification())
                .body(new LabelPojo("BDD", "red"))
                .post("/labels")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .body()
                .path("id");
    }

    @Test
    @Description("testing a POST test request with checking key/value for name and color fields")
    public void postRequestCheckResponseJsonBody() {
        secondId = RestAssured.given()
                .spec(requestSpecification())
                .body(new LabelPojo("OOP", "yellow"))
                .post("/labels")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("name", Matchers.is("OOP"))
                .body("color", Matchers.is("yellow"))
                .extract()
                .response()
                .body()
                .path("id");
    }

    @Test(priority = 3)
    public void deletePostRequestCheckStatusCode() {
        RestAssured.given()
                .spec(requestSpecification())
                .delete("/labels/" + firstId)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(priority = 4)
    public void deletePostRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .delete("/labels/" + secondId)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}


