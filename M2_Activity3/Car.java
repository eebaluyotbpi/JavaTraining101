package m2.actvity.three;

public class Car {
	
	private String carName;
	private String carModel;
	private int carYear;
	
	public Car() {
		
	}
	
	public void getCarName() {
		return;
	}
	
//	public String setCarName(String carName) {
//		return this.carName = carName;
//	}
	
	//Set carName
	public void setCarName(String carName) {
		this.carName=carName;
	}
	
	public void getCarModel(String carModel) {
		return;
	}
	
	public void setCarModel(String carModel ) {
		this.carModel = carModel;
	}
	
	public void getCarYear() {
		return;
	}
	
	public int setCarYear(int carYear) {
		return this.carYear = carYear;
	}
	
	public void DisplayCar() {
		
		System.out.println("The Car Name is " + carName);
		System.out.println("The Car Model is " + carModel);
		System.out.println("The Car Year is " + carYear);
	}
}
