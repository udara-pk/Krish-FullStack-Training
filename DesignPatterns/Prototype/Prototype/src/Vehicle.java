
public abstract class Vehicle implements Cloneable{

	private String fuelType;
	private int engineCapacity;
	
	
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
