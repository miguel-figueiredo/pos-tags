package com.talkdesk.tdx.nlp.postags;

import com.talkdesk.tdx.nlp.postags.analyzer.TextRequest;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@AllArgsConstructor
public class TextRequestDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextRequestDao.class);

    EntityManager em;

    @Transactional
    public void persist(TextRequest textRequest) {
        LOGGER.info("Persisting text request: {}", textRequest.getText());
        em.persist(textRequest);
    }
}
