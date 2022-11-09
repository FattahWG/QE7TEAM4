package starter.DummyJson;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;
public class dummyJsonAPI {
    public static final String URL = "https://dummyjson.com/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REG_BODY = DIR + "/src/test/resources/JSON/Requestbody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String GET_COMMENTS = URL + "comments";
    public static String GET_COMMENTS_ID = URL + "comments/{id}";
    public static String GET_COMMENTS_POSTID = URL + "comments/post/{id}";
    public static String POST_NEW_COMMENTS = URL +"comments/add";
    public static String DELETE_COMMENTS = URL +"comments/{id}";
    public static String HTTP_MOCKUP = URL + "http/{status}";
    public static String HTTP_CUSTOM = URL + "http/404/{message}";


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
}
