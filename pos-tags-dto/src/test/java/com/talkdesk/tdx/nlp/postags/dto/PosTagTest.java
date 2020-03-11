package com.talkdesk.tdx.nlp.postags.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.talkdesk.tdx.nlp.postags.util.TestUtils;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

public class PosTagTest {
    
    @Test
    void deserialize() throws Exception {
        Jsonb jsonb = JsonbBuilder.create();
        String json = TestUtils.readResource("/postag.json");

        PosTag posTag = jsonb.fromJson(json, PosTag.class);
        
        assertEquals("NN", posTag.getTag());
        assertEquals("Hello", posTag.getText());
    }
}
