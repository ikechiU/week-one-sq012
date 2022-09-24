package store.product;

public class Product {
    private String name;
    private String manufactureDate;
    private String bestBefore;

    public Product(String name, String manufactureDate, String bestBefore) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.bestBefore = bestBefore;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(String bestBefore) {
        this.bestBefore = bestBefore;
    }
}
