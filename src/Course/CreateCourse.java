package Course;

import java.util.Scanner;

public class CreateCourse {
    public static void createCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название класса: ");
        String name = scanner.nextLine();

        Course course = new Course(name);

        CoursesStorage.addCourse(course);
        System.out.println("Класс добавлен!");
    }
}
