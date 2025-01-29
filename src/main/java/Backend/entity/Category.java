package Backend.entity;

public class Category {
    private static int IdCounter = 1;
    private int Id;
    private String name;

    public Category(String name) {
        this.Id = IdCounter;
        this.name = name;
    }

    public int getId() {
        return Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
