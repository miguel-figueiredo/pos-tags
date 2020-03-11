package com.talkdesk.tdx.nlp.postags.util;

import java.io.*;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public class TestUtils {
    public static String readResource(String resource) throws IOException {
        String json;
        try(InputStream stream = TestUtils.class.getResourceAsStream(resource)){
            json = IOUtils.toString(stream, Charset.defaultCharset());
            if(json == null){
                throw new RuntimeException("Could not read resource: " + resource);
            }
        }
        return json;
    }
}
