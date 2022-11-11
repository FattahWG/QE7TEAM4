package starter.DummyJson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import javax.naming.directory.SearchResult;
import java.io.File;

public class dummyJsonTodos {

    @Steps
    dummyJsonAPI DummyJsonAPI;

    //Scenario 1
    @Given("Get all todos")
    public void getAllTodos() {
    }
    @When("Send get all todos request")
    public void sendGetAllTodosRequest() {
        SerenityRest.when()
                .get(dummyJsonAPI.GET_ALL_TODOS);
    }

    //Scenario 2
    @Given("Get single todo id {int}")
    public void getSingleTodoId(int id) {
        DummyJsonAPI.GetTodosId(id);
    }

    @When("Send get single todo id")
    public void sendGetSingleTodoId() {
        SerenityRest.when()
                .get(dummyJsonAPI.GET_SINGLE_TODOS);
    }

    @And("Validate get single todo id with valid json")
    public void validateGetSingleTodoIdWithValidJson() {
        File json = new File(dummyJsonAPI.JSON_SCHEMA +  "/getSingleTodoSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
