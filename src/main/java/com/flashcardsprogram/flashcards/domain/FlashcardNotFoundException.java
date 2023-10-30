package com.flashcardsprogram.flashcards.domain;

public class FlashcardNotFoundException extends RuntimeException{
    public FlashcardNotFoundException(long id){
        super("Flashcard with id: " + id + " not found.");
    }
}
