package shoppingcart.src.main.java.com.cart;

import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {


	    public static void main(String[] args) {
	    	ShoppingCart cart = new ShoppingCart();
			Scanner scan = new Scanner(System.in);
			int quantity ;
			int input;
		do {
			System.out.println("Enter the items to be added to the cart: \n1.Soup\n2.Bread\n3.Milk\n4.Apples\n5.exit");
			input = scan.nextInt();
			switch(input) {
			case 1:
				System.out.println("enter the quantity required:");
				 quantity = scan.nextInt();
				cart.addItem(ItemDetails.SOUP, quantity);
				break;
			case 2:
				System.out.println("enter the quantity required:");
				 quantity = scan.nextInt();
				cart.addItem(ItemDetails.BREAD, quantity);
				break;
			case 3:
				System.out.println("enter the quantity required:");
				 quantity = scan.nextInt();
				cart.addItem(ItemDetails.MILK, quantity);
				break;
			case 4:
				System.out.println("enter the quantity required:");
				 quantity = scan.nextInt();
				cart.addItem(ItemDetails.APPLE, quantity);
				break;
			default:
				break;
					
			}
		}while(input !=5);
		System.out.println("Enter the date: 1. today, 2. 5 days");
		int date = scan.nextInt();
		if(date>1) {
			System.out.printf("Total Rupees : Rs %f",
					cart.calculateCartValue(LocalDate.now().plusDays(5)));
		}else {
			System.out.printf("Total Rupees : Rs %f",
					cart.calculateCartValue(LocalDate.now()));	
		}
	    }

}
