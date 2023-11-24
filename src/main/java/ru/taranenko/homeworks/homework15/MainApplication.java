package ru.taranenko.homeworks.homework15;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    private static void title() {
        System.out.println();
        System.out.println("HomeWork15 к уроку Lesson15");
        System.out.println("Тараненко Вячеслав");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        title();

        System.out.println("1. Создан список с элементами от 0 до 10");
        List<Integer> list01 = getArrayListMinMax(0, 10);
        System.out.println(list01);

        System.out.println();
        System.out.println("2. Сумма элементов списка из п.1, значение которых больше 5 = ");
        System.out.println(getSumItems(list01));

        System.out.println();
        System.out.println("3. Запись в каждую заполненную ячейку списка числа = 7");
        fillItems(7, list01);
        System.out.println(list01);

        System.out.println();
        System.out.println("4. Увеличение каждого элемента списка на число = 2");
        addNumToItems(2, list01);
        System.out.println(list01);

        System.out.println();
        System.out.println("5. Создан список сотрудников");
        List<Employee> employeeList = new ArrayList<>();
        fillEmployeeList(employeeList);
        printEmployeeList(employeeList);

        System.out.println();
        System.out.println("6. метод, принимающий в качестве аргумента список сотрудников, "
                + "и возвращающий список их имен");
        List<String> listEmployeeNames = getListEmployeeNames(employeeList);
        System.out.println(listEmployeeNames);

        System.out.println();
        System.out.println("7. метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,");
        System.out.println(
                "   и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу=30");
        List<Employee> listEmployeeAge = getListEmployeeAge(employeeList, 30);
        printEmployeeList(listEmployeeAge);

        System.out.println();
        System.out.println(
                "7. метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст,");
        System.out.println("   и проверяющий что средний возраст сотрудников превышает указанный аргумент");
        checkAverageAgeEmployees(employeeList, 20);
        checkAverageAgeEmployees(employeeList, 40);

        System.out.println();
        System.out.println(
                "8. метод, принимающий в качестве аргумента список сотрудников,");
        System.out.println("   и возвращающий ссылку на самого молодого сотрудника");
        Employee youngestEemployee = getYoungestEemployee(employeeList);
        System.out.println("Самый молодой сотрудник: " + youngestEemployee.toString());
    }

    public static List<Integer> getArrayListMinMax(int min, int max) {
        List<Integer> newListMinMax = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            newListMinMax.add(i);
        }
        return newListMinMax;
    }

    public static int getSumItems(List<Integer> list) {
        int result = 0;
        for (Integer items : list) {
            if (items.intValue() > 5) {
                result += items.intValue();
            }
        }
        return result;
    }

    public static void fillItems(int num, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, num);
        }
    }

    public static void addNumToItems(int num, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, num + list.get(i));
        }
    }

    public static void fillEmployeeList(List<Employee> employeeList) {
        employeeList.add(new Employee("Иван", 20));
        employeeList.add(new Employee("Анна", 25));
        employeeList.add(new Employee("Виктор", 30));
        employeeList.add(new Employee("Елена", 35));
        employeeList.add(new Employee("Михаил", 40));
    }

    public static void printEmployeeList(List<Employee> employeeList) {
        String s = "[";
        for (int i = 0; i < employeeList.size(); i++) {
            if (s.equals("[")) {
                s = s + employeeList.get(i).toString();
            } else {
                s = s + ", " + employeeList.get(i).toString();
            }
        }
        s += "]";
        System.out.println(s);
    }

    public static List<String> getListEmployeeNames(List<Employee> employeeList) {
        List<String> newListEmployeeNames = new ArrayList<>();
        for (Employee employee : employeeList) {
            newListEmployeeNames.add(employee.name);
        }
        return newListEmployeeNames;
    }

    public static List<Employee> getListEmployeeAge(List<Employee> employeeList, int age) {
        List<Employee> newListEmployeeAge = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.age >= age) {
                newListEmployeeAge.add(employee);
            }
        }
        return newListEmployeeAge;
    }

    public static void checkAverageAgeEmployees(List<Employee> employeeList, int averageAge) {
        int currentAverageAge = 0;
        if (employeeList.size() == 0) {
            System.out.println("список сотрудников пустой");
            return;
        }
        for (Employee employee : employeeList) {
            currentAverageAge += employee.age;
        }
        currentAverageAge = (int) currentAverageAge / employeeList.size();

        if (currentAverageAge > averageAge) {
            System.out.println("средний возраст сотрудников превышает " + averageAge);
        } else {
            System.out.println("средний возраст сотрудников меньше чем: " + averageAge);
        }
    }

    public static Employee getYoungestEemployee(List<Employee> employeeList) {
        int minAge = 0;
        Employee youngestEemployee = null;
        for (Employee employee : employeeList) {
            if (minAge == 0 || employee.age < minAge) {
                minAge = employee.age;
                youngestEemployee = employee;
            }
        }
        return youngestEemployee;
    }
}