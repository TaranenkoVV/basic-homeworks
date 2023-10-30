package ru.taranenko.homeworks.homework05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainApplication {

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        init();

        int mode = getMode();
        if (mode == 1) {
            simpleMode();
        } else if (mode == 2) {
            hardMode();
        }
    }

    /**
     * Заголовок ДЗ
     */
    private static void init() {
        System.out.println();
        System.out.println("HomeWork05");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    /**
     * Вариант ДЗ
     */
    public static int getMode() {
        Scanner scanner = new Scanner(System.in);
        int mode = 0;
        System.out.println("Вариант ДЗ:");
        System.out.println("1. Обязательное ДЗ");
        System.out.println("2. ДЗ со звездочкой");
        System.out.println();

        while (mode < 1 || mode > 2) {
            System.out.print("Введите номер варианта от 1 до 2: ");
            mode = scanner.nextInt();
        }
        return mode;
    }

    /**
     * Обязательное ДЗ
     */
    public static void simpleMode() {
        Random random = new Random();

        // 01 - метод, принимающий в качестве аргументов целое число и строку,
        // и печатающий в консоль строку указанное количество раз.
        printLine(3, "HomeWork05");

        // 02 - метод, принимающий в качестве аргумента целочисленный массив,
        // суммирующий все элементы, значение которых больше 5,
        // и печатающий полученную сумму в консоль;
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length - 1; i++) {
            arr2[i] = random.nextInt(10);
        }
        calcSumItems(arr2);

        // 03 метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
        // метод должен заполнить каждую ячейку массива указанным числом;
        int[] arr3 = new int[10];
        fillArray(3, arr3);
        System.out.println(Arrays.toString(arr3));

        // 04 - метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
        // увеличивающий каждый элемент массива на указанное число;
        addNumberToItems(5, arr3);
        System.out.println(Arrays.toString(arr3));

        // 05 - метод, принимающий в качестве аргумента целочисленный массив,
        // и печатающий в консоль информацию о том, сумма элементов какой из половин массива больше;
        compareSumItems(arr2);
    }

    /**
     * метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку указанное количество
     * раз.
     *
     * @param count
     * @param str
     */
    public static void printLine(int count, String str) {
        System.out.println();
        System.out.println("Метод 1");
        System.out.println("-------");
        System.out.println("Параметры: count = " + count + ", str = " + str);
        System.out.println("Результат:");
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /**
     * метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы, значение которых больше
     * 5, и печатающий полученную сумму в консоль;
     *
     * @param arr
     */
    private static void calcSumItems(int[] arr) {
        int sum = 0;

        System.out.println();
        System.out.println("Метод 2");
        System.out.println("-------");
        System.out.println("Параметры: arr = " + Arrays.toString(arr));
        System.out.println("Результат:");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("Сумма элементов, значение которых больше 5 = " + sum);
    }

    /**
     * метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив, метод должен заполнить
     * каждую ячейку массива указанным числом;
     *
     * @param value
     * @param arr
     */
    private static void fillArray(int value, int[] arr) {
        System.out.println();
        System.out.println("Метод 3");
        System.out.println("-------");
        System.out.println("Параметры: Value = " + value + ", arr = " + Arrays.toString(arr));
        System.out.println("Результат:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }

    /**
     * метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив, увеличивающий каждый
     * элемент массива на указанное число;
     *
     * @param value
     * @param arr
     */
    private static void addNumberToItems(int value, int[] arr) {
        System.out.println();
        System.out.println("Метод 4");
        System.out.println("-------");
        System.out.println("Параметры: Value = " + value + ", arr = " + Arrays.toString(arr));
        System.out.println("Результат:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] += value;
        }
    }

    /**
     * метод, принимающий в качестве аргумента целочисленный массив, и печатающий в консоль информацию о том, сумма
     * элементов какой из половин массива больше;
     *
     * @param arr5
     */
    private static void compareSumItems(int[] arr5) {
        int sum1 = 0;
        int sum2 = 0;
        int indexMiddle = 0;

        System.out.println();
        System.out.println("Метод 5");
        System.out.println("-------");
        System.out.println("Параметры: arr = " + Arrays.toString(arr5));
        System.out.println("Результат:");

        indexMiddle = (int) arr5.length / 2;
        for (int i = 0; i < arr5.length; i++) {
            if (i <= indexMiddle) {
                sum1 += arr5[i];
            } else {
                sum2 += arr5[i];
            }
        }
        if (sum1 > sum2) {
            System.out.println("Сумма элементов первой половины больше и равна = " + sum1);
            System.out.println("Сумма элементов второй половины равна = " + sum2);
        } else {
            System.out.println("Сумма элементов второй половины больше и равна = " + sum2);
            System.out.println("Сумма элементов первой половины равна = " + sum1);
        }
    }

    /**
     * ДЗ со звездочкой
     */
    public static void hardMode() {
        // 01 - метод, принимающий на вход набор целочисленных массивов,
        // и получающий новый массив равный сумме входящих;
        int[] arr11 = {1, 2, 3};
        int[] arr12 = {2, 2};
        int[] arr13 = {1, 1, 1, 1, 1};
        calcSumItemsSeveralArrays(arr11, arr12, arr13);

        // 02 - метод, проверяющий что есть “точка” в массиве,
        // в которой сумма левой и правой части равны.
        int[] arr21 = {1, 1, 1, 1, 1, 5};
        int[] arr22 = {5, 3, 4, -2};
        int[] arr23 = {7, 2, 2, 2};
        int[] arr24 = {9, 4};
        int[] arr25 = {10, 1, 3, 6};
        findEqualSumsPoint(arr21);
        findEqualSumsPoint(arr22);
        findEqualSumsPoint(arr23);
        findEqualSumsPoint(arr24);
        findEqualSumsPoint(arr25);

        // 03 - метод, проверяющий что все элементы массива идут в порядке убывания
        // или возрастания (по выбору пользователя)
        int[] arr31 = {10, 8, 6, 4, 5, 7, 9};
        int[] arr32 = {4, 5, 7, 9, 10, 12, 14};
        int[] arr33 = {10, 8, 6, 4, 3, 2, 1};
        methodHard03(arr31);
        methodHard03(arr32);
        methodHard03(arr33);

        // 04 - метод, “переворачивающий” входящий массив
        int[] arr41 = {10, 8, 6, 4, 5, 7, 9};
        reverseArray(arr41);

        System.out.println("Результат:");
        System.out.println("\t" + Arrays.toString(arr41));
    }

    /**
     * метод, принимающий на вход набор целочисленных массивов, и получающий новый массив равный сумме входящих;
     *
     * @param arr1
     * @param arr2
     * @param arr3
     */
    private static void calcSumItemsSeveralArrays(int[]... arrays) {

        System.out.println();
        System.out.println("Метод 1* - новый массив равен сумме входящих массивов");
        System.out.println("-------");
        System.out.println("Параметры: ");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(arrays[i]));
        }

        //поиск массива с максимальным количеством элементов maxSize
        int maxSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (maxSize < arrays[i].length) {
                maxSize = arrays[i].length;
            }
        }

        //создание результирующего массива размером maxSize
        int[] resultArray = new int[maxSize];

        //сумма элементов массивов
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                resultArray[j] += arrays[i][j];
            }
        }

        System.out.println("Результат:");
        System.out.println(Arrays.toString(resultArray));
    }

    /**
     * метод, проверяющий что есть “точка” в массиве, в которой сумма левой и правой части равны.
     *
     * @param arr
     */
    private static void findEqualSumsPoint(int[] arr) {

        System.out.println();
        System.out.println("Метод 2* - поиск точки массива, в которой сумма левой и правой части равны.");
        System.out.println("-------");
        System.out.println("Параметры: ");
        System.out.println("\t" + Arrays.toString(arr));
        System.out.println("Результат:");

        int sumLeftItems = 0;
        int sumRightItems = 0;
        int sumAllItems = 0;

        for (int i = 0; i < arr.length; i++) {
            sumAllItems += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            sumLeftItems += arr[i];
            sumRightItems = sumAllItems - sumLeftItems;

            if (sumLeftItems == sumRightItems) {
                System.out.println("Точка находится между элементами " + i + " и " + (i + 1));
                return;
            }
        }

        System.out.println("Такой точки нет.");
    }

    /**
     * метод, проверяющий что все элементы массива идут в порядке убывания или возрастания (по выбору пользователя)
     */
    private static void methodHard03(int[] arr) {
        System.out.println();
        System.out.println("Метод 3* - определение порядка элементов (убывание/возрастание)");
        System.out.println("-------");
        System.out.println("Параметры: ");
        System.out.println("\t" + Arrays.toString(arr));

        Scanner scanner = new Scanner(System.in);
        int mode = 0;
        System.out.println();
        System.out.println("Вариант:");
        System.out.println("1. Определить что все элементы массива идут в порядке убывания");
        System.out.println("2. Определить что все элементы массива идут в порядке возрастания");
        System.out.println();
        while (mode < 1 || mode > 2) {
            System.out.print("Введите номер варианта от 1 до 2: ");
            mode = scanner.nextInt();
        }
        System.out.println("Результат:");

        boolean isDescending = true;
        boolean isAscending = true;

        int value = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (mode == 1) {
                //проверка на убывание элементов
                if (arr[i] <= value) {
                    value = arr[i];
                } else {
                    isDescending = false;
                    break;
                }
            }

            if (mode == 2) {
                //проверка на возрастание элементов
                if (arr[i] >= value) {
                    value = arr[i];
                } else {
                    isAscending = false;
                    break;
                }
            }
        }

        if (mode == 1) {
            //проверка на убывание элементов
            if (isDescending == true) {
                System.out.println("Все элементы массива идут в порядке убывания");
            } else {
                System.out.println("Элементы массива НЕ идут в порядке убывания!");
            }
        }

        if (mode == 2) {
            //проверка на возрастание элементов
            if (isAscending == true) {
                System.out.println("Все элементы массива идут в порядке возрастания");
            } else {
                System.out.println("Элементы массива НЕ идут в порядке возрастания!");
            }
        }
    }

    /**
     * метод, “переворачивающий” входящий массив
     *
     * @param arr
     */
    private static void reverseArray(int[] arr) {
        System.out.println();
        System.out.println("Метод 4* - переворачивание массива");
        System.out.println("-------");
        System.out.println("Параметры: ");
        System.out.println("\t" + Arrays.toString(arr));

        // перестановка элементов во входящем массиве
        int j = arr.length - 1;
        for (int i = 0; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
