package praktikum;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bun bun = (Bun) o;
        return Float.compare(bun.getPrice(), getPrice()) == 0 && getName().equals(bun.getName());
    }

    @Override
    public String toString() {
        return "Bun{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}