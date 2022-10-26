package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final Random RANDOM = new Random();

    private static final List<Burger> BURGER_LIST = Generator.getBurgerList();
    private static List<Ingredient> ingredients = new ArrayList<>();
    @Mock Burger burger;
    @Mock Bun bun;
    @Mock Ingredient ingredient;

    public void cleanAndAdd10Ingredients() {
        ingredients.clear();
        for (int i = 0; i < 10; i++) {
            ingredients.add(Generator.getRandomIngredient());
        }
    }

    @Test
    public void addIngredient() {
        cleanAndAdd10Ingredients();
        Assert.assertEquals(10, ingredients.size());
    }

    @Test
    public void removeOneIngredient() {
        cleanAndAdd10Ingredients();
        ingredients.remove(0);

        Assert.assertEquals(9, ingredients.size());
    }

    @Test
    public void removeIngredient() {
        cleanAndAdd10Ingredients();
        ingredients.add(Generator.getRandomIngredient());
        ingredients.remove(0);
        ingredients.remove(9);
        ingredients.remove(7);
        Assert.assertEquals(8, ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger = BURGER_LIST.get(RANDOM.nextInt(BURGER_LIST.size()-1));
        List<Ingredient> ingredientList = burger.getIngredients();
        Ingredient oldIndex1 = ingredientList.get(1);
        Ingredient oldIndex2 = ingredientList.get(2);

        burger.moveIngredient(2, 1);
        Assert.assertEquals(burger.getIngredients().get(2), oldIndex1);
        Assert.assertEquals(burger.getIngredients().get(1), oldIndex2);
    }

    @Test
    public void getPrice() {
        burger = BURGER_LIST.get(RANDOM.nextInt(BURGER_LIST.size()-1));

        float result = burger.getBun().getPrice() * 2;
        for (Ingredient i : burger.getIngredients()) {
            result += i.getPrice();
        }
        Assert.assertEquals(result, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();

        burger.setBun(bun);

        Ingredient ingredientSauce = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientSauce);

        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("chili sauce");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(300f);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (var ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }
}