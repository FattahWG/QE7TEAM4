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

public class GetAllCartsStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get all carts")
    public void getAllCarts() {
        DummyJsonAPI.setGetAllCarts();
    }

    @When("Send get all carts request")
    public void sendGetAllCartsRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_ALL_CARTS);
    }

    @And("Validate get all carts json schema")
    public void validateGetAllCartsJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetAllCartsJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
