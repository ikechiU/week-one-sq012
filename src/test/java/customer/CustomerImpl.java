package customer;

public class CustomerImpl implements CustomerInterface {

    private String productName;
    private int productYear = 0;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    @Override
    public void buy(String productName) {
        this.productName = confirmProductName(productName);
        System.out.println("Hello cashier, I will like to buy " + this.productName + ".");
    }

    @Override
    public void buy(String productName, int year) {
        setProductName(confirmProductName(productName));
        setProductYear(year);
        System.out.println("Hello cashier, I will like to buy " + this.productName + ". That was manufactured in " + this.productYear +".");

    }

    @Override
    public String confirmProductName(String productName) {
       return String.valueOf(productName.charAt(0)).toUpperCase() + productName.substring(1).toLowerCase();
    }
}
