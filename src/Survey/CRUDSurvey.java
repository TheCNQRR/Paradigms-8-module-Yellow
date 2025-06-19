package Survey;

import Course.Course;
import Course.CoursesStorage;
import CourseModule.CourseModule;
import Question.CRUDQuestion;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDSurvey {
    public static void createSurvey() {
        Scanner scanner = new Scanner(System.in);

        Survey survey = new Survey();

        System.out.print("Введите название опроса: ");
        String name = scanner.nextLine();
        survey.setName(name);

        System.out.print("Введите текст задания: ");
        String taskText = scanner.nextLine();
        survey.setTaskText(taskText);

        System.out.print("Введите пример: ");
        String taskExample = scanner.nextLine();
        survey.setTaskExample(taskExample);

        System.out.println("Хотите добавить вопрос к опросу?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.print("Выберите опцию: ");
        int choice = readIntInput();

        switch (choice) {
            case 1: {
                CRUDQuestion.createQuestionInSurvey(survey);
                break;
            }
            case 2: {
                System.out.println("Добавление вопроса пропущено. Вы можете добавить вопрос позднее!");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }

        System.out.println("Прикрепить опрос к теме?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.print("Выберите опцию: ");
        int choiceForConnect = readIntInput();
        boolean isSet = false;

        while (!isSet) {
            if (choiceForConnect != 1 && choiceForConnect != 2) {
                System.out.print("Ошибка, вы ввели неверный номер! Повторите попытку: ");
                choiceForConnect = readIntInput();
            }
            else {
                isSet = true;
            }
        }

        switch (choiceForConnect) {
            case 1: {
                if (CoursesStorage.getCourses().isEmpty()) {
                    System.out.println("Список классов пуст, сперва создайте класс!");
                    return;
                }

                CoursesStorage.writeAllCourses();
                System.out.print("Выберите класс, к которому будет прикреплён опрос: ");
                int courseNumber = readIntInput();

                if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Опрос не был прикреплён!");
                    return;
                }

                Course course = CoursesStorage.getCourses().get(courseNumber - 1);
                if (course.getModules().isEmpty()) {
                    System.out.println("Список модулей пуст, сперва создайте модуль в классе!");
                    return;
                }

                course.writeModules(course);
                System.out.print("Выберите модуль, к которому будет прикреплён опрос: ");
                int moduleNumber = readIntInput();

                if (moduleNumber < 1 || moduleNumber > course.getModules().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Опрос не был прикреплён!");
                    return;
                }

                CourseModule module = course.getModules().get(moduleNumber - 1);
                module.addTask(survey);
                System.out.println("Опрос прикреплён!");
                break;
            }
            case 2: {
                System.out.println("Опрос не прикреплён к теме. Вы можете прикрепить его позднее");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }

        SurveyStorage.addSurvey(survey);
        System.out.println("Опрос создан!");
    }

    public static void retrieveSurvey() {

    }

    public static void updateSurvey() {

    }

    public static void deleteSurvey() {

    }
}
