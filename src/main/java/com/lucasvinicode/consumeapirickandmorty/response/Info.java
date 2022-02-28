package com.lucasvinicode.consumeapirickandmorty.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Info {

    private String count;
    private String pages;
    private String next;
    private String prev;
}
