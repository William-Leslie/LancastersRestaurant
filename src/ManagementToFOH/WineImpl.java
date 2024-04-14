package ManagementToFOH;

public class WineImpl implements Wine {
    private final int wineID;
    private final String name;
    private final double price;
    private final int age;

    protected WineImpl(int wineID, String name, double price, int age) {
        this.wineID = wineID;
        this.name = name;
        this.price = price;
        this.age = age;
    }

    public int getWineID() {
        return wineID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAge() {
        return age;
    }
}
