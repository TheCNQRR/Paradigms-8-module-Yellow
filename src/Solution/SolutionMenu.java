package Solution;

import static ProgramSystem.Utils.readIntInput;

public class SolutionMenu {
    public static void solutionsMenu() {
        while (true) {
            showSolutionsMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CRUDSolution.createSolution();
                    break;
                }
                case 2: {
                    CRUDSolution.retrieveSolution();
                    break;
                }
                case 3: {
                    CRUDSolution.updateSolution();
                    break;
                }
                case 4: {
                    CRUDSolution.deleteSolution();
                    break;
                }
                case 5: {
                    SolutionsStorage.writeAllSolutionsFull();
                    break;
                }
                case 6: {
                    SolutionsStorage.writeSolutionsInNestedModules();
                    break;
                }
                case 7: {
                    SolutionsStorage.writeSolutionsInVisibleModules();
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

    public static void showSolutionsMenu() {
        System.out.println("\n===Управление решениями===");
        System.out.println("1. Создать решение");
        System.out.println("2. Достать решение");
        System.out.println("3. Обновить решение");
        System.out.println("4. Удалить решение");
        System.out.println("5. Вывод всех решений");
        System.out.println("6. Вывод решений по заданиям в конкретных темах, включая вложенные");
        System.out.println("7. Вывод решений по заданиям в конкретных темах, которые могут видеть студенты");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
