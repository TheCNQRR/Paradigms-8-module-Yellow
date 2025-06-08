package ProgrammingLanguage;

import java.util.ArrayList;

public class ProgrammingLanguage {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public static void writeLanguage(ProgrammingLanguage language) { System.out.println("Язык с названием \"" + language.getName() + "\""); }

    public ProgrammingLanguage(String name) { this.name = name; }

    private static final ArrayList<ProgrammingLanguage> languages = new ArrayList<>();
    public static ArrayList<ProgrammingLanguage> getLanguages() { return new ArrayList<>(languages); }
    public static void addLanguage(ProgrammingLanguage language) { languages.add(language); }
    public static void removeLanguageAtIndex(int index) { languages.remove(index); }
    public static void removeLanguageObject(ProgrammingLanguage language) { languages.remove(language); }
    public static void replaceLanguage(int index, ProgrammingLanguage language) { languages.set(index, language); }
    public static void writeAllLanguages() {
        if (languages.isEmpty()) {
            System.out.println("Список языков пуст!");
        }
        else {
            for (int i = 0; i < languages.size(); ++i) {
                System.out.println("Язык " + (i + 1) + ": " + languages.get(i).getName());
            }
        }
    }

    static {
        initializeDefaultLanguages();
    }

    private static void initializeDefaultLanguages() {
        ProgrammingLanguage temp1 = new ProgrammingLanguage("C++");
        languages.add(temp1);
        ProgrammingLanguage temp2 = new ProgrammingLanguage("C#");
        languages.add(temp2);
        ProgrammingLanguage temp3 = new ProgrammingLanguage("Java");
        languages.add(temp3);
        ProgrammingLanguage temp4 = new ProgrammingLanguage("Python");
        languages.add(temp4);
    }
}