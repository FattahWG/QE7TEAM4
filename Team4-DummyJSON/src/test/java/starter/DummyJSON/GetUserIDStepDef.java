package starter.DummyJSON;

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

public class GetUserIDStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get post by user id wit valid parameter userid {int}")
    public void getPostByUserIdWitValidParameterUseridUserid(int userid) {
        DummyJsonAPI.setGetPostByUserId(userid);
    }

    @When("Send get post by user request")
    public void sendGetPostByUserRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_POST_BY_USER_ID);
    }

    @And("Validate get post by user id json schema")
    public void validateGetPostByUserIdJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetUserIDJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get post by user id with invalid parameter userid {int}")
    public void getPostByUserIdWithInvalidParameterUseridUserid(int userid) {
        DummyJsonAPI.setGetPostByUserId(userid);
    }
}
