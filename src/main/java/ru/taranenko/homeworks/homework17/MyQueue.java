package ru.taranenko.homeworks.homework17;

/**
 * Класс очередь.
 *
 * @param <T>
 */
public class MyQueue<T> extends MyLinkedList<T> {

    /**
     * добавляет элемент в очередь.
     *
     * @param data
     * @return
     */
    public void offer(T data) {
       boolean result = super.addFirst(data);
    }

    /**
     * забирает элемент из очереди
     * @return
     */
    public T poll() {
        T lastNode = super.getLast();
        super.remove(super.getSize() - 1);
        return lastNode;
    }
}
