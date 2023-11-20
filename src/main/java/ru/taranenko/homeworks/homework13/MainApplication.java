package ru.taranenko.homeworks.homework13;

public class MainApplication {

    public static void main(String[] args) {
        title();

        Human human = new Human("Виктор");

        TransportInt transportCar = new Car("Автомобиль");
        TransportInt transportOfRoader = new OffRoader("Вездеход");
        TransportInt transportHorse = new Horse("Лошадь");
        TransportInt transportBicycle = new Bicycle("Велосипед");

        boolean result;
        result = human.move(5, TerrainType.FOREST);
        printResult(result);

        human.useTransport(transportCar);
        result = human.move(5, TerrainType.FOREST);
        printResult(result);
        result = human.move(100, TerrainType.SWAMP);
        printResult(result);

        human.useTransport(transportOfRoader);
        human.freeTransport();
        human.useTransport(transportOfRoader);

        result = human.move(100, TerrainType.SWAMP);
        printResult(result);

        human.freeTransport();
        human.freeTransport();

        human.useTransport(transportHorse);
        result = human.move(50, TerrainType.PLAIN);
        printResult(result);
        result = human.move(1, TerrainType.PLAIN);
        printResult(result);

        human.freeTransport();
        human.useTransport(transportBicycle);
        result = human.move(10, TerrainType.PLAIN);
        printResult(result);
        result = human.move(10, TerrainType.PLAIN);
        printResult(result);
        result = human.move(5, TerrainType.PLAIN);
        printResult(result);
        result = human.move(5, TerrainType.PLAIN);
        printResult(result);

        human.freeTransport();
        result = human.move(5, TerrainType.PLAIN);
        printResult(result);
    }

    public static void printResult(boolean result) {
        if (result) {
            System.out.println("Задача выполнена!");
        } else {
            System.out.println("Задача не выполнена!");
        }
        ;
    }

    /**
     * Заголовок ДЗ
     */
    private static void title() {
        System.out.println();
        System.out.println("HomeWork13 к уроку Lesson13");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }
}
