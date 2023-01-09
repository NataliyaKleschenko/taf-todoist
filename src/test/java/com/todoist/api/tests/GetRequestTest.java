package com.todoist.api.tests;

import com.todoist.api.specifications.Specifications;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetRequestTest {
    @Test
    @Description("testing GET request with code status check")
    public void getRequestCheckStatusCode() {
        RestAssured.given()
                .spec(Specifications.requestSpecification())
                .get("/labels")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Description("testing a GET request with checking the key/value on the name and color fields")
    public void getRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(Specifications.requestSpecification())
                .get("/labels")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("name[0]", Matchers.is("create"))
                .body("color[0]", Matchers.is("sky_blue"));
    }

    @Test
    @Description("testing a GET request with response validation using json schema")
    public void getRequestCheckResponseWithJsonSchema() {
        RestAssured.given()
                .spec(Specifications.requestSpecification())
                .get("/labels")
                .then()
                .spec(Specifications.responseSpecificationScOk())
                .assertThat()
                .body(matchesJsonSchemaInClasspath("SchemaLabelsByName.json"));
    }
}