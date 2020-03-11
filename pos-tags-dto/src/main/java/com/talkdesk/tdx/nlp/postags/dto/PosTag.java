package com.talkdesk.tdx.nlp.postags.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PosTag {

    private String tag;
    private String text;

    @Override
    public String toString(){
        return text + "/" + tag;
    }
}