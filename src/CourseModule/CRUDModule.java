package CourseModule;

import Course.Course;

import java.util.Scanner;

public class CRUDModule {
    public static void createModule(String topicName, Course course) {
        Scanner scanner = new Scanner(System.in);

        String moduleName;
        System.out.print("Введите название модуля: ");
        moduleName = scanner.nextLine();
        CourseModule module = new CourseModule(topicName, moduleName, course);
        course.addTopic(module);

        ModulesStorage.addModule(module);
        System.out.println("Модуль добавлен!");
    }
}
