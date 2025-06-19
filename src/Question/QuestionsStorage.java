package Question;

import java.util.ArrayList;


public class QuestionsStorage {
    private static final ArrayList<Question> questions = new ArrayList<>();
    public static ArrayList<Question> getQuestions() { return questions; }
    public static void addQuestion(Question question) { questions.add(question); }
    public static void removeQuestionAtIndex(int index) { questions.remove(index); }
    public static void removeQuestionObject(Question question) { questions.remove(question); }
    public static void writeAllQuestions() {
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
