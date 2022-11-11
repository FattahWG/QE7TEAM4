package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PutUpdatePostStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Put update post with valid json with id {int}")
    public void putUpdatePostWithValidJsonWithIdId(int id) {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/PutUpdatePost.json");
        DummyJsonAPI.setPutUpdatePost(id, json);
    }

    @When("Send put update post request")
    public void sendPutUpdatePostRequest() {
        SerenityRest.when().put(dummyJsonAPI.PUT_UPDATE_POST);
    }

    @And("Body response should contain title {string} and body {string}")
    public void bodyResponseShouldContainTitleAndBody(String title, String body) {
        SerenityRest.then()
                .body(dummyJsonResponses.TITLE, equalTo(title))
                .body(dummyJsonResponses.BODY, equalTo(body));
    }

    @And("Validate put update post json schema")
    public void validatePutUpdatePostJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/PutUpdatePostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
