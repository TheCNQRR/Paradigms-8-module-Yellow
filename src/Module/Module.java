package Module;

import Course.Course;
import Topic.Topic;

import java.util.ArrayList;

public class Module extends Topic {
    private final ArrayList<Topic> topics = new ArrayList<>();
    public void addTopic(Topic topic) {
        if (topic.getCourse() != this.course) {
            throw new IllegalArgumentException("Topic.Topic must belong to the same course");
        }
        topics.add(topic);
    }
    public ArrayList<Topic> getTopics() { return new ArrayList<>(topics); }

    public Module(String name, Course course) {
        super(course);
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}