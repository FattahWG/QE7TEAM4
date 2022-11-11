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
import org.junit.internal.runners.statements.FailOnTimeout;

import static org.hamcrest.Matchers.equalTo;

import javax.xml.transform.OutputKeys;
import java.io.File;

public class DeleteCartStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Delete cart with valid id {int}")
    public void deleteCartWithValidIdId(int id) {
        DummyJsonAPI.setDeleteCart(id);
    }

    @When("Send delete cart request")
    public void sendDeleteCartRequest() {
        SerenityRest.when().delete(dummyJsonAPI.DELETE_CART);
    }

    @And("Validate delete cart json schema")
    public void validateDeleteCartJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/DeleteCartJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete cart with invalid id {int}")
    public void deleteCartWithInvalidIdId(int id) {
        DummyJsonAPI.setDeleteCart(id);
    }
}
