package com.flashcardsprogram.flashcards.domain;

public class FlashcardAlreadyExistsException extends RuntimeException{
    public FlashcardAlreadyExistsException(long id) {
        super("A flashcard with id: " + id + " already exists.");
    }
}
