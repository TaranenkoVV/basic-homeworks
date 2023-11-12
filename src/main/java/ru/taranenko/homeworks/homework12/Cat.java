package ru.taranenko.homeworks.homework12;

public class Cat {
    // кличка кота
    private String name;

    // аппетит
    private int appetit;

    // сытость
    private boolean satiety;

    /**
     * Конструктор.
     *
     * @param name кличка
     * @param appetit аппетит
     */
    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
        //когда создаем котов, они голодны
        this.satiety = false;
    }

    /**
     * Кормление кота из тарелки plate
     *
     * @param plate тарелка
     */
    public void eat(Plate plate) {
        // если коту мало еды в тарелке, то он её просто не трогает
        if (this.appetit > plate.getCurrentFood()) {
            //кот остался голодным
            this.satiety = false;
        } else {
            //если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то вернется true
            if (plate.decreaseFood(this.appetit)) {
                //кот наелся
                this.satiety = true;
            } else {
                //кот остался голодным
                this.satiety = false;
            }
        }
    }

    /**
     * вывод в консоль состояния животного.
     */
    public void info() {
        System.out.println("Кот: " + name + "\tАппетит: " + appetit + "\tСостояние: " + (this.satiety == true ? "сыт." : "голоден."));
    }

}
