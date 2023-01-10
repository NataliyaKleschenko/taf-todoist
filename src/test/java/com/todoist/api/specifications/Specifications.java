package com.todoist.api.specifications;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;
public class Specifications {
    public static RequestSpecification labelRequestSpec = with()
            .baseUri("https://api.todoist.com/rest/v2")
            .basePath("/labels")
            .header("Authorization", "Bearer " + "3a48a4266244ee5c8ad9d2efd46ce84e6d6c8a1f")
            .header("X-Request-Id", "123-123")
            .log().uri()
            .log().body()
            .contentType(ContentType.JSON);

    public static ResponseSpecification labelResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
    public static ResponseSpecification errorResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
    public static ResponseSpecification taskDeletionResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
    public static ResponseSpecification simpleResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
