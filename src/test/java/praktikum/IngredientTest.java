package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static util.TestData.*;

public class IngredientTest {
    private static final Ingredient INGREDIENT_SAUCE_CORRECT = new Ingredient(SAUCE, INGREDIENT_SAUCE_SPACE, 80);
    private static final Ingredient INGREDIENT_FILLING_CORRECT = new Ingredient(FILLING, INGREDIENT_FILLING_MAGNOLIA, 424);
    private static final Ingredient INGREDIENT_NULL = new Ingredient(null, null, 0);

    @Test
    public void getPriceCorrect() {
        Assert.assertEquals(80, INGREDIENT_SAUCE_CORRECT.getPrice(), DELTA);
        Assert.assertEquals(424, INGREDIENT_FILLING_CORRECT.getPrice(), DELTA);
    }

    @Test
    public void getPriceNull() {
        Assert.assertEquals(0, INGREDIENT_NULL.getPrice(), DELTA);
    }

    @Test
    public void getNameCorrect() {
        Assert.assertEquals(INGREDIENT_SAUCE_SPACE, INGREDIENT_SAUCE_CORRECT.getName());
        Assert.assertEquals(INGREDIENT_FILLING_MAGNOLIA, INGREDIENT_FILLING_CORRECT.getName());
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