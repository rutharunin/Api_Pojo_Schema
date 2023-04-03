package tests.apiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Test;

import java.io.InputStream;

public class CreatePersonJsonSchema {

    PostPerson postPerson=new PostPerson();
    @Test
    public void postSchemaTest() throws JsonProcessingException {

        InputStream createPersonSchema=getClass().getClassLoader()
                        .getResourceAsStream("createpersonjsonschema.json");

        postPerson.uriNavigation();
        postPerson.serializedData("Baks","ALotOfBs");
        postPerson.post().then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(createPersonSchema));
    }
}
