package starter.DummyJson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PutUpdateProductStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Put update product with valid json with id {int}")
    public void putUpdateProductWithValidJsonWithIdId(int id) {
        File json = new File(dummyJsonAPI.JSON_REG_BODY+ "/PutUpdateProduct.json");
        DummyJsonAPI.setPutUpdateAProduct(id, json);
    }

    @When("Send put update product request")
    public void sendPutUpdateProductRequest() {
        SerenityRest.when().put(dummyJsonAPI.PUT_UPDATE_A_PRODUCT);
    }
}
