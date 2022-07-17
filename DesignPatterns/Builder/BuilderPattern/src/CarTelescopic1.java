
public class CarTelescopic1 {

	String insuarance;
	Boolean etc;
	String roadAssistance;
	String dropOffLocation;
	
	public CarTelescopic1(String insuarance) {
		this.insuarance=insuarance;
	}
	
	public CarTelescopic1(String insuarance,Boolean etc) {
		this(insuarance);
		this.etc=etc;
	}
	
	public CarTelescopic1(String insuarance,Boolean etc,String roadAssistance) {
		this(insuarance,etc);
		this.roadAssistance=roadAssistance;
	}
	
	public CarTelescopic1(String insuarance,Boolean etc,String roadAssistance,String dropOffLocation) {
		this(insuarance,etc,roadAssistance);
		this.dropOffLocation=dropOffLocation;
	}
	
	@Override
	public String toString() {
		return "Car{"+
				"insuarance='" + insuarance + '\'' +
                ", etc='" + etc + '\'' +
                ", roadAssistance='" + roadAssistance + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                '}';
	}
	
	
	
	
}
