package ru.taranenko.homeworks.homework10;

import java.util.Scanner;

public class Box {

    private String color;
    private int width;
    private int height;
    private boolean isOpened;
    private String someObject;
    private static final String EMPTY_BOX = "<пусто>";
    private static final String OBJECT_IN_BOX = "<Объект>";
    private boolean isEmpty;

    /**
     * Перекрасить коробку
     */
    public void setNewColorBox(String color) {
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
        //} else if (!isEmpty) {
        } else if (!someObject.equals(EMPTY_BOX)) {
            System.out.println("Не могу положить Объект в коробку, в коробка уже лежит предмет!");
        } else {
            someObject = OBJECT_IN_BOX;
            isEmpty = false;
            System.out.println("Объект положили в коробку.");
        }
    }

    /**
     * Выкинуть объект из коробки
     */
    public void popObjectFromBox() {
        if (!isOpened) {
            System.out.println("Не могу выкинуть Объект из коробки, коробка закрыта!");
        //} else if (isEmpty) {
        } else if (someObject.equals(EMPTY_BOX)) {
            System.out.println("Не могу выкинуть Объект из коробки, коробка пустая!");
        } else {
            someObject = EMPTY_BOX;
            isEmpty = true;
            System.out.println("Объект выкинули из коробки.");
        }
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

        //System.out.print("Наличие предмета в коробке: ");
        //if (isEmpty) {
        //    System.out.println("пусто");
        //} else {
        //    System.out.println("предмет внутри.");
        //}

        System.out.println("Наличие предмета в коробке: " + someObject);
    }
}
