import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getNameIngredient() {
        String message = "Для метода getName() класса Ingredient получено некорректное значение";
        String expectedNameIngredient = RandomStringUtils.randomAlphabetic(10);
        float priceIngredient = new Random().nextFloat();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, expectedNameIngredient, priceIngredient);
        String actualNameIngredient = ingredient.getName();
        assertEquals(message, expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void getPriceIngredient() {
        String message = "Для метода getPrice() класса Ingredient получено некорректное значение";
        String nameIngredient = RandomStringUtils.randomAlphabetic(10);
        float expectedPriceIngredient = new Random().nextFloat();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, nameIngredient, expectedPriceIngredient);
        float actualPriceIngredient = ingredient.getPrice();
        assertEquals(message, expectedPriceIngredient, actualPriceIngredient, 0.0f);
    }

    @Test
    public void getTypeSauceIngredient() {
        String expectedType = "SAUCE";
        String message = "Для метода getType() класса Ingredient для соуса получено некорректное значение";
        String nameIngredient = RandomStringUtils.randomAlphabetic(10);
        float priceIngredient = new Random().nextFloat();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, nameIngredient, priceIngredient);
        String actualTypeIngredient = ingredient.getType().toString();
        assertEquals(message, expectedType, actualTypeIngredient);
    }

    @Test
    public void getTypeFillingIngredient() {
        String expectedType = "FILLING";
        String message = "Для метода getType() класса Ingredient для начинки получено некорректное значение";
        String nameIngredient = RandomStringUtils.randomAlphabetic(10);
        float priceIngredient = new Random().nextFloat();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, nameIngredient, priceIngredient);
        String actualTypeIngredient = ingredient.getType().toString();
        assertEquals(message, expectedType, actualTypeIngredient);
    }
}
