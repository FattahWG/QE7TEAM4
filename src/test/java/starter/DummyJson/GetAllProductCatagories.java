package starter.DummyJson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetAllProductCatagories {
    @Steps
    dummyJsonAPI DummyJsonAPI;
    @Given("Get All Products Categories")
    public void getAllProductsCategories() {
        DummyJsonAPI.setGetAllProductsCategories();
    }

    @When("Send all products categories request")
    public void sendAllProductsCategoriesRequest() {
        SerenityRest.when().get(dummyJsonAPI.GET_ALL_PRODUCTS_CATEGORIES);
    }
}
