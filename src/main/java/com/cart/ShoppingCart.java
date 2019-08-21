package main.java.com.cart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ShoppingCart extends DiscountPromotion {

    private static final Integer MINIMUM_COUNT = 2;

    private static final double DISCOUNT_VALUE_ONE = 0.9;

    private static final double DISCOUNT_VALUE_TWO = 0.5;

    private Map<ItemDetails, Integer> cartItemsMap = new HashMap<>();

    public Double calculateCartValue(LocalDate localDate) {
	AtomicInteger discountItemNumber = new AtomicInteger();
	List<Double> finalPriceList = new ArrayList<>();
	if (checkDiscountValid()) {
	    int discountBreadLoafs = cartItemsMap
		    .get(ItemDetails.SOUP) / MINIMUM_COUNT;
	    discountItemNumber.set(discountBreadLoafs);
	}
	cartItemsMap.entrySet().forEach(entry -> {
	    if (checkDiscountValid(entry.getKey(), localDate)) {
		if (entry.getKey().equals(ItemDetails.APPLE)) {
		    finalPriceList.add(entry.getKey().getPrice()
			    * DISCOUNT_VALUE_ONE * entry.getValue());
		} else if (entry.getKey().equals(ItemDetails.BREAD)) {
		    finalPriceList.add(entry.getKey().getPrice()
			    * DISCOUNT_VALUE_TWO * discountItemNumber
				    .get());
		    finalPriceList.add(entry.getKey().getPrice() *
			    (entry.getValue()
				    - discountItemNumber.get()));
		}
	    } else {
		finalPriceList.add(
			entry.getKey().getPrice() * entry.getValue());
	    }
	});
	double totalprice = 0;
	for (int i = 0; i < finalPriceList.size(); i++)
	    totalprice += finalPriceList.get(i);
	return totalprice;
    }

    private boolean checkDiscountValid() {
	return cartItemsMap.containsKey(ItemDetails.SOUP)
		&& cartItemsMap
			.get(ItemDetails.SOUP) >= MINIMUM_COUNT;
    }

    public void addItem(ItemDetails itemDetails, Integer quantity) {
	if (cartItemsMap.containsKey(itemDetails)) {
	    cartItemsMap.put(itemDetails,
		    cartItemsMap.get(itemDetails) + quantity);
	} else {
	    cartItemsMap.put(itemDetails, quantity);
	}
    }

}
