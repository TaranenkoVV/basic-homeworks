package ru.taranenko.homeworks.homework10;

import java.util.Scanner;

public class BoxDemoApplication {
    private final static Scanner scanner = new Scanner(System.in);
    private Box box;

    public BoxDemoApplication(){
        box = new Box("Серый", 30, 20);
    }

    /**
     * Работа с классом Box
     */
    public void workWithBox() {

        int task;
        boolean isWorking;

        isWorking = true;
        while (isWorking) {
            task = getOperationWithBox();

            switch (task) {
                // выход
                case 0:
                    isWorking = false;
                    break;

                // Открыть коробку
                case 1:
                    box.open();
                    break;

                // Закрыть коробку
                case 2:
                    box.close();
                    break;

                // Положить в коробку предмет
                case 3:
                    box.putObject();
                    break;

                // Выкинуть из коробки предмет
                case 4:
                    box.popObject();
                    break;

                // Перекрасить коробку
                case 5:
                    String newColor;
                    System.out.print("Введите новый цвет коробки: ");
                    newColor = scanner.nextLine();

                    box.setNewColor(newColor);
                    break;

                // Вывод информации о коробке
                case 6:
                    box.printInfo();
                    break;

                default:
                    System.out.println("Неизвестное действие: " + task);
                    break;
            }
        }
    }

    /**
     * Список действий с коробкой
     * @return
     */
    private static int getOperationWithBox() {
        Scanner scanner = new Scanner(System.in);
        int operation = -1;
        System.out.println();
        System.out.println("Выполните действие с коробкой:");
        System.out.println("1. Открыть коробку");
        System.out.println("2. Закрыть коробку");
        System.out.println("3. Положить в коробку предмет");
        System.out.println("4. Выкинуть из коробки предмет");
        System.out.println("5. Перекрасить коробку");
        System.out.println("6. Вывод информации о коробке");
        System.out.println("0. Выход");
        System.out.println();

        while (operation < 0 || operation > 6) {
            System.out.print("Введите номер действия от 1 до 6 (0 для выхода): ");
            operation = scanner.nextInt();
        }
        return operation;
    }

}
