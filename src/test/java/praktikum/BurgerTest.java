package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import util.Generator;

import java.util.List;
import java.util.Random;

import static util.TestData.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private static final Random RANDOM = new Random();
    private static final Ingredient INGREDIENT_TEST1 = new Ingredient(IngredientType.SAUCE, INGREDIENT_SAUCE_SPACE, 80);
    private static final Ingredient INGREDIENT_TEST2 = new Ingredient(IngredientType.SAUCE, INGREDIENT_SAUCE_TRADITIONAL, 15);
    private static final Ingredient INGREDIENT_TEST3 = new Ingredient(IngredientType.SAUCE, INGREDIENT_SAUCE_SPIKE, 88);
    private static final List<Burger> BURGER_LIST = Generator.getBurgerList();
    private static Burger burger;

    private void setUp() {
        burger = BURGER_LIST.get(RANDOM.nextInt(BURGER_LIST.size() - 1));
        burger.getIngredients().clear();

        burger.addIngredient(INGREDIENT_TEST1);
        burger.addIngredient(INGREDIENT_TEST2);
        burger.addIngredient(INGREDIENT_TEST3);
    }

    @Test
    public void addIngredient() {
        setUp();

        Assert.assertTrue(burger.getIngredients().contains(INGREDIENT_TEST1));
        Assert.assertTrue(burger.getIngredients().contains(INGREDIENT_TEST2));
        Assert.assertTrue(burger.getIngredients().contains(INGREDIENT_TEST3));
    }

    @Test
    public void removeIngredient() {
        setUp();
        Assert.assertEquals(3, burger.getIngredients().size());
        burger.removeIngredient(0);
        Assert.assertTrue(burger.getIngredients().contains(INGREDIENT_TEST2));
        Assert.assertTrue(burger.getIngredients().contains(INGREDIENT_TEST3));
    }

    @Test
    public void moveIngredient() {
        setUp();
        burger = BURGER_LIST.get(RANDOM.nextInt(BURGER_LIST.size() - 1));
        List<Ingredient> ingredientList = burger.getIngredients();
        Ingredient oldIndex1 = ingredientList.get(1);
        Ingredient oldIndex2 = ingredientList.get(2);

        burger.moveIngredient(2, 1);
        Assert.assertEquals(burger.getIngredients().get(2), oldIndex1);
        Assert.assertEquals(burger.getIngredients().get(1), oldIndex2);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();

        burger.setBun(bun);

        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(CRATOR_BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(CHEESE_PRICE);

        Assert.assertEquals(BURGER_ERROR, CRATOR_BUN_PRICE * 2 + CHEESE_PRICE, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();

        burger.setBun(bun);

        Ingredient ingredientSauce = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientSauce);

        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(CRATOR_BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(CRATOR_BUN_PRICE);

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn(INGREDIENT_SAUCE_SPACE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(INGREDIENT_SAUCE_SPACE_PRICE);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn(CHEESE_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(CHEESE_PRICE);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (var ingredient : burger.getIngredients()) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }
}