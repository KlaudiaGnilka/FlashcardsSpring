package com.flashcardsprogram.flashcards.web;

import com.flashcardsprogram.flashcards.domain.FlashcardAlreadyExistsException;
import com.flashcardsprogram.flashcards.domain.FlashcardNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FlashcardControllerAdvice {

    @ExceptionHandler(FlashcardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String flashcardNotFoundHandler(FlashcardNotFoundException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(FlashcardAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String flashcardAlreadyExistsHandler(FlashcardAlreadyExistsException exception){
        return exception.getMessage();
    }
}
