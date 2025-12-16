package m1.actvity.three;
import java.util.Scanner;


public class Activity3 {
	
	public static int computeDiff(int firstNum, int SecondNum) {
		return firstNum - SecondNum;
	}
	
	public static int computeProduct(int firstNum, int SecondNum) {
		return firstNum * SecondNum;
	}
	
	public static int computeSum(int firstNum, int SecondNum) {
		return firstNum + SecondNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter First Number : ");
		int firstNum = input.nextInt();
		
		System.out.println("Enter Second Number : ");
		int secondNum = input.nextInt();
		
		computeDiff(firstNum,secondNum);
		System.out.println(computeDiff(firstNum,secondNum));
		
		computeProduct(firstNum,secondNum);
		System.out.println(computeProduct(firstNum,secondNum));
		
		computeSum(firstNum,secondNum);
		System.out.println(computeSum(firstNum,secondNum));
		
		
		

	}

}
