package ProgrammingLanguage;

import java.util.ArrayList;

public class ProgrammingLanguage {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private static ArrayList<String> languages = new ArrayList<>();
    public ArrayList<String> getLanguages() { return new ArrayList<>(languages); }
    public void setLanguages(ArrayList<String> languages) { this.languages = languages; }
    public void addLanguage(String language) { languages.add(language); }
    public void removeLanguageAtIndex(int index) { languages.remove(index); }
    public void removeLanguageObject(String language) { languages.remove(language); }

    static {
        initializeDefaultLanguages();
    }

    // Статический метод для добавления 4 языков
    private static void initializeDefaultLanguages() {
        languages.add("C++");
        languages.add("C#");
        languages.add("Java");
        languages.add("Python");
    }

}