package com.talkdesk.tdx.nlp.postags;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PosTagsResourceTest {

    @Test
    public void validText_post_validJson() throws Exception {
        String json = "{\"words\":[" +
                "{\"tag\":\"NN\",\"text\":\"My name\"}," +
                "{\"tag\":\"VBZ\",\"text\":\"is\"}," +
                "{\"tag\":\"NNP\",\"text\":\"Miguel\"}]}";

        given().body("My name is Miguel")
          .when().post("/postags")
          .then()
             .statusCode(200)
             .body(is(json));
    }
}