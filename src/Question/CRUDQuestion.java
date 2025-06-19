package Question;

import Survey.Survey;
import Survey.SurveyStorage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDQuestion {
    public static void createQuestion() {
        Scanner scanner = new Scanner(System.in);
        if (SurveyStorage.getSurvey().isEmpty()) {
            System.out.println("Список опросов пуст, сперва создайте опрос!");
            return;
        }

        SurveyStorage.writeAllSurveyFull();
        System.out.print("Введите номер опроса, в котором будет создан вопрос: ");
        int surveyNumber = readIntInput();

        if (surveyNumber < 1 || surveyNumber > SurveyStorage.getSurvey().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Survey survey = SurveyStorage.getSurvey().get(surveyNumber - 1);

        String name;
        System.out.print("Введите название вопроса: ");
        name = scanner.nextLine();

        System.out.print("Добавьте содержание вопроса: ");
        String content = scanner.nextLine();

        System.out.println("Выберите тип вопроса: ");
        System.out.println("1. Выбор одного из двух");
        System.out.println("2. Выбор одного из нескольких");
        System.out.println("3. Свободный ответ");
        System.out.print("Выберите опцию: ");
        int type = readIntInput();

        if (type != 1 && type != 2 && type != 3) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        QuestionType questionType;

        switch (type) {
            case 1: {
                questionType = QuestionType.ONE_OF_THE_TWO;
                Question question = new Question(survey, name, questionType);
                question.setContent(content);

                System.out.print("Введите первый ответ: ");
                String firstAnswer = scanner.nextLine();
                System.out.print("Введите второй ответ ответ: ");
                String secondAnswer = scanner.nextLine();

                question.addAnswer(firstAnswer);
                question.addAnswer(secondAnswer);

                QuestionsStorage.addQuestion(question);
                System.out.println("Вопрос создан!");
                break;
            }
            case 2: {
                questionType = QuestionType.ONE_OF_SEVERAL;

                System.out.print("Введите количество ответов на вопрос: ");
                int questionsCount = readIntInput();

                if (questionsCount < 1) {
                    System.out.println("Ошибка, число ответов не может быть меньше 1!");
                    return;
                }

                Question question = new Question(survey, name, questionType);
                question.setContent(content);

                for (int i = 0; i < questionsCount; ++i) {
                    System.out.print("Введите ответ " + (i + 1) + ": ");
                    String answer = scanner.nextLine();
                    question.addAnswer(answer);
                }
                System.out.println("Ответы добавлены!");

                QuestionsStorage.addQuestion(question);
                System.out.println("Вопрос создан!");
                break;
            }
            case 3: {
                questionType = QuestionType.FREE_RESPONSE;
                Question question = new Question(survey, name, questionType);
                question.setContent(content);
                System.out.print("Введите ответ на вопрос: ");
                String answer = scanner.nextLine();
                question.addAnswer(answer);
                QuestionsStorage.addQuestion(question);
                System.out.println("Вопрос создан!");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
    }

    public static void retrieveQuestion() {
        if (QuestionsStorage.getQuestions().isEmpty()) {
            System.out.println("Список вопросов пуст!");
            return;
        }

        for (int i = 0; i < QuestionsStorage.getQuestions().size(); ++i) {
            System.out.println("Вопрос " + (i + 1) + ": "+ QuestionsStorage.getQuestions().get(i).getName());
        }

        System.out.print("Введите номер вопроса, который вы хотите достать: ");
        int questionNumber = readIntInput();

        if (questionNumber < 1 || questionNumber > QuestionsStorage.getQuestions().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Question question = QuestionsStorage.getQuestions().get(questionNumber - 1);
        System.out.println("Информация о вопросе:");
        question.writeQuestion();
    }

    public static void updateQuestion() {
        Scanner scanner = new Scanner(System.in);
        if (QuestionsStorage.getQuestions().isEmpty()) {
            System.out.println("Список вопросов пуст!");
            return;
        }

        for (int i = 0; i < QuestionsStorage.getQuestions().size(); ++i) {
            System.out.println("Вопрос " + (i + 1) + ": "+ QuestionsStorage.getQuestions().get(i).getName());
        }

        System.out.print("Введите номер вопроса, который вы хотите обновить: ");
        int questionNumber = readIntInput();

        if (questionNumber < 1 || questionNumber > QuestionsStorage.getQuestions().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        Question question = QuestionsStorage.getQuestions().get(questionNumber - 1);

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название вопроса");
        System.out.println("2. Содержание вопроса");
        System.out.println("3. Список ответов на вопрос");
        System.out.println("4. Тип вопроса");
        System.out.print("Выберите опцию: ");
        int updatingOption = readIntInput();

        switch (updatingOption) {
            case 1: {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();
                question.setName(newName);
                System.out.println("Название обновлено!");
                break;
            }
            case 2: {
                System.out.print("Введите новое содержание: ");
                String newContent = scanner.nextLine();
                question.setName(newContent);
                System.out.println("Содержание обновлено!");
                break;
            }
            case 3: {
                System.out.println("Ответы на вопрос: ");
                for (int j = 0; j < question.getAnswers().size(); ++j) {
                    System.out.println(question.getAnswers().get(j));
                }

                System.out.print("Введите номер ответа, который хотите обновить: ");
                int updatingAnswer = readIntInput();

                if (updatingAnswer < 1 || updatingAnswer > question.getAnswers().size()) {
                    System.out.println("Ошибка, вы ввели неверный номер!");
                    return;
                }

                System.out.print("Введите новый ответ на вопрос: ");
                String newAnswer = scanner.nextLine();

                question.replaceAnswer(updatingAnswer - 1, newAnswer);
                System.out.println("Ответ изменён!");
                System.out.println("Вопрос обновлён!");
                break;
            }
            case 4: {
                System.out.println("Выберите новый тип вопроса");
                System.out.println("1. Выбор одного из двух");
                System.out.println("2. Выбор одного из нескольких");
                System.out.println("3. Свободный ответ");
                System.out.print("Выберите опцию: ");
                int choiceForType = readIntInput();

                switch (choiceForType) {
                    case 1: {
                        QuestionType newType = QuestionType.ONE_OF_THE_TWO;
                        if (newType == question.getQuestionType()) {
                            System.out.println("Вопрос уже имеет данный тип!");
                            System.out.println("Вопрос не был обновлён");
                            return;
                        }
                        question.setQuestionType(newType);

                        System.out.print("Введите первый ответ: ");
                        String firstAnswer = scanner.nextLine();
                        System.out.print("Введите второй ответ ответ: ");
                        String secondAnswer = scanner.nextLine();

                        question.clearAnswers();
                        question.addAnswer(firstAnswer);
                        question.addAnswer(secondAnswer);

                        System.out.println("Вопрос обновлён!");
                        break;
                    }
                    case 2: {
                        QuestionType newType = QuestionType.ONE_OF_SEVERAL;
                        if (newType == question.getQuestionType()) {
                            System.out.println("Вопрос уже имеет данный тип!");
                            System.out.println("Вопрос не был обновлён");
                            return;
                        }

                        System.out.print("Введите количество ответов на вопрос: ");
                        int questionsCount = readIntInput();

                        if (questionsCount < 1) {
                            System.out.println("Ошибка, число ответов не может быть меньше 1!");
                            System.out.println("Вопрос не был обновлён");
                            return;
                        }

                        question.clearAnswers();

                        for (int i = 0; i < questionsCount; ++i) {
                            System.out.print("Введите ответ " + (i + 1) + ": ");
                            String answer = scanner.nextLine();
                            question.addAnswer(answer);
                        }
                        System.out.println("Ответы добавлены!");
                        System.out.println("Вопрос обновлён!");
                        break;
                    }
                    case 3: {
                        QuestionType newType = QuestionType.FREE_RESPONSE;
                        if (newType == question.getQuestionType()) {
                            System.out.println("Вопрос уже имеет данный тип!");
                            System.out.println("Вопрос не был обновлён");
                            return;
                        }

                        question.clearAnswers();

                        System.out.print("Введите ответ на вопрос: ");
                        String answer = scanner.nextLine();
                        question.addAnswer(answer);
                        System.out.println("Ответы добавлены!");
                        System.out.println("Вопрос обновлён!");
                        break;
                    }
                    default: {
                        System.out.println("Ошибка, неверная команда!");
                    }
                }
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
    }

    public static void deleteQuestion() {
        if (QuestionsStorage.getQuestions().isEmpty()) {
            System.out.println("Список вопросов пуст!");
            return;
        }

        for (int i = 0; i < QuestionsStorage.getQuestions().size(); ++i) {
            System.out.println("Вопрос " + (i + 1) + ": " + QuestionsStorage.getQuestions().get(i).getName());
        }

        System.out.print("Введите номер вопроса, который вы хотите удалить: ");
        int questionNumber = readIntInput();

        if (questionNumber < 1 || questionNumber > QuestionsStorage.getQuestions().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        for (int i = 0; i < SurveyStorage.getSurvey().size(); ++i) {
            if (SurveyStorage.getSurvey().get(i).getQuestions().contains(QuestionsStorage.getQuestions().get(questionNumber - 1))) {
                SurveyStorage.getSurvey().get(i).removeQuestion(QuestionsStorage.getQuestions().get(questionNumber - 1));
            }
        }

        QuestionsStorage.removeQuestionAtIndex(questionNumber - 1);
        System.out.println("Вопрос удалён!");
    }

    public static void createQuestionInSurvey(Survey survey) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.print("Введите название вопроса: ");
        name = scanner.nextLine();

        System.out.print("Добавьте содержание вопроса: ");
        String content = scanner.nextLine();

        System.out.println("Выберите тип вопроса: ");
        System.out.println("1. Выбор одного из двух");
        System.out.println("2. Выбор одного из нескольких");
        System.out.println("3. Свободный ответ");
        System.out.print("Выберите опцию: ");
        int type = readIntInput();

        if (type != 1 && type != 2 && type != 3) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        QuestionType questionType;

        switch (type) {
            case 1: {
                questionType = QuestionType.ONE_OF_THE_TWO;
                Question question = new Question(survey, name, questionType);
                question.setContent(content);

                System.out.print("Введите первый ответ: ");
                String firstAnswer = scanner.nextLine();
                System.out.print("Введите второй ответ ответ: ");
                String secondAnswer = scanner.nextLine();

                question.addAnswer(firstAnswer);
                question.addAnswer(secondAnswer);

                QuestionsStorage.addQuestion(question);
                System.out.println("Вопрос создан!");
                break;
            }
            case 2: {
                questionType = QuestionType.ONE_OF_SEVERAL;

                System.out.print("Введите количество ответов на вопрос: ");
                int questionsCount = readIntInput();

                if (questionsCount < 1) {
                    System.out.println("Ошибка, число ответов не может быть меньше 1!");
                    return;
                }

                Question question = new Question(survey, name, questionType);
                question.setContent(content);

                for (int i = 0; i < questionsCount; ++i) {
                    System.out.print("Введите ответ " + (i + 1) + ": ");
                    String answer = scanner.nextLine();
                    question.addAnswer(answer);
                }
                System.out.println("Ответы добавлены!");

                QuestionsStorage.addQuestion(question);
                System.out.println("Вопрос создан!");
                break;
            }
            case 3: {
                questionType = QuestionType.FREE_RESPONSE;
                Question question = new Question(survey, name, questionType);
                question.setContent(content);
                System.out.print("Введите ответ на вопрос: ");
                String answer = scanner.nextLine();
                question.addAnswer(answer);
                QuestionsStorage.addQuestion(question);
                System.out.println("Вопрос добавлен к опросу!");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
    }
}
