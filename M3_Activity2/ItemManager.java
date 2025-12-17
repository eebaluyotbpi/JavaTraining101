package m3.activity.two;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


public class ItemManager {
	
	//Declaration & Initialize
	
	private HashSet<String> items; //HashSet Declaration
	
	public ItemManager() {
		items = new HashSet<>();
		items.add("Mouse");
		items.add("Monitor");
		items.add("Keyboard");
		items.add("Speaker");
		items.add("Printer");
	}
	
	// Add Item
	public void addItem(String item) {
		if (items.add(item)) {
			System.out.println(item + " was added successfully.");
		}else {
			 System.out.println(item + " already exists in the set.");
		}
	} //End of Add Item
	
	
	public void searchItem(String item) {
		if(items.contains(item)) {
			System.out.println(item + " was found.");
		} else {
			System.out.println(item + " was not found.");
		}
	}
	
	public void displayItem() {
		
		if (items.isEmpty()) {
			System.out.println("No Item found");
		} else {
			
			System.out.println("Total unique item is : " + items.size());
			
			for(String item : items) {
				System.out.println(item);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemManager manager = new ItemManager();
		Scanner input = new Scanner(System.in);
		
		int choice;
		 do {
	            System.out.println("\n--- Item Manager Menu ---");
	            System.out.println("1. Add Item");
	            System.out.println("2. Search Item");
	            System.out.println("3. Display All Items");
	            System.out.println("4. Exit");
	            System.out.print(">>");
	            choice = input.nextInt();
	            input.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter item to add: ");
	                    String addItem = input.nextLine();
	                    manager.addItem(addItem);
	                    break;
	                case 2:
	                    System.out.print("Enter item to search: ");
	                    String searchItem = input.nextLine();
	                    manager.searchItem(searchItem);
	                    break;
	                case 3:
	                    manager.displayItem();
	                    break;
	                case 4:
	                    System.out.println("Exiting program...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 4);

	        input.close();

	}

}
