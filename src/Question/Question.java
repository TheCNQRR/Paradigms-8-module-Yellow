package Question;

import Survey.Survey;

import java.util.ArrayList;

public class Question {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Question(Survey survey, String name, QuestionType questionType) {
        survey.addQuestion(this);
        this.name = name;
        this.questionType = questionType;
    }

    private String content;
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    private QuestionType questionType;
    public QuestionType getQuestionType() { return questionType; }
    public void setQuestionType(QuestionType questionType) { this.questionType = questionType; }

    private final ArrayList<String> answers = new ArrayList<>();
    public ArrayList<String> getAnswers() {return new ArrayList<>(answers); }
    public void addAnswer(String answer) { answers.add(answer); }
    public void replaceAnswer(int index, String newAnswer) { answers.set(index, newAnswer); }
    public void clearAnswers() { answers.clear(); }

    public void writeQuestion() {
        System.out.println("Вопрос: " + getName());
        System.out.println("Содержание вопроса: " + getContent());
        String questionType = "";
        if (this.questionType == QuestionType.ONE_OF_THE_TWO) { questionType = "выбор одного из двух"; }
        else if (this.questionType == QuestionType.ONE_OF_SEVERAL) { questionType = "выбор одного из нескольких"; }
        else if (this.questionType == QuestionType.FREE_RESPONSE) { questionType = "свободный ответ"; }
        System.out.println("Тип вопроса: " + questionType);
        System.out.println("Ответы на вопрос: ");
        for (int j = 0; j < this.getAnswers().size(); ++j) {
            System.out.println(this.getAnswers().get(j));
        }
    }
}