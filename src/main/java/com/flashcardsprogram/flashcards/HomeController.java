package com.flashcardsprogram.flashcards;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String GetGreeting(){
        return "Welcome to the flashcards program";
    }
}
