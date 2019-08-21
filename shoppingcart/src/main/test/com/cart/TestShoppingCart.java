package shoppingcart.src.main.test.com.cart;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.junit.Test;

import src.personal.workspace.funsystem.grocery.Grocery;
import src.personal.workspace.funsystem.item.Item;

public class TestShoppingCart {

    private static final double TEST_ONE_VALUE = 3.15;
    private static final double TEST_TWO_VALUE = 1.90;
    private static final double TEST_THREE_VALUE = 1.84;
    private static final double TEST_FOUR_VALUE = 1.97;

    @Test
    public void problemTestcaseOne() {
	ShoppingCart cart = new ShoppingCart();
	cart.addItem(Item.SOUP, 3);
	cart.addItem(Item.BREAD, 2);
	BigDecimal totalAmount = cart
		.calculateCartValue(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.doubleValue(),
			TEST_ONE_VALUE));
    }

    @Test
    public void problemTestcaseTwo() {
    ShoppingCart cart = new ShoppingCart();
    cart.addItem(Item.APPLE, 6);
    cart.addItem(Item.MILK, 1);
	BigDecimal totalAmount = cart
		.calculateCartValue(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.doubleValue(),
			TEST_TWO_VALUE));
    }

    @Test
    public void problemTestcaseThree() {
    ShoppingCart cart = new ShoppingCart();
    cart.addItem(Item.APPLE, 6);
    cart.addItem(Item.MILK, 1);
	BigDecimal totalAmount = cart
		.calculateCartValue(LocalDate.now().plusDays(5));
	assertTrue(Objects.equals(totalAmount.doubleValue(),
			TEST_THREE_VALUE));
    }

    @Test
    public void problemTestcaseFour() {
    ShoppingCart cart = new ShoppingCart();
    cart.addItem(Item.APPLE, 3);
    cart.addItem(Item.SOUP, 2);
    cart.addItem(Item.BREAD, 1);
	BigDecimal totalAmount = cart
		.calculateCartValue(LocalDate.now().plusDays(5));
	assertTrue(Objects.equals(totalAmount.doubleValue(),
			TEST_FOUR_VALUE));
    }
}
