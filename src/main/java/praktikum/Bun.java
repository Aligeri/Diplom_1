package praktikum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */

@Getter
@AllArgsConstructor
public class Bun {
    private String name;
    private float price;
}