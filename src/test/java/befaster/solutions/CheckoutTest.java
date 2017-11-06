package befaster.solutions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CheckoutTest {

	private Checkout checkout;
	
	@Before
	public void setup() {
		checkout = new Checkout();
	}
	
	@Test
	public void checkout_null() {
		assertThat(checkout.getPrice(null), equalTo(-1));
	}
	
	@Test
	public void checkout_empty() {
		assertThat(checkout.getPrice(""), equalTo(0));
	}
	
	@Test
	public void checkout_Ax1() {
		assertThat(checkout.getPrice("A"), equalTo(50));
	}

	@Test
	public void checkout_Bx1() {
		assertThat(checkout.getPrice("B"), equalTo(30));
	}
	
	@Test
	public void checkout_Cx1() {
		assertThat(checkout.getPrice("C"), equalTo(20));
	}
	
	@Test
	public void checkout_Dx1() {
		assertThat(checkout.getPrice("D"), equalTo(15));
	}
	
	@Test
	public void checkout_Ex1() {
		assertThat(checkout.getPrice("E"), equalTo(40));
	}
	
	@Test
	public void checkout_Fx1() {
		assertThat(checkout.getPrice("F"), equalTo(10));
	}
	
	@Test
	public void checkout_Gx1() {
		assertThat(checkout.getPrice("G"), equalTo(-1));
	}
	
	@Test
	public void checkout_Ax3() {
		assertThat(checkout.getPrice("AAA"), equalTo(130));
	}
	
	@Test
	public void checkout_Ax4() {
		assertThat(checkout.getPrice("AAAA"), equalTo(180));
	}
	
	@Test
	public void checkout_Ax5() {
		assertThat(checkout.getPrice("AAAAA"), equalTo(200));
	}
	
	@Test
	public void checkout_Ax6() {
		assertThat(checkout.getPrice("AAAAAA"), equalTo(250));
	}
	
	@Test
	public void checkout_Ax8() {
		assertThat(checkout.getPrice("AAAAAAAA"), equalTo(330));
	}
	
	@Test
	public void checkout_Ax9() {
		assertThat(checkout.getPrice("AAAAAAAAA"), equalTo(380));
	}
	
	@Test
	public void checkout_Bx2() {
		assertThat(checkout.getPrice("BB"), equalTo(45));
	}
	
	@Test
	public void checkout_Bx3() {
		assertThat(checkout.getPrice("BBB"), equalTo(75));
	}
	
	@Test
	public void checkout_Bx4() {
		assertThat(checkout.getPrice("BBBB"), equalTo(90));
	}
	
	@Test
	public void checkout_Cx2() {
		assertThat(checkout.getPrice("CC"), equalTo(40));
	}
	
	@Test
	public void checkout_Cx3() {
		assertThat(checkout.getPrice("CCC"), equalTo(60));
	}
	
	@Test
	public void checkout_Dx2() {
		assertThat(checkout.getPrice("DD"), equalTo(30));
	}
	
	@Test
	public void checkout_Dx3() {
		assertThat(checkout.getPrice("DDD"), equalTo(45));
	}
	
	@Test
	public void checkout_Ex2() {
		assertThat(checkout.getPrice("EE"), equalTo(80));
	}
	
	@Test
	public void checkout_Fx2() {
		assertThat(checkout.getPrice("FF"), equalTo(20));
	}
	
	@Test
	public void checkout_Fx3() {
		assertThat(checkout.getPrice("FFF"), equalTo(20));
	}
	
	@Test
	public void checkout_Fx4() {
		assertThat(checkout.getPrice("FFFF"), equalTo(30));
	}
	
	@Test
	public void checkout_Fx6() {
		assertThat(checkout.getPrice("FFFFFF"), equalTo(40));
	}
	
	@Test
	public void checkout_EEB() {
		assertThat(checkout.getPrice("EEB"), equalTo(80));
	}
	
	@Test
	public void checkout_EBEB() {
		assertThat(checkout.getPrice("EBEB"), equalTo(110));
	}
	
	@Test
	public void checkout_AAAAAEEBAAABB() {
		assertThat(checkout.getPrice("AAAAAEEBAAABB"), equalTo(455));
	}
	
	@Test
	public void checkout_ABABA() {
		assertThat(checkout.getPrice("ABABA"), equalTo(175));
	}
}
