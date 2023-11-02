package com.flashcardsprogram.flashcards.web;

import com.flashcardsprogram.flashcards.exercise.Exercise;
import com.flashcardsprogram.flashcards.exercise.Puzzle;
import com.flashcardsprogram.flashcards.exercise.PuzzleMaker;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("puzzle")
public class PuzzleController {
    private final PuzzleMaker puzzleMaker;

    private Exercise exercise;

    public PuzzleController(PuzzleMaker puzzleMaker){
        this.puzzleMaker = puzzleMaker;
    }

    @GetMapping
    public List<String> createPuzzle(){
        exercise = puzzleMaker.createExercise();
        return exercise.showExercise();
    }

    @PostMapping
    public List<Boolean> solvePuzzle(@RequestBody List<String> answers){
        return exercise.solveExercise(answers);
    }
}
