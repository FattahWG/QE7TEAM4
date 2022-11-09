package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class dummyJsonHttpmockup {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get http mockup {string}")
    public void getHttpMockup(String status) {
        DummyJsonAPI.MockupHttp(status);
    }

    @When("Send get http request")
    public void sendGetHttpRequest() {
        SerenityRest.when().get(dummyJsonAPI.HTTP_MOCKUP);
    }

    @Then("Status code should be {string} {string}")
    public void statusCodeShouldBeStatusMessage(String status, String message) {
        SerenityRest.then().body(dummyJsonResponses.STATUS, equalTo(status))
                .body(dummyJsonResponses.MESSAGE, equalTo(message));
    }

    @And("Respon body should be status {string} and message {string}")
    public void responBodyShouldBeStatusAndMessage(String status, String message) {
        SerenityRest.then().body(dummyJsonResponses.STATUS, equalTo(status))
                .body(dummyJsonResponses.MESSAGE, equalTo(message));
    }

    @And("Validate http mockup with valid json")
    public void validateHttpMocukupWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/GethttpmockupSchema.json");
        DummyJsonAPI.ValidateJson(json);
    }

    //Custom Mockup http
    @Given("Post http mockup custom {string}")
    public void postHttpMockupCustom(String http) {
        DummyJsonAPI.MockupCustom(http);
    }

    @When("Send post http mockup custom")
    public void sendPostHttpMockupCustom() {
        SerenityRest.when().post(dummyJsonAPI.HTTP_CUSTOM);
    }

    @And("Validate http mockup custom with valid json")
    public void validateHttpMockupCustom() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/PostHttpmockupCustomSchema.json");
        DummyJsonAPI.ValidateJson(json);
    }
}