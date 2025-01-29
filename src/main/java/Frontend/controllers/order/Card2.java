package Frontend.controllers.order;

public class Card2 {
    private String name;
    private String price;
    private String rate;
    private String info;
    private String image;

    public Card2() {
    }
    public Card2(String name, String price, String rate, String info, String image) {
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

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public void setInfo(String date) {
        this.info = date;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
