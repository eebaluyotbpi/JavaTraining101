package m4.activity.one;

public class BankAccount {
	private String accountNumber;

	
	public BankAccount() {
	
	}
	
	public BankAccount(String accountNumber) {
	
		this.accountNumber = accountNumber;
	}

	public static String getAccountName(String accountNumber) {
	
		if(accountNumber == "ACC-001") {
			System.out.println("Account Holder : Juan Dela Cruz");
		} else if (accountNumber == "ACC-002") {
			System.out.println("Account Holder : Maria Santos");
		} 
		return null;
		
	
	
		
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public static void testCase(String accountNumber) {
	
		System.out.println("Currently Checking :" + accountNumber);
		try {
			String name = getAccountName(accountNumber);
			name.toUpperCase();
			System.out.println(name);
			
		} catch (NullPointerException e) {
			System.out.println("Error : Account not found!");
		}
	}
	
	
	
	
	
}

