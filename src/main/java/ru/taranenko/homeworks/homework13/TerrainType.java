package ru.taranenko.homeworks.homework13;

public enum TerrainType {
    FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private String nameRus;

    public String getNameRus(){
        return nameRus;
    }

    TerrainType(String nameRus) {
        this.nameRus = nameRus;
    }
}
