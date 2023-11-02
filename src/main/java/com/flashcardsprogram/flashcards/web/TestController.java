package com.flashcardsprogram.flashcards.web;

import com.flashcardsprogram.flashcards.exercise.Exercise;
import com.flashcardsprogram.flashcards.exercise.TestMaker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    private final TestMaker testMaker;

    private Exercise exercise;

    public TestController(TestMaker testMaker) {
        this.testMaker = testMaker;
    }

    @GetMapping
    public List<String> createTest(){
        exercise = testMaker.createExercise();
        return exercise.showExercise();
    }

    @PostMapping
    public List<Boolean> solveTest(@RequestBody List<String> answers){
        return exercise.solveExercise(answers);
    }
}
