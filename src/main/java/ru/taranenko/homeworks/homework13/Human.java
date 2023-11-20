package ru.taranenko.homeworks.homework13;

public class Human {

    // имя
    private String name;
    private TransportInt currentTransport;


    // Человеческие силы
    private int humanPower;
    // Расход человеческих сил при перемещении на велосипеде на 100 км
    private int humanPowerBicycleConsumption;

    public int getHumanPower() {
        return humanPower;
    }

    public Human(String name) {
        this.name = name;
        this.humanPower = 25;
        this.humanPowerBicycleConsumption = 100;
    }

    public float calcRequiredPower(int distance) {
        return distance * humanPowerBicycleConsumption / 100;
    }

    public void decreasePower(int distance) {
        humanPower = humanPower - (distance * humanPowerBicycleConsumption / 100);
        if (humanPower < 0) {
            humanPower = 0;
        }
    }

    // выйти из транспорта
    public void freeTransport() {
        if (currentTransport != null) {
            System.out.println();
            System.out.println(name + " вышел из транспорта: " + ((CustomTransport) currentTransport).transportName);
            currentTransport = null;
        } else {
            System.out.println(name + " не может выйти еще раз, он не в транспорте!");
        }
    }

    // сесть в транспорт
    public void useTransport(TransportInt newTransport) {
        System.out.println();
        if (currentTransport == null) {
            currentTransport = newTransport;
            System.out.println(name + " сел в транспорт: " + ((CustomTransport) newTransport).transportName);
        } else {
            System.out.println(
                    "Невозможно сесть в новый транспорт: " + ((CustomTransport) newTransport).transportName);
            System.out.println("Сначала надо выйти из прежнего транспорта: "
                    + ((CustomTransport) currentTransport).transportName);
        }
    }


    public boolean move(int distance, TerrainType terrainType) {

        if (currentTransport == null) {

            // человек перемещается пешком
            System.out.println();
            System.out.println("Задача: " + name + " должен переместиться пешком " +
                    " по местности: " + terrainType.getNameRus() +
                    " на " + distance + " км.");

            // Есть ли у человека силы ?
            if (humanPower == 0) {
                System.out.println("Остаток сил у человека до перемещения: " + (float) humanPower);
                System.out.println(
                        name + " не может перемеcтиться на " + distance + " км. У человека не хватает сил.");
                return false;
            }

            System.out.println("Остаток сил у человека до перемещения: " + (float) humanPower);
            System.out.println(
                    name + " успешно переместился пешком по местности: " + terrainType.getNameRus() + " на "
                            + distance + " км.");
            System.out.println("Остаток сил у человека после перемещения: " + (float) humanPower);
            return true;

        } else {
            // человек перемещается с помощью транспорте
            return currentTransport.move(distance, terrainType, this);
        }
    }
}
