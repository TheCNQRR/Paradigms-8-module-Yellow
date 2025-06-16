package CourseModule;

import Course.Course;
import Topic.Topic;

import java.util.ArrayList;

public class CourseModule extends Topic {
    private String moduleName;
    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public CourseModule(String topicName, String moduleName, Course course) {
        super(course);
        this.name = topicName;
        this.moduleName = moduleName;
    }

    private CourseModule parent;
    public CourseModule getParent() { return parent; }
    public void setParent(CourseModule parent) { this.parent = parent; }
    public void removeParent() { parent = null; }
    public void removeAllChildren() { children.clear(); }
    public void removeChildrenObject(CourseModule module) { children.remove(module); }

    private final ArrayList<CourseModule> children = new ArrayList<>();
    public ArrayList<CourseModule> getChildren() { return new ArrayList<>(children); }
    public void addChildren(CourseModule children) { this.children.add(children); }
    public void removeChildrenAtIndex(int index) { children.remove(index); }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}
