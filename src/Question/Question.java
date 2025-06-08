package Question;

public class Question {
    QuestionType questionType;
    private String contentOfTheQuestion;
    public String getContentOfTheQuestion() { return contentOfTheQuestion; }
    public void setContentOfTheQuestion(String contentOfTheQuestion) { this.contentOfTheQuestion = contentOfTheQuestion; }

    private String answer;
    public String getAnswer() {return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}