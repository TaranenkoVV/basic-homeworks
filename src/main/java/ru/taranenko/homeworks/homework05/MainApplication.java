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

        //01
        method01(3, "HomeWork05");

        //02
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length - 1; i++) {
            arr2[i] = random.nextInt(10);
        }
        method02(arr2);

        //03
        int[] arr3 = new int[10];
        method03(3, arr3);
        System.out.println(Arrays.toString(arr3));

        //04
        method04(5, arr3);
        System.out.println(Arrays.toString(arr3));

        //05
        method05(arr2);
    }

    /**
     * метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку указанное количество
     * раз.
     *
     * @param count
     * @param str
     */
    public static void method01(int count, String str) {
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
    private static void method02(int[] arr) {
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
     * метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы, значение которых больше
     * 5, и печатающий полученную сумму в консоль;
     *
     * @param value
     * @param arr
     */
    private static void method03(int value, int[] arr) {
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
    private static void method04(int value, int[] arr) {
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
    private static void method05(int[] arr5) {
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
        //01
        int[] arr11 = {1, 2, 3};
        int[] arr12 = {2, 2};
        int[] arr13 = {1, 1, 1, 1, 1};
        methodHard01(arr11, arr12, arr13);

        //02
        int[] arr21 = {1, 1, 1, 1, 1, 5};
        int[] arr22 = {5, 3, 4, -2};
        int[] arr23 = {7, 2, 2, 2};
        int[] arr24 = {9, 4};
        methodHard02(arr21);
        methodHard02(arr22);
        methodHard02(arr23);
        methodHard02(arr24);

        //03
        int[] arr31 = {10, 8, 6, 4, 5, 7, 9};
        int[] arr32 = {4, 5, 7, 9, 10, 12, 14};
        int[] arr33 = {10, 8, 6, 4, 3, 2, 1};
        methodHard03(arr31);
        methodHard03(arr32);
        methodHard03(arr33);

        //04
        int[] arr41 = {10, 8, 6, 4, 5, 7, 9};
        methodHard04(arr41);
        System.out.println("\t" + Arrays.toString(arr41));
    }

    /**
     * метод, принимающий на вход набор целочисленных массивов, и получающий новый массив равный сумме входящих;
     *
     * @param arr1
     * @param arr2
     * @param arr3
     */
    private static void methodHard01(int[] arr1, int[] arr2, int[] arr3) {

        System.out.println();
        System.out.println("Метод 1* - новый массив равен сумме входящих массивов");
        System.out.println("-------");
        System.out.println("Параметры: ");
        System.out.println("\t" + Arrays.toString(arr1));
        System.out.println("\t" + Arrays.toString(arr2));
        System.out.println("\t" + Arrays.toString(arr3));
        System.out.println("Результат:");

        int maxSize = 0;

        maxSize = arr1.length;
        if (maxSize < arr2.length) {
            maxSize = arr2.length;
        }
        if (maxSize < arr3.length) {
            maxSize = arr3.length;
        }

        int[] sumArr = new int[maxSize];

        for (int i = 0; i < sumArr.length; i++) {
            if (i < arr1.length) {
                sumArr[i] += arr1[i];
            }
            if (i < arr2.length) {
                sumArr[i] += arr2[i];
            }
            if (i < arr3.length) {
                sumArr[i] += arr3[i];
            }
        }
        System.out.println("\t" + Arrays.toString(sumArr));
    }

    /**
     * метод, проверяющий что есть “точка” в массиве, в которой сумма левой и правой части равны.
     *
     * @param arr
     */
    private static void methodHard02(int[] arr) {

        System.out.println();
        System.out.println("Метод 2* - поиск точки массива, в которой сумма левой и правой части равны.");
        System.out.println("-------");
        System.out.println("Параметры: ");
        System.out.println("\t" + Arrays.toString(arr));
        System.out.println("Результат:");

        int sum1;
        int sum2;

        for (int i = 0; i < arr.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j <= i) {
                    sum1 += arr[j];
                } else {
                    sum2 += arr[j];
                }
            }

            if (sum1 == sum2) {
                System.out.println("Точка находится между элементами " + (i + 1) + " и " + (i + 2));
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

        if (mode == 1) {
            //проверка на убывание элементов
            isDescending = true;
        }
        if (mode == 2) {
            //проверка на возрастание элементов
            isAscending = true;
        }

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
    private static void methodHard04(int[] arr) {
        System.out.println();
        System.out.println("Метод 4* - переворачивание массива");
        System.out.println("-------");
        System.out.println("Параметры: ");
        System.out.println("\t" + Arrays.toString(arr));
        System.out.println("Результат:");

        int j = arr.length - 1;
        for (int i = 0; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
