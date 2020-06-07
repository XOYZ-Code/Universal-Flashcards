package com.xoyz.code.universalflashcards.storage_systen;

public class ContentHandler {
    private Card contentCard;
    private Folder contentFolder;
    private boolean isCard;
    private boolean isFolder;

    public ContentHandler(Object content) {
        System.out.println(content.getClass().getName());
    }
}
