package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetAllProductsStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get All Products")
    public void getAllProducts() {
        DummyJsonAPI.setGetAllProducts();
    }

    @When("Send all products request")
    public void sendAllProductsRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_ALL_PRODUCTS);
    }

    @Then("Status code response should be {int} OK")
    public void statusCodeResponseShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get all products json schema")
    public void validateGetAllProductsJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetAllProductsJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
