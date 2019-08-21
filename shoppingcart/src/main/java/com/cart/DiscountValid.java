package shoppingcart.src.main.java.com.cart;

import java.time.LocalDate;

public class DiscountValid {
    
	public boolean isDiscountValid(ItemDetails item, LocalDate localDate) {
		if(item.equals(ItemDetails.BREAD)){ 
			return localDate
				    .isAfter(LocalDate.now().minusDays(1))
				    && localDate
					    .isBefore(LocalDate.now()
						    .plusDays(7));
		}
		else if(item.equals(ItemDetails.APPLE)) {
			return localDate
				    .isAfter(LocalDate.now().plusDays(3))
				    && localDate.isBefore(LocalDate.now()
					    .plusDays(LocalDate.now().lengthOfMonth()
						    - LocalDate.now()
							    .getDayOfMonth()));
		}
			
		return false;
	    }
}
