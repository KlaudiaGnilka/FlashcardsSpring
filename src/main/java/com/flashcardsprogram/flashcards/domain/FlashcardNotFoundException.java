package com.flashcardsprogram.flashcards.domain;

public class FlashcardNotFoundException extends RuntimeException{
    public FlashcardNotFoundException(long id){
        super("Flashcard with id: " + id + " not found.");
    }

    public FlashcardNotFoundException(String wordEn){
        super("Flashcard with wordEn: " + wordEn + " not found");
    }
}
