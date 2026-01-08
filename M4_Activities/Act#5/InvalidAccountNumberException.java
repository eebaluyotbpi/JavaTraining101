package m4.activity.five;

public class InvalidAccountNumberException extends RuntimeException {
	
	private String accountNumber;
	
	
	public InvalidAccountNumberException(String accountNumber) {
		super("ERROR : Account number cannot be null!");
		this.accountNumber = accountNumber;
	}
	
	

}
