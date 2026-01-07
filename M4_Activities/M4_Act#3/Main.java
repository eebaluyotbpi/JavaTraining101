package m4.activity.three;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATMTransaction atmApp = new ATMTransaction();
		
		atmApp.checkBalance("100123456", 15000.00);
		atmApp.checkBalance("200987654", 25000.00);
		atmApp.checkBalance("ABC12345", 15000.00);
		atmApp.checkBalance("", 15000.00);
	}

}
