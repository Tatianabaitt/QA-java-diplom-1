import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {

    private final Bun bun1;
    private final Bun bun2;
    private final boolean expected;

    public BunParametrizedTest(Bun bun1, Bun bun2, boolean expected) {
        this.bun1 = bun1;
        this.bun2 = bun2;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}") // добавили аннотацию
    public static Object[][] getBuns() {
        Bun bun;
        return new Object[][]{
                {new Bun("black bun", 100), new Bun("black bun", 100), true},
                {new Bun("black bun", 100), new Bun("white bun", 100), false},
                {new Bun("black bun", 100), new Bun("black bun", 300), false},
                {new Bun("black bun", 100), null, false},
                {bun = new Bun("black bun", 100), bun, true},
        };
    }

    @Test
    public void checkEqualsBuns() {
        String message = "Для метода equals() класса Bug получено некорректное значение";
        assertEquals(message, bun1.equals(bun2), expected);
    }
}