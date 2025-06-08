package Topic;

import java.util.ArrayList;

public class TopicsStorage {
    private static final ArrayList<Topic> topics = new ArrayList<>();
    public static ArrayList<Topic> getTopics() { return topics; }
    public static void addTopic(Topic topic) { topics.add(topic); }
    public static void removeTopicAtIndex(int index) { topics.remove(index); }
    public static void removeTopicObject(Topic topic) { topics.remove(topic); }
}
