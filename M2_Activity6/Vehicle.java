package m2.activity.six;

public abstract class Vehicle implements Refuelable {
	
	private int numOfWheels;
	private String brand;
	
	public Vehicle() {
	
	}
	
	
	public Vehicle(int numOfWheels, String brand) {
		this.numOfWheels = numOfWheels;
		this.brand = brand; 
	}
	
	public abstract void startEngine();
	
	
	//Get
	public int getNumOfWheels() {
		return numOfWheels;
	}
	
	//Set
	
	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void destroy() {
		System.out.println(brand + "has" + numOfWheels + " wheels was succesfully destroyed!");
	}

}
