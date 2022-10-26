package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IngredientTypeTest {
    private static final String FILLING = "FILLING";
    private static final String SAUCE = "SAUCE";
    private static final String[] INGREDIENT_ARRAY = {"SAUCE", "FILLING"};

    @Test
    public void values() {
        IngredientType[] ingredientTypes = IngredientType.values();
        Assert.assertEquals(Arrays.toString(INGREDIENT_ARRAY), Arrays.toString(ingredientTypes));
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf(FILLING));
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf(SAUCE));
    }
}