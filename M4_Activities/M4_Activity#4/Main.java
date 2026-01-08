package m4.activity.four;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountValidator av = new AccountValidator();
				
				
		try {
			av.validateAccountNumber("1234567890");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("VALID ACCOUNT");
		}
		
		try {
			av.validateAccountNumber("123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR : Must be a 10-digits");
		
		}
		
		try {
			av.validateAccountNumber(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR : annot be null");
		
		}
		

		
	}

}
