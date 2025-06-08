package ProgrammingLanguage;

import java.util.ArrayList;

public class ProgrammingLanguage {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private static final ArrayList<String> languages = new ArrayList<>();
    public ArrayList<String> getLanguages() { return new ArrayList<>(languages); }
    public static void addLanguage(String language) { languages.add(language); }
    public static void removeLanguageAtIndex(int index) { languages.remove(index); }
    public static void removeLanguageObject(String language) { languages.remove(language); }

    static {
        initializeDefaultLanguages();
    }

    private static void initializeDefaultLanguages() {
        languages.add("C++");
        languages.add("C#");
        languages.add("Java");
        languages.add("Python");
    }
}