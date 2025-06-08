package Question;

import java.util.ArrayList;


public class QuestionsStorage {
    private static final ArrayList<Question> questions = new ArrayList<>();
    public static ArrayList<Question> getQuestions() { return questions; }
    public static void addQuestion(Question question) { questions.add(question); }
    public static void removeQuestionAtIndex(int index) { questions.remove(index); }
    public static void removeQuestionObject(Question question) { questions.remove(question); }
}
