package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();

    public void saveDishByType (String dishType, String dishName) {
        if (checkType(dishType)) {
            ArrayList<String> dishesList = dishesByType.get(dishType);
            dishesList.add(dishName);
        } else {
            ArrayList<String> dishesList = new ArrayList<>();
            dishesList.add(dishName);
            dishesByType.put(dishType, dishesList);
        }
    }

    public Boolean checkType(String type) {
        boolean isTypeExist = false;
        if (dishesByType.containsKey(type)) {
            isTypeExist = true;
        }
        return isTypeExist;
    }

}
