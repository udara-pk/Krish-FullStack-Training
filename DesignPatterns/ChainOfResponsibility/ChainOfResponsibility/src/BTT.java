
public class BTT extends Handler{

	public double applyTax(Invoice invoice) {
		invoice.setTax(invoice.getTax()+invoice.getAmount()*0.03);
		System.out.println("BTT calculated!");
		if(invoice.getAmount()>200.0 && invoice.getAmount()<=300.0) {
			return invoice.getTax();
		}
		else {
			return handler.applyTax(invoice);
		}
	}
}
