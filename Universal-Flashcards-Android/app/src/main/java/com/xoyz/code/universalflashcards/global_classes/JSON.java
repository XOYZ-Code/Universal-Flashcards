package com.xoyz.code.universalflashcards.global_classes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSON {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    public static JsonNode readJson(String content) throws IOException {
        return objectMapper.readTree(content);
    }
}
