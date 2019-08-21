package main.test.com.cart;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Objects;

import org.junit.Test;

import main.java.com.cart.ItemDetails;
import main.java.com.cart.ShoppingCart;

public class TestShoppingCart {

    private static final float TEST_ONE_VALUE = (float) 3.15;
    private static final float TEST_TWO_VALUE = (float) 1.90;
    private static final float TEST_THREE_VALUE = (float) 1.84;
    private static final float TEST_FOUR_VALUE = (float) 1.97;

    @Test
    public void performFirstTestcase() {
	ShoppingCart cart = new ShoppingCart();
	cart.addItem(ItemDetails.SOUP, 3);
	cart.addItem(ItemDetails.BREAD, 2);
	Double totalAmount = cart
		.calculateCartValue(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.floatValue(),
		TEST_ONE_VALUE));
    }

    @Test
    public void performSecondTestcase() {
	ShoppingCart cart = new ShoppingCart();
	cart.addItem(ItemDetails.APPLE, 6);
	cart.addItem(ItemDetails.MILK, 1);
	Double totalAmount = cart
		.calculateCartValue(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.floatValue(),
		TEST_TWO_VALUE));
    }

    @Test
    public void performThirdTestcase() {
	ShoppingCart cart = new ShoppingCart();
	cart.addItem(ItemDetails.APPLE, 6);
	cart.addItem(ItemDetails.MILK, 1);
	Double totalAmount = cart
		.calculateCartValue(LocalDate.now().plusDays(5));
	assertTrue(Objects.equals(totalAmount.floatValue(),
		TEST_THREE_VALUE));
    }

    @Test
    public void performFourthTestcase() {
	ShoppingCart cart = new ShoppingCart();
	cart.addItem(ItemDetails.APPLE, 3);
	cart.addItem(ItemDetails.SOUP, 2);
	cart.addItem(ItemDetails.BREAD, 1);
	Double totalAmount = cart
		.calculateCartValue(LocalDate.now().plusDays(5));
	assertTrue(Objects.equals(totalAmount.floatValue(),
		TEST_FOUR_VALUE));
    }
}
