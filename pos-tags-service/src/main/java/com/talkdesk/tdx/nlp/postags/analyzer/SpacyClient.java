package com.talkdesk.tdx.nlp.postags.analyzer;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "spacy-api")
public interface SpacyClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    String analyze(TextRequest text);
}
