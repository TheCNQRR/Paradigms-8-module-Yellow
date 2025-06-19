package Solution;

import AlgorithmicTask.AlgorithmicTask;
import AlgorithmicTask.AlgorithmicTasksStorage;
import Survey.Survey;
import Survey.SurveyStorage;
import TaskWithRepository.TaskWithRepository;
import TaskWithRepository.TasksWithRepositoryStorage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDSolution {
    public static void createSolution() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название решения: ");
        String name = scanner.nextLine();

        System.out.print("Введите текст решения: ");
        String solutionText = scanner.nextLine();

        Solution solution = new Solution();
        solution.setName(name);
        solution.setSolutionText(solutionText);

        System.out.println("Прикрепить решение к заданию?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.print("Выберите опцию: ");
        int connectingOption = readIntInput();

        switch (connectingOption) {
            case 1: {
                System.out.println("Куда вы хотите прикрепить решение?");
                System.out.println("1. К заданию по алгоритмике");
                System.out.println("2. К заданию с репозиторием");
                System.out.println("3. К опросу");
                System.out.print("Выбери опцию: ");
                int choice = readIntInput();

                switch (choice) {
                    case 1: {
                        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
                            System.out.println("Список заданий по алгоритмике пуст!");
                            return;
                        }

                        AlgorithmicTasksStorage.writeAllTasks();
                        System.out.print("Введите номер задания, к которому вы хотите прикрепить решение: ");
                        int taskNumber = readIntInput();
                        if (taskNumber < 1 || taskNumber > AlgorithmicTasksStorage.getAlgorithmicTasks().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        AlgorithmicTask task = AlgorithmicTasksStorage.getAlgorithmicTasks().get(taskNumber - 1);

                        solution.addTask(task);
                        System.out.println("Решение прикреплено!");
                        break;
                    }
                    case 2: {
                        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
                            System.out.println("Список заданий с репозиторием пуст!");
                            return;
                        }

                        TasksWithRepositoryStorage.writeAllTasks();
                        System.out.print("Введите номер задания, к которому вы хотите прикрепить решение: ");
                        int taskNumber = readIntInput();
                        if (taskNumber < 1 || taskNumber > TasksWithRepositoryStorage.getTasksWithRepository().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        TaskWithRepository task = TasksWithRepositoryStorage.getTasksWithRepository().get(taskNumber - 1);
                        solution.addTask(task);
                        System.out.println("Решение прикреплено!");
                        break;
                    }
                    case 3: {
                        if (SurveyStorage.getSurvey().isEmpty()) {
                            System.out.println("Список опросов пуст!");
                            return;
                        }

                        SurveyStorage.writeAllSurvey();
                        System.out.print("Введите номер опроса, к которому вы хотите прикрепить решение: ");
                        int surveyNumber = readIntInput();
                        if (surveyNumber < 1 || surveyNumber > SurveyStorage.getSurvey().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        Survey survey = SurveyStorage.getSurvey().get(surveyNumber - 1);
                        solution.addTask(survey);
                        System.out.println("Решение прикреплено!");
                        break;
                    }
                    default: {
                        System.out.println("Ошибка, неверная команда!");
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Решение не прикреплено. Вы можете прикрепить его позднее");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }

        SolutionsStorage.addSolution(solution);
        System.out.println("Решение добавлено!");
    }

    public static void retrieveSolution() {
        if (SolutionsStorage.getSolution().isEmpty()) {
            System.out.println("Список решений пуст!");
            return;
        }

        SolutionsStorage.writeAllSolutions();
        System.out.print("Введите номер решения, которое вы хотите достать: ");
        int solutionNumber = readIntInput();

        if (solutionNumber < 1 || solutionNumber > SolutionsStorage.getSolution().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Solution solution = SolutionsStorage.getSolution().get(solutionNumber - 1);
        solution.writeSolution();
    }

    public static void updateSolution() {
        Scanner scanner = new Scanner(System.in);
        if (SolutionsStorage.getSolution().isEmpty()) {
            System.out.println("Список решений пуст!");
            return;
        }

        SolutionsStorage.writeAllSolutions();
        System.out.print("Введите номер решения, которое вы хотите обновить: ");
        int solutionNumber = readIntInput();

        if (solutionNumber < 1 || solutionNumber > SolutionsStorage.getSolution().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Solution solution = SolutionsStorage.getSolution().get(solutionNumber - 1);

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название решения");
        System.out.println("2. Текст решения");
        System.out.println("3. Прикрепить решение к заданию");
        System.out.println("4. Открепить решение от задания");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
        int choice = readIntInput();

        switch (choice) {
            case 1: {
                System.out.println("Введите новое название");
                String newName = scanner.nextLine();
                solution.setName(newName);
                System.out.println("Название изменено!");
                break;
            }
            case 2: {
                System.out.println("Введите новый текст решения");
                String newSolutionText = scanner.nextLine();
                solution.setSolutionText(newSolutionText);
                System.out.println("Текст решения изменён!");
                break;
            }
            case 3: {
                System.out.println("Куда вы хотите прикрепить решение?");
                System.out.println("1. К заданию по алгоритмике");
                System.out.println("2. К заданию с репозиторием");
                System.out.println("3. К опросу");
                System.out.print("Выбери опцию: ");
                int choiceForConnect = readIntInput();

                switch (choiceForConnect) {
                    case 1: {
                        AlgorithmicTasksStorage.writeAllTasks();
                        System.out.println("Введите номер задания, к которому вы хотите прикрепить решение");
                        int taskNumber = readIntInput();
                        if (taskNumber < 1 || taskNumber > AlgorithmicTasksStorage.getAlgorithmicTasks().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        AlgorithmicTask task = AlgorithmicTasksStorage.getAlgorithmicTasks().get(taskNumber - 1);

                        solution.addTask(task);
                        System.out.println("Решение прикреплено!");
                        break;
                    }
                    case 2: {
                        TasksWithRepositoryStorage.writeAllTasks();
                        System.out.println("Введите номер задания, к которому вы хотите прикрепить решение");
                        int taskNumber = readIntInput();
                        if (taskNumber < 1 || taskNumber > TasksWithRepositoryStorage.getTasksWithRepository().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        TaskWithRepository task = TasksWithRepositoryStorage.getTasksWithRepository().get(taskNumber - 1);
                        solution.addTask(task);
                        System.out.println("Решение прикреплено!");
                        break;
                    }
                    case 3: {
                        SurveyStorage.writeAllSurvey();
                        System.out.println("Введите номер опроса, к которому вы хотите прикрепить решение");
                        int surveyNumber = readIntInput();
                        if (surveyNumber < 1 || surveyNumber > SurveyStorage.getSurvey().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                            return;
                        }

                        Survey survey = SurveyStorage.getSurvey().get(surveyNumber - 1);
                        solution.addTask(survey);
                        System.out.println("Решение прикреплено!");
                        break;
                    }
                    default: {
                        System.out.println("Ошибка, неверная команда!");
                    }
                }
                break;
            }
            case 4: {
                solution.writeTasks();
                System.out.print("Введите номер решения, от которого вы хотите открепить задание: ");
                int taskNumber = readIntInput();

                if (taskNumber < 1 || taskNumber > solution.getTask().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    return;
                }

                solution.removeTask(taskNumber - 1);
                System.out.println("Решение откреплено от задания!");
                break;
            }
            case 0: {
                return;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
    }

    public static void deleteSolution() {
        if (SolutionsStorage.getSolution().isEmpty()) {
            System.out.println("Список решений пуст!");
            return;
        }

        SolutionsStorage.writeAllSolutions();
        System.out.print("Введите номер решения, которое вы хотите удалить: ");
        int solutionNumber = readIntInput();

        if (solutionNumber < 1 || solutionNumber > SolutionsStorage.getSolution().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        SolutionsStorage.removeSolutionAtIndex(solutionNumber - 1);
        System.out.println("Решение удалено!");
    }
}
