
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Package pack=PackageFactory.createPackage(PackageCode.BASIC);
		System.out.println(pack);
		
		Package pack1=PackageFactory.createPackage(PackageCode.PLATINUM);
		System.out.println(pack1);
		
		Package pack2=PackageFactory.createPackage(PackageCode.SILVER);
		System.out.println(pack2);

	}

}
