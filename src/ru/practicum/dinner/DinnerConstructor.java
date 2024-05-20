package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();

    public void saveDishByType(String dishType, String dishName) {
        if (checkType(dishType)) {
            ArrayList<String> dishesList = dishesByType.get(dishType);
            dishesList.add(dishName);
        } else {
            ArrayList<String> dishesList = new ArrayList<>();
            dishesList.add(dishName);
            dishesByType.put(dishType, dishesList);
        }
    }

    public void comboGenerator(int numbersOfCombos, ArrayList<String> userTypes) {
        Random random = new Random();
        if (dishesByType.isEmpty()) {
            return;
        }
        for (int i = 0; i < numbersOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.print("[");
            for (int j = 0; j < userTypes.size(); j++) {
                int randomDishIndex = random.nextInt(dishesByType.get(userTypes.get(j)).size());
                if (j == userTypes.size() - 1) {
                    String dishGeneratedByType = dishesByType.get(userTypes.get(j)).get(randomDishIndex);
                    System.out.print(dishGeneratedByType);
                } else {
                    String dishGeneratedByType = dishesByType.get(userTypes.get(j)).get(randomDishIndex);
                    System.out.print(dishGeneratedByType + ", ");
                }
            }
            System.out.println("]");
        }
    }

    public Boolean checkType(String dishType) {
        boolean isTypeExist = false;
        if (dishesByType.containsKey(dishType)) {
            isTypeExist = true;
        }
        return isTypeExist;
    }

}
