package ru.taranenko.homeworks.homework27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        title();


        Box<Fruit> boxFruit = new Box("Коробка с фруктами");
        boxFruit.addContent(new Apple("Big apple", 500));

        Box<Apple> boxApple = new Box("Коробка с яблоками");
        boxApple.addContent(new Apple("apple1", 100));
        boxApple.addContent(new Apple("apple2", 200));

        Box<Orange> boxOrange = new Box("Коробка с апельсинами");
        boxOrange.addContent(new Orange("orange1", 200));
        boxOrange.addContent(new Orange("orange2", 200));

        printBoxInfo(boxFruit);
        printBoxInfo(boxApple);
        printBoxInfo(boxOrange);

        System.out.println();
        System.out.println("Сравнение массы: " + boxApple.getName() + " и " + boxOrange.getName());
        if (boxApple.compare(boxOrange)) {
            System.out.println("Массы равны");
        } else {
            System.out.println("Массы не равны");
        }

        System.out.println();
        System.out.println("Добавим яблоко в Коробку с яблоками.");
        boxApple.addContent(new Apple("apple3", 100));
        printBoxInfo(boxApple);
        printBoxInfo(boxOrange);

        System.out.println();
        System.out.println("Сравнение массы: " + boxApple.getName() + " и " + boxOrange.getName());
        if (boxApple.compare(boxOrange)) {
            System.out.println("Массы равны");
        } else {
            System.out.println("Массы не равны");
        }


        System.out.println();
        System.out.println("Пересыпать все фрукты из 'Коробки с яблоками' в 'Коробку с фруктами'.");
        System.out.println("---------------------------------------------------------------------");
        boxApple.moveContentInto(boxFruit);
        printBoxInfo(boxApple);
        printBoxInfo(boxFruit);

        System.out.println();
        System.out.println("Пересыпать все фрукты из 'Коробки с фруктами' в 'Коробку с апельсинами'.");
        System.out.println("---------------------------------------------------------------------");
        boxFruit.moveContentInto(boxOrange);
        printBoxInfo(boxFruit);
        printBoxInfo(boxOrange);

        System.out.println();
        System.out.println("Пересыпать все фрукты из 'Коробки с апельсинами' в 'Коробку с яблоками'.");
        System.out.println("---------------------------------------------------------------------");
        boxOrange.moveContentInto(boxApple);
        printBoxInfo(boxOrange);
        printBoxInfo(boxApple);

        System.out.println();
        System.out.println("Пересыпать все фрукты из 'Коробки с яблоками' в 'Коробку с апельсинами'.");
        System.out.println("---------------------------------------------------------------------");
        boxApple.moveContentInto(boxOrange);
        printBoxInfo(boxApple);
        printBoxInfo(boxOrange);

    }

    public static void printBoxInfo(Box box) {
        System.out.println(box.getName() + ". Кол-во фруктов = " + box.getContent().size() + ". Вес = " + calcBoxWeight(
                box.getContent()));
        System.out.println(box.getContent().toString());
    }

    public static double calcBoxWeight(List<? extends Fruit> in) {
        double result = 0.0;
        for (int i = 0; i < in.size(); i++) {
            result += in.get(i).getWeight();
        }
        return result;
    }

    /**
     * Заголовок ДЗ
     */
    private static void title() {
        System.out.println();
        System.out.println("HomeWork27 к уроку Lesson27");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }
}
