package Module;

import Course.Course;
import Topic.Topic;

import java.util.ArrayList;

public class Module extends Topic {
    private String moduleName;
    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public Module(String topicName, String moduleName, Course course) {
        super(course);
        this.name = topicName;
        this.moduleName = moduleName;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}
