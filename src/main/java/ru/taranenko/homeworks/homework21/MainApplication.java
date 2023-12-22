package ru.taranenko.homeworks.homework21;

public class MainApplication {

    final static int COUNT_ITEMS = 100000000;
    final static int COUNT_STEP = 25000000;
    private double[] array;

    public MainApplication() {
        array = new double[COUNT_ITEMS];
    }

    public static void main(String[] args) throws InterruptedException {
        MainApplication app = new MainApplication();
        app.run();
    }

    public void run() throws InterruptedException {
        fillArrayInOneThread();
        fillArrayInManyThread();
    }

    public void fillArrayInOneThread() {
        System.out.println();
        System.out.println("Заполнение массива в одном потоке");

        long time = System.currentTimeMillis();
        fillArray(0, COUNT_ITEMS);
        System.out.println(" время работы 1 потока, мс = " + (System.currentTimeMillis() - time));
    }

    public void fillArrayInManyThread() throws InterruptedException {
        System.out.println();
        System.out.println("Заполнение массива в нескольких потоках");

        Thread t1 = new Thread(() -> fillArray(0, COUNT_STEP));
        Thread t2 = new Thread(() -> fillArray((1 * COUNT_STEP) + 1, (2 * COUNT_STEP)));
        Thread t3 = new Thread(() -> fillArray((2 * COUNT_STEP) + 1, (3 * COUNT_STEP)));
        Thread t4 = new Thread(() -> fillArray((3 * COUNT_STEP)+1, COUNT_ITEMS));

        long time = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println(" время работы 4 потоков, мс = " + (System.currentTimeMillis() - time));
    }

    public void fillArray(int min, int max) {
        for (int i = min; i < max; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}

