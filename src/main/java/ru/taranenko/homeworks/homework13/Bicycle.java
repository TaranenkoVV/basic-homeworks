package ru.taranenko.homeworks.homework13;

public class Bicycle extends CustomTransport implements TransportInt {

    public Bicycle(String transportName) {
        this.transportName = transportName;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType, Human driver) {
        System.out.println();
        System.out.println("Задача: переместиться с помощью транспорта-" + transportName +
                " по местности: " + terrainType.getNameRus() +
                " на " + distance + " км.");

        if (terrainType == TerrainType.SWAMP) {
            System.out.println(transportName + " не может перемещаться по местности: " + terrainType.getNameRus());
            return false;
        }

        // Хватит ли у "водителя" сил на всю дистанцию
        if ( driver.getHumanPower() == 0 || driver.calcRequiredPower(distance) > driver.getHumanPower()) {
            System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Не хватает сил водителя.");
            return false;
        }

        System.out.println("Остаток сил у водителя до перемещения: " + (float) driver.getHumanPower() );
        System.out.println(transportName + " успешно переместился по местности: " + terrainType.getNameRus() + " на " + distance + " км.");
        driver.decreasePower(distance);
        System.out.println("Остаток сил у водителя после перемещения: " + (float) driver.getHumanPower());
        return true;
    }
}
