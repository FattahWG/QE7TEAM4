package starter.DummyJSON;

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

public class PostCreatePostStepDef {
    @Steps
    DummyJsonAPI dummyJsonAPI;

    @Given("Post create post with valid json")
    public void postCreatePostWithValidJson() {
        File json = new File(DummyJsonAPI.JSON_REQUEST_BODY + "/CreatePost.json");
        dummyJsonAPI.setPostCreatePost(json);
    }

    @When("Send post create post request")
    public void sendPostCreatePostRequest() {
        SerenityRest.when().post(DummyJsonAPI.POST_CREATE_POST);
    }

    @And("Body response should contain title {string} and userId {int}")
    public void bodyResponseShouldContainTitleAndUserId(String title, int userId) {
        SerenityRest.then()
                .body(DummyJsonResponse.TITLE, equalTo(title))
                .body(DummyJsonResponse.USERID, equalTo(userId));
    }

    @And("Validate post create post json schema")
    public void validatePostCreatePostJsonSchema() {
        File json = new File(DummyJsonAPI.JSON_SCHEMA + "/CreatePostJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
