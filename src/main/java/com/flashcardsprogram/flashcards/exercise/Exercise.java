package com.flashcardsprogram.flashcards.exercise;

import java.util.*;

public abstract class Exercise {

    public abstract List<String> showExercise();

    public abstract List<Boolean> solveExercise(List<String> answer);
}
