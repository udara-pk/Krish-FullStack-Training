
public class Car {

	
	private final String insuarance;
	private final Boolean etc;
	private final String roadAssistance;
	private final String dropOffLocation;
	
	public Car(Builder builder) {
		// TODO Auto-generated constructor stub
		this.insuarance=builder.insuarance;
		this.dropOffLocation=builder.dropOffLocation;
		this.etc=builder.etc;
		this.roadAssistance=builder.roadAssistance;
	}

	
	static class Builder{
		private String insuarance;
		private Boolean etc;
		private String roadAssistance;
		private String dropOffLocation;
		
		public Car build() {
			return new Car(this);
		}
		
		public Builder(String insuarance) {
			this.insuarance=insuarance;
		}
		
		public Builder etc(Boolean etc) {
			this.etc=etc;
			return this;
		}
		
		public Builder roadAssistance(String roadAssistance) {
			this.roadAssistance=roadAssistance;
			return this;
		}
		
		public Builder dropOffLocation(String dropOffLocation) {
			this.dropOffLocation=dropOffLocation;
			return this;
		}	
		
	}
	
	@Override
	public String toString() {
		return "Car{"+
				"insuarance='" + insuarance + '\'' +
                ", etc='" + etc  +
                ", roadAssistance='" + roadAssistance + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                '}';
	}
}
