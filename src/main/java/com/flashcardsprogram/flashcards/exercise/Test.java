package com.flashcardsprogram.flashcards.exercise;

import com.flashcardsprogram.flashcards.domain.Flashcard;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class Test extends Exercise{
    private List<Flashcard> exerciseFlashcards;

    @Override
    public List<String> showExercise() {
        List<String> exercise = exerciseFlashcards.stream().map(Flashcard::getWordEN).toList();
        return exercise;
    }

    @Override
    public List<Boolean> solveExercise(List<String> answers) {
        List<String> correctAnswers = exerciseFlashcards.stream().map(Flashcard::getWordIT).toList();
        List<Boolean> results = new ArrayList<>();
        for(int i = 0; i < answers.size(); i++){
            results.add(answers.get(i).equals(correctAnswers.get(i)));
        }
        return results;
    }

    public List<Flashcard> getExerciseFlashcards() {
        return exerciseFlashcards;
    }

    public void setExerciseFlashcards(List<Flashcard> exerciseFlashcards) {
        this.exerciseFlashcards = exerciseFlashcards;
    }
}
