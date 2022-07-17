
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vat vat=new Vat();
		BTT btt=new BTT();
		SSF ssf=new SSF();
		NBT nbt=new NBT();
		Tax tax=new Tax();
		
		tax.setHandler(vat);
		vat.setHandler(nbt);
		nbt.setHandler(btt);
		btt.setHandler(ssf);
		
		Invoice invoice=new Invoice(1,50);
		System.out.println(tax.applyTax(invoice));
		
		Invoice invoice2=new Invoice(2,150);
		System.out.println(tax.applyTax(invoice2));
		
		Invoice invoice3=new Invoice(3,250);
		System.out.println(tax.applyTax(invoice3));
		
		Invoice invoice4=new Invoice(4,350);
		System.out.println(tax.applyTax(invoice4));
		
		Invoice invoice5=new Invoice(1,450);
		System.out.println(tax.applyTax(invoice5));
		
		Invoice invoice6=new Invoice(1,550);
		System.out.println(tax.applyTax(invoice6));
		
		
		

	}

}
