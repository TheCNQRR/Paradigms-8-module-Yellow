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
        if (topicsNames.isEmpty()) {
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
    public void replaceModule(int index, CourseModule module) { modules.set(index, module); }
    public void writeModules(Course course) {
        for (int i = 0; i < course.modules.size(); ++i) {
            System.out.println("Модуль " + (i + 1) + ": " + course.modules.get(i).getModuleName());
        }
    }
    public void removeModuleAtIndex(int index) {
        CourseModule module = modules.get(index);
        modules.remove(module.getParent());
        for (int i = 0; i < module.getChildren().size(); ++i) {
            modules.remove(module.getChildren().get(i));
        }
        module.getParent().removeChildrenObject(module);
        module.removeAllChildren();
        module.removeParent();
        modules.remove(module);
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

    public void writeModulesInCourse(Course course) {
        if (course.topicsNames.isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }

        for (int i = 0; i < topicsNames.size(); ++i) {
            System.out.println("|-Тема " + (i + 1) + ": " + topicsNames.get(i));
            int moduleCounter = 1;

            for (Topic topic : topics) {
                if (topic instanceof CourseModule) {
                    CourseModule module = (CourseModule) topic;
                    if (module.getName().equals(topicsNames.get(i))) {
                        System.out.println("|--Модуль " + moduleCounter + ": " + module.getModuleName());
                        moduleCounter++;

                        if (!module.getChildren().isEmpty()) {
                            printNestedModules(module, 3);
                        }
                    }
                }
            }
        }
    }

    private void printNestedModules(CourseModule parentModule, int depth) {
        int childCounter = 1;
        for (CourseModule child : parentModule.getChildren()) {
            System.out.println("|" + "-".repeat(depth) + "Модуль " + childCounter + ": " + child.getModuleName());
            childCounter++;

            if (!child.getChildren().isEmpty()) {
                printNestedModules(child, depth + 1);
            }
        }
    }
}