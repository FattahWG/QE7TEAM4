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

public class GetSearchPostBodyStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get search post body with valid parameter word {string}")
    public void getSearchPostBodyWithValidParameterWordWord(String word) {
        DummyJsonAPI.setGetSearchPostBody(word);
    }

    @When("Send get search post body request")
    public void sendGetSearchPostBodyRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_SEARCH_POST_BODY);
    }

    @And("Validate get search post body json schema")
    public void validateGetSearchPostBodyJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetSearchPostBodyJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
