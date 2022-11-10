package starter.DummyJSON;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.internal.runners.statements.FailOnTimeout;

import static org.hamcrest.Matchers.equalTo;

import javax.xml.transform.OutputKeys;
import java.io.File;

public class DeletePostStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Delete post with valid id {int}")
    public void deletePostWithValidIdId(int id) {
        DummyJsonAPI.setDeletePost(id);
    }

    @When("Send delete post request")
    public void sendDeletePostRequest() {
        SerenityRest.when().delete(dummyJsonAPI.DELETE_POST);
    }

    @And("Validate delete post json schema")
    public void validateDeletePostJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/DeletePostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
