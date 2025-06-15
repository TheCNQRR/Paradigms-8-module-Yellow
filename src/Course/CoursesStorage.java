package Course;

import AlgorithmicTask.AlgorithmicTask;
import CourseModule.CourseModule;
import Topic.Topic;

import java.util.ArrayList;

import static ProgramSystem.Utils.readIntInput;

public class CoursesStorage {
    private static final ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Course> getCourses() { return new ArrayList<>(courses); }
    public static void addCourse(Course course) { courses.add(course); }
    public static void removeCourseAtIndex(int index) { courses.remove(index); }
    public static void removeCourseObject(Course course) { courses.remove(course); }
    public static void writeAllCourses() {
        //TODO в полной структуре предлагать выбор вывода просто курса или полной информации о каждом
        if (courses.isEmpty()) {
            System.out.println("Список классов пуст!");
        }
        else {
            System.out.println("Вывод информации о классах");
            System.out.println("1. Краткий (названия)");
            System.out.println("2. Полный (названия, темы, модули, секции)");
            System.out.print("Выберите опцию: ");

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    for (int i = 0; i < courses.size(); ++i) {
                        System.out.println("{");
                        System.out.println("Название класса " + (i + 1) + ": " + courses.get(i).getName());
                        System.out.println("}");
                    }
                    break;
                }
                case 2: {
                    for (int i = 0; i < courses.size(); ++i) {
                        System.out.println("{");
                        System.out.println("Название класса " + (i + 1) + ": " + courses.get(i).getName());
                        System.out.println("Список тем: ");
                        System.out.println("[");
                        for (int j = 0; j < courses.get(i).getTopicsNames().size(); ++j) {
                            System.out.println("Название темы " + (j + 1) + ": " + courses.get(i).getTopicsNames().get(j));
                        }
                        System.out.println("]");
                        System.out.println("Список модулей: ");
                        System.out.println("[");
                        for (int k = 0; k < courses.get(i).getTopics().size(); ++k) {
                            Topic topic = courses.get(i).getTopics().get(k);
                            if (topic instanceof CourseModule) {
                                CourseModule module = (CourseModule) topic;
                                System.out.println("Название модуля " + (k + 1) + ": " + module.getModuleName());
                            }
                        }
                        System.out.println("]");
                        //TODO секции
                        System.out.println("}");
                    }
                    break;
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }
}
