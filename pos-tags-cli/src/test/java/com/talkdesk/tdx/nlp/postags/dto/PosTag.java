package com.talkdesk.tdx.nlp.postags.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PosTag {

    private String tag;
    private String text;
}