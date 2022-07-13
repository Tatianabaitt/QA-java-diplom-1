package praktikum;

import java.util.Objects;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */
public class Ingredient {

    public IngredientType type;
    public String name;
    public float price;

    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public IngredientType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Float.compare(that.getPrice(), getPrice()) == 0 && getType() == that.getType() && Objects.equals(getName(), that.getName());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}