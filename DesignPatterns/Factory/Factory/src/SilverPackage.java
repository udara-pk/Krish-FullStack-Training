
public class SilverPackage extends Package{

	@Override
	protected void createPackage() {
		decoration.add(new BridalDeco());
		decoration.add(new BridesMaidDeco());
	}
}
