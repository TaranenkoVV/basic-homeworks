package ru.taranenko.homeworks.homework16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class PhoneBook {
    private final Map<String, Set<String>> mapPhoneBook = new HashMap<>();

    //    Метод add() должен позволять добавлять запись имя-телефон;
    public void add(String name, String number) {
        Set<String> numbers = new HashSet<>();

        if (mapPhoneBook.containsKey(name)) {
            numbers = mapPhoneBook.get(name);
            mapPhoneBook.remove(name);
        }
        numbers.add(number);
        mapPhoneBook.put(name, numbers);
    }

    //    Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
    public Set<String> find(String name) {
        return mapPhoneBook.get(name);
    }

    //    Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
    public String containsPhoneNumber(String number) {
        String name = "";
        Set<String> numbers = null;

        for (Map.Entry<String, Set<String>> entry : mapPhoneBook.entrySet()) {
            numbers = entry.getValue();
            if(numbers.contains(number)) {
                name = entry.getKey();
                break;
            }
        }
        return name;
    }

    public void print() {
        String name = "";
        Set<String> numbers = null;

        for (Map.Entry<String, Set<String>> entry : mapPhoneBook.entrySet()) {
            name = entry.getKey();
            numbers = entry.getValue();

            System.out.println();
            System.out.println("Абонент: " + name);
            System.out.println("\tТелефоны: " + numbers);


        }
    }
}
