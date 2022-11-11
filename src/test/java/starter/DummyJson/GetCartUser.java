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
import static org.hamcrest.Matchers.not;

import javax.xml.transform.OutputKeys;
import java.io.File;

public class GetCartUser {
    @Steps
    dummyJsonAPI DummyJsonAPI;

    @Given("Get cart user with valid userId {int}")
    public void getCartUserWithValidUserIdUserId(int userId) {
        DummyJsonAPI.setGetCartUserByUserId(userId);
    }

    @When("Send get cart user request")
    public void sendGetCartUserRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_CART_USER_BY_USER_ID);
    }

    @Given("Get cart user with invalid userId {int}")
    public void getCartUserWithInvalidUserIdUserId(int userId) {
        DummyJsonAPI.setGetCartUserByUserId(userId);
    }
}
