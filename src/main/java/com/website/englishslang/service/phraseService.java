package com.website.englishslang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class phraseService {

    private Map<String, String> dictionary;
    public phraseService(){
        dictionary = new HashMap<>();
        loadPhrases();
    }
    public void loadPhrases(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Map<String, String> phrases = objectMapper.readValue(getClass().getResourceAsStream("/phrases.json"), Map.class);
            dictionary.putAll(phrases);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
