package ru.taranenko.homeworks.homework11;

public class MainApplication {

    public static void main(String[] args) {
        title();

        Cat cat = new Cat("Barsik", 2, 0, 100);
        cat.taskRun(5);
        cat.taskSwimming(10);
        cat.taskRun(20);

        Dog dog = new Dog("Muhtar", 4, 1, 100);
        dog.taskRun(5);
        dog.taskSwimming(10);

        Horse horse = new Horse("Strelka", 6, 2, 500);
        horse.taskSwimming(100);
        horse.taskRun(100);
        horse.taskRun(1000);
        horse.taskRun(2000);
    }
    /**
     * Заголовок ДЗ
     */
    private static void title() {
        System.out.println();
        System.out.println("HomeWork11 к уроку Lesson11");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }
}
