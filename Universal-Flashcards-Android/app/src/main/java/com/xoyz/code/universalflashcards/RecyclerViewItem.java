package com.xoyz.code.universalflashcards;

public class RecyclerViewItem {
    private int ImageResource;
    private String main_text;
    private String sub_text;

    public RecyclerViewItem(int pImageResource, String pmain_text, String psub_text) {
        ImageResource = pImageResource;
        main_text = pmain_text;
        sub_text = psub_text;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getMain_text() {
        return main_text;
    }

    public String getSub_text() {
        return sub_text;
    }
}
