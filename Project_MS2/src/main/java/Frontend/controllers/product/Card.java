package Frontend.controllers.product;

public class Card {
    private String name;
    private String price;
    private String rate;
    private String info;
    private String image;

    public Card(String name, String price, String rate, String info, String image) {
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public String getRate() {
        return rate;
    }
    public String getInfo() {
        return info;
    }
    public String getImage() {
        return image;
    }
}
