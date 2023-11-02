package com.flashcardsprogram.flashcards.exercise;

import com.flashcardsprogram.flashcards.domain.Flashcard;
import com.flashcardsprogram.flashcards.domain.FlashcardRepository;
import com.flashcardsprogram.flashcards.domain.FlashcardService;
import com.flashcardsprogram.flashcards.web.PuzzleController;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class PuzzleMaker implements ExerciseMaker {

    public FlashcardRepository flashcardRepository;

    public PuzzleMaker(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public Exercise createExercise(){
        List<Flashcard> testFlashcards = (List<Flashcard>) flashcardRepository.findAll();
        Puzzle puzzle = new Puzzle();
        if(testFlashcards.size() > 5){
            Collections.shuffle(testFlashcards);
            puzzle.setExerciseFlashcards(testFlashcards.subList(0,5));
        }else{
            puzzle.setExerciseFlashcards(testFlashcards);
        }
        return puzzle;
    }
}
