package Topic;

import Course.CoursesStorage;

import java.util.ArrayList;

public class TopicsStorage {
    private static final ArrayList<Topic> topics = new ArrayList<>();
    public static ArrayList<Topic> getTopics() { return topics; }
    public static void addTopic(Topic topic) { topics.add(topic); }
    public static void removeTopicAtIndex(int index) { topics.remove(index); }
    public static void removeTopicObject(Topic topic) { topics.remove(topic); }
    public static void writeAllTopics() {
        int counter = 1;
        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            if (!CoursesStorage.getCourses().get(i).getTopicsNames().isEmpty()) {
                System.out.println("Класс " + counter + ": ");
                CoursesStorage.getCourses().get(i).writeTopics();
                counter++;
            }
        }
        if (counter == 1) {
            System.out.println("Список тем пуст!");
        }
    }
}
