package m3.activity.one;


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Activity1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		LinkedList<String>  inventory = new LinkedList<>();
		
		
		System.out.println("All Products\n");
		
		//Add the ITEMS
		inventory.add("Mouse");
		inventory.add("Keyboard");
		inventory.add("Monitor");
		inventory.add("Printer");
		inventory.add("Laptop");
		
		// Display Properly
		int index =1 ;
		for (String item : inventory) { //Item is equivalent to the items in inventory
		    System.out.println(index + "- " + item); // Print the items based on how many it is
		    index++;
		}
		
		System.out.println("Search");
		String search = input.next();
		
		
		if(inventory.contains(search)) {
			System.out.println("Found the " + search );
		}else {
			System.out.println("Not found");
			
		}
		
		
		//After removing
		System.out.println("After adding and Removing");
		inventory.remove("Mouse");
		inventory.add("Webcam");
		
		System.out.println("Search :");
		
		String search1 = input.next();
		
		if(inventory.contains(search)) {
			System.out.println("Found the " + search );
		}else {
			System.out.println("Not found");
		}
		int i =  1;
		for (String item : inventory) { //Item is equivalent to the items in inventory
		    System.out.println(i + "- " + item); // Print the items based on how many it is
		    i++;
		}
		
		
		
//		List<String> inventory = new ArrayList<>();
//		
//		inventory.add("Mouse");
//		inventory.add("Keyboard");
//		inventory.add("Monitor");
//		inventory.add("Printer");
//		inventory.add("Laptop");
		



	}

}
