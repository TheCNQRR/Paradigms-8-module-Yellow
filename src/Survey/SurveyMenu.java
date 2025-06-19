package Survey;

import static ProgramSystem.Utils.readIntInput;

public class SurveyMenu {
    public static void surveyMenu() {
        while (true) {
            showSurveyMenu();

            int choice = readIntInput();

            switch(choice) {
                case 1: {
                    CRUDSurvey.createSurvey();
                    break;
                }
                case 2: {
                    CRUDSurvey.retrieveSurvey();
                    break;
                }
                case 3: {
                    CRUDSurvey.updateSurvey();
                    break;
                }
                case 4: {
                    CRUDSurvey.deleteSurvey();
                    break;
                }
                case 5: {
                    SurveyStorage.writeAllSurvey();
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
    }

    public static void showSurveyMenu() {
        System.out.println("\n===Управление опросами===");
        System.out.println("1. Создать опрос");
        System.out.println("2. Достать опрос");
        System.out.println("3. Обновить опрос");
        System.out.println("4. Удалить опрос");
        System.out.println("5. Вывод всех опросов");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
