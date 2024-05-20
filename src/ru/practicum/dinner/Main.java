package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
//        System.out.println("Введите тип блюда:");
//        String dishType = scanner.nextLine();
//        System.out.println("Введите название блюда:");
//        String dishName = scanner.nextLine();
//
//        //dc.saveDishByType(dishType, dishName);// добавьте новое блюдо

        ArrayList<String> type1 = new ArrayList<>();
        type1.add("Грибной суп");
        type1.add("Борщ");
        type1.add("Молочный суп");
        type1.add("Рассольник");
        type1.add("Суп с фрикадельками");
        type1.add("Суп без фрикаделек");
        dc.dishesByType.put("Первое", type1);

        ArrayList<String> type2 = new ArrayList<>();
        type2.add("Котлета");
        type2.add("Отбивная");
        type2.add("Макароны");
        type2.add("Картошка");
        type2.add("Рис");
        type2.add("Греча");
        dc.dishesByType.put("Второе", type2);

        ArrayList<String> type3 = new ArrayList<>();
        type3.add("Сок");
        type3.add("Кола");
        type3.add("Спрайт");
        type3.add("Чай");
        type3.add("Кофе");
        type3.add("Молоко");
        dc.dishesByType.put("Напиток", type3);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> userTypes = new ArrayList<>();



//        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if(dc.dishesByType.containsKey(nextItem)) {
                if (!userTypes.contains(nextItem)) {
                    userTypes.add(nextItem);
                }
                nextItem = scanner.nextLine();
            } else {
                System.out.println("Такого типа блюд нет. Введите другой тип:");
                nextItem = scanner.nextLine();
            }
        }
        dc.comboGenerator(numberOfCombos, userTypes);

        // сгенерируйте комбинации блюд и выведите на экран

    }
}
