package com.flashcardsprogram.flashcards.exercise;

import com.flashcardsprogram.flashcards.domain.Flashcard;
import com.flashcardsprogram.flashcards.domain.FlashcardRepository;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class TestMaker implements ExerciseMaker {

    public FlashcardRepository flashcardRepository;

    public TestMaker(FlashcardRepository flashcardRepository){
        this.flashcardRepository = flashcardRepository;
    }
    @Override
    public Exercise createExercise() {
        List<Flashcard> testFlashcards = (List<Flashcard>) flashcardRepository.findAll();
        Test test = new Test();
        if(testFlashcards.size() > 10){
            Collections.shuffle(testFlashcards);
            test.setExerciseFlashcards(testFlashcards.subList(0,10));
        }else{
            test.setExerciseFlashcards(testFlashcards);
        }
        return test;
    }
}
