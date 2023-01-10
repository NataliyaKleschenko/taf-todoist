package com.todoist.api.tests;
import com.todoist.api.pojos.LabelResponse;
import com.todoist.api.steps.CreateLabelSteps;
import org.testng.annotations.Test;
import static com.todoist.api.steps.DeleteLabelSteps.deleteLabel;
import static com.todoist.api.steps.GetLabelSteps.isLabelExistsById;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteAddedLabelTest extends BaseTest{
    @Test
    public void testDeleteLabel() {
        String name = "Label";
        String color = "red";
        LabelResponse response = CreateLabelSteps.createNewLabel(name, color);
        assertThat(isLabelExistsById(response.getId())).isTrue();

        deleteLabel(response.getId());
        assertThat(isLabelExistsById(response.getId())).isTrue();
    }
}
