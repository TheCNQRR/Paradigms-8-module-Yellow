package ProgramSystem;

import java.util.Scanner;
import Course.CoursesMenu;
import ProgrammingLanguage.ProgrammingLanguagesMenu;
import AlgorithmicTask.AlgorithmicTasksMenu;
import CourseModule.ModulesMenu;

import static ProgramSystem.Utils.readIntInput;

public class Console {
    public static Scanner scanner = new Scanner(System.in);
    public static void mainMenu() {
        while (true) {
            MainScreen.showMainMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CoursesMenu.coursesMenu();
                    break;
                }
                case 3: {
                    ModulesMenu.modulesMenu();
                    break;
                }
                case 6: {
                    AlgorithmicTasksMenu.algorithmicTasksMenu();
                    break;
                }
                case 11: {
                    ProgrammingLanguagesMenu.programmingLanguagesMenu();
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }
}
