package starter.DummyJson;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;
public class dummyJsonAPI {
    public static final String URL = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REG_BODY = DIR + "/src/test/resources/JSON/Requestbody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String GET_COMMENTS = URL + "/comments";
    public static String GET_COMMENTS_ID = URL + "/comments/{id}";
    public static String GET_COMMENTS_POSTID = URL + "/comments/post/{id}";
    public static String POST_NEW_COMMENTS = URL +"/comments/add";
    public static String DELETE_COMMENTS = URL +"/comments/{id}";
    public static String HTTP_MOCKUP = URL + "/http/{status}";
    public static String HTTP_CUSTOM = URL + "/http/404/{message}";
    public static String GET_ALL_QUOTES = URL + "/quotes";
    public static String GET_SINGLE_QUOTES = URL + "/quotes/{id}";
    public static String GET_RANDOM_QUOTES = URL + "/quotes/random";
    public static String GET_ALL_TODOS = URL + "/todos";
    public static String GET_SINGLE_TODOS = URL + "/todos/{id}";
    public static String POST_NEW_TODO = URL + "/todos/add";

    //Scenario GET
    public static String GET_ALL_POST = URL + "/posts";
    public static String GET_SINGLE_POST = URL + "/posts/{id}";
    public static String GET_POST_ID = URL + "/posts/{postid}/comments";
    public static String GET_POST_BY_USER_ID = URL + "/posts/user/{userid}";
    public static String GET_SEARCH_POST_BODY = URL + "/posts/search?q={word}";

    //Scenario POST
    public static String POST_CREATE_POST = URL + "/posts/add";

    //Scenario PUT
    public static String PUT_UPDATE_POST = URL + "/posts/{id}";

    //Scenario DELETE
    public static String DELETE_POST = URL + "/posts/{id}";

    public static String GET_ALL_CARTS = URL + "/carts";
    public static String GET_SINGLE_CARTS = URL + "/carts/{id}";
    public static String GET_CART_USER_BY_USER_ID = URL + "/carts/user/{userId}";

    //Scenario POST
    public static String POST_CREATE_CART = URL + "/carts/add";

    //Scenario PUT
    public static String PUT_UPDATE_CART = URL + "/carts/{id}";

    //Scenario DELETE
    public static String DELETE_CART = URL + "/carts/{id}";



    public static String GET_ALL_PRODUCTS = URL + "/products";
    public static String GET_SINGLE_PRODUCTS = URL + "/products/{id}";
    public static String GET_ALL_PRODUCTS_CATEGORIES = URL + "/products/categories";
    public static String POST_A_PRODUCT = URL + "/products/add";
    public static String PUT_UPDATE_A_PRODUCT = URL + "/products/{id}";
    public static String DELETE_A_PRODUCT = URL + "/products/{id}";

    public static String GET_LIST_USER = URL + "/users";
    public static String GET_INVALID_USER = URL + "userrrsst";
    public static String GET_SINGLE_USER =URL + "/users/{id}";
    public static String GET_SEARCH_USER = URL + "/users/search?q={page}";
    public static String GET_FILTER_USER = URL + "/users/filter?key={key}&value={value}";
    public static String GET_USER_CARTS = URL + "/users/{id}/carts";
    public static String GET_USER_POSTS = URL +"/users/{id}/posts";
    public static String GET_USER_TODOS = URL +"/users/{id}/todos";
    public static String POST_ADD_NEW_USER = URL + "/users/add";
    public static String PUT_UPDATE_USER = URL + "/users/{id}";
    public static String DELETE_USER = URL + "/users/{id}";

    @Step("Get All Post")
    public void setGetAllPost(){
        SerenityRest.given();
    }

