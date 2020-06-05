package com.xoyz.code.universalflashcards.global_classes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import java.io.IOException;

public class JSON {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        return new ObjectMapper();
    }

    public static JsonNode readJson(String content) throws IOException {
        return objectMapper.readTree(content);
    }
}
