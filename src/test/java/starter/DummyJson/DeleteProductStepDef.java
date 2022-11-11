package starter.DummyJson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteProductStepDef {
    @Steps
    dummyJsonAPI DummyJsonAPI;
    @Given("Delete product with valid id {int}")
    public void deleteProductWithValidIdId(int id) {
        DummyJsonAPI.setDeleteAProduct(id);
    }

    @When("Send delete product request")
    public void sendDeleteProductRequest() {
        SerenityRest.when().delete(dummyJsonAPI.DELETE_A_PRODUCT);
    }
}
