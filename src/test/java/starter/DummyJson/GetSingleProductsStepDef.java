package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleProductsStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get single product with valid parameter id {int}")
    public void getSingleProductWithValidParameterIdId(int id) {
        DummyJsonAPI.setGetSingleProducts(id);
    }

    @When("Send get single product request")
    public void sendGetSingleProductRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_SINGLE_PRODUCTS);
    }

    @And("Body response should contain id {int}")
    public void bodyResponseShouldContainIdId(int id) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id));
    }

    @Given("Get single product with invalid parameter id {int}")
    public void getSingleProductWithInvalidParameterIdId(int id) {
        DummyJsonAPI.setGetSingleProducts(id);
    }

    @Then("Status code response should be {int} Not Found")
    public void statusCodeResponseShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }
}
