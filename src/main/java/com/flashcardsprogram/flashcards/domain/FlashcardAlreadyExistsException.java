package com.flashcardsprogram.flashcards.domain;

public class FlashcardAlreadyExistsException extends RuntimeException{
    public FlashcardAlreadyExistsException(Flashcard flashcard) {
        super("A flashcard: " + flashcard + " already exists.");
    }
}
