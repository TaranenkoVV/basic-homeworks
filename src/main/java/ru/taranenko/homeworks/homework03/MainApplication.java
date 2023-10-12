package ru.taranenko.homeworks.homework03;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        int mode = getMode();
        if (mode == 1) {
            sequentialStart();
        } else if (mode == 2) {
            selectiveStart();
        }
    }

    public static int getMode() {
        Scanner scanner = new Scanner(System.in);
        int mode = 0;
        System.out.println("Режимы запуска:");
        System.out.println("1. Последовательный запуск методов");
        System.out.println("2. Запуск метода по выбору");
        System.out.println();

        while (mode < 1 || mode > 2) {
            System.out.print("Введите режим от 1 до 2: ");
            mode = scanner.nextInt();
        }
        return mode;
    }

    public static void sequentialStart() {
        greetings();
        checkSign(-5, 2, 1);
        checkSign(5, -2, 1);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(10, 4, true);
        addOrSubtractAndPrint(10, 2, false);
    }

    public static int getNumMethod() {
        Scanner scanner = new Scanner(System.in);
        int numMethod = 0;

        System.out.println("\nСписок методов:");
        System.out.println("1) Метод greetings:");
        System.out.println("2) Метод checkSign:");
        System.out.println("3) Метод selectColor:");
        System.out.println("4) Метод compareNumbers:");
        System.out.println("5) Метод addOrSubtractAndPrint:");
        System.out.println();

        while (numMethod < 1 || numMethod > 5) {
            System.out.print("Введите номер метода от 1 до 5: ");
            numMethod = scanner.nextInt();
        }
        return numMethod;
    }

    public static void selectiveStart() {
        int numMethod = getNumMethod();

        if (numMethod == 1) {
            greetings();

        } else if (numMethod == 2) {
            int a = (int) (Math.random() * 20) * (Math.random() < 0.5 ? -1 : 1);
            int b = (int) (Math.random() * 20) * (Math.random() < 0.5 ? -1 : 1);
            int c = (int) (Math.random() * 20) * (Math.random() < 0.5 ? -1 : 1);

            checkSign(a, b, c);

        } else if (numMethod == 3) {
            selectColor();

        } else if (numMethod == 4) {
            compareNumbers();

        } else if (numMethod == 5) {
            int initValue = (int) (Math.random() * 20);
            int delta = (int) (Math.random() * 20);
            boolean increment = Math.random() > 0.5;

            addOrSubtractAndPrint(initValue, delta, increment);
        }

    }

    public static void greetings() {
        System.out.println("\n1) Метод greetings:");
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println("\n2) Метод checkSign:");

        int sum = a + b + c;
        System.out.println("(" + a + ") + (" + b + ") + (" + c + ") = " + sum);
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 15;
        System.out.println("\n3) Метод selectColor:");

        System.out.println("data = " + data);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 25;
        int b = 15;
        System.out.println("\n4) Метод compareNumbers:");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result = 0;
        System.out.println("\n5) Метод addOrSubtractAndPrint:");

        System.out.println("initValue = " + initValue);
        System.out.println("delta     = " + delta);
        System.out.println("increment = " + increment);

        if (increment) {
            result = initValue + delta;
        } else {
            result = initValue - delta;
        }

        System.out.println("Результат = " + result);
    }
}
