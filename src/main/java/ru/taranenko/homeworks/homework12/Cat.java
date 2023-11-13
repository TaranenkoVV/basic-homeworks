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
        // если пытаемся накормить сытого кота, то ничего не меняется, кот ничего не ест
        if(this.satiety) {
            System.out.println("Кот: " + this.name + " уже сыт!");
            return;
        }

        // если коту мало еды в тарелке, то он её просто не трогает
        if (!plate.decreaseFood(this.appetit)) {
            //кот остался голодным
            System.out.println("Коту: " + this.name + " не хватило еды в тарелке! \tХотел бы съесть: " + this.appetit );
            this.satiety = false;
        } else {
            //вернулось true, удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды
            //кот наелся
            System.out.print("Кот: " + this.name + " съел из тарелки " + this.appetit + " кусков еды. ");
            System.out.println("\tВ тарелке осталось: " + plate.getCurrentFood());
            this.satiety = true;
        }
    }

    /**
     * вывод в консоль состояния животного.
     */
    public void info() {
        System.out.println("Кот: " + name + "\tАппетит: " + appetit + "\tСостояние: " + (this.satiety == true ? "сыт." : "голоден."));
    }

}
