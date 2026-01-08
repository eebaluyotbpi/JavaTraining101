package m4.activity.five;

public class InvalidAccountFormatException extends Exception {
	private String accountNumber;
	public InvalidAccountFormatException( String accountNumber) {
		super("ERROR : Account number must be digits only");
		
		this.accountNumber = accountNumber;
		
		
	}
	
	

}
