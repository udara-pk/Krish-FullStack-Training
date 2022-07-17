
public class PackageFactory {

	public static Package createPackage(PackageCode packageCode) {
		switch(packageCode) {
			case BASIC:
				return new BasicPackage();
			case SILVER:
				return new SilverPackage();
			case PLATINUM:
				return new PlatinumPackage();	
			default:
				return null;
		}
	}
}
