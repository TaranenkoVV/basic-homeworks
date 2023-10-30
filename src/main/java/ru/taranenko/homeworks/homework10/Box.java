package ru.taranenko.homeworks.homework10;

import java.util.Scanner;

public class Box {

    private Scanner scanner = new Scanner(System.in);
    private String color;
    private int width;
    private int height;
    private boolean isOpened;
    private String someObject;
    private static final String EMPTY_BOX = "<пусто>";
    private static final String OBJECT_IN_BOX = "<Объект>";

    /**
     * Конструктор
     * @param color
     * @param width
     * @param height
     */
    public Box(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.someObject = EMPTY_BOX;
    }

    /**
     * Список действий с коробкой
     * @return
     */
    public static int getOperationWithBox() {
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

    /**
     * Открыть коробку
     */
    public void openBox() {
        if (isOpened) {
            System.out.println("Коробка уже открыта!");
        } else {
            this.isOpened = true;
            System.out.println("Коробка открыта.");
        }
    }

    /**
     * Закрыть коробку
     */
    public void closeBox() {
        if (!isOpened) {
            System.out.println("Коробка уже закрыта!");
        } else {
            this.isOpened = false;
            System.out.println("Коробка закрыта.");
        }
    }

    /**
     * Положить объект в коробку
     */
    public void putObjectInBox() {
        if (!isOpened) {
            System.out.println("Не могу положить Объект в коробку, коробка закрыта!");
        } else if (someObject != EMPTY_BOX) {
            System.out.println("Не могу положить Объект в коробку, в коробка уже лежит предмет!");
        } else {
            someObject = OBJECT_IN_BOX;
            System.out.println("Объект положили в коробку.");
        }
    }

    /**
     * Выкинуть объект из коробки
     */
    public void popObjectFromBox() {
        if (!isOpened) {
            System.out.println("Не могу выкинуть Объект из коробки, коробка закрыта!");
        } else if (someObject == EMPTY_BOX) {
            System.out.println("Не могу выкинуть Объект из коробки, коробка пустая!");
        } else {
            someObject = EMPTY_BOX;
            System.out.println("Объект выкинули из коробки.");
        }
    }

    /**
     * Перекрасить коробку
     */
    public void setNewColorBox() {
        String newColor;
        System.out.print("Введите новый цвет коробки: ");
        newColor = scanner.nextLine();
        this.color = newColor;
        System.out.print("Коробку перекрасили в новый цвет: " + this.color);
        System.out.println();
    }

    /**
     * Вывод информации о коробке в консоль.
     */
    public void printBoxInfo() {
        System.out.println("Информация о коробке:");
        System.out.println("Цвет  : " + color);
        System.out.println("Ширина: " + width);
        System.out.println("Высота: " + height);

        System.out.print("Состояние коробки: ");
        if (isOpened) {
            System.out.println("открыта.");
        } else {
            System.out.println("закрыта.");
        }

        System.out.println("Наличие предмета: " + someObject);
    }
}
