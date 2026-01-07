package m4.activity.two;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATMSystem atmSystem = new ATMSystem();
		int index = 1;
		System.out.println("=== ATM Withdrawal System ===");
		System.out.println("=== Test" + index++ + "===");
		atmSystem.processWithdrawal("1","5000");
		System.out.println();
		
		
		
		System.out.println("=== Test " + index++ + "===");
		atmSystem.processWithdrawal("abc","5000");
		System.out.println();
		System.out.println("=== Test " + index++ + "===");
		atmSystem.processWithdrawal("10","5000");
		System.out.println();
		System.out.println("=== Test " + index++ + "===");
		atmSystem.processWithdrawal("1","20000");
			
	}

}
