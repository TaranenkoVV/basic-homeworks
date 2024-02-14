package ru.taranenko.homeworks.homework27;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box<T> implements Comparable<Box> {

    //имя коробки
    private String name;

    //содержимое коробки
    private List<T> content; // = new ArrayList<T>();

    public List<? extends Fruit> getContent() {
        return (List<? extends Fruit>) content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Box(String name) {
        this.name = name;
    }

    public Box(String name, List<T> content) {
        this.name = name;
        this.content = content;
    }

    public void addContent(T t) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(t);
    }

    //метод расчета веса фруктов в коробке, для использования в методе compareTo
    public double calcWeight(List<? extends Fruit> in) {
        double result = 0.0;
        for (int i = 0; i < in.size(); i++) {
            result += in.get(i).getWeight();
        }
        return result;
    }

    public boolean compare(Box another) {
        if (this.compareTo(another) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Box another) {
        if (abs((this.calcWeight(this.getContent()) - another.calcWeight(another.getContent()))) < 0.001) {
            return 0;
        }
        if (this.calcWeight(this.getContent()) < another.calcWeight(another.getContent())) {
            return -1;
        } else {
            return 1;
        }
    }


    public boolean moveContentInto(Box another) {
        boolean result = false;

        result = another.getContent().addAll(this.getContent());

        if (result) {
            System.out.println("Успешно пересыпали");
            for (int i = content.size() - 1; i >= 0; i--) {
                content.remove(i);
            }
        } else {
            System.out.println("Нельзя пересыпать");
        }
        return result;
    }

}
