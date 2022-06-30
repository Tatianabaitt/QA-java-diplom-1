import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void getListAvailableBuns() {
        List<Bun> expectedBuns = new ArrayList<>();
        expectedBuns.add(new Bun("black bun", 100));
        expectedBuns.add(new Bun("white bun", 200));
        expectedBuns.add(new Bun("red bun", 300));
        String message = "При проверке метода availableBuns() класса Database получено некорректное значение";
        Database database = new Database();
        int expectedCountBuns = expectedBuns.size();
        int actualCountBuns = database.availableBuns().size();
        assertEquals(message, expectedCountBuns, actualCountBuns);
        for (int i = 0; i < database.availableBuns().size(); i++) {
            assertEquals(database.availableBuns().get(i), expectedBuns.get(i));
        }
    }

    @Test
    public void getListAvailableIngredients() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
        String message = "При проверке метода availableIngredients() класса Database получено некорректное значение";
        Database database = new Database();
        int expectedCountIngredients = expectedIngredients.size();
        int actualCountIngredients = database.availableIngredients().size();
        assertEquals(message, expectedCountIngredients, actualCountIngredients);
        for (int i = 0; i < database.availableIngredients().size(); i++) {
            assertEquals(database.availableIngredients().get(i), expectedIngredients.get(i));
        }
    }
}
