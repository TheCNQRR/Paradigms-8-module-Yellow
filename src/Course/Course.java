package Course;

import Section.Section;
import Topic.Topic;
import Module.Module;

import java.util.ArrayList;

public class Course {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private ArrayList<Topic> topics;
    public ArrayList<Topic> getTopics() { return new ArrayList<>(topics); }
    public void setTopics(ArrayList<Topic> topics) { this.topics = topics; }
    public void addTopic(Topic topic) { topics.add(topic); }
    public void removeTopicAtIndex(int index) { topics.remove(index); }
    public void removeTopicObject(Topic topic) { topics.remove(topic); }
    //TODO полный вывод курса
    public void writeCourse(Course course) {
        System.out.println("Название курса: " + course.getName());
    }

    public Course(String name) { this.name = name; }

    public Module createModule(String topicName, String name) {
        Module module = new Module(topicName, name, this);
        topics.add(module);
        return module;
    }

    public Section createSection(String name) {
        Section section = new Section(name, this);
        topics.add(section);
        return section;
    }
}