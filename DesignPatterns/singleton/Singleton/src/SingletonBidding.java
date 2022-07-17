
public class SingletonBidding {

	private static volatile SingletonBidding bidding;
	
	private SingletonBidding() {
		if(bidding != null) {
			throw new RuntimeException("Please use getBidding method");
		}
		
	}

	public static SingletonBidding getBidding() {
		
		if(bidding == null) {
			synchronized (SingletonBidding.class) {
				if(bidding == null) {
					bidding = new SingletonBidding();
					countdown();
				}
			}
		}
		return bidding;
	}
	
	public static void countdown() {
		for(int i = 10; i >= 0; i--) {
			System.out.println("Remaining time for the bidding:" + i);
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==0) {
				System.out.println("Your time is up.. Thank you for bidding");
			}
		}
	}
}
