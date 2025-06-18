package Section;

import Course.Course;
import Course.CoursesStorage;
import CourseModule.CRUDModule;
import CourseModule.CourseModule;
import Topic.Topic;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDSection {
    public static void createSection() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание секции");
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса внутри которого будет создана секция: ");
        int courseNumber = readIntInput();

        if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(courseNumber - 1);
            if (course.getTopicsNames().isEmpty()) {
                System.out.println("Список тем пуст, сперва создайте тему!");
                return;
            }

            course.writeTopics();
            System.out.print("Введите номер темы, внутри которой будет создана секция: ");
            int topicNumber = readIntInput();
            if (topicNumber < 1 || topicNumber > course.getTopics().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
                return;
            }
            else {
                CRUDSection.createSectionInCourse(course.getTopics().get(topicNumber - 1).getName(), course);
            }
        }
    }

    public static void retrieveSection() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        int sectionsNumber = 0;
        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            for (int j = 0; j < CoursesStorage.getCourses().get(i).getSections().size(); ++j) {
                System.out.println("Секция " + (sectionsNumber + 1) + ": " + CoursesStorage.getCourses().get(i).getSections().get(j).getSectionName());
                sectionsNumber++;
            }
        }

        if (sectionsNumber == 0) {
            System.out.println("Список секций пуст!");
            return;
        }

        System.out.print("Введите номер секции, которую хотите достать: ");
        int retrieveSection = readIntInput();

        if (retrieveSection < 1 || retrieveSection > sectionsNumber) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            int temp = 0;
            for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
                for (int j = 0; j < CoursesStorage.getCourses().get(i).getSections().size(); ++j) {
                    temp++;
                    if (retrieveSection == temp) {
                        System.out.println("Информация о секции: ");
                        System.out.println("Родительская тема: " + CoursesStorage.getCourses().get(i).getSections().get(j).getName());
                        System.out.println("Название секции: " + CoursesStorage.getCourses().get(i).getSections().get(j).getSectionName());
                        break;
                    }
                }
            }
        }
    }

    public static void updateSection() {
        Scanner scanner = new Scanner(System.in);
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, в котором вы хотите изменить модуль: ");
        int updatingCourse = readIntInput();

        if (updatingCourse < 1 || updatingCourse > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(updatingCourse - 1);
            if (course.getSections().isEmpty()) {
                System.out.println("Список секций пуст!");
                return;
            }

            course.writeSections(course);
            System.out.print("Введите номер секции, которую вы хотите редактировать: ");
            int updatingSection = readIntInput();
            if (updatingSection < 1 || updatingSection > course.getSections().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
            }
            else {
                System.out.print("Введите новое название секции: ");
                String newName = scanner.nextLine();
                Section section = course.getSections().get(updatingSection - 1);

                Section originalSection = section;
                originalSection.setSectionName(newName);
                course.replaceSection(updatingSection - 1, originalSection);

                for (int i = 0; i < course.getTopics().size(); ++i) {
                    Topic topic = course.getTopics().get(i);
                    if (topic instanceof Section) {
                        Section temp = (Section) topic;
                        if (temp == originalSection) {
                            temp.setSectionName(newName);
                            course.replaceTopic(i, temp);
                        }
                    }
                }
                System.out.println("Название секции изменено!");
            }
        }
    }

    public static void deleteSection() {
        Scanner scanner = new Scanner(System.in);
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, в котором вы хотите удалить секцию: ");
        int updatingCourse = readIntInput();

        if (updatingCourse < 1 || updatingCourse > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(updatingCourse - 1);
            if (course.getSections().isEmpty()) {
                System.out.println("Список секций пуст!");
                return;
            }

            course.writeSections(course);
            System.out.print("Введите номер секции, которую хотите удалить: ");
            int deletingSection = readIntInput();
            if (deletingSection < 1 || deletingSection > course.getModules().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
            }
            else {
                Section section = course.getSections().get(deletingSection - 1);
                for (int i = 0; i < course.getTopics().size(); ++i) {
                    Topic topic = course.getTopics().get(i);
                    if (topic instanceof Section) {
                        Section tempModule = (Section) topic;
                        if (tempModule == section) {
                            course.removeTopicAtIndex(i);
                            break;
                        }
                    }
                }
                course.removeModuleAtIndex(deletingSection - 1);
                System.out.println("Секция удалена!");
            }
        }
    }

    public static void createSectionInCourse(String topicName, Course course) {
        Scanner scanner = new Scanner(System.in);

        String sectionName;
        System.out.print("Введите название секции: ");
        sectionName = scanner.nextLine();
        Section section = new Section(topicName, sectionName, course);
        section.setParent(section);
        course.addTopic(section);
        course.addSection(section);

        SectionsStorage.addSection(section);
        System.out.println("Секция добавлена!");
    }
}
