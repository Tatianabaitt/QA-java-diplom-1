import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.*;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class BurgerTest {

    @Test
    public void checkSetBuns() {
        String message = "Для метода setBuns() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Bun bun_test = new Bun("black bun", 100);
        burger.setBuns(bun_test);
        assertEquals(message, burger.bun, bun_test);
    }

    @Test
    public void checkAddIngredient() {
        String message = "Для метода addIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Ingredient expectedIngredient = new Ingredient(SAUCE, "hot sauce", 100);
        int expectedSizeListIngredients = burger.ingredients.size() + 1;
        burger.addIngredient(expectedIngredient);
        int actualSizeListIngredients = burger.ingredients.size();
        assertEquals(message, expectedSizeListIngredients, actualSizeListIngredients);
        assertEquals(message, burger.ingredients.get(burger.ingredients.size() - 1), expectedIngredient);
    }

    @Test
    public void checkRemoveIngredient() {
        int countChosenIngredient = 0;
        String message = "Для метода removeIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(SAUCE, "hot sauce", 200);
        Ingredient ingredient_remove = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient ingredient3 = new Ingredient(SAUCE, "sour cream", 100);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient_remove);
        burger.ingredients.add(ingredient3);
        int expectedSizeListIngredients = burger.ingredients.size() - 1;
        for (Ingredient ingredient : burger.ingredients) {
            if (ingredient.equals(ingredient_remove)) {
                countChosenIngredient += 1;
            }
        }
        burger.removeIngredient(1);
        int actualSizeListIngredients = burger.ingredients.size();
        assertEquals(message, expectedSizeListIngredients, actualSizeListIngredients);
        for (Ingredient ingredient : burger.ingredients) {
            if (ingredient.equals(ingredient_remove)) {
                countChosenIngredient -= 1;
            }
        }
        System.out.println(countChosenIngredient);
        assertEquals(message, 1, countChosenIngredient);
    }

    @Test
    public void checkMoveIngredient() {
        String message = "Для метода moveIngredient() класса Burger получено некорректное значение";
        Burger burger = new Burger();
        Ingredient ingredient0 = new Ingredient(SAUCE, "hot sauce", 200);
        Ingredient ingredient1 = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient ingredient2 = new Ingredient(SAUCE, "sour cream", 100);
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
        Ingredient ingredient_1 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient_1.getPrice()).thenReturn(100F);
        Ingredient ingredient_2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient_2.getPrice()).thenReturn(300.1F);
        Ingredient ingredient_3 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient_3.getPrice()).thenReturn(999.13F);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(567.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.addIngredient(ingredient_3);
        float actualPrice = burger.getPrice();
        assertEquals(message, expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void checkGetReceipt() {
        String message = "Для метода getReceipt() класса Burger получено некорректное значение";
        Burger burger = Mockito.spy(Burger.class);
        Ingredient ingredient_1 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient_1.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient_1.getType()).thenReturn(SAUCE);
        Ingredient ingredient_2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient_2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient_2.getType()).thenReturn(FILLING);
        Ingredient ingredient_3 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient_3.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient_3.getType()).thenReturn(SAUCE);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(567.0F);
        Mockito.when(bun.getName()).thenReturn("red bun");
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.addIngredient(ingredient_3);
        Mockito.when(burger.getPrice()).thenReturn(2533.23F);
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
