package m4.activity.five;

public class Main {

	public static void main(String[] args) throws InvalidAccountNumberException, InvalidAccountFormatException {
		// TODO Auto-generated method stub
		AccountValidator av = new AccountValidator();
		
		
		av.testValidation("Test 1 - Valid 10 Digits", "1234567890");
		av.testValidation("Test 2 - too short", "123");
		av.testValidation("Test 3 - invalid format", "12345ABC90");
		av.testValidation("Test 4 - With Space", "1234 5678790");
		av.testValidation("Test 5 - null", null);
		
		
		
		
	}

}
