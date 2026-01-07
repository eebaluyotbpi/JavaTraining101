package m4.activity.three;

import java.time.LocalDate;

public class ATMTransaction {
	private String accountNumber;
	private double balance;
	private LocalDate tranDate = LocalDate.now();
	

	public ATMTransaction(String accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public ATMTransaction() {
		// TODO Auto-generated constructor stub
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	
	public void checkBalance(String accountNumber, double balance) {
		try {
			System.out.println("Processing balance inquiry...");
			// Convert to Int
			
			Integer.parseInt(accountNumber);
			
			
			//Get the first Char
			char accountType = accountNumber.charAt(0);
			
			//Logic
			
			if(accountType == '1') {
				System.out.println("Account Type : Savings");
			} else if (accountType == '2') {
				System.out.println("Account Type : Checking");
			} else {
				System.out.println("Account Type : Unkown");
				return;
			}
			
			// Display Account
			
			System.out.println("Account Number : " + accountNumber);
			System.out.println("Current Balance : " + balance);
			System.out.println("Balance Inquiry is successful!");
		
		} catch(NumberFormatException e) {
			System.out.println("Error: Invalid Account Format!");
			
		} catch(StringIndexOutOfBoundsException e) {
			System.out.println("Error: Account number is empty or invalid!");
		} finally {
			System.out.println("==== RECEIPT ====");
			System.out.println("Transaction Date :" + tranDate);
			System.out.println("Transaction Type : Balance Inquiry" );
			System.out.println("ATM Location : Main Branch");
			System.out.println("Thank you for banking with us!");
			System.out.println("==================\n");
			
		}
	}
	
	

}
