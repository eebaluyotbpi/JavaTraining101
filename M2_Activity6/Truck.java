package m2.activity.six;

public class Truck extends Vehicle {
	
	public Truck(int numOfWheels, String brand) {
		super(numOfWheels,brand);
	}
	
	@Override
	
	
	//Start Engine Method
	public void startEngine() {
		System.out.println(getBrand() + " Truck has " + getNumOfWheels() + " wheels has been started!");
	}
	
	@Override
	
	public void refuel() {
		System.out.println("Refueling the " + getBrand() + " Truck");
	}
}
