import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class BurgerTest {
/*
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
*/
    @Test
    public void checkSetBuns(){
        String message = "Для метода setBuns() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        assertNotNull(message, burger.bun);
    }

    @Test
    public void checkAddIngredient(){
        String message = "Для метода addIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        int expectedSizeListIngredients = burger.ingredients.size() + 1;
        burger.addIngredient(ingredient);
        int actualSizeListIngredients = burger.ingredients.size();
        assertEquals(message, expectedSizeListIngredients, actualSizeListIngredients);
    }

    @Test
    public void checkRemoveIngredient(){
        String message = "Для метода removeIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.ingredients.add(ingredient);
        int expectedSizeListIngredients = burger.ingredients.size() - 1;
        burger.removeIngredient(burger.ingredients.size() - 1);
        int actualSizeListIngredients = burger.ingredients.size();
        assertEquals(message, expectedSizeListIngredients, actualSizeListIngredients);
    }
}
