package com.talkdesk.tdx.nlp.postags.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.talkdesk.tdx.nlp.postags.util.TestUtils;
import java.util.*;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;

class PosTagsTest {

    @Test
    void deserialize() throws Exception {
        Jsonb jsonb = JsonbBuilder.create();

        PosTags posTags = jsonb.fromJson(TestUtils.readResource("/postags.json"), PosTags.class);

        assertEquals(getExpectedWords(), posTags.getWords());
    }

    private List<PosTag> getExpectedWords() {
        List<PosTag> words = new ArrayList<>();
        words.add(new PosTag("NN", "My name"));
        words.add(new PosTag("VBZ", "is"));
        words.add(new PosTag("NNP", "Miguel"));
        return words;
    }

}