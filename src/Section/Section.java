package Section;

import Course.Course;
import CourseModule.CourseModule;
import Topic.Topic;

public class Section extends Topic {
    private String sectionName;
    public String getSectionName() { return sectionName; }
    public void setSectionName(String name) { this.sectionName = name; }

    public Section(String topicName, String moduleName, Course course) {
        super(course);
        this.name = topicName;
        this.sectionName = moduleName;
    }

    private Topic parent;
    public Topic getParent() { return parent; }
    public void setParent(Topic parent) { this.parent = parent; }
    public void removeParent() { parent = null; }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}