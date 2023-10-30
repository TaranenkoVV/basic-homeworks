package ru.taranenko.homeworks.homework10;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        int mode;
        boolean isWorking;

        title();

        isWorking = true;
        while (isWorking) {
            mode = getMode();
            if (mode == 1) {
                workWithUser();

            } else if (mode == 2) {
                workWithBox();

            } else if (mode == 0) {
                isWorking = false;
            }
        }
    }

    /**
     * Заголовок ДЗ
     */
    private static void title() {
        System.out.println();
        System.out.println("HomeWork10 к уроку Lesson10");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    /**
     * Вариант ДЗ
     */
    public static int getMode() {
        Scanner scanner = new Scanner(System.in);
        int mode = -1;
        System.out.println();
        System.out.println("Вариант ДЗ:");
        System.out.println("1. Работа с классом User");
        System.out.println("2. Работа с классом Box");
        System.out.println("0. Выход");
        System.out.println();

        while (mode < 0 || mode > 2) {
            System.out.print("Введите номер варианта от 1 до 2 (0 для выхода): ");
            mode = scanner.nextInt();
        }
        return mode;
    }

    /**
     * Работа с классом Box
     */
    private static void workWithBox() {
        Box box = new Box("Серый", 30, 20);

        int task;
        boolean isWorking;

        isWorking = true;
        while (isWorking) {
            task = box.getOperationWithBox();

            switch (task) {
                // выход
                case 0:
                    isWorking = false;
                    break;

                // Открыть коробку
                case 1:
                    box.openBox();
                    break;

                // Закрыть коробку
                case 2:
                    box.closeBox();
                    break;

                // Положить в коробку предмет
                case 3:
                    box.putObjectInBox();
                    break;

                // Выкинуть из коробки предмет
                case 4:
                    box.popObjectFromBox();
                    break;

                // Перекрасить коробку
                case 5:
                    box.setNewColorBox();
                    break;

                // Вывод информации о коробке
                case 6:
                    box.printBoxInfo();
                    break;

                default:
                    System.out.println("Неизвестное действие: " + task);
                    break;
            }
        }
    }

    /**
     * Работа с классом User
     */
    private static void workWithUser() {
        User[] user = new User[10];
        fillUserArray(user);
        printUser(user);
    }

    /**
     * Заполнение массива с пользователями
     *
     * @param user
     */
    private static void fillUserArray(User[] user) {
        user[0] = new User("Иванов", "Иван", "Иванович", 1950, "ivanov@mail.ru");
        user[1] = new User("Петров", "Петр", "Петрович", 1960, "petrov@mail.ru");
        user[2] = new User("Сидорова", "Ольга", "Валерьевна", 1990, "sidorova@mail.ru");
        user[3] = new User("Абдулов", "Александр", "Иванович", 2000, "aai@mail.ru");
        user[4] = new User("Лисин", "Дмитрий", "Павлович", 2010, "ivanov@mail.ru");
        user[5] = new User("Тараненко", "Вячеслав", "Владимирович", 1975, "tvvsample@mail.ru");
        user[6] = new User("Козырева", "Зоя", "Михайловна", 1970, "koz@mail.ru");
        user[7] = new User("Лукиных", "Данил", "Викторович", 1980, "dan@mail.ru");
        user[8] = new User("Жижин", "Алексей", "Иванович", 1995, "ivanov@mail.ru");
        user[9] = new User("Крутова", "Нина", "Ивановна", 2005, "ivanov@mail.ru");

    }

    /**
     * Вывод информации в консоль о пользователях старше 40 лет
     *
     * @param user
     */
    private static void printUser(User[] user) {
        int currentYear = 2023;
        System.out.println();
        System.out.println("Список пользователей старше 40 лет:");
        for (int i = 0; i < user.length; i++) {
            if ((user[i] != null) && (currentYear - user[i].getBirthYear()) > 40) {
                System.out.println();
                System.out.println("Элемент массива: " + i);
                user[i].printUserInfo();
            }
        }
    }

}
