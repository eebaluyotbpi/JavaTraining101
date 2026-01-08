package m4.activity.four;

public class AccountValidator {
	private String accountNumber;

	public AccountValidator(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
	
	
	public AccountValidator() {
		// TODO Auto-generated constructor stub
	}



	public void validateAccountNumber(String accountNumber) throws Exception {
		
		if(accountNumber.equals(null)) {
			throw new NullPointerException("Cannot be null");
		}
		
		if(accountNumber.length() != 10) {
			throw new Exception("ERROR : Length must be 10!");
		} 
		
		System.out.println("VALID ACCOUNT :" + accountNumber);
		
	}

}
