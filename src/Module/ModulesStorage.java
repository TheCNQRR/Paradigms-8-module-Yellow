package Module;

import java.util.ArrayList;

public class ModulesStorage {
    private static final ArrayList<Module> modules = new ArrayList<>();
    public static ArrayList<Module> getModules() { return modules; }
    public static void addModule(Module module) { modules.add(module); }
    public static void removeModuleAtIndex(int index) { modules.remove(index); }
    public static void removeModuleObject(Module module) { modules.remove(module); }
}
