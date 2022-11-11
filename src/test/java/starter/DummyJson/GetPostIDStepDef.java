package starter.DummyJson;

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

public class GetPostIDStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get post ID with parameter postid {int}")
    public void getPostIDWithParameterIdId(int postid) {
        DummyJsonAPI.setGetPostId(postid);
    }

    @When("Send get post ID request")
    public void sendGetPostIDRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_POST_ID);
    }

    @And("Validate get post id json schema")
    public void validateGetPostIdJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetPostIDJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get post ID with invalid parameter postid {int}")
    public void getPostIDWithInvalidParameterIdId(int postid) {
        DummyJsonAPI.setGetPostId(postid);
    }

}
