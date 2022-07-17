
public abstract class Handler {

	protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract double applyTax(Invoice invoice);
}
