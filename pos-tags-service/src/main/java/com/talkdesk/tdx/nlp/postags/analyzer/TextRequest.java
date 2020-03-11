package com.talkdesk.tdx.nlp.postags.analyzer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TextRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String model = "en";

    public TextRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getModel() {
        return model;
    }
}
