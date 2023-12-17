package ru.taranenko.homeworks.homework17;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.sound.midi.Soundbank;

public class MainApplication {

    private static void title() {
        System.out.println();
        System.out.println("HomeWork17 к уроку Lesson17");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        title();

        // --------------------------
        System.out.println();
        System.out.println("1. Работа с MyLinkedList");
        CustomLinkedList<String> list = new MyLinkedList<>();
        list.addLast("01");
        list.addLast("02");
        list.addLast("03");
        System.out.println("добавили в MyLinkedList элементы:");
        System.out.println("размер MyLinkedList = " + list.getSize());
        System.out.println("элементы в MyLinkedList:");
        list.printItems();

        System.out.println("удаляем элемент с индексом = 1");
        list.remove(1);
        System.out.println("размер MyLinkedList = " + list.getSize());
        System.out.println("Остались элементы:");
        list.printItems();

        // --------------------------
        System.out.println();
        System.out.println("2. Работа с очередью");
        MyQueue<String> queue = new MyQueue<>();
        queue.offer("q01");
        queue.offer("q02");
        queue.offer("q03");
        System.out.println("добавили в очередь элементы:");
        System.out.println("размер очереди = " + queue.getSize());
        System.out.println("элементы в очереди :");
        queue.printItems();

        System.out.println("забираем элементы из очереди:");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("размер очереди = " + queue.getSize());

        // --------------------------
        System.out.println();
        System.out.println("3. Работа со стеком");
        MyStack<String> stack = new MyStack<>();
        stack.push("s01");
        stack.push("s02");
        stack.push("s03");
        System.out.println("поместили в стек элементы:");
        System.out.println("размер стека = " + stack.getSize());
        System.out.println("элементы в стеке :");
        stack.printItems();

        System.out.println("достаем элементы из стека:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("размер стека = " + stack.getSize());


        // --------------------------
        System.out.println();
        System.out.println("4. Сортировка массива методом QuickSort");
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int[] newArray = new int[array.length];

        newArray = sort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(newArray));
    }

    public static int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Выбор среднего элемента в качестве опорного
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Обмен опорного элемента с последним
        int temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
