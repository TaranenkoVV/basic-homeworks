package ru.taranenko.homeworks.homework10;

import java.util.Scanner;

public class Box {

    private String color;
    private final int width;
    private final int height;
    private boolean isOpened;
    private String someObject;
    private static final String EMPTY_BOX = "<пусто>";
    private static final String OBJECT_IN_BOX = "<Объект>";

    /**
     * Перекрасить коробку
     */
    public void setNewColor(String color) {
        this.color = color;
        System.out.print("Коробку перекрасили в новый цвет: " + this.color);
        System.out.println();
    }

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
     * Открыть коробку
     */
    public void open() {
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
    public void close() {
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
    public void putObject() {
        if (!isOpened) {
            System.out.println("Не могу положить Объект в коробку, коробка закрыта!");
        } else if (!someObject.equals(EMPTY_BOX)) {
            System.out.println("Не могу положить Объект в коробку, в коробка уже лежит предмет!");
        } else {
            someObject = OBJECT_IN_BOX;
            System.out.println("Объект положили в коробку.");
        }
    }

    /**
     * Выкинуть объект из коробки
     */
    public void popObject() {
        if (!isOpened) {
            System.out.println("Не могу выкинуть Объект из коробки, коробка закрыта!");
        } else if (someObject.equals(EMPTY_BOX)) {
            System.out.println("Не могу выкинуть Объект из коробки, коробка пустая!");
        } else {
            someObject = EMPTY_BOX;
            System.out.println("Объект выкинули из коробки.");
        }
    }

    /**
     * Вывод информации о коробке в консоль.
     */
    public void printInfo() {
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

        System.out.println("Наличие предмета в коробке: " + someObject);
    }
}
