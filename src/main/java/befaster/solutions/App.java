package befaster.solutions;

public class App {
	public static int checkout(String x) {
		Checkout checkout = new Checkout();
		return checkout.getPrice(x);
	}
}
