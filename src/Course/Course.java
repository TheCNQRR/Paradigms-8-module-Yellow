package Course;

import Section.Section;
import Task.Task;
import Topic.Topic;
import CourseModule.CourseModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class Course {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private final HashMap<String, Boolean> topicsVisibility = new HashMap<>();

    private ArrayList<Topic> topics = new ArrayList<>();
    public ArrayList<Topic> getTopics() { return new ArrayList<>(topics); }
    public void setTopics(ArrayList<Topic> topics) { this.topics = topics; }
    public void addTopic(Topic topic) { topics.add(topic); }
    public void removeTopicAtIndex(int index) { topics.remove(index); }
    public void removeTopicObject(Topic topic) { topics.remove(topic); }
    public void replaceTopic(int index, Topic topic) { topics.set(index, topic); }

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
                String status = isTopicVisible(topicsNames.get(i)) ? "" : " [Скрыта]";
                System.out.println("Тема " + (i + 1) + ": " + topicsNames.get(i) + status);
            }
        }
    }

    private final ArrayList<String> topicsNames = new ArrayList<>();
    public void addTopicName(String name) {
        topicsNames.add(name);
        topicsVisibility.put(name, true);
    }
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

    private final ArrayList<Section> sections = new ArrayList<>();
    public ArrayList<Section> getSections() { return new ArrayList<>(sections); }
    public void addSection(Section section) { sections.add(section); }
    public void replaceSection(int index, Section section) { sections.set(index, section); }
    public void writeSections(Course course) {
        for (int i = 0; i < course.sections.size(); ++i) {
            System.out.println("Секция " + (i + 1) + ": " + course.sections.get(i).getSectionName());
        }
    }

    public void setTopicVisibility(String topicName, boolean isVisible) {
        if (topicsVisibility.containsKey(topicName)) {
            topicsVisibility.put(topicName, isVisible);

            for (Topic item : topics) {
                if (item.getName().equals(topicName)) {
                    item.setVisibility(isVisible);

                    if (item instanceof CourseModule) {
                        ((CourseModule) item).setVisibilityRecursive(isVisible);
                    }
                }
            }
        }
    }

    public boolean isTopicVisible(String topicName) {
        return topicsVisibility.getOrDefault(topicName, true);
    }

    public Course(String name) { this.name = name; }

    public CourseModule createModule(String topicName, String name) {
        CourseModule module = new CourseModule(topicName, name, this);
        topics.add(module);
        return module;
    }

    public Section createSection(String topicName, String name) {
        Section section = new Section(topicName, name, this);
        topics.add(section);
        return section;
    }

    public void writeModulesInCourse(Course course) {
        if (course.topicsNames.isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }

        for (int i = 0; i < topicsNames.size(); ++i) {
            String topicName = topicsNames.get(i);
            boolean isTopicVisible = isTopicVisible(topicName);
            String topicStatus = isTopicVisible ? "" : " [Скрыта]";

            System.out.println("|-Тема " + (i + 1) + ": " + topicName + topicStatus);
            int moduleCounter = 1;

            for (Topic topic : topics) {
                if (topic instanceof CourseModule) {
                    CourseModule module = (CourseModule) topic;
                    if (module.getName().equals(topicName)) {
                        String moduleStatus = isTopicVisible ? "" : " [Скрыт]";
                        System.out.println("|--Модуль " + moduleCounter + ": " +
                                module.getModuleName() + moduleStatus);
                        moduleCounter++;

                        if (!module.getChildren().isEmpty()) {
                            printNestedModules(module, 3, isTopicVisible);
                        }
                    }
                }
            }
        }
    }

    public void printNestedModules(CourseModule parentModule, int depth, boolean isParentVisible) {
        int childCounter = 1;
        for (CourseModule child : parentModule.getChildren()) {
            String status = isParentVisible ? "" : " [Скрыт]";
            System.out.println("|" + "-".repeat(depth) + "Модуль " + childCounter + ": " +
                    child.getModuleName() + status);
            childCounter++;

            if (!child.getChildren().isEmpty()) {
                printNestedModules(child, depth + 1, isParentVisible);
            }
        }
    }

    public void writeSectionsInCourse(Course course) {
        if (course.topicsNames.isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }

        for (int i = 0; i < topicsNames.size(); ++i) {
            String topicName = topicsNames.get(i);
            boolean isTopicVisible = isTopicVisible(topicName);
            String topicStatus = isTopicVisible ? "" : " [Скрыта]";

            System.out.println("|-Тема " + (i + 1) + ": " + topicName + topicStatus);
            int sectionCounter = 1;

            for (Topic topic : topics) {
                if (topic instanceof Section) {
                    Section section = (Section) topic;
                    if (section.getName().equals(topicName)) {
                        String sectionStatus = isTopicVisible ? "" : " [Скрыта]";
                        System.out.println("|--Секция " + sectionCounter + ": " +
                                section.getSectionName() + sectionStatus);
                        sectionCounter++;
                    }
                }
            }
        }
    }

    public void writeModulesAndSectionsInCourse(Course course) {
        if (course.topicsNames.isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }


        for (int i = 0; i < topicsNames.size(); ++i) {
            String topicName = topicsNames.get(i);
            boolean isTopicVisible = isTopicVisible(topicName);
            String topicStatus = isTopicVisible ? "" : " [Скрыта]";

            System.out.println("|-Тема " + (i + 1) + ": " + topicName + topicStatus);

            int moduleCounter = 1;
            for (Topic topic : topics) {
                if (topic instanceof CourseModule) {
                    CourseModule module = (CourseModule) topic;
                    if (module.getName().equals(topicName)) {
                        String moduleStatus = isTopicVisible ? "" : " [Скрыт]";
                        System.out.println("|--Модуль " + moduleCounter + ": " +
                                module.getModuleName() + moduleStatus);
                        moduleCounter++;

                        if (!module.getChildren().isEmpty()) {
                            printNestedModules(module, 3, isTopicVisible);
                        }
                    }
                }
            }

            int sectionCounter = 1;
            for (Topic topic : topics) {
                if (topic instanceof Section) {
                    Section section = (Section) topic;
                    if (section.getName().equals(topicName)) {
                        String sectionStatus = isTopicVisible ? "" : " [Скрыта]";
                        System.out.println("|--Секция " + sectionCounter + ": " +
                                section.getSectionName() + sectionStatus);
                        sectionCounter++;
                    }
                }
            }
        }
    }

    public void writeModulesContainsTask(Task task) {
        int counter = 1;
        for (int i = 0; i < modules.size(); ++i) {
            CourseModule module = modules.get(i);
            if (module.getTasks().contains(task)) {
                System.out.println("Модуль " + counter + ": " + module.getModuleName());
                counter++;
            }
        }
    }

    public int getCountModulesContainsTask(Task task) {
        int counter = 0;
        for (int i = 0; i < modules.size(); ++i) {
            CourseModule module = modules.get(i);
            if (module.getTasks().contains(task)) {
                counter++;
            }
        }
        return counter;
    }
}