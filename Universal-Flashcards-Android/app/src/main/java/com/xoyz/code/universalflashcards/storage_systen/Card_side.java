package com.xoyz.code.universalflashcards.storage_systen;

public class Card_side {

    private boolean image_available = false;
    private boolean sound_available = false;
    private String content;

    public Card_side(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
