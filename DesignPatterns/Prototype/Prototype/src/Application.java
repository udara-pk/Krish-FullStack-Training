
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Regitry registry=new Regitry();
		Car car=(Car) registry.getVehicle(VehicleType.CAR);
		System.out.println(car);
		
		car.setType("Luxury");
		
		System.out.println(car);
		
		Car car1=(Car) registry.getVehicle(VehicleType.CAR);
		System.out.println(car1);
		
	}

}
