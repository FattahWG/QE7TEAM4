package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class dummyJsonQuotes {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    //Scenario 1
    @Given("Get all quotes")
    public void getAllQuotes() {
    }

    @When("Send get Get all quotes request")
    public void sendGetGetAllQuotesRequest() {
        SerenityRest.when()
                .get(dummyJsonAPI.GET_ALL_QUOTES);
    }

    //Scenario 2
    @Given("Get single quote id {int}")
    public void getSingleQuoteId(int id) {
        DummyJsonAPI.GetQuotesId(id);
    }

    @When("Send get single quote id")
    public void sendGetSingleQuoteId() {
        SerenityRest.when()
                .get(dummyJsonAPI.GET_SINGLE_QUOTES);
    }

    @And("Validate get single qute id with valid json")
    public void validateGetSingleQuteIdWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA +  "/getSingleQuotesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get quote invalid id {int}")
    public void getQuoteInvalid(int id) {
        DummyJsonAPI.GetQuotesId(id);
    }
    @When("Send get single quote invalid id")
    public void sendGetSingleQuoteInvalidId() {
        SerenityRest.when()
                .get(dummyJsonAPI.GET_SINGLE_QUOTES);
    }

    //Scenario 3
    @Given("Get a random quotes")
    public void getARandomQuotes() {
    }

    @When("Send get a random quotes request")
    public void sendGetARandomQuotesRequest() {
        SerenityRest.when()
                .get(dummyJsonAPI.GET_RANDOM_QUOTES);
    }
}
