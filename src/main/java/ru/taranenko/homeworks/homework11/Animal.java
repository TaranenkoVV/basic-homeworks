package ru.taranenko.homeworks.homework11;

public class Animal {

    // имя
    protected String name;

    // скорость бега м/с
    protected int runningSpeed;

    // скорость плавания м/с
    protected int swimmingSpeed;

    // общая выносливость животного
    protected int overallEndurance;

    // затраты выносливости в беге
    protected int runningEnduranceCost;

    // затраты выносливости в плавании
    protected int swimmingEnduranceCost;

    // умеет ли животное плавать
    protected boolean canSwim;
    // умеет ли животное бегать
    protected boolean canRun;

    public String getName() {
        return name;
    }

    /**
     * вывод в консоль состояние животного.
     */
    public void info() {
        System.out.println("Параметры животного: " + name + ". Скорость бега: " + runningSpeed + " м/с. Скорость плавания: " + swimmingSpeed + " м/с");
        System.out.println("Состояние животного: " + name + ". Осталось " + overallEndurance + " единиц выносливости.");
    }

    /**
     * расчет количества единиц выносливости требуемых для заданной дистанции.
     *
     * @param distance
     * @param enduranceCost
     * @return requiredEndurance
     */
    public int calcRequiredEndurance(int distance, int enduranceCost) {
        int requiredEndurance;
        requiredEndurance = distance * enduranceCost;
        return requiredEndurance;
    }

    public int animalIsTired() {
        int time = -1;
        overallEndurance = 0;
        System.out.println("\tУ животного " + name + " появилось состояние усталости.");
        return time;
    }

    /**
     * расчет времени для прохождения дистанции.
     *
     * @param distance
     * @param speed
     * @return time
     */
    public int calcTimeToDistance(int distance, int speed){
        int time;
        if (speed == 0) {
            time = 0;
        } else {
            time = (int) distance / speed;
        }
        return time;
    }

    /**
     * Расчет времени затраченного на действие на дистанцию distance.
     * Если выносливости не хватает, то возвращаем время -1
     * и указываем что у животного появилось состояние усталости.
     *
     * @param distance
     * @param speed
     * @param enduranceCost
     * @return time
     */
    public int calcTimeAction(int distance, int speed, int enduranceCost) {
        int time;
        int requiredEndurance;

        // есть ли еще единицы выносливости у животного
        if (overallEndurance == 0){
            time = animalIsTired();
            return time;
        }

        // расчет количества единиц выносливости требуемых для прохождения дистанции
        requiredEndurance = calcRequiredEndurance(distance, enduranceCost);
        overallEndurance = overallEndurance - requiredEndurance;

        // хватит ли выносливости на всю дистанцию
        if (overallEndurance < 0){
            time = animalIsTired();
            return time;
        }

        // расчет времени для прохождения дистанции
        time = calcTimeToDistance(distance, speed);
        return time;
    }

    /**
     * Расчет времени затраченного на БЕГ на дистанцию distance.
     * @param distance
     * @return time
     */
    public int run(int distance) {
        int time;

        if(!canRun){
            System.out.println("\tЖивотное " + name + " не умеет бегать.");
            time = 0;
            return time;
        }

        time = calcTimeAction(distance, runningSpeed, runningEnduranceCost);

        if (time >= 0) {
            System.out.println("\tЖивотное " + name + " успешно справилось с заданием за " + time + " секунд!");
        } else {
            System.out.println("\tЖивотное " + name + " не справилось с заданием!");
        }

        return time;
    }

    /**
     * Расчет времени затраченного на ПЛАВАНИЕ на дистанцию distance.
     * @param distance
     * @return time
     */
    public int swimming(int distance) {
        int time;

        if(!canSwim){
            System.out.println("\tЖивотное " + name + " не умеет плавать.");
            time = 0;
            return time;
        }

        time = calcTimeAction(distance, swimmingSpeed, swimmingEnduranceCost);

        if (time >= 0) {
            System.out.println("\tЖивотное " + name + " успешно справилось с заданием за " + time + " секунд!");
        } else {
            System.out.println("\tЖивотное " + name + " не справилось с заданием!");
        }

        return time;
    }
}
