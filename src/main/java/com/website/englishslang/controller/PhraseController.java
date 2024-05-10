package com.website.englishslang.controller;

import com.website.englishslang.service.PhraseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhraseController {
    private PhraseService phraseService;
    public PhraseController(){
        phraseService = new PhraseService();
    }
    @GetMapping("/")
    public String showMainPage(){

    }
    @GetMapping("/phrase/{word}")
    public String getDefinition(){

    }
    @GetMapping("/search")
    public String serachDefinition(){

    }
}
