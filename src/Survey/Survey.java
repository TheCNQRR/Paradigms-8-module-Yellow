package Survey;

import Question.Question;
import Task.Task;

import java.util.ArrayList;

public class Survey extends Task {
    private final ArrayList<Question> questions;
    public Survey() { this.questions = new ArrayList<Question>(); }
    public void addQuestion(Question question) { this.questions.add(question); }
    public void removeQuestion(Question question) { this.questions.remove(question); }
    public ArrayList<Question> getQuestions() { return new ArrayList<>(questions); }
}