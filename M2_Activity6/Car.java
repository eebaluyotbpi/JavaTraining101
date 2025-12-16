package m2.activity.six;

public class Car extends Vehicle {
	
	public Car(int numOfWheels, String brand) {
		super(numOfWheels,brand);
	}
	
	public Car() {
	}
	
	
	@Override 
	
	public void startEngine() {
		System.out.println(getBrand() + " Car with " + getNumOfWheels() + " wheels has started the engine" );
	}
	
	@Override
	public void refuel() {
		System.out.println("Refueling the " + getBrand() + " car");
	}
}
