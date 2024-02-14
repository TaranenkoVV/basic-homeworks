package ru.taranenko.homeworks.homework27;

public class Fruit {
    private final String name;
    private final double weight;

    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }

    public Fruit(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
