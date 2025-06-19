package Solution;

import Course.Course;
import Course.CoursesStorage;
import CourseModule.CourseModule;
import Topic.Topic;

import java.util.ArrayList;

import static ProgramSystem.Utils.readIntInput;

public class SolutionsStorage {
    private static final ArrayList<Solution> solutions = new ArrayList<>();
    public static ArrayList<Solution> getSolution() { return solutions; }
    public static void addSolution(Solution solution) { solutions.add(solution); }
    public static void removeSolutionAtIndex(int index) { solutions.remove(index); }
    public static void removeSolutionObject(Solution solution) { solutions.remove(solution); }

    public static void writeAllSolutions() {
        if (solutions.isEmpty()) {
            System.out.println("Список решений пуст");
        }
        else {
            for (int i = 0; i < solutions.size(); ++i) {
                System.out.println("Решение " + (i + 1) + ": " + solutions.get(i).getName());
            }
        }
    }

    public static void writeAllSolutionsFull() {
        if (solutions.isEmpty()) {
            System.out.println("Список решений пуст");
        }
        else {
            for (int i = 0; i < solutions.size(); ++i) {
                Solution solution = solutions.get(i);
                System.out.println("Решение " + (i + 1) + ": " + solution.getName());
                System.out.println("Текст решения: " + solution.getSolutionText());
                if (solution.getTask().isEmpty()) {
                    System.out.println("Список заданий, к которым прикреплено решение пуст");
                } else {
                    System.out.println("Список заданий, к которым прикреплено решение:");
                    System.out.println("{");
                    for (int j = 0; j < solution.getTask().size(); ++j) {
                        System.out.println("Задание " + (j + 1) + ": " + solution.getTask().get(j).getName());
                    }
                    System.out.println("}");
                }
            }
        }
    }

    public static void writeSolutionsInNestedModules() {
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, в котором вы хотите вывести решения: ");
        int courseNumber = readIntInput();

        if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Course course = CoursesStorage.getCourses().get(courseNumber - 1);

        if (course.getTopicsNames().isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }

        for (int i = 0; i < course.getTopicsNames().size(); ++i) {
            String topicName = course.getTopicsNames().get(i);

            System.out.println("|-Тема " + (i + 1) + ": " + topicName);
            int moduleCounter = 1;

            for (Topic topic : course.getTopics()) {
                if (topic instanceof CourseModule) {
                    CourseModule module = (CourseModule) topic;
                    if (module.getName().equals(topicName)) {
                        int counter = 1;
                        System.out.println("|--Модуль " + moduleCounter + ": " + module.getModuleName());
                        for (int j = 0; j < module.getTasks().size(); ++j) {
                            for (int k = 0; k < solutions.size(); ++k) {
                                for (int l = 0; l < solutions.get(k).getTask().size(); ++l) {
                                    if (module.getTasks().get(j) == solutions.get(k).getTask().get(l)) {
                                        System.out.println("|---Решение " + counter + ": " + solutions.get(k).getName());
                                        counter++;
                                    }
                                }
                            }
                        }
                        moduleCounter++;

                        if (!module.getChildren().isEmpty()) {
                            printNestedModules(module, 3);
                        }
                    }
                }
            }
        }
    }

    public static void printNestedModules(CourseModule parentModule, int depth) {
        int childCounter = 1;
        for (CourseModule child : parentModule.getChildren()) {
            int counter = 1;
            System.out.println("|" + "-".repeat(depth) + "Модуль " + childCounter + ": " + child.getModuleName());
            for (int j = 0; j < child.getTasks().size(); ++j) {
                for (int k = 0; k < solutions.size(); ++k) {
                    for (int l = 0; l < solutions.get(k).getTask().size(); ++l) {
                        if (child.getTasks().get(j) == solutions.get(k).getTask().get(l)) {
                            System.out.println("|" + "-".repeat(depth + 1) + "Решение " + counter + ": " + solutions.get(k).getName());
                            counter++;
                        }
                    }
                }
            }
            childCounter++;

            if (!child.getChildren().isEmpty()) {
                printNestedModules(child, depth + 1);
            }
        }
    }

    public static void writeSolutionsInVisibleModules() {
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, в котором вы хотите вывести решения: ");
        int courseNumber = readIntInput();

        if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Course course = CoursesStorage.getCourses().get(courseNumber - 1);

        if (course.getTopicsNames().isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }

        int topicCounter = 1;
        for (int i = 0; i < course.getTopicsNames().size(); ++i) {
            String topicName = course.getTopicsNames().get(i);
            boolean isTopicVisible = course.isTopicVisible(topicName);

            if (isTopicVisible) {
                System.out.println("|-Тема " + topicCounter + ": " + topicName);
                topicCounter++;
                int moduleCounter = 1;

                for (Topic topic : course.getTopics()) {
                    if (topic instanceof CourseModule) {
                        CourseModule module = (CourseModule) topic;
                        if (module.getName().equals(topicName)) {
                            int counter = 1;
                            System.out.println("|--Модуль " + moduleCounter + ": " + module.getModuleName());
                            for (int j = 0; j < module.getTasks().size(); ++j) {
                                for (int k = 0; k < solutions.size(); ++k) {
                                    for (int l = 0; l < solutions.get(k).getTask().size(); ++l) {
                                        if (module.getTasks().get(j) == solutions.get(k).getTask().get(l)) {
                                            System.out.println("|---Решение " + counter + ": " + solutions.get(k).getName());
                                            counter++;
                                        }
                                    }
                                }
                            }
                            moduleCounter++;

                            if (!module.getChildren().isEmpty()) {
                                printNestedModulesWithVisibility(module, 3);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printNestedModulesWithVisibility(CourseModule parentModule, int depth) {
        int childCounter = 1;
        for (CourseModule child : parentModule.getChildren()) {
            int counter = 1;
            System.out.println("|" + "-".repeat(depth) + "Модуль " + childCounter + ": " + child.getModuleName());
            for (int j = 0; j < child.getTasks().size(); ++j) {
                for (int k = 0; k < solutions.size(); ++k) {
                    for (int l = 0; l < solutions.get(k).getTask().size(); ++l) {
                        if (child.getTasks().get(j) == solutions.get(k).getTask().get(l)) {
                            System.out.println("|" + "-".repeat(depth + 1) + "Решение " + counter + ": " + solutions.get(k).getName());
                            counter++;
                        }
                    }
                }
            }
            childCounter++;

            if (!child.getChildren().isEmpty()) {
                printNestedModules(child, depth + 1);
            }
        }
    }
}
