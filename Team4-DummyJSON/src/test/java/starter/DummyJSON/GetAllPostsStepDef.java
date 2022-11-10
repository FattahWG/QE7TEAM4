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

public class GetAllPostsStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get all posts")
    public void getAllPosts() {
        DummyJsonAPI.setGetAllPost();
    }

    @When("Send get all posts request")
    public void sendGetAllPosts() {
        SerenityRest.when().get(dummyJsonAPI.GET_ALL_POST);
    }

    @Then("Status code should response {int} OK")
    public void statusCodeShouldResponseOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get all post json schema")
    public void validateGetAllPostJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetAllPostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
