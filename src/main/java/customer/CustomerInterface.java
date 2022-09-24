package customer;

public interface CustomerInterface {
    void buy(String productName); //Abstraction
    void buy(String productName, int year); //Method overloading
    String confirmProductName(String productName);
}
