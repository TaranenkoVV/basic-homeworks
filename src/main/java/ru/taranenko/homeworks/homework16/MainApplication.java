package ru.taranenko.homeworks.homework16;

import java.util.Map;
import java.util.Set;

public class MainApplication {

    private static void title() {
        System.out.println();
        System.out.println("HomeWork16 к уроку Lesson16");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        title();

        PhoneBook myPhoneBook = new PhoneBook();

        // Метод add() должен позволять добавлять запись имя-телефон;
        myPhoneBook.add("Виктор", "8-901-11-11-111");
        myPhoneBook.add("Виктор", "8-901-11-11-112");
        myPhoneBook.add("Виктор", "8-901-11-11-113");
        myPhoneBook.add("Иван", "8-901-11-11-200");
        myPhoneBook.add("Иван", "8-901-11-11-300");
        myPhoneBook.add("Ольга", "8-901-11-11-500");

        System.out.println();
        System.out.println("Список всех номеров в телефонной книге:");
        myPhoneBook.print();

        // Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
        System.out.println();
        System.out.println("1 - поиск номер(-а, -ов) телефона по имени:");
        String name;
        name = "Иван";
        searchByName(myPhoneBook, name);
        name = "Глеб";
        searchByName(myPhoneBook, name);


        // Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
        System.out.println();
        System.out.println("2 - проверка наличия телефона в справочнике:");
        String number;

        number = "8-901-11-11-113";
        searchByNumber(myPhoneBook, number);

        number = "8-901-11-11-115";
        searchByNumber(myPhoneBook, number);

    }

    public static void searchByName(PhoneBook phoneBook, String name) {
        String foundName;
        System.out.println();
        System.out.println("поиск телефонов абонента: " + name);

        Set<String> numbers = phoneBook.find(name);
        if (numbers == null) {
            System.out.println("У абонента нет телефонных номеров.");
        } else {
            System.out.println("У абонента есть телефонные номера:");
            System.out.println(numbers);
        }

    }

    public static void searchByNumber(PhoneBook phoneBook, String number) {
        String foundName;
        System.out.println();
        System.out.println("поиск номера: " + number);

        foundName = phoneBook.containsPhoneNumber(number);
        if (foundName.equals("")) {
            System.out.println("номер не найден");
        } else {
            System.out.println("номер принадлежит - " + foundName);
        }
    }




}
