package starter.DummyJSON;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class DummyJsonAPI {
    public static final String URL = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema";

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

    //==============================================================================//

    //Scenario All Post
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
}
