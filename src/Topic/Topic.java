package Topic;

import Course.Course;

public abstract class Topic {
    protected String name;
    public abstract String getName();
    public abstract void setName(String name);

    protected Course course;
    public Course getCourse() { return course; }


    public Topic(Course course) {
        if (course == null) { throw new IllegalArgumentException("Topic.Topic must belong to a course"); }
        this.course = course;
        this.visibility = true;
    }

    private boolean visibility;
    public boolean isVisible() { return visibility; }
    public void setVisibility(boolean visibility) { this.visibility = visibility; }
}
