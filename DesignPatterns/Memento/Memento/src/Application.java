
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CareTaker careTaker = new CareTaker();
        Cart cart = new Cart();
        cart.addItem(new Item("cake"));
        cart.addItem(new Item("pen"));
        
        careTaker.save(cart);
        System.out.println(cart);
        
        cart.addItem(new Item("pencil"));
        careTaker.save(cart);
        System.out.println(cart);
        
        cart.addItem(new Item("flower"));
        careTaker.save(cart);
        System.out.println(cart);
        
        cart.addItem(new Item("knife"));
        //careTaker.save(cart);
        System.out.println(cart);
        
        
        careTaker.revert(cart);
        System.out.println(cart);
        
        cart.addItem(new Item("Ipad"));
        //careTaker.save(cart);
        System.out.println(cart);
        
        careTaker.revert(cart);
        System.out.println(cart);
        
        careTaker.revert(cart);
        System.out.println(cart);
        careTaker.revert(cart);
        System.out.println(cart);
        careTaker.revert(cart);
        System.out.println(cart);
        
        
        
	}

}
