package m4.activity.five;

public class AccountValidator {
	
	
	
	
	public void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException, InvalidAccountFormatException {
			if (accountNumber == null || accountNumber.trim().isEmpty()) {
				throw new NullPointerException("Account Number cannot be null");
			} 
			
			for (char c : accountNumber.toCharArray()) {
				if(!Character.isDigit(c)) {
					throw new InvalidAccountFormatException("Account number must contains digit only");
				}
			}
			
			if(accountNumber.length() != 10) {
				throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
			}
			
			// Valid
			
			System.out.println("Valid account :" + accountNumber);
			
			
	}
	
	public void testValidation(String testName,String accountNumber) throws InvalidAccountFormatException {
		System.out.println(testName);
		
		try {
			validateAccountNumber(accountNumber);
		}catch(InvalidAccountNumberException e) {
			// Using e.getMessage() you will be able to get the error in the exception class
			System.out.println("\u001B[31mError: "+ e.getMessage() + "\u001B[0m");
		} catch(InvalidAccountFormatException e) {
			System.out.println("\u001B[31mError: "+ e.getMessage() + "\u001B[0m");
			
		} catch(NullPointerException e) {
			System.out.println("\u001B[31mError: "+ e.getMessage() + "\u001B[0m");
		}
	}

}