    //Scenario Single Post
    @Step("Get Single Post")
    public void setGetSinglePost(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Scenario Get Post ID
    @Step("Get Post ID")
    public void setGetPostId(int postId){
        SerenityRest.given().pathParam("postid", postId);
    }

    //Scenario Get Post By User ID
    @Step("Get Post By User ID")
    public void setGetPostByUserId(int userId){
        SerenityRest.given().pathParam("userid", userId);
    }

    //Scenario Get Search Post Body
    @Step("Get Search Post Body")
    public void setGetSearchPostBody(String word){
        SerenityRest.given().pathParam("word",word);
    }

    //Scenario Post Create Post
    @Step("Post Create Post")
    public void setPostCreatePost(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Put Update Post
    @Step("Put Update Post")
    public void setPutUpdatePost(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Delete Post
    @Step("Delete Post")
    public void setDeletePost(int id){
        SerenityRest.given().pathParam("id", id);
    }

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

    //GET METHOD
    @Step("Get list comments")
    public void GetListComments(){
    }
    @Step("Get comments id")
    public void GetCommentsId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get comments post id")
    public void GetCommentsPostid(int postId){
        SerenityRest.given().pathParam("postId", postId);
    }
    @Step("Get invalid comments id")
    public void GetInvalidCommentsid(int id){
        SerenityRest.given().pathParam("id", id);
    }
    //PUT METHOD
    @Step("Post new comments")
    public void ValidateJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Put update comments")
    public void PutUpdateComments(int id,File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Delete comments")
    public void DeleteComments(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Mockup HTPP")
    public void MockupHttp(String status){ SerenityRest.given().pathParam("status", status);
    }

    @Step("Mockup custom")
    public void MockupCustom(String http){
        SerenityRest.given().pathParam("message", http);
    }

    @Step ("Get List User")
    public void GetListUser(){
    }
//    @Step ("Get List User invalid")
//    public void GetListUserInvalid(){
//
//    }
    @Step ("Get Single User Valid Id")
    public void GetSingleUserValidId(int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step ("Get Single User invalid page")
    public void GetSingleUserInalidPage(String page){
        SerenityRest.given().pathParams("id", page);
    }
    @Step ("Get Single User invalid Id")
    public void GetSingleUserInalidId(int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step ("Get search user with valid Page")
    public void GetSearchUserValidPage(String page){
        SerenityRest.given().pathParams("page", page);
    }
    @Step ("Get search user with invalid Page")
    public void GetSearchUserInvalidPage (String page){
        SerenityRest.given().pathParams("page", page);
    }
    @Step ("Get filter user with valid path")
    public void GetFilterWithValidPath(String key, String value){
        SerenityRest.given().pathParams("key", key)
                .pathParams("value", value);
    }
    @Step("Get user carts by id")
    public void GetUserCartsById (int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step("Get user carts with invalid by id")
    public void GetUserCartsWithInvalidById (String id){
        SerenityRest.given().pathParams("id", id);
    }

    @Step("Get user posts by id")
    public void GetUserPostsById (int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step("Get user posts with invalid by id")
    public void GetUserPostsWithInvalidById (String id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step("Get user todos by id")
    public void GetUserTodosById (int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step("Get user todos with invalid by id")
    public void GetUserTodosWithInvalidById (String id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step ("Post add a new user")
    public void PostAddNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Put update user")
    public void PutUpdateUser(int id,File json){
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }


    @Step("Delete User")
    public void deleteUser (int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get quotes id")
    public void GetQuotesId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get todos id")
    public void GetTodosId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get todos user id")
    public void GetTodosUserId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get All Products")
    public void setGetAllProducts(){
        SerenityRest.given();
    }

    @Step("Get Single Products")
    public void setGetSingleProducts(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get All Products Categories")
    public void setGetAllProductsCategories(){
        SerenityRest.given();
    }

    @Step("Post Create Products")
    public void setPostAProduct(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Product")
    public void setPutUpdateAProduct(int id, File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("id", id);
    }

    @Step("Delete Product")
    public void setDeleteAProduct(int id){
        SerenityRest.given().pathParam("id", id);
    }

}
