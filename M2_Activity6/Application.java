package m2.activity.six;

public class Application {

	//Create Interface Refuelable Implementing class should be able to impelement method refuel()
	//Create Abstract Vehicle,. number of wheels and brand
	//Abstract method startengine()
	//conrete method void destroy()
	//Create two concrete class car and truck must imple refuelable and extend vehicle
	//Main app - one car and one truck and call the methods they inherited and implemented
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Object
		Vehicle car = new Car(4,"Toyota");
		Vehicle truck = new Truck(16, "Hyundai");
		
		//Car
		car.startEngine();
		car.refuel();
		
		System.out.println("======================");
		
		//Truck
		truck.startEngine();
		truck.refuel();
		
		System.out.println("======================");
		//Destroy
		car.destroy();
		truck.destroy();	
	}

}
