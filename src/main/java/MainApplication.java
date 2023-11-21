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

        // 2 - массив с неправильным размером
        try {
            printArray(badArraySize);
            sumItem = calcSumItem(badArraySize);
            System.out.println("Сумма элементов массива = " + sumItem);

        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        // 3 - массив с ошибочными элементами
        try {
            printArray(badArrayItem);
            sumItem = calcSumItem(badArrayItem);
            System.out.println("Сумма элементов массива = " + sumItem);

        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int calcSumItem(String[][] arrParam) {

        //1 проверка размерности массива
        int sizeRow = arrParam.length;
        int sizeCol = arrParam[0].length;
        int size = 4;

        if (sizeRow != size || sizeCol != size) {
            throw new AppArraySizeException("", "[" + sizeRow + "][" + sizeCol + "]");
        }

        //2 расчет суммы
        int i = 0;
        int j = 0;
        int result = 0;
        try {
            for (i = 0; i < arrParam.length; i++) {
                for (j = 0; j < arrParam[i].length; j++) {
                    result += Integer.parseInt(arrParam[i][j]);
                }
            }
            return result;

        } catch (NumberFormatException ex) {
            throw new AppArrayDataException(ex.getMessage(), "[" + i + "," + j + "] = " + arrParam[i][j]);
        }
    }

    public static void fillArray(String[][] arrParam) {
        Random random = new Random();
        for (int i = 0; i < arrParam.length; i++) {
            for (int j = 0; j < arrParam[i].length; j++) {
                arrParam[i][j] = Integer.toString(random.nextInt(10));
                ;
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
