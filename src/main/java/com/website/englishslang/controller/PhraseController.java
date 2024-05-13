package com.website.englishslang.controller;

import com.website.englishslang.service.PhraseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PhraseController {
    private final PhraseService phraseService;
    public PhraseController(){
        phraseService = new PhraseService();
    }
    @GetMapping("/")
    public String showMainPage(Model model){
        Map<String, String> dict = phraseService.getDictionary();
        model.addAttribute("words", dict.keySet());
        model.addAttribute("definitions", dict.values());
        return "index";
    }
    @GetMapping("/phrase/{word}")
    public String getDefinition(@PathVariable String word, Model model){
        String definiton = phraseService.getDefiniton(word);
        model.addAttribute("word", word);
        model.addAttribute("definition", definiton);
        return "phrase";

    }
    @GetMapping("/search")
    public String searchDefinition(@RequestParam String query, Model model){
        if(phraseService.getDictionary().containsKey(query)){
            String results = phraseService.getDefiniton(query);
            model.addAttribute("results", results);
            model.addAttribute("word", query);
            return "search";
        }
        else {
            return "search";
        }
    }

}
