package m2.actvity.three;


public class Students {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car carObj = new Car();
		Car carObj2 = new Car();
		carObj.setCarName("Accord");
		carObj.setCarModel("Honda");
		carObj.setCarYear(2009);
		
		carObj.DisplayCar();
		
		
		carObj2.setCarName("Ativ");
		carObj2.setCarModel("Toyota");
		carObj2.setCarYear(2025);
		
		carObj2.DisplayCar();
		
		

	}
}
