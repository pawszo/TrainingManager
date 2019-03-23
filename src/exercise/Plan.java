package exercise;

import java.util.ArrayList;

public class Plan {

    private ArrayList<String> exercises = new ArrayList<>();
    private ArrayList<String> muscles = new ArrayList<>();
    private String name;

    public void addMuscle(String scoreLabel) {
        muscles.add(scoreLabel);
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);

    }

    public void setExercises(Object[] jlist) {
        for(Object c:jlist) {
            exercises.add(c.toString());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String planName = "Training plan created on ";
        return planName;
    }
}
