package Question;

import AlgorithmicTask.CRUDAlgorithmicTask;

import static ProgramSystem.Utils.readIntInput;

public class QuestionMenu {
    public static void questionsMenu() {
        while (true) {
            showQuestionsMenu();

            int choice = readIntInput();

            switch(choice) {
                case 1: {
                    CRUDQuestion.createQuestion();
                    break;
                }
                case 2: {
                    CRUDQuestion.retrieveQuestion();
                    break;
                }
                case 3: {
                    CRUDQuestion.updateQuestion();
                    break;
                }
                case 4: {
                    CRUDQuestion.deleteQuestion();
                    break;
                }
                case 5: {
                    QuestionsStorage.writeAllQuestions();
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

    public static void showQuestionsMenu() {
        System.out.println("\n===Управление вопросами===");
        System.out.println("1. Создать вопрос");
        System.out.println("2. Достать вопрос");
        System.out.println("3. Обновить вопрос");
        System.out.println("4. Удалить вопрос");
        System.out.println("5. Вывод всех вопросов");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
