package Survey;

import Question.Question;
import Question.QuestionType;
import Task.Task;

import java.util.ArrayList;

public class Survey extends Task {
    private final ArrayList<Question> questions;
    public Survey() { this.questions = new ArrayList<Question>(); }
    public void addQuestion(Question question) { this.questions.add(question); }
    public void removeQuestion(Question question) { this.questions.remove(question); }
    public ArrayList<Question> getQuestions() { return new ArrayList<>(questions); }
    public void writeAllQuestions() {
        if (questions.isEmpty()) {
            System.out.println("Список вопросов пуст!");
            return;
        }

        for (int i = 0; i < questions.size(); ++i) {
            Question question = questions.get(i);
            System.out.println("{");
            System.out.println("Вопрос " + (i + 1) + ": " + question.getName());
            System.out.println("Содержание вопроса: " + question.getContent());
            String questionType = "";
            if (question.getQuestionType() == QuestionType.ONE_OF_THE_TWO) { questionType = "выбор одного из двух"; }
            else if (question.getQuestionType() == QuestionType.ONE_OF_SEVERAL) { questionType = "выбор одного из нескольких"; }
            else if (question.getQuestionType() == QuestionType.FREE_RESPONSE) { questionType = "свободный ответ"; }
            System.out.println("Тип вопроса: " + questionType);
            System.out.println("Ответы на вопрос: ");
            for (int j = 0; j < question.getAnswers().size(); ++j) {
                System.out.println(question.getAnswers().get(j));
            }
            System.out.println("}");
        }
    }
}