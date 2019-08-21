package main.java.com.cart;

public enum ItemDetails {
    SOUP(0.65),
    BREAD(0.80),
    MILK(1.30),
    APPLE(0.10);

    private final Double price;

    ItemDetails(Double price) {
	this.price = price;
    }

    public Double getPrice() {
	return price;
    }

}
