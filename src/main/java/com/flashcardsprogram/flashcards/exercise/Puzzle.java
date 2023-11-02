package com.flashcardsprogram.flashcards.exercise;

import com.flashcardsprogram.flashcards.domain.Flashcard;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
public class Puzzle extends Exercise {
    private List<String> wordsEN;
    private List<String> wordsIT;

    private List<Flashcard> exerciseFlashcards;

    @Override
    public List<String> showExercise() {
        wordsEN = new ArrayList<>(exerciseFlashcards.stream().map(Flashcard::getWordEN).toList());
        wordsIT = new ArrayList<>(exerciseFlashcards.stream().map(Flashcard::getWordIT).toList());
        Collections.shuffle(wordsEN);
        Collections.shuffle(wordsIT);
        List<String> puzzleWords = new ArrayList<>();
        for(int i = 0; i < wordsEN.size(); i++){
            puzzleWords.add(wordsEN.get(i) + "-" + wordsIT.get(i));
        }
        return puzzleWords;
    }

    @Override
    public List<Boolean> solveExercise(List<String> answers) {
        List<Boolean> results = new ArrayList<>();
        for (String ans : answers) {
            char ans1 = ans.charAt(0);
            char ans2 = ans.charAt(1);
            int ans1Index = Integer.parseInt(String.valueOf(ans1)) - 1;
            int ans2Index = ans2 - 97;
            try {
                String ans1Word = wordsEN.get(ans1Index);
                String ans2Word = wordsIT.get(ans2Index);
                Optional<Flashcard> flashcard = exerciseFlashcards.stream().filter
                        (f -> f.getWordEN().equals(ans1Word)).findFirst();
                if (flashcard.isPresent()) {
                    results.add(ans2Word.equals(flashcard.get().getWordIT()));
                } else {
                    results.add(false);
                }
            } catch (IndexOutOfBoundsException e) {
                results.add(false);
            }
        }
        return results;
    }

    public List<String> getWordsEN() {
        return wordsEN;
    }

    public void setWordsEN(List<String> wordsEN) {
        this.wordsEN = wordsEN;
    }

    public List<String> getWordsIT() {
        return wordsIT;
    }

    public void setWordsIT(List<String> wordsIT) {
        this.wordsIT = wordsIT;
    }

    public List<Flashcard> getExerciseFlashcards() {
        return exerciseFlashcards;
    }

    public void setExerciseFlashcards(List<Flashcard> exerciseFlashcards) {
        this.exerciseFlashcards = exerciseFlashcards;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puzzle puzzle = (Puzzle) o;
        return Objects.equals(wordsEN, puzzle.wordsEN) && Objects.equals(wordsIT, puzzle.wordsIT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordsEN, wordsIT);
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "wordsEN=" + wordsEN +
                ", wordsIT=" + wordsIT +
                '}';
    }
}
