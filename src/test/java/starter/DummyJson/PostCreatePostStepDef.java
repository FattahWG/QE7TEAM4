package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PostCreatePostStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Post create post with valid json")
    public void postCreatePostWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/CreatePost.json");
        DummyJsonAPI.setPostCreatePost(json);
    }

    @When("Send post create post request")
    public void sendPostCreatePostRequest() {
        SerenityRest.when().post(dummyJsonAPI.POST_CREATE_POST);
    }

    @And("Body response should contain title {string} and userId {int}")
    public void bodyResponseShouldContainTitleAndUserId(String title, int userId) {
        SerenityRest.then()
                .body(dummyJsonResponses.TITLE, equalTo(title))
                .body(dummyJsonResponses.USERID, equalTo(userId));
    }

    @And("Validate post create post json schema")
    public void validatePostCreatePostJsonSchema() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/CreatePostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
