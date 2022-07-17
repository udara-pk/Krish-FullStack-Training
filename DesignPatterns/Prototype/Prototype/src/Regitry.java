import java.util.HashMap;
import java.util.Map;

public class Regitry {
	
	private Map<VehicleType, Vehicle> vehicles=new HashMap<>();
	
	public Regitry() {
		this.initialize();
	}

	public Vehicle getVehicle(VehicleType vehicleType) {
		Vehicle vehicle=null;
		try {
			 vehicle=(Vehicle) vehicles.get(vehicleType).clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return vehicle;
	}
	private void initialize() {
		// TODO Auto-generated method stub
		Car car=new Car();
		car.setEngineCapacity(2000);
		car.setType("Hybrid");
		car.setFuelType("Octane95");
		
		Bus bus=new Bus();
		bus.setNoOfSheets(50);
		bus.setEngineCapacity(3000);
		bus.setFuelType("Diesel");
		
		vehicles.put(VehicleType.CAR, car);
		vehicles.put(VehicleType.BUS, car);
		
	}

}
