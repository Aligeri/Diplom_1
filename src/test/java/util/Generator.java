package util;

import lombok.experimental.UtilityClass;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class Generator {
    private static final Random RANDOM = new Random();
    public static String getRandomString(){
        final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static Ingredient getRandomIngredient() {
        List<Ingredient> ingredients = new LinkedList<>();
        IngredientType[] ingredientTypes = IngredientType.values();

        for (int i = 0; i < 99; i++) {
            ingredients.add
                    (new Ingredient(ingredientTypes[RANDOM.nextInt(2)],
                            getRandomString(), RANDOM.nextFloat()));
        }
        return ingredients.get(RANDOM.nextInt(99));
    }

    public static List<Burger> getBurgerList() {
        List<Burger> burgerList = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            burgerList.add(new Burger());
            burgerList.get(i).setBun(new Bun(getRandomString(), RANDOM.nextFloat()));

            for (int j = 0; j < 9; j++) {
                ingredients.add(getRandomIngredient());
            }
            burgerList.get(i).setIngredients(ingredients);
        }
        return burgerList;
    }
}