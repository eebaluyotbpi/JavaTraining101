package m1.actvity.two;
import java.util.Scanner;


public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to BPI Java Training!\n");
		
		System.out.println("Enter your age : ");
		int age = sc.nextInt();
		
		double x = age; //convert automatically to int
		double y = 11.75; //double
		int z = (int) y; //convert manually to int
		
		System.out.println("Your age as int is: " + age);
		System.out.println("Your age as double is: " + x);
		System.out.println("Your age as double converted to int is: " + z);
	}

}
