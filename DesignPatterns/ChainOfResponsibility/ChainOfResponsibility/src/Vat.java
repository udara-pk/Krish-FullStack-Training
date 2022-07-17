
public class Vat extends Handler{
	
	public double applyTax(Invoice invoice) {
		invoice.setTax(invoice.getTax()+invoice.getAmount()*0.01);
		System.out.println("VAT calculated!");
		if(invoice.getAmount()<=100) {
			return invoice.getTax();
		}
		else {
			return handler.applyTax(invoice);
		}
	}
}
