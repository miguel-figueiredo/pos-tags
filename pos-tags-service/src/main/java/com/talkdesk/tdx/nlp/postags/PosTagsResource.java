package com.talkdesk.tdx.nlp.postags;

import com.talkdesk.tdx.nlp.postags.analyzer.PosTagsService;
import com.talkdesk.tdx.nlp.postags.analyzer.TextRequest;
import com.talkdesk.tdx.nlp.postags.dto.PosTags;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/postags")
// With Lombok's all args constructor the @Inject annotation is not required.
// Both the @Inject and the @AllArgsConstructor tend to hide the instantiation complexity of the class. Use it wisely.
@AllArgsConstructor
public class PosTagsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PosTagsResource.class);

    PosTagsService posTagsService;

    TextRequestDao textRequestDao;

    ManagedExecutor managedExecutor;

    /**
     * Analyzes a text and returns Part-of-Speech Tags (PoS) in a JSON format.
     * 
     * @param text the text to be analyzed
     * @return the PoS Tags
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response analyze(String text) {
        LOGGER.info("Analyzing text: {}", text);
        TextRequest textRequest = new TextRequest(text);
        managedExecutor.runAsync(() -> textRequestDao.persist(textRequest));

        PosTags posTags = posTagsService.analyze(textRequest);
        return Response.ok().entity(posTags).build();
    }
}