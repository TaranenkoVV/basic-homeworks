package ru.taranenko.homeworks.homework11;

public class Dog extends Animal {

    public Dog(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        //затраты единиц выносливости на 1 метр бега
        this.runningEnduranceCost = 1;
        //затраты единиц выносливости на 1 метр плавания
        this.swimmingEnduranceCost = 2;
        // общая выносливость животного
        this.overallEndurance = endurance;
    }

    public void taskSwimming(int distance) {
        int time;
        System.out.println();
        this.info();

        System.out.println("\tЗадание для собаки: " + name + ". Проплыть " + distance + " метров.");
        time = this.swimming(distance);
        this.info();
    }

    public void taskRun(int distance) {
        int time;
        System.out.println();
        this.info();

        System.out.println("\tЗадание для собаки: " + name + ". Пробежать " + distance + " метров.");
        time = this.run(distance);
        this.info();
    }

}
