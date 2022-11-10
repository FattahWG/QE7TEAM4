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
import static org.hamcrest.Matchers.equalTo;

import javax.xml.transform.OutputKeys;
import java.io.File;

public class PutUpdatePostStepDef {
    @Steps
    DummyJsonAPI dummyJsonAPI;

    @Given("Put update post with valid json with id {int}")
    public void putUpdatePostWithValidJsonWithIdId(int id) {
        File json = new File(DummyJsonAPI.JSON_REQUEST_BODY + "/PutUpdatePost.json");
        dummyJsonAPI.setPutUpdatePost(id, json);
    }

    @When("Send put update post request")
    public void sendPutUpdatePostRequest() {
        SerenityRest.when().put(DummyJsonAPI.PUT_UPDATE_POST);
    }

    @And("Body response should contain title {string} and body {string}")
    public void bodyResponseShouldContainTitleAndBody(String title, String body) {
        SerenityRest.then()
                .body(DummyJsonResponse.TITLE, equalTo(title))
                .body(DummyJsonResponse.BODY, equalTo(body));
    }

    @And("Validate put update post json schema")
    public void validatePutUpdatePostJsonSchema() {
        File json = new File(DummyJsonAPI.JSON_SCHEMA + "/PutUpdatePostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
