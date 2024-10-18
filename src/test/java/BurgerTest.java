import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class BurgerTest {

    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient0;
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(567.0F);
        Mockito.when(ingredient0.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient0.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient0.getPrice()).thenReturn(100F);
        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        Mockito.when(ingredient1.getPrice()).thenReturn(300.1F);
        Mockito.when(ingredient2.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient2.getPrice()).thenReturn(999.13F);
    }

    @Test
    public void checkSetBuns() {
        String message = "Для метода setBuns() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(message, burger.bun, bun);
    }

    @Test
    public void checkAddIngredient() {
        String message = "Для метода addIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        int expectedSizeListIngredients = burger.ingredients.size() + 1;
        burger.addIngredient(ingredient1);
        int actualSizeListIngredients = burger.ingredients.size();
        assertEquals(message, expectedSizeListIngredients, actualSizeListIngredients);
        assertEquals(message, burger.ingredients.get(burger.ingredients.size() - 1), ingredient1);
    }

    @Test
    public void checkRemoveIngredient() {
        int countChosenIngredient = 0;
        String message = "Для метода removeIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        for (Ingredient ingredient : burger.ingredients) {
            if (ingredient.equals(ingredient1)) {
                countChosenIngredient += 1;
            }
        }
        burger.removeIngredient(1);
        for (Ingredient ingredient : burger.ingredients) {
            if (ingredient.equals(ingredient1)) {
                countChosenIngredient -= 1;
            }
        }
        assertEquals(message, 1, countChosenIngredient);
    }

    @Test
    public void checkMoveIngredient() {
        String message = "Для метода moveIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        int expectedSizeListIngredients = burger.ingredients.size();
        burger.moveIngredient(0, 2);
        int actualSizeListIngredients = burger.ingredients.size();
        assertEquals(message, expectedSizeListIngredients, actualSizeListIngredients);
        assertEquals(message, burger.ingredients.get(0), ingredient1);
        assertEquals(message, burger.ingredients.get(1), ingredient2);
        assertEquals(message, burger.ingredients.get(2), ingredient0);
    }

    @Test
    public void checkGetPrice() {
        float expectedPrice = 2533.23F;
        String message = "Для метода getPrice() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float actualPrice = burger.getPrice();
        assertEquals(message, expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void checkGetReceipt() {
        String message = "Для метода getReceipt() класса Burger получено некорректное значение";
        Burger burger = Mockito.spy(Burger.class);
        burger.setBuns(bun);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float priceBurger = bun.getPrice() * 2 + ingredient0.getPrice() + ingredient1.getPrice() + ingredient2.getPrice();
        Mockito.when(burger.getPrice()).thenReturn(priceBurger);
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== red bun ====)%n"));
        expectedReceipt.append("= sauce hot sauce =\n");
        expectedReceipt.append("= filling cutlet =\n");
        expectedReceipt.append("= sauce chili sauce =\n");
        expectedReceipt.append("(==== red bun ====)\n");
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String actualReceipt = burger.getReceipt();
        assertEquals(message, expectedReceipt.toString(), actualReceipt);
    }
}
