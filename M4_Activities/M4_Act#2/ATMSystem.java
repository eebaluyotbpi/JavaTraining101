package m4.activity.two;

public class ATMSystem {
	private double[] accounts = {10000,15000,20000};
//	private String accountIndex;
//	private String amountInput;
	
	

	public double[] getAccounts() {
		return accounts;
	}





	public void processWithdrawal(String accountIndex, String amountInput) {
		
		try {
			// Parse Int
		

			int index = Integer.parseInt(accountIndex);
			double balance = accounts[index];
			// Parse amount to Double
			double amount = Double.parseDouble(amountInput);
				
			// Process
			System.out.println("Account :" + index);
			System.out.println("Current Balance :" + balance);
			if(amount > balance) {
				System.out.println("Withdrawal Amount : " + amount);
				
				System.out.println("Insufficient Balance");
			} else {
				System.out.println("Withdrawal Amount : " + amount);
				balance = balance - amount;
				System.out.println("NEW BALANCE :" + balance);
				System.out.println("Withdrawal Successful!");
			}	
					
		} catch (NumberFormatException e){	
			System.out.println("Account =" + accountIndex + "," + "Amount =" + amountInput);
			System.out.println("ERROR : Invalid input!");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Account =" + accountIndex + "," + "Amount =" + amountInput);
			System.out.println("ERROR : Account not found!");	
			
	    } catch(Exception e) {
	    	System.out.println("Account =" + accountIndex + "," + "Amount =" + amountInput);
	    	System.out.println("ERROR : Transaction Failed!");
	    }
	
	} // end of process withdrawal
	

}










