package com.flashcardsprogram.flashcards.web;

import com.flashcardsprogram.flashcards.domain.Flashcard;
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
        return flashcardService.viewBookList();
    }

    @GetMapping("{id}")
    public Flashcard getById(@PathVariable long id){
        return flashcardService.viewFlashcardDetails(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flashcard put(Flashcard flashcard){
        return flashcardService.addFlashcardToRepository(flashcard);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(long id){
        flashcardService.removeFlashcardFromRepository(id);
    }

    @PutMapping("{id}")
    public Flashcard edit(@PathVariable long id, Flashcard flashcard){
        return flashcardService.editFlashcardDetails(id, flashcard);
    }

}
