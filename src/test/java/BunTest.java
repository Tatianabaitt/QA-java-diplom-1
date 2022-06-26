import org.junit.Test;
import praktikum.Bun;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameBun() {
        String message = "Для метода getName() класса Bug получено некорректное значение";
        String expectedNameBun = RandomStringUtils.randomAlphabetic(10);
        float priceBun = new Random().nextFloat();
        Bun bun = new Bun(expectedNameBun, priceBun);
        String actualNameBug = bun.getName();
        assertEquals(message, expectedNameBun, actualNameBug);
    }

    @Test
    public void getPriceBun() {
        String message = "Для метода getPrice() класса Bug получено некорректное значение";
        String nameBun = RandomStringUtils.randomAlphabetic(10);
        float expectedPriceBun = new Random().nextFloat();
        Bun bun = new Bun(nameBun, expectedPriceBun);
        float actualPriceBug = bun.getPrice();
        assertEquals(message, expectedPriceBun, actualPriceBug, 0.0f);
    }
}
