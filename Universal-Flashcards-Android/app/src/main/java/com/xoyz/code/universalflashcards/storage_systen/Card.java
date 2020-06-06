package com.xoyz.code.universalflashcards.storage_systen;

import java.util.Date;
import java.sql.Timestamp;

import com.xoyz.code.universalflashcards.storage_systen.Card_side;

public class Card {

    private Timestamp timestemp_creation;

    private String cardID = "";

    private int stats_reviewed = 0;
    private int stats_passed = 0;
    private int stats_failed = 0;
    private int stats_knowlegdePoints = 0;

    private Card_side sideA = new Card_side("Enter your Question");
    private Card_side sideB = new Card_side("Enter your Answer");

    public Card() {
        Date date = new Date();
        this.timestemp_creation = new Timestamp(date.getTime());
        this.generateNewCardID();
    }

    private void generateNewCardID() {
        Date cacheDate = new Date();
        StringBuilder cacheID = new StringBuilder(String.valueOf(cacheDate.toString()) + "_");
        char[] letters = "abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        for (int i = 0; i < 10; i++) {
            cacheID.append(letters[(int) (Math.random() * letters.length)]);
        }
        this.cardID = cacheID.toString();
    }
}
