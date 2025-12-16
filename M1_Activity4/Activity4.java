package m1.actvity.four;
import java.util.Scanner;
public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input age: ");
		int age = sc.nextInt();
		
		if (age < 18) {
			System.out.println("Minor");
		}else if (age >= 18 && age <= 60) {
			System.out.println("Adult");
		} else {
			System.out.println("Senior");
		}
		sc.close();
	}

}
