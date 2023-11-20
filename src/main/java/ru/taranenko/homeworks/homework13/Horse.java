package ru.taranenko.homeworks.homework13;

public class Horse extends CustomTransport implements TransportInt {

    // Лошадиные силы
    private int horsePower;
    // Расход лошадиных сил на 100 км
    private int horsePowerConsumption;


    public Horse(String transportName) {
        this.transportName = transportName;
        this.horsePower = 10;
        this.horsePowerConsumption = 20;
    }

    private float calcRequiredPower(int distance) {
        return distance * horsePowerConsumption / 100;
    }

    private void decreasePower(int distance) {
        horsePower = horsePower - (distance * horsePowerConsumption / 100);
        if (horsePower < 0) {
            horsePower = 0;
        }
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

        // Хватит ли сил на всю дистанцию
        if (horsePower == 0 || calcRequiredPower(distance) > horsePower) {
            System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Не хватает сил.");
            return false;
        }

        System.out.println("Остаток сил у лошади до перемещения: " + (float) horsePower );
        System.out.println(transportName + " успешно переместилась по местности: " + terrainType.getNameRus() + " на " + distance + " км.");
        decreasePower(distance);
        System.out.println("Остаток сил у лошади после перемещения: " + (float)horsePower);
        return true;
    }
}
