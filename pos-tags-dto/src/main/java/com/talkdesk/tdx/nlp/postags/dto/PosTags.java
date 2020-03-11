package com.talkdesk.tdx.nlp.postags.dto;

import static java.util.stream.Collectors.joining;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosTags {

    private List<PosTag> words;

    @Override
    public String toString(){
        return words.stream().map(PosTag::toString).collect(joining(", "));
    }
}
