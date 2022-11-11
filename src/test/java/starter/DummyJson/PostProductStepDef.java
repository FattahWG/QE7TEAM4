package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostProductStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Post create product with valid json")
    public void postCreateProductWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/PostProduct.json");
        DummyJsonAPI.setPostAProduct(json);
    }

    @When("Send post create product request")
    public void sendPostCreateProductRequest() {
        SerenityRest.when().post(dummyJsonAPI.POST_A_PRODUCT);
    }

    @And("Body response should contain title {string}")
    public void bodyResponseShouldContainTitle(String title) {
        SerenityRest.then().body(dummyJsonResponses.TITLE, equalTo(title));
    }
}
