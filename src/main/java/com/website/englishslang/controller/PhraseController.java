package com.website.englishslang.controller;

import com.website.englishslang.service.PhraseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PhraseController {
    private PhraseService phraseService;
    public PhraseController(){
        phraseService = new PhraseService();
    }
    @GetMapping("/")
    public String showMainPage(){

        return phraseService.getDictionary().toString();
    }
    @GetMapping("/phrase/{word}")
    public String getDefinition(@PathVariable String word){
        return phraseService.getDefiniton(word);

    }
    @GetMapping("/search")
    public String searchDefinition(@RequestParam String query){
        if(phraseService.getDictionary().containsKey(query)){
            return getDefinition(query);
        }
        else {
            return "Такого слова не найдено!";
        }
    }

}
