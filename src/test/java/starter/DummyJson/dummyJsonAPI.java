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


    public static String GET_ALL_PRODUCTS = URL + "/products";
    public static String GET_SINGLE_PRODUCTS = URL + "/products/{id}";
    public static String GET_ALL_PRODUCTS_CATEGORIES = URL + "/products/categories";
    public static String POST_A_PRODUCT = URL + "/products/add";
    public static String PUT_UPDATE_A_PRODUCT = URL + "/products/{id}";
    public static String DELETE_A_PRODUCT = URL + "/products/{id}";

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
