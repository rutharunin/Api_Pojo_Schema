package tests.apiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import tests.pojo.serializedPojo.AddressPojo;
import tests.pojo.serializedPojo.NamePojo;
import tests.pojo.serializedPojo.PostPersonPoJo;

import java.io.InputStream;
import java.util.*;

public class PostPerson {

    public String requestBody;

    @Test
    public void test1() throws JsonProcessingException{
        uriNavigation();
        serializedData("Baks","ALotOfBs");
        validateSomeResponse();
    }
    public void uriNavigation(){
        RestAssured.baseURI="http://codefish.ninja/openmrs";
        RestAssured.basePath="ws/rest/v1/person";
    }
    public void serializedData(String firstName,String lastName) throws JsonProcessingException {
        //initialize names by creating an object and store it in a variable
        NamePojo namePojo = new NamePojo(firstName,lastName);
        List<NamePojo> nameList = Arrays.asList(namePojo);

        //initialize name by creating an object but not sture the object
        List<AddressPojo> addressList = new ArrayList<>();
        addressList.add(new AddressPojo("5555 w LLLL", "Heaven", "USA", "60000"));

        //all initializations in this class initialize the instances in a pojo class with constructor >>> no Setter method needed
        PostPersonPoJo postPersonPoJo = new PostPersonPoJo(nameList, "M", "2000-10-10", addressList);

        ObjectMapper objectMapper = new ObjectMapper();
        requestBody = objectMapper.writeValueAsString(postPersonPoJo);
    }

    public Response post(){

return                 RestAssured.given()
                        .header("Authorization", "Basic QWRtaW46QWRtaW4xMjM=")
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post()
                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().response();
    }

    public void validateSomeResponse(){

        Map<String,Object>deserializedResponse=post().as(new TypeRef<Map<String,Object>>() {
        });
        Assert.assertEquals(22,deserializedResponse.get("age"));
        Assert.assertEquals("Baks ALotOfBs",deserializedResponse.get("display"));

    }
}