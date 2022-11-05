package praktikum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */

@Getter
@AllArgsConstructor
public class Ingredient {
    private IngredientType type;
    private String name;
    private float price;
}