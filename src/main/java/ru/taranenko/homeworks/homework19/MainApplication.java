package ru.taranenko.homeworks.homework19;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApplication {

    private static void title() {
        System.out.println();
        System.out.println("HomeWork19 к уроку Lesson19");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
        System.out.println();
    }

    public static void main(String[] args) {
        title();

        String workingDirectory = System.getProperty("user.dir");
        System.out.println("Корневой каталог проекта: " + workingDirectory);

        Scanner scanner = new Scanner(System.in);
        String fileName = "";
        while (fileName.equals("")) {
            System.out.println();
            printTxtFiles(workingDirectory);

            System.out.println();
            System.out.print("Введите имя файла для обработки: ");
            fileName = scanner.nextLine();

            if (!(new File(workingDirectory + "\\" + fileName).exists())) {
                System.out.println("Файл не найден: " + fileName);
                fileName = "";
            }
        }

        System.out.println();
        System.out.println("Содержимое файла " + fileName);
        readFromFile(fileName);

        System.out.println();
        System.out.print("Введите строчку для добавления в файл: ");
        String addString = scanner.nextLine();

        System.out.println();
        System.out.println("Добавление строки в файл..");
        addStringToFile(fileName, addString);

        System.out.println();
        System.out.println("Новое содержимое файла " + fileName);
        readFromFile(fileName);
    }

    public static void printTxtFiles(String workingDirectory) {
        System.out.println("Список текстовых файлов(*.txt) в каталоге:");
        String fileExt = ".txt";
        File folder = new File(workingDirectory);
        File[] listOfFiles = folder.listFiles(new MyFileNameFilter(fileExt));
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    // Реализация интерфейса FileNameFilter
    public static class MyFileNameFilter implements FilenameFilter {

        private String ext;

        public MyFileNameFilter(String ext) {
            this.ext = ext.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }

    public static void readFromFile(String fileName) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addStringToFile(String fileName, String addString) {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            byte[] buffer = addString.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
