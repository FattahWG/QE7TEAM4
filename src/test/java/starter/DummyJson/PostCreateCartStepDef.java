package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.cucumber.java.zh_cn.假如;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import javax.xml.transform.OutputKeys;
import java.io.File;

public class PostCreateCartStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Post create cart with valid json")
    public void postCreateCartWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/PostCreateCart.json");
        DummyJsonAPI.setPostCreateCart(json);
    }

    @When("Send post create cart request")
    public void sendPostCreateCartRequest() {
        SerenityRest.when().post(dummyJsonAPI.POST_CREATE_CART);
    }

    @And("Response body should contain id {int} and userId {int}")
    public void responseBodyShouldContainIdAndUserId(int id, int userId) {
        SerenityRest.then()
                .body(dummyJsonResponses.ID, equalTo(id))
                .body(dummyJsonResponses.USERID, equalTo(userId));
    }

    @And("Validate post create cart json schema")
    public void validatePostCreateCartJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/PostCreateCartJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
