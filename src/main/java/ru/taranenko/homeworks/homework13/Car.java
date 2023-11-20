package ru.taranenko.homeworks.homework13;

public class Car extends CustomTransport implements TransportInt {

    // Объем топлива
    private int fuelVolume;
    // Расход топлива: литров на 100 км
    private int fuelConsumption;


    public Car(String transportName) {
        this.transportName = transportName;
        this.fuelVolume = 50;
        this.fuelConsumption = 10;
    }

    private float calcRequiredFuel(int distance) {
        return distance * fuelConsumption / 100;
    }

    private void decreaseFuelVolume(int distance) {
        fuelVolume = fuelVolume - (distance * fuelConsumption / 100);
        if (fuelVolume < 0) {
            fuelVolume = 0;
        }
    }

    @Override
    public boolean move(int distance, TerrainType terrainType, Human driver) {
        System.out.println();
        System.out.println("Задача: переместиться с помощью транспорта-" + transportName +
                " по местности: " + terrainType.getNameRus() +
                " на " + distance + " км.");

        if (terrainType == TerrainType.FOREST || terrainType == TerrainType.SWAMP) {
            System.out.println(transportName + " не может перемещаться по местности: " + terrainType.getNameRus());
            return false;
        }

        // Хватит ли топлива на всю дистанцию
        if (fuelVolume == 0 || calcRequiredFuel(distance) > fuelVolume) {
            System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Не хватает топлива.");
            return false;
        }

        System.out.println("Остаток топлива до перемещения: " + (float) fuelVolume + " л.");
        System.out.println(transportName + " успешно переместился по местности: "
                + terrainType.getNameRus()
                + " на " + distance + " км.");
        decreaseFuelVolume(distance);
        System.out.println("Остаток топлива после перемещения: " + (float) fuelVolume + " л.");

        return true;

    }
}
