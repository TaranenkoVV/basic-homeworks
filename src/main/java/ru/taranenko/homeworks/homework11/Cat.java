package ru.taranenko.homeworks.homework11;

public class Cat extends Animal {

    public Cat(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        //затраты единиц выносливости на 1 метр бега
        this.runningEnduranceCost = 1;
        //затраты единиц выносливости на 1 метр плавания
        this.swimmingEnduranceCost = -1;
        // общая выносливость животного
        this.overallEndurance = endurance;

        this.canRun = true;
        this.canSwim = false;
    }

    public void taskSwimming(int distance) {
        int time;
        System.out.println();
        this.info();

        System.out.println("\tЗадание для кота: " + name + ". Проплыть " + distance + " метров.");
        time = this.swimming(distance);
        this.info();
    }

    public void taskRun(int distance) {
        int time;
        System.out.println();
        this.info();

        System.out.println("\tЗадание для кота: " + name + ". Пробежать " + distance + " метров.");
        time = this.run(distance);
        this.info();
    }

    /**
     * Расчет времени затраченного на БЕГ на дистанцию distance.
     *
     * @param distance
     * @return time
     */
    @Override
    public int run(int distance) {
        int time;
        time = super.run(distance);
        return time;
    }

    /**
     * Расчет времени затраченного на ПЛАВАНИЕ на дистанцию distance.
     *
     * @param distance
     * @return time
     */
    @Override
    public int swimming(int distance) {
        int time;
        time = super.swimming(distance);
        return time;
    }
}
