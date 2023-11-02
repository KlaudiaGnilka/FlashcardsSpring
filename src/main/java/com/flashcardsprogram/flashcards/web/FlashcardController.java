package com.flashcardsprogram.flashcards.web;

import com.flashcardsprogram.flashcards.domain.Flashcard;
import com.flashcardsprogram.flashcards.domain.FlashcardAlreadyExistsException;
import com.flashcardsprogram.flashcards.domain.FlashcardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flashcards")
public class FlashcardController {
    private final FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService){
        this.flashcardService = flashcardService;
    }

    @GetMapping
    public Iterable<Flashcard> get(){
        return flashcardService.viewFlashcardList();
    }

    @GetMapping("{id}")
    public Flashcard getById(@PathVariable long id){
        return flashcardService.viewFlashcardDetailsById(id);
    }

    @GetMapping("wordEN/{wordEn}")
    public Flashcard getByWordEn(@PathVariable String wordEn){
        return flashcardService.viewFlashcardDetailsByWordEn(wordEn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flashcard post(@RequestBody Flashcard flashcard){
        try {
            return flashcardService.addFlashcardToRepository(flashcard);
        }catch (FlashcardAlreadyExistsException e){
            System.out.println("This flashcard is already exists");
        }
        return flashcard;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        flashcardService.removeFlashcardFromRepository(id);
    }


    @PutMapping("{id}")
    public Flashcard put(@PathVariable long id, @RequestBody Flashcard flashcard){
        return flashcardService.editFlashcardDetails(id, flashcard);
    }

}
