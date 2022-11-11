package starter.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;

import java.io.File;

public class dummyJsonAPI {
    public static final String URL = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema";

    //Scenario GET
    public static String GET_ALL_CARTS = URL + "/carts";
    public static String GET_SINGLE_CARTS = URL + "/carts/{id}";
    public static String GET_CART_USER_BY_USER_ID = URL + "/carts/user/{userId}";

    //Scenario POST
    public static String POST_CREATE_CART = URL + "/carts/add";

    //Scenario PUT
    public static String PUT_UPDATE_CART = URL + "/carts/{id}";

    //Scenario DELETE
    public static String DELETE_CART = URL + "/carts/{id}";

    //==========================================================================================//

    //Scenario All Carts
    @Step("Get All Carts")
    public void setGetAllCarts(){
        SerenityRest.given();
    }

    //Scenario Get Single Cart
    @Step("Get Single Cart")
    public void setGetSingleCarts(int id){
        SerenityRest.given().pathParam("id", id);
    }

    //Scenario Cart User By User ID
    @Step("Get Cart User By User ID")
    public void setGetCartUserByUserId(int userId){
        SerenityRest.given().pathParam("userId", userId);
    }

    //Scenario Post Create Cart
    @Step("Post Create Cart")
    public void setPostCreateCart(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Put Update Cart
    @Step("Put Update Cart")
    public void setPutUpdateCart(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Delete Cart
    @Step("Delete Cart")
    public void setDeleteCart(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
