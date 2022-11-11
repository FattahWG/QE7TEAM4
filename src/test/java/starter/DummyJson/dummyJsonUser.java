package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class dummyJsonUser {
    @Steps
    dummyJsonAPI DummyJsonAPI;
    @Given("Get list user with valid path")
    public void getListUserWithValidPath() {
        DummyJsonAPI.GetListUser();
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_LIST_USER);
    }

    @And("Validate get list user with valid json")
    public void validateGetListUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getListUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterId(int id) {
        DummyJsonAPI.GetSingleUserValidId(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_SINGLE_USER);
    }

    @And("Validate get single user with valid json")
    public void validateGetSingleUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/GetSingleUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single user with invalid parameter page {string}")
    public void getSingleUserWithInvalidParameterPage(String page) {
        DummyJsonAPI.GetSingleUserInalidPage(page);
    }

    @Then("Status code should be {int} Bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Given("Get single user with invalid parameter id {int}")
    public void getSingleUserWithInvalidParameterIdId(int id) {
        DummyJsonAPI.GetSingleUserInalidId(id);
    }

    @Given("Get search user with valid page {string}")
    public void getSearchUserWithValidPage(String page) {
        DummyJsonAPI.GetSearchUserValidPage(page);
    }

    @When("Send get search user request")
    public void sendGetSearchUserRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_SEARCH_USER);
    }

    @And("Validate get search user with valid json")
    public void validateGetSearchUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getSearchUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get search user with invalid page {string}")
    public void getSearchUserWithInvalidPage(String page) {
        DummyJsonAPI.GetSearchUserInvalidPage(page);
    }

    @Given("Get filter user with valid key {string} and value {string}")
    public void getFilterUserWithValidKeyAndValue(String key, String value) {
       DummyJsonAPI.GetFilterWithValidPath(key, value);
    }

    @When("Send get filter user request")
    public void sendGetFilterUserRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_FILTER_USER);
    }

    @And("Validate get filter user with valid json")
    public void validateGetFilterUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getFilterUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get user carts with valid path by user id {int}")
    public void getUserCartsWithValidPathByUserIdId(int id) {
        DummyJsonAPI.GetUserCartsById(id);
    }

    @When("Send get user carts request")
    public void sendGetUserCartsRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_USER_CARTS);
    }

    @And("Validate get user carts by id with valid json")
    public void validateGetUserCartsByIdWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getUserCartsJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get user carts with invalid path by user id {string}")
    public void getUserCartsWithInvalidPathByUserIdId(String id) {
        DummyJsonAPI.GetUserCartsWithInvalidById(id);
    }

    @Given("Get user post with valid id {int}")
    public void getUserPostWithValidId(int id) {
        DummyJsonAPI.GetUserPostsById(id);
    }

    @When("Send get user posts request")
    public void sendGetUserPostsRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_USER_POSTS);
    }

    @And("Validate get user posts with valid json")
    public void validateGetUserPostsWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getUserPostsJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get user posts with invalid path by user id {string}")
    public void getUserPostsWithInvalidPathByUserId(String id) {
        DummyJsonAPI.GetUserPostsWithInvalidById(id);
    }

    @Given("Get user todos with valid id {int}")
    public void getUserTodosWithValidId(int id) {
        DummyJsonAPI.GetUserTodosById(id);
    }

    @And("Validate get user todos with valid json")
    public void validateGetUserTodosWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/getUserTodosJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get user todos with invalid path by user id {string}")
    public void getUserTodosWithInvalidPathByUserId(String id) {
        DummyJsonAPI.GetUserTodosWithInvalidById(id);
    }

    @When("Send get user todos request")
    public void sendGetUserTodosRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_USER_TODOS);
    }

    //Add a new User
    @Given("Post add a new user with valid json")
    public void postAddANewUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/AddNewUser.json");
        DummyJsonAPI.ValidateJson(json);
    }

    @When("Send post add a new user")
    public void sendPostAddANewUser() {
        SerenityRest.when().post(dummyJsonAPI.POST_ADD_NEW_USER);
    }

    @And("Validate post add a new user with valid json")
    public void validatePostAddANewUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/postAddNewUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Update User
    @Given("Put update user id {int} with valid json")
    public void putUpdateUserIdIdWithValidJson(int id) {
        File json = new File(dummyJsonAPI.JSON_REG_BODY + "/UpdateUser.json");
        DummyJsonAPI.PutUpdateUser(id, json);
    }
    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(dummyJsonAPI.PUT_UPDATE_USER);
    }
    @And("Respon body should be id {string} and name {string}")
    public void responBodyShouldBeIdIdAndNameName(String id, String lastName) {
        SerenityRest.then().body(dummyJsonResponses.ID, equalTo(id))
                .body(dummyJsonResponses.LASTNAME, equalTo(lastName));
    }

    @And("Validate put update user with valid json")
    public void validatePutUpdateUserWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA + "/PutUpdateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Delet User
    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
        DummyJsonAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(dummyJsonAPI.DELETE_USER);
    }

}
