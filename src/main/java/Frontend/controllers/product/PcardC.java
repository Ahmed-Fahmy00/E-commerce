package Frontend.controllers.product;

public class PcardC {
    private String name;
    private double price;
    private double rate;
    private String info;
    private String image;
    private int id;

    public PcardC() {
    }
    public PcardC(int id, String name, double price, double rate, String info, String image) {
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.info = info;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getRate() {
        return rate;
    }
    public String getInfo() {
        return info;
    }
    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
