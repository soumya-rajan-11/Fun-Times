package shoppingcart.src.main.java.com.cart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class ShoppingCart extends DiscountValid {

    private static final Integer MINIMUM_COUNT = 2;

    private static final double DISCOUNT_VALUE_ONE = 0.9;

    private static final double DISCOUNT_VALUE_TWO = 0.5;

    private Map<ItemDetails, Integer> cartItemsMap = new HashMap<>();
    
    public void addItem(ItemDetails itemDetails, Integer quantity) {
    	if (cartItemsMap.containsKey(itemDetails)) {
    		cartItemsMap.put(itemDetails, cartItemsMap.get(itemDetails) + quantity);
    	} else {
    		cartItemsMap.put(itemDetails, quantity);
    	}
    }

    public BigDecimal calculateCartValue(LocalDate localDate) {
    	AtomicInteger discountItemNumber = new AtomicInteger();
    	if (checkDiscountValid()) {
    		int discountBreadLoafs = cartItemsMap.get(ItemDetails.SOUP) / MINIMUM_COUNT;
    		discountItemNumber.set(discountBreadLoafs);
    	}
    	List<BigDecimal> finalPriceList = new ArrayList<>();
    	cartItemsMap.entrySet().forEach(entry -> {
    		if (isDiscountValid(entry.getKey(), localDate)) {
    				if (entry.getKey().equals(ItemDetails.APPLE)) {
    						finalPriceList.add(entry.getKey().getPrice()
    								.multiply(BigDecimal.valueOf(
    										DISCOUNT_VALUE_ONE))
    								.multiply(BigDecimal
    										.valueOf(entry.getValue())));
    				} else if (entry.getKey().equals(ItemDetails.BREAD)) {
    						finalPriceList.add(entry.getKey().getPrice()
    								.multiply(BigDecimal.valueOf(
    										DISCOUNT_VALUE_TWO))
    								.multiply(BigDecimal.valueOf(
    										discountItemNumber
    										.get())));
    						finalPriceList.add(entry.getKey().getPrice()
    								.multiply(BigDecimal.valueOf(entry
    										.getValue()
    										- discountItemNumber
    										.get())));
    				}
    			} else {
    				finalPriceList.add(entry.getKey().getPrice().multiply(
    						BigDecimal.valueOf(entry.getValue())));
	    }
	});
	return finalPriceList.stream().reduce(BigDecimal.ZERO,
		BigDecimal::add);
    
    }

    private boolean checkDiscountValid() {
    	return cartItemsMap.containsKey(ItemDetails.SOUP)
		&& cartItemsMap.get(ItemDetails.SOUP) >= MINIMUM_COUNT;
		}


}
