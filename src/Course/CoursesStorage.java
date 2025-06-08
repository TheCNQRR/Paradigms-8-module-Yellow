package Course;

import java.util.ArrayList;

public class CoursesStorage {
    private static final ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Course> getCourses() { return courses; }
    public static void addCourse(Course course) { courses.add(course); }
    public static void removeCourseAtIndex(int index) { courses.remove(index); }
    public static void removeCourseObject(Course course) { courses.remove(course); }
}
