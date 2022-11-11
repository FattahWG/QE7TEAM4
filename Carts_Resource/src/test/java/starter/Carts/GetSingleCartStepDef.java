package starter.Carts;

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
import static org.hamcrest.Matchers.not;

import javax.xml.transform.OutputKeys;
import java.io.File;

public class GetSingleCartStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get single cart with valid id {int}")
    public void getSingleCartWithValidIdId(int id) {
        DummyJsonAPI.setGetSingleCarts(id);
    }

    @When("Send get single cart request")
    public void sendGetSingleCartRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_SINGLE_CARTS);
    }

    @And("Response body should contain id {int}")
    public void responseBodyShouldContainIdId(int id) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id));
    }

    @And("Validate get single cart json schema")
    public void validateGetSingleCartJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetSingleCartJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single cart with invalid id {int}")
    public void getSingleCartWithInvalidIdId(int id) {
        DummyJsonAPI.setGetSingleCarts(id);
    }

    @Then("Status code should response {int} Not Found")
    public void statusCodeShouldResponseNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }


}
