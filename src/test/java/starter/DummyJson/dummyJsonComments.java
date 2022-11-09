package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class dummyJsonComments {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    //GET
    //List comments with valid path
    @Given("Get list comments with valid path")
    public void getListCommentsWithParameterIdId() {
    }

    @When("Send get list comments request")
    public void sendGetListCommentsRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_COMMENTS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Respon body should be total comment {int} and limit view {int}")
    public void responBodyShouldBeTotalandLimit(int total, int limit) {
        SerenityRest.then().body(dummyJsonResponses.TOTAL, equalTo(total))
                .body(dummyJsonResponses.LIMIT, equalTo(limit));
    }

    @And("Validate get list comments with valid json")
    public void validateGetListCommentsWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/listCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Comments ID
    @Given("Get comments id {int}")
    public void getCommentsIdId(int id) {
        DummyJsonAPI.GetCommentsId(id);
    }

    @When("Send get comments id")
    public void sendGetCommentsId() {
        SerenityRest.when().get(dummyJsonAPI.GET_COMMENTS_ID);
    }

    @And("Respon body should be id {int} and post id {int}")
    public void responBodyShouldBeIdIdAndPostIdPostId(int id, int postId) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id))
                .body(dummyJsonResponses.POSTID, equalTo(postId));
    }
    @And("Validate get comments id with valid json")
    public void validateGetcommentidWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getCommentsidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get comments post id
    @Given("Get comments post id {int}")
    public void getCommentsPostIdPostId(int postId) {
        DummyJsonAPI.GetCommentsId(postId);
    }

    @When("Send get comments post id")
    public void sendGetCommentsPostId() {
        SerenityRest.when().get(dummyJsonAPI.GET_COMMENTS_POSTID);
    }

    @And("Respon body should be total comments {int}")
    public void responBodyShouldBePostIdPostIdAndTotalCommentsTotal(int total) {
        SerenityRest.then().body(dummyJsonResponses.TOTAL, equalTo(total));
    }
    @And("Validate get comments post id with valid json")
    public void validateGetCommentsPostIdWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getcommentspostidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Invalid comments id
    @Given("Get comments invalid id comments {int}")
    public void getCommentsInvalidIdComments(int invalid) {
        DummyJsonAPI.GetInvalidCommentsid(invalid);
    }

    @When("Send get comments invalid id")
    public void sendGetCommentsInvalidId() {
        SerenityRest.when().get(dummyJsonAPI.GET_COMMENTS_ID);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Respon body should be {string}")
    public void responBodyShouldBe(String message) {
        SerenityRest.then().body(dummyJsonResponses.MESSAGE, equalTo(message));
    }

    @And("Validate get comment invalid id with valid json")
    public void validateGetCommentInvalidIdWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getinvalidcommentsidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Post new Comments
    @Given("Post new comments with valid json")
    public void postNewCommentsWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/createNewComments.json");
        DummyJsonAPI.ValidateJson(json);
    }
    @When("Send post new comments request")
    public void sendPostNewCommentsRequest() {
        SerenityRest.when().post(dummyJsonAPI.POST_NEW_COMMENTS);
    }

    @And("Respon body should be new id {int} and post id {int}")
    public void responBodyShouldBeNewIdAndPostId(int id, int postId) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id))
                .body(dummyJsonResponses.POSTID, equalTo(postId));
    }
    @And("Validate post new comments with valid json")
    public void validatePostNewCommentsWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/postNewcommnetsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Update comments
    @Given("Put update comments id {int} with valid json")
    public void putUpdateCommentsWithValidJson(int id) {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/updateComments.json");
        DummyJsonAPI.PutUpdateComments(id, json);
    }

    @When("Send put update comments request")
    public void sendPutUpdateCommentsRequest() {
        SerenityRest.when().put(dummyJsonAPI.GET_COMMENTS_ID);
    }

    @And("Respon body should be id {int} and comments {string}")
    public void responBodyShouldBeIdIdAndCommentsComments(int id, String comments) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id))
                .body(dummyJsonResponses.BODY, equalTo(comments));
    }

    @And("Validate put update comments with valid json")
    public void validatePutUpdateCommentsWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/updateCommentsSchema.json");
        DummyJsonAPI.ValidateJson(json);
    }

    //Delete Comments
    @Given("Delete comments id {int}")
    public void deleteCommentsIdId(int id) {
        DummyJsonAPI.DeleteComments(id);

    }

    @When("Send delete comments id")
    public void sendDeleteCommentsId() {
        SerenityRest.when().delete(dummyJsonAPI.DELETE_COMMENTS);
    }

    @And("Respon body should be id {int} and user id {int}")
    public void responBodyShouldBeIdIdAndDeleteTrue(int id, int userId) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id))
                .body(dummyJsonResponses.USER_ID, equalTo(userId));

    }

    @And("Validate delete comments with valid json")
    public void validateDeleteCommentsWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/deleteCommentsSchema.json");
        DummyJsonAPI.ValidateJson(json);
    }
}
