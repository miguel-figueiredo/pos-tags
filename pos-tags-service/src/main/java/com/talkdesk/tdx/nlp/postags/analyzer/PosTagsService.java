package com.talkdesk.tdx.nlp.postags.analyzer;

import com.talkdesk.tdx.nlp.postags.dto.PosTags;
import javax.enterprise.context.*;
import javax.json.bind.JsonbBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PosTagsService {

    SpacyClient client;

    // In this case an @AllArgsConstructor may not be used
    public PosTagsService(@RestClient SpacyClient client){
        this.client = client;
    }

    public PosTags analyze(TextRequest text) {
        String response = client.analyze(text);
        // Manual conversion is required because the spacy HTTP response is text/string
        // Investigate the implementation of a translator
        return JsonbBuilder.create().fromJson(response, PosTags.class);
    }
}
