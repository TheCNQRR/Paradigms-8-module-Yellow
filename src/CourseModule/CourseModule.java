package CourseModule;

import Course.Course;
import Topic.Topic;

public class CourseModule extends Topic {
    private String moduleName;
    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public CourseModule(String topicName, String moduleName, Course course) {
        super(course);
        this.name = topicName;
        this.moduleName = moduleName;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}
