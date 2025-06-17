package CourseModule;

import java.util.ArrayList;
import Course.CoursesStorage;

public class ModulesStorage {
    private static final ArrayList<CourseModule> modules = new ArrayList<>();
    public static ArrayList<CourseModule> getModules() { return modules; }
    public static void addModule(CourseModule module) { modules.add(module); }
    public static void removeModuleAtIndex(int index) { modules.remove(index); }
    public static void removeModuleObject(CourseModule module) { modules.remove(module); }
    public static void writeAllModules() {
        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            CoursesStorage.getCourses().get(i).writeModulesInCourse(CoursesStorage.getCourses().get(i));
        }
    }
}
