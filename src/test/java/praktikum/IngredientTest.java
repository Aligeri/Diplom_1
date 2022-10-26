package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private static final Ingredient INGREDIENT_SAUCE_CORRECT = new Ingredient(SAUCE, "Сычуаньский", 5.5f);
    private static final Ingredient INGREDIENT_FILLING_CORRECT = new Ingredient(FILLING, "Котлета", 22.7f);
    private static final Ingredient INGREDIENT_NULL = new Ingredient(null, null, 0);

    @Test
    public void getPriceCorrect() {
        Assert.assertEquals(5.5f, INGREDIENT_SAUCE_CORRECT.getPrice(), 0);
        Assert.assertEquals(22.7f, INGREDIENT_FILLING_CORRECT.getPrice(), 0);
    }

    @Test
    public void getPriceNull() {
        Assert.assertEquals(0, INGREDIENT_NULL.getPrice(), 0);
    }

    @Test
    public void getNameCorrect() {
        Assert.assertEquals("Сычуаньский", INGREDIENT_SAUCE_CORRECT.getName());
        Assert.assertEquals("Котлета", INGREDIENT_FILLING_CORRECT.getName());
    }

    @Test
    public void getNameNull() {
        Assert.assertNull("У ингредиента есть имя", INGREDIENT_NULL.getName());
    }

    @Test
    public void getTypeCorrect() {
        Assert.assertEquals(SAUCE, INGREDIENT_SAUCE_CORRECT.getType());
        Assert.assertEquals(FILLING, INGREDIENT_FILLING_CORRECT.getType());
    }

    @Test
    public void getTypeNull() {
        Assert.assertNull("У ингредиента есть тип", INGREDIENT_NULL.getType());
    }
}