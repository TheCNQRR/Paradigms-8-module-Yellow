package Section;

import java.util.ArrayList;

public class SectionsStorage {
    private static final ArrayList<Section> sections = new ArrayList<>();
    public static ArrayList<Section> getSections() { return sections; }
    public static void addSections(Section section) { sections.add(section); }
    public static void removeSectionAtIndex(int index) { sections.remove(index); }
    public static void removeSectionObject(Section section) { sections.remove(section); }
}
