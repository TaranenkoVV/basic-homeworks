package ru.taranenko.homeworks.homework17;


public class MyLinkedList<T> implements CustomLinkedList<T> {

    public MyLinkedList() {
    }

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    static class Node<T> {

        T value;
        Node<T> previous;
        Node<T> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * добавляет элемент в начало списка, остальные сдвигаются вправо.
     *
     * @param data
     */
    @Override
    public boolean addFirst(T data) {
        Node<T> node = new Node<>();
        node.value = data;

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.previous = node;
            first = node;
        }
        size++;

        return true;
    }

    /**
     * добавляет элемент в конец списка.
     *
     * @param data
     * @return
     */
    @Override
    public boolean addLast(T data) {
        Node<T> node = new Node<>();
        node.value = data;

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        size++;

        return true;
    }

    /**
     * возвращает первый элемент списка.
     *
     * @return
     */
    @Override
    public T getFirst() {
        return first.value;
    }

    /**
     * возвращает последний элемент списка.
     *
     * @return
     */
    @Override
    public T getLast() {
        return last.value;
    }

    /**
     * вставляет элемент на позицию с номером position, остальные элементы сдвигаются вправо.
     *
     * @param position
     * @param data
     * @return
     */
    @Override
    public boolean add(int position, T data) {
        if(position == 0) {
            return addFirst(data);

        } else if (position == size) {
            return addLast(data);

        } else {
            if (size != 0) {
                Node<T> current = first;
                int currentIndex = 0;
                while (current != null) {
                    if (currentIndex == position) {

                        Node<T> newItem = new Node<>();
                        newItem.value = data;

                        Node<T> prevItem = current;
                        Node<T> nextItem = current.next;

                        newItem.next = prevItem.next;
                        prevItem.next = newItem;

                        newItem.previous = nextItem.previous;
                        nextItem.previous = newItem;

                        size++;
                        return true;

                    }
                    current = current.next;
                    currentIndex++;
                }
            }
        }
        return false;
    }

    /**
     * удаляет элемент с номером position.
     *
     * @param position
     * @return
     */
    @Override
    public T remove(int position) {
        if (size != 0) {
            Node<T> current = first;
            int currentIndex = 0;
            while (current != null) {
                if (currentIndex == position) {

                    Node<T> prevItem = null;
                    Node<T> nextItem = null;

                    // если это первый элемент
                    if (current.previous == null) {

                        nextItem = current.next;
                        if(nextItem != null) {
                            nextItem.previous = current.previous;
                        } else {
                            nextItem = null;
                            last = nextItem;
                        }
                        first = nextItem;

                        current.next = null;
                        size--;
                        return current.value;

                    } else if (current.next == null) {

                        // если это последний элемент
                        prevItem = current.previous;
                        prevItem.next = current.next;
                        last = prevItem;

                        current.previous = null;
                        size--;
                        return current.value;

                    } else {

                        // если это элемент в середине списка
                        prevItem = current.previous;
                        nextItem = current.next;

                        prevItem.next = nextItem;
                        nextItem.previous = prevItem;

                        current.previous = null;
                        current.next = null;
                        size--;
                        return current.value;
                    }
                }
                current = current.next;
                currentIndex++;
            }
        }
        return null;
    }

    /**
     * возвращает элемент с номером posiion.
     *
     * @param position
     * @return
     */
    @Override
    public T get(int position) {

        if (size != 0) {
            Node<T> current = first;
            int currentIndex = 0;
            while (current != null) {
                if (currentIndex == position) {
                    return current.value;
                }
                current = current.next;
                currentIndex++;
            }
        }
        return null;
    }

    /**
     * возвращает количество элементов в списке.
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void printItems() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println("индекс: " + i + "  элемент: " + this.get(i));
        }
    }
}
