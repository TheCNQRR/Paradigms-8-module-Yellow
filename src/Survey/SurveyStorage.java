package Survey;

import Question.QuestionType;

import java.util.ArrayList;

public class SurveyStorage {
    private static final ArrayList<Survey> surveys = new ArrayList<>();
    public static ArrayList<Survey> getSurvey() { return surveys; }
    public static void addSurvey(Survey survey) { surveys.add(survey); }
    public static void removeSurveyAtIndex(int index) { surveys.remove(index); }
    public static void removeSurveyObject(Survey survey) { surveys.remove(survey); }
    public static void writeAllSurvey() {
        if (surveys.isEmpty()) {
            System.out.println("Список вопросов пуст!");
            return;
        }

        for (int i = 0; i < surveys.size(); ++i) {
            Survey survey = surveys.get(i);
            System.out.println("Название опроса: " + survey.getName());
            System.out.println("Список вопросов: ");
            System.out.println("{");
            for (int j = 0; j < survey.getQuestions().size(); ++j) {
                System.out.println("Вопрос " + (i + 1) + ": " + survey.getQuestions().get(j).getName());
                System.out.println("Содержание вопроса: " + survey.getQuestions().get(j).getContent());
                String questionType = "";
                if (survey.getQuestions().get(j).getQuestionType() == QuestionType.ONE_OF_THE_TWO) { questionType = "выбор одного из двух"; }
                else if (survey.getQuestions().get(j).getQuestionType() == QuestionType.ONE_OF_SEVERAL) { questionType = "выбор одного из нескольких"; }
                else if (survey.getQuestions().get(j).getQuestionType() == QuestionType.FREE_RESPONSE) { questionType = "свободный ответ"; }
                System.out.println("Тип вопроса: " + questionType);
                System.out.println("Ответы на вопрос: ");
                for (int k = 0; k < survey.getQuestions().get(j).getAnswers().size(); ++k) {
                    System.out.println(survey.getQuestions().get(j).getAnswers().get(k));
                }
                System.out.println("}");
            }
        }
    }
}
