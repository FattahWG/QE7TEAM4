package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class GetSinglePostStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get single post with parameter id {int}")
    public void getSinglePostWithParameterIdId(int id) {
        DummyJsonAPI.setGetSinglePost(id);
    }

    @When("Send get single post request")
    public void sendGetSinglePostRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_SINGLE_POST);
    }

    @And("Body response page should be id {int}")
    public void bodyResponsePageShouldBeIdId(int id) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate get single post json schema")
    public void validateGetSinglePostJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetSinglePostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single post with invalid parameter id {int}")
    public void getSinglePostWithInvalidParameterIdId(int id) {
        DummyJsonAPI.setGetSinglePost(id);
    }

    @Then("Status code should response {int} Not Found")
    public void statusCodeShouldResponseNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }
}
