import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final boolean expected;

    public IngredientParametrizedTest(Ingredient ingredient1, Ingredient ingredient2, boolean expected) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}") // добавили аннотацию
    public static Object[][] getIngredients() {
        Ingredient ingredient;
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "hot sauce", 100), new Ingredient(IngredientType.SAUCE, "hot sauce", 100), true},
                {new Ingredient(IngredientType.SAUCE, "hot sauce", 100), new Ingredient(IngredientType.SAUCE, "sour cream", 100), false},
                {new Ingredient(IngredientType.SAUCE, "hot sauce", 100), new Ingredient(IngredientType.FILLING, "hot sauce", 100), false},
                {new Ingredient(IngredientType.SAUCE, "hot sauce", 100), new Ingredient(IngredientType.SAUCE, "hot sauce", 300), false},
                {new Ingredient(IngredientType.SAUCE, "hot sauce", 100), null, false},
                {ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100), ingredient, true},
        };
    }

    @Test
    public void checkEqualsIngredients() {
        String message = "Для метода equals() класса Bug получено некорректное значение";
        assertEquals(message, ingredient1.equals(ingredient2), expected);
    }
}