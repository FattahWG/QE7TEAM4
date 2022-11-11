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

public class PutUpdateCartStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Put update cart with valid json with id {int}")
    public void putUpdateCartWithValidJsonWithIdId(int id) {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/PutUpdateCart.json");
        DummyJsonAPI.setPutUpdateCart(id, json);
    }

    @When("Send update cart request")
    public void sendUpdateCartRequest() {
        SerenityRest.when().put(dummyJsonAPI.PUT_UPDATE_CART);
    }

    @And("Validate put update cart json schema")
    public void validatePutUpdateCartJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/PutUpdateCartJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
