package Course;

import Section.Section;
import Topic.Topic;
import CourseModule.CourseModule;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Course {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private ArrayList<Topic> topics = new ArrayList<>();
    public ArrayList<Topic> getTopics() { return new ArrayList<>(topics); }
    public void setTopics(ArrayList<Topic> topics) { this.topics = topics; }
    public void addTopic(Topic topic) { topics.add(topic); }
    public void removeTopicAtIndex(int index) { topics.remove(index); }
    public void removeTopicObject(Topic topic) { topics.remove(topic); }
    public void replaceTopic(int index, Topic topic) { topics.set(index, topic); }
    //TODO полный вывод курса
    public void writeCourse(Course course) { System.out.println("Название курса: " + course.getName()); }
    public void writeTopicAtIndex(int index) {
        System.out.println("Тема с названием \"" + topics.get(index).getName() + "\"");
    }
    public void writeTopics() {
        if (topics.isEmpty()) {
            System.out.println("Список тем пуст!");
        }
        else {
            for (int i = 0; i < topicsNames.size(); ++i) {
                System.out.println("Тема " + (i + 1) + ": " + topicsNames.get(i));
            }
        }
    }

    private final ArrayList<String> topicsNames = new ArrayList<>();
    public void addTopicName(String name) { topicsNames.add(name); }
    public void removeTopicNameAtIndex(int index) { topicsNames.remove(index); }
    public ArrayList<String> getTopicsNames() { return new ArrayList<>(topicsNames); }
    public void replaceTopicName(int index, String name) { topicsNames.set(index, name); }

    private final ArrayList<CourseModule> modules = new ArrayList<>();
    public ArrayList<CourseModule> getModules() { return new ArrayList<>(modules); }
    public void addModule(CourseModule module) { modules.add(module); }
    public void writeModules(Course course) {
        for (int i = 0; i < course.modules.size(); ++i) {
            System.out.println("Модуль " + (i + 1) + ": " + course.modules.get(i).getModuleName());
        }
    }
    public void removeModuleAtIndex(int index) {
        modules.remove(index);
    }


    public Course(String name) { this.name = name; }

    public CourseModule createModule(String topicName, String name) {
        CourseModule module = new CourseModule(topicName, name, this);
        topics.add(module);
        return module;
    }

    public Section createSection(String name) {
        Section section = new Section(name, this);
        topics.add(section);
        return section;
    }
}