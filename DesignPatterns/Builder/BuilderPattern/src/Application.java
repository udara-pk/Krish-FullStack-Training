
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Without Pattern");
		CarTelescopic1 carT1=new CarTelescopic1("full");
		System.out.println(carT1);
		
		System.out.println("With Pattern");
		
		Car.Builder builder=new Car.Builder("full");
		Car car=builder.dropOffLocation("Matara").roadAssistance("Manual").build();
		System.out.println(car);

	}

}
