package com.todoist.api.tests;

import com.todoist.api.pojos.LabelResponse;
import com.todoist.api.steps.CreateLabelSteps;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.assertj.core.api.ObjectAssert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewLabelTest extends BaseTest{
    @Test(priority = 0)
    public void testCreateNewLabel() {
        String name = "First";
        String color = "red";
        LabelResponse response = CreateLabelSteps.createNewLabel(name, color);

        assertThat(response.getName()).isEqualTo(name);
        assertThat(response.getColor()).isEqualTo(color);
        ObjectAssert<JsonSchemaValidator> jsonSchemaValidatorObjectAssert = assertThat(matchesJsonSchemaInClasspath("SchemaLabelsByName.json"));
    }
    @Test(priority = 3)
    public void testCreateNewLabelWithExistingName() {
        String name = "First";
        String color = "yellow";
        String response = CreateLabelSteps.createNewLabelWithError(name, color);

        assertThat(response).isEqualTo("Label with this name already exists");
    }

    @Test(priority = 4)
    public void testCreateNewLabelWithIncorrectColor() {
        String name = "Second";
        String color = "indigo";
        String response = CreateLabelSteps.createNewLabelWithError(name, color);

        assertThat(response).isEqualTo("Color format is not valid");
    }
}

