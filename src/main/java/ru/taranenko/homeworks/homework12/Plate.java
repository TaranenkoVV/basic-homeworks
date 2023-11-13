package ru.taranenko.homeworks.homework12;

public class Plate {

    //максимальное количество еды - объем тарелки
    private int maxFood;
    //текущее количество еды
    private int currentFood;

    /**
     * Конструктор.
     *
     * @param maxFood объем тарелки
     */
    public Plate(int maxFood) {
        this.maxFood = maxFood;
        //При создании тарелки она полностью заполняется едой
        this.addFood(maxFood);
    }

    /**
     * Добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
     *
     * @param food количество еды
     */
    public void addFood(int food) {
        this.currentFood += food;
        if (this.currentFood > this.maxFood) {
            this.currentFood = this.maxFood;
        }
    }

    /**
     * Уменьшить количество еды в тарелке.
     * В тарелке не может оказаться отрицательное количество еды если удалось
     * уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае false
     *
     * @param food количество еды
     */
    public boolean decreaseFood(int food) {
        if (this.currentFood < food) {
            return false;
        } else {
            this.currentFood -= food;
            return true;
        }
    }

    /**
     * Получить текущее количество еды в тарелке.
     *
     * @return количество еды
     */
    public int getCurrentFood() {
        return this.currentFood;
    }
}
