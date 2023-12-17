package ru.taranenko.homeworks.homework17;

public class MyStack<T> extends MyLinkedList<T> {

    /**
     * помещающает элемент в стек
     *
     * @param data
     * @return
     */
    public boolean push(T data) {
        return super.addFirst(data);
    }

    /**
     * достает элемент из стека
     *
     * @return
     */
    public T pop() {
        T firstNode = super.getFirst();
        super.remove(0);
        return firstNode;
    }

}
