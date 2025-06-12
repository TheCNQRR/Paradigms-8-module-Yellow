package Course;

import AlgorithmicTask.AlgorithmicTask;

import java.util.ArrayList;

public class CoursesStorage {
    private static final ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Course> getCourses() { return new ArrayList<>(courses); }
    public static void addCourse(Course course) { courses.add(course); }
    public static void removeCourseAtIndex(int index) { courses.remove(index); }
    public static void removeCourseObject(Course course) { courses.remove(course); }
    public static void writeAllCourses() {
        //TODO в полной структуре предлагать выбор вывода просто курса или полной информации о каждом
        if (courses.isEmpty()) {
            System.out.println("Список курсов пуст!");
        }
        else {
            for (int i = 0; i < courses.size(); ++i) {
                System.out.println("{");
                System.out.println("Название курса " + (i + 1) + ": " + courses.get(i).getName());
                System.out.println("}");
            }
        }
    }
}
