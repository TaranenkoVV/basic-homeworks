package ru.taranenko.homeworks.homework12;

public class MainApplication {

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        title();

        Plate plate = new Plate(100);
        Cat[] cat = new Cat[10];

        // Заполнение массива с котами
        fillCatsArray(cat);

        System.out.println("Количество еды в тарелке перед кормлением котов: " + plate.getCurrentFood());

        //покормить котов из тарелки plate
        feedingCats(cat, plate);

        System.out.println("Состояние котов после кормления");
        printCatsInfo(cat, plate);

        System.out.println("Количество еды в тарелке после кормления котов: " + plate.getCurrentFood());
    }

    /**
     * Заголовок ДЗ
     */
    private static void title() {
        System.out.println();
        System.out.println("HomeWork12 к уроку Lesson12");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    /**
     * Заполнение массива с котами
     *
     * @param cat
     */
    private static void fillCatsArray(Cat[] cat) {
        cat[0] = new Cat("Кот-01", 10);
        cat[1] = new Cat("Кот-02", 20);
        cat[2] = new Cat("Кот-03", 15);
        cat[3] = new Cat("Кот-04", 5);
        cat[4] = new Cat("Кот-05", 10);
        cat[5] = new Cat("Кот-06", 10);
        cat[6] = new Cat("Кот-07", 10);
        cat[7] = new Cat("Кот-08", 15);
        cat[8] = new Cat("Кот-09", 10);
        cat[9] = new Cat("Кот-10", 5);
    }

    /**
     * Кормление котов из тарелки plate
     */
    private static void feedingCats(Cat[] cat, Plate plate) {
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
        }
    }

    /**
     * Вывод информации состоянии всех котов.
     *
     * @param cat массив котов
     */
    private static void printCatsInfo(Cat[] cat, Plate plate) {
        for (int i = 0; i < cat.length; i++) {
            cat[i].info();
        }
    }
}
