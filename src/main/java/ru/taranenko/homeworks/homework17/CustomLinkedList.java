package ru.taranenko.homeworks.homework17;

public interface CustomLinkedList<T> {

    int size();
    boolean isEmpty();

    /**
     * добавляет элемент в начало списка, остальные сдвигаются вправо.
     *
     * @param data
     */
    boolean addFirst(T data);

    /**
     * добавляет элемент в конец списка.
     *
     * @param data
     * @return
     */
    boolean addLast(T data);

    /**
     * возвращает первый элемент списка.
     *
     * @return
     */
    T getFirst();

    /**
     * возвращает последний элемент списка.
     *
     * @return
     */
    T getLast();

    /**
     *  вставляет элемент на позицию с номером position, остальные элементы сдвигаются вправо.
     *
     * @param position
     * @param data
     * @return
     */
    boolean add(int position, T data);

    /**
     *  удаляет элемент с номером position.
     *
     * @param position
     * @return
     */
    T remove(int position);

    /**
     *  возвращает элемент с номером posiion.
     *
     * @param position
     * @return
     */
    T get(int position);

    /**
     *  возвращает количество элементов в списке.
     *
     * @return
     */
    int getSize();

    void printItems();
}
