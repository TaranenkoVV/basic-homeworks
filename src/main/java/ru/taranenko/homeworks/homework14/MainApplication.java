package ru.taranenko.homeworks.homework14;

import java.util.Random;

public class MainApplication {

    private static void title() {
        System.out.println();
        System.out.println("HomeWork14 к уроку Lesson14");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        title();

        String[][] goodArray = new String[4][4];
        String[][] badArrayItem = new String[4][4];
        String[][] badArraySize = new String[3][5];
        String[][] badArraySize2 =  {
                {"1", "2", "3", "4"},
                {"2", "2", "3", "4"},
                {"3", "2"},
                {"4", "2", "3", "4" } };

        // заполнение массивов
        fillArray(goodArray);

        fillArray(badArraySize);

        fillArray(badArrayItem);
        badArrayItem[1][1] = "AA";
        badArrayItem[2][2] = "BB";
        badArrayItem[3][3] = "CC";

        // расчет суммы элементов
        int sumItem;

        // 1 - массив без ошибок
        try {
            printArray(goodArray);
            sumItem = calcSumItem(goodArray);
            System.out.println("Сумма элементов массива = " + sumItem);

        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        // 2 - массив с неправильным размером - 1
        try {
            printArray(badArraySize);
            sumItem = calcSumItem(badArraySize);
            System.out.println("Сумма элементов массива = " + sumItem);

        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        // 2 - массив с неправильным размером - 2
        try {
            printArray(badArraySize2);
            sumItem = calcSumItem(badArraySize2);
            System.out.println("Сумма элементов массива = " + sumItem);

        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        // 4 - массив с ошибочными элементами
        try {
            printArray(badArrayItem);
            sumItem = calcSumItem(badArrayItem);
            System.out.println("Сумма элементов массива = " + sumItem);

        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int calcSumItem(String[][] arrParam) {

        // проверка размерности массива
        int sizeRow = arrParam.length;
        int sizeCol = arrParam[0].length;
        int goodSize = 4;
        boolean isBadSize = (sizeRow != goodSize);
        if (!isBadSize) {
            for (int i = 0; i < arrParam.length; i++) {
                if ((sizeCol = arrParam[i].length) != goodSize) {
                    isBadSize = true;
                    break;
                }
            }
        }
        if (isBadSize) {
            throw new AppArraySizeException("", "[" + sizeRow + "][" + sizeCol + "]");
        }

        //2 расчет суммы
        int result = 0;
        for (int i = 0; i < arrParam.length; i++) {
            for (int j = 0; j < arrParam[i].length; j++) {
                try {
                    result += Integer.parseInt(arrParam[i][j]);
                } catch (NumberFormatException ex) {
                    throw new AppArrayDataException(ex.getMessage(), "[" + i + "," + j + "] = " + arrParam[i][j]);
                }
            }
        }
        return result;
    }

    public static void fillArray(String[][] arrParam) {
        Random random = new Random();
        for (int i = 0; i < arrParam.length; i++) {
            for (int j = 0; j < arrParam[i].length; j++) {
                arrParam[i][j] = Integer.toString(random.nextInt(10));
            }
        }
    }

    public static void printArray(String[][] arrParam) {
        System.out.println();
        for (int i = 0; i < arrParam.length; i++) {
            for (int j = 0; j < arrParam[i].length; j++) {
                System.out.print(arrParam[i][j] + " \t\t");
            }
            System.out.println();
        }
    }
}
