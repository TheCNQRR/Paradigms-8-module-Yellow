package Section;

import Course.Course;
import Topic.Topic;

public class Section extends Topic {
    public Section(String name, Course course) {
        super(course);
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}