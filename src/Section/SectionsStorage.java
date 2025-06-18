package Section;

import Course.CoursesStorage;

import java.util.ArrayList;

public class SectionsStorage {
    private static final ArrayList<Section> sections = new ArrayList<>();
    public static ArrayList<Section> getSections() { return sections; }
    public static void addSection(Section section) { sections.add(section); }
    public static void removeSectionAtIndex(int index) { sections.remove(index); }
    public static void removeSectionObject(Section section) { sections.remove(section); }
    public static void writeAllSections() {
        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            CoursesStorage.getCourses().get(i).writeSectionsInCourse(CoursesStorage.getCourses().get(i));
        }
    }
}
