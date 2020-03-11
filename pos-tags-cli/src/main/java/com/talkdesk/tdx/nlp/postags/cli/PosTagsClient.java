package com.talkdesk.tdx.nlp.postags.cli;

import com.talkdesk.tdx.nlp.postags.dto.PosTags;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/postags")
public interface PosTagsClient {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    PosTags analyze(String text);
}
