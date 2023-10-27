package ru.taranenko.homeworks.homework07;

import java.util.Random;

public class MainApplication {

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        init();

        Random random = new Random();
        int[][] arr1 = new int[3][3];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                arr1[i][j] = random.nextInt(10) - 5;
            }
        }

        // 01
        int sum = 0;
        sum = sumOfPositiveElements(arr1);
        System.out.println("Результат: " + sum);

        // 02
        int size = 5;
        printStar(size);

        // 03
        resetDiagonal(arr1);

        // 04
        findMax(arr1);

        // 05
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                arr1[i][j] = random.nextInt(10);
            }
        }
        int sum2row = findSum(arr1);
        if(sum2row == -1) {
            System.out.println("Результат: второй строки не существует");
        } else{
            System.out.println("Результат: сумма элементов второй строки = " + sum2row);
        }
    }

    /**
     * Заголовок ДЗ
     */
    private static void init() {
        System.out.println();
        System.out.println("HomeWork07 (Основы языка Java. Часть 3)");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    /**
     * метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив, метод должен
     * посчитать и вернуть сумму всех элементов массива, которые больше 0;
     *
     * @param arr
     * @return
     */
    private static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        System.out.println();
        System.out.println("1) Метод sumOfPositiveElements");
        System.out.println("-------");
        System.out.println("Параметры: arr = ");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] >= 0) {
                    System.out.print(" " + arr[row][col]);
                } else {
                    System.out.print(arr[row][col]);
                }
                System.out.print("\t\t");

                //подсчет суммы
                if (arr[row][col] > 0) {
                    sum += arr[row][col];
                }
            }
            System.out.println();
        }
        return sum;
    }

    /**
     * метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами
     * соответствующей длины
     *
     * @param size
     */
    private static void printStar(int size) {
        System.out.println();
        System.out.println("2) Метод printStar");
        System.out.println("-------");
        System.out.println("Параметры: size = " + size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * метод, принимающий в качестве аргумента двумерный целочисленный массив, и зануляющий его диагональные элементы
     * (можете выбрать любую из диагоналей, или занулить обе);
     *
     * @param arr
     */
    private static void resetDiagonal(int[][] arr) {
        System.out.println();
        System.out.println("3) Метод resetDiagonal");
        System.out.println("-------");
        System.out.println("Параметры: arr = ");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] >= 0) {
                    System.out.print(" " + arr[row][col]);
                } else {
                    System.out.print(arr[row][col]);
                }
                System.out.print("\t\t");
            }
            System.out.println();
        }

        System.out.println("Результат: ");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                //обнуление диагональных элементов
                if (row == col) {
                    arr[row][col] = 0;
                }
                if ((row + col) == arr.length - 1) {
                    arr[row][col] = 0;
                }

                //вывод элементов
                if (arr[row][col] >= 0) {
                    System.out.print(" " + arr[row][col]);
                } else {
                    System.out.print(arr[row][col]);
                }
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }

    /**
     * метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива.
     *
     * @param arr
     */
    private static void findMax(int[][] arr) {
        int max = arr[0][0];
        System.out.println();
        System.out.println("4) Метод findMax");
        System.out.println("-------");
        System.out.println("Параметры: arr = ");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                //поиск max элемента
                if (arr[row][col] > max) {
                    max = arr[row][col];
                }

                //вывод элементов
                if (arr[row][col] >= 0) {
                    System.out.print(" " + arr[row][col]);
                } else {
                    System.out.print(arr[row][col]);
                }
                System.out.print("\t\t");
            }
            System.out.println();
        }
        System.out.println("Результат: максимальный элемент = " + max);
    }

    /**
     * метод, который считает сумму элементов второй строки двумерного массива,
     * если второй строки не существует, то в качестве результата необходимо вернуть -1
     *
     * @param arr
     * @return sum
     */
    private static int findSum(int[][] arr) {
        int sum;
        System.out.println();
        System.out.println("5) Метод findSum");
        System.out.println("-------");
        System.out.println("Параметры: arr = ");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                //вывод элементов
                if (arr[row][col] >= 0) {
                    System.out.print(" " + arr[row][col]);
                } else {
                    System.out.print(arr[row][col]);
                }
                System.out.print("\t\t");
            }
            System.out.println();
        }

        //сумма элементов второй строки
        if(arr.length < 1){
            sum = -1;
        } else {
            sum = 0;
            for (int col = 0; col < arr[1].length; col++) {
                sum += arr[1][col];
            }
        }

       return sum;
    }
}

