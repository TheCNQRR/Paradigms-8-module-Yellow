package Survey;

import java.util.ArrayList;

public class SurveyStorage {
    private static final ArrayList<Survey> surveys = new ArrayList<>();
    public static ArrayList<Survey> getSurvey() { return surveys; }
    public static void addSurvey(Survey survey) { surveys.add(survey); }
    public static void removeSurveyAtIndex(int index) { surveys.remove(index); }
    public static void removeSurveyObject(Survey survey) { surveys.remove(survey); }
}
