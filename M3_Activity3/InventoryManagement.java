package m3.activity.three;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class InventoryManagement {
	
//	private HashMap<String, Integer> productMap = new HashMap<>();
	private HashMap<String, Integer> productMap;
	// Constructor
	public InventoryManagement() {
		productMap = new HashMap<>();
		
	}
	
	//Add product method
	public void addProduct(String name, Integer price) {
		productMap.put(name,price);
		System.out.println("Added the product " + name + "Price is : " + price);
	}
	
	
	public void searchProduct(String name) {
		if(productMap.containsKey(name)) {
			System.out.println("The product has been found  >> " + name +" Price is >> " + productMap.get(name));
		} else {
			System.out.println("Not found : " + name);
		}
	}
	
	//Display Product
	
	public void displayProduct() {
		if(productMap.isEmpty()) {
			System.out.println("Product is empty");
		} else {
			 for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
	                System.out.println(entry.getKey() + " - " + entry.getValue());
	            }
		}
			
	}//END OF DISPLAY PRODUCT 
	
	
	//find cheapest method
	public void findCheapest() {
		if(productMap.isEmpty()) {
			System.out.println("No products availalble.");
			return;
		}else {
			
			String cheapestProduct = null;
			 int cheapestPrice = Integer.MAX_VALUE; //Max price
	
		        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
		            if (entry.getValue() < cheapestPrice) { //Check if the value is less than to cheapest price
		                cheapestPrice = entry.getValue();
		                cheapestProduct = entry.getKey();
		            }
		        }
		        System.out.println("Cheapest product: " + cheapestProduct + " with price " + cheapestPrice);
		}
	}//end of find cheapest method
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Object
		InventoryManagement manager = new InventoryManagement();
		Scanner input = new Scanner(System.in);
		

		boolean isRunning = true;
		while (isRunning) {
			System.out.println("=== Inventory Management System ===\n"
					+ "Please select an option below\n" 
					+ "1. Search Product\n"
					+ "2. Add Product\n"
					+ "3. Print products\n"
					+ "4. Find the cheapest product \n"
					+ "5. Exit");
			System.out.println("Enter your choice: ");
			int choice = input.nextInt();
			input.nextLine();
		
			
		//SWITCH CASE//
		switch(choice) {
		case 1:
			System.out.println("Enter product to search :");
			String searchItem = input.nextLine();
			manager.searchProduct(searchItem);
			break;
		case 2:
			System.out.println("Add product");
			System.out.println(">>");
			String addProduct = input.nextLine();
			System.out.println("Price of the product");
			System.out.println(">>");
			int addPrice = input.nextInt();
			manager.addProduct(addProduct, addPrice);
			System.out.println("Added successfully :" + addProduct +  ":" +  addPrice);
			break;
		case 3:
			System.out.println("=== Print All Products ===");
			manager.displayProduct();
			System.out.println("===== End =====");
			
			break;
		case 4:
			System.out.println("=== Find Cheapest Products ===\n");
			
			manager.findCheapest();
			break;
		case 5:
			System.out.println("=== Exiting ===\n");
			isRunning = false;
			break;
		default:
			System.out.println("Invalid choice, please try again.");
		}
	}// END OF WHILE
	input.close();		
	}

}
 