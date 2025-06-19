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
        if (SurveyStorage.getSurvey().isEmpty()) {
            System.out.println("Список опросов пуст!");
            return;
        }

        for (int i = 0; i < SurveyStorage.getSurvey().size(); ++i) {
            System.out.println("Опрос " + (i + 1) + ": " + SurveyStorage.getSurvey().get(i).getName());
        }

        System.out.print("Введите номер опроса, который вы хотите достать: ");
        int surveyNumber = readIntInput();

        if (surveyNumber < 1 || surveyNumber > SurveyStorage.getSurvey().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Survey survey = SurveyStorage.getSurvey().get(surveyNumber - 1);
        survey.writeSurvey();
    }

    public static void updateSurvey() {
        if (SurveyStorage.getSurvey().isEmpty()) {
            System.out.println("Список опросов пуст!");
            return;
        }

        for (int i = 0; i < SurveyStorage.getSurvey().size(); ++i) {
            System.out.println("Опрос " + (i + 1) + ": " + SurveyStorage.getSurvey().get(i).getName());
        }

        System.out.print("Введите номер опроса, который вы хотите обновить: ");
        int surveyNumber = readIntInput();

        if (surveyNumber < 1 || surveyNumber > SurveyStorage.getSurvey().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Survey survey = SurveyStorage.getSurvey().get(surveyNumber - 1);

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название опроса");
        System.out.println("2. Текст опроса");
        System.out.println("3. Пример");
        System.out.println("4. Список вопросов");
        System.out.println("5. Прикрепить задание к теме");
        System.out.println("6. Открепить задание от темы");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
        int option = readIntInput();

        Scanner scanner = new Scanner(System.in);


        switch (option) {
            case 1: {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();
                survey.setName(newName);
                SurveyStorage.replaceSurvey(surveyNumber - 1, survey);
                System.out.println("Опрос обновлён!");
                break;
            }
            case 2: {
                System.out.print("Введите новый текст задания: ");
                String newTaskText = scanner.nextLine();
                survey.setTaskText(newTaskText);
                SurveyStorage.replaceSurvey(surveyNumber - 1, survey);
                System.out.println("Опрос обновлён!");
                break;
            }
            case 3: {
                System.out.print("Введите новый пример: ");
                String newTaskExample = scanner.nextLine();
                survey.setTaskExample(newTaskExample);
                SurveyStorage.replaceSurvey(surveyNumber - 1, survey);
                System.out.println("Опрос обновлён!");
                break;
            }
            case 4: {
                System.out.println("Что вы хотите сделать?");
                System.out.println("1. Добавить вопрос");
                System.out.println("2. Удалить вопрос");
                System.out.print("Выберите опцию: ");
                int choiceForUpdate = readIntInput();

                switch (choiceForUpdate) {
                    case 1: {
                        CRUDQuestion.createQuestionInSurvey(survey);
                        break;
                    }
                    case 2: {
                        if (survey.getQuestions().isEmpty()) {
                            System.out.println("Список вопросов пуст!");
                            return;
                        }

                        survey.writeAllQuestions();
                        System.out.println("Введите номер вопроса, который вы хотите удалить");

                        int deletingQuestion = readIntInput();

                        if (deletingQuestion < 1 || deletingQuestion > survey.getQuestions().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        survey.removeQuestionAtIndex(deletingQuestion - 1);
                        System.out.println("Вопрос удалён!");
                        break;
                    }
                }
            }
            case 5: {
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
                if (module.getTasks().contains(survey)) {
                    System.out.println("Модуль уже содержит данный опрос, опрос не был прикреплён повторно");
                } else {
                    module.addTask(survey);
                    System.out.println("Опрос прикреплён!");
                }
                break;
            }
            case 6: {
                if (CoursesStorage.getCourses().isEmpty()) {
                    System.out.println("Список классов пуст, опроса никуда не прикреплён!");
                    return;
                }

                CoursesStorage.writeAllCourses();
                System.out.print("Выберите класс, от которого будет откреплён опрос: ");
                int courseNumber = readIntInput();

                if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Опрос не был откреплён!");
                    return;
                }

                Course course = CoursesStorage.getCourses().get(courseNumber - 1);
                if (course.getModules().isEmpty()) {
                    System.out.println("Список модулей пуст, опрос не был откреплён!");
                    return;
                }

                if (course.getCountModulesContainsTask(survey) == 0) {
                    System.out.println("Ни один модулем в этом класс не содержит данный опрос!");
                    return;
                }

                course.writeModulesContainsTask(survey);
                System.out.print("Выберите модуль, от которого будет откреплён опрос: ");
                int moduleNumber = readIntInput();

                if (moduleNumber < 1 || moduleNumber > course.getCountModulesContainsTask(survey)) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Опрос не был откреплён!");
                    return;
                }

                for (int i = 0; i < course.getModules().size(); ++i) {
                    int counter = 0;
                    if (course.getModules().get(i).getTasks().contains(survey)) {
                        counter++;
                        if (counter == moduleNumber) {
                            course.getModules().get(i).removeTaskObject(survey);
                            System.out.println("Опрос откреплён!");
                        }
                    }
                }
                break;
            }
            case 0: {
                return;
            }
            default: {
                System.out.println("Ошибка, вы ввели неверную команду!");
            }
        }
    }

    public static void deleteSurvey() {
        if (SurveyStorage.getSurvey().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        SurveyStorage.writeAllSurveyFull();

        System.out.print("Введите номер опроса, который вы хотите удалить: ");
        int choice = readIntInput();

        if (choice > SurveyStorage.getSurvey().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            for (int j = 0; j < CoursesStorage.getCourses().get(i).getModules().size(); ++j) {
                if (CoursesStorage.getCourses().get(i).getModules().get(j).getTasks().contains(SurveyStorage.getSurvey().get(choice - 1))) {
                    CoursesStorage.getCourses().get(i).getModules().get(j).removeTaskObject(SurveyStorage.getSurvey().get(choice - 1));
                }
            }
        }

        SurveyStorage.removeSurveyAtIndex(choice - 1);
        System.out.println("Опрос удалён!");
    }
}
