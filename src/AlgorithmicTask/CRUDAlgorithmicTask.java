package AlgorithmicTask;

import ProgrammingLanguage.ProgrammingLanguage;
import ProgrammingLanguage.CRUDProgrammingLanguage;
import Task.TasksStorage;
import TaskWithRepository.TasksWithRepositoryStorage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

//TODO нет привязки языка программирования

public class CRUDAlgorithmicTask {
    public static void createAlgorithmicTask() {
        Scanner scanner = new Scanner(System.in);

        AlgorithmicTask algorithmicTask = new AlgorithmicTask();

        System.out.print("Введите название задания по алгоритмике: ");
        String name = scanner.nextLine();
        algorithmicTask.setName(name);

        System.out.print("Введите текст задания: ");
        String taskText = scanner.nextLine();
        algorithmicTask.setTaskText(taskText);

        System.out.print("Введите пример: ");
        String taskExample = scanner.nextLine();
        algorithmicTask.setTaskExample(taskExample);

        System.out.println("Хотите добавить язык программирования к заданию?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.print("Выберите опцию: ");
        int choice = readIntInput();

        switch (choice) {
            case 1: {
                if (ProgrammingLanguage.getLanguages().isEmpty()) {
                    System.out.println("Список языков пуст, сперва создайте язык!");
                    return;
                }
                else {
                    ProgrammingLanguage.writeAllLanguages();
                    System.out.print("Введите номер языка, который вы хотите добавить: ");
                    int languageNumber = readIntInput();

                    if (languageNumber < 1 || languageNumber > ProgrammingLanguage.getLanguages().size()) {
                        System.out.println("Ошибка, вы ввели неверный номер!");
                        return;
                    }
                    else {
                        algorithmicTask.addProgrammingLanguage(ProgrammingLanguage.getLanguages().get(languageNumber - 1));
                        System.out.println("Язык программирования добавлен!");
                    }
                }
            }
            case 2: {
                System.out.println("Добавление языка пропущено. Вы можете добавить язык позднее!");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }

        AlgorithmicTasksStorage.addAlgorithmicTask(algorithmicTask);
        TasksStorage.addTask(algorithmicTask);
        System.out.println("Задание по алгоритмике добавлено!");
    }

    public static void retrieveAlgorithmicTask() {
        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        AlgorithmicTasksStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите достать: ");
        int choice = readIntInput();

        if (choice > AlgorithmicTasksStorage.getAlgorithmicTasks().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        AlgorithmicTasksStorage.getAlgorithmicTasks().get(choice - 1).writeAlgorithmicTask();
    }

    public static void updateAlgorithmicTask() {
        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        AlgorithmicTasksStorage.writeAllTasks();
        System.out.print("Введите номер задания, которое хотите обновить: ");
        int choice = readIntInput();

        if (choice > AlgorithmicTasksStorage.getAlgorithmicTasks().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название задания");
        System.out.println("2. Текст задания");
        System.out.println("3. Пример");
        System.out.println("4. Языки программирования");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");

        int option = readIntInput();

        Scanner scanner = new Scanner(System.in);

        AlgorithmicTask newAlgorithmicTask = AlgorithmicTasksStorage.getAlgorithmicTasks().get(choice - 1);
        //TODO интеграция в родительский класс
        switch (option) {
            case 1: {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();
                newAlgorithmicTask.setName(newName);
                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                System.out.println("Задание обновлено!");
                break;
            }
            case 2: {
                System.out.print("Введите новый текст задания: ");
                String newTaskText = scanner.nextLine();
                newAlgorithmicTask.setTaskText(newTaskText);
                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                System.out.println("Задание обновлено!");
                break;
            }
            case 3: {
                System.out.print("Введите новый пример: ");
                String newTaskExample = scanner.nextLine();
                newAlgorithmicTask.setTaskExample(newTaskExample);
                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                System.out.println("Задание обновлено!");
                break;
            }
            case 4: {
                System.out.println("Что вы хотите сделать?");
                System.out.println("1. Добавить язык");
                System.out.println("2. Удалить язык");
                System.out.print("Выберите опцию: ");
                int choiceForUpdate = readIntInput();

                switch (choiceForUpdate) {
                    case 1: {
                        System.out.println("Как вы хотите добавить язык?");
                        System.out.println("1. Создать новый");
                        System.out.println("2. Выбрать из списка существующих");
                        System.out.print("Выберите опцию: ");

                        int choiceForCreate = readIntInput();

                        switch (choiceForCreate) {
                            case 1: {
                                CRUDProgrammingLanguage.createProgrammingLanguage();
                                newAlgorithmicTask.addProgrammingLanguage(ProgrammingLanguage.getLanguages().getLast());
                                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                                System.out.println("Язык программирования добавлен!");
                                break;
                            }
                            case 2: {
                                if (ProgrammingLanguage.getLanguages().isEmpty()) {
                                    System.out.println("Список языков по программированию пуст!");
                                    return;
                                }

                                ProgrammingLanguage.writeAllLanguages();
                                System.out.print("Введите номер языка, который вы хотите добавить: ");

                                int programmingLanguageNumber = readIntInput();

                                if (programmingLanguageNumber < 1 || programmingLanguageNumber > ProgrammingLanguage.getLanguages().size()) {
                                    System.out.println("Ошибка, вы ввели неверный номер!");
                                    return;
                                }
                                else {
                                    newAlgorithmicTask.addProgrammingLanguage(ProgrammingLanguage.getLanguages().get(programmingLanguageNumber - 1));
                                    AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                                    System.out.println("Язык программирования добавлен!");
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        if (newAlgorithmicTask.getProgrammingLanguage().isEmpty()) {
                            System.out.println("Список языков по программированию пуст, сперва создайте язык!");
                            return;
                        }

                        newAlgorithmicTask.writeLanguagesInTask();
                        System.out.print("Введите номер языка, который вы хотите удалить: ");
                        int choiceForDeleteLanguage = readIntInput();

                        if (choiceForDeleteLanguage < 1 || choiceForDeleteLanguage > newAlgorithmicTask.getProgrammingLanguage().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }
                        else {
                            newAlgorithmicTask.removeProgrammingLanguageAtIndex(choiceForDeleteLanguage - 1);
                            AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                            System.out.println("Язык программирования удалён!");
                        }
                        break;
                    }
                }
            }
            case 0: {
                return;
            }
            default: {
                System.out.println("Ошибка, вы ввели неверную команду!");
            }
        }
    }

    public static void deleteAlgorithmicTask() {
        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        AlgorithmicTasksStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите удалить: ");
        int choice = readIntInput();

        if (choice > AlgorithmicTasksStorage.getAlgorithmicTasks().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        AlgorithmicTasksStorage.removeAlgorithmicTaskAtIndex(choice - 1);
        System.out.println("Задание удалено!");
    }
}
