import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void getListAvailableBuns() {
        String message = "При проверке метода availableBuns() класса Database получено некорректное значение";
        Database database = new Database();
        int expectedCountBuns = 3;
        int actualCountBuns = database.availableBuns().size();
        assertEquals(message, expectedCountBuns, actualCountBuns);
    }

    @Test
    public void getListAvailableIngredients() {
        String message = "При проверке метода availableIngredients() класса Database получено некорректное значение";
        Database database = new Database();
        int expectedCountIngredients = 6;
        int actualCountIngredients = database.availableIngredients().size();
        assertEquals(message, expectedCountIngredients, actualCountIngredients);
    }
}
