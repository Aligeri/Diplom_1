package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static util.TestData.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][] {
                {IngredientType.FILLING, CHEESE_NAME, CHEESE_PRICE},
                {IngredientType.SAUCE, INGREDIENT_SAUCE_SPACE, INGREDIENT_SAUCE_SPACE_PRICE},
        };
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(INGREDIENT_ERROR, type, ingredient.getType());
    }
}