package ProgramSystem;

import java.util.Scanner;
import Course.CoursesMenu;
import ProgrammingLanguage.ProgrammingLanguagesMenu;
import AlgorithmicTask.AlgorithmicTasksMenu;
import CourseModule.ModulesMenu;
import Question.QuestionMenu;
import Section.SectionMenu;
import Topic.TopicMenu;
import TaskWithRepository.TaskWithRepositoryMenu;
import Survey.SurveyMenu;
import Solution.SolutionMenu;

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
                case 2: {
                    TopicMenu.topicMenu();
                    break;
                }
                case 3: {
                    ModulesMenu.modulesMenu();
                    break;
                }
                case 4: {
                    SectionMenu.sectionsMenu();
                    break;
                }
                case 5: {
                    AlgorithmicTasksMenu.algorithmicTasksMenu();
                    break;
                }
                case 6: {
                    TaskWithRepositoryMenu.tasksWithRepositoryMenu();
                    break;
                }
                case 7: {
                    SolutionMenu.solutionsMenu();
                    break;
                }
                case 8: {
                    SurveyMenu.surveyMenu();
                    break;
                }
                case 9: {
                    QuestionMenu.questionsMenu();
                    break;
                }
                case 10: {
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
