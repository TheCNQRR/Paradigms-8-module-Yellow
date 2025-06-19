package TaskWithRepository;

import AlgorithmicTask.AlgorithmicTask;
import Course.Course;
import Course.CoursesStorage;
import CourseModule.CourseModule;
import Task.TasksStorage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDTaskWithRepository {
    public static void createTaskWithRepository() {
        Scanner scanner = new Scanner(System.in);

        TaskWithRepository taskWithRepository = new TaskWithRepository();

        System.out.print("Введите название задания с репозиторием: ");
        String name = scanner.nextLine();
        taskWithRepository.setName(name);

        System.out.print("Введите ссылку на репозиторий: ");
        String reference = scanner.nextLine();
        taskWithRepository.setRepositoryReference(reference);

        System.out.print("Введите текст задания: ");
        String taskText = scanner.nextLine();
        taskWithRepository.setTaskText(taskText);

        System.out.print("Введите пример: ");
        String taskExample = scanner.nextLine();
        taskWithRepository.setTaskExample(taskExample);

        System.out.println("Прикрепить задание к теме?");
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
                System.out.print("Выберите класс, к которому будет прикреплено задание: ");
                int courseNumber = readIntInput();

                if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Задание не было прикреплено!");
                    return;
                }

                Course course = CoursesStorage.getCourses().get(courseNumber - 1);
                if (course.getModules().isEmpty()) {
                    System.out.println("Список модулей пуст, сперва создайте модуль в классе!");
                    return;
                }

                course.writeModules(course);
                System.out.print("Выберите модуль, к которому будет прикреплено задание: ");
                int moduleNumber = readIntInput();

                if (moduleNumber < 1 || moduleNumber > course.getModules().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Задание не было прикреплено!");
                    return;
                }

                CourseModule module = course.getModules().get(moduleNumber - 1);
                module.addTask(taskWithRepository);
                System.out.println("Задание прикреплено!");
                break;
            }
            case 2: {
                System.out.println("Задание не прикреплено к теме. Вы можете прикрепить его позднее");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }

        TasksWithRepositoryStorage.addTaskWithRepository(taskWithRepository);
        TasksStorage.addTask(taskWithRepository);
        System.out.println("Задание с репозиторием добавлено!");
    }

    public static void retrieveTaskWithRepository() {
        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
            return;
        }

        TasksWithRepositoryStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите достать: ");
        int choice = readIntInput();

        if (choice < 1 || choice > TasksWithRepositoryStorage.getTasksWithRepository().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        TasksWithRepositoryStorage.getTasksWithRepository().get(choice - 1).writeTaskWithRepository();
    }

    public static void updateTaskWithRepository() {
        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
            return;
        }

        TasksWithRepositoryStorage.writeAllTasks();
        System.out.print("Введите номер задания, которое хотите обновить: ");
        int choice = readIntInput();

        if (choice > TasksWithRepositoryStorage.getTasksWithRepository().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название задания");
        System.out.println("2. Ссылку на репозиторий");
        System.out.println("3. Текст задания");
        System.out.println("4. Пример");
        System.out.println("5. Прикрепить задание к теме");
        System.out.println("6. Открепить задание от темы");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");

        int option = readIntInput();

        Scanner scanner = new Scanner(System.in);

        TaskWithRepository newTaskWithRepository = TasksWithRepositoryStorage.getTasksWithRepository().get(choice - 1);
        switch (option) {
            case 1: {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();
                newTaskWithRepository.setName(newName);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 2: {
                System.out.print("Введите новую ссылку на репозиторий: ");
                String newReference = scanner.nextLine();
                newTaskWithRepository.setName(newReference);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 3: {
                System.out.print("Введите новый текст задания: ");
                String newTaskText = scanner.nextLine();
                newTaskWithRepository.setTaskText(newTaskText);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 4: {
                System.out.print("Введите новый пример: ");
                String newTaskExample = scanner.nextLine();
                newTaskWithRepository.setTaskExample(newTaskExample);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 5: {
                if (CoursesStorage.getCourses().isEmpty()) {
                    System.out.println("Список классов пуст, сперва создайте класс!");
                    return;
                }

                CoursesStorage.writeAllCourses();
                System.out.print("Выберите класс, к которому будет прикреплено задание: ");
                int courseNumber = readIntInput();

                if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Задание не было прикреплено!");
                    return;
                }

                Course course = CoursesStorage.getCourses().get(courseNumber - 1);
                if (course.getModules().isEmpty()) {
                    System.out.println("Список модулей пуст, сперва создайте модуль в классе!");
                    return;
                }

                course.writeModules(course);
                System.out.print("Выберите модуль, к которому будет прикреплено задание");
                int moduleNumber = readIntInput();

                if (moduleNumber < 1 || moduleNumber > course.getModules().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Задание не было прикреплено!");
                    return;
                }

                CourseModule module = course.getModules().get(moduleNumber - 1);
                if (module.getTasks().contains(newTaskWithRepository)) {
                    System.out.println("Модуль уже содержит данное задание, задание не было прикреплено повторно");
                }
                else {
                    module.addTask(newTaskWithRepository);
                    System.out.println("Задание прикреплено!");
                }
                break;
            }
            case 6: {
                if (CoursesStorage.getCourses().isEmpty()) {
                    System.out.println("Список классов пуст, задание никуда не прикреплено!");
                    return;
                }

                CoursesStorage.writeAllCourses();
                System.out.print("Выберите класс, от которого будет откреплено задание: ");
                int courseNumber = readIntInput();

                if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Задание не было откреплено!");
                    return;
                }

                Course course = CoursesStorage.getCourses().get(courseNumber - 1);
                if (course.getModules().isEmpty()) {
                    System.out.println("Список модулей пуст, задание не было откреплено!");
                    return;
                }

                if (course.getCountModulesContainsTask(newTaskWithRepository) == 0) {
                    System.out.println("Ни один модулем в этом класс не содержит данное задание!");
                    return;
                }

                course.writeModulesContainsTask(newTaskWithRepository);
                System.out.print("Выберите модуль, от которого будет откреплено задание: ");
                int moduleNumber = readIntInput();

                if (moduleNumber < 1 || moduleNumber > course.getCountModulesContainsTask(newTaskWithRepository)) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    System.out.println("Задание не было откреплено!");
                    return;
                }

                for (int i = 0; i < course.getModules().size(); ++i) {
                    int counter = 0;
                    if (course.getModules().get(i).getTasks().contains(newTaskWithRepository)) {
                        counter++;
                        if (counter == moduleNumber)  {
                            course.getModules().get(i).removeTaskObject(newTaskWithRepository);
                            System.out.println("Задание откреплено!");
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

    public static void deleteTaskWithRepository() {
        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
            return;
        }

        TasksWithRepositoryStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите удалить: ");
        int choice = readIntInput();

        if (choice > TasksWithRepositoryStorage.getTasksWithRepository().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            for (int j = 0; j < CoursesStorage.getCourses().get(i).getModules().size(); ++j) {
                if (CoursesStorage.getCourses().get(i).getModules().get(j).getTasks().contains(TasksWithRepositoryStorage.getTasksWithRepository().get(choice - 1))) {
                    CoursesStorage.getCourses().get(i).getModules().get(j).removeTaskObject(TasksWithRepositoryStorage.getTasksWithRepository().get(choice - 1));
                }
            }
        }

        TasksWithRepositoryStorage.removeTaskWithRepositoryAtIndex(choice - 1);
        System.out.println("Задание удалено!");
    }
}
