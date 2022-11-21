package com.example.demo.outdoc;

import org.springframework.data.annotation.Id;

public class InMetadata {

    @Id
    private String id;
    private String word;

    public InMetadata(String id, String word) {
        this.id = id;
        this.word = word;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
