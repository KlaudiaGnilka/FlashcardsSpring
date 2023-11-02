package com.flashcardsprogram.flashcards.domain;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


import java.util.Objects;

public class Flashcard {
    @NotBlank(message = "The wordIT must be defined")
    private String wordIT;

    @NotBlank(message = "The wordEN must be defined")
    private String wordEN;

    @Id
    private long id;

    public Flashcard(long id, String wordEN, String wordIT) {
        this.wordIT = wordIT;
        this.wordEN = wordEN;
        this.id = id;
    }

    public String getWordIT() {
        return wordIT;
    }

    public void setWordIT(String wordIT) {
        this.wordIT = wordIT;
    }

    public String getWordEN() {
        return wordEN;
    }

    public void setWordEN(String wordEN) {
        this.wordEN = wordEN;
    }

    public long getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }


    @Override
    public String toString() {
        return wordEN + " ---------- " + wordIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return Objects.equals(wordEN, flashcard.wordEN) && Objects.equals(wordIT, flashcard.wordIT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordIT, wordEN);
    }
}
